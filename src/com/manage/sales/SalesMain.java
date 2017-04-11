/*
영화별 총매출 이자 Sales의 Main Page
 */

package com.manage.sales;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.jitb.db.DBManager;

public class SalesMain extends JPanel implements ItemListener{
	 
	DBManager manager = DBManager.getInstance();
	Connection con;

	// panel1 : 영화 별 매출 panel (p_north, p_center, choice포함)
	// panel2 : 영화관 총 매출 panel
	private JPanel panel1, p_north, p_center;
	private JPanel  p_default, p_nowMovie, p_pastMovie;
	private JTabbedPane tab;
	private Choice choice;
	private SalesTheater salesTheater;

	public SalesMain() {

		panel1 = new JPanel();
		salesTheater = new SalesTheater();
		p_north = new JPanel();
		p_center = new JPanel();
		p_default = new DefaultMovie();
		p_nowMovie = new NowMovie();
		p_pastMovie = new PastMovie();
		
		choice = new Choice();

		tab = new JTabbedPane();

		tab.addTab("영화별", panel1);		
		tab.addTab("영화관별", salesTheater);
		
		choice.add("선택 ▼");
		choice.add("상영 중");
		choice.add("과거 상영");
		choice.setPreferredSize(new Dimension(130, 30));

		p_north.setBackground(Color.pink);
		p_north.add(choice);
		p_north.setPreferredSize(new Dimension(1000, 50));

		p_center.add(p_default);
		p_center.add(p_nowMovie);
		p_center.add(p_pastMovie);
		
		p_default.setPreferredSize(new Dimension(1000, 650));
		p_nowMovie.setPreferredSize(new Dimension(1000, 650));
		p_pastMovie.setPreferredSize(new Dimension(1000, 650));

		panel1.add(p_north, BorderLayout.NORTH);
		panel1.add(p_center, BorderLayout.CENTER);
		panel1.setPreferredSize(new Dimension(1000, 700));		
		add(tab);
		
		init();
		choice.addItemListener(this);

		setLayout(new FlowLayout());
		setSize(1000, 650);
		setVisible(true);
	}
	
	public void init() {
		con = manager.getConnect();
		((NowMovie)p_nowMovie).setConnection(con);
		((PastMovie)p_pastMovie).setConnection(con);
	}

	public void itemStateChanged(ItemEvent e) {
		int index = choice.getSelectedIndex();
		System.out.println(index);
		
		if(index==1) {
			p_nowMovie.setVisible(true);	
			p_pastMovie.setVisible(false);
			p_default.setVisible(false);
		} else if(index==2) {
			p_pastMovie.setVisible(true);
			p_nowMovie.setVisible(false);
			p_default.setVisible(false);
		} else {
			p_default.setVisible(true);
			p_nowMovie.setVisible(false);	
			p_pastMovie.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new SalesMain();
	}
}
