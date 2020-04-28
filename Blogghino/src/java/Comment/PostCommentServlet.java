/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comment;

import Post.BuildPost;
import Post.CreatePostServlet;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Elia
 */
public class PostCommentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String a = session.getAttribute("usrnm").toString();
        
        String f = request.getParameter("Cibo");
        //new request

        if (f == "Cibo") {
            try {
                String reply = request.getParameter("reply");
                String mail = request.getParameter("mail");
                String web = request.getParameter("website");
                String com = BuildComment.BuildContent(request.getParameter("comment"));
                String datime = BuildComment.BuildDate();
                String ath = BuildComment.BuildAuthor(a);

                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/MicroBlogDB", "USER1", "USER1");

                PreparedStatement ps = con.prepareStatement("INSERT INTO COMMENT VALUES(?,?,?)");

                ps.setString(1, ath);
                ps.setString(2, datime);
                ps.setString(3, com);
                ps.executeUpdate();

                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MicroBlogDB", "USER1", "USER1");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM COMMENT");
                rs.next();

                String author = rs.getString("AUTHOR");
                String date = rs.getString("DATETIME");
                String c = rs.getString("COMMENT");

                //Instantiating the File class
                String filePath = "C:\\Users\\Elia\\Desktop\\Blogghino\\web\\Cibocs.html";
                //Instantiating the Scanner class to read the file
                Scanner sc = new Scanner(new File(filePath));
                //instantiating the StringBuffer class
                StringBuffer buffer = new StringBuffer();
                //Reading lines of the file and appending them to StringBuffer
                while (sc.hasNextLine()) {
                    buffer.append(sc.nextLine() + System.lineSeparator());
                }
                String fileContents = buffer.toString();
                System.out.println("Contents of the file: " + fileContents);
                //closing the Scanner object
                sc.close();
                String oldLine1 = "<!--NewComment-->";
                String newLine1 = "<!--NewComment-->\n\n" + author + "\n" + date + "\n" + "c";

                //Replacing the old line with new line
                fileContents = fileContents.replaceAll(oldLine1, newLine1);
                //instantiating the FileWriter class
                FileWriter writer = new FileWriter(filePath);
                System.out.println("");
                System.out.println("new data: " + fileContents);
                writer.append(fileContents);
                writer.flush();

                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/MicroBlogDB", "USER1", "USER1");
                PreparedStatement statement = connection.prepareStatement("DELETE FROM COMMENT");
                statement.executeUpdate();

                response.sendRedirect("Cibo.html");

            } catch (Exception ex) {
                Logger.getLogger(PostCommentServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
