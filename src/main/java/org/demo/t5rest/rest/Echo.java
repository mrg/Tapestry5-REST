package org.demo.t5rest.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/echo")
public interface Echo
{
    @GET
    @Path("/{message}")
    @Produces({ "text/plain" })
    Response echo(@PathParam("message") String message);
}
