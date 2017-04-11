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
import com.user.main.ClientMain;

public class NumberCheckScreen extends ScreenFrame {
	JPanel p_north;
	JPanel p_center;
	Canvas bt_bookingNum;
	Canvas bt_birthPhone;
	BookingNumPanel bn;
	BirthPhonePanel bpn;
	
	Image btnImg[] = new Image[12];
	
	Image img;
	boolean flag = true;
	
	public NumberCheckScreen(ClientMain main) {
		super(main);
		setLayout(new BorderLayout());
		setBtnImg();
		
		p_north = new JPanel();
		p_center = new JPanel();
		
		bt_bookingNum = new Canvas(){
			@Override
			public void paint(Graphics g) {
				if(flag == true){
					setImg("/white_line.png");
				}else{
					setImg("/black_line.png");
				}
				g.drawImage(img, 0, -20, 300, 100, this);
				g.setColor(Color.WHITE);
				g.setFont(new Font("Malgun Gothic", Font.BOLD, 25));
				g.drawString("예매번호", 100, 50);
			}
		};
		
		bt_birthPhone = new Canvas(){
			@Override
			public void paint(Graphics g) {
				if(flag == true){
					setImg("/black_line.png");
				}else{
					setImg("/white_line.png");
				}
				g.drawImage(img, 0, -20, 300, 100, this);
				g.setColor(Color.WHITE);
				g.setFont(new Font("Malgun Gothic", Font.BOLD, 25));
				g.drawString("생년월일+휴대폰번호", 30, 50);
			}
		};
		
		bn = new BookingNumPanel(main, btnImg);
		bpn = new BirthPhonePanel(main, btnImg);
		
		bt_bookingNum.setPreferredSize(new Dimension(300, 100));
		bt_birthPhone.setPreferredSize(new Dimension(300, 100));
		bn.setPreferredSize(new Dimension(800, 1100));
		bpn.setPreferredSize(new Dimension(800, 1100));
		
		p_north.setBackground(new Color(33,33,33));
		p_center.setBackground(new Color(33,33,33));
		
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
	
	public void setBtnImg(){
		URL url[] = new URL[12];
		url[0] = getClass().getResource("/zero.png");
		url[1] = getClass().getResource("/one.png");
		url[2] = getClass().getResource("/two.png");
		url[3] = getClass().getResource("/three.png");
		url[4] = getClass().getResource("/four.png");
		url[5] = getClass().getResource("/five.png");
		url[6] = getClass().getResource("/six.png");
		url[7] = getClass().getResource("/seven.png");
		url[8] = getClass().getResource("/eight.png");
		url[9] = getClass().getResource("/nine.png");
		url[10] = getClass().getResource("/del.png");
		url[11] = getClass().getResource("/check.png");
		
		try {
			for(int i=0; i<btnImg.length; i++){
				btnImg[i] = ImageIO.read(url[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		flag = true;
		bt_bookingNum.repaint();
		bt_birthPhone.repaint();
		bn.setVisible(true);
		bpn.setVisible(false);
	}
	
	public void ClickBirthPhone(){
		flag = false;
		bt_bookingNum.repaint();
		bt_birthPhone.repaint();
		bn.setVisible(false);
		bpn.setVisible(true);
	}
}
