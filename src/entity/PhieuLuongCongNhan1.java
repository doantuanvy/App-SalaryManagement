package entity;

public class PhieuLuongCongNhan1 {
	private String maPLCN;
	private float thanhTien;
	private CongNhanNew cn;
	private float thucLanh;
	private float tienUng;
	private int tongSPHC;
	private int tongSPTC;
	private String maNguoiCham;
	private int thangLuong;
	private int namLuong;
	
	
	public PhieuLuongCongNhan1()
	{
		super();
		
	}


	public PhieuLuongCongNhan1(String maPLCN, float thanhTien, CongNhanNew cn, float thucLanh, float tienUng,
			int tongSPHC, int tongSPTC, String maNguoiCham, int thangLuong, int namLuong) {
		super();
		this.maPLCN = maPLCN;
		this.thanhTien = thanhTien;
		this.cn = cn;
		this.thucLanh = thucLanh;
		this.tienUng = tienUng;
		this.tongSPHC = tongSPHC;
		this.tongSPTC = tongSPTC;
		this.maNguoiCham = maNguoiCham;
		this.thangLuong = thangLuong;
		this.namLuong = namLuong;
	}


	public String getMaPLCN() {
		return maPLCN;
	}


	public void setMaPLCN(String maPLCN) {
		this.maPLCN = maPLCN;
	}


	public float getThanhTien() {
		return thanhTien;
	}


	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
	}


	public CongNhanNew getCn() {
		return cn;
	}


	public void setCn(CongNhanNew cn) {
		this.cn = cn;
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


	public int getTongSPHC() {
		return tongSPHC;
	}


	public void setTongSPHC(int tongSPHC) {
		this.tongSPHC = tongSPHC;
	}


	public int getTongSPTC() {
		return tongSPTC;
	}


	public void setTongSPTC(int tongSPTC) {
		this.tongSPTC = tongSPTC;
	}


	public String getMaNguoiCham() {
		return maNguoiCham;
	}


	public void setMaNguoiCham(String maNguoiCham) {
		this.maNguoiCham = maNguoiCham;
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


	@Override
	public String toString() {
		return "PhieuLuongCongNhan1 [maPLCN=" + maPLCN + ", thanhTien=" + thanhTien + ", cn=" + cn + ", thucLanh="
				+ thucLanh + ", tienUng=" + tienUng + ", tongSPHC=" + tongSPHC + ", tongSPTC=" + tongSPTC
				+ ", maNguoiCham=" + maNguoiCham + ", thangLuong=" + thangLuong + ", namLuong=" + namLuong + "]";
	}
	
	

}
