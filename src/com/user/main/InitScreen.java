/*
 * 화면을 터치하세요 첫번째 창
 */
package com.user.main;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.user.frame.ScreenFrame;

public class InitScreen extends ScreenFrame implements ActionListener {

	private JButton next;
	Image img;

	Canvas can;
	Toolkit kit;

	JPanel panel;
	JButton bt;

	public InitScreen(ClientMain main) {
		super(main);

		next = new JButton("다음 페이지");
		next.addActionListener(this);

		add(next);

//		can = new Canvas();
//		panel = new JPanel();
//		bt = new JButton("화면을 터치하세요");
//		// bt_poster=new JButton(new ImageIcon("C:/project
//		// workspace/JITB/res/pt.jpg"));
//
//		// panel.add(bt_poster,BorderLayout.CENTER);
//		panel.add(bt, BorderLayout.CENTER);
//		
//		add(bt);
//		add(can);
//		
//		URL url = getClass().getResource("/touch.png");
//		URL url2 = getClass().getResource("/pt.png");
//
//		try {
//			img = ImageIO.read(url);
//			img = ImageIO.read(url2);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		can = new Canvas(){
//		      
//			@Override
//		      public void paint(Graphics g) {
//		         g.drawImage(img, 0, 0, 50, 50, this);
//			
//		      }
//		   };
//		can.setPreferredSize(new Dimension(50,50));
//		JFrame frame = new JFrame();
//		frame.setSize(300, 300);
//		JLabel label = new JLabel(new ImageIcon(img));
//		frame.add(label);
//		frame.setVisible(true);
//
//		bt.setFocusPainted(false);
//		bt.setBorderPainted(false);
//		bt.setContentAreaFilled(false);

		setSize(450, 700);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == next) {
			main.setPage(1);
		}
	}
}
