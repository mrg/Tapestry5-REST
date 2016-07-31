package org.demo.t5rest.services;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.services.ApplicationDefaults;
import org.apache.tapestry5.ioc.services.SymbolProvider;
import org.demo.t5rest.rest.Echo;
import org.demo.t5rest.rest.PeopleResource;

public class AppModule
{
    public static void bind(ServiceBinder binder)
    {
        // Other Services
        binder.bind(PeopleService.class);

        // REST Services
        binder.bind(Echo.class);
        binder.bind(PeopleResource.class);
    }

    public static void contributeFactoryDefaults(MappedConfiguration<String, Object> configuration)
    {
        configuration.override(SymbolConstants.APPLICATION_VERSION, "1.0");
        configuration.override(SymbolConstants.PRODUCTION_MODE, false);
    }

    public static void contributeApplicationDefaults(MappedConfiguration<String, Object> configuration)
    {
        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en");
        configuration.add(SymbolConstants.HMAC_PASSPHRASE, "HMAC_PASSPHRASE");
    }

    @ApplicationDefaults
    @Contribute(SymbolProvider.class)
    public static void setupEnvironment(MappedConfiguration<String, Object> configuration)
    {
        configuration.add(SymbolConstants.JAVASCRIPT_INFRASTRUCTURE_PROVIDER, "jquery");
        configuration.add(SymbolConstants.MINIFICATION_ENABLED, true);
    }

    /**
     * Configure Rest resources
     *
     * @param singletons
     * @param peopleResource
     */
//    @Contribute(javax.ws.rs.core.Application.class)
////    public static void configurePhoneRestResources(Configuration<Object> singletons, @Autobuild PeopleResource peopleResource)
//    public static void configureRestResources(Configuration<Object> singletons, PeopleResource peopleResource, Echo echo)
//    {
//        singletons.add(peopleResource);
//        singletons.add(echo);
//    }
}
