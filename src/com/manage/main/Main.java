package com.manage.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.manage.inventory.InventoryMain;
import com.manage.movie.Movie;
import com.manage.sales.SalesMain;


public class Main extends JFrame implements ActionListener{
	JPanel p_north, p_content;
	//JButton bt_home, bt_movie, , bt_sales;
	JButton bt_inventory, bt_discount;
	// 메뉴에 따른 여러 버튼 배열로 저장
	JButton[] menu=new JButton[5];
	
	// 메뉴 이름 배열로 저장
	String[] title={"홈","영화 관리","재고 관리","할인 관리","매출 관리"};
	
	// 각 메뉴 패널(여기에 각자 만든 패널을 가져와주시면 됩니다!)
	Movie movie;
	SalesMain salesMain;
	
	// 메뉴에 따른 여러 페이지 배열로 저장
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
		
		// 버튼 따로 만들면 관리하기 귀찮아서 수업시간에 했던 대로 배열로 저장
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
		
		// 각자 만든 패널을 page번호에 맞게 붙여주세요!
		/*
		 * 0 : 홈
		 * 1 : 영화/관 관리
		 * 2 : 재고 관리
		 * 3 : 할인 관리
		 * 4 : 매출 관리
		 * */
		page[1]=new Movie();
		page[2]=new InventoryMain();
		page[4]=new SalesMain();
		
		// Movie Panel 부착
		p_content.add(page[1]);
		p_content.add(page[2]);
		p_content.add(page[4]);
		
		// JTabbedPane을 사용하기 위해 GridLayout 1행1열 사용
		// Grid 사용하니까 화면이 2개다 보여서 Grid 지웠습니다.
		//p_content.setLayout(new GridLayout(1,1));
		
		// 그냥 패널 붙이는 실험할 때 편하시라고 배경색 올려놨어용
		p_content.setBackground(Color.pink);
		
		add(p_north,BorderLayout.NORTH);
		add(p_content);
		
		setSize(1200,800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		//초기화면 세팅
		page[1].setVisible(false);
		page[2].setVisible(false);
		page[4].setVisible(false);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		JButton bt=(JButton)obj;
		
		// 지혜언니랑 긍열오빠 패널 다 붙이면 밑에 코드 지우고 이거 풀어주세요!
		// 아래 코드는 아직 패널이 다 붙여지지 않아서 for문을 못돌리길래 만들어놓은 코드입니다ㅠㅠ
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
			System.out.println("Movie 누름");
			page[1].setVisible(true);
			page[2].setVisible(false);
			page[4].setVisible(false);
		}else if(bt==menu[2]){
			System.out.println("재고 누름");
			page[1].setVisible(false);
			page[2].setVisible(true);
			page[4].setVisible(false);
		}
		else if(bt==menu[4]) {
			System.out.println("Sales 누름");			
			page[1].setVisible(false);
			page[2].setVisible(false);
			page[4].setVisible(true);
			
		}
		else{
			page[1].setVisible(false);
			page[2].setVisible(false);
			page[4].setVisible(false);
		}
	}

	public static void main(String[] args) {
		new Main();	
	}

}
