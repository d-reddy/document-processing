package com.reddy.indexer.application;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * Created by deven on 7/19/2016.
 */
public class ConfigurationModule extends AbstractModule {
    IndexerConfiguration config;

    public ConfigurationModule(IndexerConfiguration config){
        this.config = config;
    }

    @Override
    protected void configure(){
        bind(IndexerConfiguration.class).toInstance(this.config);
        bind(String.class).annotatedWith(Names.named("sourceDir")).toInstance(this.config.getSourceDir());
    }
}
