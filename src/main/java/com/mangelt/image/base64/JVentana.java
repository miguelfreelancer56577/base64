package com.mangelt.image.base64;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class JVentana extends JFrame {
	
	JTextField txtInput;
	JTextField txtOutput;
	JLabel lblPath;
	JLabel lblOutput;
	JButton btnToBase64;
	JButton btnFromBase64;
	JTextArea lblLog;
	
	StringBuilder log = new StringBuilder("Inicia pantalla de carga. \n");
	
	public static final String TOBASE64 = "to base64";
	public static final String FROMBASE64 = "from base64";
	
	public JVentana(Config config){
		super(config.getTitle());
		onCreate(config);
		onStart();
	}
	
	public void onCreate(Config config){
		getContentPane().setLayout(null);
		setBounds(config.getPositionX(), config.getPositionY(), config.getWidth(), config.getHigh());
		txtInput = new JTextField();
		lblPath = new JLabel("file input:");
		lblPath.setBounds(5, 5, 100, 20);
		txtInput.setBounds(105, 5, 200, 20);
		txtOutput = new JTextField();
		lblOutput = new JLabel("file output:");
		txtOutput = new JTextField();
		lblOutput.setBounds(5, 30, 120, 20);
		txtOutput.setBounds(125, 30, 200, 20);
		btnToBase64 = new JButton(TOBASE64);
		btnToBase64.setBounds(5, 70, 200, 40);
		btnToBase64.addActionListener(new ActionListenerSelectImpl(this));
		btnFromBase64 = new JButton(FROMBASE64);
		btnFromBase64.setBounds(5, 115, 200, 40);
		btnFromBase64.addActionListener(new ActionListenerSelectImpl(this));
		lblLog = new JTextArea(log.toString());
		lblLog.setBounds(5, 130, 200, 200);
		Border bGreyLine = BorderFactory.createLineBorder(Color.GRAY, 1, true);
		lblLog.setBorder(bGreyLine);
		JScrollPane scrollPane = new JScrollPane(lblLog);
		getContentPane().add(txtInput);
		getContentPane().add(lblPath);
		getContentPane().add(txtOutput);
		getContentPane().add(lblOutput);
		getContentPane().add(btnToBase64);
		getContentPane().add(btnFromBase64);
//		getContentPane().add(lblLog);
	}
	
	public void onStart(){
		setVisible(true);
	}
	
	
	
}
