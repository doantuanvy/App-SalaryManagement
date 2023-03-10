package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.CongNhanNew;
import entity.PhanCong;
import entity.SanPham;

public class DAO_PhanCong {
	public List<PhanCong> getAllPhanCong(){
		ArrayList<PhanCong> ds = new ArrayList<PhanCong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select * from tb_PhanCong";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				ds.add(new PhanCong(rs.getString("maPC"),rs.getString("giaiDoan"),rs.getDouble("donGia"),new CongNhanNew(rs.getString("maCN")),new SanPham(rs.getString("maSP"))));			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}
	public ArrayList<CongNhanNew> getAllCongNhan(){
		ArrayList<CongNhanNew> dscn = new ArrayList<CongNhanNew>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from tb_CongNhan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String  maCongNhan = rs.getString(1);
				String hoTen = rs.getString(2);
				boolean gioiTinh = rs.getBoolean(3);
				String SDT = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				String diaChi = rs.getString(6);
				String cCCD = rs.getString(7);
				CongNhanNew cn = new CongNhanNew(maCongNhan, hoTen, gioiTinh, SDT, ngaySinh, diaChi,cCCD);
				dscn.add(cn);
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dscn;

	}
	public ArrayList<SanPham> getAllSanPham(){
		ArrayList<SanPham> dsSP = new ArrayList<SanPham>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
//			ConnectDB.getInstance().connect();
//			ConnectDB.getInstance();
//			Connection con= ConnectDB.getConnection();
			String sql = "select*from tb_SanPham";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String maSP = rs.getString(1);
				String tenSP = rs.getString(2);
				String moTa = rs.getString(3);
				SanPham sp = new SanPham(maSP,tenSP,moTa);
				dsSP.add(sp);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsSP;
	}
	public boolean addPhanCong(PhanCong pc) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("insert into"+" tb_PhanCong values(?,?,?,?,?)");
			stmt.setString(1, pc.getMaPhanCong());
			stmt.setString(2, pc.getGiaDoan());
			stmt.setDouble(3, pc.getDonGia());
			stmt.setString(4, pc.getMaSanPham().getMaSP());
			stmt.setString(5, pc.getMaCongNhan().getMaCN());
			n=stmt.executeUpdate();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n>0;
	}
	public void delete(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("delete from tb_PhanCong where maPC=?");
			stmt.setString(1, ma);
			stmt.executeUpdate();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			}
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	public void update(PhanCong pc) {
		ConnectDB.getInstance();
		Connection	 con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt =con.prepareStatement("update tb_PhanCong set giaiDoan=?,donGia=?,maSP=?, maCN=?  where maPC=?");
			stmt.setString(1, pc.getGiaDoan());
			stmt.setDouble(2, pc.getDonGia());
			stmt.setString(3, pc.getMaSanPham().getMaSP());
			stmt.setString(4, pc.getMaCongNhan().getMaCN());
			stmt.setString(5, pc.getMaPhanCong());
			
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {stmt.close();
			}
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	public ArrayList<String> getMaPC() {
		ArrayList<String> ma = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select * from tb_PhanCong";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				ma.add((rs.getString("maPC").trim()).replaceAll("[A-Z]",""));
			}
		}catch (SQLException e) {	
		e.printStackTrace();
		}
		return ma;
	}
}
