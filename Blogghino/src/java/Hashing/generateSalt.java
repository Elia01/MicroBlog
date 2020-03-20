package Hashing;

import java.security.*;

/**
 *
 * @author Gaole Elia
 * @version 1.0
 */
public class generateSalt {
     public static byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException{
        //Always use a SecureRandom generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        //Create array for salt
        byte[] salt = new byte[16];
        //Get a random salt
        sr.nextBytes(salt);
        //return salt
        return salt;
    }
}