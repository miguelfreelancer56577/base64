package com.mangelt.image.base64.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FilenameUtils;

public class Convertor {
	
	public Convertor(){
	}
	
	public static String toBase64HtmlImageFormFile(File file) throws IOException, Exception{
		
		String base64FileImage = null;
		
		String nameFile = file.getName();
        
        String fileType = FilenameUtils.getExtension(nameFile);
        
        if(fileType.equalsIgnoreCase("png") || fileType.equals("jpg")){
        	
        	if(fileType.equalsIgnoreCase("jpg"))
        		fileType = "jpeg";
    		
            base64FileImage = addUrlType(toBase64FormFile(file), fileType);
            
        }else{
        	throw new Exception("You must only load files either png or jpg.");
        }
        
		return base64FileImage;
		
	}
	
	protected static String addUrlType(String stringBase64,String fileType){
		
		StringBuilder sb = new StringBuilder(new String("data:image/0;base64,").replace("0", fileType) );
		
		sb.append(stringBase64);
		
		return sb.toString();
		
	} 
	
	public static String toBase64FormFile(File file) throws IOException {
		
		FileInputStream fileInputStream = new FileInputStream(file); 
		
		String base64File = null;
	
		byte[] bytes = new byte[(int)file.length()];
		
		fileInputStream.read(bytes);
        
        base64File = new String(Base64.encodeBase64(bytes), "UTF-8");
        
		return base64File;
		
	}
	
	public static void toCopyFromBase64(String base64, File saveIt) throws IOException{
		
		byte[] bytes  = Base64.decodeBase64(base64);
		
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		
//		String imgName = UUID.randomUUID().toString() + fileType;
		
		FileOutputStream fos = new FileOutputStream(saveIt);
		
		int data;
		
		while((data=bis.read())!=-1)
		{ 
			
			char ch = (char)data;
			
			fos.write(ch);
		
		}
		
		fos.flush();
		
		fos.close();
		
	}
	
}
