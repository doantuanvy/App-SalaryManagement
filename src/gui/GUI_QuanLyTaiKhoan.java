package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DAO_NguoiQuanLy;
import dao.DAO_NhanVienHanhChinh;
import dao.DAO_TaiKhoan;
import entity.DangNhap;
import entity.NguoiQuanLy;
import entity.NhanVienHanhChinh;

public class GUI_QuanLyTaiKhoan extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtMK;
	private JTextField txtTenTK;
	private DefaultTableModel model;
	private JButton btnThem;
	private JButton btnDelete;
	private JButton btnReset;
	private JButton btnXoaRong;
	private DAO_TaiKhoan tk_dao;
	private DAO_NhanVienHanhChinh nv_dao;
	private JComboBox<String> comboBoxMaNhanvien;
	private JComboBox<String> comboBoxloaiTK;
	private JComboBox<String> comboxMaQL;
	private DAO_NguoiQuanLy ql_dao;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI_QuanLyTaiKhoan frame = new GUI_QuanLyTaiKhoan();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public GUI_QuanLyTaiKhoan() {
		setBounds(100, 100, 1360, 680);
		contentPane = new JPanel();
		setTitle("Thông Tin Tài Khoản");
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try{
			ConnectDB.getInstance().connect();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		tk_dao = new DAO_TaiKhoan();
		nv_dao = new DAO_NhanVienHanhChinh();
		ql_dao = new DAO_NguoiQuanLy();
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(10, 10, 1327, 97);
		contentPane.add(panel_3);
		
		JLabel lblQunLThng = new JLabel("Quản Lý Thông Tin Tài Khoản");
		lblQunLThng.setFont(new Font("Tahoma", Font.ITALIC, 45));
		lblQunLThng.setBounds(336, 21, 660, 55);
		panel_3.add(lblQunLThng);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaptionBorder);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(11, 117, 1326, 299);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1306, 279);
		panel.add(scrollPane);
		
		String[] cols= {"Tên Tài Khoản","Mật Khẩu","Mã Nhân Viên","Mã Người Quản Lý"};
		model= new DefaultTableModel(cols,0);
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1.setBounds(10, 425, 1327, 127);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtMK = new JTextField();
		txtMK.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtMK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMK.setColumns(10);
		txtMK.setBounds(456, 72, 316, 27);
		panel_1.add(txtMK);
		
		txtTenTK = new JTextField();
		txtTenTK.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtTenTK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenTK.setColumns(10);
		txtTenTK.setBounds(456, 29, 316, 27);
		panel_1.add(txtTenTK);
		
		JLabel lblNewLabel_1 = new JLabel("Tên Tài Khoản:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(277, 26, 170, 33);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật Khẩu:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(326, 69, 95, 33);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mã Nhân Viên:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(821, 29, 170, 33);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Mã Người Quản Lý:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(782, 69, 191, 33);
		panel_1.add(lblNewLabel_1_1_1);
		
		comboBoxMaNhanvien = new JComboBox<String>();
		comboBoxMaNhanvien.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBoxMaNhanvien.setBounds(983, 29, 316, 27);
		panel_1.add(comboBoxMaNhanvien);
		
		comboBoxloaiTK = new JComboBox<String>();
		comboBoxloaiTK.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBoxloaiTK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBoxloaiTK.setModel(new DefaultComboBoxModel<String>(new String[] {"Tài Khoản cần Tạo", "Nhân Viên", "Quản Lý"}));
		comboBoxloaiTK.setBounds(10, 32, 242, 33);
		panel_1.add(comboBoxloaiTK);
		
		comboxMaQL = new JComboBox<String>();
		comboxMaQL.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboxMaQL.setBounds(983, 79, 316, 27);
		panel_1.add(comboxMaQL);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(SystemColor.activeCaptionBorder);
		panel_2.setBounds(10, 559, 1326, 74);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		 btnThem = new JButton("Thêm");
		 btnThem.setIcon(new ImageIcon("data\\img\\icons8-add-24.png"));
		btnThem.setFont(new Font("Serif", Font.PLAIN, 22));
		btnThem.setBounds(128, 10, 201, 40);
		panel_2.add(btnThem);
		
		 btnDelete = new JButton("Xóa");
		 btnDelete.setIcon(new ImageIcon("data\\img\\icons8-remove-24.png"));
		btnDelete.setFont(new Font("Serif", Font.PLAIN, 22));
		btnDelete.setBounds(385, 10, 188, 40);
		panel_2.add(btnDelete);
		
		 btnReset = new JButton("Reset Mật Khẩu");
		 btnReset.setIcon(new ImageIcon("data\\img\\icons8-process-24.png"));
		btnReset.setFont(new Font("Serif", Font.PLAIN, 22));
		btnReset.setBounds(610, 10, 226, 40);
		panel_2.add(btnReset);
		
		 btnXoaRong = new JButton("Xóa Rỗng");
		 btnXoaRong.setIcon(new ImageIcon("data\\img\\icons8-delete-key-24.png"));
		btnXoaRong.setFont(new Font("Serif", Font.PLAIN, 22));
		btnXoaRong.setBounds(875, 10, 201, 40);
		panel_2.add(btnXoaRong);
		
		btnDelete.addActionListener(this);
		btnReset.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoaRong.addActionListener(this);
		comboBoxMaNhanvien.addActionListener(this);
		comboBoxloaiTK.addActionListener(this);
		comboxMaQL.addActionListener(this);
		
		Doculieuvaotabel();
		updateComboboxDataNV();
		updateComboboxDataQL();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = table.getSelectedRow(); 
				if(row != -1){
					String ma = (String) table.getValueAt(row, 0);
					DangNhap tk = new DangNhap(ma);
					ArrayList<DangNhap> lstk = tk_dao.getALLTaiKhoan();
					if(tk_dao.getALLTaiKhoan().contains(tk)){
						tk = lstk.get(lstk.indexOf(tk));
						txtTenTK.setText(tk.getTaiKhoan() + "");
						txtTenTK.setEditable(false);
						txtMK.setText("1111");
						
					}
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThem)){
			String tk = txtTenTK.getText();
			String mk = txtMK.getText();
			String manv = comboBoxMaNhanvien.getSelectedItem().toString();
			int option = comboBoxloaiTK.getSelectedIndex();
			if(option == 0) {
				JOptionPane.showMessageDialog(this, "Cần Chọn Tài khoản Cần Tạo!");
			}
			if(option == 1) {
					if(kiemtra()) {
						comboxMaQL.setEditable(false);
						NhanVienHanhChinh nhanVienHanhChinh = new NhanVienHanhChinh(manv);
						DangNhap dn = new DangNhap(tk,mk,nhanVienHanhChinh);
						if(!tk_dao.getALLTaiKhoan().contains(dn)) {
							try {
								tk_dao.createNV(dn);
								JOptionPane.showMessageDialog(this, "Thêm thành Công!");
							} catch (Exception e2) {
								e2.printStackTrace();
							}	
						}else {
							JOptionPane.showMessageDialog(this, "Chú ý: Trùng Tên Đăng Nhập!");
						}
					}
			}
			
			if(option == 2) {
				if(kiemtra()) {
					NguoiQuanLy nguoiQuanLy = new NguoiQuanLy();
					DangNhap ql = new DangNhap(tk,mk,nguoiQuanLy);
					if(!tk_dao.getALLTaiKhoan().contains(ql)) {
						try {
							tk_dao.createQL(ql);
							JOptionPane.showMessageDialog(this, "Thêm thành Công!");
						} catch (Exception e2) {
							e2.printStackTrace();
						}	
					}else {
						JOptionPane.showMessageDialog(this, "Chú ý: Trùng Tên Đăng Nhập!");
					}
				}
		}
			
	
	}
		
		if(o.equals(btnXoaRong)){
			txtTenTK.setText("");
			txtMK.setText("");
			txtTenTK.setEditable(true);
			txtTenTK.requestFocus();
		}
		if(o.equals(btnReset)){
			int row = table.getSelectedRow();
			if(row>=0) {
				DangNhap dn = suatk();
				if(tk_dao.Updata(dn)) {
					table.setValueAt("*********", row, 1);
					txtTenTK.setEditable(false);
				}
			}
		}
		if(o.equals(btnDelete)) {
			int row = table.getSelectedRow();
			if(row != -1){
				int hoiNhac = JOptionPane.showConfirmDialog(this, "Chắc chắn xóa không? ", "Chú ý", JOptionPane.YES_NO_OPTION);
				if(hoiNhac == JOptionPane.YES_OPTION){
					String tenTK = (String) table.getValueAt(row, 0);
					if(tk_dao.delete(tenTK)) {
						model.removeRow(row);
						txtMK.setText("");
						txtTenTK.setText("");
				}
			}
		}
	}
		
}
	
	private void updateComboboxDataNV() {
		int n = nv_dao.getAllNhanVienHanhChinh().size(); 
		String []items = new String[n];
		int i = 0;
		for(NhanVienHanhChinh nv : nv_dao.getAllNhanVienHanhChinh()){
			items[i] = String.valueOf(nv.getMaNhanVien());
			i++;
		}
		comboBoxMaNhanvien.setModel(new DefaultComboBoxModel<String>(items));
	}
	
	private void updateComboboxDataQL() {
		int n = ql_dao.getAllNguoiQuanLy().size(); 
		String []items = new String[n];
		int i = 0;
		for(NguoiQuanLy nv : ql_dao.getAllNguoiQuanLy()){
			items[i] = String.valueOf(nv.getMaNguoiQuanLy());
			i++;
		}
		comboxMaQL.setModel(new DefaultComboBoxModel<String>(items));
	}
	
	private DangNhap suatk() {
		try {
				String TK = txtTenTK.getText();
				String MK = txtMK.getText();
				return new DangNhap(TK,MK,null,null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void Doculieuvaotabel(){
		List<DangNhap> list = tk_dao.getALLTaiKhoan();
		for (DangNhap tk :list) {
					model.addRow(new Object[] {
							tk.getTaiKhoan(),
							"*********",
							tk.getNv().getMaNhanVien(),
							tk.getQl().getMaNguoiQuanLy()
					});			
		}
	}
	
	private boolean kiemtra() {
		String tentk = txtTenTK.getText().trim();
		String mk = txtMK.getText().trim();
		
		if(!(tentk.length() > 0 && tentk.matches("[A-Z0-9]{3,8}$"))) {
			JOptionPane.showMessageDialog(this, "Chú ý: Nhập mã sai cú pháp! (mã phải nhập chữ in hoa không dấu và số độ dài 3-8)");
			return false;
		}
		if (!(mk.length() > 0 && mk.matches("[A-Za-z0-9]+"))) {
			JOptionPane.showMessageDialog(this,"Chú ý: Nhập tên sai cú pháp! (Phải Nhập Số, chữ không dấu)");
			return false;
		}
		
		return true;
	}
}
