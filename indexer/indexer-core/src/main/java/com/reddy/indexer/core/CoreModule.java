package com.reddy.indexer.core;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.Multibinder;
import com.reddy.indexer.core.imp.RequestProcessor;

/**
 * Created by deven on 7/10/2016.
 */
public class CoreModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IRequestProcessor.class).to(RequestProcessor.class);
    }
}
