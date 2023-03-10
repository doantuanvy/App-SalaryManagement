package entity;

import java.util.Objects;

public class ChamCongNV {
	private String maString;
	private int thang;
	private int nam;
	private int soNgayLam;
	private int soGioTC;
	private double tienUng;
	private NhanVienNew nVienNew;
	private HopDongNV hopDongNV;
	private TangCa tangCa;
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
	public int getSoNgayLam() {
		return soNgayLam;
	}
	public void setSoNgayLam(int soNgayLam) {
		this.soNgayLam = soNgayLam;
	}
	public int getSoGioTC() {
		return soGioTC;
	}
	public void setSoGioTC(int soGioTC) {
		this.soGioTC = soGioTC;
	}
	public double getTienUng() {
		return tienUng;
	}
	public void setTienUng(double tienUng) {
		this.tienUng = tienUng;
	}
	public NhanVienNew getnVienNew() {
		return nVienNew;
	}
	public void setnVienNew(NhanVienNew nVienNew) {
		this.nVienNew = nVienNew;
	}
	public HopDongNV getHopDongNV() {
		return hopDongNV;
	}
	public void setHopDongNV(HopDongNV hopDongNV) {
		this.hopDongNV = hopDongNV;
	}
	public TangCa getTangCa() {
		return tangCa;
	}
	public void setTangCa(TangCa tangCa) {
		this.tangCa = tangCa;
	}
	public ChamCongNV() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChamCongNV(String maString, int thang, int nam, int soNgayLam, int soGioTC, double tienUng,
			NhanVienNew nVienNew, HopDongNV hopDongNV, TangCa tangCa) {
		super();
		this.maString = maString;
		this.thang = thang;
		this.nam = nam;
		this.soNgayLam = soNgayLam;
		this.soGioTC = soGioTC;
		this.tienUng = tienUng;
		this.nVienNew = nVienNew;
		this.hopDongNV = hopDongNV;
		this.tangCa = tangCa;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(hopDongNV, nam, thang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChamCongNV other = (ChamCongNV) obj;
		return Objects.equals(hopDongNV, other.hopDongNV) && nam == other.nam && thang == other.thang;
	}
	@Override
	public String toString() {
		return "ChamCongNV [maString=" + maString + ", thang=" + thang + ", nam=" + nam + ", soNgayLam=" + soNgayLam
				+ ", soGioTC=" + soGioTC + ", tienUng=" + tienUng + ", nVienNew=" + nVienNew + ", hopDongNV="
				+ hopDongNV + ", tangCa=" + tangCa + "]";
	}
	
}
