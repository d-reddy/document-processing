package com.reddy.indexer.core.datacontracts;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dreddy on 7/15/2016.
 */
public class Document {
    private String id;
    private Map<String, Object> map = new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @JsonAnyGetter
    public Map<String, Object> getMap() {
        return map;
    }

    @JsonAnySetter
    public void addProperty(String name, Object value) {
        map.put(name, value);
    }

    public Object getDocumentFieldValue(String fieldName)
    {
        return map.get(fieldName);
    }
}
