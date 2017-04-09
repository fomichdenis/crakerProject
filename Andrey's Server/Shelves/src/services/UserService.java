package services;

import beans.BooksBean;
import beans.UsersBean;
import com.google.gson.Gson;

import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static services.CORS.makeCORS;

/**
 * Created by adaico on 05.04.17.
 */
@Path("/users")
@Stateless
public class UserService {
    static private EntityManagerFactory emf = Persistence.createEntityManagerFactory("BooksPersistence");
    Gson gson = new Gson();

    @POST
    @Path("/{userId}")
    @Produces("application/json")
    public Response getBook(@PathParam("userId") int userId) {
        UsersBean pb = new UsersBean(emf);
        return makeCORS(Response.ok(gson.toJson(pb.getElement(userId))));
    }

    public static void main(String[] args) {
        Gson gson = new Gson();
        UsersBean pb = new UsersBean(emf);
        System.out.print(gson.toJson(pb.getElement(1)));
    }
}
