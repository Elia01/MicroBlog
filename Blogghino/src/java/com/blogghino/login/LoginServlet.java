package com.blogghino.login;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gaole Elia
 * @version 1.0
 */

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();

            String usrnm = request.getParameter("usrnm");
            String psw = request.getParameter("psw");

            byte[] salt = Validate.getSalt(usrnm);

            String hashedPsw = com.blogghino.hashing.saltToPassword.getSecurePassword(psw, salt);

            if (Validate.checkUser(usrnm, hashedPsw)) {
                HttpSession session = request.getSession();
                session.setAttribute("usrnm", usrnm);

                RequestDispatcher rs = request.getRequestDispatcher("home.html");
                rs.forward(request, response);
            } else {
                out.println("Username or Password incorrect");
                RequestDispatcher rs = request.getRequestDispatcher("login.html");
                rs.include(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
