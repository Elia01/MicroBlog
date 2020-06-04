package com.blogghino.login;

import java.sql.*;

/**
 *
 * @author Gaole Elia
 * @version 1.0
 */
public class Validate {

    public static boolean checkUser(String usrnm, String psw) {

        boolean st = false;
        try {
            //loading drivers for mysql

            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //creating connection with the database
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/MicroBlogDB", "USER1", "USER1");
            PreparedStatement ps = con.prepareStatement("select * from UTENTI where USERNAME=? and PASSWORD=?");
            ps.setString(1, usrnm);
            ps.setString(2, psw);
            ResultSet rs = ps.executeQuery();
            st = rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }
    
    
      public static byte[] getSalt(String usrnm) throws ClassNotFoundException, SQLException{
        
        byte[] slt;
        String s;
        
        
            //loading drivers for mysql
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //creating connection with the database
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/MicroBlogDB", "USER1", "USER1");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT SALT FROM UTENTI WHERE USERNAME LIKE '" + usrnm + "'");
            rs.next();
            s =  rs.getString("SALT");
            slt = s.getBytes();
            
            return slt;


                   
    }
}
