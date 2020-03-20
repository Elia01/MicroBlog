package Hashing;

import java.security.*;

/**
 *
 * @author Gaole Elia
 * @version 1.0
 */
public class saltToPassword {
    
    public static String getSecurePassword(String passwordToHash, byte[] salt){
        
        String generatedPassword = null;
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            md.update(salt);
            
            byte[] bytes = md.digest(passwordToHash.getBytes());
            
            StringBuilder sb = new StringBuilder();
            
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            
            generatedPassword = sb.toString();
            
        } 
        
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        
        return generatedPassword;
    }
     
    //Add salt
}
