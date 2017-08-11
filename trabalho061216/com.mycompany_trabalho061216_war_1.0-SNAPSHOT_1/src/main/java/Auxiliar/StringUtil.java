/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliar;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Mauricio Capua
 */
public class StringUtil {

    public static String encripta(String senha) {
        if (senha == null) {
            return null;
        }

        try {

            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
            System.out.println(hexString.toString());
            return hexString.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {

            e.printStackTrace();

            return senha;
        }
    }
}
