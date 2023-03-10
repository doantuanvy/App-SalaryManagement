package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChamCongCN;
import entity.ChamCongNV;
import entity.CongNhanNew;
import entity.HopDongNV;
import entity.NhanVienNew;
import entity.PhanCong_tv;
import entity.SanPham;
import entity.TangCa;

public class DAO_ChamCongNV {
	public ArrayList<HopDongNV> getAllHopDong(){
		ArrayList<HopDongNV> dsHD = new ArrayList<HopDongNV>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
//			String sql = "select*from tb_HOPDONGNV";
			String query ="SELECT * from tb_HOPDONGNV inner join tb_NHANVIEN on tb_HOPDONGNV.maNV = tb_NHANVIEN.maNV";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {				
				String maHD = rs.getString("maHD").trim();
				String maNV = rs.getString("maNV");
				String tenString = rs.getString("hoTen");
				Boolean gioiTinhBoolean = rs.getBoolean("gioiTinh");
				
				NhanVienNew nhanVienNew = new NhanVienNew(maNV, tenString, gioiTinhBoolean);
				
				HopDongNV hopDongNV= new HopDongNV(maHD, nhanVienNew);
				dsHD.add(hopDongNV);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsHD;
		
	}
	public ArrayList<ChamCongNV> getAllChamCong(){
		ArrayList<ChamCongNV> dsHD = new ArrayList<ChamCongNV>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from tb_CHAMCONGNV";
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String maCC = rs.getString("maCC");
				Integer thangInteger = rs.getInt("thangLuong");
				Integer namInteger = rs.getInt("namLuong");
				Integer soNgayLamInteger = rs.getInt("soNgayLam");
				Double tienUngDouble = rs.getDouble("tienUng");
				Integer soGioTCInteger = rs.getInt("soGioTangCa");
				String maNVString = rs.getString("maNV");
				String maTCString = rs.getString("maTC");
				String maHDString = rs.getString("maHD").trim();
				
				NhanVienNew nhanVienNew = new NhanVienNew(maNVString);
				TangCa tangCa = new TangCa(maTCString);
				HopDongNV hopDongNV = new HopDongNV(maHDString);
				
				ChamCongNV chamCongNV =new ChamCongNV(maCC, thangInteger, namInteger, soNgayLamInteger, soGioTCInteger, tienUngDouble, nhanVienNew, hopDongNV, tangCa);
				dsHD.add(chamCongNV);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsHD;
		
	}
//	Lấy tất cả hợp đồng từ bảng hợp đồng
	public ArrayList<TangCa> getAllTangCa(){
		ArrayList<TangCa> dsHD = new ArrayList<TangCa>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from tb_TANGCA";
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String maTC = rs.getString("maTC");
				String loaiCa = rs.getString("loaiCa");
				float heSoLuongFloat = rs.getFloat("heSoLuong");
				float donGiaFloat = rs.getFloat("donGia");
				TangCa tangCa = new TangCa(maTC, loaiCa, heSoLuongFloat, donGiaFloat);
		
				dsHD.add(tangCa);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsHD;
	}
	public boolean creatChamCong(ChamCongNV chamCongCN) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("insert  into tb_CHAMCONGNV values(?,?,?,?,?,?,?,?,?)");
			stmt.setString(1,chamCongCN.getMaString());
			stmt.setInt(2,chamCongCN.getThang());
			stmt.setInt(3,chamCongCN.getNam());
			stmt.setInt(4,chamCongCN.getSoNgayLam());
			stmt.setInt(5,chamCongCN.getSoGioTC());
			stmt.setString(9, chamCongCN.getHopDongNV().getMaHD());
			stmt.setString(6, chamCongCN.getnVienNew().getMaNV());
			stmt.setDouble(7, chamCongCN.getTienUng());
			stmt.setString(8, chamCongCN.getTangCa().getMaTangCa());
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
	public boolean deleteChamCong(String maCC) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0 ;
		try {
			stmt = con.prepareStatement("delete from tb_CHAMCONGNV where maCC = ? ");
			stmt.setString(1, maCC);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n> 0;
	}
	public boolean updateChamCong(ChamCongNV chamCongCN,String dieuKien) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt = con.prepareStatement("update tb_CHAMCONGNV set maCC = ?,thangLuong = ?,namLuong=?,soNgayLam=?,soGioTangCa=?,maNV=?,tienUng=?,maTC=?,maHD=? where maCC=?");
			
			stmt.setString(1,chamCongCN.getMaString());
			stmt.setInt(2,chamCongCN.getThang());
			stmt.setInt(3,chamCongCN.getNam());
			stmt.setInt(4,chamCongCN.getSoNgayLam());
			stmt.setInt(5,chamCongCN.getSoGioTC());
			stmt.setString(9, chamCongCN.getHopDongNV().getMaHD());
			stmt.setString(6, chamCongCN.getnVienNew().getMaNV());
			stmt.setDouble(7, chamCongCN.getTienUng());
			stmt.setString(8, chamCongCN.getTangCa().getMaTangCa());
			stmt.setString(10, dieuKien);
			
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
    	   String sql="SELECT top 1 maCC FROM tb_CHAMCONGNV ORDER BY maCC DESC" ;
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
