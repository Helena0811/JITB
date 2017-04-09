/*
��ȭ�� �Ѹ��� ���� Sales�� Main Page
 */

package com.manage.sales;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class SalesMovie extends JPanel{

	// panel1 : ��ȭ �� ���� panel (p_north, p_center, choice����)
	// panel2 : ��ȭ�� �� ���� panel

	private JPanel panel1, panel2, p_north, p_center;
	private JTabbedPane tab;
	private Choice choice;

	public SalesMovie() {

		panel1 = new JPanel();
		panel2 = new JPanel();
		p_north = new JPanel();
		p_center = new JPanel();
		choice = new Choice();

		tab = new JTabbedPane();
		
		tab.addTab("��ȭ��", panel1);
		tab.setMnemonicAt(0, KeyEvent.VK_1);
		
		tab.addTab("��ȭ����", panel2);
		tab.setMnemonicAt(0, KeyEvent.VK_1);

		choice.add("�� ��");
		choice.add("���� ��");
		choice.setPreferredSize(new Dimension(130, 30));

		p_north.setBackground(Color.pink);
		p_north.add(choice);
		p_north.setPreferredSize(new Dimension(1000, 50));

		p_center.setBackground(Color.gray);

		panel1.add(p_north, BorderLayout.NORTH);
		panel1.add(p_center);
		panel1.setPreferredSize(new Dimension(1000, 700));
		add(tab);
		
		setLayout(new FlowLayout());
		setSize(1000, 650);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SalesMovie();
	}
}
