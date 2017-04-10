package com.manage.movie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JPanel;

// ��ȭ ��� ���̾ƿ�
public class MovieList extends JPanel implements ActionListener{

	JPanel p_north, p_content;
	JLabel lb_title;
	JButton bt_add;
	
	AddMovie addMovie;
	
	public MovieList() {
		p_north=new JPanel();
		p_content=new JPanel();
		lb_title=new JLabel("��ȭ ���");
		bt_add=new JButton("�߰�");
		
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
	}
	
	public void makeInnerFrame(){
		JDesktopPane desktop=new JDesktopPane();
		
		Dimension outerSize=this.getSize();
		
		addMovie=new AddMovie("��ȭ �߰�", true, true, true);
		//addTheater.setBounds(outerSize.width/2, outerSize.height/2, 300, 200);
		
		desktop.add(addMovie);
		
		this.p_content.add(desktop);

	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		JButton bt=(JButton)obj;
		
		// ��ȭ �߰� ��ư
		if(bt==bt_add){
			makeInnerFrame();
		}
	}

	
}
