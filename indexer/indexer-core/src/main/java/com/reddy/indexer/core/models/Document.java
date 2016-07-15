package com.reddy.indexer.core.models;

import java.util.List;

/**
 * Created by dreddy on 7/15/2016.
 */
public class Document {
    private String name;
    private String author;
    private String content;
    private List<String> tags;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
