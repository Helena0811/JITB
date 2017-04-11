package com.user.main.purchase.advance;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu.Separator;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.user.main.ClientMain;

public class BookingNumPanel extends JPanel{
	JPanel p_pilot;
	JPanel p_bn;
	JTextField t_init;
	JTextField t_num;
	JPanel p_label;
	JLabel la_detail1, la_detail2;
	JPanel p_grid;
	
	ClientMain main;
	Image btnImg[];
	NumButton btnPanel[] = new NumButton[12];
	
	StringBuffer num = new StringBuffer();
	
	public BookingNumPanel(ClientMain main, Image btnImg[]) {
		this.main = main;
		this.btnImg = btnImg;
		
		String str1 = "앞 4자리를 제외하고 뒤 11자리를 입력해주세요";
		String str2 = "예매번호를 모르신다면 생년월일+휴대폰번호로 조회해주세요";
		
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
		p_grid = new JPanel(new GridLayout(4, 3));
		
		for(int i=0; i<btnPanel.length; i++){
			btnPanel[i] = new NumButton(btnImg[i], i);
			btnPanel[i].setPreferredSize(new Dimension(50, 50));
			btnPanel[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					NumButton btn = (NumButton)e.getSource();
					
					if(btn.index == 10){
						deleteNum();
					}else if(btn.index == 11){
						main.setPage(3);
					}else{
						insertNum(btn.index);
					}
				}
			});
		}
		
		for(int i=0; i<9; i++){
			p_grid.add(btnPanel[i+1]);
		}
		p_grid.add(btnPanel[10]);
		p_grid.add(btnPanel[0]);
		p_grid.add(btnPanel[11]);
		
		t_init.setEditable(false);
		
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
		
		p_bn.setBackground(new Color(33,33,33));
		p_pilot.setBackground(new Color(33,33,33));
		p_label.setBackground(new Color(33,33,33));
		p_grid.setBackground(new Color(33,33,33));
		
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
		
		p_pilot.add(p_bn);
		p_pilot.add(p_label);
		p_pilot.add(p_grid);
		add(p_pilot);
		
		setBackground(new Color(33,33,33));
		setVisible(true);
	}
	
	public void insertNum(int index){
		num.append(index);
		t_num.setText(num.toString());
	}
	
	public void deleteNum(){
		if(num.length() != 0){
			num.delete(num.length()-1, num.length());
		}
		if(num.length() == 0){
			t_num.setText("뒷 자리(7~8자)");
		}else{
			t_num.setText(num.toString());
		}
	}
}
