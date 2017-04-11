/*
 * 영화관 추가 클래스
 * 규칙) 영화관 이름은 무조건 1-2자리 숫자로 입력할 것!
 * 현재 상황)
 * 데이터 연동 완료
 * - 영화관 리스트를 보여주는 디자인적 구현 필요
 * */
package com.manage.movie;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jitb.db.DBManager;

// 영화관 추가 레이아웃
public class AddTheater extends JInternalFrame implements ActionListener, ItemListener{
	JPanel p_outer;
	JPanel p_title;
	JPanel p_input;
	JPanel p_content;
	JPanel p_select;
	JPanel p_button;
	
	JLabel lb_title;
	JLabel lb_name;
	JLabel lb_content;
	JLabel lb_row, lb_col;
	
	JTextField t_name;
	
	Choice ch_row, ch_col;
	
	JButton bt_cancel, bt_confirm;
	
	int row, col;
	
	// DB연동에 필요
	DBManager manager;
	Connection con;
	
	public AddTheater(String title, boolean resizable, boolean closable, boolean maximizable) {
		this.title=title;
		this.resizable=resizable;
		this.closable=closable;
		this.maximizable=maximizable;
		
		p_outer=new JPanel();
		p_title=new JPanel();
		p_input=new JPanel();
		p_content=new JPanel();
		p_select=new JPanel();
		p_button=new JPanel();
		
		lb_title=new JLabel("영화관 크기 설정");
		lb_name=new JLabel("영화관 이름 입력");
		t_name=new JTextField(10);
		lb_content=new JLabel("추가할 영화관의 행, 열을 선택해주세요.");
		
		lb_row=new JLabel("행");
		lb_col=new JLabel("열");
		
		ch_row=new Choice();
		ch_col=new Choice();
		
		bt_confirm=new JButton("확인");
		bt_cancel=new JButton("취소");
		
		for(int i=0; i<10; i++){
			ch_row.add(Integer.toString(i+1));
			ch_col.add(Integer.toString(i+1));
		}
		
		// choice와 ItemListener 연결
		ch_row.addItemListener(this);
		ch_col.addItemListener(this);
		
		p_title.add(lb_title);
		p_input.add(lb_name);
		p_input.add(t_name);
		p_content.add(lb_content);
		p_select.add(lb_row);
		p_select.add(ch_row);
		p_select.add(lb_col);
		p_select.add(ch_col);
		
		p_button.add(bt_confirm);
		
		p_outer.add(p_title);
		p_outer.add(p_input);
		p_outer.add(p_content);
		p_outer.add(p_select);
		p_outer.add(p_button);
		
		add(p_outer);
		
		bt_confirm.addActionListener(this);
		
		setBounds(370, 220, 300, 200);
		//setSize(300, 200);
		setVisible(true);
		setBackground(Color.YELLOW);
		
		// DB 연결
		connect();
	}
	
	// DB 연결
	public void connect(){
		manager=DBManager.getInstance();
		con=manager.getConnect();
	}
	
	// 설정한 관 정보 저장
	// -> theater 테이블에 데이터 저장
	public void insertTheater(){
		
		PreparedStatement pstmt=null;
		
		StringBuffer sql=new StringBuffer();
		sql.append("insert into theater(theater_id, name, row_line, column_line, branch_id, movie_id)");
		sql.append(" values(seq_theater.nextval, ?, ?, ?, 1, null)");
		
		try {
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, t_name.getText());
			pstmt.setString(2, Integer.toString(ch_row.getSelectedIndex()+1));
			pstmt.setString(3, Integer.toString(ch_col.getSelectedIndex()+1));
			
			// 성공적으로 insert문 반환시 무조건 1 반환
			int result=pstmt.executeUpdate();
			if(result!=0){
				JOptionPane.showMessageDialog(this, "영화관 추가 완료");
			}
			else{
				JOptionPane.showMessageDialog(this, "영화관 추가 실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	// choice 선택(지금 사용 안함)
	public void itemStateChanged(ItemEvent e) {
		Object obj=e.getSource();
		Choice ch=(Choice)obj;
		//int index=ch.getSelectedIndex();
		int row_index=ch_row.getSelectedIndex();
		int col_index=ch_col.getSelectedIndex();
	}

	// 확인 버튼을 누르면
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		JButton bt=(JButton)(obj);
		
		// 확인 버튼을 누르면 
		if(bt==bt_confirm){
			System.out.println("확인 누름");
			//this.setDefaultCloseOperation(AddTheater.DISPOSE_ON_CLOSE);
			
			// 영화관 이름을 제대로 입력하지 않은 경우
			if(t_name.getText().equals("")){
				JOptionPane.showMessageDialog(this, "영화관 이름을 제대로 입력해주세요.");
				return;
			}
			else{
				// 확인 버튼을 누르면 데이터가 theater 테이블에 저장되고 창 종료
				insertTheater();
			}
			
			this.dispose();
		}
		
		// 취소 버튼을 누르면
		else if(bt==bt_cancel){
			this.dispose();
		}
	}

}
