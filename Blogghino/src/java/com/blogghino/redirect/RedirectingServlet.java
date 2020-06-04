/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogghino.redirect;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;


/**
 *
 * @author Elia
 * 
 */
public class RedirectingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String wlcm = request.getParameter("wlcm");
            if(wlcm != ""){
                response.sendRedirect("home.html");
            }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


}
