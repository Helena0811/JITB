/*
영화관 총 매출
 */
package com.manage.sales;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SalesTheater extends JFrame{
	
	JPanel p_center;
	
	public SalesTheater() {
		p_center = new JPanel();
		p_center.setBackground(Color.yellow);
		add(p_center);
		
		setVisible(true);
		setSize(1000,650);
	}
	
	public static void main(String[] args) {
		new SalesTheater();
		
	}

}
