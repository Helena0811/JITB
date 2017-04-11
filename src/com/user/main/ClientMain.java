package com.user.main;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jitb.db.DBManager;
import com.user.main.purchase.ConfirmScreen;
import com.user.main.purchase.DiscountChoiceScreen;
import com.user.main.purchase.MenuChoiceScreen;
import com.user.main.purchase.PaymentChoiceScreen;
import com.user.main.purchase.advance.NoTicketScreen;
import com.user.main.purchase.advance.NumberCheckScreen;
import com.user.main.purchase.combo.ComboChoiceScreen;
import com.user.main.purchase.combo.GifticonChoiceScreen;
import com.user.main.purchase.combo.OptionChoiceScreen;
import com.user.main.purchase.ticket.MovieChoiceScreen;
import com.user.main.purchase.ticket.PersonsChoiceScreen;
import com.user.main.purchase.ticket.SeatsChoiceScreen;

public class ClientMain extends JFrame{
	private DBManager manager;
	private Connection con;
	private ArrayList<JPanel> screen;
	
	/*
	 * 생성자
	 * - 모든 화면 스크린 패널 생성
	 */
	public ClientMain() {
		setLayout(new FlowLayout());
		
		init();
		
		//index=0
		screen.add(new InitScreen(this));
		//index=1
		screen.add(new MenuChoiceScreen(this));
		//index=2
		screen.add(new NumberCheckScreen(this));
		//index=3
		screen.add(new NoTicketScreen(this));
		screen.add(new MovieChoiceScreen(this));
		screen.add(new PersonsChoiceScreen(this));
		screen.add(new SeatsChoiceScreen(this));
		screen.add(new ComboChoiceScreen(this));
		screen.add(new GifticonChoiceScreen(this));
		screen.add(new OptionChoiceScreen(this));
		screen.add(new ConfirmScreen(this));
		screen.add(new DiscountChoiceScreen(this));
		screen.add(new PaymentChoiceScreen(this));
		
		for(int i=0; i<screen.size(); i++){
			add(screen.get(i));
		}
		
		setPage(0);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				manager.disConnect(con);
				System.exit(0);
			}
		});
		setSize(800, 1200);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/*
	 * void init()
	 * - 데이터베이스 객체를 가져옴
	 * - 전체 스크린을 담기 위한 ArrayList배열 생성
	 */
	public void init(){
		manager = DBManager.getInstance();
		con = manager.getConnect();
		
		screen = new ArrayList<JPanel>();
	}
	
	/*
	 * void setPage(int index)
	 * - 파라미터 값으로 받은 index 페이지로 화면 전환
	 */
	public void setPage(int index){
		for(int i=0; i<screen.size(); i++){
			if(i == index){
				screen.get(i).setVisible(true);
			}else{
				screen.get(i).setVisible(false);
			}
		}
	}
	
	/*
	 * 실행부
	 */
	public static void main(String[] args){
		new ClientMain();
	}
}
