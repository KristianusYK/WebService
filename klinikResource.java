/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import helper.KlinikHelper;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import pojos.Klinik;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("klinik")
public class klinikResource {

    @Context
    private UriInfo context;

    public klinikResource() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        KlinikHelper helper = new KlinikHelper();
        List<Klinik> list = helper.getKlinik();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }
    @POST
    @Path("addKlinik")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewKlinik(String data) {
        Gson gson = new Gson();
        Klinik klinik = gson.fromJson(data, Klinik.class);
        KlinikHelper helper = new KlinikHelper();
        helper.addNewKlinik(
                klinik.getIdKlinik(),
                klinik.getNama(),
                klinik.getSpesialis());
        return Response
                .status(200)
                .entity(klinik)
                .build();
    }
}
