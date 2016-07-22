package com.reddy.indexer.core;

import com.google.inject.AbstractModule;
import com.reddy.indexer.core.imp.SolrIndexerService;
import com.reddy.indexer.core.imp.RequestProcessor;

/**
 * Created by deven on 7/10/2016.
 */
public class CoreModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IRequestProcessor.class).to(RequestProcessor.class);
        bind(IIndexerService.class).to(SolrIndexerService.class);

    }
}
