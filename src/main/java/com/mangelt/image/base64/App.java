package com.mangelt.image.base64;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.mangelt.image.base64.util.Convertor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	File f = new File("C:\\Users\\vn0x53q\\Pictures\\confirm-shopping-cart-icon-94980.png");
    	
    	try {
    		
			
			System.out.println(Convertor.toBase64FormFile(f));
			
			System.out.println(Convertor.toBase64HtmlImageFormFile(f));
			
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
