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
import entity.PhieuLuongNVnew;
import entity.SanPham;
import entity.TangCaNew;

public class DAO_PhieuLuongNhanVien {
	public ArrayList<PhieuLuongNVnew> getAllPhieuLuongNhanVien(){
		ArrayList<PhieuLuongNVnew> list = new ArrayList<PhieuLuongNVnew>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from tb_PHIEULUONGNV ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				String maPLNV=rs.getString(1);
				float thanhTien=rs.getFloat(2);
				NhanVienNew maNV = new NhanVienNew(rs.getString(3));
				ChamCongNhanVienNew maCC = new ChamCongNhanVienNew(rs.getString(4));
				PhieuLuongNVnew plnv=new PhieuLuongNVnew(maPLNV,thanhTien,maNV,maCC);
				list.add(plnv);
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		return list;
	}
	
	public ArrayList<TangCaNew> getAllTangCa()
	{
		ArrayList<TangCaNew> list = new ArrayList<TangCaNew>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from tb_TANGCA ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				String maTC=rs.getString(1);
				String loaiCa=rs.getString(2);
				float heSoLuong=rs.getFloat(3);
				float donGia=rs.getFloat(4);
				
				
				
				TangCaNew tc=new TangCaNew(maTC,loaiCa,heSoLuong,donGia);
				list.add(tc);
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		return list;
	}
	
	
	public ArrayList<ChamCongNhanVienNew> getAllChamCongNhanVien()
	{
		ArrayList<ChamCongNhanVienNew> list = new ArrayList<ChamCongNhanVienNew>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from tb_CHAMCONGNV ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				String maCC=rs.getString(1);
				String thangLuong=rs.getString(2);
				String namLuong=rs.getString(3);
				int soNgayLam=rs.getInt(4);
				int soGioTangCa=rs.getInt(5);
				NhanVienNew maNV = new NhanVienNew(rs.getString(6));
				float tienUng=rs.getFloat(7);
				TangCaNew maTC=new TangCaNew(rs.getString(8));
				HopDongNV maHD=new HopDongNV(rs.getString(9));
				
				
				
				ChamCongNhanVienNew ccnv=new ChamCongNhanVienNew(maCC,thangLuong,namLuong,soNgayLam,soGioTangCa,maNV,tienUng,maTC,maHD);
				list.add(ccnv);
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		return list;
	}
	//tìm kiếm bảng chấm công
	public ChamCongNhanVienNew getnhanvienmaCC(String ma){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		ChamCongNhanVienNew ccnv  = null;
		try {
			String sql = "Select * from tb_CHAMCONGNV where maCC = '"+ma+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				String maCC=rs.getString(1);
				String thangLuong=rs.getString(2);
				String namLuong=rs.getString(3);
				int soNgayLam=rs.getInt(4);
				int soGioTangCa=rs.getInt(5);
				NhanVienNew maNV = new NhanVienNew(rs.getString(6));
				float tienUng=rs.getFloat(7);
				TangCaNew maTC=new TangCaNew(rs.getString(8));
				HopDongNV maHD=new HopDongNV(rs.getString(9));
				
				ccnv=new ChamCongNhanVienNew(maCC,thangLuong,namLuong,soNgayLam,soGioTangCa,maNV,tienUng,maTC,maHD);
				
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return ccnv;
	}
	
	public TangCaNew getnhanvienmaTC(String ma){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		TangCaNew tc  = null;
		try {
			String sql = "Select * from tb_TANGCA where maTC = '"+ma+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				String maTC=rs.getString(1);
				String loaiCa=rs.getString(2);
				float heSoLuong=rs.getFloat(3);
				float donGia=rs.getFloat(4);
				
				
				
				tc=new TangCaNew(maTC,loaiCa,heSoLuong,donGia);
				
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return tc;
	}
	
	//tìm kiếm bảng phiếu lương
	public PhieuLuongNVnew getnhanvienmaPL(String ma){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PhieuLuongNVnew pll  = null;
		try {
			String sql = "Select * from tb_PHIEULUONGNV where maPLNV = '"+ma+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				String maPLNV=rs.getString(1);
				float thanhTien=rs.getFloat(2);
				NhanVienNew maNV = new NhanVienNew(rs.getString(3));
				ChamCongNhanVienNew maCC = new ChamCongNhanVienNew(rs.getString(4));
				pll=new PhieuLuongNVnew(maPLNV,thanhTien,maNV,maCC);
				
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return pll;
	}
	
	public ArrayList<PhieuLuongNVnew> getNhanVienMaNV()
	{   ArrayList<PhieuLuongNVnew> list=new ArrayList<PhieuLuongNVnew>();
		
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from tb_PHIEULUONGNV order by maNV";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				String maPLNV=rs.getString(1);
				float thanhTien=rs.getFloat(2);
				NhanVienNew maNV = new NhanVienNew(rs.getString(3));
				ChamCongNhanVienNew maCC = new ChamCongNhanVienNew(rs.getString(4));
				list.add(new PhieuLuongNVnew(maPLNV,thanhTien,maNV,maCC));
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	public ArrayList<PhieuLuongNVnew> getNhanVienMaCC()
	{   ArrayList<PhieuLuongNVnew> ds=new ArrayList<PhieuLuongNVnew>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		try {
			String sql = "select*from tb_PHIEULUONGNV order by maCC";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				String maPLNV=rs.getString(1);
				float thanhTien=rs.getFloat(2);
				NhanVienNew maNV = new NhanVienNew(rs.getString(3));
				ChamCongNhanVienNew maCC = new ChamCongNhanVienNew(rs.getString(4));
				ds.add(new PhieuLuongNVnew(maPLNV,thanhTien,maNV,maCC));
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return ds;
	}
	
	
	
	// xử lý tính lương
	/*public String getMaLonNhat() {
		String  cl=null;
     
       try {
    		ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
    	    String sql="SELECT top 1 maPLNV FROM tb_PHIEULUONGNV ORDER BY maPLNV DESC" ;
    	    PreparedStatement pstm = conn.prepareStatement(sql);
    	    ResultSet rs= pstm.executeQuery();
    	  
    	   while (rs.next()) {
    		  String maPLNV = rs.getString(1); 
    		  cl=maPLNV;
    		  
    		   
    	   }
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return cl;
	
	}*/
	
	
	
	public ArrayList<ChamCongNhanVienNew> getAll(){
		ArrayList<ChamCongNhanVienNew> listALL = new ArrayList<ChamCongNhanVienNew>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "SELECT * from tb_HOPDONGNV inner join tb_CHAMCONGNV on tb_HOPDONGNV.maHD = tb_CHAMCONGNV.maHD inner join tb_TANGCA on tb_CHAMCONGNV.maTC = tb_TANGCA.maTC ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				String maHD = rs.getString(1);
				Date ngayBD= rs.getDate(2);
				Date ngayHH = rs.getDate(3);
				float heSoLuong = rs.getFloat(4);
				double luongCoBan = rs.getDouble(5);
				NhanVienNew maNV = new NhanVienNew(rs.getString(6));
				HopDongNV hd=new HopDongNV(maHD,ngayBD,ngayHH,heSoLuong,luongCoBan,maNV);
				
				String maCC=rs.getString(7);
				String thangLuong=rs.getString(8);
				String namLuong=rs.getString(9);
				int soNgayLam=rs.getInt(10);
				int soGioTangCa=rs.getInt(11);
				NhanVienNew maNVV = new NhanVienNew(rs.getString(12));
				float tienUng=rs.getFloat(13);
				//TangCaNew maTCC=new TangCaNew(rs.getString(14));
				//HopDongNV maHDd=new HopDongNV(rs.getString(15));
				
				
				
				String maTC=rs.getString(16);
				String loaiCa=rs.getString(17);
				float heSoLuongg=rs.getFloat(18);
				float donGia=rs.getFloat(19);
				TangCaNew tc=new TangCaNew(maTC,loaiCa,heSoLuongg,donGia);
				
				ChamCongNhanVienNew cc=new ChamCongNhanVienNew(maCC,thangLuong,namLuong,soNgayLam,soGioTangCa,maNVV,tienUng,tc,hd);
				
				listALL.add(cc);
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		return listALL;
	}
	
	

}
