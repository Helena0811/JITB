package com.manage.sales;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MovieItem extends JPanel{

	Canvas can;
	JLabel la_sales, la_booking;
	
	public MovieItem(Image poster, String sales, String booking) {
		
		can = new Canvas(){
			public void paint(Graphics g) {
				//이 img들은 반복문 돌려서 받아온다.
				g.drawImage(poster, 0, 0, 120, 120, this);
			}
		};
		
		//판매율/방문자수??
		la_sales = new JLabel("평균 매출 : "+ sales+" 원 \n");
		la_booking = new JLabel("평균 예매 : " +booking+" 건");
	
		add(can);
		add(la_sales);
		add(la_booking);
		
		can.setPreferredSize(new Dimension(120, 120));
		setPreferredSize(new Dimension(120, 180));
		
	}

}
