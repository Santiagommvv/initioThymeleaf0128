
package com.initioSpring.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Enc_Utileria {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        String password111 = "111";
        String password333 = "333";
        
        
        
        String enP1 = encoder.encode(password111);
        String enP3 = encoder.encode(password333);
        
        boolean isPasswordMatch = encoder.matches(password111, enP1);
        boolean isPasswordMatch3 = encoder.matches(password333, enP3);
        
        System.out.println("Password : " + password111 + "   isPasswordMatch    : " + isPasswordMatch);
        System.out.println("Password : " + password333 + "   isPasswordMatch    : " + isPasswordMatch3);
        System.out.println(enP1);
        System.out.println(enP3);
        /*
        System.out.println("passwordAdmin: " + password111);
        System.out.println("passwordAdmin encriptado:" + encriptarPassword(password111));
        System.out.println("passwordUser: " + password333);
        System.out.println("passwordUser encriptado:" + encriptarPassword(password333));
        
        boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
        */
    }
    
    /*public static String encriptarPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }*/
}
