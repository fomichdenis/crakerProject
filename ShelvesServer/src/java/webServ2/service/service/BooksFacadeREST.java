/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServ2.service.service;

import ent.Books;
import ent.Authors;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import webServ2.service.service.AbstractFacade;
import com.google.gson.Gson;
import javax.ws.rs.QueryParam;

/**
 *
 * @author fomichdenis
 */
@Stateless
@Path("books")
public class BooksFacadeREST extends AbstractFacade<Books> {

    @PersistenceContext(unitName = "ShelvesServerPU")
    private EntityManager em;

    public BooksFacadeREST() {
        super(Books.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public String create(String json) {
        return super.create(json);
    }

    @PUT
    @Path("edit")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@QueryParam("id") Long id, Books entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("remove")
    public void remove(@QueryParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("find")
    @Produces({MediaType.APPLICATION_JSON})
    public String find(@QueryParam("id") Long id) {
        return (new Gson()).toJson(super.find(id));
    }
    
    @GET
    @Path("findbyauthor")
    @Produces({MediaType.APPLICATION_JSON})
    public String findByAuthorId(@QueryParam("id") Long id) {
        return (new Gson()).toJson(em.createQuery("select b from Books b where b.authorid = " + id, Books.class).getResultList());
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public String findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllBooks() {
        return (new Gson()).toJson(em.createQuery("select b, a.authorname, a.authorsurname from Books b join Authors a on b.authorid = a.authorid").getResultList());
    }

    @GET
    @Path("findrange")
    @Produces({MediaType.APPLICATION_JSON})
    public String findRange(@QueryParam("from") Integer from, @QueryParam("to") Integer to) {
        return (new Gson()).toJson(super.findRange(new int[]{from, to}));
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
