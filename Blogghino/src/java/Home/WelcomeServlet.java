package Home;

/**
 *
 * @author Gaole Elia
 * @version 1.0
 */
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class WelcomeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String usrnm = request.getParameter("usrnm");
        out.println("<head><style>");
        out.println("* {box-sizing: border-box;}");
        out.println("body {margin: 0;");
        out.println("font-family: Arial, Helvetica, sans-serif;}");
        out.println(".header {overflow: hidden;");
        out.println("background-color: #f1f1f1;");
        out.println("padding: 20px 10px;}");
        out.println(".btn {background-color: dodgerblue;");
        out.println("color: white;");
        out.println("padding: 15px 20px;");
        out.println("border: none;");
        out.println("cursor: pointer;");
        out.println("width: 100%;");
        out.println("opacity: 0.9;");
        out.println("border-radius: 4px;}");
        out.println(".btn:hover {opacity: 1;}");
        out.println("</head></style>");
        
        out.println("<div class='header'><center><h2>You're successfuly logged in</h2></center></div>");
        out.println("<div style='padding-left:20px'><center><h3>Welcome " + usrnm + "</h3></center></div>");
        out.println("<form action='RedirectingServlet' style='max-width:100px;margin:auto'>"
                + "<input class='btn' type='submit' name='wlcm' value='OK'/>"
                + "</form>");
    }
}
