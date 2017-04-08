package com.manage.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.manage.movie.Movie;

public class Main extends JFrame implements ActionListener{
	JPanel p_north, p_content;
	//JButton bt_home, bt_movie, bt_inventory, bt_discount, bt_sales;
	
	// �޴��� ���� ���� ��ư �迭�� ����
	JButton[] menu=new JButton[5];
	
	// �޴� �̸� �迭�� ����
	String[] title={"Ȩ","��ȭ ����","��� ����","���� ����","���� ����"};
	
	// �� �޴� �г�(���⿡ ���� ���� �г��� �������ֽø� �˴ϴ�!)
	Movie movie;
	
	// �޴��� ���� ���� ������ �迭�� ����
	JPanel[] page=new JPanel[5];
	
	public Main() {
		p_north=new JPanel();
		p_content=new JPanel();
		
		/*
		bt_home=new JButton("home");
		bt_movie=new JButton("movie");
		bt_inventory=new JButton("inventory");
		bt_discount=new JButton("discount");
		bt_sales=new JButton("sales");
		*/
		
		// ��ư ���� ����� �����ϱ� �����Ƽ� �����ð��� �ߴ� ��� �迭�� ����
		for(int i=0; i<menu.length; i++){
			menu[i]=new JButton(title[i]);
			p_north.add(menu[i]);
			menu[i].addActionListener(this);
		}
		
		/*
		p_north.add(bt_home, BorderLayout.NORTH);
		p_north.add(bt_movie, BorderLayout.NORTH);
		p_north.add(bt_inventory, BorderLayout.NORTH);
		p_north.add(bt_discount, BorderLayout.NORTH);
		p_north.add(bt_sales, BorderLayout.NORTH);
		*/
		
		p_north.setSize(1000, 40);
		
		// ���� ���� �г��� page��ȣ�� �°� �ٿ��ּ���!
		/*
		 * 0 : Ȩ
		 * 1 : ��ȭ/�� ����
		 * 2 : ��� ����
		 * 3 : ���� ����
		 * 4 : ���� ����
		 * */
		page[1]=new Movie();
		
		// Movie Panel ����
		p_content.add(page[1]);
		
		// JTabbedPane�� ����ϱ� ���� GridLayout 1��1�� ���
		p_content.setLayout(new GridLayout(1,1));
		
		// �׳� �г� ���̴� ������ �� ���Ͻö�� ���� �÷������
		p_content.setBackground(Color.pink);
		
		add(p_north,BorderLayout.NORTH);
		add(p_content);
		
		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}

	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		JButton bt=(JButton)obj;
		
		// ������϶� �࿭���� �г� �� ���̸� �ؿ� �ڵ� ����� �̰� Ǯ���ּ���!
		// �Ʒ� �ڵ�� ���� �г��� �� �ٿ����� �ʾƼ� for���� �������淡 �������� �ڵ��Դϴ٤Ф�
		/*
		for(int i=0; i<page.length; i++){
			if(bt==menu[i]){
				page[i].setVisible(true);
			}
			else{
				page[i].setVisible(false);
			}
		}
		*/
		if(bt==menu[1]){
			System.out.println("����");
			page[1].setVisible(true);
		}
		else{
			page[1].setVisible(false);
		}
	}

	public static void main(String[] args) {
		new Main();
		
		

	}

}
