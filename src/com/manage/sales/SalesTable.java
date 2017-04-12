/*
일별 영화관 매출액을 보여주는 테이블
 */
package com.manage.sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class SalesTable extends AbstractTableModel {

	Connection con;

	Vector<String> columName = new Vector<String>();
	Vector<Vector> data = new Vector<Vector>();

	public SalesTable(Connection con) {
		this.con = con;
		getList();

	}

	public void getList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuffer sql = new StringBuffer();
		sql.append("select b.name as 상위콤보, c.name as 하위콤보,");
		sql.append(" d.buy_snack_id, d.sales_qt, d.SALES_TOT, d.SALES_TIME");
		sql.append(" from TOP_OPT b, SUB_OPT c, buy_snack d");
		sql.append(" where b.TOP_OPT_ID=c.TOP_OPT_ID");
		sql.append(" and c.sub_opt_id=d.SUB_OPT_ID");
		sql.append(" group by b.name, c.name,  d.buy_snack_id,  d.sales_qt,  d.SALES_TOT, d.SALES_TIME");
		sql.append(" order by d.SALES_TIME asc");

		try {
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			// 요일 바꿀 때마다 테이블 초기화 할 것임 현재는 x
			// columName.removeAll(columName);
			// data.removeAll(data);

			ResultSetMetaData meta = rs.getMetaData();
			for (int i = 1; i <= meta.getColumnCount(); i++) {
				columName.add(meta.getColumnName(i));
			}

			while (rs.next()) {
				Vector vec = new Vector();
				vec.add(rs.getString("상위콤보"));
				vec.add(rs.getString("하위콤보"));
				vec.add(rs.getInt("buy_snack_id"));
				vec.add(rs.getInt("sales_qt"));
				vec.add(rs.getInt("SALES_TOT"));
				vec.add(rs.getString("SALES_TIME"));

				data.add(vec);
			}

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

	public int getRowCount() {
		return data.size();
	}

	public int getColumnCount() {
		return columName.size();
	}

	public String getColumnName(int col) {
		return columName.get(col);
	}

	public Object getValueAt(int row, int col) {
		return data.get(row).get(col);
	}

}
