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
	 * ������
	 * - ���Ź�ȣ�� Ȯ���� �� �ִ� TextField ����
	 * - ���Ź�ȣ�� ������ ���� ���� ��ư�� ���� ��ư �г� ����
	 * - ���� ��ư ȿ���� ���� �̺�Ʈ ���
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
				//�ٱ� �׵θ� ���ֱ�
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
				btn = new NumButton("��");
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
	 * - ���� ���ڸ� TextField�� �ݿ�
	 * - �� ���ڰ� �ƴ� del, � ���� �ٸ� �̺�Ʈ �߻�
	 */
	public void numWrite(int index){
		for(int i=0; i<btnArr.size(); i++){
			if(i == index-1){
				if(i==9){
					//������ ���� �ϳ� �����
					sb.delete(sb.length()-1, sb.length());
					input.setText(sb.toString());
				}else if(i==11){
					//���� �ܰ�� ����
					
				}else{
					//��ư�� ���� �Է�
					sb.append(Integer.toString(btnArr.get(i).num));
					input.setText(sb.toString());
				}
			}
		}
	}
}
