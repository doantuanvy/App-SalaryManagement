package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.DangNhap;
import entity.NguoiQuanLy;
import entity.NhanVienHanhChinh;

public class DAO_TaiKhoan {
	
	public ArrayList<DangNhap> getALLTaiKhoan(){
		ArrayList<DangNhap> dstk = new ArrayList<DangNhap>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select*from TaiKhoan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String  taiKhoan = rs.getString(1);
				String matKhau = rs.getString(2);
				NhanVienHanhChinh maNv = new NhanVienHanhChinh(rs.getString(3));
				NguoiQuanLy maQL = new NguoiQuanLy(rs.getString(4));

				DangNhap tk = new DangNhap(taiKhoan,matKhau,maNv,maQL);
				dstk.add(tk);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dstk;

	}
	public boolean createNV(DangNhap dn) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("INSERT INTO TaiKhoan (tenTaiKhoan, matKhau, maNhanVien) VALUES (?, ?, ?)");
			stmt.setString(1, dn.getTaiKhoan());
			stmt.setString(2, dn.getMatKhau());
			stmt.setString(3, dn.getNv().getMaNhanVien());
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
	
	public boolean createQL(DangNhap dn) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("INSERT INTO TaiKhoan (tenTaiKhoan, matKhau, maQuanLy ) VALUES (?, ?, ?)");
			stmt.setString(1, dn.getTaiKhoan());
			stmt.setString(2, dn.getMatKhau());
			stmt.setString(3, dn.getQl().getMaNguoiQuanLy());
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
	
	public boolean Updata(DangNhap dn) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt = con.prepareStatement("Update TaiKhoan Set matKhau = ? where tenTaiKhoan=?");			
			stmt.setString(1, dn.getMatKhau());
			stmt.setString(2, dn.getTaiKhoan());
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
	
	public boolean delete(String tentk) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0 ;
		try {
			stmt = con.prepareStatement("delete from TaiKhoan where tenTaiKhoan = ?  ");
			stmt.setString(1, tentk);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n> 0;
	}
	

}
