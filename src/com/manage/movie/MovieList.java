package com.manage.movie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jitb.db.DBManager;

// 영화 목록 레이아웃
public class MovieList extends JPanel implements ActionListener{

	JPanel p_north, p_content;
	JLabel lb_title;
	JButton bt_add;
	
	AddMovie addMovie;
	
	JDesktopPane desktop=new JDesktopPane();
	
	
	DBManager manager;
	Connection con;
	
	// 현재 존재하는 영화를 담아놓을 collection framework
	ArrayList<JPanel> movieList=new ArrayList<JPanel>();
	
	// innerFrame이 켜져있는 상태면 추가 버튼 비활성화
	boolean inner=false;
	
	public MovieList() {
	
		p_north=new JPanel();
		p_content=new JPanel();
		lb_title=new JLabel("영화 목록");
		bt_add=new JButton("추가");
		
		p_north.setLayout(new BorderLayout());
		p_north.add(lb_title, BorderLayout.WEST);
		p_north.add(bt_add, BorderLayout.EAST);
		
		//p_content.setBackground(Color.CYAN);
		p_content.setLayout(new BorderLayout());
		
		bt_add.addActionListener(this);
		
		setLayout(new BorderLayout());
		add(p_north,BorderLayout.NORTH);
		add(p_content);
		
		setBackground(Color.red);
		
		// DB 연결
		connect();
		
		// 영화 가져오기
		getMovieList();
	}
	
	// DB 연결
	public void connect(){
		manager=DBManager.getInstance();
		con=manager.getConnect();
	}
	
	// 현재 존재하는 영화를 DB에서 가져오기
	public void getMovieList(){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	}
	
	public void makeInnerFrame(){
		//JDesktopPane desktop=new JDesktopPane();
		Dimension outerSize=this.getSize();
		
		addMovie=new AddMovie("영화 추가", true, false, true);
		//addTheater.setBounds(outerSize.width/2, outerSize.height/2, 300, 200);
		
		desktop.add(addMovie);
		
		this.p_content.add(desktop);

	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		JButton bt=(JButton)obj;
		
		// innerFrame이 생성된 적이 없으면
		if(!inner){
			// 영화 추가 버튼
			if(bt==bt_add){
				makeInnerFrame();
				System.out.println("추가 누름");
				inner=true;
			}
		}
		else{
			addMovie.setDefault();
			addMovie.setVisible(true);
		}
	}

}
