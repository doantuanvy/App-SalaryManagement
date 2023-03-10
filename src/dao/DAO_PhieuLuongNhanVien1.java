package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChamCongNhanVienNew;
import entity.HopDongNV;
import entity.NhanVienNew;
import entity.PhieuLuongNhanVien1;
import entity.TangCaNew;



public class DAO_PhieuLuongNhanVien1 {
	public ArrayList<PhieuLuongNhanVien1> getAllPhieuLuongNhanVien(){
		ArrayList<PhieuLuongNhanVien1> list = new ArrayList<PhieuLuongNhanVien1>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "SELECT * from tb_NHANVIEN inner join tb_PHIEULUONGNV on tb_NHANVIEN.maNV = tb_PHIEULUONGNV.maNV";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{   
				String maNV=rs.getString(1);
				String tenNV=rs.getString(2);
				boolean gioiTinh=rs.getBoolean(3);
				String sdt=rs.getString(4);
				Date ngaySinh=rs.getDate(5);
				String diaChi=rs.getString(6);
				String donViCongTac=rs.getString(7);
				String cccd=rs.getString(8);
				NhanVienNew nv=new NhanVienNew(maNV,tenNV,gioiTinh,sdt,ngaySinh,diaChi,donViCongTac,cccd);
				
				String maPLNV=rs.getString(9);
				float thanhTien=rs.getFloat(10);
				//
				float thucLanh=rs.getFloat(12);
				float tienUng=rs.getFloat(13);
				int soNgayLam=rs.getInt(14);
				int soGioTangCa=rs.getInt(15);
				String maNguoiCham=rs.getString(16);
				int thangLuong=rs.getInt(17);
				int namLuong=rs.getInt(18);
				PhieuLuongNhanVien1 plnv=new PhieuLuongNhanVien1(maPLNV,thanhTien,nv,thucLanh,tienUng,soNgayLam,soGioTangCa,maNguoiCham,thangLuong,namLuong);
				list.add(plnv);
				
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		return list;
	}
	
	
	
	
	public ArrayList<HopDongNV> getAllHD_NV(){
		ArrayList<HopDongNV> listALL = new ArrayList<HopDongNV>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "SELECT * from tb_NHANVIEN inner join tb_HOPDONGNV on tb_NHANVIEN.maNV = tb_HOPDONGNV.maNV";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				String maNV=rs.getString(1);
				String tenNV=rs.getString(2);
				boolean gioiTinh=rs.getBoolean(3);
				String sdt=rs.getString(4);
				Date ngaySinh=rs.getDate(5);
				String diaChi=rs.getString(6);
				String donViCongTac=rs.getString(7);
				String cccd=rs.getString(8);
				NhanVienNew nv=new NhanVienNew(maNV,tenNV,gioiTinh,sdt,ngaySinh,diaChi,donViCongTac,cccd);
				
				String maHD=rs.getString(9);
				Date ngayBatDau=rs.getDate(10);
				Date ngayHetHan=rs.getDate(11);
				float heSoLuong=rs.getFloat(12);
				float luongCoBan=rs.getFloat(13);
				//
				
				HopDongNV hdnv=new HopDongNV(maHD,ngayBatDau,ngayHetHan,heSoLuong,luongCoBan,nv);
				
				listALL.add(hdnv);
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		return listALL;
	}
	
	// lấy số ngày làm
	public int  getSoNgayLam(String sql){
		int a = 0;
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				Integer soNgayLam = rs.getInt(1);
				a=soNgayLam;
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return a;
	}
	
	// lấy số giờ tăng ca
	public int  getSoGioTangCa(String sql){
		int a = 0;
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				Integer soGioTangCa = rs.getInt(1);
				a=soGioTangCa;
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return a;
	}
	
	//thêm vào database
	public boolean themPLNV(PhieuLuongNhanVien1 plnv1) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("insert  into tb_PHIEULUONGNV values(?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1,plnv1.getMaPLNV());
			stmt.setFloat(2,plnv1.getThanhTien());
			stmt.setString(3,plnv1.getNv().getMaNV());
			stmt.setFloat(4,plnv1.getThucLanh());
			stmt.setFloat(5, plnv1.getTienUng());
			stmt.setInt(6, plnv1.getSoNgayLam());
			stmt.setInt(7, plnv1.getSoGioTangCa());
			stmt.setString(8, plnv1.getMaNguoiCham());
			stmt.setInt(9, plnv1.getThangLuong());
			stmt.setInt(10, plnv1.getNamLuong());
			
			
			
			
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
	
	
	//lấy mã lớn nhất để tạo phiếu lương
	public String getMaLonNhat() {
		String  cl=null;
     
       try {
    	   ConnectDB.getInstance().connect();
		   ConnectDB.getInstance();
		   Connection conn= ConnectDB.getConnection();
    	   String sql="SELECT top 1 maPLNV FROM tb_PHIEULUONGNV ORDER BY maPLNV DESC" ;
    	   PreparedStatement pstm = conn.prepareStatement(sql);
    	   ResultSet rs= pstm.executeQuery();
    	  
    	   while (rs.next()) {
    		  String maPhieuLuong = rs.getString(1); 
    		  cl=maPhieuLuong;
    		  
    		   
    	   }
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return cl;
	
	}

}
