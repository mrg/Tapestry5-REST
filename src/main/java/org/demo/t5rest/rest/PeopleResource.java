package org.demo.t5rest.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.demo.t5rest.model.Person;

@Path("/people")
public interface PeopleResource
{
    @GET
    @Produces({ "application/json" })
    public List<Person> getAllPeople();

    @GET
    @Path("{id : \\d+}") //support digit only
    @Produces({ "application/json" })
    public Person getByID(@PathParam("id") int id);

    @GET
    @Path("/lastname/{lastName}")
    @Produces({ "application/json" })
    public List<Person> getByLastName(@PathParam("lastName") String lastName);

    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces({ "application/json" })
    public Response post(MultivaluedMap<String, String> formParams);
}
