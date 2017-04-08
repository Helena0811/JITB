package com.user.main.purchase.advance;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class NumButton extends JPanel{
	int num;
	String str;
	
	/*
	 * ������
	 * - �������̵�
	 * - ���ڳ� ���ڸ� ����
	 */
	public NumButton(int num) {
		this.num = num;
	}
	
	public NumButton(String str) {
		this.str = str;
	}
	
	/*
	 * void paintComponent(Graphics g)
	 * - �������̵�
	 * - �гο� ���ڳ� ���ڸ� �ֱ� ���� �޼���
	 */
	@Override
	protected void paintComponent(Graphics g) {
		URL url = getClass().getResource("/circleBtn.png");
		Image img;
		try {
			img = ImageIO.read(url);
			g.drawImage(img, 0, 0, 50, 50, this);
			g.setFont(new Font("default", Font.BOLD, 30));
			if(str == null){
				g.drawString(Integer.toString(num), 18, 33);
			}else{
				g.drawString(str, 18, 33);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
