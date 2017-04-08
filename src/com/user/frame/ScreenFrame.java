package com.user.frame;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.user.main.Main;

public class ScreenFrame extends JPanel{
	protected Main main;
	private JLabel label;
	
	/*
	 * 생성자
	 * - 임시로 화면을 구분하기 위한 구분자로 클래스명을 출력함
	 * - 임시 배경색 지정
	 * - 전체 스크린 크기 지정
	 */
	public ScreenFrame(Main main) {
		this.main = main;
		
		label = new JLabel(this.getClass().getName());
		add(label);
		
		setVisible(false);
		setBackground(new Color(255, 217, 236));
		setPreferredSize(new Dimension(800, 1200));
	}
}
