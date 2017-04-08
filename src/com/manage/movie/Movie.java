package com.manage.movie;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

// ��ȭ/�� ���� �г�
public class Movie extends JPanel{
	JTabbedPane tabbedPane;
	JComponent theater;
	JComponent movie;
	
	public Movie() {
		//super(new GridLayout(1,1));
		
		tabbedPane = new JTabbedPane();
		
		// tab���� : ��ȭ��, ���� : theater
		theater=makeTextPanel("theater");
		tabbedPane.addTab("��ȭ��", theater);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		
		movie=makeTextPanel("movie");
		tabbedPane.addTab("��ȭ", movie);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		
		add(tabbedPane);
		
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		// ����Frame�� ��ư�� Ŭ������ ���� �������� �ϹǷ� ������ false
		setVisible(false);
	}
	
	/* 
	 * JTabbedPane���� tab�� content�� ����� �޼ҵ�
	 * ����� content�ȿ� JLabel�� ��������, ���� �̰͵� JPanel�� ������ ��!
	 * */
	protected JComponent makeTextPanel(String text){
		JPanel panel=new JPanel(false);
		JLabel type=new JLabel(text);
		// label ũ�� ���� ���ϸ� �۰� ���Ϳ�! �� �������ּ��� :)
		type.setPreferredSize(new Dimension(100, 40));
		type.setHorizontalAlignment(JLabel.CENTER);
		panel.setLayout(new GridLayout(1, 1));
		panel.add(type);
		// panel ũ�� ���� ���ϸ� �۰� ���Ϳ�! �� �������ּ��� :)
		panel.setPreferredSize(new Dimension(1000, 750));
		
		return panel;
	}
	
}
