
package entity;

public class DangNhap {
	private String taiKhoan;
	private String matKhau;
	
	private NguoiQuanLy ql;
	private NhanVienHanhChinh nv;
	public DangNhap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DangNhap(String taiKhoan, String matKhau, NhanVienHanhChinh nv, NguoiQuanLy ql) {
		super();
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.nv = nv;
		this.ql = ql;
	}

	public DangNhap(String taiKhoan, String matKhau, NhanVienHanhChinh nv) {
		super();
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.nv = nv;
	}

	public DangNhap(String taiKhoan, String matKhau, NguoiQuanLy ql) {
		super();
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.ql = ql;
	}

	public DangNhap(String taiKhoan) {
		super();
		this.taiKhoan = taiKhoan;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public NguoiQuanLy getQl() {
		return ql;
	}
	public void setQl(NguoiQuanLy ql) {
		this.ql = ql;
	}
	public NhanVienHanhChinh getNv() {
		return nv;
	}
	public void setNv(NhanVienHanhChinh nv) {
		this.nv = nv;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((taiKhoan == null) ? 0 : taiKhoan.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DangNhap other = (DangNhap) obj;
		if (taiKhoan == null) {
			if (other.taiKhoan != null)
				return false;
		} else if (!taiKhoan.equals(other.taiKhoan))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DangNhap [taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + ", ql=" + ql + ", nv=" + nv + "]";
	}
	
	
	
}
