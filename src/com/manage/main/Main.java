package com.manage.main;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame{
	JPanel p_north, p_content;
	JButton bt_home, bt_movie, bt_inventory, bt_discount, bt_sales;
	
	public Main() {
		p_north=new JPanel();
		p_content=new JPanel();
		
		bt_home=new JButton("home");
		bt_movie=new JButton("movie");
		bt_inventory=new JButton("inventory");
		bt_discount=new JButton("discount");
		bt_sales=new JButton("sales");
		
		p_north.add(bt_home, BorderLayout.NORTH);
		p_north.add(bt_movie, BorderLayout.NORTH);
		p_north.add(bt_inventory, BorderLayout.NORTH);
		p_north.add(bt_discount, BorderLayout.NORTH);
		p_north.add(bt_sales, BorderLayout.NORTH);
		
		p_north.setSize(1000, 40);
		p_content.setSize(1000, 750);
		p_content.setBackground(Color.pink);
		
		add(p_north,BorderLayout.NORTH);
		add(p_content);
		
		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	
	public static void main(String[] args) {
		new Main();

	}

}
