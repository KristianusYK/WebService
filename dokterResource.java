/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import helper.DokterHelper;
import static javax.ws.rs.HttpMethod.POST;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import pojos.Dokter;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("dokter")
public class dokterResource {

    @Context
    private UriInfo context;

    public dokterResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        DokterHelper helper = new DokterHelper();
        List<Dokter> list = helper.getDokter();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }
    @POST
    @Path("addDokter")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewDokter(String data) {
        Gson gson = new Gson();
        Dokter dokter = gson.fromJson(data, Dokter.class);
        DokterHelper helper = new DokterHelper();
        helper.addNewDokter(
                dokter.getNama(),
                dokter.getSpesialis());
        return Response
                .status(200)
                .entity(dokter)
                .build();
    }
}
