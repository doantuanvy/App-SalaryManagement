package entity;

import java.sql.Date;
import java.util.Objects;

public class HopDongNV {
	private String maHD;
	private Date ngayBatDau;
	private Date ngayHetHan;
	private float heSoLuong;
	private double luongCoBan;
	private NhanVienNew cn;
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public Date getNgayHetHan() {
		return ngayHetHan;
	}
	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}
	public float getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(float heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	public double getLuongCoBan() {
		return luongCoBan;
	}
	public void setLuongCoBan(double luongCoBan) {
		this.luongCoBan = luongCoBan;
	}
	public NhanVienNew getCn() {
		return cn;
	}
	public void setCn(NhanVienNew cn) {
		this.cn = cn;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(cn);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HopDongNV other = (HopDongNV) obj;
		return Objects.equals(cn, other.cn);
	}
	
	public HopDongNV() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HopDongNV(String maHD) {
		super();
		this.maHD=maHD;
		
	}

	public HopDongNV(String maHD, Date ngayBatDau, Date ngayHetHan, float heSoLuong, double luongCoBan,
			NhanVienNew cn) {
		super();
		this.maHD = maHD;
		this.ngayBatDau = ngayBatDau;
		this.ngayHetHan = ngayHetHan;
		this.heSoLuong = heSoLuong;
		this.luongCoBan = luongCoBan;
		this.cn = cn;
	}
	
	public HopDongNV(String maHD, NhanVienNew cn) {
		super();
		this.maHD = maHD;
		this.cn = cn;
	}
	@Override
	public String toString() {
		return "HopDongNV [maHD=" + maHD + ", ngayBatDau=" + ngayBatDau + ", ngayHetHan=" + ngayHetHan + ", heSoLuong="
				+ heSoLuong + ", luongCoBan=" + luongCoBan + ", cn=" + cn + "]";
	}
	
	
	
	
}
