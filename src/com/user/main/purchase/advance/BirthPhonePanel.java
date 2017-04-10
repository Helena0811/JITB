package com.user.main.purchase.advance;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class BirthPhonePanel extends JPanel{
	JPanel p_pilot;
	JTextField t_birth;
	JPanel p_phone;
	JTextField t_init;
	JTextField t_phone;
	JPanel p_label;
	JLabel la_detail1, la_detail2;
	JPanel p_grid;
	
	public BirthPhonePanel() {
		String str1 = "법정생년월일(6자)과 휴대폰 뒷자리(7~8자)를 입력해주세요.\n";
		String str2 = "비회원으로 예매한 고객님께서는 예매번호로 조회해주세요.";
		
		p_pilot = new JPanel();
		t_birth = new JTextField("생년월일(6자)"){
			@Override
			public void setBorder(Border border) {}
		};
		p_phone = new JPanel();
		t_init = new JTextField("01X"){
			@Override
			public void setBorder(Border border) {}
		};
		t_phone = new JTextField("뒷 자리(7~8자)"){
			@Override
			public void setBorder(Border border) {}
		};
		p_label = new JPanel();
		la_detail1 = new JLabel(str1);
		la_detail2 = new JLabel(str2);
		p_grid = new JPanel(new GridLayout(4, 3));
		
		t_birth.setFont(new Font("Malgun Gothic", Font.BOLD, 50));
		t_birth.setForeground(Color.WHITE);
		t_birth.setBackground(new Color(33,33,33));
		t_init.setFont(new Font("Malgun Gothic", Font.BOLD, 50));
		t_init.setForeground(Color.WHITE);
		t_init.setBackground(new Color(33,33,33));
		t_phone.setFont(new Font("Malgun Gothic", Font.BOLD, 50));
		t_phone.setForeground(Color.WHITE);
		t_phone.setBackground(new Color(33,33,33));
		la_detail1.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
		la_detail1.setForeground(Color.WHITE);
		la_detail2.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
		la_detail2.setForeground(Color.WHITE);
		
		p_phone.setBackground(new Color(33,33,33));
		p_label.setBackground(new Color(33,33,33));
		p_pilot.setBackground(new Color(33,33,33));
		
		t_init.setPreferredSize(new Dimension(100, 100));
		t_phone.setPreferredSize(new Dimension(450, 100));
		t_birth.setPreferredSize(new Dimension(575, 100));
		p_phone.setPreferredSize(new Dimension(600, 100));
		p_label.setPreferredSize(new Dimension(600, 130));
		p_grid.setPreferredSize(new Dimension(300, 500));
		p_pilot.setPreferredSize(new Dimension(600, 900));
		
		p_phone.add(t_init);
		p_phone.add(t_phone);
		p_label.add(la_detail1);
		p_label.add(la_detail2);
		
		p_pilot.add(t_birth);
		p_pilot.add(p_phone);
		p_pilot.add(p_label);
		p_pilot.add(p_grid);
		
		add(p_pilot);
		
		setBackground(new Color(33,33,33));
		setVisible(false);
	}
}
