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

public class DAO_ChamCongCN1 {
	
	public ArrayList<PhanCong_tv> getAllChamCong(){
		ArrayList<PhanCong_tv> dsHD = new ArrayList<PhanCong_tv>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "SELECT  tb_CONGNHAN.maCN , tb_CONGNHAN.hoTen,tb_SANPHAM.tenSP,tb_PHANCONG.giaiDoan from tb_CONGNHAN inner join tb_PHANCONG on tb_CONGNHAN.maCN = tb_PHANCONG.maCN inner join tb_SANPHAM on tb_PHANCONG.maSP=tb_SANPHAM.maSP inner join tb_HOPDONGSP on tb_SANPHAM.maSP=tb_HOPDONGSP.maSP";
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String ten = rs.getString("hoTen");
				String ma = rs.getString("maCN");
				String tenSPString= rs.getString("tenSP");
				String congDoanString = rs.getString("giaiDoan");
				
				SanPham sanPham = new SanPham(null, tenSPString, null);
				
				CongNhanNew congNhanNew = new CongNhanNew(ma, ten);
				PhanCong_tv phanCong_tv = new PhanCong_tv(congDoanString, sanPham, congNhanNew);

				
				dsHD.add(phanCong_tv);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsHD;
		
	}
	public ArrayList<ChamCongCN1> getAllChamCongCN(){
		ArrayList<ChamCongCN1> dsHD = new ArrayList<ChamCongCN1>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from tb_CHAMCONGCN1";
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				Integer maString = rs.getInt("maCC");
				
				String maCN = rs.getString("maCN").trim();
				Date ngayCCDate = rs.getDate("ngayCC");
				Boolean diemDanhBoolean = rs.getBoolean("diemDanh");
				Integer soSPHCInteger = rs.getInt("soSPHC");
				Integer soSPTCInteger = rs.getInt("soSPTC");
				String nguoiChamString = rs.getString("maNguoiCham");
				CongNhanNew congNhanNew = new CongNhanNew(maCN);
				NhanVienNew nhanVienNew = new NhanVienNew(nguoiChamString);
				
				
				ChamCongCN1 chamCongCN1 = new ChamCongCN1(maString, congNhanNew, ngayCCDate, diemDanhBoolean, soSPHCInteger, soSPTCInteger, nhanVienNew);

				
				dsHD.add(chamCongCN1);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsHD;
		
	}
	
	public ArrayList<ChamCongCN1> getAllBangCong(){
		ArrayList<ChamCongCN1> dsHD = new ArrayList<ChamCongCN1>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select tb_CHAMCONGCN1.maCN,tb_CONGNHAN.hoTen,tb_CHAMCONGCN1.ngayCC,tb_CHAMCONGCN1.diemDanh,tb_CHAMCONGCN1.soSPHC,tb_CHAMCONGCN1.soSPTC \r\n"
					+ "from tb_CHAMCONGCN1 inner join tb_CONGNHAN on tb_CHAMCONGCN1.maCN=tb_CONGNHAN.maCN\r\n"
					+ "order by tb_CHAMCONGCN1.maCN";
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				
				
				String maCN = rs.getString("maCN").trim();
				String tenCN = rs.getString("hoTen");
				Date ngayCCDate = rs.getDate("ngayCC");
				Boolean diemDanhBoolean = rs.getBoolean("diemDanh");
				Integer soSPHCInteger = rs.getInt("soSPHC");
				Integer soSPTCInteger = rs.getInt("soSPTC");
				
				CongNhanNew congNhanNew = new CongNhanNew(maCN, tenCN);
				
				
				
				ChamCongCN1 chamCongCN1 = new ChamCongCN1(0, congNhanNew, ngayCCDate, diemDanhBoolean, soSPHCInteger, soSPTCInteger, null);

				
				dsHD.add(chamCongCN1);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsHD;
		
	}
	
	public int  getTongSP(String sql){
		int num =0;
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				Integer tempInteger = rs.getInt(1);
				num=tempInteger;
				
				
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return num;
		
	}
	public boolean creatChamCong(ChamCongCN1 chamCongCN) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("insert  into tb_CHAMCONGCN1 values(?,?,?,?,?,?,?)");
			stmt.setInt(1,chamCongCN.getMaString());
			stmt.setString(2,chamCongCN.getCongNhanNew().getMaCN());
			stmt.setDate(3,chamCongCN.getNgayCCDate());
			stmt.setBoolean(4,chamCongCN.isDiemDanh());
			stmt.setInt(5,chamCongCN.getSoSPHC());
			stmt.setInt(6,chamCongCN.getSoSPTC());
			stmt.setString(7, chamCongCN.getNguoiChamNew().getMaNV());
			
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
    	   String sql="SELECT top 1 maCC FROM tb_CHAMCONGCN1 ORDER BY maCC DESC" ;
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
