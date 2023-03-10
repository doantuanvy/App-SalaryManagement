package gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class GUI_TabpanelHopDong extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabPane;
	private GUI_QuanLyHDSP hdsp;
	private GUI_QuanLiHDNV hdnv;
	public GUI_TabpanelHopDong() {
		
		setTitle("Quản Lý Hợp Đồng");
		setSize(1360,680);
		setLocationRelativeTo(null);
		setResizable(false);
		
		ImageIcon nv = new ImageIcon("icon/nv.png");
		

		tabPane = new JTabbedPane();
		
		hdsp = new GUI_QuanLyHDSP();
		hdnv = new GUI_QuanLiHDNV();
		
		tabPane.addTab("Hợp Đồng Nhân Viên", nv,hdnv.getContentPane(),"Quản Lý Hợp Đồng Nhân Viên");
		tabPane.addTab("Hợp Đồng Sản Phẩm", nv,hdsp.getContentPane(),"Quản Lý Hợp Đồng Sản Phẩm");
		
		add(tabPane);
	}
//	public static void main(String[] args) {
//		new GUI_TabpanelHopDong().setVisible(true);
//	}

}