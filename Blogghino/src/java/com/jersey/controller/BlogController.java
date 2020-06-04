/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jersey.controller;

import com.jersey.client.JerseyClient;
import com.jersey.domain.Post;
import static com.sun.xml.internal.ws.api.pipe.Fiber.current;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.concurrent.ThreadLocalRandom.current;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.Response;
import static org.apache.tomcat.jni.Thread.current;
import org.json.JSONException;
import static org.primefaces.PF.current;
import static org.primefaces.PrimeFaces.current;



/**
 *
 * @author Elia
 */

@Named(value = "blogController")
@SessionScoped
public class BlogController implements Serializable{

    Map<Integer,Post> posts = new HashMap<Integer,Post>();
    JerseyClient client = new JerseyClient();
    Post current = new Post();
    /**
     * Creates a new instance of BlogController
     */
    public BlogController() {
        try{
            constructPostList(client.getAllPostInJSON());
        }catch(JSONException ex){
            FacesMessage facesMes = new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(),"");
            FacesContext.getCurrentInstance().addMessage(null, facesMes);
        }
    }
    
    private void constructPostList(String jsonListOfPosts)throws JSONException{
        
        if(jsonListOfPosts == null|| jsonListOfPosts.isEmpty()){
            throw new JSONException("Post list cannot be empty or null.");
        }
    }
    public void prepareCreate(){
        current = new Post();
    }
    
    public void create(){
        try{
            Response response = client.newPOST(current.toJSON());
            if(response.getStatus() == Response.Status.BAD_REQUEST.getStatusCode()){
                FacesMessage faceMes = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bad Request", "");
                FacesContext.getCurrentInstance().addMessage(null, faceMes);
                return;
            }
            constructPostList(client.getAllPostInJSON());
        
        }catch(JSONException ex){
            FacesMessage facesMes = new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(),"");
            FacesContext.getCurrentInstance().addMessage(null, facesMes);
    }
    }
    
    public List<Post> getPosts(){
        List<Post> list = new ArrayList(posts.values());
        return list;
    }
    
}
