/*
buy_snack 데이터 베이스의 레코드 1건을 담기위한 객체 : DTO 설계
*/

package com.manage.sales;

public class BuySnack {

	private int buy_snack_id;
	private int sub_opt_id;
	private int sales_qt;
	private int sales_time;
	private int sales_tot;
	private int top_opt_id;
	private int combo_id;

	public int getBuy_snack_id() {
		return buy_snack_id;
	}

	public void setBuy_snack_id(int buy_snack_id) {
		this.buy_snack_id = buy_snack_id;
	}

	public int getSub_opt_id() {
		return sub_opt_id;
	}

	public void setSub_opt_id(int sub_opt_id) {
		this.sub_opt_id = sub_opt_id;
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

	public int getSales_tot() {
		return sales_tot;
	}

	public void setSales_tot(int sales_tot) {
		this.sales_tot = sales_tot;
	}

	public int getTop_opt_id() {
		return top_opt_id;
	}

	public void setTop_opt_id(int top_opt_id) {
		this.top_opt_id = top_opt_id;
	}

	public int getCombo_id() {
		return combo_id;
	}

	public void setCombo_id(int combo_id) {
		this.combo_id = combo_id;
	}

}
