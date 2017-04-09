package services;

import beans.BooksBean;
import com.google.gson.Gson;

import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import static services.CORS.*;

/**
 * Created by adaico on 26.03.17.
 */

@Path("/books")
@Stateless
public class BookService {
    static private EntityManagerFactory emf = Persistence.createEntityManagerFactory("BooksPersistence");
    Gson gson = new Gson();

    @GET
    @Path("/getBooks")
    @Produces("application/json")
    public Response getBooks() {
        BooksBean bb = new BooksBean(emf);
        return makeCORS(Response.ok(gson.toJson(bb.getAllElements())));
    }

    @POST
    @Path("/{bookId}")
    @Produces("application/json")
    public Response getBook(@PathParam("bookId") int bookId) {
        BooksBean bb = new BooksBean(emf);
        return makeCORS(Response.ok(gson.toJson(bb.getElement(bookId))));
    }

    public static void main(String[] args) {
        Gson gson = new Gson();
        BooksBean bb = new BooksBean(emf);
        System.out.print(gson.toJson(bb.getElement(1)));
    }
}
