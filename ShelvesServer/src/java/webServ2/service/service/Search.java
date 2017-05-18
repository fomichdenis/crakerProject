/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServ2.service.service;

import com.google.gson.Gson;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author adaico
 */
@Stateless
@Path("search")
public class Search {
    
    @PersistenceContext(unitName = "ShelvesServerPU")
    private EntityManager em;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String find(@QueryParam("data") String data) {
        data = data.toLowerCase();
        List books = em.createQuery(
                "SELECT b.bookid, b.bookname "
                + "FROM Books b "
                + "WHERE LOWER(b.bookname) LIKE :data")
                .setParameter("data", data + "%").getResultList();
        if (books.isEmpty()) books = null;
        List authors = em.createQuery(
                "SELECT a.authorid, a.authorname, a.authorsurname "
                + "FROM Authors a "
                + "WHERE LOWER(a.authorname) LIKE :data OR LOWER(a.authorsurname) LIKE :data")
                .setParameter("data", data + "%").getResultList();
        if (authors.isEmpty()) authors = null;
        Map<String, List> response = new HashMap<>();
        response.put("books", books);
        response.put("authors", authors);
        return (new Gson()).toJson(response);
    }
}
