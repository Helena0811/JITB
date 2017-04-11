package com.manage.inventory;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Add_combo extends JFrame{
	JButton bt;
	public Add_combo() {
		bt=new JButton("test");
		setBackground(Color.RED);
		
		bt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Add_top add=new Add_top();
			}
		});
		add(bt);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		new Add_combo();
	}
}
