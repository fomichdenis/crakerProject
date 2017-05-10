/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServ;

import beans.*;
import com.google.gson.Gson;
import ent.Comments;
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
/*@Path("Comment")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {

    @Context
    private UriInfo context;
    CommentBean cmt;

    @GET
    @Path("getComment")
    public String getCommentById(@QueryParam("commentId") Long id){
        Comments comment = cmt.getCommentById( Long.toString(id) );
        String json = (new Gson()).toJson(comment);
        return json;
    }
    
    @GET
    @Path("getComments")
    public String getComments(){
        List<Comments> comment = cmt.getComments();
        String json = (new Gson()).toJson(comment);
        return json;
    }
    
    @GET
    @Path("deleteComment")
    void deleteComment(@QueryParam("bookId") Long id){
        cmt.deleteComment(Long.toString(id));       
    }
    
    @POST
    @Path("createComment")
    void createComment(@QueryParam("commentId")Long id, @QueryParam("bookId")Long bookId, @QueryParam("userId")Long userId, @QueryParam("date")String date, 
            @QueryParam("likes")Long likes, @QueryParam("dislike")Long dislike, @QueryParam("text")String text){
        cmt.createComment(id, bookId, userId, date, likes, dislike, text);       
    }
}*/
