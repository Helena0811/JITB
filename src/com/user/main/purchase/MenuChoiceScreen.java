package com.user.main.purchase;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.user.frame.ScreenFrame;
import com.user.main.ClientMain;

public class MenuChoiceScreen extends ScreenFrame implements ActionListener {

	JButton next;
	JPanel panel;
	// JTextArea area;
	JButton bt_ticketprint, bt_ticket, bt_combo;

	public MenuChoiceScreen(ClientMain main) {
		super(main);

		next = new JButton("다음 페이지");
		next.addActionListener(this);

		add(next);

//		panel = new JPanel();
//		// area = new JTextArea();
//		bt_ticketprint = new JButton("예매티켓출력");
//		bt_ticket = new JButton("예매티겟 구매");
//		bt_combo = new JButton("콤보");
//
//		bt_ticket.addActionListener(this);
//
//		panel.setLayout(new FlowLayout());
//
//		// panel.add(area);
//		panel.add(bt_ticketprint);
//		panel.add(bt_ticket);
//		panel.add(bt_combo);
//
//		// add(area);
//		add(panel);
//
//		// bt_ticketprint.setFocusPainted(false);
//		// bt_ticket.setBorderPainted(false);
//		// setContentAreaFilled(false);
//
//		setBackground(new Color(21,21,21));
//		bt_ticketprint.setSize(300, 400);
//		bt_ticket.setSize(300, 400);
//		bt_combo.setSize(300, 400);

		setSize(400, 600);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == next) {
			main.setPage(2);
		} else if (obj == bt_ticket) {
			JOptionPane.showMessageDialog(this, "출력메시지");
		}
	}
}
