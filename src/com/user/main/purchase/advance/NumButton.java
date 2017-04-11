package com.user.main.purchase.advance;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;

public class NumButton extends Canvas{
	Image img;
	int index;
	
	public NumButton(Image img, int index) {
		this.img = img;
		this.index = index;
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, 50, 50, this);
	}
}
