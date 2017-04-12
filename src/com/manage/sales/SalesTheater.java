/*
영화관 총 매출
 */
package com.manage.sales;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class SalesTheater extends JPanel implements ItemListener{
	
	private JPanel p_north, p_center, p_content;
	private JPanel p_daily, p_weekly, p_monthly;
	private Choice choice;

	public SalesTheater() {
		
		p_north = new JPanel();
		p_center = new JPanel();
		p_content = new JPanel();
		
		p_daily = new DailySales();
		p_weekly = new WeeklySales();
		p_monthly = new MonthlySales();
		
		choice = new Choice();
		choice.add("Daily, 일 별");
		choice.add("Weekly, 주 별");
		choice.add("Monthly, 월 별");
		choice.setPreferredSize(new Dimension(130, 30));
		
		p_north.setBackground(Color.pink);
		p_north.add(choice);
		p_north.setPreferredSize(new Dimension(1000, 50));

		p_center.setBackground(Color.ORANGE);
		p_center.setPreferredSize(new Dimension(1000, 650));
		
		p_content.add(p_north, BorderLayout.NORTH);
		p_content.add(p_center, BorderLayout.CENTER);
		p_content.setPreferredSize(new Dimension(1000, 700));		
		add(p_content);
		
		choice.addItemListener(this);
		
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(1000, 650);
	
	}
	
	//일별, 주별, 월별 선택 choice
	public void itemStateChanged(ItemEvent e) {
		int index = choice.getSelectedIndex();
		System.out.println(index);
		
		if(index==1) {
			p_daily.setVisible(true);	
			p_weekly.setVisible(false);
			p_monthly.setVisible(false);
		} else if(index==2) {
			p_weekly.setVisible(true);
			p_daily.setVisible(false);
			p_monthly.setVisible(false);
		} else {
			p_monthly.setVisible(true);
			p_daily.setVisible(false);	
			p_weekly.setVisible(false);
		}
		
	}
	
	
	public static void main(String[] args) {
		new SalesTheater();
	}



}
