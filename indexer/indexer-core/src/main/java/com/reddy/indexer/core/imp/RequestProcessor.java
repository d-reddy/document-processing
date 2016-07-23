package com.reddy.indexer.core.imp;

import com.google.inject.Inject;
import com.reddy.indexer.core.IIndexerService;
import com.reddy.indexer.core.IRequestProcessor;
import com.reddy.indexer.core.datacontracts.Document;
import org.apache.tika.fork.ForkParser;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by deven on 7/10/2016.
 */
public class RequestProcessor implements IRequestProcessor {

    private IIndexerService indexerService;

    @Inject
    public RequestProcessor(IIndexerService indexerService) {

        this.indexerService = indexerService;
    }

    public void index(String sourceDir) {

        List<Document> documents = new ArrayList<Document>();

        //read files from directory
        try {
            Files.walk(Paths.get(sourceDir)).forEach(filePath -> {
                try{
                    InputStream fsInputStream = null;
                    ByteArrayInputStream memInputStream = null;
                    byte[] data = null;

                    if (Files.isRegularFile(filePath)) {
                        System.out.println(filePath);

                        ContentHandler contentHandler = new BodyContentHandler(-1);
                        Metadata contentMetadata = new Metadata();
                        ParseContext parserContext = new ParseContext();
                        File fsFile = filePath.toFile();
                        fsInputStream = new FileInputStream(fsFile.getPath());
                        data = new byte[(int) fsFile.length()];
                        fsInputStream.read(data);
                        memInputStream = new ByteArrayInputStream(data);

                        ForkParser contentParser = new ForkParser();
                        contentParser.parse(memInputStream, contentHandler, contentMetadata, parserContext);

                        //list file metadata
                        //getting the list of all meta data elements
                        String[] metadataNames = contentMetadata.names();

                        for(String name : metadataNames) {
                            System.out.println(name + ": " + contentMetadata.get(name));
                        }

                        Document doc = new Document();
                        doc.addProperty("title",filePath.getFileName());
                        doc.addProperty("content",contentHandler.toString());
                        doc.addProperty("process-date",new Date());
                        doc.addProperty("file-location",filePath);

                        documents.add(doc);

                        if (fsInputStream != null) {
                            fsInputStream.close();
                            fsInputStream = null;
                        }
                        if (memInputStream != null) {
                            memInputStream.close();
                            memInputStream = null;
                        }

                        data = null;

                    }


                }
                catch (Exception e) {
                    //log exception
                    System.out.println(e);
                }

            });

            indexerService.add(documents);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //return
    }
}
