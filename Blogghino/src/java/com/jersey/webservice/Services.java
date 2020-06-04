/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jersey.webservice;

import com.jersey.domain.Post;
import com.jersey.dao.PostDAO;
import java.io.IOException;
import java.sql.*;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Elia
 */
@Path("service")   //this path is used for identify class
public class Services {

    PostDAO postDAO = new PostDAO();
    private static final String SUCCESS_RESULT = "<result>success</result>";
    private static final String FAILURE_RESULT = "<result>failure</result>";

    @GET  //this path is used for identify method
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllPostInJSON() throws ClassNotFoundException, SQLException {

        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/MicroBlogDB", "USER1", "USER1");
        PreparedStatement ps = con.prepareStatement("select * from SAVEDPOST");

        ResultSet rs = ps.executeQuery();

        String arr = "";
        while (rs.next()) {
            String em = "";
            em += "(\r\tid: " + rs.getString("ID") + "\n\r";
            em += "\t image: " + rs.getString("IMAGE") + "\n\r";
            em += "\t author: " + rs.getString("AUTHOR") + "\n\r";
            em += "\t date: " + rs.getString("DATE") + "\n\r";
            em += "\t hours: " + rs.getString("HOURS") + "\n\r";
            em += "\t tags: " + rs.getString("TAGS") + "\n\r";
            em += "\t title: " + rs.getString("TITLE") + "\n\r";
            em += "\t subtitle: " + rs.getString("SUBTITLE") + "\n\r";
            em += "\t content: " + rs.getString("CONTENT") + "\n\r\r)";

            arr += em.replace("\n", ",");

        }
        return "Post{\n" + arr + "}";

    }

    @GET
    @Path("/{id}")   //this path is used for identify method
    @Produces(MediaType.APPLICATION_JSON)
    public String getPostByIdInJSON(@PathParam("id") String postID) throws ClassNotFoundException, SQLException {

        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/MicroBlogDB", "USER1", "USER1");
        PreparedStatement ps = con.prepareStatement("select * from SAVEDPOST WHERE ID = " + Integer.parseInt(postID));

        ResultSet rs = ps.executeQuery();

        String arr = "";
        while (rs.next()) {
            String em = "";
            em += "\t id: " + rs.getString("ID") + "\n\r";
            em += "\t image: " + rs.getString("IMAGE") + "\n\r";
            em += "\t author: " + rs.getString("AUTHOR") + "\n\r";
            em += "\t date: " + rs.getString("DATE") + "\n\r";
            em += "\t hours: " + rs.getString("HOURS") + "\n\r";
            em += "\t tags: " + rs.getString("TAGS") + "\n\r";
            em += "\t title: " + rs.getString("TITLE") + "\n\r";
            em += "\t subtitle: " + rs.getString("SUBTITLE") + "\n\r";
            em += "\t content: " + rs.getString("CONTENT") + "\n\r\r";

            arr += em.replace("\n", ",");

        }
        return "Post{\n" + arr + "}";

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String newPOST(@FormParam("id") int id,
            @FormParam("image") String image,
            @FormParam("author") String author,
            @FormParam("date") String date,
            @FormParam("hours") String hour,
            @FormParam("tags") String tags,
            @FormParam("title") String title,
            @FormParam("subtitle") String subtitle,
            @FormParam("content") String content,
            @Context HttpServletResponse servletResponse) throws IOException {
        Post post = new Post(id, image, author, date, hour, tags, title, subtitle, content);
        int result = postDAO.updatePost(post);
        if (result == 1) {
            return SUCCESS_RESULT;
        }

        return FAILURE_RESULT;
    }
}
