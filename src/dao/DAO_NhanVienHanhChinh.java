package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.NhanVienHanhChinh;

public class DAO_NhanVienHanhChinh implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public ArrayList<NhanVienHanhChinh> getAllNhanVienHanhChinh(){
		ArrayList<NhanVienHanhChinh> dsnvhc = new ArrayList<>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from tb_NHANVIEN";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String  maNhanVien = rs.getString(1);
				String hoTen = rs.getString(2);
				Boolean gioiTinh = rs.getBoolean(3);
				String SDT = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				String diaChi = rs.getString(6);
				String donViCongTac = rs.getString(7);
				String canCuoc = rs.getString(8);
				NhanVienHanhChinh nvhc = new NhanVienHanhChinh(maNhanVien,hoTen,gioiTinh,SDT,ngaySinh,diaChi,donViCongTac,canCuoc);
				dsnvhc.add(nvhc);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dsnvhc;
		
	}
	public ArrayList<NhanVienHanhChinh> getAllNhanVienHanhChinhTheoTen(){
		ArrayList<NhanVienHanhChinh> dsnvhc = new ArrayList<NhanVienHanhChinh>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from tb_NHANVIEN order by hoTen";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String  maNhanVien = rs.getString(1);
				String hoTen = rs.getString(2);
				Boolean gioiTinh = rs.getBoolean(3);
				String SDT = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				String diaChi = rs.getString(6);
				String donViCongTac = rs.getString(7);
				String canCuoc = rs.getString(8);
				
				NhanVienHanhChinh nvhc = new NhanVienHanhChinh(maNhanVien, hoTen, gioiTinh, SDT, ngaySinh, diaChi,donViCongTac,canCuoc);
				dsnvhc.add(nvhc);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dsnvhc;
		
	}
	public ArrayList<NhanVienHanhChinh> getAllNhanVienHanhChinhTheoCV(){
		ArrayList<NhanVienHanhChinh> dsnvhc = new ArrayList<NhanVienHanhChinh>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from tb_NHANVIEN order by chucVu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String  maNhanVien = rs.getString(1);
				String hoTen = rs.getString(2);
				Boolean gioiTinh = rs.getBoolean(3);
				String SDT = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				String diaChi = rs.getString(6);
				String donViCongTac = rs.getString(7);
				String canCuoc = rs.getString(8);
				NhanVienHanhChinh nvhc = new NhanVienHanhChinh(maNhanVien,hoTen,gioiTinh,SDT,ngaySinh,diaChi,donViCongTac,canCuoc);
				dsnvhc.add(nvhc);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dsnvhc;
		
	}
	public ArrayList<NhanVienHanhChinh> getAllNhanVienHanhChinhTheoDV(){
		ArrayList<NhanVienHanhChinh> dsnvhc = new ArrayList<NhanVienHanhChinh>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from NhanVien order by donViCongTac";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String  maNhanVien = rs.getString(1);
				String hoTen = rs.getString(2);
				Boolean gioiTinh = rs.getBoolean(3);
				String SDT = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				String diaChi = rs.getString(6);
				String donViCongTac = rs.getString(7);
				String canCuoc = rs.getString(8);
				NhanVienHanhChinh nvhc = new NhanVienHanhChinh(maNhanVien,hoTen,gioiTinh,SDT,ngaySinh,diaChi,donViCongTac,canCuoc);
				dsnvhc.add(nvhc);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dsnvhc;
		
	}
	public boolean create(NhanVienHanhChinh nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("insert  into tb_NHANVIEN values(?,?,?,?,?,?,?,?)");
			stmt.setString(1, nv.getMaNhanVien().trim());
			stmt.setString(2, nv.getHoTen().trim());
			stmt.setBoolean(3, nv.getGioiTinh());
			stmt.setString(4, nv.getSdt().trim());
			stmt.setDate(5, (Date) nv.getNgaySinh());
			stmt.setString(6, nv.getDiaChi().trim());
			stmt.setString(7, nv.getDonViCongTac().trim());
			stmt.setString(8, nv.getCanCuoc().trim());
			n = stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n>0;
	}
	public boolean Updata(NhanVienHanhChinh nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("Update NhanVien Set hoTen = ?, gioiTinh = ?, SDT=?, ngaySinh=?, diaChi=?, donViCongTac=?  where maNhanVien=?");
			stmt.setString(1, nv.getHoTen());
			stmt.setBoolean(2, nv.getGioiTinh());
			stmt.setString(3, nv.getSdt());
			stmt.setDate(4, (Date) nv.getNgaySinh());
			stmt.setString(5, nv.getDiaChi());
			stmt.setDate(6, (Date) nv.getNgaySinh());
			stmt.setString(7, nv.getDonViCongTac());
			stmt.setString(8, nv.getMaNhanVien());
			n = stmt.executeUpdate();
			
		}catch (SQLException e) {
			JOptionPane.showConfirmDialog(null,"Vui lòng chọn lại ngày sinh!");
		}
		finally {
			try {
				stmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n>0;
		
	}

	public ArrayList<NhanVienHanhChinh> getnhanvienma(String ma){
		ArrayList<NhanVienHanhChinh> list=new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		NhanVienHanhChinh nvhc = null;
		try {
			
			String sql = "Select *  from tb_NHANVIEN where maNV LIKE '%"+ma+"%'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String  maNhanVien = rs.getString(1);
				String hoTen = rs.getString(2);
				Boolean gioiTinh = rs.getBoolean(3);
				String SDT = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				String diaChi = rs.getString(6);
				String donViCongTac = rs.getString(7);
				String canCuoc = rs.getString(8);
				nvhc = new NhanVienHanhChinh(maNhanVien,hoTen,gioiTinh,SDT,ngaySinh,diaChi,donViCongTac,canCuoc);
				list.add(nvhc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
public ArrayList<NhanVienHanhChinh> getnhanvienten(String ten){
		
		ArrayList<NhanVienHanhChinh> dsnvhc = new ArrayList<NhanVienHanhChinh>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		NhanVienHanhChinh nvhc = null;
		try {
			
			String sql = "Select *  from tb_NHANVIEN where hoTen LIKE N'%"+ten+"%'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String  maNhanVien = rs.getString(1);
				String hoTen = rs.getString(2);
				Boolean gioiTinh = rs.getBoolean(3);
				String SDT = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				String diaChi = rs.getString(6);
				String donViCongTac = rs.getString(7);
				String canCuoc = rs.getString(8);
				nvhc = new NhanVienHanhChinh(maNhanVien,hoTen,gioiTinh,SDT,ngaySinh,diaChi,donViCongTac,canCuoc);
				dsnvhc.add(nvhc);
			}
		} catch (Exception e) {
			
		}
		return dsnvhc;
		
	}
public NhanVienHanhChinh getnhanviensdt(String sdt){
	
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	NhanVienHanhChinh nvhc = null;
	try {
		
		String sql = "Select *  from NhanVien where sDT LIKE N'%"+sdt+"%'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			String  maNhanVien = rs.getString(1);
			String hoTen = rs.getString(2);
			Boolean gioiTinh = rs.getBoolean(3);
			String SDT = rs.getString(4);
			Date ngaySinh = rs.getDate(5);
			String diaChi = rs.getString(6);
			String donViCongTac = rs.getString(7);
			String canCuoc = rs.getString(8);
			nvhc = new NhanVienHanhChinh(maNhanVien,hoTen,gioiTinh,SDT,ngaySinh,diaChi,donViCongTac,canCuoc);
				
		}
	} catch (Exception e) {
		
	}
	return nvhc;
	
}
public ArrayList<NhanVienHanhChinh> locTheoPhong(String namePhong){
	ArrayList<NhanVienHanhChinh> dsnv = new ArrayList<>();
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	NhanVienHanhChinh nvhc = null;
	try {
		
		String sql = "select * from tb_NHANVIEN where  donViCongTac LIKE N'%"+namePhong+"%'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			String  maNhanVien = rs.getString(1);
			String hoTen = rs.getString(2);
			Boolean gioiTinh = rs.getBoolean(3);
			String SDT = rs.getString(4);
			Date ngaySinh = rs.getDate(5);
			String diaChi = rs.getString(6);
			String donViCongTac = rs.getString(7);
			String cccd = rs.getString(8);
			nvhc = new NhanVienHanhChinh(maNhanVien, hoTen, gioiTinh, SDT, ngaySinh, diaChi, donViCongTac,cccd);
			dsnv.add(nvhc);
			
		}
	} catch (Exception e) {
		
	}
	return dsnv;
}
public ArrayList<NhanVienHanhChinh> locnhanvien(String Gioitinh1,String donvicongtac1){
	ArrayList<NhanVienHanhChinh> dsnvhc = new ArrayList<NhanVienHanhChinh>();
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	NhanVienHanhChinh nvhc = null;
	try {
		
		String sql = "select * from NhanVien where  gioiTinh LIKE N'%"+Gioitinh1+"%' AND donViCongTac LIKE N'%"+donvicongtac1+"%'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			String  maNhanVien = rs.getString(1);
			String hoTen = rs.getString(2);
			Boolean gioiTinh = rs.getBoolean(3);
			String SDT = rs.getString(4);
			Date ngaySinh = rs.getDate(5);
			String diaChi = rs.getString(6);
			String donViCongTac = rs.getString(7);
			String cccd = rs.getString(8);
			nvhc = new NhanVienHanhChinh(maNhanVien, hoTen, gioiTinh, SDT, ngaySinh, diaChi, donViCongTac,cccd);
			dsnvhc.add(nvhc);
			
		}
	} catch (Exception e) {
		
	}
	return dsnvhc;
	
}
			
					
	public boolean delete(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0 ;
		try {
			stmt = con.prepareStatement("delete from tb_NHANVIEN where maNV = ?  ");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Chú ý: Không Thể Xóa Vì Nhân Viên Đang Còn Hợp Đồng Và có Tài khoản Đăng nhập! ");
		}
		return n> 0;
	}
	public String getMaLonNhat() {
		String  cl=null;
      
       try {
    		ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
    	   String sql="SELECT top 1 maNV FROM tb_NHANVIEN ORDER BY maNV DESC" ;
    	   PreparedStatement pstm = conn.prepareStatement(sql);
    	   ResultSet rs= pstm.executeQuery();
    	  
    	   while (rs.next()) {
    		  String maCN= rs.getString(1); 
    		  cl=maCN;
    		  
    		   
    	   }
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return cl;
	
	}
}
