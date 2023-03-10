package entity;

import java.sql.Date;

public class ChiTietHopDong {
	private String maHD;
	private int soLuong;
	private double giaTri;
	private String maSP;
	private boolean tinhTrang;
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getGiaTri() {
		return giaTri;
	}
	public void setGiaTri(double giaTri) {
		this.giaTri = giaTri;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public boolean isTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public ChiTietHopDong(String maHD, int soLuong, double giaTri, String maSP, boolean tinhTrang) {
		super();
		this.maHD = maHD;
		this.soLuong = soLuong;
		this.giaTri = giaTri;
		this.maSP = maSP;
		this.tinhTrang = tinhTrang;
	}
	public ChiTietHopDong() {
		super();
		// TODO Auto-generated constructor stub
	}
}
