package entity;

import java.sql.Date;

public class NguoiQuanLy {
	private String maNguoiQuanLy;
	private String hoTen;
	private String gioiTinh;
	private String sdt;
	private Date ngaySinh;
	private String diaChi;
	public String getMaNguoiQuanLy() {
		return maNguoiQuanLy;
	}
	public void setMaNguoiQuanLy(String maNguoiQuanLy) {
		this.maNguoiQuanLy = maNguoiQuanLy;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNguoiQuanLy == null) ? 0 : maNguoiQuanLy.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NguoiQuanLy other = (NguoiQuanLy) obj;
		if (maNguoiQuanLy == null) {
			if (other.maNguoiQuanLy != null)
				return false;
		} else if (!maNguoiQuanLy.equals(other.maNguoiQuanLy))
			return false;
		return true;
	}
	public NguoiQuanLy(String maNguoiQuanLy, String hoTen, String gioiTinh, String sdt, Date ngaySinh, String diaChi) {
		super();
		this.maNguoiQuanLy = maNguoiQuanLy;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.sdt = sdt;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
	}
	public NguoiQuanLy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NguoiQuanLy(String maNguoiQuanLy) {
		super();
		this.maNguoiQuanLy = maNguoiQuanLy;
	}
	@Override
	public String toString() {
		return "NguoiQuanLy [maNguoiQuanLy=" + maNguoiQuanLy + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", sdt="
				+ sdt + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + "]";
	}
	
	
	

	
	
}
