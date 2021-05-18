package academy.devdojo.springboot2.service;

import java.security.MessageDigest;
import java.math.BigInteger;

public class CriptoService {

    public static String encrypt(String text){
        return encrypt(text,16);
    }

    public static String encrypt(String text, Integer length){
        String ecryptText = "";
        MessageDigest md;
        try{
            md = MessageDigest.getInstance("MD5");
            BigInteger hash = new BigInteger(1,md.digest(text.getBytes()));
            ecryptText = hash.toString(length);
        }catch (Exception e){}
        return ecryptText;
    }

}
