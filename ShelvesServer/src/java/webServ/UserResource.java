/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServ;

import beans.*;
import com.google.gson.Gson;
import ent.Users;
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
/*@Path("User")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Context
    private UriInfo context;
    UsersBean us;
    
    @GET
    @Path("getUser")
    public String getUserById(@QueryParam("userId") Long id){
        Users user = us.getUserById( Long.toString(id) );
        String json = (new Gson()).toJson(user);
        return json;
    }
    
    @GET
    @Path("getUsers")
    public String getUsers(){
        List<Users> user = us.getUsers();
        String json = (new Gson()).toJson(user);
        return json;
    }
    
    @GET
    @Path("deleteUser")
    void deleteUser(@QueryParam("userId") Long id){
        us.deleteUser(Long.toString(id));       
    }
    
    @POST
    @Path("createUser")
    void createUser(@QueryParam("userId") Long id, @QueryParam("userName") String name, @QueryParam("userSurname") String surname, @QueryParam("email") String email, 
            @QueryParam("login")String login, @QueryParam("sex")Long sex, @QueryParam("information")String information){
        us.createUser(id, name, surname, email, login, sex, information);  
    }
}*/
