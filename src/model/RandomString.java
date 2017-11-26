package model;

import java.util.Random;

public class RandomString {

	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZzxcvbnmasdfghjklqwertyuiop";
    static Random rnd = new Random();

    public static String randomString( int len ){
       StringBuilder sb = new StringBuilder( len );
       for( int i = 0; i < len; i++ ) 
          sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
       return sb.toString();
    }
	
}
