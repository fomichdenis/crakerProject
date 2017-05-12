/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServ2.service.service;

import ent.Users;
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
@Path("users")
public class UsersFacadeREST extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "ShelvesServerPU")
    private EntityManager em;

    public UsersFacadeREST() {
        super(Users.class);
    }

    @POST
    @Override
    @Path("create")
    @Consumes({MediaType.APPLICATION_JSON})
    public String create(String json) {
        Users entity = (new Gson()).fromJson(json, Users.class);
        List<Users> u = getEntityManager().createQuery("select u from Users u where u.login LIKE '" + entity.getLogin() + "'", Users.class).getResultList();
        if (u.isEmpty()) {
            return super.create(json);
        }
        else {
            return (new Gson()).toJson("login has already existed");
        }
    }

    @PUT
    @Path("edit")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@QueryParam("id") Long id, Users entity) {
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
    
    @POST
    @Path("finduser")
    @Produces({MediaType.APPLICATION_JSON})
    public String findById(String data) { 
    	String login = (new Gson()).fromJson(data, String[].class)[0];
        String password = (new Gson()).fromJson(data, String[].class)[1];  
        List<Users> u = em.createQuery("select u from Users u where u.login LIKE '" + login + "' and u.password LIKE '" + password  + "'", Users.class).getResultList();
        if (u.isEmpty()){
            return (new Gson()).toJson(null);
        }
        else if (u.size() == 1) {
            return (new Gson()).toJson(u.get(0));
        }
        return (new Gson()).toJson("more than 1 user");
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public String findAll() {
        return super.findAll();
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
