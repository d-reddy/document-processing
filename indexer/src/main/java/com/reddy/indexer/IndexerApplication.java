package com.reddy.indexer;

import com.google.inject.Guice;
import com.reddy.indexer.resources.IndexerResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.reddy.indexer.core.CoreModule;

/**
 * Created by deven on 7/10/2016.
 */
public class IndexerApplication extends Application<IndexerConfiguration> {

    public static void main(String[] args) throws Exception {
        new IndexerApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<IndexerConfiguration> bootstrap) {
        // nothing to do yet
        InjectorProvider.setInjector(Guice.createInjector(new CoreModule()));
    }

    @Override
    public void run(IndexerConfiguration configuration,
                    Environment environment) {
        // nothing to do yet
        environment.jersey().register(InjectorProvider.getInjector().getInstance(IndexerResource.class));
    }
}
