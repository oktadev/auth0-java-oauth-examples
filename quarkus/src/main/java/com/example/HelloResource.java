package com.example;

import io.quarkus.security.Authenticated;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;
import java.security.Principal;

@Path("/hello")
public class HelloResource {

    @GET
    @Authenticated
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@Context SecurityContext context) {
        Principal userPrincipal = context.getUserPrincipal();
        return "Hello, " + userPrincipal.getName() + "!";
    }
}
