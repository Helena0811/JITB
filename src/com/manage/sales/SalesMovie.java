/*
영화별 총매출 이자 Sales의 Main Page
 */

package com.manage.sales;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.jitb.db.DBManager;


public class SalesMovie extends JPanel{
	 
	DBManager manager = DBManager.getInstance();
	Connection con;

	// panel1 : 영화 별 매출 panel (p_north, p_center, choice포함)
	// panel2 : 영화관 총 매출 panel
	private JPanel panel1, p_north, p_center, p_grid;
	private JTabbedPane tab;
	private Choice choice;
	private SalesTheater salesTheater;
	

	public SalesMovie() {

		panel1 = new JPanel();
		salesTheater = new SalesTheater();
		p_north = new JPanel();
		p_center = new JPanel();
		p_grid = new GridPanel();
		choice = new Choice();

		tab = new JTabbedPane();
		
		tab.addTab("영화별", panel1);		
		tab.addTab("영화관별", salesTheater);
		
		choice.add("상영 중");
		choice.add("과거 상영");
		choice.setPreferredSize(new Dimension(130, 30));

		p_north.setBackground(Color.pink);
		p_north.add(choice);
		p_north.setPreferredSize(new Dimension(1000, 50));

		//p_center.setBackground(Color.pink);
		//p_center.add(p_grid);
		p_grid.setPreferredSize(new Dimension(1000, 650));

		panel1.add(p_north, BorderLayout.NORTH);
		panel1.add(p_grid, BorderLayout.CENTER);
		panel1.setPreferredSize(new Dimension(1000, 700));
		
		add(tab);

		init();
		
		setLayout(new FlowLayout());
		setSize(1000, 650);
		setVisible(true);
	}
	
	public void init() {
		con = manager.getConnect();
		((GridPanel)p_grid).setConnection(con);
	}

	public static void main(String[] args) {
		new SalesMovie();
	}
}
