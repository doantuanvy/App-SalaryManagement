package entity;

import java.util.Objects;

public class ChamCongCongNhanNew {
	private String maCC;
	private int thangLuong;
	private int namLuong;
	private int soLuongHT;
	private CongNhanNew cn;
	private PhanCongnew pc;
	private float tienUng;
	private int soLuongTC;
	private TangCaNew tc;
	
	
	public ChamCongCongNhanNew()
	{
		super();
	}

	public ChamCongCongNhanNew(String maCC)
	{
		super();
		this.maCC=maCC;
	}
	public ChamCongCongNhanNew(String maCC, int thangLuong, int namLuong, int soLuongHT, CongNhanNew cn, PhanCongnew pc,
			float tienUng, int soLuongTC, TangCaNew tc) {
		super();
		this.maCC = maCC;
		this.thangLuong = thangLuong;
		this.namLuong = namLuong;
		this.soLuongHT = soLuongHT;
		this.cn = cn;
		this.pc = pc;
		this.tienUng = tienUng;
		this.soLuongTC = soLuongTC;
		this.tc = tc;
	}

	public String getMaCC() {
		return maCC;
	}

	public void setMaCC(String maCC) {
		this.maCC = maCC;
	}

	public int getThangLuong() {
		return thangLuong;
	}

	public void setThangLuong(int thangLuong) {
		this.thangLuong = thangLuong;
	}

	public int getNamLuong() {
		return namLuong;
	}

	public void setNamLuong(int namLuong) {
		this.namLuong = namLuong;
	}

	public int getSoLuongHT() {
		return soLuongHT;
	}

	public void setSoLuongHT(int soLuongHT) {
		this.soLuongHT = soLuongHT;
	}

	public CongNhanNew getCn() {
		return cn;
	}

	public void setCn(CongNhanNew cn) {
		this.cn = cn;
	}

	public PhanCongnew getPc() {
		return pc;
	}

	public void setPc(PhanCongnew pc) {
		this.pc = pc;
	}

	public float getTienUng() {
		return tienUng;
	}

	public void setTienUng(float tienUng) {
		this.tienUng = tienUng;
	}

	public int getSoLuongTC() {
		return soLuongTC;
	}

	public void setSoLuongTC(int soLuongTC) {
		this.soLuongTC = soLuongTC;
	}

	public TangCaNew getTc() {
		return tc;
	}

	public void setTc(TangCaNew tc) {
		this.tc = tc;
	}

	@Override
	public String toString() {
		return "ChamCongCongNhanNew [maCC=" + maCC + ", thangLuong=" + thangLuong + ", namLuong=" + namLuong
				+ ", soLuongHT=" + soLuongHT + ", cn=" + cn + ", pc=" + pc + ", tienUng=" + tienUng + ", soLuongTC="
				+ soLuongTC + ", tc=" + tc + "]";
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
		ChamCongCongNhanNew other = (ChamCongCongNhanNew) obj;
		return Objects.equals(maCC, other.maCC);
	}
	
	
	
	

}
