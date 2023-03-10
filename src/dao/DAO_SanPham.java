package dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import connectDB.ConnectDB;


import entity.SanPham;


public class DAO_SanPham{
	
	
	public ArrayList<SanPham> getAllSanPham(){
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from tb_SANPHAM ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				String maSP=rs.getString(1).trim();
				String tenSP=rs.getString(2);
				String moTa=rs.getString(3);
				String hinhAnh=rs.getString(4);
				SanPham sp=new SanPham(maSP,tenSP,moTa,hinhAnh);
				list.add(sp);
				
				
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public boolean deleteSanPham(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0 ;
		try {
			stmt = con.prepareStatement("delete from tb_SANPHAM where maSP = ? ");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n> 0;
	}
	
	

	public boolean themSanPham(SanPham sanPham) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("insert  into tb_SANPHAM values(?,?,?,?)");
			stmt.setString(1,sanPham.getMaSP().trim());
			stmt.setString(2,sanPham.getTenSP());
			stmt.setString(3,sanPham.getMoTa());
			stmt.setString(4,sanPham.getHinhAnh());
			
			
			
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
	
	
	public SanPham getnhanvienmaSP(String ma){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		SanPham sp  = null;
		try {
			String sql = "Select * from tb_SANPHAM where maSP = '"+ma+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				String maSP=rs.getString(1);
				String tenSP=rs.getString(2);
				String moTa=rs.getString(3);
				String ghiChu=rs.getString(4);
				sp=new SanPham(maSP,tenSP,moTa,ghiChu);
				
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return sp;
	}
	
	
	public boolean updateSanPham(SanPham sanPham, String dieuKien) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt = con.prepareStatement("update SanPham set maSP = ?,tenSP = ?,moTa = ?,hinhAnh = ? where maSP = ?");
			
			stmt.setString(1, sanPham.getMaSP().trim());
			stmt.setString(2, sanPham.getTenSP());
			stmt.setString(3, sanPham.getMoTa());
			stmt.setString(4, sanPham.getHinhAnh());
			stmt.setString(5, dieuKien);
			n = stmt.executeUpdate();
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return n>0;
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
}
