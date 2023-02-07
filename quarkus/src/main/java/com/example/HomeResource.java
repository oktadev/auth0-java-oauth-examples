package com.example;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

/**
 * Renders the "home" template on /.
 */
@Path("/")
public class HomeResource {

    @Inject Template home;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance home(@Context SecurityContext ctx) {
        return home.data("user", ctx.getUserPrincipal());
    }
}