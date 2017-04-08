/*
buy_movie 데이터 베이스의 레코드 1건을 담기위한 객체 : DTO 설계
*/

package com.manage.sales;

public class BuyMovie {
	
	private int buy_movie_id;
	private int movie_id;
	private int sales_qt;
	private int sales_time;
	private String date;
	private int sales_tot;
	
	public int getBuy_movie_id() {
		return buy_movie_id;
	}
	public void setBuy_movie_id(int buy_movie_id) {
		this.buy_movie_id = buy_movie_id;
	}
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public int getSales_qt() {
		return sales_qt;
	}
	public void setSales_qt(int sales_qt) {
		this.sales_qt = sales_qt;
	}
	public int getSales_time() {
		return sales_time;
	}
	public void setSales_time(int sales_time) {
		this.sales_time = sales_time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getSales_tot() {
		return sales_tot;
	}
	public void setSales_tot(int sales_tot) {
		this.sales_tot = sales_tot;
	}
	
	
}
