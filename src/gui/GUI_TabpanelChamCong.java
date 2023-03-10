package gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class GUI_TabpanelChamCong extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabPane;
	private GUI_CHAMCONGCN cccn;
	private GUI_CHAMCONGNV ccnv;
	public GUI_TabpanelChamCong() {
		
		setTitle("Quản Chấm Công");
		setSize(1360,680);
		setLocationRelativeTo(null);
		setResizable(false);
		
		ImageIcon nv = new ImageIcon("icon/nv.png");
		

		tabPane = new JTabbedPane();
		
		cccn = new GUI_CHAMCONGCN();
		ccnv = new GUI_CHAMCONGNV();
		
		tabPane.addTab("Chấm Công Nhân Viên", nv,ccnv.getContentPane(),"Chấm Công Nhân Viên");
		tabPane.addTab("Chấm Công Công Nhân", nv,cccn.getContentPane(),"Chấm Công Công Nhân");
		
		add(tabPane);
	}
//	public static void main(String[] args) {
//		new GUI_TabpanelChamCong().setVisible(true);
//	}

}
