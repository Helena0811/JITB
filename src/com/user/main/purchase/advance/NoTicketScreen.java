package com.user.main.purchase.advance;

import java.awt.BorderLayout;
import java.awt.Canvas;
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
	JPanel p_detail;
	JPanel p_bt;
	Canvas bt_confirm;
	Canvas bt_main;
	
	public NoTicketScreen(ClientMain main) {
		super(main);
		
		p_detail = new JPanel(new BorderLayout());
		p_bt = new JPanel();
		bt_confirm = new Canvas(){
			@Override
			public void paint(Graphics g) {
				URL url = getClass().getResource("/bt_onemore.png");
				try {
					Image img = ImageIO.read(url);
					g.drawImage(img, 0, 0, 200, 100, this);
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
					g.drawImage(img, 0, 0, 200, 100, this);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		
		p_bt.add(bt_confirm);
		p_bt.add(bt_main);
		p_detail.add(p_bt, BorderLayout.SOUTH);
		add(p_detail);
		
		p_bt.setPreferredSize(new Dimension(600, 100));
		bt_confirm.setPreferredSize(new Dimension(200, 100));
		bt_main.setPreferredSize(new Dimension(200, 100));
		p_detail.setPreferredSize(new Dimension(600, 600));
		
		setVisible(true);
	}
}
