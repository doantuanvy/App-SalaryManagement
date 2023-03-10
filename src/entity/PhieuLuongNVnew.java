package entity;

import java.util.Objects;

public class PhieuLuongNVnew {
	private String maPLNV;
	private float thanhTien;
	private NhanVienNew nv;
	private ChamCongNhanVienNew cc;
	
	public PhieuLuongNVnew()
	{
		super();
	}
	
	public PhieuLuongNVnew(String maPLNV)
	{
		super();
		this.maPLNV=maPLNV;
	}
	
	public PhieuLuongNVnew(String maPLNV, float thanhTien, NhanVienNew nv, ChamCongNhanVienNew cc) {
		super();
		this.maPLNV = maPLNV;
		this.thanhTien = thanhTien;
		this.nv = nv;
		this.cc = cc;
	}

	public String getMaPLNV() {
		return maPLNV;
	}

	public void setMaPLNV(String maPLNV) {
		this.maPLNV = maPLNV;
	}

	public float getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
	}

	public NhanVienNew getNv() {
		return nv;
	}

	public void setNv(NhanVienNew nv) {
		this.nv = nv;
	}

	public ChamCongNhanVienNew getCc() {
		return cc;
	}

	public void setCc(ChamCongNhanVienNew cc) {
		this.cc = cc;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPLNV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhieuLuongNVnew other = (PhieuLuongNVnew) obj;
		return Objects.equals(maPLNV, other.maPLNV);
	}

	@Override
	public String toString() {
		return "PhieuLuongNVnew [maPLNV=" + maPLNV + ", thanhTien=" + thanhTien + ", nv=" + nv + ", cc=" + cc + "]";
	}
	
	
	
	

}
