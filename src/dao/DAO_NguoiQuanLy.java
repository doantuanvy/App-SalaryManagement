package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NguoiQuanLy;

public class DAO_NguoiQuanLy {
	
	public ArrayList<NguoiQuanLy> getAllNguoiQuanLy(){
		ArrayList<NguoiQuanLy> dsnql = new ArrayList<NguoiQuanLy>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from NguoiQuanLyNhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String  maQL = rs.getString(1);
				String hoTen = rs.getString(2);
				String gioiTinh = rs.getString(3);
				String SDT = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				String diaChi = rs.getString(6);

				NguoiQuanLy nvhc = new NguoiQuanLy(maQL, hoTen, gioiTinh, SDT, ngaySinh, diaChi);
				dsnql.add(nvhc);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dsnql;
		
	}
	
}
