package com.manage.movie;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// ��ȭ�� �߰� ���̾ƿ�
public class AddTheater extends JInternalFrame implements ActionListener{
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
	
	JButton bt_confirm;
	
	int row, col;
	
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
		
		lb_title=new JLabel("��ȭ�� ũ�� ����");
		lb_name=new JLabel("��ȭ�� �̸� �Է�");
		t_name=new JTextField(10);
		lb_content=new JLabel("�߰��� ��ȭ���� ��, ���� �������ּ���.");
		
		lb_row=new JLabel("��");
		lb_col=new JLabel("��");
		
		ch_row=new Choice();
		ch_col=new Choice();
		
		bt_confirm=new JButton("Ȯ��");
		
		for(int i=0; i<5; i++){
			ch_row.add(Integer.toString(i+1));
			ch_col.add(Integer.toString(i+1));
		}
		
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
	}

	// Ȯ�� ��ư�� ������
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		JButton bt=(JButton)(obj);
		
		if(bt==bt_confirm){
			//System.out.println("Ȯ�� ����");
			//this.setDefaultCloseOperation(AddTheater.DISPOSE_ON_CLOSE);
			// Ȯ�� ��ư�� ������ �����Ͱ� theater ���̺� ����ǰ� â ����
			this.dispose();
		}
	}
}
