package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class GUI_TabpanelMenu extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabPane;
	private JButton reload;
	private JButton exit;
	private GUI_TabpanelQuanLyLuong tab;
	
//	private GUI_QuanLyHopDong qlhd;
	private Gui_qlsp qlsp;
	private GUI_ThongKe thongke;
	private GUI_TrangChu homee;
	private GUI_TabPanelQuanLyNhanSu tab1;
	private GUI_TabpanelChamCong chamcong;
	private GUI_TabpanelHopDong qlhd;
	private GUI_PhanCong pc;
	
	public GUI_TabpanelMenu() {
		setTitle("Chức Năng");
		setSize(1366,768);
		setLocationRelativeTo(null);
		setResizable(false);
		
		ImageIcon kh = new ImageIcon("data\\\\img\\\\kh.png");
		ImageIcon rel = new ImageIcon("data\\\\img\\\\icons8-process-24.png");
		ImageIcon exitt = new ImageIcon("data\\\\img\\\\icons8-exit-24.png");
		ImageIcon chart = new ImageIcon("data\\\\img\\\\icons8-chart-24.png");
		ImageIcon contract = new ImageIcon("data\\\\img\\\\icons8-contract-30.png");
		ImageIcon product = new ImageIcon("data\\\\img\\\\icons8-product-30.png");
		ImageIcon employee = new ImageIcon("data\\\\img\\\\icons8-employee-30.png");
		ImageIcon salary = new ImageIcon("data\\\\img\\\\icons8-salary-female-30.png");
		ImageIcon home = new ImageIcon("data\\\\img\\\\icons8-home-30.png");
		
		
		tabPane = new JTabbedPane();

		reload = new JButton("REFRESH");
		reload.setBackground(Color.white);
		exit = new JButton("Đăng Xuất");
		exit.setBackground(Color.white);
		
		tab = new GUI_TabpanelQuanLyLuong();
		tab1 = new GUI_TabPanelQuanLyNhanSu();
//		qlkh = new GUI_QuanLyKhachHang();
		qlhd = new GUI_TabpanelHopDong();
		qlsp = new Gui_qlsp();
		thongke = new GUI_ThongKe();
		homee = new GUI_TrangChu();
		chamcong = new GUI_TabpanelChamCong();
		pc = new GUI_PhanCong();
		
		
		JPanel pnl = new JPanel();
		tabPane.addTab("Trang Chủ", home,homee.getContentPane(),"Trang Chủ");
		tabPane.addTab("Quản Lý nhân Sự", employee,tab1.getContentPane(),"Quản Lý nhân Sự");
//		tabPane.addTab("Quản Lý Khách Hàng", kh,qlkh.getContentPane(),"Quản Lý Khách Hàng");
//		tabPane.addTab("Quản Lý Lương", salary,tab.getContentPane(),"Quản Lý Lương");
//		tabPane.addTab("Quản Chấm Công", salary,chamcong.getContentPane(),"Quản Lý Chấm Công");
		tabPane.addTab("Quản Lý Sản Phẩm", product,qlsp.getContentPane(),"Quản Lý Sản Phẩm");
		tabPane.addTab("Quản Lý Hợp Đồng", contract,qlhd.getContentPane(),"Quản Lý Hợp Đồng");
		tabPane.addTab("Phân Công Công Nhân", salary,pc.getContentPane(),"Phân Công Công Nhân");
		tabPane.addTab("Quản Lý Chấm Công", salary,chamcong.getContentPane(),"Quản Lý Chấm Công");
		tabPane.addTab("Quản Lý Lương", salary,tab.getContentPane(),"Quản Lý Lương");
		tabPane.addTab("Thống Kê", chart,thongke.getContentPane(),"Thống Kê");
		
		
		pnl.add(reload);
		reload.setIcon(rel);
		pnl.add(exit);
		exit.setIcon(exitt);
		this.add(tabPane);
		this.add(pnl,BorderLayout.SOUTH);
	
		

		reload.addActionListener(this);
		exit.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(reload)) {
			new GUI_TabpanelMenu().setVisible(true);
			this.setVisible(false);
		}
		if(o.equals(exit))
			System.exit(0);
	}		
	
//	public static void main(String[] args) {
//		new GUI_TabpanelMenu().setVisible(true);
//	}
}
	

