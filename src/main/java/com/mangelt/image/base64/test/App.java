package com.mangelt.image.base64.test;

import java.io.File;
import java.io.FileNotFoundException;
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
    	
    	File f = new File("C:\\Users\\vn0x53q\\Pictures\\confirm-shopping-cart-icon-94980.png");
//    	File f = new File("C:\\Users\\vn0x53q\\Documents\\dcnm1.mx.wal-mart.com.zip");
    	
    	try {
    		
			
//			System.out.println(Convertor.toBase64FormFile(f));
			
//			System.out.println(Convertor.toBase64HtmlImageFormFile(f));
			
//			String imgName = UUID.randomUUID().toString() + ".zip" ;
//			
//			File img = new File(imgName);
//			
//			Convertor.toCopyFromBase64(Convertor.toBase64FormFile(f), img);
    		
    		String base64 = Convertor.toBase64FormFile(f);
    		
    		String base64Html = Convertor.toBase64HtmlImageFormFile(f);
    		
    		String type = Convertor.getTypeFromBase64Html("");
    		
    		String value = Convertor.getValueFromBase64Html(""); 
    		
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
