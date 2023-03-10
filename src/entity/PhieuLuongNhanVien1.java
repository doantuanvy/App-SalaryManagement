package entity;

public class PhieuLuongNhanVien1 {
	private String maPLNV;
	private float thanhTien;
	private NhanVienNew nv;
	private float thucLanh;
	private float tienUng;
	private int soNgayLam;
	private int soGioTangCa;
	private String maNguoiCham;
	private int thangLuong;
	private int namLuong;
	public PhieuLuongNhanVien1()
	{
		super();
	}

	

	public PhieuLuongNhanVien1(String maPLNV, float thanhTien, NhanVienNew nv, float thucLanh, float tienUng,
			int soNgayLam, int soGioTangCa, String maNguoiCham, int thangLuong, int namLuong) {
		super();
		this.maPLNV = maPLNV;
		this.thanhTien = thanhTien;
		this.nv = nv;
		this.thucLanh = thucLanh;
		this.tienUng = tienUng;
		this.soNgayLam = soNgayLam;
		this.soGioTangCa = soGioTangCa;
		this.maNguoiCham = maNguoiCham;
		this.thangLuong = thangLuong;
		this.namLuong = namLuong;
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

	public float getThucLanh() {
		return thucLanh;
	}

	public void setThucLanh(float thucLanh) {
		this.thucLanh = thucLanh;
	}

	public float getTienUng() {
		return tienUng;
	}

	public void setTienUng(float tienUng) {
		this.tienUng = tienUng;
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

	public String getMaNguoiCham() {
		return maNguoiCham;
	}

	public void setMaNguoiCham(String maNguoiCham) {
		this.maNguoiCham = maNguoiCham;
	}



	@Override
	public String toString() {
		return "PhieuLuongNhanVien1 [maPLNV=" + maPLNV + ", thanhTien=" + thanhTien + ", nv=" + nv + ", thucLanh="
				+ thucLanh + ", tienUng=" + tienUng + ", soNgayLam=" + soNgayLam + ", soGioTangCa=" + soGioTangCa
				+ ", maNguoiCham=" + maNguoiCham + ", thangLuong=" + thangLuong + ", namLuong=" + namLuong + "]";
	}

	
	
	
	

}
