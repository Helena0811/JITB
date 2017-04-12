package com.manage.movie;

import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.jitb.db.DBManager;

import javafx.embed.swing.JFXPanel;
import javafx.geometry.HPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

// 영화 추가 레이아웃
public class AddMovie extends JInternalFrame implements ActionListener, FocusListener, ItemListener{
	JPanel p_outer;
	
	JFXPanel p_date;
	
	Canvas can;
	
	JLabel lb_title;
	JTextField t_title;
	JLabel lb_director;
	JTextField t_director;
	JLabel lb_actor;
	JTextField t_actor;
	JLabel story;
	JTextArea ta_story;
	JLabel lb_start_date;
	// Date Picker
	JLabel lb_end_date;
	// Date Picker
	JLabel lb_run_time;
	JTextField t_run_time;
	
	Choice ch_theater;
	
	JButton bt_confirm, bt_cancel;
	
	Toolkit kit=Toolkit.getDefaultToolkit();
	Image img;
	
	File file;
	JFileChooser chooser;
	
	// Date Picker
	private Stage stage;
    private DatePicker startDatePicker;
    private DatePicker endDatePicker;
    
    // DB 연동
    DBManager manager;
    Connection con;
    
    // textArea에 커서 올릴 때 워터마크
    boolean Flag=false;
    
    // textField default값
    String[] txtDefault={
    		"영화 제목을 입력하세요.",
    		"영화 감독을 입력하세요.",
    		"주연 배우를 입력하세요.",
    		"스토리를 입력하세요.",
    		"상영 시간을 입력하세요.",
    };
    
    JTextField[] t_input=new JTextField[5];
    
    ArrayList<TheaterData> theater=new ArrayList<TheaterData>();
 
	public AddMovie(String title, boolean resizable, boolean closable, boolean maximizable) {
		this.title=title;
		this.resizable=resizable;
		this.closable=closable;
		this.maximizable=maximizable;
		
		URL url=this.getClass().getResource("/shrek.jpg");
		
		try {
			img=ImageIO.read(url);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// 포스터 등록
		can=new Canvas(){
			
			public void paint(Graphics g) {
				// 포스터 붙이기
				g.drawImage(img, 0, 0, 200, 300, this);
			}
		};
		
		can.setPreferredSize(new Dimension(500, 300));
		can.setBounds(0, 0, 200, 300);
		
		chooser=new JFileChooser("C:/Users/user/Pictures/AC3");
		
		can.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				getPoster();
			}
		});
		
		p_outer=new JPanel();
		p_date=new JFXPanel();
		
		t_title=new JTextField(txtDefault[0],20);
		t_director=new JTextField(txtDefault[1],20);
		t_actor=new JTextField(txtDefault[2],20);
		ta_story=new JTextArea(txtDefault[3],4,20);
		t_run_time=new JTextField(txtDefault[4],20);
		ch_theater=new Choice();
		
		bt_confirm=new JButton("확인");
		bt_cancel=new JButton("취소");
		
		bt_confirm.addActionListener(this);
		bt_cancel.addActionListener(this);
		
		t_title.addFocusListener(this);
		t_director.addFocusListener(this);
		t_actor.addFocusListener(this);
		ta_story.addFocusListener(this);
		t_run_time.addFocusListener(this);
		
		createCalendar();
				
		p_date.setLayout(new GridLayout(1, 2));
		p_outer.add(can);
		p_outer.add(t_title);
		p_outer.add(t_director);
		p_outer.add(t_actor);
		p_outer.add(ta_story);
		p_outer.add(p_date);
		p_outer.add(t_run_time);
		p_outer.add(ch_theater);
		p_outer.add(bt_confirm);
		p_outer.add(bt_cancel);
		add(p_outer);
		
		setBounds(250, 50, 500, 600);
		setVisible(true);
		
		// DB 연결
		connect();
		
		// 사용 가능한 영화관 목록 가져오기
		getTheaterList();
		System.out.println(theater);
	}
	
	// DB 연결
	public void connect(){
		manager=DBManager.getInstance();
		con=manager.getConnect();
	}
	
	// 설정한 영화 정보 저장
	// -> movie 테이블에 데이터 저장
	public void insertMovie(){
		PreparedStatement pstmt=null;
		/*
		// 입력값을 변수에 저장
		String poster=file.getName();
		String title=t_title.getText();
		String director=t_director.getText();
		String actor=t_actor.getText();
		String story=ta_story.getText();
		int run_time=Integer.parseInt(t_run_time.getText());
		*/
		LocalDate start_date=startDatePicker.getValue();
		LocalDate end_date=endDatePicker.getValue();
		
		System.out.println(start_date.toString()+","+end_date.toString());
		
		// movie_id, poster, name, director, main_actor, story, start_date, end_date, run_time
		StringBuffer sql=new StringBuffer();
		sql.append("insert into movie(movie_id, poster, name, director, main_actor, story, start_date, end_date, run_time)");
		sql.append(" values(seq_movie.nextval, ?, ?, ?, ?, ?, ");
		sql.append("to_date(?,'YYYY-MM-DD'), ");
		sql.append("to_date(?,'YYYY-MM-DD'), ?)");
		
		StringBuffer sql2=new StringBuffer();
		sql2.append("update ");
		
		// 제약조건(제약조건이 좀 많아유ㅠㅠ)
		/* 1. 이미지명이 제대로 들어오고
		 * 2. 영화 이름이 null이 아니고
		 * 3. 영화 감독이 null이 아니고
		 * 4. 주연 배우가 null이 아니고
		 * 5. 스토리가 null이 아니고
		 * 6. 상영시간이 0보다 커야하고
		 * 7. 개봉일자가 종료일자보다 크면 안되고
		 * */
		//if(file.getName()!=null&&!t_title.getText().equals("")&&!t_director.getText().equals("")&&!t_actor.getText().equals("")&&!ta_story.getText().equals("")&&Integer.parseInt(t_run_time.getText())>0&&start_date.isAfter(end_date)){
			try {
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, file.getName());
				pstmt.setString(2, t_title.getText());
				pstmt.setString(3, t_director.getText());
				pstmt.setString(4, t_actor.getText());
				pstmt.setString(5, ta_story.getText());
				pstmt.setString(6, startDatePicker.getValue().toString());
				pstmt.setString(7, endDatePicker.getValue().toString());
				pstmt.setInt(8, Integer.parseInt(t_run_time.getText()));
				
				// 성공적으로 insert했다면 반환값은 1
				int result=pstmt.executeUpdate();
				if(result!=0){
					JOptionPane.showMessageDialog(this, "영화 추가 완료");
					
					// 등록 완료했으면 포스터 파일 저장
					copyPoster();
				}
				else{
					JOptionPane.showMessageDialog(this, "영화 추가 실패");
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
		//}
	/*
		else{
			JOptionPane.showMessageDialog(this, "입력값을 제대로 입력해주세요.");
		}
	*/
	}
	
	// 포스터 등록
	public void getPoster(){
		int result=chooser.showOpenDialog(this);
		if(result==JFileChooser.APPROVE_OPTION){
			file=chooser.getSelectedFile();
			img=kit.getImage(file.getAbsolutePath());
			can.repaint();
		}
	}
	
	// 영화를 등록하면 포스터 저장
	public void copyPoster(){
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		try {
			fis=new FileInputStream(file);
			fos=new FileOutputStream("/"+file.getName());
			
			byte[] b=new byte[1024];
			int flag;
			while(true){
				flag=fis.read(b);
				if(flag==-1){
					break;
				}
				fos.write(b);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	// 하나의 frame을 가지고 사용하므로 기존 값으로 항상 초기화
	public void setDefault(){
		t_title.setText(txtDefault[0]);
		t_director.setText(txtDefault[1]);
		t_actor.setText(txtDefault[2]);
		ta_story.setText(txtDefault[3]);
		t_run_time.setText(txtDefault[4]);
		//ch_theater.select(0);
		startDatePicker.setValue(LocalDate.now());
		endDatePicker.setValue(startDatePicker.getValue().plusDays(1));
		
	}
	
	public void createCalendar(){
		Group root=new Group();
		//VBox root=new VBox(20);
		Scene scene=new Scene(root,337,50);
        startDatePicker = new DatePicker();
        endDatePicker = new DatePicker();
        startDatePicker.setValue(LocalDate.now());
        endDatePicker.setValue(startDatePicker.getValue().plusDays(1));
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        Label checkInlabel = new Label("개봉 일자");
        gridPane.add(checkInlabel, 0, 0);
        GridPane.setHalignment(checkInlabel, HPos.LEFT);
        gridPane.add(startDatePicker, 0, 1);
        Label checkOutlabel = new Label("종료 일자");
        gridPane.add(checkOutlabel, 1, 0);
        GridPane.setHalignment(checkOutlabel, HPos.RIGHT);
        gridPane.add(endDatePicker, 1, 1);
        root.getChildren().add(gridPane);
        p_date.setScene(scene);
	}

	// 확인 버튼을 누르면
	public void actionPerformed(ActionEvent e) {
		JButton bt=(JButton)e.getSource();
		
		if(bt==bt_confirm){
			insertMovie();
			this.setVisible(false);
			//this.dispose();
		}
		else if(bt==bt_cancel){
			//this.dispose();
			this.setVisible(false);
		}
	}
	
	// textfield default값 구하기
	public String getTextField(int index){
		return txtDefault[index];
	}

	// 커서를 올렸을 때
	public void focusGained(FocusEvent e) {
		//JTextArea txta=(JTextArea)e.getSource();
		if(e.getComponent().equals(ta_story)){
			JTextArea txta=(JTextArea)e.getSource();
			if(txta.getText().trim().equals(txtDefault[3])){
				txta.setText("");
			}
		}
		
		else{
			JTextField txt=(JTextField)e.getSource();
			
			for(int i=0; i<5; i++){
				String value=getTextField(i);
				if(txt.getText().trim().equals(value)){
					txt.setText("");
				}
			}
		}
	}

	// 커서를 뗐을 때
	public void focusLost(FocusEvent e) {
		
		if(e.getComponent().equals(ta_story)){
			JTextArea txta=(JTextArea)e.getSource();
			
			if(txta.getText().trim().equals("")){
				txta.setText(txtDefault[3]);
			}
		}
		else{
			JTextField txt=(JTextField)e.getSource();
			
			for(int i=0; i<5; i++){
				String value=getTextField(i);
				if(txt.getText().trim().equals("")){
					txt.setText(value);
				}
			}
		}
	}
	
	// 영화관 choice 목록 가져오기
	public void getTheaterList(){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from theater where movie_id is null";
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				TheaterData theaterData=new TheaterData();
				theaterData.setTheater_id(rs.getInt("theater_id"));
				theaterData.setName(rs.getString("name"));
				theaterData.setRow_line(rs.getInt("row_line"));
				theaterData.setColumn_line(rs.getInt("column_line"));
				theaterData.setBranch_id(rs.getInt("branch_id"));
				theaterData.setMovie_id(rs.getString("movie_id"));
				
				theater.add(theaterData);
			}
			
			// 레코드 수만큼 영화관 목록 받아오기
			for(int i=0; i<theater.size(); i++){
				System.out.println(theater.get(i).getName());
				ch_theater.add(theater.get(i).getName()+"관");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 영화관에 movie_id 넘기기
	public void insertMovieID(){
		PreparedStatement pstmt;
		
	}
	
	// 관 선택 choice 구현
	public void itemStateChanged(ItemEvent e) {
		Object obj=e.getItem();
		Choice ch=(Choice)obj;
		
		int index=ch.getSelectedIndex();
		
		// 영화관을 선택하면
		if(index==ch_theater.getSelectedIndex()){
			insertMovieID();
		}
		
	}
	
}