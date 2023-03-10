package gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;



public class GUI_TabPanelQuanLyNhanSu extends  JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabPane;
	private GUI_QuanLyNhanVienHanhChinh qlnvhc;
	private GUI_QuanLyCongNhan qlcn;
	public GUI_TabPanelQuanLyNhanSu() {
		
		setTitle("Quản Lý Nhân Sự");
		setSize(1461,750);
		setLocationRelativeTo(null);
		setResizable(false);
		
		ImageIcon nv = new ImageIcon("icon/nv.png");
		

		tabPane = new JTabbedPane();
		
		qlnvhc = new GUI_QuanLyNhanVienHanhChinh();
		qlcn = new GUI_QuanLyCongNhan();

		tabPane.addTab("Quản Lý Nhân Viên", nv,qlnvhc.getContentPane(),"Quản Lý Nhân Viên");
		tabPane.addTab("Quản Lý Công Nhân", nv,qlcn.getContentPane(),"Quản Lý Công Nhân");
		
		add(tabPane);
	}
//	public static void main(String[] args) {
//		new GUI_TabPanelQuanLyNhanSu().setVisible(true);
//	}
		
}
	

