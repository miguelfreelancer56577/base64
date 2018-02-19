package com.mangelt.image.base64.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

import com.mangelt.image.base64.util.Convertor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
//    	File f = new File("C:\\Users\\vn0x53q\\Pictures\\confirm-shopping-cart-icon-94980.png");
    	File f = new File("C:\\Users\\vn0x53q\\Downloads\\CV.pub");
    	File file = new File("C:\\Users\\vn0x53q\\Downloads\\curriculum.txt");
    	
    	try {
    		
    		String everything = Convertor.fromFiletoString(file);
    		
			Convertor.toCopyFromBase64(everything, f);
    		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
        System.out.println();
    }
}
