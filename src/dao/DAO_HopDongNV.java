
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.sql.Date;
import connectDB.ConnectDB;

import entity.NhanVienNew;


import entity.HopDongNV;

public class DAO_HopDongNV {

//	Lấy tất cả hợp đồng từ bảng hợp đồng
	public ArrayList<HopDongNV> getAllHopDong(){
		ArrayList<HopDongNV> dsHD = new ArrayList<HopDongNV>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from tb_HOPDONGNV";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String maHD = rs.getString("maHD");
				Date ngayBD= rs.getDate("ngayBatDau");
				Date ngayHH = rs.getDate("ngayHetHan");
				float heSoLuong = rs.getFloat("heSoLuong");
				double luongCoBan = rs.getDouble("luongCoBan");
				NhanVienNew maCN = new NhanVienNew(rs.getString("maNV"));
//				SanPham sp = new SanPham(rs.getString(4));
				
			
				HopDongNV hd = new HopDongNV(maHD, ngayBD, ngayHH, heSoLuong, luongCoBan, maCN);
				dsHD.add(hd);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsHD;
		
	}
//	Lấy tất cả chi tiết hợp đồng trong bảng chi tiết hợp đồng
	public ArrayList<NhanVienNew> getAllNV(){
		ArrayList<NhanVienNew> dsNV= new ArrayList<NhanVienNew>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from tb_NHANVIEN";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String maNV = rs.getString("maNV");
				String ten = rs.getString("hoTen");
				Boolean gioiTinh = rs.getBoolean("gioiTinh");
				NhanVienNew nVienNew = new NhanVienNew(maNV, ten, gioiTinh);
				
				dsNV.add(nVienNew);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsNV;
		
	}
	

//	Thêm mới một hợp đồng vào bảng hợp đồng
	public boolean creatHopDong(HopDongNV hopDong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("insert  into tb_HOPDONGNV values(?,?,?,?,?,?)");
			stmt.setString(1,hopDong.getMaHD());
			stmt.setDate(2,(Date) hopDong.getNgayBatDau());
			stmt.setDate(3,(Date) hopDong.getNgayHetHan());
			stmt.setFloat(4,hopDong.getHeSoLuong());
			
			stmt.setDouble(5, hopDong.getLuongCoBan());
			stmt.setString(6, hopDong.getCn().getMaNV());
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
			stmt = con.prepareStatement("delete from tb_HOPDONGNV where maHD = ? ");
			stmt.setString(1, maHopDong);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n> 0;
	}


	
//	Sửa thông tin của hợp đồng
	public boolean updateHopDong(HopDongNV hopDong,String dieuKien) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt = con.prepareStatement("update tb_HOPDONGNV set maHD = ?,ngayBatDau = ?,ngayHetHan=?,heSoLuong=?,luongCoBan=?,maNV=? where maHD=?");
			
			stmt.setString(1,hopDong.getMaHD());
			stmt.setDate(2,(Date) hopDong.getNgayBatDau());
			stmt.setDate(3,(Date) hopDong.getNgayHetHan());
			stmt.setFloat(4,hopDong.getHeSoLuong());
			stmt.setDouble(5, hopDong.getLuongCoBan());
			stmt.setString(6, hopDong.getCn().getMaNV());
			stmt.setString(7, dieuKien);
			
			n = stmt.executeUpdate();
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return n>0;
	}
public  HopDongNV getnhanvienma(String ma){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		HopDongNV hdnv  = null;
		try {
			
			String sql = "Select * from tb_HOPDONGNV where maHD = '"+ma+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maHD = rs.getString(1);
				Date ngayTaoHD = rs.getDate(2);
				Date ngayHetHan = rs.getDate(3);
				float heSoLuong=rs.getFloat(4);
				double luongCoBan=rs.getDouble(5);
				NhanVienNew maNV= new NhanVienNew(rs.getString(6));
				hdnv=new HopDongNV(maHD,ngayTaoHD,ngayHetHan,heSoLuong,luongCoBan,maNV);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hdnv;
	}
public String getMaLonNhat() {
	String  cl=null;
  
   try {
		ConnectDB.getInstance().connect();
		ConnectDB.getInstance();
		Connection conn= ConnectDB.getConnection();
	   String sql="SELECT top 1 maHD FROM tb_HOPDONGNV ORDER BY maHD DESC" ;
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
