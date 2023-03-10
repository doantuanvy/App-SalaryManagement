package entity;

import java.sql.Date;

public class CongNhan {
	private String maCongNhan;
	private String hoTen;
	private String gioiTinh;
	private String sdt;
	private Date ngaySinh;
	private String diaChi;
	
	public CongNhan(String maCongNhan, String hoTen, String gioiTinh, String sdt, Date ngaySinh, String diaChi) {
		super();
		this.maCongNhan = maCongNhan;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.sdt = sdt;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
	}

	public CongNhan() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public CongNhan(String maCongNhan) {
		super();
		this.maCongNhan = maCongNhan;
	}

	public CongNhan(String maCongNhan, String hoTen, String gioiTinh) {
		super();
		this.maCongNhan = maCongNhan;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maCongNhan == null) ? 0 : maCongNhan.hashCode());
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
		CongNhan other = (CongNhan) obj;
		if (maCongNhan == null) {
			if (other.maCongNhan != null)
				return false;
		} else if (!maCongNhan.equals(other.maCongNhan))
			return false;
		return true;
	}

	public String getMaCongNhan() {
		return maCongNhan;
	}

	public void setMaCongNhan(String maCongNhan) {
		this.maCongNhan = maCongNhan;
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
	public String toString() {
		return "CongNhan [maCongNhan=" + maCongNhan + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", sdt=" + sdt
				+ ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + "]";
	}
	
	
	
}
