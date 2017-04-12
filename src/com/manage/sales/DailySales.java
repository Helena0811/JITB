/*
당일 별 영화관 총 매출을 보여주는 패널
 */

package com.manage.sales;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.jitb.db.DBManager;

public class DailySales extends JPanel{

	
	private JPanel p_north, p_center, p_south;
	private JLabel la_sales;
	private JTable table;
	private JScrollPane scroll;
	
	SalesTable salesTable;
	
	DBManager manager;
	Connection con;

	public DailySales(){
		
		p_north = new JPanel();
		p_center = new JPanel();
		p_south = new JPanel();
		la_sales = new JLabel();
		table = new JTable(4,4);
		scroll = new JScrollPane(table);
		
		p_south.add(la_sales);
				
		p_north.setBackground(Color.yellow);
		//p_center.setBackground(Color.blue);
		p_south.setBackground(Color.orange);
		
		//size조정
		p_north.setPreferredSize(new Dimension(1000, 50));
		p_center.setPreferredSize(new Dimension(1000, 500));
		p_south.setPreferredSize(new Dimension(1000, 100));

		//center에 붙이기
		p_center.setLayout(new BorderLayout());
		p_center.add(scroll);

		//패널들 붙이기
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		add(p_south, BorderLayout.SOUTH);
	
		setVisible(true);
		setPreferredSize(new Dimension(1000, 650));
		
		init();
		getUpList();
	}
	
	public void init() {
		manager = DBManager.getInstance();
		con = manager.getConnect();
	}
	
	public void getUpList(){
		table.setModel(salesTable = new SalesTable(con));
	}
}
