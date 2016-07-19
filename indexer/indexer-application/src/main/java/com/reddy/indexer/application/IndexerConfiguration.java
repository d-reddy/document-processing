package com.reddy.indexer.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.inject.Singleton;
import io.dropwizard.Configuration;

/**
 * Created by deven on 7/10/2016.
 */
public class IndexerConfiguration extends Configuration {
    private String sourceDir;
    private String targetDir;

    @JsonProperty
    public String getSourceDir() {
        return sourceDir;
    }

    @JsonProperty
    public void setSourceDir(String sourceDir) {
        this.sourceDir = sourceDir;
    }

    @JsonProperty
    public String getTargetDir() {
        return targetDir;
    }

    @JsonProperty
    public void setTargetDir(String targetDir) {
        this.targetDir = targetDir;
    }
}
