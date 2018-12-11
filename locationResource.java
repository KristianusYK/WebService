/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.google.gson.Gson;
import helper.LocationHelper;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.Location;

/**
 * REST Web Service
 *
 * @author K
 */
@Path("location")
public class locationResource {

    @Context
    private UriInfo context;

    public locationResource() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        LocationHelper helper = new LocationHelper();
        List<Location> list = helper.getAllLocation();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }

}