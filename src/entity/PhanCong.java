package entity;

public class PhanCong {
	private String maPhanCong;
	private String giaDoan;
	private double donGia;
	private CongNhanNew maCongNhan;
	private SanPham maSanPham;
	public String getMaPhanCong() {
		return maPhanCong;
	}
	public void setMaPhanCong(String maPhanCong) {
		this.maPhanCong = maPhanCong;
	}
	public String getGiaDoan() {
		return giaDoan;
	}
	public void setGiaDoan(String giaDoan) {
		this.giaDoan = giaDoan;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public CongNhanNew getMaCongNhan() {
		return maCongNhan;
	}
	public void setMaCongNhan(CongNhanNew maCongNhan) {
		this.maCongNhan = maCongNhan;
	}
	public SanPham getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(SanPham maSanPham) {
		this.maSanPham = maSanPham;
	}
	public PhanCong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhanCong(String maPhanCong, String giaDoan, double donGia, CongNhanNew congNhan, SanPham maSanPham) {
		super();
		this.maPhanCong = maPhanCong;
		this.giaDoan = giaDoan;
		this.donGia = donGia;
		this.maCongNhan = congNhan;
		this.maSanPham = maSanPham;
	}
	
	
}
