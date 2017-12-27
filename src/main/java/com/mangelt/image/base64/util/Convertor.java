package com.mangelt.image.base64.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FilenameUtils;

public class Convertor extends FileInputStream {
	
	protected String encodedfile = null;
	protected File file = null;
	
	public Convertor(File file) throws FileNotFoundException, NullPointerException{
		super(file);
		if(file == null)
			throw new NullPointerException("File is null.");
		this.file = file;
	}
	
	public String encodeFileToBase64Binary() throws IOException, Exception{
		
		String nameFile = file.getName();
        
        String fileType = FilenameUtils.getExtension(nameFile);
        
        if(fileType.equalsIgnoreCase("png") || fileType.equals("jpg")){
        	
        	if(fileType.equalsIgnoreCase("jpg"))
        		fileType = "jpeg";
    		
    		byte[] bytes = new byte[(int)file.length()];
    		
            this.read(bytes);
            
            encodedfile = addUrlType(new String(Base64.encodeBase64(bytes), "UTF-8"), fileType);
            
        }else{
        	throw new Exception("You must only load files either png or jpg.");
        }
        
		return encodedfile;
		
	}
	
	protected String addUrlType(String stringBase64,String fileType){
		
		StringBuilder sb = new StringBuilder(new String("data:image/0;base64,").replace("0", fileType) );
		
		sb.append(stringBase64);
		
		return sb.toString();
		
	} 
	
}
