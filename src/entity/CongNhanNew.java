package entity;

import java.sql.Date;
import java.util.Objects;

public class CongNhanNew {
	private String maCN;
	private String hoTen;
	private boolean gioiTinh;
	private String sDT;
	private Date ngaySinh;
	private String diaChi;
	private String cCCD;
	public String getMaCN() {
		return maCN;
	}
	public void setMaCN(String maCN) {
		this.maCN = maCN;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getsDT() {
		return sDT;
	}
	public void setsDT(String sDT) {
		this.sDT = sDT;
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
	public String getcCCD() {
		return cCCD;
	}
	public void setcCCD(String cCCD) {
		this.cCCD = cCCD;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maCN);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CongNhanNew other = (CongNhanNew) obj;
		return Objects.equals(maCN, other.maCN);
	}
	public CongNhanNew() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CongNhanNew(String maCN, String hoTen, boolean gioiTinh, String sDT, Date ngaySinh, String diaChi,
			String cCCD) {
		super();
		this.maCN = maCN;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.sDT = sDT;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.cCCD = cCCD;
	}
	
	
	
	public CongNhanNew(String maCN, String hoTen) {
		super();
		this.maCN = maCN;
		this.hoTen = hoTen;
	}
	public CongNhanNew(String maCN, String hoTen, boolean gioiTinh, String diaChi) {
		super();
		this.maCN = maCN;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
	}
	public CongNhanNew(String maCN, String hoTen, boolean gioiTinh) {
		super();
		this.maCN = maCN;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
	}
	public CongNhanNew(String maCN) {
		super();
		this.maCN = maCN;
	}
	@Override
	public String toString() {
		return "CongNhanNew [maCN=" + maCN + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", sDT=" + sDT
				+ ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", cCCD=" + cCCD + "]";
	}
	
	
}
