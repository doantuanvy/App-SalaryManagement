package entity;

import java.sql.Date;

public class HopDongSP {
	private String maHDString;
	private int soLuong;
	private double giaTri;
	private Date ngayBD;
	private Date ngayHH;
	private boolean tinhTrang;
	private SanPham sPham;
	public String getMaHDString() {
		return maHDString;
	}
	public void setMaHDString(String maHDString) {
		this.maHDString = maHDString;
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
	public Date getNgayBD() {
		return ngayBD;
	}
	public void setNgayBD(Date ngayBD) {
		this.ngayBD = ngayBD;
	}
	public Date getNgayHH() {
		return ngayHH;
	}
	public void setNgayHH(Date ngayHH) {
		this.ngayHH = ngayHH;
	}
	public boolean isTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public SanPham getsPham() {
		return sPham;
	}
	public void setsPham(SanPham sPham) {
		this.sPham = sPham;
	}
	public HopDongSP() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HopDongSP(String maHDString) {
		super();
		this.maHDString = maHDString;
	}
	public HopDongSP(String maHDString, int soLuong, double giaTri, Date ngayBD, Date ngayHH, boolean tinhTrang,
			SanPham sPham) {
		super();
		this.maHDString = maHDString;
		this.soLuong = soLuong;
		this.giaTri = giaTri;
		this.ngayBD = ngayBD;
		this.ngayHH = ngayHH;
		this.tinhTrang = tinhTrang;
		this.sPham = sPham;
	}
	@Override
	public String toString() {
		return "HopDongSP [maHDString=" + maHDString + ", soLuong=" + soLuong + ", giaTri=" + giaTri + ", ngayBD="
				+ ngayBD + ", ngayHH=" + ngayHH + ", tinhTrang=" + tinhTrang + ", sPham=" + sPham + "]";
	}
	
	
	
}
