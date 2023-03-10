package entity;

import java.util.Objects;

public class ChamCongNhanVienNew {
	private String maCC;
	private String thangLuong;
	private String namLuong;
	private int soNgayLam;
	private int soGioTangCa;
	private NhanVienNew nv;
	private float tienUng;
	private TangCaNew tc;
	private HopDongNV hd;
	
	
	public ChamCongNhanVienNew()
	{
		super();
	}
     
	public ChamCongNhanVienNew(String maCC)
	{
		super();
		this.maCC=maCC;
	}

	public ChamCongNhanVienNew(String maCC, String thangLuong, String namLuong, int soNgayLam, int soGioTangCa,
			NhanVienNew nv, float tienUng, TangCaNew tc, HopDongNV hd) {
		super();
		this.maCC = maCC;
		this.thangLuong = thangLuong;
		this.namLuong = namLuong;
		this.soNgayLam = soNgayLam;
		this.soGioTangCa = soGioTangCa;
		this.nv = nv;
		this.tienUng = tienUng;
		this.tc = tc;
		this.hd = hd;
	}


	public String getMaCC() {
		return maCC;
	}


	public void setMaCC(String maCC) {
		this.maCC = maCC;
	}


	public String getThangLuong() {
		return thangLuong;
	}


	public void setThangLuong(String thangLuong) {
		this.thangLuong = thangLuong;
	}


	public String getNamLuong() {
		return namLuong;
	}


	public void setNamLuong(String namLuong) {
		this.namLuong = namLuong;
	}


	public int getSoNgayLam() {
		return soNgayLam;
	}


	public void setSoNgayLam(int soNgayLam) {
		this.soNgayLam = soNgayLam;
	}


	public int getSoGioTangCa() {
		return soGioTangCa;
	}


	public void setSoGioTangCa(int soGioTangCa) {
		this.soGioTangCa = soGioTangCa;
	}


	public NhanVienNew getNv() {
		return nv;
	}


	public void setNv(NhanVienNew nv) {
		this.nv = nv;
	}


	public float getTienUng() {
		return tienUng;
	}


	public void setTienUng(float tienUng) {
		this.tienUng = tienUng;
	}


	public TangCaNew getTc() {
		return tc;
	}


	public void setTc(TangCaNew tc) {
		this.tc = tc;
	}


	public HopDongNV getHd() {
		return hd;
	}


	public void setHd(HopDongNV hd) {
		this.hd = hd;
	}


	@Override
	public int hashCode() {
		return Objects.hash(maCC);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChamCongNhanVienNew other = (ChamCongNhanVienNew) obj;
		return Objects.equals(maCC, other.maCC);
	}


	@Override
	public String toString() {
		return "ChamCongNhanVienNew [maCC=" + maCC + ", thangLuong=" + thangLuong + ", namLuong=" + namLuong
				+ ", soNgayLam=" + soNgayLam + ", soGioTangCa=" + soGioTangCa + ", nv=" + nv + ", tienUng=" + tienUng
				+ ", tc=" + tc + ", hd=" + hd + "]";
	}
	
	
	
	
	

}
