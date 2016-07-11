package com.reddy.indexer.core.imp;

import com.reddy.indexer.core.IRequestProcessor;

/**
 * Created by deven on 7/10/2016.
 */
public class RequestProcessor implements IRequestProcessor {
    public void index(String sourceDir) {
        //read files from directory

        //for each file, get file type, author, modified date, created date, content, build solr document model

        //build a request to solr to index the document

        //return
    }
}
