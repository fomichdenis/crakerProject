/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServ;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author fomichdenis
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(webServ2.service.service.AuthorsFacadeREST.class);
        resources.add(webServ2.service.service.BooksFacadeREST.class);
        resources.add(webServ2.service.service.CommentsFacadeREST.class);
        resources.add(webServ2.service.service.RecordsFacadeREST.class);
        resources.add(webServ2.service.service.UsersFacadeREST.class);
    }
    
}

/*public void create(String json) {
        T entity = (new Gson()).fromJson(json, entityClass);
        getEntityManager().persist(entity);
    }*/
