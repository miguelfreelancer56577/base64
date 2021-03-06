package com.mangelt.image.base64.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FilenameUtils;

public class Convertor {
	
	public Convertor(){
	}
	
	protected static final Matcher findMatch(String regex, String input){
		
		return Pattern.compile(regex).matcher(input);
		
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
		
		byte[] bytes  = org.apache.commons.codec.binary.Base64.decodeBase64(base64.getBytes());
		
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
	
	protected static final String regexBase64Html = "data:image\\W{1}(png|jpg);base64,";
	
	public static String getTypeFromBase64Html(String base64Html){
		
		String type = null;
		
		Matcher regex = findMatch(regexBase64Html, base64Html);
		
		if(regex.find()){
			
//			data:image/png;base64,
			type = regex.group();
			
			type = type.substring(11, 14);
			
		}else{
			
			throw new NullPointerException("It does not have a image type.");
			
		}
		
		return type;
	}  
	
	public static String getValueFromBase64Html(String base64Html){
		
		String value = null;
		
		Matcher regex = findMatch(regexBase64Html, base64Html);
		
		if(regex.find()){
			
			value = base64Html.replaceAll(regexBase64Html, "");
			
		}else{
			
			throw new NullPointerException("It does not have a base64 image type.");
			
		}
		
		return value;
	}
	
	public static String fromFiletoString(File input) throws FileNotFoundException{
		
		BufferedReader br = new BufferedReader(new FileReader(input));
		
		String everything = "";
		StringBuilder sb = new StringBuilder();
		
		try {
			
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    everything = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		    try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return everything;
		
	}
	
	public static Boolean createBase64File(File inputFile, File outputFile){
		
		if(inputFile.exists()){
			
			try {
				
				String contentBase64 = toBase64FormFile(inputFile);
				
				createFile(contentBase64, outputFile);
				
			} catch (IOException e) {
				return false;
			}
			
		}
		
		return false;
		
	}
	
	public static Boolean createFile(String content, File outputFile){
		
		PrintWriter writer;
		
		try {
			
			writer = new PrintWriter(outputFile, "UTF-8");
			
			writer.println(content);
			
			writer.close();
			
			return true;
			
		} catch (FileNotFoundException e) {
		} catch (UnsupportedEncodingException e) {
		}
		
		return false;
		
	} 
	
}
