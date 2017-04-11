package com.user.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientThread extends Thread{
	Socket socket;
	
	BufferedReader buffr;
	BufferedWriter buffw;
	
	boolean flag;
	
	public ClientThread(Socket socket) {
		this.socket = socket;
		
		flag = true;
		
		try {
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void listen(){
		//서버에서 계속 업데이트 해주는 영화 좌석정보를 계속 듣는다.
	}
	
	public void send(String msg){
		
	}
	
	@Override
	public void run() {
		while(flag){
			listen();
		}
	}
}
