package dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChamCongCN;
import entity.CongNhanNew;
import entity.HopDongNV;
import entity.LoaiSanPham;
import entity.PhanCong_tv;
import entity.SanPham;
import entity.TangCa;

public class DAO_ChamCongCN {
//	Lấy tất cả hợp đồng từ bảng hợp đồng
	public ArrayList<PhanCong_tv> getAllPhanCong(){
		ArrayList<PhanCong_tv> dsHD = new ArrayList<PhanCong_tv>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from tb_PHANCONG";
			String query ="SELECT * from tb_PHANCONG inner join tb_CONGNHAN on tb_PHANCONG.maCN = tb_CONGNHAN.maCN";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {				
				String maPC = rs.getString("maPC").trim();
				String maCN = rs.getString("maCN");
				String tenString = rs.getString("hoTen");
				Boolean gioiTinhBoolean = rs.getBoolean("gioiTinh");
				String congDoanString = rs.getString("giaiDoan");
				String maSPString= rs.getString("maSP");
				SanPham sPham = new SanPham(maSPString);
				CongNhanNew cNew = new CongNhanNew(maCN, tenString, gioiTinhBoolean);
				PhanCong_tv pCong = new PhanCong_tv(maPC, congDoanString, sPham, cNew);
				dsHD.add(pCong);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsHD;
		
	}
//	Lấy tất cả hợp đồng từ bảng hợp đồng
	public ArrayList<ChamCongCN> getAllChamCong(){
		ArrayList<ChamCongCN> dsHD = new ArrayList<ChamCongCN>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from tb_CHAMCONGCN";
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String maCC = rs.getString("maCC");
				Integer thangInteger = rs.getInt("thangLuong");
				Integer namInteger = rs.getInt("namLuong");
				Integer soLuongHCInteger = rs.getInt("soLuongHT");
				Double tienUngDouble = rs.getDouble("tienUng");
				Integer soLuongTCInteger = rs.getInt("soLuongTC");
				String maCNString = rs.getString("maCN");
				String maTCString = rs.getString("maTC");
				String maPCString = rs.getString("maPC").trim();
				CongNhanNew congNhanNew = new CongNhanNew(maCNString);
				TangCa tangCa = new TangCa(maTCString);
				PhanCong_tv phanCong = new PhanCong_tv(maPCString);
				
				ChamCongCN chamCongCN = new ChamCongCN(maCC, thangInteger, namInteger, soLuongHCInteger, tienUngDouble, soLuongTCInteger, congNhanNew, tangCa, phanCong);
				dsHD.add(chamCongCN);
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
	public boolean creatChamCong(ChamCongCN chamCongCN) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("insert  into tb_CHAMCONGCN values(?,?,?,?,?,?,?,?,?)");
			stmt.setString(1,chamCongCN.getMaString());
			stmt.setInt(2,chamCongCN.getThang());
			stmt.setInt(3,chamCongCN.getNam());
			stmt.setInt(4,chamCongCN.getSoLuongHC());
			stmt.setInt(8,chamCongCN.getSoLuongTC());
			stmt.setString(5, chamCongCN.getcNew().getMaCN());
			stmt.setString(6, chamCongCN.getpCong().getMaString());
			stmt.setDouble(7, chamCongCN.getTienUng());
			stmt.setString(9, chamCongCN.gettCa().getMaTangCa());
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
			stmt = con.prepareStatement("delete from tb_CHAMCONGCN where maCC = ? ");
			stmt.setString(1, maCC);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n> 0;
	}
	public boolean updateChamCong(ChamCongCN chamCongCN,String dieuKien) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt = con.prepareStatement("update tb_CHAMCONGCN set maCC = ?,thangLuong = ?,namLuong=?,soLuongHT=?,maCN=?,maPC=?,tienUng=?,soLuongTC=?,maTC=? where maCC=?");
			
			stmt.setString(1,chamCongCN.getMaString());
			stmt.setInt(2, chamCongCN.getThang());
			stmt.setInt(3, chamCongCN.getNam());
			stmt.setInt(4,chamCongCN.getSoLuongHC());
			stmt.setString(5, chamCongCN.getcNew().getMaCN());
			stmt.setString(6, chamCongCN.getpCong().getMaString());
			stmt.setDouble(7, chamCongCN.getTienUng());
			stmt.setInt(8,chamCongCN.getSoLuongTC());
			stmt.setString(9, chamCongCN.gettCa().getMaTangCa());
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
    	   String sql="SELECT top 1 maCC FROM tb_CHAMCONGCN ORDER BY maCC DESC" ;
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
