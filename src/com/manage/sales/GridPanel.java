/*
영화별 평균 매출, 평균 예매를 확인할 수 있는 GridPanel
 */
package com.manage.sales;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GridPanel extends JPanel{
	private Connection con;
	String path = "C:/project/JITB/res/";
	ArrayList <BuyMovie> list = new ArrayList<BuyMovie>();
	
	Calendar strDate = Calendar.getInstance();
	Calendar endDate = Calendar.getInstance();
	
	public GridPanel() {
		this.setVisible(true);
		this.setBackground(Color.orange);
		setPreferredSize(new Dimension(1000, 650));
	}

	public void setConnection(Connection con) {
		this.con=con;
		loadData();
	}


	public void loadData() {
		
		//join을 통해 원하는 정보 불러오기
		String sql = "select a.POSTER"
				+ ", a.START_DATE"
				+", sum(d.sales_qt) as sales_qt"
				+", sum(d.sales_tot) as sales_tot"
				+" from movie a"
				+", START_TIME b"
				+", SEAT c"
				+", BUY_MOVIE d"
				+" where 1=1"
				+" and a.MOVIE_ID = b.MOVIE_ID"
				+" and b.START_TIME_ID = c.START_TIME_ID"
				+" and c.SEAT_ID = d.SEAT_ID"
				+" group by"
				+" a.POSTER"
				+", a.START_DATE";
				
		PreparedStatement pstmt= null;
		ResultSet rs = null;

		try {
			pstmt= con.prepareStatement(sql);
			rs = pstmt.executeQuery(); //쿼리 실행!!

			while(rs.next()){
				BuyMovie dto = new BuyMovie();

				//dto.setBuy_movie_id(rs.getInt("buy_movie_id"));
				//dto.setMovie_id(rs.getInt("movie_id"));
				//dto.setSales_qt(rs.getInt("sqles_qt"));
				//dto.setSales_time(rs.getInt("sales_time"));
				//dto.setDate(rs.getString("date"));
				
				dto.setPoster(rs.getString("poster"));
				dto.setSales_tot(rs.getInt("sales_tot"));
				dto.setSales_qt(rs.getInt("sales_qt"));
				dto.setStart_date(rs.getString("start_date"));

				list.add(dto);
			}
			//데이터베이스를 모두 가져왔으므로 디자인에 반영
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
	
	//list에 담겨있는 만큼 for문 돌리기
	public void init() {
		for(int i=0; i<list.size(); i++) {
			BuyMovie buyMovie = list.get(i);
			try {
				Image poster = ImageIO.read(new File(path+buyMovie.getPoster()));
				int sales_tot = buyMovie.getSales_tot();
				int sales_qt = buyMovie.getSales_qt();
				String str = buyMovie.getStart_date();
				int year = Integer.parseInt(str.substring(0, 4));
				int month = Integer.parseInt(str.substring(5,7))-1;
				int date = Integer.parseInt(str.substring(8,10))-1;
				int period = 0; //영화 여러번 돌리기 때문에 startDate가 달라 초기화 시키기
				
				//endDate에 현재 일자 넣기
				endDate.setTime(new Date());
				//strDate 영화 개봉일 넣어줌
				strDate.set(year, month, date);
				//현재 일자에서 영화개봉일을 뺀 상영기간을 구해줌
				period = (int)(endDate.getTimeInMillis() - strDate.getTimeInMillis())/(60*60*24*1000);
				
				String sales = String.format("%.1f", (double)sales_tot/period);
				String booking = String.format("%.1f", (double)sales_qt/period*100);
				
				MovieItem item = new MovieItem(poster, sales, booking);
				add(item);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
