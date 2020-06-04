/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jersey.dao;

import com.jersey.domain.Post;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Elia
 */
public class PostDAO {
    
    private static final List<Post> posts = new ArrayList<Post>();
    
    public PostDAO() {}

      public List<Post> getAllPost(){ 
      List<Post> postList = null; 
      try { 
         File file = new File("Posts.dat"); 
         if (!file.exists()) { 
            Post p = new Post(1, "Mahesh", "Teacher", "12/2/2016", "12:34", "lezione", "Lezione", "lessons", "lezione di inglese"); 
            postList = new ArrayList<Post>(); 
            postList.add(p); 
            savePostList(postList);   
         } 
         else{ 
            FileInputStream fis = new FileInputStream(file); 
            ObjectInputStream ois = new ObjectInputStream(fis); 
            postList = (List<Post>) ois.readObject(); 
            ois.close(); 
         }
      } catch (IOException e) { 
         e.printStackTrace(); 
      } catch (ClassNotFoundException e) { 
         e.printStackTrace(); 
      }   
      return postList; 
   }  
    
    public Post getPost(int id){ 
      List<Post> posts = getAllPost();  
      for(Post post: posts){ 
         if(post.getId() == id){ 
            return post; 
         } 
      } 
      return null; 
   }
   
    
    public int addPost(Post p){ 
      List<Post> postList = getAllPost(); 
      boolean postExists = false; 
      for(Post post: postList){ 
         if(post.getId() == p.getId()){ 
            postExists = true; 
            break; 
         } 
      }   
      if(!postExists){ 
         postList.add(p); 
         savePostList(postList); 
         return 1; 
      } 
      return 0; 
   }
    
      public int updatePost(Post p){ 
      List<Post> postList = getAllPost();  
      for(Post post: postList){ 
         if(post.getId() == p.getId()){ 
            int index = postList.indexOf(post);    
            postList.set(index, p); 
            savePostList(postList); 
            return 1; 
         } 
      }   
      return 0; 
   } 
    
      private void savePostList(List<Post> postList){ 
      try { 
         File file = new File("Posts.dat"); 
         FileOutputStream fos;  
         fos = new FileOutputStream(file);
         ObjectOutputStream oos = new ObjectOutputStream(fos);   
         oos.writeObject(postList); 
         oos.close(); 
      } catch (FileNotFoundException e) { 
         e.printStackTrace(); 
      } catch (IOException e) { 
         e.printStackTrace(); 
      } 
   } 
}
