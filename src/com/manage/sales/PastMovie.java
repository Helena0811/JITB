/*
과거에 상영했던 영화별 평균 매출, 평균 예매를 확인할 수 있는 패널
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

public class PastMovie extends JPanel {

	private Connection con;
	String path = "C:/project/JITB/res/";
	ArrayList<BuyMovie> list = new ArrayList<BuyMovie>();
	
	/*---------------------------------------
	Calendar를 사용해 strDate랑 endDate 만든다.
	---------------------------------------*/
	Calendar strDate = Calendar.getInstance();
	Calendar endDate = Calendar.getInstance();

	public PastMovie() {
		this.setVisible(true);
		this.setBackground(Color.yellow);
		setPreferredSize(new Dimension(1000, 650));
	}

	public void setConnection(Connection con) {
		this.con = con;
		loadData();
	}

	/*---------------------------------------
	 Join을 통해 원하는 정보(Poster, StartDate, EndDATE를 불러온 후 
	 현재 날짜를 불러오는 오라클 함수를 사용해
	 현재 날짜와 영화의 EndDate 비교해서 상영이 끝난 영화 데이터만을 출력
	---------------------------------------*/
	public void loadData() {
		String sql = "select a.POSTER" + ", a.START_DATE" + ", a.END_DATE" + ", sum(d.sales_qt) as sales_qt"
				+ ", sum(d.sales_tot) as sales_tot" + " from movie a" + ", START_TIME b" + ", SEAT c" + ", BUY_MOVIE d"
				+ " where 1=1" + " and a.MOVIE_ID = b.MOVIE_ID" + " and b.START_TIME_ID = c.START_TIME_ID"
				+ " and c.SEAT_ID = d.SEAT_ID" + " group by a.POSTER, a.START_DATE, a.END_DATE"
				+ " having END_DATE < TO_DATE " + "(TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS')"
				+ ", 'YYYYMMDDHH24MISS') + (48 / 24)";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // 쿼리 실행!!

			while (rs.next()) {
				BuyMovie dto = new BuyMovie();

				dto.setPoster(rs.getString("poster"));
				dto.setSales_tot(rs.getInt("sales_tot"));
				dto.setSales_qt(rs.getInt("sales_qt"));
				dto.setStart_date(rs.getString("start_date"));
				dto.setEnd_date(rs.getString("end_date"));

				list.add(dto);
			}
			init();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/*---------------------------------------
	 END_DATE, START_DATE를 불러옴
	 상영이 끝난 영화의 경우 (END_DATE - START_DATE)를 기간으로 설정
	---------------------------------------*/
	public void init() {
		for(int i=0; i<list.size(); i++) {
			BuyMovie buyMovie = list.get(i);
			try {
				Image poster = ImageIO.read(new File(path+buyMovie.getPoster()));
				int sales_tot = buyMovie.getSales_tot();
				int sales_qt = buyMovie.getSales_qt();
				
				//영화 시작하는 날짜 구하기
				String start = buyMovie.getStart_date();
				int str_year = Integer.parseInt(start.substring(0, 4));
				int str_month = Integer.parseInt(start.substring(5,7))-1;
				int str_date = Integer.parseInt(start.substring(8,10))-1;
				
				//영화 끝나는 날짜 구하기
				String end = buyMovie.getEnd_date();
				int end_year = Integer.parseInt(end.substring(0, 4));
				int end_month = Integer.parseInt(end.substring(5,7));
				int end_date = Integer.parseInt(end.substring(8,10));
				
				//영화 여러번 돌리기 때문에 startDate가 달라 초기화 시키기
				int period = 0; 

				//startDate에 영화 개봉일, endDate에 영화 끝난 날 넣어줌
				strDate.set(str_year, str_month, str_date);
				endDate.set(end_year, end_month, end_date);
				
				//end-date에서 영화 개봉일을 뺀 상영기간을 구해줌
				period = (int)(strDate.getTimeInMillis()- endDate.getTimeInMillis())/(60*60*24*1000);
				System.out.println(period);
				
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
