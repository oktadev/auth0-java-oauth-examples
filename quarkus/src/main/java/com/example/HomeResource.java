package com.example;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

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