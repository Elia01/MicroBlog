
package Registration;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gaole Elia
 * @version 1.0
 */
public class RegisterServlet extends HttpServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            String name = request.getParameter("usrnm");
            String psw = request.getParameter("psw");
            
            byte[] salt = Hashing.generateSalt.getSalt();
            String s = new String(salt);
            String hashedPsw = Hashing.saltToPassword.getSecurePassword(psw, salt);
            String role = "";
            
            try {
                
                // loading drivers for mysql
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                
                //creating connection with the database
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/MicroBlogDB","USER1","USER1");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT USERNAME FROM UTENTI");

                //Control if Username in the table UTENTI is empty
                if(rs.next()== false){
                    role = "Admin";
                
                }else{
                    role = "Basic User";
                }while(rs.next());
                
                PreparedStatement ps = con.prepareStatement("insert into UTENTI values(?,?,?,?)");
                
                ps.setString(1, name);
                ps.setString(2, hashedPsw);
                ps.setString(3, s);
                ps.setString(4, role);
                ps.executeUpdate();
                
                
//                if(i > 0) {
//                    out.println("<strong>" + "You are sucessfully registered" + "</strong>" + "<br>");
//                    out.println("Welcome " + "<strong>" + name + "</strong>");
//                    RequestDispatcher rs = request.getRequestDispatcher("index.html");
//                    rs.include(request, response);
//                    
//                }
                
            }
            catch(Exception se) {        
                se.printStackTrace();
            }
            
        }
        catch(Exception ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
	RequestDispatcher rds = request.getRequestDispatcher("WelcomeServlet");
        rds.forward(request, response);
    }
}
