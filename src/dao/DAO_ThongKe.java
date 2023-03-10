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
import entity.ChiTietHopDong;
import entity.NhanVienNew;
import entity.PhieuLuongCongNhan_ThongKe;
import entity.PhieuLuongNhanVien_ThongKe;


public class DAO_ThongKe {
	public List<ChiTietHopDong> getAllChiTietHopDong(){
		ArrayList<ChiTietHopDong> ds = new ArrayList<ChiTietHopDong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select * from tb_HopDongSP";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				ds.add(new ChiTietHopDong(rs.getString("maHD"),rs.getInt("soLuong"),rs.getDouble("giaTri"),rs.getString("maSP"),rs.getBoolean("tinhTrang")));
				}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}
	public ArrayList<NhanVienNew> getAllNhanVienHanhChinh(){
		ArrayList<NhanVienNew> dsnvhc = new ArrayList<NhanVienNew>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from tb_NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String  maNhanVien = rs.getString(1);
				String hoTen = rs.getString(2);
				boolean gioiTinh = rs.getBoolean(3);
				String SDT = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				String diaChi = rs.getString(6);
				String donViCongTac = rs.getString(7);
				String cCCD = rs.getString(8);
				
				NhanVienNew nv = new NhanVienNew(maNhanVien, hoTen, gioiTinh, SDT, ngaySinh, diaChi,donViCongTac,cCCD);
				dsnvhc.add(nv);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dsnvhc;
	}
	public  ArrayList<PhieuLuongNhanVien_ThongKe> getAllPhieuLuongNhanVien(){
		ArrayList<PhieuLuongNhanVien_ThongKe> list = new ArrayList<PhieuLuongNhanVien_ThongKe>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from tb_PhieuLuongNV";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maPhieuLuong= rs.getString("maPLNV");
				int ngay = rs.getInt("thangLuong");
				Double thanhTien = rs.getDouble("thanhTien");
				String maNguoiHuong = rs.getString("maNV");
				
				list.add(new PhieuLuongNhanVien_ThongKe(maPhieuLuong,ngay,thanhTien,maNguoiHuong));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	public  ArrayList<PhieuLuongCongNhan_ThongKe> getAllPhieuLuongCongNhan(){
		ArrayList<PhieuLuongCongNhan_ThongKe> list = new ArrayList<PhieuLuongCongNhan_ThongKe>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from tb_PhieuLuongCN";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maPhieuLuong= rs.getString("maPLCN");
				int ngay = rs.getInt("thangLuong");
				Double thanhTien = rs.getDouble("thanhTien");
				String maNguoiHuong = rs.getString("maCN");;
				list.add(new PhieuLuongCongNhan_ThongKe(maPhieuLuong,ngay,thanhTien,maNguoiHuong));
			}
			ConnectDB.getInstance().disconnect();
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
}
