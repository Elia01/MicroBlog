package Profile;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Gaole Elia
 * @version 1.0
 */
public class ProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("welcome.html").include(request, response);

        HttpSession session = request.getSession(false);

        if (session != null) {
            String name = (String) session.getAttribute("name");
            out.println("<h3>Hello, " + name + " Welcome to your Profile</h3>");

        } else {
            out.print("Please login first");
            request.getRequestDispatcher("login.html");
        }

        out.close();
    }
}
