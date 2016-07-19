package com.reddy.indexer.application.resources;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.reddy.indexer.application.IndexerConfiguration;
import com.reddy.indexer.core.IRequestProcessor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * Created by deven on 7/10/2016.
 */
@Path("/")
public class IndexerResource {

    private IRequestProcessor processor;
    private String sourceDir;

    @Inject
    public IndexerResource(IRequestProcessor processor, @Named("sourceDir") String sourceDir) {
        this.processor = processor;
        this.sourceDir = sourceDir;
    }

    @GET
    public String index() {
        return "<h1>It Works!!!</h1> ";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add")
    public Response add(@QueryParam("userName") String userName) {

        this.processor.index(sourceDir);
        return Response.ok().build();
    }

}