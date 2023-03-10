package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.CongNhanNew;

import entity.PhanCongnew;
import entity.PhieuLuongCongNhan1;

import entity.SanPham;


public class DAO_PhieuLuongCongNhan1 {
	
	public ArrayList<PhanCongnew> getAllPC_CN(){
		ArrayList<PhanCongnew> listALL = new ArrayList<PhanCongnew>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "SELECT * from tb_CONGNHAN inner join tb_PHANCONG on tb_CONGNHAN.maCN = tb_PHANCONG.maCN";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				String maCN=rs.getString(1);
				String tenCN=rs.getString(2);
				boolean gioiTinh=rs.getBoolean(3);
				String sdt=rs.getString(4);
				Date ngaySinh=rs.getDate(5);
				String diaChi=rs.getString(6);
				
				String cccd=rs.getString(7);
				CongNhanNew cn=new CongNhanNew(maCN,tenCN,gioiTinh,sdt,ngaySinh,diaChi,cccd);
				
				String maPC=rs.getString(8);
				String giaiDoan=rs.getString(9);
				float donGia=rs.getFloat(10);
				SanPham sp=new SanPham(rs.getString(11));
				//maCN
				PhanCongnew pc=new PhanCongnew(maPC,giaiDoan,donGia,sp,cn);
				listALL.add(pc);
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		return listALL;
	}
	
	// lấy số sản phẩm tăng ca
	public int  getSoSanPhamTangCa(String sql){
		int a = 0;
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				Integer soSanPhamTangCa = rs.getInt(1);
				a=soSanPhamTangCa;
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return a;
	}
	//lấy số sản phẩm hành chính
	public int  getSoSanPhamHanhChinh(String sql){
		int a = 0;
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				Integer soSanPhamHanhChinh = rs.getInt(1);
				a=soSanPhamHanhChinh;
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return a;
	}
	
	
	//thêm vào database
		public boolean themPLCN(PhieuLuongCongNhan1 pl) {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			int n=0;
			try {
				stmt = con.prepareStatement("insert  into tb_PHIEULUONGCN values(?,?,?,?,?,?,?,?,?,?)");
				stmt.setString(1,pl.getMaPLCN());
				stmt.setFloat(2,pl.getThanhTien());
				stmt.setString(3,pl.getCn().getMaCN());
				stmt.setFloat(4,pl.getThucLanh());
				stmt.setFloat(5,pl.getTienUng());
				stmt.setInt(6,pl.getTongSPHC());
				stmt.setInt(7,pl.getTongSPTC());
				stmt.setString(8, pl.getMaNguoiCham());
				stmt.setInt(9, pl.getThangLuong());
				stmt.setInt(10, pl.getNamLuong());
				
				
				
				
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
		
		//lấy mã lớn nhất
		public String getMaLonNhat() {
			String  cl=null;
	     
	       try {
	    	   ConnectDB.getInstance().connect();
			   ConnectDB.getInstance();
			   Connection conn= ConnectDB.getConnection();
	    	   String sql="SELECT top 1 maPLCN FROM tb_PHIEULUONGCN ORDER BY maPLCN DESC" ;
	    	   PreparedStatement pstm = conn.prepareStatement(sql);
	    	   ResultSet rs= pstm.executeQuery();
	    	  
	    	   while (rs.next()) {
	    		  String maPhieuLuongCN = rs.getString(1); 
	    		  cl=maPhieuLuongCN;
	    		  
	    		   
	    	   }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cl;
		
		}
		
		
		public ArrayList<PhieuLuongCongNhan1> getAllPhieuLuongCongNhan(){
			ArrayList<PhieuLuongCongNhan1> list = new ArrayList<PhieuLuongCongNhan1>();
			try {
				ConnectDB.getInstance().connect();
				ConnectDB.getInstance();
				Connection con= ConnectDB.getConnection();
				String sql = "SELECT * from tb_CONGNHAN inner join tb_PHIEULUONGCN on tb_CONGNHAN.maCN = tb_PHIEULUONGCN.maCN";
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				while(rs.next())
				{   
					String maCN=rs.getString(1);
					String tenCN=rs.getString(2);
					boolean gioiTinh=rs.getBoolean(3);
					String sdt=rs.getString(4);
					Date ngaySinh=rs.getDate(5);
					String diaChi=rs.getString(6);
					String cccd=rs.getString(7);
					CongNhanNew cn=new CongNhanNew(maCN,tenCN,gioiTinh,sdt,ngaySinh,diaChi,cccd);
					
					String maPLNV=rs.getString(8);
					float thanhTien=rs.getFloat(9);
					//
					float thucLanh=rs.getFloat(11);
					float tienUng=rs.getFloat(12);
					int soSPHC=rs.getInt(13);
					int soSPTC=rs.getInt(14);
					String maNguoiCham=rs.getString(15);
					int thangLuong=rs.getInt(16);
					int namLuong=rs.getInt(17);
					PhieuLuongCongNhan1 plcn=new PhieuLuongCongNhan1(maPLNV,thanhTien,cn,thucLanh,tienUng,soSPHC,soSPTC,maNguoiCham,thangLuong,namLuong);
					list.add(plcn);
					
				}
			}catch(SQLException e){
				e.printStackTrace();
				
			}
			return list;
		}

}
