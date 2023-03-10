package entity;

import java.util.Objects;

public class PhanCong_tv {
	private String maString;
	private String giaiDoanString;
	private float donGia;
	
	private SanPham sPham;
	private CongNhanNew cNew;
	public String getMaString() {
		return maString;
	}
	public void setMaString(String maString) {
		this.maString = maString;
	}
	public String getGiaiDoanString() {
		return giaiDoanString;
	}
	public void setGiaiDoanString(String giaiDoanString) {
		this.giaiDoanString = giaiDoanString;
	}
	public float getDonGia() {
		return donGia;
	}
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	
	public SanPham getsPham() {
		return sPham;
	}
	public void setsPham(SanPham sPham) {
		this.sPham = sPham;
	}
	public CongNhanNew getcNew() {
		return cNew;
	}
	public void setcNew(CongNhanNew cNew) {
		this.cNew = cNew;
	}
	public PhanCong_tv() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PhanCong_tv(String giaiDoanString, SanPham sPham, CongNhanNew cNew) {
		super();
		this.giaiDoanString = giaiDoanString;
		this.sPham = sPham;
		this.cNew = cNew;
	}
	public PhanCong_tv(String maString, String giaiDoanString, float donGia, SanPham sPham, CongNhanNew cNew) {
		super();
		this.maString = maString;
		this.giaiDoanString = giaiDoanString;
		this.donGia = donGia;
		
		this.sPham = sPham;
		this.cNew = cNew;
	}
	
	public PhanCong_tv(String maString) {
		super();
		this.maString = maString;
	}
	
	
	public PhanCong_tv(String maString, String giaiDoanString, SanPham sPham, CongNhanNew cNew) {
		super();
		this.maString = maString;
		this.giaiDoanString = giaiDoanString;
		this.sPham = sPham;
		this.cNew = cNew;
	}
	@Override
	public String toString() {
		return "PhanCong [maString=" + maString + ", giaiDoanString=" + giaiDoanString + ", donGia=" + donGia
				+ ", sPham=" + sPham + ", cNew=" + cNew + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maString);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhanCong_tv other = (PhanCong_tv) obj;
		return Objects.equals(maString, other.maString);
	}
	
}
