/*
Default 패널 임의로 만듬
 */
package com.manage.sales;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class DefaultMovie extends JPanel{
	
	
	public DefaultMovie() {

		this.setVisible(true);
		this.setBackground(Color.cyan);
		setPreferredSize(new Dimension(1000, 650));
	}

}
