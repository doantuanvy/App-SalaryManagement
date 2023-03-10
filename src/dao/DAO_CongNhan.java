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
import entity.CongNhanNew;



public class DAO_CongNhan implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArrayList<CongNhanNew> getAllCongNhan(){
		ArrayList<CongNhanNew> dscn = new ArrayList<CongNhanNew>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from tb_CONGNHAN";
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
	//tìm tất cả công nhân theo tên
	public ArrayList<CongNhanNew> getAllCongNhanTheoTen(){
		ArrayList<CongNhanNew> dscn = new ArrayList<CongNhanNew>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from tb_CONGNHAN order by hoTen";
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
	public boolean create(CongNhanNew cn) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("insert into tb_CONGNHAN values(?,?,?,?,?,?,?)");
			stmt.setString(1, cn.getMaCN());
			stmt.setString(2, cn.getHoTen());
			stmt.setBoolean(3, cn.isGioiTinh());
			stmt.setString(4, cn.getsDT());
			stmt.setDate(5, (Date) cn.getNgaySinh());
			stmt.setString(6, cn.getDiaChi());
			stmt.setString(7, cn.getcCCD());
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
	
	public boolean Updata(CongNhanNew cn) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("Update tb_CONGNHAN Set hoTen = ?, gioiTinh = ?, sDT=?, ngaySinh=?, diaChi=?,CCCD=? where maCN=?");
			stmt.setString(1, cn.getHoTen());
			stmt.setBoolean(2, cn.isGioiTinh());
			stmt.setString(3, cn.getsDT());
			stmt.setDate(4, (Date) cn.getNgaySinh());
			stmt.setString(5, cn.getDiaChi());
			stmt.setString(6, cn.getcCCD());
			stmt.setString(7, cn.getMaCN());
			n = stmt.executeUpdate();
			
		}catch (SQLException e) {
//			JOptionPane.showMessageDialog(null,"Chú ý: Nhập số điện thoại sai cú pháp!Là số và 10 kí tự!)");
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
	public boolean delete(String macn) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0 ;
		try {
			stmt = con.prepareStatement("delete from tb_CONGNHAN where maCN = ?  ");
			stmt.setString(1, macn);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n> 0;
	}
	public String getMaLonNhat() {
		String  cl=null;
      
       try {
    		ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
    	   String sql="SELECT top 1 maCN FROM tb_CONGNHAN ORDER BY maCN DESC" ;
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
public ArrayList<CongNhanNew> getCongNhanma(String ma){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		ArrayList<CongNhanNew> dscn = new ArrayList<CongNhanNew>();
		try {
			
			String sql = "Select *  from tb_CONGNHAN where maCN LIKE '%"+ma+"%'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String  maNhanVien = rs.getString(1);
				String hoTen = rs.getString(2);
				boolean gioiTinh = rs.getBoolean(3);		   
				String SDT = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				String diaChi = rs.getString(6);
				String cCCD = rs.getString(7);
				CongNhanNew cn = new CongNhanNew(maNhanVien, hoTen, gioiTinh, SDT, ngaySinh, diaChi,cCCD);
				dscn.add(cn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dscn;
	}

public ArrayList<CongNhanNew> getCongNhanTen(String ten){
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	ArrayList<CongNhanNew> dscn = new ArrayList<CongNhanNew>();
	try {
		
		String sql = "Select *  from tb_CONGNHAN where hoTen LIKE N'%"+ten+"%'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			String  maNhanVien = rs.getString(1);
			String hoTen = rs.getString(2);
			Boolean gioiTinh = rs.getBoolean(3);
		    
			String SDT = rs.getString(4);
			Date ngaySinh = rs.getDate(5);
			String diaChi = rs.getString(6);
			String cCCD = rs.getString(7);
			CongNhanNew cn = new CongNhanNew(maNhanVien, hoTen, gioiTinh, SDT, ngaySinh, diaChi,cCCD);
			dscn.add(cn);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return dscn;
}

public ArrayList<CongNhanNew> getCongNhansdt(String sdt){
	
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	ArrayList<CongNhanNew> dscn =new ArrayList<>();
	CongNhanNew cn = null;
	try {
		
		String sql = "Select *  from tb_CONGNHAN where sDT LIKE '%"+sdt+"%'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			String  maNhanVien = rs.getString(1);
			String hoTen = rs.getString(2);
			Boolean gioiTinh = rs.getBoolean(3);
		   
			String SDT = rs.getString(4);
			Date ngaySinh = rs.getDate(5);
			String diaChi = rs.getString(6);
			String cCCD = rs.getString(7);
			cn = new CongNhanNew(maNhanVien, hoTen, gioiTinh, SDT, ngaySinh, diaChi,cCCD);
		dscn.add(cn);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return dscn;
}

public ArrayList<CongNhanNew> getCongNhanGT(String gt){
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	ArrayList<CongNhanNew> dscn = new ArrayList<CongNhanNew>();
	try {
		
		String sql = "Select *  from tb_CONGNHAN where gioiTinh LIKE N'%"+gt+"%'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			String  maNhanVien = rs.getString(1).trim();
			String hoTen = rs.getString(2).trim();
			Boolean gioiTinh = rs.getBoolean(3);
		    
			String SDT = rs.getString(4).trim();
			Date ngaySinh = rs.getDate(5);
			String diaChi = rs.getString(6).trim();
			String cCCD = rs.getString(7).trim();
			CongNhanNew cn = new CongNhanNew(maNhanVien, hoTen,gioiTinh, SDT, ngaySinh, diaChi,cCCD);
			dscn.add(cn);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return dscn;
}

}
