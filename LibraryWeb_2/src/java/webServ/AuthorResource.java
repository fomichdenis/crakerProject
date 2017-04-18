/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServ;

import java.util.List;
import beans.AuthorsBean;
import com.google.gson.Gson;
import ent.Authors;
import javax.ejb.Stateless;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author fomichdenis
 */
@Path("Author")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
public class AuthorResource {

    @Context
    private UriInfo context;
    
    AuthorsBean ath;

    /**
     * Creates a new instance of AuthorResource
     */
    @GET
    @Path("getAuthor")
    public String getAuthorById(@QueryParam("authorId") Long id){
        Authors author = ath.getAuthorById( Long.toString(id) );
        String json = (new Gson()).toJson(author);
        return json;
    }
    
    @GET
    @Path("getAuthors")
    public String getAuthors(){
        List<Authors> author = ath.getAuthors();
        String json = (new Gson()).toJson(author);
        return json;
    }
    
    @GET
    @Path("deleteAuthor")
    void deleteAuthor(@QueryParam("authorId") Long id){
        ath.deleteAuthor(Long.toString(id));       
    }
    
    @POST
    @Path("createAuthor")
    void createAuthor(@QueryParam("authorId") Long id, @QueryParam("authorName") String name,@QueryParam("authorSurname") String surname,
            @QueryParam("authorYearBirthday") Long yearB, @QueryParam("authorYearDeath") Long yearD, @QueryParam("authorInformation") String information){
        ath.createAuthor(id, name, surname, yearB, yearD, information);       
    }
    
}