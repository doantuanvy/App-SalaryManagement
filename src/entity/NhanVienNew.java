package entity;


import java.sql.Date;
import java.util.Objects;

public class NhanVienNew {
	private String maNV;
	private String hoTen;
	private boolean gioiTinh;
	private String sDT;
	private Date ngaySinh;
	private String diaChi;
	private String donViCongTac;
	private String cCCD;
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
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
	public String getDonViCongTac() {
		return donViCongTac;
	}
	public void setDonViCongTac(String donViCongTac) {
		this.donViCongTac = donViCongTac;
	}
	public String getcCCD() {
		return cCCD;
	}
	public void setcCCD(String cCCD) {
		this.cCCD = cCCD;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVienNew other = (NhanVienNew) obj;
		return Objects.equals(maNV, other.maNV);
	}
	public NhanVienNew() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NhanVienNew(String maNV) {
		super();
		this.maNV = maNV;
	}
	
	
	public NhanVienNew(String maNV, String hoTen, boolean gioiTinh, String donViCongTac) {
		super();
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.donViCongTac = donViCongTac;
	}
	public NhanVienNew(String maNV, String hoTen) {
		super();
		this.maNV = maNV;
		this.hoTen = hoTen;
	}
	public NhanVienNew(String maNV, String hoTen, boolean gioiTinh, String sDT, Date ngaySinh, String diaChi,
			String donViCongTac, String cCCD) {
		super();
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.sDT = sDT;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.donViCongTac = donViCongTac;
		this.cCCD = cCCD;
	}
	
	public NhanVienNew(String maNV, String hoTen, boolean gioiTinh) {
		super();
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
	}
	
	@Override
	public String toString() {
		return "NhanVienNew [maNV=" + maNV + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", sDT=" + sDT
				+ ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", donViCongTac=" + donViCongTac + ", cCCD=" + cCCD
				+ "]";
	}
	
	
}
