package com.mangelt.image.base64;

public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Config config = new Config();
    	config.setTitle("Base64...");
    	config.setPositionX(10);
    	config.setPositionY(10);
    	config.setWidth(400);
    	config.setHigh(400);
    	
        JVentana name = new JVentana(config);

	}

}
