package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.HopDongNV;
import entity.HopDongSP;
import entity.NhanVienNew;
import entity.SanPham;

public class DAO_HopDongSP {
//	Lấy tất cả hợp đồng từ bảng hợp đồng
	public ArrayList<HopDongSP> getAllHopDong(){
		ArrayList<HopDongSP> dsHD = new ArrayList<HopDongSP>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from tb_HOPDONGSP";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String maHD = rs.getString("maHD");
				Date ngayBD= rs.getDate("ngayBatDau");
				Date ngayHH = rs.getDate("ngayHetHan");
				SanPham maSP = new SanPham(rs.getString("maSP"));
				double giaTri = rs.getDouble("giaTri");
				int soLuong = rs.getInt("soLuong");
				Boolean tinhTrang = rs.getBoolean("tinhTrang");
				
				HopDongSP hd = new HopDongSP(maHD, soLuong, giaTri, ngayBD, ngayHH, tinhTrang, maSP);
				
			
				
				dsHD.add(hd);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsHD;
		
	}
//	Lấy tất cả chi tiết hợp đồng trong bảng chi tiết hợp đồng
	public ArrayList<SanPham> getAllSP(){
		ArrayList<SanPham> dsNV= new ArrayList<SanPham>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from tb_SANPHAM";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String maSP = rs.getString("maSP");
				String ten = rs.getString("tenSP");
				String moTa = rs.getString("moTa");
				SanPham sp = new SanPham(maSP, ten, moTa);
				
				
				dsNV.add(sp);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsNV;
		
	}
	

//	Thêm mới một hợp đồng vào bảng hợp đồng
	public boolean creatHopDong(HopDongSP hopDong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("insert  into tb_HOPDONGSP values(?,?,?,?,?,?,?)");
			stmt.setString(1,hopDong.getMaHDString());
			stmt.setDate(5,(Date) hopDong.getNgayBD());
			stmt.setDate(6,(Date) hopDong.getNgayHH());
			stmt.setString(4,hopDong.getsPham().getMaSP());
			
			stmt.setDouble(3, hopDong.getGiaTri());
			stmt.setInt(2, hopDong.getSoLuong());
			stmt.setBoolean(7, hopDong.isTinhTrang());
			n = stmt.executeUpdate();			
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
//	

	

//	Xóa một hợp đồng 
	public boolean deleteHopDong(String maHopDong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0 ;
		try {
			stmt = con.prepareStatement("delete from tb_HOPDONGSP where maHD = ? ");
			stmt.setString(1, maHopDong);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n> 0;
	}


	
//	Sửa thông tin của hợp đồng
	public boolean updateHopDong(HopDongSP hopDong,String dieuKien) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt = con.prepareStatement("update tb_HOPDONGSP set maHD = ?,soLuong=?,giaTri=?,maSP=?,ngayBatDau = ?,ngayHetHan=?,tinhTrang =? where maHD=?");
			
			stmt.setString(1,hopDong.getMaHDString());
			stmt.setDate(5,(Date) hopDong.getNgayBD());
			stmt.setDate(6,(Date) hopDong.getNgayHH());
			stmt.setInt(2,hopDong.getSoLuong());
			stmt.setDouble(3, hopDong.getGiaTri());
			stmt.setString(4, hopDong.getsPham().getMaSP());
			stmt.setBoolean(7, hopDong.isTinhTrang());
			stmt.setString(8, dieuKien);
			
			n = stmt.executeUpdate();
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return n>0;
	}
	public String getMaLonNhat() {
		String  cl=null;
      
       try {
    		ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
    	   String sql="SELECT top 1 maHD FROM tb_HOPDONGSP ORDER BY maHD DESC" ;
    	   PreparedStatement pstm = conn.prepareStatement(sql);
    	   ResultSet rs= pstm.executeQuery();
    	  
    	   while (rs.next()) {
    		  String maCaLam = rs.getString(1); 
    		  cl=maCaLam;
    		  
    		   
    	   }
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return cl;
	
	}

}
