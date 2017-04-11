package com.manage.sales;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Sales extends JPanel {

	JTabbedPane tab;
	JComponent movie;
	JComponent theater;

	SalesMain salesMovie;
	SalesTheater salesTheater;

	public Sales() {

		tab = new JTabbedPane();
		salesMovie = new SalesMain();
		salesTheater = new SalesTheater();

		tab.addTab("영화별", salesMovie);
		tab.addTab("영화관별", salesTheater);

		add(tab);
		tab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		setVisible(false);

	}
	
	protected JComponent makeInnerPanel(JPanel subPanel){
		JPanel panel=new JPanel(false);
		panel.setLayout(new BorderLayout());
		panel.add(subPanel);
		panel.setPreferredSize(new Dimension(1000, 750));
		return panel;
	}
}

