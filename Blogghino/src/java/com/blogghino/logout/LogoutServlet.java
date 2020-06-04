package com.blogghino.logout;  
  
import java.io.*;
import javax.servlet.*;  
import javax.servlet.http.*;

/**
 *
 * @author Gaole Elia
 * @version 1.0
 */

public class LogoutServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                        throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
          
        request.getRequestDispatcher("index.html").include(request, response);  
          
        HttpSession session = request.getSession();
        session.invalidate();
          
        out.print("<p>you are successfully logged out!</p>");  
    }  
} 