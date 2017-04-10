package com.user.main.purchase.advance;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class BookingNumPanel extends JPanel{
	JPanel p_pilot;
	JPanel p_bn;
	JTextField t_init;
	JTextField t_num;
	JPanel p_label;
	JLabel la_detail1, la_detail2, la_detail3;
	JPanel p_grid;
	
	public BookingNumPanel() {
		String str1 = "앞 4자리를 제외하고 뒤 11자리를 입력해주세요";
		String str2 = "예매번호를 모르는 고객께서는";
		String str3 = "생년월일+휴대폰번호로 조회해주세요";
		
		p_pilot = new JPanel();
		p_bn = new JPanel();
		t_init = new JTextField("0057"){
			@Override
			public void setBorder(Border border) {}
		};
		t_num = new JTextField("뒷 자리(11자)"){
			@Override
			public void setBorder(Border border) {}
		};
		p_label = new JPanel();
		la_detail1 = new JLabel(str1);
		la_detail2 = new JLabel(str2);
		la_detail3 = new JLabel(str3);
		p_grid = new JPanel(new GridLayout(4, 3));
		
		t_init.setFont(new Font("Malgun Gothic", Font.BOLD, 50));
		t_init.setForeground(Color.WHITE);
		t_init.setBackground(new Color(33,33,33));
		t_num.setFont(new Font("Malgun Gothic", Font.BOLD, 50));
		t_num.setForeground(Color.WHITE);
		t_num.setBackground(new Color(33,33,33));
		la_detail1.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
		la_detail1.setForeground(Color.WHITE);
		la_detail2.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
		la_detail2.setForeground(Color.WHITE);
		la_detail3.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
		la_detail3.setForeground(Color.WHITE);
		
		p_bn.setBackground(new Color(33,33,33));
		p_pilot.setBackground(new Color(33,33,33));
		p_label.setBackground(new Color(33,33,33));
		
		t_init.setPreferredSize(new Dimension(120, 100));
		t_num.setPreferredSize(new Dimension(450, 100));
		p_bn.setPreferredSize(new Dimension(600, 100));
		p_label.setPreferredSize(new Dimension(600, 130));
		p_grid.setPreferredSize(new Dimension(300, 500));
		p_pilot.setPreferredSize(new Dimension(600, 900));
		
		p_bn.add(t_init);
		p_bn.add(t_num);
		p_label.add(la_detail1);
		p_label.add(la_detail2);
		p_label.add(la_detail3);
		
		p_pilot.add(p_bn);
		p_pilot.add(p_label);
		p_pilot.add(p_grid);
		add(p_pilot);
		
		setBackground(new Color(33,33,33));
		setVisible(true);
	}
}
