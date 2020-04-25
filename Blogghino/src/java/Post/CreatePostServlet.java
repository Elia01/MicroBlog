/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Post;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
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
        String img = request.getParameter("image");
        
        String image = BuildPost.BuildImage(img);
        String title = BuildPost.BuildTitle(ttl);
        String subtitle = BuildPost.BuildSubTitle(subttl);
        String content = BuildPost.BuildContent(cont);
        String author = BuildPost.BuildAuthor(a);
        String date = BuildPost.BuildDate();
        String hour = BuildPost.BuildHour();
        String tags = BuildPost.BuildTags(tgs);
        int i = 0;
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/MicroBlogDB","USER1","USER1");

            PreparedStatement ps = con.prepareStatement("insert into POST values(?,?,?,?,?,?,?,?,?)");
            
            
            ps.setString(1, image);
            ps.setString(2, author);
            ps.setString(3, date);
            ps.setString(4, hour);
            ps.setString(5, tags);
            ps.setString(6, title);
            ps.setString(7, subtitle);
            ps.setString(8, content);
            ps.setInt(9, i);
            ps.executeUpdate();
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MicroBlogDB","USER1","USER1");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM POST" );
            rs.next();
            
            String img1 =  rs.getString("IMAGE");
            String ath =  rs.getString("AUTHOR");
            String date1 =  rs.getString("DATE");
            String h =  rs.getString("HOURS");
            String tag =  rs.getString("TAGS");
            String tit =  rs.getString("TITLE");
            String subtit =  rs.getString("SUBTITLE");
            String cont1 =  rs.getString("CONTENT");
            String id =  rs.getString("ID");
            
            //Instantiating the File class
            String filePath = "C:\\Users\\Elia\\Desktop\\Blogghino\\web\\PostsList.html";
            //Instantiating the Scanner class to read the file
            Scanner sc = new Scanner(new File(filePath));
            //instantiating the StringBuffer class
            StringBuffer buffer = new StringBuffer();
            //Reading lines of the file and appending them to StringBuffer
            while (sc.hasNextLine()) {
                buffer.append(sc.nextLine()+System.lineSeparator());
            }
            String fileContents = buffer.toString();
            System.out.println("Contents of the file: "+fileContents);
            //closing the Scanner object
            sc.close();
            String oldLine1 = "<!--NewPost-->";
            String newLine1 = "<!--NewPost-->\n\n" + img1 + "\n" + ath + "\n"+ date1 + "\n" + h + "\n" + tag + "\n" + tit + "\n" + subtit + "\n" + cont1 + "\n";
            
            //Replacing the old line with new line
            fileContents = fileContents.replaceAll(oldLine1, newLine1);
            //instantiating the FileWriter class
            FileWriter writer = new FileWriter(filePath);
            System.out.println("");
            System.out.println("new data: "+fileContents);
            writer.append(fileContents);
            writer.flush();
            
            String fp = "C:\\Users\\Elia\\Desktop\\Blogghino\\web\\PostsList.html";
            //Instantiating the Scanner class to read the file
            Scanner scan = new Scanner(new File(fp));
            //instantiating the StringBuffer class
            StringBuffer b = new StringBuffer();
            //Reading lines of the file and appending them to StringBuffer
            while (scan.hasNextLine()) {
                b.append(scan.nextLine()+System.lineSeparator());
            }
            String fc = buffer.toString();
            System.out.println("Contents of the file: "+fc);
            //closing the Scanner object
            scan.close();
            String oldLine2 = "<!--NewTit-->";
            String newLine2 = tit + "\n<!--NewTit-->";
            
            //Replacing the old line with new line
            fc = fc.replaceAll(oldLine2, newLine2);
            //instantiating the FileWriter class
            FileWriter w = new FileWriter(fp);
            System.out.println("");
            System.out.println("new data: "+fc);
            w.append(fc);
            w.flush();
            
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/MicroBlogDB","USER1","USER1");
            PreparedStatement statement = connection.prepareStatement("DELETE FROM POST");
            statement.executeUpdate();
            
            
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(CreatePostServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("home.html");
    }
}
