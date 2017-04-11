package com.manage.movie;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
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

// ��ȭ �߰� ���̾ƿ�
public class AddMovie extends JInternalFrame{
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
	
	JButton bt_confirm;
	
	Toolkit kit=Toolkit.getDefaultToolkit();
	Image img;
	
	File file;
	JFileChooser chooser;
	
	// Date Picker
	private Stage stage;
    private DatePicker checkInDatePicker;
    private DatePicker checkOutDatePicker;
    
    // DB ����
    DBManager manager;
    Connection con;
 
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
		
		// ������ ���
		can=new Canvas(){
			
			public void paint(Graphics g) {
				// ������ ���̱�
				g.drawImage(img, 0, 0, 100, 100, this);
			}
		};
		
		can.setPreferredSize(new Dimension(250, 300));
		can.setBounds(0, 0, 250, 300);
		
		chooser=new JFileChooser("C:/Users/user/Pictures/AC3");
		
		can.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				getPoster();
			}
		});
		
		p_outer=new JPanel();
		p_date=new JFXPanel();
		lb_title=new JLabel("��ȭ �̸�");
		lb_director=new JLabel("��ȭ ����");
		lb_actor=new JLabel("�ֿ� ���");
		lb_start_date=new JLabel("���� ����");
		lb_end_date=new JLabel("���� ����");
		lb_run_time=new JLabel("�� �ð�");
		
		t_title=new JTextField(15);
		t_director=new JTextField(15);
		t_actor=new JTextField(15);
		ta_story=new JTextArea(20,5);
		t_run_time=new JTextField(10);
		
		bt_confirm=new JButton("Ȯ��");
		
		/*
		p_outer.setPreferredSize(new Dimension(500, 600));
		p_outer.add(can);
		p_outer.add(lb_title);
		p_outer.add(t_title);
		p_outer.add(lb_director);
		p_outer.add(t_director);
		p_outer.add(lb_actor);
		p_outer.add(t_actor);
		p_outer.add(lb_start_date);
		// Date picker
		p_outer.add(lb_end_date);
		// Date picker
		p_outer.add(lb_run_time);
		p_outer.add(t_run_time);
		p_outer.add(bt_confirm);
		
		add(p_outer);
		*/
		createCalendar();
		//add(can);
		
		p_date.setLayout(new GridLayout(1, 2));
		p_outer.add(can);
		p_outer.add(lb_title);
		p_outer.add(t_title);
		p_outer.add(lb_director);
		p_outer.add(t_director);
		p_outer.add(lb_actor);
		p_outer.add(t_actor);
		//p_outer.add(lb_start_date);
		// Date picker
		//p_outer.add(lb_end_date);
		// Date picker
		p_outer.add(p_date);
		p_outer.add(lb_run_time);
		p_outer.add(t_run_time);
		p_outer.add(bt_confirm);
		
		add(p_outer);
		//add(p_date, BorderLayout.SOUTH);
		
		
		setBounds(250, 50, 500, 600);
		setVisible(true);
		
		// DB ����
		connect();
	}
	
	// DB ����
	public void connect(){
		
	}
	
	// ������ ��ȭ ���� ����
	// -> movie ���̺� ������ ����
	public void putData(){
		
	}
	
	// �̹��� ������ ��������, movie���̺��� poster�� ����
	public void getPoster(){
		int result=chooser.showOpenDialog(this);
		if(result==JFileChooser.APPROVE_OPTION){
			file=chooser.getSelectedFile();
			img=kit.getImage(file.getAbsolutePath());
			can.repaint();
		}
	}
	
	public void createCalendar(){
		Group root=new Group();
		//VBox root=new VBox(20);
		Scene scene=new Scene(root,337,50);
        checkInDatePicker = new DatePicker();
        checkOutDatePicker = new DatePicker();
        checkInDatePicker.setValue(LocalDate.now());
        checkOutDatePicker.setValue(checkInDatePicker.getValue().plusDays(1));
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        Label checkInlabel = new Label("���� ����");
        gridPane.add(checkInlabel, 0, 0);
        GridPane.setHalignment(checkInlabel, HPos.LEFT);
        gridPane.add(checkInDatePicker, 0, 1);
        Label checkOutlabel = new Label("���� ����");
        gridPane.add(checkOutlabel, 1, 0);
        GridPane.setHalignment(checkOutlabel, HPos.RIGHT);
        gridPane.add(checkOutDatePicker, 1, 1);
        root.getChildren().add(gridPane);
        p_date.setScene(scene);
	}
	
}
