package com.user.main.purchase.advance;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.user.frame.ScreenFrame;
import com.user.main.Main;

public class NumberCheckScreen extends ScreenFrame {
	JPanel p_north;
	JPanel p_center;
	Canvas bt_bookingNum;
	Canvas bt_birthPhone;
	BookingNumPanel bn;
	BirthPhonePanel bpn;
	
	Image img;
	boolean flag = false;
	
	public NumberCheckScreen(Main main) {
		super(main);
		setLayout(new BorderLayout());
		
		p_north = new JPanel();
		p_center = new JPanel();
		
		setImg("/white_line.png");
		bt_bookingNum = new Canvas(){
			@Override
			public void paint(Graphics g) {
				g.drawImage(img, 0, -20, 300, 100, this);
				g.setColor(Color.WHITE);
				g.setFont(new Font("Malgun Gothic", Font.BOLD, 25));
				g.drawString("예매번호", 100, 50);
			}
		};
		
		bt_birthPhone = new Canvas(){
			@Override
			public void paint(Graphics g) {
				if(flag == false){
					setImg("/black_line.png");
					flag = true;
				}
				g.drawImage(img, 0, -20, 300, 100, this);
				g.setColor(Color.WHITE);
				g.setFont(new Font("Malgun Gothic", Font.BOLD, 25));
				g.drawString("생년월일+휴대폰번호", 30, 50);
			}
		};
		
		bn = new BookingNumPanel();
		bpn = new BirthPhonePanel();
		
		bt_bookingNum.setPreferredSize(new Dimension(300, 100));
		bt_birthPhone.setPreferredSize(new Dimension(300, 100));
		bn.setPreferredSize(new Dimension(800, 1100));
		bpn.setPreferredSize(new Dimension(800, 1100));
		
		p_north.setBackground(Color.BLACK);
		p_center.setBackground(Color.BLACK);
		bn.setBackground(Color.BLACK);
		bpn.setBackground(Color.BLACK);
		
		p_north.add(bt_bookingNum);
		p_north.add(bt_birthPhone);
		p_center.add(bn);
		p_center.add(bpn);
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		bt_bookingNum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClickBookingNum();
			}
		});
		
		bt_birthPhone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClickBirthPhone();
			}
		});
	}
	
	public void setImg(String src){
		URL url = getClass().getResource(src);
		try {
			img = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ClickBookingNum(){
		setImg("/white_line.png");
		bt_bookingNum.repaint();
	}
	
	public void ClickBirthPhone(){
		setImg("/black_line.png");
		bt_bookingNum.repaint();
	}
}
