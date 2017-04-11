package com.manage.inventory;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
//상품을 추가하는 패널
public class Inventory extends JPanel implements ActionListener{
	
	JTable table;
	JButton bt_add;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
	
	public Inventory() {
		table=new JTable();
		bt_add=new JButton("추가");
		
		bt_add.addActionListener(this);
		
		setBackground(Color.BLUE);
		
	}

}
