package com.manage.sales;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GridPanel extends JPanel{
	private Connection con;
	String path = "C:/java_workspace2/DBProject2/data/";
	ArrayList <BuyMovie> list = new ArrayList<BuyMovie>();
	
	public GridPanel() {

		this.setVisible(false);
		this.setBackground(Color.orange);
		setPreferredSize(new Dimension(650, 550));
	}
	
	public void setConnection(Connection con) {
		this.con=con;
		loadData();
	}
	
	
	public void loadData() {
		//���� ������ ��ȭ�� ��ȸ�ϴ� ���� �ʿ�!
		String sql = "select * from buy_movie order by buy_movie_id asc";
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try {
			pstmt= con.prepareStatement(sql);
			rs = pstmt.executeQuery(); //���� ����!!
			
			while(rs.next()){
				BuyMovie dto = new BuyMovie(); //���ڵ� 1���� ��� ���� �ν��Ͻ�
				
				dto.setBuy_movie_id(rs.getInt("buy_movie_id"));
				dto.setMovie_id(rs.getInt("movie_id"));
				dto.setSales_qt(rs.getInt("sqles_qt"));
				dto.setSales_time(rs.getInt("sales_time"));
				dto.setDate(rs.getString("date"));
				dto.setSales_tot(rs.getInt("sales_tot"));

				list.add(dto);
			}
			//�����ͺ��̽��� ��� ���������Ƿ� �����ο� �ݿ�����
			init();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public void init() {
		for(int i=0; i<list.size(); i++) {
			BuyMovie buyMovie = list.get(i);
				//img, moviename, �غ�Ϸ�
				//Image img = ImageIO.read(new File(path+buyMovie.getImg()));
				//String price = Integer.toString(buyMovie.getPrice());
				
				//�� 3���� BookItem�� new����		
				//BookItem item = new BookItem(img, name, price);
				//add(item);
		}
	}
}
