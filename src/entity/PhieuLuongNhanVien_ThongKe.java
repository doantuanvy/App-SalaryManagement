package entity;

import java.sql.Date;

public class PhieuLuongNhanVien_ThongKe {
	private String maPhieuLuong;
	private int ngayCC;
	private double thanhTien;
	private String maNguoiHuong;
	public String getMaPhieuLuong() {
		return maPhieuLuong;
	}
	public void setMaPhieuLuong(String maPhieuLuong) {
		this.maPhieuLuong = maPhieuLuong;
	}
	
	public int getNgayCC() {
		return ngayCC;
	}
	public void setNgayCC(int ngayCC) {
		this.ngayCC = ngayCC;
	}
	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	public String getMaNguoiHuong() {
		return maNguoiHuong;
	}
	public void setMaNguoiHuong(String maNguoiHuong) {
		this.maNguoiHuong = maNguoiHuong;
	}
	public PhieuLuongNhanVien_ThongKe(String maPhieuLuong, int ngayCC, double thanhTien, String maNguoiHuong) {
		super();
		this.maPhieuLuong = maPhieuLuong;
		this.ngayCC = ngayCC;
		this.thanhTien = thanhTien;
		this.maNguoiHuong = maNguoiHuong;
	}
	public PhieuLuongNhanVien_ThongKe() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PhieuLuongNhanVien_ThongKe [maPhieuLuong=" + maPhieuLuong + ", ngayCC=" + ngayCC + ", thanhTien="
				+ thanhTien + ", maNguoiHuong=" + maNguoiHuong + "]";
	}
	
	
	
	

}
