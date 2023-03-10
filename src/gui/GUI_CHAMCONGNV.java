package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import dao.DAO_ChamCongNV1;
import dao.DAO_CongNhan;
import entity.ChamCongCN;
import entity.ChamCongNV;
import entity.ChamCongNV1;
import entity.CongNhan;
import entity.CongNhanNew;
import entity.HopDongNV;
import entity.NhanVienNew;
import entity.PhanCong_tv;
import entity.TangCa;


public class GUI_CHAMCONGNV extends JFrame implements ActionListener,MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
//	private DAO_CaLam dao_CaLam = new DAO_CaLam();
	private DAO_ChamCongNV1 dao_ChamCongNV= new DAO_ChamCongNV1();	
	
	
	private JPanel panel,panel_2,panel_3;
	private JButton btnChamCong,btnRefresh,btnLuu;
	private JButton btnThem;
	private JButton btnLamRong;
	private JButton btnThoat;
	private JLabel lblNhanVienDangNhap;
	private SqlDateModel modelNgayLam;

	private DefaultTableModel modelChamCong;

	private DefaultTableModel modelHopDong;

	private DefaultTableModel modelTangCa;

	private JTable tableChamCong;

	private TableRowSorter<TableModel> filter;

	private TableRowSorter<TableModel> fileter1;

	private TableRowSorter<TableModel> filter2;

	private JDatePickerImpl ngayTaoHD;

	private JCheckBox diLam;

	private JComboBox<Object> comboBox_TC;

	private TableColumn testColumn;
	private JLabel lblNewLabel_3;
	private JTextField textField_SoGioTC;

	private JCheckBox chckbxDiemDanh;

	private JButton btnXuatFile;
//	public static void main(String[] args) {
//		
//		//System.out.print();;
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI_CHAMCONGNV frame = new GUI_CHAMCONGNV();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public GUI_CHAMCONGNV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 650);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 204, 51), new Color(0, 153, 153), new Color(0, 102, 204), new Color(0, 255, 255)));
		panel.setBounds(7, 10, 1330, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản Lý Chấm Công Nhân Viên");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 38));
		lblNewLabel.setBounds(10, 0, 595, 46);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_9 = new JLabel("Mã nhân viên:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(1048, 25, 125, 14);
		panel.add(lblNewLabel_9);
		
		lblNhanVienDangNhap = new JLabel();
		lblNhanVienDangNhap.setToolTipText("Mã nhân viên đang đăng nhập");
		lblNhanVienDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNhanVienDangNhap.setBounds(1203, 27, 117, 14);
		panel.add(lblNhanVienDangNhap);
		lblNhanVienDangNhap.setText(GUI_DangNhap.getDnma());
		modelChamCong = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã nhân viên","Nhân viên", "Giới tính","Phòng Ban"
				}
			);
		
		modelTangCa= new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã tăng ca", "Loại ca","Hệ số lương","Đơn giá"
				}
			);
		
		
		
		
		
		panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(7, 67, 1330, 501);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setToolTipText("Bảng ca làm");
		scrollPane_1.setBounds(0, 51, 1330, 450);
		panel_2.add(scrollPane_1);
		
		
		tableChamCong = new JTable(modelChamCong);

		
		scrollPane_1.setViewportView(tableChamCong);
		
		JLabel lblNewLabel_1 = new JLabel("Chấm công");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setForeground(new Color(51, 51, 204));
		lblNewLabel_1.setBounds(14, 0, 128, 17);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày chấm công:");
		lblNewLabel_2.setBounds(147, 15, 128, 26);
		panel_2.add(lblNewLabel_2);
		
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		SqlDateModel modelngayTaoHD = new SqlDateModel(date);
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
		ngayTaoHD.setBounds(298, 16, 329, 25);
		panel_2.add(ngayTaoHD);
		
		lblNewLabel_3 = new JLabel("Có mặt/Vắng mặt:");
		lblNewLabel_3.setBounds(670, 15, 121, 24);
		panel_2.add(lblNewLabel_3);
		
		 chckbxDiemDanh = new JCheckBox("");
		chckbxDiemDanh.setBounds(800, 15, 26, 26);
		panel_2.add(chckbxDiemDanh);
		
		JLabel lblNewLabel_4 = new JLabel("Số giờ tăng ca:");
		lblNewLabel_4.setBounds(895, 15, 121, 26);
		panel_2.add(lblNewLabel_4);
		
		textField_SoGioTC = new JTextField();
		textField_SoGioTC.setText("0");
		textField_SoGioTC.setEnabled(false);
		textField_SoGioTC.setBounds(1036, 15, 96, 26);
		panel_2.add(textField_SoGioTC);
		textField_SoGioTC.setColumns(10);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setBounds(7, 578, 1330, 35);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		btnChamCong = new JButton("Chấm Công");
		btnChamCong.setToolTipText("Tạo phiếu ca làm mới");
		btnChamCong.setBackground(SystemColor.inactiveCaptionBorder);
		btnChamCong.setBounds(384, 0, 156, 30);
		
		btnThem = new JButton("Thêm ");
		btnThem.setBackground(SystemColor.inactiveCaptionBorder);
		btnThem.setBounds(384, 0, 156, 30);
		
		btnLamRong = new JButton("Làm Rỗng");
		btnLamRong.setBackground(SystemColor.textHighlight);
		btnLamRong.setBounds(573, 0, 156, 30);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBackground(Color.PINK);
		btnThoat.setBounds(769, 0, 156, 30);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setToolTipText("Sửa đổi thông tin phiếu ca làm");
		btnRefresh.setBackground(SystemColor.textHighlight);
		btnRefresh.setBounds(608, 0, 156, 30);
	
		btnLuu = new JButton("Lưu");
		btnLuu.setBackground(SystemColor.inactiveCaptionBorder);
		btnLuu.setBounds(384, 0, 156, 30);
		
		diLam = new JCheckBox();
		comboBox_TC = new JComboBox<Object>(new Object[] {0,1,2,3,4});
		comboBox_TC.setFont(new Font("Tahoma", Font.PLAIN, 10));
		comboBox_TC.setBounds(767, 175, 126, 22);
		
		btnXuatFile = new JButton("Xuất Bảng Công");
		btnXuatFile.setToolTipText("Sửa đổi thông tin phiếu ca làm");
		btnXuatFile.setBackground(SystemColor.textHighlight);
		btnXuatFile.setBounds(837, 0, 156, 30);
		panel_3.add(btnXuatFile);
		
		panel.addMouseListener(this);
		panel_2.addMouseListener(this);
		panel_3.addMouseListener(this);
		tableChamCong.addMouseListener(this);
		btnRefresh.addActionListener(this);
		btnChamCong.addActionListener(this);
		chckbxDiemDanh.addActionListener(this);
		btnXuatFile.addActionListener(this);

		
		panel_3.add(btnChamCong);
		panel_3.add(btnRefresh);
		
		
	
		filter = new TableRowSorter<TableModel>(modelChamCong);
		fileter1 = new TableRowSorter<TableModel>(modelHopDong);
		filter2 = new TableRowSorter<TableModel>(modelTangCa);
		
		
		
		docDuLieuDatabaseVaoTableChamCong();
		
//		docDuLieuDatabaseVaoTableHopDong();
//		docDuLieuDatabaseVaoTableTangCa();
		
	}
	
	

	

	private void docDuLieuDatabaseVaoTableChamCong() {
		// TODO Auto-generated method stub
		List<NhanVienNew> dsHD = dao_ChamCongNV.getAllChamCong();
		for (NhanVienNew chamCongCN :dsHD) {
		modelChamCong.addRow(new Object[] {
			chamCongCN.getMaNV(),chamCongCN.getHoTen(),chamCongCN.isGioiTinh()?"Nam":"Nữ",chamCongCN.getDonViCongTac()
		});
		}
	}

	public  int taoMa(int ma) {
		String maSoHD = dao_ChamCongNV.getMaLonNhat().trim();
		int a = Integer.parseInt(maSoHD);
		ma = (a+1);
//		textFieldMaHD.setText("HDNV0"+(maSoHD+1));
		return ma;
	}
	public boolean kiemTra() {
		
		try {
			int soGioTC = Integer.parseInt(textField_SoGioTC.getText().trim());
			if (soGioTC<0) {
				JOptionPane.showMessageDialog(this, "Số giờ tăng ca phải lớn hơn 0");
				return false;
			} 
		} catch (NumberFormatException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Số giờ tăng ca yêu cầu nhập số và không để trống");
			return false;
		}
		
		return true;
	}
	public void them() {
		int row = tableChamCong.getSelectedRow();
		int maCC = 0;
		taoMa(maCC);
		String maNVString= modelChamCong.getValueAt(row, 0).toString().trim();
		Date ngayTao = (Date) ngayTaoHD.getModel().getValue();
		boolean diemDanh = chckbxDiemDanh.isSelected();
		int soGioTC = Integer.parseInt(textField_SoGioTC.getText().trim());
		String maNguoiCham = lblNhanVienDangNhap.getText().trim();
		NhanVienNew nguoiCham = new NhanVienNew(maNguoiCham);
		NhanVienNew nhanVienNew = new NhanVienNew(maNVString);
		ChamCongNV1 chamCongNV1 = new ChamCongNV1(taoMa(maCC), nhanVienNew, ngayTao, diemDanh, soGioTC,nguoiCham);
		
		
		
		
			try {
				dao_ChamCongNV.creatChamCong(chamCongNV1);
				
				
				JOptionPane.showMessageDialog(this, "Chấm công thành công");
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	
	private void xoaHetDuLieuTrenTableMode() {
		DefaultTableModel dm = (DefaultTableModel) tableChamCong.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();

		}
	
	public void xuatFile() {
		ArrayList<ChamCongNV1> arr =dao_ChamCongNV.getAllBangCong();
		try {
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("BangCong");
			XSSFRow row=null;
			Cell cell= null;
			row=sheet.createRow(3);
			
			cell=row.createCell(0,CellType.STRING);
			cell.setCellValue("Mã nhân viên");
	
			cell=row.createCell(1,CellType.STRING);
			cell.setCellValue("Họ tên");
			
			cell=row.createCell(2,CellType.STRING);
			cell.setCellValue("Ngày chấm công");
			
			cell=row.createCell(3,CellType.BOOLEAN);
			cell.setCellValue("Điểm danh");
			
			cell=row.createCell(4,CellType.STRING);
			cell.setCellValue("Số giờ tăng ca");
			
			
			
			
			for(int i=0;i<arr.size();i++) {
				row=sheet.createRow(i+4);
				
				cell = row.createCell(0,CellType.STRING);
				cell.setCellValue(arr.get(i).getnVienNew().getMaNV());
				
				cell = row.createCell(1,CellType.STRING);
				cell.setCellValue(arr.get(i).getnVienNew().getHoTen());
				
				cell = row.createCell(2,CellType.STRING);
				cell.setCellValue(arr.get(i).getNgayCCDate().toString());
				
				cell = row.createCell(3,CellType.BOOLEAN);
				cell.setCellValue(arr.get(i).getDiemDanhBoolean()?"Có mặt":"Vắng mặt");
				
				cell = row.createCell(4,CellType.STRING);
				cell.setCellValue(arr.get(i).getSoGioTC());
				
				
				
				
				
				
				
			}
			File f= new File("C:\\New folder\\BangCongNhanVien.xlsx");
			try {
				FileOutputStream fis =new FileOutputStream(f);
				workbook.write(fis);
				fis.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Xuất file thành công");
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
	
	
	
	// Doc
	
	
	
	
	
	
	
	
	// Xóa
	
	
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnChamCong)) {
			int row = tableChamCong.getSelectedRow();
			if (row!=-1) {
				if (kiemTra()) {
					them();
				} else
					JOptionPane.showMessageDialog(this, "Chấm công thất bại");
				
			} else
				JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên chấm công");
		}
		if (o.equals(chckbxDiemDanh)) {
			if (chckbxDiemDanh.isSelected()) {
				textField_SoGioTC.setEnabled(true);
			} else {
				textField_SoGioTC.setEnabled(false);
				textField_SoGioTC.setText("0");
			}
				
		}
		
		if (o.equals(btnXuatFile)) {
			xuatFile();
		}
		if (o.equals(btnRefresh)) {
			xoaHetDuLieuTrenTableMode();
			docDuLieuDatabaseVaoTableChamCong();
		}
	}
}

