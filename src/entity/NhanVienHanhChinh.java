package entity;

import java.util.Date;

public class NhanVienHanhChinh {
	private String maNhanVien;
	private String hoTen;
	private boolean gioiTinh;
	private String sdt;
	private Date ngaySinh;
	private String diaChi;
	private String donViCongTac;
	private String canCuoc;
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public boolean getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
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
	public String getDonViCongTac() {
		return donViCongTac;
	}
	public void setDonViCongTac(String donViCongTac) {
		this.donViCongTac = donViCongTac;
	}
	
	public String getCanCuoc() {
		return canCuoc;
	}
	public void setCanCuoc(String canCuoc) {
		this.canCuoc = canCuoc;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNhanVien == null) ? 0 : maNhanVien.hashCode());
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
		NhanVienHanhChinh other = (NhanVienHanhChinh) obj;
		if (maNhanVien == null) {
			if (other.maNhanVien != null)
				return false;
		} else if (!maNhanVien.equals(other.maNhanVien))
			return false;
		return true;
	}
	
	
	public NhanVienHanhChinh() {
		super();
	}
	public NhanVienHanhChinh(String maNhanVien) {
		
		this.maNhanVien = maNhanVien;
	}
	public NhanVienHanhChinh(String maNhanVien, String hoTen, boolean gioiTinh, String sdt, Date ngaySinh,
			String diaChi, String donViCongTac, String canCuoc) {
		super();
		this.maNhanVien = maNhanVien;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.sdt = sdt;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.donViCongTac = donViCongTac;
		this.canCuoc = canCuoc;
	}
	@Override
	public String toString() {
		return "NhanVienHanhChinh [maNhanVien=" + maNhanVien + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", sdt="
				+ sdt + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", donViCongTac=" + donViCongTac
				+ ", canCuoc=" + canCuoc + "]";
	}
	
}
 
 

