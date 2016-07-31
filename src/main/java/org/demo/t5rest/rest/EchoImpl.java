package org.demo.t5rest.rest;

import javax.ws.rs.core.Response;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.slf4j.Logger;

public class EchoImpl implements Echo
{
    @Inject
    private Logger logger;

    @Override
    public Response echo(String message)
    {
        JSONObject json = new JSONObject("message", message);

        logger.debug(json.toCompactString());

        return Response.ok().entity(json.toCompactString()).build();
    }
}
