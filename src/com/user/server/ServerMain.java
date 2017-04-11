package com.user.server;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ServerMain extends JFrame{
	JTextArea console;
	JScrollPane scroll;
	
	public ServerMain() {
		console = new JTextArea();
		scroll = new JScrollPane(console);
		
		console.setFont(new Font("Consolas", Font.PLAIN, 25));
		console.setBackground(Color.BLACK);
		console.setForeground(Color.WHITE);
		
		add(scroll);
		
		setTitle("server");
		setSize(600, 800);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ServerMain();
	}
}
