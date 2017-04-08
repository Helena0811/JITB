package com.user.main.purchase.advance;

import java.awt.BorderLayout;
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


public class NumberCheckScreen extends ScreenFrame{
	JPanel p_north;
	JPanel p_center;
	
	JPanel bt_bookingNum;
	JPanel bt_birthPhone;
	
	BookingNumPanel bookingNum;
	BirthPhonePanel birthPhone;
	
	/*
	 * 생성자
	 * - 예매 확인 패널로 넘어가는 버튼 용도 패널 생성
	 * - 생년월일+휴대폰번호 확인 패널로 넘어가는 버튼 용도 패널 생성
	 * - 예매 확인 패널 생성
	 * - 생년월일+휴대폰번호 확인 패널 생성
	 */
	public NumberCheckScreen(Main main) {
		super(main);
		
		p_north = new JPanel();
		p_center = new JPanel();
		bookingNum = new BookingNumPanel();
		birthPhone = new BirthPhonePanel();
		
		bt_bookingNum = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				URL url = getClass().getResource("/yellowBtn.png");
				Image img;
				try {
					img = ImageIO.read(url);
					g.drawImage(img, 0, 0, 400, 100, this);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				g.setFont(new Font("defalut", Font.BOLD, 30));
				g.drawString("예매번호", 130, 60);
			}
		};
		
		bt_birthPhone = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				URL url = getClass().getResource("/yellowBtn.png");
				Image img;
				try {
					img = ImageIO.read(url);
					g.drawImage(img, 0, 0, 400, 90, this);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				g.setFont(new Font("defalut", Font.BOLD, 30));
				g.drawString("생년월일 + 휴대폰번호", 40, 55);
			}
		};
		
		p_north.setBackground((new Color(255, 217, 236)));
		p_center.setBackground(new Color(255, 217, 236));
		
		bt_bookingNum.setPreferredSize(new Dimension(400, 100));
		bt_birthPhone.setPreferredSize(new Dimension(400, 100));
		
		p_north.add(bt_bookingNum);
		p_north.add(bt_birthPhone);
		p_center.add(bookingNum);
		p_center.add(birthPhone);
		
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		bt_bookingNum.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				clickBookingNum();
			}
		});
		
		bt_birthPhone.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				clickBirthPhone();
			}
		});
	}
	
	/*
	 * void clickBookingNum()
	 * - 예매 확인 버튼용 패널을 누르면 예매 확인 패널이 보여짐
	 */
	public void clickBookingNum(){
		bookingNum.setVisible(true);
		birthPhone.setVisible(false);
	}
	
	/*
	 * void clickBookingNum()
	 * - 생년월일+휴대폰번호 버튼용 패널을 누르면 생년월일+휴대폰번호 확인 패널이 보여짐
	 */
	public void clickBirthPhone(){
		bookingNum.setVisible(false);
		birthPhone.setVisible(true);
	}
}
