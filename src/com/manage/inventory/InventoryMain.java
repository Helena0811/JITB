package com.manage.inventory;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class InventoryMain extends JPanel{
	JTabbedPane tabbedPane;
	JComponent item_add;   //추가될 창
	JComponent item_select;
	
	Inventory inventory;
	
	public InventoryMain() {
		//super(new GridLayout(1,1));
		
		inventory=new Inventory();
		tabbedPane = new JTabbedPane();
		
		// tab제목 : 영화관, 내용 : theater
		item_add=makeInnerPanel(inventory);
		tabbedPane.addTab("재고 확인", item_add);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		add(tabbedPane);
		
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		// 메인Frame의 버튼을 클릭했을 때만 보여져야 하므로 지금은 false
		setVisible(false);
	}
	
	/* 
	 * JTabbedPane에서 tab과 content를 만드는 메소드
	 * 현재는 content안에 JLabel만 들어가있지만, 추후 이것도 JPanel로 구현할 것!
	 * */
	protected JComponent makeInnerPanel(JPanel subPanel){
		JPanel panel=new JPanel(false);
		panel.setLayout(new BorderLayout());
		panel.add(subPanel);
		panel.setPreferredSize(new Dimension(1000, 750));
		
		return panel;
	}
	
}
