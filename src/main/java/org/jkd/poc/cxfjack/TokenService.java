package org.jkd.poc.cxfjack;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * Created by kdjayasu on 10/16/14.
 */
@Path("/token")
public class TokenService {

    /**
     * Deserialized example using JsonProvider attached to CXF server.
     **/

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createToken(TokenRequest tokenRequest){

        System.out.println("New token created ....\n ..." + tokenRequest);

        return Response.ok().entity(new TokenResponse("3dde43dsf","24-12-2014")).build();
    }


    /**
     * Deserialized example using Jackson object mapper. In this way, we have more control in granular level.
     **/

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateToken(String tokenRequest){

        System.out.println("Token updated ....\n ..." + tokenRequest);

        ObjectMapper mapper = new ObjectMapper();
        AnnotationIntrospector jaxbAnnotationIntrospector = new JaxbAnnotationIntrospector(TypeFactory.defaultInstance());
        mapper.setAnnotationIntrospector(jaxbAnnotationIntrospector);
        mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE,true);
        try {
            TokenRequest request = mapper.readValue(tokenRequest, TokenRequest.class);
            System.out.println("Deserialized Request : " + request);
        } catch (IOException e) {
            e.printStackTrace();
            return Response.serverError().entity(e.getMessage()).build();
        }

        return Response.ok().entity(new TokenResponse("3dde43dsf","24-12-2014")).build();
    }
}
