package com.example;

import io.quarkus.oidc.runtime.OidcJwtCallerPrincipal;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.security.Authenticated;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

/**
 * Displays the current user's OIDC claims.
 */
@Path("/profile")
public class ProfileResource {

    @Inject
    Template profile;

    @GET
    @Authenticated
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance profile(@Context SecurityContext ctx) {
        // cast the user to a OidcJwtCallerPrincipal to get access to the token claims
        OidcJwtCallerPrincipal jwtPrincipal = (OidcJwtCallerPrincipal) ctx.getUserPrincipal();
        return profile.data("user", ctx.getUserPrincipal(), "claims", jwtPrincipal.getClaims().getClaimsMap() );
    }
}