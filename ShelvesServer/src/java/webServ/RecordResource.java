/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServ;

import beans.*;
import com.google.gson.Gson;
import ent.Records;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author fomichdenis
 */
/*@Path("Record")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
public class RecordResource {

    @Context
    private UriInfo context;
    RecordBean rec;

    @GET
    @Path("getRecord")
    public String getRecordById(@QueryParam("recordId") Long id){
        Records record = rec.getRecordById( Long.toString(id) );
        String json = (new Gson()).toJson(record);
        return json;
    }
    
    @GET
    @Path("getRecords")
    public String getRecords(){
        List<Records> record = rec.getRecords();
        String json = (new Gson()).toJson(record);
        return json;
    }
    
    @GET
    @Path("deleteRecord")
    void deleteRecord(@QueryParam("recordId") Long id){
        rec.deleteRecord(Long.toString(id));       
    }
    
    @POST
    @Path("createRecord")
    void createRecord(@QueryParam("commentId")Long id, @QueryParam("bookId")Long bookId, @QueryParam("userId")Long userId, @QueryParam("date")String date, 
            @QueryParam("rate")Long rate, @QueryParam("progress")Long progress, @QueryParam("text")String text, @QueryParam("status")Long status){
        rec.createRecord(id, userId, bookId, rate, date, text, status, progress);       
    }
}*/
