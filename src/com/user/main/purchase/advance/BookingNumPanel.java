package com.user.main.purchase.advance;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class BookingNumPanel extends JPanel{
	JPanel p_input;
	JTextField input;
	
	JPanel p_btn;
	ArrayList<NumButton> btnArr;
	
	StringBuffer sb;

	/*
	 * 생성자
	 * - 예매번호를 확인할 수 있는 TextField 생성
	 * - 예매번호를 누르기 위한 숫자 버튼을 위한 버튼 패널 생성
	 * - 숫자 버튼 효과를 위한 이벤트 등록
	 */
	public BookingNumPanel(){
		btnArr = new ArrayList<NumButton>();
		sb = new StringBuffer();
		
		p_btn = new JPanel(new GridLayout(4, 3));
		p_input = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				g.drawLine(0, 105, 800, 105);
			}
		};
		input = new JTextField(15){
			@Override
			public void setBorder(Border border) {
				//바깥 테두리 없애기
			}
		};
		input.setFont(new Font("default", Font.BOLD, 50));
		//input.setBackground(new Color(255, 217, 236));
		
		input.setPreferredSize(new Dimension(0, 100));
		p_btn.setPreferredSize(new Dimension(400, 500));
		p_input.setBackground(new Color(255, 217, 236));
		p_btn.setBackground(new Color(255, 217, 236));
		
		p_input.add(input);
		
		for(int i=1; i<=12; i++){
			NumButton btn;
			if(i==10){
				 btn = new NumButton("del");
			}else if(i==11){
				btn = new NumButton(0);
			}else if(i==12){
				btn = new NumButton("√");
			}else{
				btn = new NumButton(i);
			}
			
			final int index = i;
			btn.setPreferredSize(new Dimension(50, 50));
			btn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					numWrite(index);
				}
			});
			p_btn.add(btn);
			btnArr.add(btn);
		}
		
		add(p_input);
		add(p_btn);
		
		setVisible(true);
		setBackground(new Color(255, 217, 236));
		setPreferredSize(new Dimension(800, 1000));
	}
	
	/*
	 * void numWrite(int index)
	 * - 누른 숫자를 TextField에 반영
	 * - 단 숫자가 아닌 del, √에 대한 다른 이벤트 발생
	 */
	public void numWrite(int index){
		for(int i=0; i<btnArr.size(); i++){
			if(i == index-1){
				if(i==9){
					//마지막 숫자 하나 지우기
					sb.delete(sb.length()-1, sb.length());
					input.setText(sb.toString());
				}else if(i==11){
					//다음 단계로 진행
					
				}else{
					//버튼에 숫자 입력
					sb.append(Integer.toString(btnArr.get(i).num));
					input.setText(sb.toString());
				}
			}
		}
	}
}
