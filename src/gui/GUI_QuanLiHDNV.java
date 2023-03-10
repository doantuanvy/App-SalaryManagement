package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;
import connectDB.ConnectDB;
import dao.DAO_HopDongNV;
import entity.HopDongNV;
import entity.NhanVienNew;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.LineBorder;

public class GUI_QuanLiHDNV extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	Thuộc tính
	private JPanel quanLyHopdong;
	private JTable tableQLHD;
	private JTextField timKiem;

	private DAO_HopDongNV hopDong_DAO;
	private DefaultTableModel modelHopDong;
	private JButton them;
	private JButton sua;
	private JButton xoa;
	private JComboBox<String> loaiTimKiem;
	
	

//-------  Dành cho JFame nhập và sửa
	private JPanel themHD;
	
	private JTextField textFieldMaHD;
	private JButton xoaRong;
	private JButton thoat;
	private JButton themHopDong;
	private JFrame nhap_SuaHD;
	private JButton suaHD;
	private JDatePickerImpl ngayTaoHD;
	private JDatePickerImpl ngayHetHanHD;
	private JButton btnLocHDHetHan;
	private JLabel lblNewLabel;
	private DefaultTableModel modelNV;
	private JScrollPane scrollPaneTableNV;
	private JTable tableNV;
	private JTextField textFieldMaNV;
	
	private JTextField textFieldLuongCoBan;
	private JTextField textFieldHeSoLuong;
	
	private JTextField textFieldMaNV1;
	private TableRowSorter<TableModel> filter;

	
//--------------------------------------
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI_QuanLiHDNV frame = new GUI_QuanLiHDNV();
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
//	Hàm khởi tạo màn hình quản lý hợp đồng
	@SuppressWarnings("deprecation")
	public GUI_QuanLiHDNV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 680);
		setLocationRelativeTo(null);
		setResizable(false);
		
		quanLyHopdong = new JPanel();
		quanLyHopdong.setBackground(new Color(255, 140, 0));
		quanLyHopdong.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(quanLyHopdong);
		quanLyHopdong.setLayout(null);
		
		
		modelHopDong = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã hợp đồng", "Ngày bắt đầu", "Ngày hết hạn", "Hệ số lương", "Lương cơ bản", "Mã nhân viên"
				}
			);
		modelNV= new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã nhân viên", "Họ và tên","Giới tính"
				}
			);
		
		JPanel panelChucNang = new JPanel();
		panelChucNang.setBorder(new LineBorder(Color.ORANGE));
		panelChucNang.setBackground(Color.WHITE);
//		panelChucNang.setBounds(10, 304, 468, 347);
		panelChucNang.setBounds(10, 40, 469, 611);
		quanLyHopdong.add(panelChucNang);
		panelChucNang.setLayout(null);
		
		timKiem = new JTextField();
		timKiem.setToolTipText("Nhập để tìm kiếm");
		timKiem.setBounds(10, 120, 273, 29);
		panelChucNang.add(timKiem);
		timKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		timKiem.setColumns(10);
		

		
		loaiTimKiem = new JComboBox<String>();
		loaiTimKiem.setToolTipText("Tùy chọn để tìm kiếm");
		loaiTimKiem.setBackground(new Color(245, 222, 179));
		loaiTimKiem.setBounds(293, 120, 165, 29);
		panelChucNang.add(loaiTimKiem);
		loaiTimKiem.setModel(new DefaultComboBoxModel<String>(new String[] {"Tìm theo mã hợp đồng", "Tìm theo mã nhân viên"}));
		
		them = new JButton("Thêm hợp đồng");
		them.setToolTipText("Thêm mới một hợp đồng");
		them.setBackground(new Color(224, 255, 255));
		them.setBounds(10, 56, 140, 29);
		panelChucNang.add(them);
		them.setFont(new Font("Tahoma", Font.PLAIN, 15));
		xoa = new JButton("Xóa hợp đồng");
		xoa.setToolTipText("Xóa một hợp đồng");
		xoa.setBackground(new Color(250, 250, 210));
		xoa.setBounds(318, 56, 140, 29);
		panelChucNang.add(xoa);
		xoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		sua = new JButton("Sửa hợp đồng ");
		sua.setToolTipText("Sửa một hợp hợp đồng");
		sua.setBackground(new Color(255, 239, 213));
		sua.setBounds(164, 56, 140, 29);
		panelChucNang.add(sua);
		sua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblChucNang = new JLabel("Tùy chọn");
		lblChucNang.setFont(new Font("Sitka Display", Font.PLAIN, 27));
		lblChucNang.setHorizontalAlignment(SwingConstants.LEFT);
		lblChucNang.setBounds(10, 0, 109, 34);
		panelChucNang.add(lblChucNang);
		
		
		
		btnLocHDHetHan = new JButton("Lọc hợp đồng hết hạn");
		btnLocHDHetHan.setToolTipText("lọc hợp đồng đã hết hạn");
		btnLocHDHetHan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLocHDHetHan.setBackground(new Color(224, 255, 255));
		btnLocHDHetHan.setBounds(152, 246, 165, 29);
		panelChucNang.add(btnLocHDHetHan);
		
		
		sua.addActionListener(this);
		xoa.addActionListener(this);
		
		JPanel panelQLHD = new JPanel();
		panelQLHD.setBorder(new LineBorder(Color.ORANGE));
		panelQLHD.setBackground(Color.WHITE);
//		panelQLHD.setBounds(479, 304, 875, 347);
		panelQLHD.setBounds(478, 40, 876, 611);
		quanLyHopdong.add(panelQLHD);
		panelQLHD.setLayout(null);
		
		JScrollPane scrollPaneTableQLHD = new JScrollPane();
		scrollPaneTableQLHD.setBounds(10, 39, 855, 297);
		panelQLHD.add(scrollPaneTableQLHD);
		tableQLHD = new JTable(modelHopDong);
		tableQLHD.setBackground(Color.WHITE);
		tableQLHD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPaneTableQLHD.setViewportView(tableQLHD);
		
		scrollPaneTableNV = new JScrollPane();
		scrollPaneTableNV.setBounds(10, 346, 855, 255);
		panelQLHD.add(scrollPaneTableNV);
		tableNV = new JTable(modelNV);
		tableNV.setBackground(Color.WHITE);
		tableNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPaneTableNV.setViewportView(tableNV);
		
		JLabel tieuDe = new JLabel("Hợp đồng");
		tieuDe.setBounds(10, 0, 120, 40);
		panelQLHD.add(tieuDe);
		tieuDe.setFont(new Font("Sitka Display", Font.PLAIN, 27));
		tieuDe.setHorizontalAlignment(SwingConstants.LEFT);

		
		JPanel panelTieuDe = new JPanel();
		panelTieuDe.setBorder(new LineBorder(Color.ORANGE));
		panelTieuDe.setBackground(new Color(211, 211, 211));
		panelTieuDe.setBounds(10, 0, 1344, 30);
		quanLyHopdong.add(panelTieuDe);
		panelTieuDe.setLayout(null);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("data\\\\img\\\\login.png"));
		lblNewLabel.setText("  "+GUI_DangNhap.getDnma());
		lblNewLabel.setBounds(1217, 0, 117, 30);
		panelTieuDe.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(10, 0, 391, 30);
		java.util.Date date = new java.util.Date();
		lblNewLabel_1.setText(date.getDate()+"/"+(date.getMonth()+1)+"/"+(date.getYear()+1900));
		panelTieuDe.add(lblNewLabel_1);
		
		them.addActionListener(this);
		loaiTimKiem.addActionListener(this);
		timKiem.addActionListener(this);
		
	
		btnLocHDHetHan.addActionListener(this);
		
//==================================================================================================================================================
//		Khởi tạo màn hình thêm - sửa hợp đồng
		nhap_SuaHD = new JFrame();
		nhap_SuaHD.setBounds(100, 100, 600, 635);
		nhap_SuaHD.setLocationRelativeTo(null);
		nhap_SuaHD.setResizable(false);
		themHD = new JPanel();
		themHD.setBorder(new LineBorder(Color.ORANGE));
		themHD.setBackground(new Color(245, 255, 250));
		themHD.setBorder(new EmptyBorder(5, 5, 5, 5));
		nhap_SuaHD.setContentPane(themHD);
		themHD.setLayout(null);

		JLabel tieuDeThemHD = new JLabel("Thông tin hợp đồng");
		tieuDeThemHD.setBounds(0, 0, 594, 58);
		tieuDeThemHD.setFont(new Font("Tahoma", Font.BOLD, 23));
		tieuDeThemHD.setHorizontalAlignment(SwingConstants.CENTER);
		themHD.add(tieuDeThemHD);
		
		JLabel maHD = new JLabel("Mã hợp đồng: ");
		maHD.setBounds(59, 69, 84, 22);
		themHD.add(maHD);
		
		
		
		JLabel ngayTao = new JLabel("Ngày bắt đầu:  ");
		ngayTao.setBounds(59, 101, 84, 22);
		themHD.add(ngayTao);
		
		JLabel heSoLuong = new JLabel("Hệ số lương: ");
		heSoLuong.setBounds(59, 263, 119, 22);
		themHD.add(heSoLuong );
		
		JLabel luongCoBan = new JLabel("Lương cơ bản: ");
		luongCoBan.setBounds(59, 219, 98, 22);
		themHD.add(luongCoBan);
		
		JLabel ngayHetHan = new JLabel("Ngày hết hạn:");
		ngayHetHan.setBounds(59, 133, 84, 22);
		themHD.add(ngayHetHan);
		
		textFieldHeSoLuong = new JTextField();
		textFieldHeSoLuong.setToolTipText("Nhập hệ số lương");
		textFieldHeSoLuong.setBounds(181, 265, 329, 20);
		themHD.add(textFieldHeSoLuong);
		textFieldHeSoLuong.setColumns(10);
		
		textFieldLuongCoBan = new JTextField();
		textFieldLuongCoBan.setToolTipText("Nhập lương cơ bản");
		textFieldLuongCoBan.setColumns(10);
		textFieldLuongCoBan.setBounds(181, 221, 329, 20);
		themHD.add(textFieldLuongCoBan);
		
		SqlDateModel modelngayTaoHD = new SqlDateModel();
		Properties pngayTaoHD =  new Properties();
		pngayTaoHD.put("text.date", "date");
		pngayTaoHD.put("text.month", "month");
		pngayTaoHD.put("text.year", "year");
		JDatePanelImpl implngayTaoHD = new JDatePanelImpl(modelngayTaoHD, pngayTaoHD);
		ngayTaoHD = new JDatePickerImpl(implngayTaoHD, new AbstractFormatter() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@Override
			public String valueToString(Object value) throws ParseException {
				if(value != null) {
					Calendar cal = (Calendar) value;
					SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
					String strDate = format.format(cal.getTime());
					return strDate;
				}
				return "";
			}
			@Override
			public Object stringToValue(String text) throws ParseException {
				
				return null;
			}
		});
		ngayTaoHD.setToolTipText("Chọn ngày bắt đầu");
		((JDatePickerImpl) ngayTaoHD).getJFormattedTextField().setBackground(new Color(250, 250, 210));
		ngayTaoHD.setBackground(new Color(250, 250, 210));
		ngayTaoHD.setBounds(181, 101, 329, 25);
		themHD.add(ngayTaoHD);
		
		
	
		
		textFieldMaHD = new JTextField();
		textFieldMaHD.setToolTipText("Mã hợp đồng tạo tự động");
		textFieldMaHD.setColumns(10);
		textFieldMaHD.setBounds(181, 69, 329, 20);
		textFieldMaHD.setEditable(false);
		themHD.add(textFieldMaHD);
		
		SqlDateModel modelHetHanHD = new SqlDateModel();
		Properties pHetHanHD =  new Properties();
		pHetHanHD.put("text.date", "date");
		pHetHanHD.put("text.month", "month");
		pHetHanHD.put("text.year", "year");
		JDatePanelImpl implHetHanHD = new JDatePanelImpl(modelHetHanHD, pHetHanHD);
		ngayHetHanHD = new JDatePickerImpl(implHetHanHD, new AbstractFormatter() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@Override
			public String valueToString(Object value) throws ParseException {
				if(value != null) {
					Calendar cal = (Calendar) value;
					SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
					String strDate = format.format(cal.getTime());
					return strDate;
				}
				return "";
			}
			@Override
			public Object stringToValue(String text) throws ParseException {
				
				return null;
			}
		});
		ngayHetHanHD.setToolTipText("Chọn ngày hết hạn hợp đồng");
		((JDatePickerImpl) ngayHetHanHD).getJFormattedTextField().setBackground(new Color(250, 250, 210));
		ngayHetHanHD.setBackground(new Color(250, 250, 210));
		ngayHetHanHD.setBounds(181, 136, 329, 25);
		themHD.add(ngayHetHanHD);
		
		
		textFieldMaNV = new JTextField();
		textFieldMaNV.setToolTipText("Mã Nhân Viên tạo tự động");
		textFieldMaNV.setColumns(10);
		textFieldMaNV.setBounds(181, 177, 329, 20);
		textFieldMaNV.setEditable(false);
		themHD.add(textFieldMaNV);
		
		textFieldMaNV1 = new JTextField();
		textFieldMaNV1.setToolTipText("Mã Nhân Viên tạo tự động");
		textFieldMaNV1.setColumns(10);
		textFieldMaNV1.setBounds(181, 177, 329, 20);
		textFieldMaNV1.setEditable(false);
		themHD.add(textFieldMaNV1);
		
//		comboBoxMaSP = new JComboBox<String>();
//		comboBoxMaSP.setToolTipText("Tùy chọn mã nhân viên");
//		comboBoxMaSP.setBounds(181, 177, 329, 20);
//		comboBoxMaSP.setBackground(new Color(245, 222, 179));
//		themHD.add(comboBoxMaSP);
		
		
		
		
		JLabel maSP = new JLabel("Mã nhân viên:");
		maSP.setBounds(59, 176, 84, 22);
		themHD.add(maSP);
		
		
		
		themHopDong = new JButton("Thêm");
		themHopDong.setToolTipText("Thêm mới hợp đồng");
		themHopDong.setBackground(new Color(224, 255, 255));
		themHopDong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		themHopDong.setBounds(288, 336, 98, 33);
		themHD.add(themHopDong);
		
		xoaRong = new JButton("Xóa rỗng");
		xoaRong.setToolTipText("Xóa nội dung đã nhập ở trên để bắt đầu nhập lại");
		xoaRong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		xoaRong.setBackground(new Color(224, 255, 255));
		xoaRong.setBounds(288, 459, 98, 30);
		themHD.add(xoaRong);
		
		thoat = new JButton("Thoát");
		thoat.setToolTipText("Ngừng thêm hợp đồng");
		thoat.setBackground(new Color(224, 255, 255));
		thoat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		thoat.setBounds(288, 513, 98, 33);
		themHD.add(thoat);
		
		suaHD = new JButton("Sửa");
		suaHD.setBackground(new Color(224, 255, 255));
		suaHD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		suaHD.setBounds(288, 398, 98, 33);
		themHD.add(suaHD);
		
		
		
		themHopDong.addActionListener(this);
		xoaRong.addActionListener(this);
		suaHD.addActionListener(this);
		thoat.addActionListener(this);
		tableNV.addMouseListener(this);
		tableQLHD.addMouseListener(this);
		
////==================================================================================================================================================

		
		hopDong_DAO = new DAO_HopDongNV();
		filter = new TableRowSorter<TableModel>(modelHopDong);
		
	
		
		

		
//		Gọi các hàm đọc dữ liệu
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DocDuLieuVaoTabelHD();
		DocDuLieuVaoTabelNV();
//		updateComboboxMaKH();
//		updateComboboxMaNV();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(them)) {
			nhanThem();
		}
		if(o.equals(themHopDong)) {
			nhanThemHD();
		}
		if(o.equals(xoa)) {
			xoaHD();;
		}
		if(o.equals(sua)) {
			int row = tableQLHD.getSelectedRow();
			if(row!=-1) {
				themHopDong.setVisible(false);
				suaHD.setVisible(true);
				nhap_SuaHD.setVisible(true);
				textFieldMaNV.setVisible(true);
				textFieldMaNV1.setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(this, "Chưa chọn hợp đồng cần sửa");
			}
		}
		if(o.equals(suaHD)) {
			suaHD();
		}
		if(o.equals(loaiTimKiem)) {
			timKiem();
		}
		if(o.equals(btnLocHDHetHan)) {

			tableQLHD.setRowSorter(filter);
			filter.setRowFilter(RowFilter.dateFilter(ComparisonType.BEFORE, new java.util.Date(), 2));
		}
		if(o.equals(thoat)) {
			nhap_SuaHD.setVisible(false);
		}
	}
		
//		if(o.equals(suaHD)) {
//			suaHD();
//		}
		
//	đọc dữ liệu vào bảng HD
	public void DocDuLieuVaoTabelHD(){
		List<HopDongNV> dsHD = hopDong_DAO.getAllHopDong();
		
			for (HopDongNV hopDong :dsHD) {
				
				modelHopDong.addRow(new Object[] {
						hopDong.getMaHD(),hopDong.getNgayBatDau(),hopDong.getNgayHetHan(),hopDong.getHeSoLuong(),hopDong.getLuongCoBan(),hopDong.getCn().getMaNV()
						});
				
			}
			
		
	}

//	đọc dữ liệu vào bảng NV
	public void DocDuLieuVaoTabelNV(){
		List<NhanVienNew> dsNV = hopDong_DAO.getAllNV();
		
			for (NhanVienNew nhanVien :dsNV) {
				
				modelNV.addRow(new Object[] {
						nhanVien.getMaNV(),nhanVien.getHoTen(),nhanVien.isGioiTinh()?"Nam":"Nữ"
						});
				
			}
			
		
	}
//	Hàm tạo mã hợp đồng khi thêm mới
	public void taoMaHD() {
		int maSoHD = hopDong_DAO.getAllHopDong().size();	
		
		textFieldMaHD.setText("HDNV0"+(maSoHD+1));
	
	}
	public  void taoMa() {
		String ma ="HDNV";
		String maSoHD = hopDong_DAO.getMaLonNhat().trim();
		int a = Integer.parseInt(maSoHD.substring(4));
		
		if(a>=1&&a<=8) {
			ma += "000";
		}
		else if(a>=9&&a<=98) {
			ma += "00";
		}
		else if(a>=99&&a>=998) {
			ma += "0";
		}
		
		textFieldMaHD.setText(ma+(a+1));
//		textFieldMaHD.setText("HDNV0"+(maSoHD+1));
		
	}
//	Xóa rỗng textfield
	public void xoaRong() {
		tableQLHD.clearSelection();
		textFieldHeSoLuong.setText("");
		textFieldLuongCoBan.setText("");
	
		ngayTaoHD.getJFormattedTextField().setText("");
		ngayHetHanHD.getJFormattedTextField().setText("");
	}
//	Hàm xử lý khi ấn nút thêm hợp đồng
	public void nhanThem() {
		themHopDong.setVisible(true);
		suaHD.setVisible(false);
		textFieldMaNV.setVisible(false);
		textFieldMaNV1.setVisible(true);
		nhap_SuaHD.setVisible(true);
		
		taoMa();
		xoaRong();
	}

//	Hàm xử lý khi nhấn thêm trên màn hình thêm hợp đồng 
	public void nhanThemHD(){
		
		int row = tableNV.getSelectedRow();
		
		if (row !=-1) {
			String maHD = textFieldMaHD.getText();
			
			
			
			Date ngayTao = (Date) ngayTaoHD.getModel().getValue();
			Date ngayHetHan = (Date) ngayHetHanHD.getModel().getValue();
			double luongCoBan = Double.parseDouble(textFieldLuongCoBan.getText());
			float heSoLuong = Float.parseFloat(textFieldHeSoLuong.getText());
			NhanVienNew nv = new NhanVienNew(textFieldMaNV1.getText());
			
			HopDongNV hopDong = new HopDongNV(maHD, ngayTao, ngayHetHan, heSoLuong, luongCoBan, nv);
			
			if(!hopDong_DAO.getAllHopDong().contains(hopDong)) {
				try {
					hopDong_DAO.creatHopDong(hopDong);
					
					modelHopDong.addRow(new Object[] {
							hopDong.getMaHD(),hopDong.getNgayBatDau(),hopDong.getNgayHetHan(),hopDong.getHeSoLuong(),hopDong.getLuongCoBan(),hopDong.getCn().getMaNV()
					});
					
					nhanThem();
					JOptionPane.showMessageDialog(this, "Thêm thành công");
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(this, "TRÙNG!");
			}	
		}
		else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần tạo hợp đồng");
		}
	}
	
//	Hàm xóa một hợp đồng
	public void xoaHD() {
		int row = tableQLHD.getSelectedRow();
		if(row != -1){
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Chắc chắn xóa không? ", "Chú ý", JOptionPane.YES_NO_OPTION);
			if(hoiNhac == JOptionPane.YES_OPTION){
				String maHD = tableQLHD.getValueAt(row, 0).toString();
				 
					hopDong_DAO.deleteHopDong(maHD);
					modelHopDong.removeRow(row);
					
					JOptionPane.showMessageDialog(this, "Đã xóa 1 hợp đồng.");										
				}
				else {
					JOptionPane.showMessageDialog(this, "không xóa được");
				}
			}
		else
			JOptionPane.showMessageDialog(this, "Bạn phải chọn hợp đồng cần xóa. ");
	}
//	Hàm sửa một hợp đồng
	public void suaHD() {
		
		int row = tableQLHD.getSelectedRow();
		String maHD = textFieldMaHD.getText();
		Date ngayTao = (Date) ngayTaoHD.getModel().getValue();
		Date ngayHetHan = (Date) ngayHetHanHD.getModel().getValue();
		double luongCoBan = Double.parseDouble(textFieldLuongCoBan.getText());
		float heSoLuong = Float.parseFloat(textFieldHeSoLuong.getText());
		NhanVienNew nv = new NhanVienNew(textFieldMaNV.getText());
		if(ngayTao==null)
			ngayTao = (Date) tableQLHD.getValueAt(row, 1);
		if (ngayHetHan==null)
			ngayHetHan = (Date) tableQLHD.getValueAt(row, 2);
			
		HopDongNV hopDong = new HopDongNV(maHD, ngayTao, ngayHetHan, heSoLuong, luongCoBan, nv);
		String dK = tableQLHD.getValueAt(row, 0).toString();
			if (row != -1) {
				hopDong_DAO.updateHopDong(hopDong,dK);
				tableQLHD.setValueAt(dK, row, 0);
				tableQLHD.setValueAt(ngayTao, row, 1);
				tableQLHD.setValueAt(ngayHetHan, row, 2);
				tableQLHD.setValueAt(heSoLuong, row, 3);
				tableQLHD.setValueAt(luongCoBan, row, 4);
				tableQLHD.setValueAt(nv.getMaNV(), row, 5);
				nhap_SuaHD.setVisible(false);
				JOptionPane.showMessageDialog(this,"Đã sửa thành công");
			}
			else {
				JOptionPane.showMessageDialog(this, "Chưa chọn hợp đồng cần sửa");
			}
			
		
	}
//	Hàm tìm kiếm hợp đồng
	public void timKiem() {
		int select = loaiTimKiem.getSelectedIndex();
		if(select==0) {
			tableQLHD.setRowSorter(filter);
			filter.setRowFilter(RowFilter.regexFilter(timKiem.getText(),0));
		}
		if (select==1) {
			tableQLHD.setRowSorter(filter);
			filter.setRowFilter(RowFilter.regexFilter(timKiem.getText(),5));
		}
		
		if (timKiem.getText().length()<=0) {
			JOptionPane.showMessageDialog(this, "PHẢI NHẬP ĐIỀU KIỆN ĐỂ TÌM KIẾM");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row1 = tableQLHD.getSelectedRow();
		int row = tableNV.getSelectedRow();
		if(row1!=-1) {
			textFieldMaNV.setText("");
			textFieldMaHD.setText(tableQLHD.getValueAt(row1, 0).toString());
			ngayTaoHD.getJFormattedTextField().setText(tableQLHD.getValueAt(row1, 1).toString());
			ngayHetHanHD.getJFormattedTextField().setText(tableQLHD.getValueAt(row1, 2).toString());
			textFieldHeSoLuong.setText(tableQLHD.getValueAt(row1, 3).toString());
			textFieldLuongCoBan.setText(tableQLHD.getValueAt(row1, 4).toString());
			textFieldMaNV.setText(tableQLHD.getValueAt(row1,5).toString());
		}
		 // lay dong dang chon tren table
		if(row!=-1 ) {
			textFieldMaNV1.setText(tableNV.getValueAt(row,0).toString());	
		}
		}
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	}