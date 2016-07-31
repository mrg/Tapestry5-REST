package org.demo.t5rest.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.demo.t5rest.model.Person;
import org.demo.t5rest.services.PeopleService;
import org.slf4j.Logger;

public class PeopleResourceImpl implements PeopleResource
{
    @Inject
    private Logger logger;

    @Inject
    private PeopleService peopleService;

    @Override
    public List<Person> getAllPeople()
    {
//        logger.debug("Returning " + peopleService.getAllPeople().size() + " people.");
        return peopleService.getAllPeople();
    }

    @Override
    public Person getByID(int id)
    {
        logger.info("Filtering by id: " + id);

        for (Person person : getAllPeople())
            if (person.getId() == id)
                return person;

        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @Override
    public List<Person> getByLastName(String lastName)
    {
        logger.info("Filtering by last name: " + lastName);

        List<Person> matchingPeople = new ArrayList<Person>();

        for (Person person : getAllPeople())
            if (person.getLastName().equalsIgnoreCase(lastName))
                matchingPeople.add(person);

        if (matchingPeople.size() == 0)
            throw new WebApplicationException(Response.Status.NOT_FOUND);

        return matchingPeople;
    }

    // See here for lots of ways of handling POST:
    //     http://stackoverflow.com/questions/8194408/how-to-access-parameters-in-a-restful-post-method

    @Override
    public Response post(MultivaluedMap<String, String> formParams)
    {
        logger.debug("posting...");

        for (String key : formParams.keySet())
            logger.debug("    i saw: " + key + " = " + formParams.get(key));

        List<String> ids = formParams.get("id");

        if (ids == null || ids.size() == 0)
            throw new WebApplicationException(Response.Status.NOT_FOUND);

        Person person = getByID(Integer.parseInt(ids.get(0)));

        for (String key : formParams.keySet())
        {
            // Only handle firstName and lastName for now...
            if (key.equals("firstName"))
                person.setFirstName(formParams.get(key).get(0));
            else if (key.equals("lastName"))
                person.setLastName(formParams.get(key).get(0));
            else
                logger.debug("Encountered unhandled parameter: " + key + " " + formParams.get(key) + " [skipping]");
        }

//            persistenceService.save(domainObject);
            return Response.ok().build();
    }
}
