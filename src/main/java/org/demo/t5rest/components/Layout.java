package org.demo.t5rest.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

public class Layout
{
    @Inject
    private Logger             logger;

    @Property
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    private String             title;
}
