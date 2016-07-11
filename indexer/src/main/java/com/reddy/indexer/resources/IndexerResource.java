package com.reddy.indexer.resources;

import com.google.inject.Inject;
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

    @Inject
    public IndexerResource(IRequestProcessor processor) {
        this.processor = processor;
    }

    @GET
    public String index() {
        return "<h1>It Works!!!</h1> ";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("add")
    public Response add(String sourceDir) {
        this.processor.index(sourceDir);
        return Response.ok().build();
    }

}