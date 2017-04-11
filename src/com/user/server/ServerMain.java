package com.user.server;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerMain extends JFrame implements ActionListener, Runnable{
	JPanel p_north;
	JLabel label;
	JTextField t_port;
	JButton bt_start;
	JTextArea console;
	JScrollPane scroll;
	
	int port = 7777;
	ServerSocket server;
	
	Thread thread;
	Vector<ServerThread> stArr = new Vector<ServerThread>();
	
	public ServerMain() {
		p_north = new JPanel();
		label = new JLabel("포트번호");
		t_port = new JTextField(5);
		bt_start = new JButton("서버 가동");
		
		console = new JTextArea();
		scroll = new JScrollPane(console);
		
		t_port.setText(Integer.toString(port));
		
		bt_start.setBackground(Color.YELLOW);
		p_north.setBackground(Color.WHITE);
		console.setFont(new Font("dotum", Font.PLAIN, 25));
		console.setBackground(Color.BLACK);
		console.setForeground(Color.WHITE);
		
		p_north.add(label);
		p_north.add(t_port);
		p_north.add(bt_start);
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		bt_start.addActionListener(this);
		
		setTitle("server");
		setSize(600, 800);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void connect(){
		port = Integer.parseInt(t_port.getText());
		
		try {
			server = new ServerSocket(port);
			console.setText("Operation port "+port+" ...\n");
			
			while(true){
				Socket socket = server.accept();
				String ip = socket.getInetAddress().getHostAddress();
				console.setText("Connect IP "+ip+" (total xx)");
				ServerThread st = new ServerThread(socket, this);
				st.start();
				stArr.add(st);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		connect();
	}
	
	public static void main(String[] args) {
		new ServerMain();
	}
}
