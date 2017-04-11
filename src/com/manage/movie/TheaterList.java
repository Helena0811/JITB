/*
 * 영화관 목록 출력 및 추가 클래스
 * 현재 상황)
 * getTheaterList()를 이용하여 theater 테이블 가져오는 메소드 구현중
 * */
package com.manage.movie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jitb.db.DBManager;

// 관 목록 레이아웃
public class TheaterList extends JPanel implements ActionListener{
	JPanel p_north, p_content;
	JLabel lb_title;
	JButton bt_add;
	
	AddTheater addTheater;
	
	DBManager manager;
	Connection con;
	
	// 현재 존재하는 영화관을 담아놓을 collection framework
	ArrayList<JPanel> theaterList=new ArrayList<JPanel>();
	
	public TheaterList() {
		p_north=new JPanel();
		p_content=new JPanel();
		lb_title=new JLabel("영화관 목록");
		bt_add=new JButton("추가");
		
		p_north.setLayout(new BorderLayout());
		p_north.add(lb_title, BorderLayout.WEST);
		p_north.add(bt_add, BorderLayout.EAST);
		
		p_content.setBackground(Color.CYAN);
		p_content.setLayout(new BorderLayout());
		
		bt_add.addActionListener(this);
		
		setLayout(new BorderLayout());
		add(p_north,BorderLayout.NORTH);
		add(p_content);
		
		setBackground(Color.red);
		
		// DB 연결
		connect();
				
		// 영화관 가져오기
		getTheaterList();
	}
	
	// DB 연결
		public void connect(){
			manager=DBManager.getInstance();
			con=manager.getConnect();
		}
		
	// 현재 존재하는 영화관을 DB에서 가져오기
	public void getTheaterList(){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from theater";
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				TheaterData dto=new TheaterData();
				dto.setTheater_id(rs.getInt("theater_id"));
				dto.setName(rs.getString("name"));
				dto.setRow_line(rs.getInt("row_line"));
				dto.setColumn_line(rs.getInt("column_line"));
				dto.setBranch_id(rs.getInt("branch_id"));
				dto.setMovie_id(rs.getString("movie_id"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void makeInnerFrame(){
		JDesktopPane desktop=new JDesktopPane();
		
		Dimension outerSize=this.getSize();
		
		addTheater=new AddTheater("영화관 추가", true, true, true);
		//addTheater.setBounds(outerSize.width/2, outerSize.height/2, 300, 200);
		
		desktop.add(addTheater);
		
		this.p_content.add(desktop);

	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		JButton bt=(JButton)obj;
		
		// 영화관 추가 버튼
		if(bt==bt_add){
			makeInnerFrame();
		}
	}
}
