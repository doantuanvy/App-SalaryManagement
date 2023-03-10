package entity;

import java.util.Objects;

public class TangCaNew {
	private String maTC;
	private String loaiCa;
	private float heSoLuong;
	private float donGia;
	
	public TangCaNew()
	{
		super();
	}
	
	public TangCaNew(String maTC)
	{
		super();
		this.maTC=maTC;
	}
	
	
	
	public TangCaNew(String maTC, String loaiCa, float heSoLuong, float donGia) {
		super();
		this.maTC = maTC;
		this.loaiCa = loaiCa;
		this.heSoLuong = heSoLuong;
		this.donGia = donGia;
	}
	
	



	@Override
	public String toString() {
		return "TangCaNew [maTC=" + maTC + ", loaiCa=" + loaiCa + ", heSoLuong=" + heSoLuong + ", donGia=" + donGia
				+ "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(maTC);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TangCaNew other = (TangCaNew) obj;
		return Objects.equals(maTC, other.maTC);
	}
	public String getMaTC() {
		return maTC;
	}
	public void setMaTC(String maTC) {
		this.maTC = maTC;
	}
	public String getLoaiCa() {
		return loaiCa;
	}
	public void setLoaiCa(String loaiCa) {
		this.loaiCa = loaiCa;
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
	
	
	
	

}
