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
	 * ������
	 * - �ӽ÷� ȭ���� �����ϱ� ���� �����ڷ� Ŭ�������� �����
	 * - �ӽ� ���� ����
	 * - ��ü ��ũ�� ũ�� ����
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
