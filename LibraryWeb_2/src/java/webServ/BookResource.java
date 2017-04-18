/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServ;

import beans.*;
import com.google.gson.Gson;
import ent.Books;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ejb.EJB;

/**
 * REST Web Service
 *
 * @author fomichdenis
 */
/*@Path("Book")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Context
    private UriInfo context;

    @Inject
    BooksBean bk;

    @GET
    @Path("getBook")
    public String getBookById(@QueryParam("bookId") Long id){
        Books book = bk.getBookById( Long.toString(id) );
        String json = (new Gson()).toJson(book);
        return json;
    }
    
    @GET
    @Path("getBooks")
    public String getBooks(){
        List<Books> book = bk.getBooks();
        //Books book = new Books();
        String json = (new Gson()).toJson(book);
        return json;
    }
    
    @GET
    @Path("deleteBook")
    void deleteBook(@QueryParam("bookId") Long id){
        bk.deleteBook(Long.toString(id));       
    }
    
    @POST
    @Path("createBook")
    void createBook(@QueryParam("bookId") Long id, @QueryParam("authorId") Long authorId, @QueryParam("bookName") String name, @QueryParam("annotation") String annot,
            @QueryParam("date") Long date, @QueryParam("series") String series, @QueryParam("seriesNumber") Long seriesNumber){
        bk.createBook(id, authorId, name, annot, date, series, seriesNumber);       
    }
}*/
