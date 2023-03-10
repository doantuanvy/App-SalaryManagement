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
import entity.ChamCongCN1;
import entity.ChamCongNV;
import entity.ChamCongNV1;
import entity.CongNhanNew;
import entity.HopDongNV;
import entity.NhanVienNew;
import entity.PhanCong_tv;
import entity.SanPham;
import entity.TangCa;

public class DAO_ChamCongNV1 {
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
	public ArrayList<NhanVienNew> getAllChamCong(){
		ArrayList<NhanVienNew> dsHD = new ArrayList<NhanVienNew>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from tb_NHANVIEN";
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String ten = rs.getString("hoTen");
				String ma = rs.getString("maNV");
				Boolean gioiBoolean = rs.getBoolean("gioiTinh");
				String phongBanString = rs.getString("donViCongTac");
				
				NhanVienNew nhanVienNew = new NhanVienNew(ma, ten, gioiBoolean, phongBanString);
				
	
				
				
				dsHD.add(nhanVienNew);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsHD;
		
	}

	public boolean creatChamCong(ChamCongNV1 chamCongCN) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("insert  into tb_CHAMCONGNV1 values(?,?,?,?,?,?)");
			stmt.setInt(1,chamCongCN.getMaString());
			stmt.setString(2,chamCongCN.getnVienNew().getMaNV());
			stmt.setDate(3,chamCongCN.getNgayCCDate());
			stmt.setBoolean(4,chamCongCN.getDiemDanhBoolean());
			stmt.setInt(5,chamCongCN.getSoGioTC());
			stmt.setString(6, chamCongCN.getNguoiChamCong().getMaNV());
			
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
	public ArrayList<ChamCongNV1> getAllBangCong(){
		ArrayList<ChamCongNV1> dsHD = new ArrayList<ChamCongNV1>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select tb_CHAMCONGNV1.maNV,tb_NHANVIEN.hoTen,tb_CHAMCONGNV1.ngayCC,tb_CHAMCONGNV1.diemDanh,tb_CHAMCONGNV1.soGioTC from tb_CHAMCONGNV1 inner join tb_NHANVIEN on tb_CHAMCONGNV1.maNV=tb_NHANVIEN.maNV\r\n"
					+ "order by tb_CHAMCONGNV1.maNV";
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				
				
				String maNV = rs.getString("maNV").trim();
				String tenCN = rs.getString("hoTen");
				Date ngayCCDate = rs.getDate("ngayCC");
				Boolean diemDanhBoolean = rs.getBoolean("diemDanh");
				
				Integer soSPTCInteger = rs.getInt("soGioTC");
				
				NhanVienNew nhanVienNew = new NhanVienNew(maNV, tenCN);
				
				
				
				ChamCongNV1 chamCongCN1 = new ChamCongNV1(0, nhanVienNew, ngayCCDate, diemDanhBoolean, soSPTCInteger, null);

				
				dsHD.add(chamCongCN1);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsHD;
		
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
    	   String sql="SELECT top 1 maCC FROM tb_CHAMCONGNV1 ORDER BY maCC DESC" ;
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
