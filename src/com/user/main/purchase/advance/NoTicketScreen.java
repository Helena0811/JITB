package com.user.main.purchase.advance;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.user.frame.ScreenFrame;
import com.user.main.ClientMain;

public class NoTicketScreen extends ScreenFrame {
	JPanel no;
	JPanel p_detail;
	JPanel p_bt;
	Canvas bt_confirm;
	Canvas bt_main;
	
	public NoTicketScreen(ClientMain main) {
		super(main);
		
		no = new JPanel();
		p_detail = new JPanel(new BorderLayout()){
			@Override
			protected void paintComponent(Graphics g) {
				URL url = getClass().getResource("/noTicketMessage.png");
				try {
					Image img = ImageIO.read(url);
					g.drawImage(img, 0, 0, 527, 402, this);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		p_bt = new JPanel();
		p_bt.setOpaque(false);
		bt_confirm = new Canvas(){
			@Override
			public void paint(Graphics g) {
				URL url = getClass().getResource("/bt_confirm.png");
				try {
					Image img = ImageIO.read(url);
					g.drawImage(img, 0, 0, 135, 59, this);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		bt_main = new Canvas(){
			@Override
			public void paint(Graphics g) {
				URL url = getClass().getResource("/bt_main.png");
				try {
					Image img = ImageIO.read(url);
					g.drawImage(img, 0, 0, 135, 59, this);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		
		no.setBackground(new Color(33,33,33));
		bt_confirm.setBackground(Color.WHITE);
		bt_main.setBackground(Color.WHITE);
		
		no.setPreferredSize(new Dimension(600, 200));
		p_bt.setPreferredSize(new Dimension(400, 80));
		bt_confirm.setPreferredSize(new Dimension(135, 59));
		bt_main.setPreferredSize(new Dimension(135, 59));
		p_detail.setPreferredSize(new Dimension(527, 402));
		
		p_bt.add(bt_confirm);
		p_bt.add(bt_main);
		p_detail.add(p_bt, BorderLayout.SOUTH);
		add(no);
		add(p_detail);
		
		setVisible(true);
	}
}
