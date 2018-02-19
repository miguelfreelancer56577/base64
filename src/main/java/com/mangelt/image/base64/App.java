package com.mangelt.image.base64;

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
    	File inputFile = new File("C:\\Users\\vn0x53q\\Documents\\CV EDUARDO TORRES RENTERIA.pub");
    	File outputFile = new File("C:\\Users\\vn0x53q\\Desktop\\CV EDUARDO TORRES RENTERIA.txt");
    	File saveFile = new File("C:\\Users\\vn0x53q\\Downloads\\CV EDUARDO TORRES RENTERIA.pub");
    	
    	
    	try {
    		
			Convertor.createBase64File(inputFile, outputFile);
			
			String getContent = Convertor.fromFiletoString(outputFile);
			
			Convertor.toCopyFromBase64(getContent, saveFile);
    		
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
        System.out.println();
    }
}
