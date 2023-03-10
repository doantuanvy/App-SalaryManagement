package entity;

public class TangCa1 {
	private String maTC;
	private String loaiCa;
	private float heSoLuong;
	private float donGia;
	
	public TangCa1()
	{
		super();
	}
	
	

	public TangCa1(String maTC, String loaiCa, float heSoLuong, float donGia) {
		super();
		this.maTC = maTC;
		this.loaiCa = loaiCa;
		this.heSoLuong = heSoLuong;
		this.donGia = donGia;
	}



	@Override
	public String toString() {
		return "TangCa1 [maTC=" + maTC + ", loaiCa=" + loaiCa + ", heSoLuong=" + heSoLuong + ", donGia=" + donGia + "]";
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
