package entity;

import java.sql.Date;
import java.util.Objects;

public class ChamCongNV1 {
	private int maString;
	private NhanVienNew nVienNew;
	private Date ngayCCDate;
	private Boolean diemDanhBoolean;
	private int soGioTC;
	private NhanVienNew nguoiChamCong;
	
	public int getMaString() {
		return maString;
	}
	public void setMaString(Integer maString) {
		this.maString = maString;
	}
	public NhanVienNew getnVienNew() {
		return nVienNew;
	}
	public void setnVienNew(NhanVienNew nVienNew) {
		this.nVienNew = nVienNew;
	}
	public Date getNgayCCDate() {
		return ngayCCDate;
	}
	public void setNgayCCDate(Date ngayCCDate) {
		this.ngayCCDate = ngayCCDate;
	}
	public Boolean getDiemDanhBoolean() {
		return diemDanhBoolean;
	}
	public void setDiemDanhBoolean(Boolean diemDanhBoolean) {
		this.diemDanhBoolean = diemDanhBoolean;
	}
	public int getSoGioTC() {
		return soGioTC;
	}
	public void setSoGioTC(int soGioTC) {
		this.soGioTC = soGioTC;
	}
	public NhanVienNew getNguoiChamCong() {
		return nguoiChamCong;
	}
	public void setNguoiChamCong(NhanVienNew nguoiChamCong) {
		this.nguoiChamCong = nguoiChamCong;
	}
	public ChamCongNV1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChamCongNV1(Integer maString, NhanVienNew nVienNew, Date ngayCCDate, Boolean diemDanhBoolean, int soGioTC,
			NhanVienNew nguoiChamCong) {
		super();
		this.maString = maString;
		this.nVienNew = nVienNew;
		this.ngayCCDate = ngayCCDate;
		this.diemDanhBoolean = diemDanhBoolean;
		this.soGioTC = soGioTC;
		this.nguoiChamCong = nguoiChamCong;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nVienNew, ngayCCDate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChamCongNV1 other = (ChamCongNV1) obj;
		return Objects.equals(nVienNew, other.nVienNew) && Objects.equals(ngayCCDate, other.ngayCCDate);
	}
	
	
}
