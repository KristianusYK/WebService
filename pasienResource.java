/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.google.gson.Gson;
import helper.AntrianHelper;
import helper.PasienHelper;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.Antrian;
import pojos.Pasien;

/**
 * REST Web Service
 *
 * @author Asus
 */
@Path("pasien")
public class pasienResource {

    @Context
    private UriInfo context;

    public pasienResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        PasienHelper helper = new PasienHelper();
        List<Pasien> list = helper.getPasien();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }

    @POST
    @Path("addPasien")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewPasien(String data) {
        Gson gson = new Gson();
        Pasien pasien = gson.fromJson(data, Pasien.class);
        PasienHelper helper = new PasienHelper();
        helper.addNewPasien(
                pasien.getNoRm(),
                pasien.getNama(),
                pasien.getAlamat(),
                pasien.getNik(),
                pasien.getTanggalLahir(),
                pasien.getKelamin());
        return Response
                .status(200)
                .entity(pasien)
                .build();
    }
     @GET
    @Path("cariPasien")
    @Produces(MediaType.APPLICATION_JSON)
    public Response cariPasien(@QueryParam("nik") String nik) {
        PasienHelper test = new PasienHelper();
        Pasien pasien = test.cariPasien(nik);
        Gson gson = new Gson();
        String json = gson.toJson(pasien);
        return Response
                .status(200)
                .entity(json)
                .build();
    }
}
