/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Post;

import java.io.IOException;
import java.sql.*;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author Elia
 * @version 1.0
 */
public class CreatePostServlet extends HttpServlet {


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String a = session.getAttribute("usrnm").toString();
        
        String ttl = request.getParameter("title");
        String subttl = request.getParameter("subtitle");
        String cont = request.getParameter("content");
        String tgs = request.getParameter("tags");
        
        String title = BuildPost.BuildTitle(ttl);
        String subtitle = BuildPost.BuildTitle(subttl);
        String content = BuildPost.BuildContent(cont);
        String author = BuildPost.BuildAuthor(a);
        String date = BuildPost.BuildDate();
        String hour = BuildPost.BuildHour();
        String tags = BuildPost.BuildTags(tgs);
        //String image = BuildPost.BuildImage();
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/MicroBlogDB","USER1","USER1");

            PreparedStatement ps = con.prepareStatement("insert into POST values(?,?,?,?,?,?,?,?)");
            
            
            //ps.setString(1, image);
            ps.setString(2, author);
            ps.setString(3, date);
            ps.setString(4, hour);
            ps.setString(5, tags);
            ps.setString(6, title);
            ps.setString(7, subtitle);
            ps.setString(8, content);
            ps.executeUpdate();
            
            //String htmlContent = TextUtil.convertTextToHTML(content);
            
            //Post post = new Post(title, htmlContent, newDate);
            
            //request.getServletContext().setAttribute("post", post);
            
            //RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
            //rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CreatePostServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
