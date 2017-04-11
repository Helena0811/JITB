package com.manage.movie;

public class TheaterData {
	private int theater_id;
	private String name;
	private int row_line;
	private int column_line;
	private int branch_id;
	private String movie_id;
	
	public int getTheater_id() {
		return theater_id;
	}
	public void setTheater_id(int theater_id) {
		this.theater_id = theater_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRow_line() {
		return row_line;
	}
	public void setRow_line(int row_line) {
		this.row_line = row_line;
	}
	public int getColumn_line() {
		return column_line;
	}
	public void setColumn_line(int column_line) {
		this.column_line = column_line;
	}
	public int getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}
	public String getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}

}
