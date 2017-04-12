package com.manage.sales;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;

import javax.swing.JPanel;

public class MonthlySales extends JPanel{
	
	private Connection con;

	public MonthlySales() {
		this.setVisible(true);
		this.setBackground(Color.GREEN);
		setPreferredSize(new Dimension(1000, 650));
	}
	
	public void setConnection(Connection con) {
		this.con=con;
	}


}
