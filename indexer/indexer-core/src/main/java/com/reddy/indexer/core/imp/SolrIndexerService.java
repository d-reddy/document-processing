package com.reddy.indexer.core.imp;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.reddy.indexer.core.IIndexerService;
import com.reddy.indexer.core.datacontracts.Document;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.common.SolrInputDocument;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by dreddy on 7/15/2016.
 */
public class SolrIndexerService implements IIndexerService {
    private CloudSolrClient client;
    private String collection;

    private static final Function<Document, String> projectId =
            new Function<Document, String>() {
                public String apply(Document x) {
                    return x.getId();
                }
            };

    @Inject
    public SolrIndexerService(/*@Named("searchHostUrl")*/ String serverUrl, /*@Named("collection")*/ String collection) {
        this.client = new CloudSolrClient(serverUrl);
        this.collection = collection;
    }

    @Override
    public void add(List<Document> documents) throws Exception{
        try {

            ArrayList<SolrInputDocument> solrDocs = new ArrayList<>();

            for (Document doc : documents) {
                SolrInputDocument solrDoc = new SolrInputDocument();
                solrDoc.addField("id", doc.getId());
                for (Map.Entry<String, Object> field : doc.getMap().entrySet()) {
                    solrDoc.addField(field.getKey(), field.getValue());
                }
                solrDocs.add(solrDoc);

            }

            client.setDefaultCollection(collection);
            client.add(solrDocs);

        } catch (Exception e) {
            //log it
            throw e;
        }
    }

    @Override
    public void delete(List<Document> documents) throws Exception {

        try {

            client.setDefaultCollection(collection);
            client.deleteById(Lists.transform(documents, projectId));

        } catch (Exception e) {
            throw e;
        }
    }
}