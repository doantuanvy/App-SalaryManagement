package entity;

import java.sql.Date;

public class PhieuLuongCongNhan_ThongKe {
	private String maPhieuLuong;
	private int ngay;
	private Double thanhTien;
	private String maNguoiHuong;
	
	
	
	public String getMaPhieuLuong() {
		return maPhieuLuong;
	}



	public void setMaPhieuLuong(String maPhieuLuong) {
		this.maPhieuLuong = maPhieuLuong;
	}


	



	public int getNgay() {
		return ngay;
	}



	public void setNgay(int ngay) {
		this.ngay = ngay;
	}



	public Double getThanhTien() {
		return thanhTien;
	}



	public void setThanhTien(Double thanhTien) {
		this.thanhTien = thanhTien;
	}



	public String getMaNguoiHuong() {
		return maNguoiHuong;
	}



	public void setMaNguoiHuong(String maNguoiHuong) {
		this.maNguoiHuong = maNguoiHuong;
	}



	public PhieuLuongCongNhan_ThongKe(String maPhieuLuong, int ngay, Double thanhTien, String maNguoiHuong) {
		super();
		this.maPhieuLuong = maPhieuLuong;
		this.ngay = ngay;
		this.thanhTien = thanhTien;
		this.maNguoiHuong = maNguoiHuong;
	}



	public PhieuLuongCongNhan_ThongKe() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
