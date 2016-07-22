package com.reddy.indexer.core;

import com.reddy.indexer.core.datacontracts.Document;

import java.util.List;

/**
 * Created by dreddy on 7/15/2016.
 */
public interface IIndexerService {
    void add(List<Document> document) throws Exception;
    void delete(List<Document> documents) throws Exception;
}
