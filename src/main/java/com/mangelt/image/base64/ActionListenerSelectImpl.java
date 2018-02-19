package com.mangelt.image.base64;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.mangelt.image.base64.util.Convertor;

public class ActionListenerSelectImpl implements ActionListener{

	JVentana v;
	StringBuilder log;

	public ActionListenerSelectImpl(JVentana v) {
		super();
		this.v = v;
		log = v.log;
	}
	
	public void actionPerformed(ActionEvent e){
		
		log.append("Procesando archivos...\n");
		
		JButton btn = (JButton)e.getSource();
		
		String path = v.txtInput.getText();
		
		String nameOutput = v.txtOutput.getText();
		
		boolean statusOK = true;
		
		String msgInput = "";
		
		String msgOut = "";
		
		if(btn.getText().equalsIgnoreCase(JVentana.TOBASE64)){
			
			msgInput = "Por favor ingrese la ruta del archivo que quiere convertir a base64.";
			
			msgOut = "Por favor ingrese el nombre del archivo donde se va a guardar el contenido en base64.";
	    	
		}else{
			
			msgInput = "Por favor ingrese la ruta del archivo con el contenido en base64.";
			
			msgOut = "Por favor ingrese el nombre del archivo de salida.";
			
		}
		
		if(path.equals("")){
			
			log.append(msgInput);
			
			log.append("\n");
			
			JOptionPane.showMessageDialog(v, msgInput, "[ERROR] input", JOptionPane.ERROR_MESSAGE);
			statusOK = false;
		}
		
		if(nameOutput.equals("")){
			
			log.append(msgOut);
			
			log.append("\n");
			
			JOptionPane.showMessageDialog(v, msgOut, "[ERRO] output", JOptionPane.ERROR_MESSAGE);
			statusOK = false;
		}
		
		if(statusOK == true){
			
			File inputFile = new File(path);
	    	File outputFile = new File(nameOutput);
			
			if(btn.getText().equalsIgnoreCase(JVentana.TOBASE64)){
				
				log.append("Convirtiendo contenido a base 64.\n");
				
		    	Convertor.createBase64File(inputFile, outputFile);
		    	
			}else{
			
				String getContent;
				try {
					
					log.append("Convirtiendo de base64 a archivo de salida.\n");
					
					getContent = Convertor.fromFiletoString(inputFile);
					
					Convertor.toCopyFromBase64(getContent, outputFile);
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
			
			doDestroy();
	    	
		}
		
	}
	
	public void doDestroy(){
		
		log.append("Termina proceso.\n");
		
		String path = v.txtInput.getText();
		
		File before = new File(path); 
		
		File logFile = new File(before + "log" + System.currentTimeMillis() + ".log");
		
		Convertor.createFile(log.toString(), logFile);
		
		v.lblLog.setText(log.toString());
	}
	
}
