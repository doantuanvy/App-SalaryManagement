package entity;

import java.util.Objects;

public class PhanCongnew {
	private String maPC;
	private String giaiDoan;
	private float donGia;
	private SanPham sp;
	private CongNhanNew cn;
	
	public PhanCongnew()
	{
		super();
		
	}
	
	public PhanCongnew(String maPC)
	{
		super();
		this.maPC=maPC;
		
	}

	

	public PhanCongnew(String maPC, String giaiDoan, float donGia,SanPham sp, CongNhanNew cn) {
		super();
		this.maPC = maPC;
		this.giaiDoan = giaiDoan;
		this.donGia = donGia;
		this.sp = sp;
		this.cn = cn;
	}

	public String getMaPC() {
		return maPC;
	}

	public void setMaPC(String maPC) {
		this.maPC = maPC;
	}

	public String getGiaiDoan() {
		return giaiDoan;
	}

	public void setGiaiDoan(String giaiDoan) {
		this.giaiDoan = giaiDoan;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	

	public SanPham getSp() {
		return sp;
	}

	public void setSp(SanPham sp) {
		this.sp = sp;
	}

	public CongNhanNew getCn() {
		return cn;
	}

	public void setCn(CongNhanNew cn) {
		this.cn = cn;
	}

	

	@Override
	public String toString() {
		return "PhanCongnew [maPC=" + maPC + ", giaiDoan=" + giaiDoan + ", donGia=" + donGia + ", sp=" + sp + ", cn="
				+ cn + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPC);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhanCongnew other = (PhanCongnew) obj;
		return Objects.equals(maPC, other.maPC);
	}

	
	
	

}
