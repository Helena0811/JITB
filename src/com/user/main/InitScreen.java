package com.user.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.user.frame.ScreenFrame;

public class InitScreen extends ScreenFrame implements ActionListener{
	private JButton next;
	
	public InitScreen(Main main) {
		super(main);
		
		next = new JButton("다음 페이지");
		next.addActionListener(this);
		
		add(next);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == next){
			main.setPage(1);
		}
	}
}
