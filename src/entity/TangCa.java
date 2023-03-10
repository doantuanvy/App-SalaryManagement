package entity;

import java.sql.Date;

public class TangCa {
	private String maTangCa;
	private String loaiCaString;
	private float heSoLuong;
	private float donGia;
	public String getMaTangCa() {
		return maTangCa;
	}
	public void setMaTangCa(String maTangCa) {
		this.maTangCa = maTangCa;
	}
	public String getLoaiCaString() {
		return loaiCaString;
	}
	public void setLoaiCaString(String loaiCaString) {
		this.loaiCaString = loaiCaString;
	}
	public float getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(float heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	public float getDonGia() {
		return donGia;
	}
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	public TangCa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TangCa(String maTangCa, String loaiCaString, float heSoLuong, float donGia) {
		super();
		this.maTangCa = maTangCa;
		this.loaiCaString = loaiCaString;
		this.heSoLuong = heSoLuong;
		this.donGia = donGia;
	}
	public TangCa(String maTangCa) {
		super();
		this.maTangCa = maTangCa;
	}
	@Override
	public String toString() {
		return "TangCa [maTangCa=" + maTangCa + ", loaiCaString=" + loaiCaString + ", heSoLuong=" + heSoLuong
				+ ", donGia=" + donGia + "]";
	}
	
	
	
	

}
