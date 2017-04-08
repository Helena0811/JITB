package com.user.main.purchase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.user.frame.ScreenFrame;
import com.user.main.Main;

public class MenuChoiceScreen extends ScreenFrame implements ActionListener{
	JButton next;
	
	public MenuChoiceScreen(Main main) {
		super(main);
		
		next = new JButton("다음 페이지");
		next.addActionListener(this);
		
		add(next);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == next){
			main.setPage(2);
		}
	}
}
