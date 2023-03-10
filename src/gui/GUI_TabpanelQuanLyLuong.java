package gui;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;



public class GUI_TabpanelQuanLyLuong extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabPane;
	private GUI_QuanLyLuongCongNhan1 qllcn;
	private GUI_QuanLyLuongNhanVien1 qllnv;
	
	public GUI_TabpanelQuanLyLuong() {
		
		setTitle("Quản Lý Lương");
		setSize(1360,680);
		setLocationRelativeTo(null);
		setResizable(false);
		
		ImageIcon nv = new ImageIcon("icon/nv.png");
		

		tabPane = new JTabbedPane();
		
		qllcn = new GUI_QuanLyLuongCongNhan1();
		qllnv = new GUI_QuanLyLuongNhanVien1();
	
		tabPane.addTab("Quản Lý Lương Nhân Viên", nv,qllnv.getContentPane(),"Quản Lý Lương Nhân Viên");
		tabPane.addTab("Quản Lý Lương Công Nhân", nv,qllcn.getContentPane(),"Quản Lý Lương Công Nhân");
		
		
		add(tabPane);
	}
//	public static void main(String[] args) {
//		new GUI_TabpanelQuanLyLuong().setVisible(true);
//	}
		
}
	

