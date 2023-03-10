

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
import dao.DAO_NhanVienHanhChinh;

import dao.DAO_HopDongSP;
import dao.DAO_SanPham;
import entity.HopDongNV;
import entity.HopDongSP;
import entity.NhanVienNew;
import entity.SanPham;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import javax.swing.JCheckBox;
public class GUI_QuanLyHDSP extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	Thuộc tính
	private JPanel quanLyHopdong;
	private JTable tableQLHD;
	private JTextField timKiem;
	private JTextField loc;
	private DAO_HopDongSP hopDong_DAO;
	private DefaultTableModel modelHopDong;
	private JButton them;
	private JButton sua;
	private JButton xoa;
	private JComboBox<String> loaiTimKiem;
	private TableRowSorter<TableModel> filter;
	
	

//-------  Dành cho JFame nhập và sửa
	private JPanel themHD;
	private JTextField textFieldSoLuongSanPham;
	private JTextField textFieldGiaTriHD;
	
	private JTextField textFieldMaHD;
	private JButton xoaRong;
	private JButton thoat;
	private JButton themHopDong;
	private JFrame nhap_SuaHD;
	private JButton suaHD;
	private JDatePickerImpl ngayTaoHD;
	private JDatePickerImpl ngayHetHanHD;
	private JComboBox<String> comboBoxMaSP;
	
	
	
	private JCheckBox chckbxThanhToan;
	private JButton btnLocHDChuaThanhToan;
	private JButton btnLocHD;
	private JButton btnLocHDHetHan;
	private DefaultTableModel modelSP;
	private JScrollPane scrollPaneTableSP;
	private JTable tableSP;
	private JTextField textFieldMaSP;
	private JTextField textFieldMaSP1;
	
//--------------------------------------
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI_QuanLyHDSP frame = new GUI_QuanLyHDSP();
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
	public GUI_QuanLyHDSP() {
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
					"Mã hợp đồng", "Ngày bắt đầu", "Ngày hết hạn", "Mã sản phẩm", "Giá trị", "Số Lượng","Tình trạng"
				}
			);
		modelSP= new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã sản phẩm", "Tên sản phẩm","Mô tả"
				}
			);
		JPanel panelChucNang = new JPanel();
		panelChucNang.setBorder(new LineBorder(Color.ORANGE));
		panelChucNang.setBackground(Color.WHITE);
		panelChucNang.setBounds(10, 40, 469, 611);
		quanLyHopdong.add(panelChucNang);
		panelChucNang.setLayout(null);
		
		timKiem = new JTextField();
		timKiem.setToolTipText("Nhập để tìm kiếm");
		timKiem.setBounds(10, 120, 273, 29);
		panelChucNang.add(timKiem);
		timKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		timKiem.setColumns(10);
		
		loc = new JTextField();
		loc.setToolTipText("Nhập để lọc");
		loc.setBounds(10, 186, 273, 29);
		panelChucNang.add(loc);
		loc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loc.setColumns(10);
		
		loaiTimKiem = new JComboBox<String>();
		loaiTimKiem.setToolTipText("Tùy chọn để tìm kiếm");
		loaiTimKiem.setBackground(new Color(245, 222, 179));
		loaiTimKiem.setBounds(293, 120, 165, 29);
		panelChucNang.add(loaiTimKiem);
		loaiTimKiem.setModel(new DefaultComboBoxModel<String>(new String[] {"Tìm theo mã hợp đồng", "Tìm theo mã sản phẩm"}));
		
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
		
		btnLocHD = new JButton("Lọc theo mã sản phẩm");
		btnLocHD.setToolTipText("Lọc hợp đồng theo mã sản phẩm");
		btnLocHD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLocHD.setBackground(new Color(224, 255, 255));
		btnLocHD.setBounds(293, 187, 165, 29);
		panelChucNang.add(btnLocHD);
		
		btnLocHDHetHan = new JButton("Lọc hợp đồng hết hạn");
		btnLocHDHetHan.setToolTipText("lọc hợp đồng đã hết hạn");
		btnLocHDHetHan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLocHDHetHan.setBackground(new Color(224, 255, 255));
		btnLocHDHetHan.setBounds(152, 246, 165, 29);
		panelChucNang.add(btnLocHDHetHan);
		
		btnLocHDChuaThanhToan = new JButton("Lọc hợp đồng chưa thanh toán");
		btnLocHDChuaThanhToan.setToolTipText("Lọc hợp đồng chưa thanh toán");
		btnLocHDChuaThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLocHDChuaThanhToan.setBackground(new Color(224, 255, 255));
		btnLocHDChuaThanhToan.setBounds(122, 286, 225, 29);
		panelChucNang.add(btnLocHDChuaThanhToan);
		sua.addActionListener(this);
		xoa.addActionListener(this);
		
		JPanel panelQLHD = new JPanel();
		panelQLHD.setBorder(new LineBorder(Color.ORANGE));
		panelQLHD.setBackground(Color.WHITE);
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
		
		scrollPaneTableSP = new JScrollPane();
		scrollPaneTableSP.setBounds(10, 346, 855, 255);
		panelQLHD.add(scrollPaneTableSP);
		tableSP = new JTable(modelSP);
		tableSP.setBackground(Color.WHITE);
		tableSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPaneTableSP.setViewportView(tableSP);
		
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
		btnLocHD.addActionListener(this);
		btnLocHDChuaThanhToan.addActionListener(this);
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
		
		
		
		JLabel ngayTao = new JLabel("Ngày tạo:  ");
		ngayTao.setBounds(59, 115, 84, 22);
		themHD.add(ngayTao);
		
		JLabel soLuongSP = new JLabel("Số lượng sản phẩm: ");
		soLuongSP.setBounds(59, 304, 119, 22);
		themHD.add(soLuongSP);
		
		JLabel giaTri = new JLabel("Giá trị hợp đồng: ");
		giaTri.setBounds(59, 260, 98, 22);
		themHD.add(giaTri);
		
		JLabel ngayHetHan = new JLabel("Ngày hết hạn:");
		ngayHetHan.setBounds(59, 162, 84, 22);
		themHD.add(ngayHetHan);
		
		textFieldSoLuongSanPham = new JTextField();
		textFieldSoLuongSanPham.setToolTipText("Nhập số lượng sản phẩm");
		textFieldSoLuongSanPham.setBounds(181, 306, 329, 20);
		themHD.add(textFieldSoLuongSanPham);
		textFieldSoLuongSanPham.setColumns(10);
		
		textFieldGiaTriHD = new JTextField();
		textFieldGiaTriHD.setToolTipText("Nhập giá trị hợp đồng");
		textFieldGiaTriHD.setColumns(10);
		textFieldGiaTriHD.setBounds(181, 262, 329, 20);
		themHD.add(textFieldGiaTriHD);
		
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
		ngayTaoHD.setBounds(181, 115, 329, 25);
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
		ngayHetHanHD.setBounds(181, 162, 329, 25);
		themHD.add(ngayHetHanHD);
		
		textFieldMaSP = new JTextField();
		textFieldMaSP.setToolTipText("Mã Sản Phẩm lấy từ table");
		textFieldMaSP.setColumns(10);
		textFieldMaSP.setBounds(181, 215, 329, 20);
		textFieldMaSP.setEditable(false);
		themHD.add(textFieldMaSP);
		
		textFieldMaSP1 = new JTextField();
		textFieldMaSP1.setToolTipText("Mã Sản Phẩm lấy từ table");
		textFieldMaSP1.setColumns(10);
		textFieldMaSP1.setBounds(181, 215, 329, 20);
		textFieldMaSP1.setEditable(false);
		themHD.add(textFieldMaSP1);
		
		
		
		JLabel maSP = new JLabel("Mã sản phẩm:");
		maSP.setBounds(59, 210, 84, 22);
		themHD.add(maSP);
		
		
		
		
		
		themHopDong = new JButton("Thêm");
		themHopDong.setToolTipText("Thêm mới hợp đồng");
		themHopDong.setBackground(new Color(224, 255, 255));
		themHopDong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		themHopDong.setBounds(254, 402, 98, 33);
		themHD.add(themHopDong);
		
		xoaRong = new JButton("Xóa rỗng");
		xoaRong.setToolTipText("Xóa nội dung đã nhập ở trên để bắt đầu nhập lại");
		xoaRong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		xoaRong.setBackground(new Color(224, 255, 255));
		xoaRong.setBounds(254, 488, 98, 30);
		themHD.add(xoaRong);
		
		thoat = new JButton("Thoát");
		thoat.setToolTipText("Ngừng thêm hợp đồng");
		thoat.setBackground(new Color(224, 255, 255));
		thoat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		thoat.setBounds(254, 528, 98, 33);
		themHD.add(thoat);
		
		suaHD = new JButton("Sửa");
		suaHD.setBackground(new Color(224, 255, 255));
		suaHD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		suaHD.setBounds(254, 455, 98, 33);
		themHD.add(suaHD);
		
		
		JLabel lblTnhTrang = new JLabel("Tình trạng:");
		lblTnhTrang.setBounds(59, 354, 84, 22);
		themHD.add(lblTnhTrang);
		
		chckbxThanhToan = new JCheckBox("  Đã thanh toán");
		chckbxThanhToan.setToolTipText("Nếu hợp đồng đã thanh toán thì ấn chọn");
		chckbxThanhToan.setBackground(new Color(255, 250, 205));
		chckbxThanhToan.setBounds(181, 354, 110, 23);
		themHD.add(chckbxThanhToan);
		
		themHopDong.addActionListener(this);
		xoaRong.addActionListener(this);
		suaHD.addActionListener(this);
		thoat.addActionListener(this);
		tableSP.addMouseListener(this);
		tableQLHD.addMouseListener(this);
////==================================================================================================================================================
//		Kết nối cơ sở dữ liệu và tạo các đới tượng DAO
		try{
			ConnectDB.getInstance().connect();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		hopDong_DAO = new DAO_HopDongSP();
		
		filter = new TableRowSorter<TableModel>(modelHopDong);
		
//		tableQLHD.getSelectionModel().addListSelectionListener(selectRow);
	
		
//		Gọi các hàm đọc dữ liệu
		DocDuLieuVaoTabelHD();
		DocDuLieuVaoTabelSP();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(them)) {
			int row = tableSP.getSelectedRow();
			if(row!=-1) {
				nhanThem();
			}
			else
				JOptionPane.showMessageDialog(this, "Bạn phải chọn sản phẩm cần tạo hợp đồng ");
		}
		if(o.equals(themHopDong)) {
			if(kiemTraNhapHopDong()) {
				nhanThemHD();
			}
		}
		if(o.equals(xoa)) {
			int row = tableQLHD.getSelectedRow();
			if(row!=-1) {
				xoaHD();
			}
			else
				JOptionPane.showMessageDialog(this, "Bạn phải chọn hợp đồng cần xóa ");
		
		}
		
		if(o.equals(sua)) {
			int row = tableQLHD.getSelectedRow();
			if(row!=-1) {
				themHopDong.setVisible(false);
				suaHD.setVisible(true);
				textFieldMaSP.setVisible(true);
				textFieldMaSP1.setVisible(false);
				nhap_SuaHD.setVisible(true);
			}
			else
				JOptionPane.showMessageDialog(this, "Bạn phải chọn hop dong cần sửa. ");
		}
		if(o.equals(suaHD)) {
			if(kiemTraNhapHopDongSua()) {
				suaHD();
			}
		}
		if(o.equals(btnLocHD)) { 
				tableQLHD.setRowSorter(filter);
				filter.setRowFilter(RowFilter.regexFilter(loc.getText(),3));
		}
		if (o.equals(btnLocHDChuaThanhToan)) {
			tableQLHD.setRowSorter(filter);
			filter.setRowFilter(RowFilter.regexFilter("Chưa thanh toán",6));
		}
		if(o.equals(btnLocHDHetHan)) {

			tableQLHD.setRowSorter(filter);
			filter.setRowFilter(RowFilter.dateFilter(ComparisonType.BEFORE, new java.util.Date(), 2));
		}
		if(o.equals(loaiTimKiem)) {
			timKiem();
		}
		if(o.equals(xoaRong)) {
			xoaRong();
		}
		if(o.equals(thoat)) {
			nhap_SuaHD.setVisible(false);
		}
		
	}
// Tìm Kiếm hợp đồng
private void timKiem() {
		// TODO Auto-generated method stub
		int select = loaiTimKiem.getSelectedIndex();
		if(select==0) {
			tableQLHD.setRowSorter(filter);
			filter.setRowFilter(RowFilter.regexFilter(timKiem.getText(),0));
		}
		if (select==1) {
			tableQLHD.setRowSorter(filter);
			filter.setRowFilter(RowFilter.regexFilter(timKiem.getText(),3));
		}
		
		if (timKiem.getText().length()<=0) {
			JOptionPane.showMessageDialog(this, "PHẢI NHẬP ĐIỀU KIỆN ĐỂ TÌM KIẾM");
		}
	}

//	đọc dữ liệu vào bảng hợp đồng
	public void DocDuLieuVaoTabelHD(){
		List<HopDongSP> dsHD = hopDong_DAO.getAllHopDong();
		
			for (HopDongSP hopDong :dsHD) {
				
				modelHopDong.addRow(new Object[] {
						hopDong.getMaHDString(),hopDong.getNgayBD(),hopDong.getNgayHH(),hopDong.getsPham().getMaSP(),hopDong.getGiaTri(),hopDong.getSoLuong(),hopDong.isTinhTrang()?"Thanh toán":"Chưa thanh toán"
						});
				
			}
			
		
	}

//	đọc dữ liệu vào bảng sản phẩm
	public void DocDuLieuVaoTabelSP(){
		List<SanPham> dsHD = hopDong_DAO.getAllSP();
		
			for (SanPham sanPham :dsHD) {
				
				modelSP.addRow(new Object[] {
						sanPham.getMaSP(),sanPham.getTenSP(),sanPham.getMoTa()
						});
				
			}		
	}
//	Hàm tạo mã hợp đồng khi thêm mới
	public void taoMaHD() {
		int maSoHD = hopDong_DAO.getAllHopDong().size();	
		
		textFieldMaHD.setText("HDSP0"+(maSoHD+1));
	
	}
	public  void taoMa() {
		String ma ="HDSP";
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
	}
//	Xóa rỗng textfield
	public void xoaRong() {
		
		textFieldSoLuongSanPham.setText("");
		textFieldGiaTriHD.setText("");
		chckbxThanhToan.setSelected(false);
		ngayTaoHD.getJFormattedTextField().setText("");
		ngayHetHanHD.getJFormattedTextField().setText("");
	}
//	Kiểm tra nhập liệu để thêm hợp đồng
	public boolean kiemTraNhapHopDong() {
		
		String giaTriHD = textFieldGiaTriHD.getText();
		String soLuongSP = textFieldSoLuongSanPham.getText();
		Date ngayTao = (Date) ngayTaoHD.getModel().getValue();
		Date ngayHetHan = (Date) ngayHetHanHD.getModel().getValue();
		
		
		if (ngayTao==null) {
			JOptionPane.showMessageDialog(this, "PHẢI CHỌN NGÀY TẠO");
			return false;
		}
		if(!(giaTriHD.length()>0)){
			JOptionPane.showMessageDialog(this,"NHẬP GIÁ TRỊ HỢP ĐỒNG.");
		}
		if(!(soLuongSP.length()>0)){
			JOptionPane.showMessageDialog(this,"SỐ LƯỢNG SẢN PHẨM.");
		}
		if (soLuongSP.length() > 0) {
			try {
				int y = Integer.parseInt(soLuongSP);
				if (y <= 0) {
					JOptionPane.showMessageDialog(this,"SỐ LỰONG SẢN PHẢM PHẢI LỚN HƠN 0.");
					return false;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this,"SỐ LƯỢNG SẢN PHẢM PHẢI NHẬP SỐ.");
				return false;
			}
		}
		if (giaTriHD.length() > 0) {
			try {
				double y = Double.parseDouble(giaTriHD);
				if (y <= 0) {
					JOptionPane.showMessageDialog(this,"GIÁ TRỊ HỢP ĐỒNG PHẢI LỚN HƠN 0.");
					return false;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this,"GIÁ TRỊ HỢP ĐỒNG PHẢI NHẬP SỐ.");
				return false;
			}
		}
		if (ngayHetHan==null) {
			JOptionPane.showMessageDialog(this, "PHẢI CHỌN NGÀY HẾT HẠN");
			return false;
		}
	
		if (!(ngayTao.before(ngayHetHan))) {
			JOptionPane.showMessageDialog(this, "NGÀY HẾT HẠN PHẢI SAU NGÀY TẠO");
			return false;
		}
		
		return true;
	}
public boolean kiemTraNhapHopDongSua() {
		
		String giaTriHD = textFieldGiaTriHD.getText();
		String soLuongSP = textFieldSoLuongSanPham.getText();
		Date ngayTao = (Date) ngayTaoHD.getModel().getValue();
		Date ngayHetHan = (Date) ngayHetHanHD.getModel().getValue();
		
		
		if (ngayTao==null) {
			JOptionPane.showMessageDialog(this, "PHẢI CHỌN NGÀY TẠO");
			return false;
		}
		if(!(giaTriHD.length()>0)){
			JOptionPane.showMessageDialog(this,"NHẬP GIÁ TRỊ HỢP ĐỒNG.");
		}
		if(!(soLuongSP.length()>0)){
			JOptionPane.showMessageDialog(this,"SỐ LƯỢNG SẢN PHẨM.");
		}
		if (soLuongSP.length() > 0) {
			try {
				int y = Integer.parseInt(soLuongSP);
				if (y <= 0) {
					JOptionPane.showMessageDialog(this,"SỐ LỰONG SẢN PHẢM PHẢI LỚN HƠN 0.");
					return false;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this,"SỐ LƯỢNG SẢN PHẢM PHẢI NHẬP SỐ.");
				return false;
			}
		}
		if (giaTriHD.length() > 0) {
			try {
				double y = Double.parseDouble(giaTriHD);
				if (y <= 0) {
					JOptionPane.showMessageDialog(this,"GIÁ TRỊ HỢP ĐỒNG PHẢI LỚN HƠN 0.");
					return false;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this,"GIÁ TRỊ HỢP ĐỒNG PHẢI NHẬP SỐ.");
				return false;
			}
		
		
		}
		
		return true;
	}
//	Kiểm tra dữ liệu để sửa hợp đồng (có tham số)
	public boolean kiemTraNhapHopDong(String tenHD, String soLuongSP, String giaTriHD, Date ngayTao, Date ngayHetHan) {
		
		if(!(giaTriHD.length()>0)){
			JOptionPane.showMessageDialog(this,"NHẬP GIÁ TRỊ HỢP ĐỒNG.");
		}
		if(!(soLuongSP.length()>0)){
			JOptionPane.showMessageDialog(this,"SỐ LƯỢNG SẢN PHẨM.");
		}
		if (soLuongSP.length() > 0) {
			try {
				int y = Integer.parseInt(soLuongSP);
				if (y <= 0) {
					JOptionPane.showMessageDialog(this,"SỐ LƯỢNG SẢN PHẨM PHẢI LỚN HƠN 0.");
					return false;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this,"SỐ LƯỢNG SẢN PHẨM PHẢI NHẬP SỐ.");
				return false;
			}
		}
		if (giaTriHD.length() > 0) {
			try {
				double y = Double.parseDouble(giaTriHD);
				if (y <= 0) {
					JOptionPane.showMessageDialog(this,"GIÁ TRỊ HỢP ĐỒNG PHẢI LỚN HƠN 0.");
					return false;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this,"GIÁ TRỊ HỌP ĐỒNG PHẢI NHẬP SỐ.");
				return false;
			}
		}
		
		if (!(comboBoxMaSP.getSelectedIndex()>=0)) {
			JOptionPane.showMessageDialog(this, "CHỌN MÃ SẢN PHẨM ");
			return false;
		}
		if (!(ngayTao.before(ngayHetHan))) {
			JOptionPane.showMessageDialog(this, "NGÀY HẾT HẠN PHẢI SAU NGÀY TẠO");
			return false;
		}
		return true;
	}


	private JLabel lblNewLabel;
//	Hàm xử lý khi ấn nút thêm hợp đồng
	public void nhanThem() {
		themHopDong.setVisible(true);
		suaHD.setVisible(false);
		nhap_SuaHD.setVisible(true);
		textFieldMaSP.setVisible(false);
		textFieldMaSP1.setVisible(true);
		xoaRong();
		taoMa();
	}
//	Hàm xử lý khi nhấn thêm trên màn hình thêm hợp đồng 
	public void nhanThemHD(){
		
		int row = tableSP.getSelectedRow();
		
		if (row !=-1) {
			String maHD = textFieldMaHD.getText();
			
			Date ngayTao = (Date) ngayTaoHD.getModel().getValue();
			Date ngayHetHan = (Date) ngayHetHanHD.getModel().getValue();
			
			
			SanPham sanPham = new SanPham(textFieldMaSP1.getText());
			double giaTri = Double.parseDouble(textFieldGiaTriHD.getText());
			int soLuong = Integer.parseInt(textFieldSoLuongSanPham.getText());
			boolean thanhToan = chckbxThanhToan.isSelected();
			HopDongSP hopDong = new HopDongSP(maHD, soLuong, giaTri, ngayTao, ngayHetHan, thanhToan, sanPham);
//			HopDongNV hopDong = new HopDongNV(maHD, ngayTao, ngayHetHan, heSoLuong, luongCoBan, nv);
			
			if(!hopDong_DAO.getAllHopDong().contains(hopDong)) {
				try {
					hopDong_DAO.creatHopDong(hopDong);
					
					modelHopDong.addRow(new Object[] {
							hopDong.getMaHDString(),hopDong.getNgayBD(),hopDong.getNgayHH(),hopDong.getsPham().getMaSP(),hopDong.getGiaTri(),hopDong.getSoLuong(),(chckbxThanhToan.isSelected()?" Đã thanh toán":" Chưa thanh toán")
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
			JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần tạo hợp đồng");
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
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	int row1 = tableQLHD.getSelectedRow();
	int row = tableSP.getSelectedRow();
	if(row1!=-1) {
		
		textFieldMaHD.setText(tableQLHD.getValueAt(row1, 0).toString());
		ngayTaoHD.getJFormattedTextField().setText(tableQLHD.getValueAt(row1, 1).toString());
		ngayHetHanHD.getJFormattedTextField().setText(tableQLHD.getValueAt(row1, 2).toString());
		textFieldMaSP.setText(tableQLHD.getValueAt(row1, 3).toString());
		textFieldGiaTriHD.setText(tableQLHD.getValueAt(row1, 4).toString());
		textFieldSoLuongSanPham.setText(tableQLHD.getValueAt(row1, 5).toString());
		chckbxThanhToan.setSelected(false);

	}
	 // lay dong dang chon tren table
	if(row!=-1 ) {
		textFieldMaSP1.setText(tableSP.getValueAt(row,0).toString());	
	}
	
}
//Hàm sửa một hợp đồng
public void suaHD() {
	
	int row = tableQLHD.getSelectedRow();
	String maHD = textFieldMaHD.getText();
	Date ngayTao = (Date) ngayTaoHD.getModel().getValue();
	Date ngayHetHan = (Date) ngayHetHanHD.getModel().getValue();
	double giaTri = Double.parseDouble(textFieldGiaTriHD.getText());
	int soLuong = Integer.parseInt(textFieldSoLuongSanPham.getText()); 
	SanPham sPham = new SanPham(textFieldMaSP.getText());
//	NhanVienNew nv = new NhanVienNew(textFieldMaNV.getText());
	if(ngayTao==null)
		ngayTao = (Date) tableQLHD.getValueAt(row, 1);
	if (ngayHetHan==null)
		ngayHetHan = (Date) tableQLHD.getValueAt(row, 2);
	boolean thanhToan = chckbxThanhToan.isSelected();
	HopDongSP hopDong = new HopDongSP(maHD, soLuong, giaTri, ngayTao, ngayHetHan, thanhToan, sPham);
//	HopDongNV hopDong = new HopDongNV(maHD, ngayTao, ngayHetHan, heSoLuong, luongCoBan, nv);
	String dK = tableQLHD.getValueAt(row, 0).toString();
		if (row != -1) {
			hopDong_DAO.updateHopDong(hopDong,dK);
			tableQLHD.setValueAt(maHD, row, 0);
			tableQLHD.setValueAt(ngayTao, row, 1);
			tableQLHD.setValueAt(ngayHetHan, row, 2);
			tableQLHD.setValueAt(sPham.getMaSP(), row, 3);
			tableQLHD.setValueAt(giaTri, row, 4);
			tableQLHD.setValueAt(soLuong, row, 5);
			tableQLHD.setValueAt(thanhToan?"Đã thanh toán":"Chưa thanh toán", row, 6);
			nhap_SuaHD.setVisible(false);
			JOptionPane.showMessageDialog(this,"Đã sửa thành công");
		}
		else {
			JOptionPane.showMessageDialog(this, "Chưa chọn hợp đồng cần sửa");
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
