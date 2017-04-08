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

public class SalesMovie extends JFrame{

	// p_content : ������+choice�� �� ��� ��ü �г�
	// p_north : choice�� ���� �г�
	// p_center : ���빰�� �� �г�
	private JPanel p_content, p_north, p_center;
	private JTabbedPane tab;
	private Choice choice;
	private GridPanel p_grid;

	public SalesMovie() {

		p_content = new JPanel();
		p_north = new JPanel();
		p_center = new JPanel();
		choice = new Choice();

		tab = new JTabbedPane();
		
		tab.addTab("��ȭ��", p_content);
		tab.setMnemonicAt(0, KeyEvent.VK_1);
		
		tab.addTab("��ȭ����", p_grid);
		tab.setMnemonicAt(0, KeyEvent.VK_1);

		choice.add("�� ��");
		choice.add("���� ��");
		choice.setPreferredSize(new Dimension(130, 30));

		p_north.setBackground(Color.pink);
		p_north.add(choice);
		p_north.setPreferredSize(new Dimension(1000, 50));

		p_center.setBackground(Color.gray);

		p_content.add(p_north, BorderLayout.NORTH);
		p_content.add(p_center, BorderLayout.CENTER);
		p_content.setPreferredSize(new Dimension(1000, 600));
		add(tab);
		
		setLayout(new FlowLayout());
		setSize(1000, 650);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SalesMovie();
	}
}
