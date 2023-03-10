package entity;

import java.sql.Date;
import java.util.Objects;

public class ChamCongCN1 {
	private int maString;
	private CongNhanNew congNhanNew;
	private Date ngayCCDate;
	private boolean diemDanh;
	private int soSPHC;
	private int soSPTC;
	private NhanVienNew nguoiChamNew;
	public int getMaString() {
		return maString;
	}
	public void setMaString(Integer maString) {
		this.maString = maString;
	}
	public CongNhanNew getCongNhanNew() {
		return congNhanNew;
	}
	public void setCongNhanNew(CongNhanNew congNhanNew) {
		this.congNhanNew = congNhanNew;
	}
	public Date getNgayCCDate() {
		return ngayCCDate;
	}
	public void setNgayCCDate(Date ngayCCDate) {
		this.ngayCCDate = ngayCCDate;
	}
	public boolean isDiemDanh() {
		return diemDanh;
	}
	public void setDiemDanh(boolean diemDanh) {
		this.diemDanh = diemDanh;
	}
	public int getSoSPHC() {
		return soSPHC;
	}
	public void setSoSPHC(int soSPHC) {
		this.soSPHC = soSPHC;
	}
	public int getSoSPTC() {
		return soSPTC;
	}
	public void setSoSPTC(int soSPTC) {
		this.soSPTC = soSPTC;
	}
	public NhanVienNew getNguoiChamNew() {
		return nguoiChamNew;
	}
	public void setNguoiChamNew(NhanVienNew nguoiChamNew) {
		this.nguoiChamNew = nguoiChamNew;
	}
	public ChamCongCN1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChamCongCN1(Integer maString, CongNhanNew congNhanNew, Date ngayCCDate, boolean diemDanh, int soSPHC,
			int soSPTC, NhanVienNew nguoiChamNew) {
		super();
		this.maString = maString;
		this.congNhanNew = congNhanNew;
		this.ngayCCDate = ngayCCDate;
		this.diemDanh = diemDanh;
		this.soSPHC = soSPHC;
		this.soSPTC = soSPTC;
		this.nguoiChamNew = nguoiChamNew;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((congNhanNew == null) ? 0 : congNhanNew.hashCode());
		result = prime * result + ((ngayCCDate == null) ? 0 : ngayCCDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ChamCongCN1 other = (ChamCongCN1) obj;
		if (congNhanNew == null) {
			if (other.congNhanNew != null) {
				return false;
			}
		} else if (!congNhanNew.equals(other.congNhanNew)) {
			return false;
		}
		if (ngayCCDate == null) {
			if (other.ngayCCDate != null) {
				return false;
			}
		} else if (!ngayCCDate.equals(other.ngayCCDate)) {
			return false;
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
