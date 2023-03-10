package entity;

import java.util.Objects;

public class ChamCongCN {
	private String maString;
	private int thang;
	private int nam;
	private int soLuongHC;
	private double tienUng;
	private int soLuongTC;
	private CongNhanNew cNew;
	private TangCa tCa;
	private PhanCong_tv pCong;
	public String getMaString() {
		return maString;
	}
	public void setMaString(String maString) {
		this.maString = maString;
	}
	public int getThang() {
		return thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public int getNam() {
		return nam;
	}
	public void setNam(int nam) {
		this.nam = nam;
	}
	public int getSoLuongHC() {
		return soLuongHC;
	}
	public void setSoLuongHC(int soLuongHC) {
		this.soLuongHC = soLuongHC;
	}
	public double getTienUng() {
		return tienUng;
	}
	public void setTienUng(double tienUng) {
		this.tienUng = tienUng;
	}
	public int getSoLuongTC() {
		return soLuongTC;
	}
	public void setSoLuongTC(int soLuongTC) {
		this.soLuongTC = soLuongTC;
	}
	public CongNhanNew getcNew() {
		return cNew;
	}
	public void setcNew(CongNhanNew cNew) {
		this.cNew = cNew;
	}
	public TangCa gettCa() {
		return tCa;
	}
	public void settCa(TangCa tCa) {
		this.tCa = tCa;
	}
	public PhanCong_tv getpCong() {
		return pCong;
	}
	public void setpCong(PhanCong_tv pCong) {
		this.pCong = pCong;
	}
	public ChamCongCN() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChamCongCN(String maString, int thang, int nam, int soLuongHC, double tienUng, int soLuongTC,
			CongNhanNew cNew, TangCa tCa, PhanCong_tv pCong) {
		super();
		this.maString = maString;
		this.thang = thang;
		this.nam = nam;
		this.soLuongHC = soLuongHC;
		this.tienUng = tienUng;
		this.soLuongTC = soLuongTC;
		this.cNew = cNew;
		this.tCa = tCa;
		this.pCong = pCong;
	}
	public ChamCongCN(String maString) {
		super();
		this.maString = maString;
	}
	
	@Override
	public String toString() {
		return "ChamCongCN [maString=" + maString + ", thang=" + thang + ", nam=" + nam + ", soLuongHC=" + soLuongHC
				+ ", tienUng=" + tienUng + ", soLuongTC=" + soLuongTC + ", cNew=" + cNew + ", tCa=" + tCa + ", pCong="
				+ pCong + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(pCong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChamCongCN other = (ChamCongCN) obj;
		return Objects.equals(pCong, other.pCong);
	}
	
}
