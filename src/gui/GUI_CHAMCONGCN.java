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

import org.apache.poi.hslf.dev.SlideAndNotesAtomListing;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import dao.DAO_ChamCongCN1;
import dao.DAO_ChamCongNV1;
import dao.DAO_CongNhan;
import entity.ChamCongCN;
import entity.ChamCongCN1;
import entity.ChamCongNV;
import entity.ChamCongNV1;
import entity.CongNhan;
import entity.CongNhanNew;
import entity.HopDongNV;
import entity.NhanVienNew;
import entity.PhanCong_tv;
import entity.TangCa;


public class GUI_CHAMCONGCN extends JFrame implements ActionListener,MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
//	private DAO_CaLam dao_CaLam = new DAO_CaLam();
	private DAO_ChamCongCN1 dao_ChamCongCN= new DAO_ChamCongCN1();	
	
	private JTable table;
	private DefaultTableModel model;
	private JTable table_1;
	private JTable table_2;
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
	private JTextField textField_SPHC;
	private JLabel lblTongSP;
	private JLabel lblNewLabel_5;
	private JTextField textField_SPTC;

	private JCheckBox chckbxDiemDanh;

	private JButton btnXuatFile;
//	public static void main(String[] args) {
//		
//		//System.out.print();;
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI_CHAMCONGCN frame = new GUI_CHAMCONGCN();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			
//		});
//	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public GUI_CHAMCONGCN() {
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
		
		JLabel lblNewLabel = new JLabel("Quản Lý Chấm Công Công Nhân");
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
					"Mã công nhân","Công nhân", "Sản phẩm","Công đoạn"
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
		scrollPane_1.setBounds(0, 96, 1330, 405);
		panel_2.add(scrollPane_1);
		
		
		tableChamCong = new JTable(modelChamCong);

		
		scrollPane_1.setViewportView(tableChamCong);
		
		JLabel lblNewLabel_1 = new JLabel("Chấm công");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setForeground(new Color(51, 51, 204));
		lblNewLabel_1.setBounds(14, 0, 128, 17);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày chấm công:");
		lblNewLabel_2.setBounds(14, 27, 128, 26);
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
		ngayTaoHD.setBounds(132, 27, 219, 25);
		panel_2.add(ngayTaoHD);
		
		lblNewLabel_3 = new JLabel("Có mặt/Vắng mặt:");
		lblNewLabel_3.setBounds(387, 28, 121, 24);
		panel_2.add(lblNewLabel_3);
		
		chckbxDiemDanh = new JCheckBox("");
		chckbxDiemDanh.setBounds(515, 27, 26, 26);
		panel_2.add(chckbxDiemDanh);
		
		JLabel lblNewLabel_4 = new JLabel("Số sản phẩm hành chính:");
		lblNewLabel_4.setBounds(582, 27, 157, 26);
		panel_2.add(lblNewLabel_4);
		
		textField_SPHC = new JTextField();
		textField_SPHC.setText("0");
		textField_SPHC.setEnabled(false);
		textField_SPHC.setBounds(749, 28, 58, 26);
		panel_2.add(textField_SPHC);
		textField_SPHC.setColumns(10);
		
		JLabel lblNew = new JLabel("/");
		lblNew.setBounds(820, 27, 11, 26);
		panel_2.add(lblNew);
		
		lblTongSP = new JLabel("");
		lblTongSP.setBounds(841, 27, 45, 26);
		panel_2.add(lblTongSP);
		
		lblNewLabel_5 = new JLabel("Số sản phẩm tăng ca:");
		lblNewLabel_5.setBounds(941, 27, 157, 26);
		panel_2.add(lblNewLabel_5);
		
		textField_SPTC = new JTextField();
		textField_SPTC.setText("0");
		textField_SPTC.setEnabled(false);
		textField_SPTC.setColumns(10);
		textField_SPTC.setBounds(1108, 27, 58, 26);
		panel_2.add(textField_SPTC);
		
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
		btnRefresh.setBounds(638, 0, 156, 30);
	
		btnLuu = new JButton("Lưu");
		btnLuu.setBackground(SystemColor.inactiveCaptionBorder);
		btnLuu.setBounds(384, 0, 156, 30);
		
		diLam = new JCheckBox();
		comboBox_TC = new JComboBox<Object>(new Object[] {0,1,2,3,4});
		comboBox_TC.setFont(new Font("Tahoma", Font.PLAIN, 10));
		comboBox_TC.setBounds(767, 175, 126, 22);
		
		btnXuatFile = new JButton("Xuất bảng công");
		btnXuatFile.setToolTipText("Sửa đổi thông tin phiếu ca làm");
		btnXuatFile.setBackground(SystemColor.textHighlight);
		btnXuatFile.setBounds(883, 0, 156, 30);
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
	
	

	private void xoaHetDuLieuTrenTableMode() {
		DefaultTableModel dm = (DefaultTableModel) tableChamCong.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();

		}
	

	private void docDuLieuDatabaseVaoTableChamCong() {
		// TODO Auto-generated method stub
		List<PhanCong_tv> dsHD = dao_ChamCongCN.getAllChamCong();
		for (PhanCong_tv chamCongCN :dsHD) {
		modelChamCong.addRow(new Object[] {
			chamCongCN.getcNew().getMaCN(),chamCongCN.getcNew().getHoTen(),chamCongCN.getsPham().getTenSP(),chamCongCN.getGiaiDoanString()
		});
		}
	}

	public  int taoMa(int ma) {
		String maSoHD = dao_ChamCongCN.getMaLonNhat().trim();
		int a = Integer.parseInt(maSoHD);
		ma = (a+1);
//		textFieldMaHD.setText("HDNV0"+(maSoHD+1));
		return ma;
	}
	public void them() {
		int row = tableChamCong.getSelectedRow();
		int maCC =0;
		taoMa(maCC);
		String maNVString= modelChamCong.getValueAt(row, 0).toString().trim();
		Date ngayTao = (Date) ngayTaoHD.getModel().getValue();
		boolean diemDanh = chckbxDiemDanh.isSelected();
		int soSPHC = Integer.parseInt(textField_SPHC.getText().trim());
		int soSPTC = Integer.parseInt(textField_SPTC.getText().trim());
		String maNguoiCham = lblNhanVienDangNhap.getText().trim();
		NhanVienNew nguoiCham = new NhanVienNew(maNguoiCham);
		CongNhanNew maCongNhanNew = new CongNhanNew(maNVString);
		ChamCongCN1 chamCongCN1 = new ChamCongCN1(taoMa(maCC), maCongNhanNew, ngayTao, diemDanh, soSPHC, soSPTC, nguoiCham);
		
		if(!dao_ChamCongCN.getAllChamCongCN().contains(chamCongCN1)) {
			try {
				dao_ChamCongCN.creatChamCong(chamCongCN1);
				
				JOptionPane.showMessageDialog(this, "Thêm thành công");
			}catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
		else {
			JOptionPane.showMessageDialog(this, "TRÙNG! Đã chấm công cho công nhân này vào hôm nay rồi");
		}
			
		}
	public boolean kiemtra() {
		
		
		if (!chckbxDiemDanh.isSelected()) {
			
			textField_SPHC.setText("0");
			textField_SPTC.setText("0");
			return true;
		} else {
			try {
				int soSPHC= Integer.parseInt(textField_SPHC.getText().trim());
				int soSPTC= Integer.parseInt(textField_SPTC.getText().trim());
				int tong = Integer.parseInt(lblTongSP.getText().trim());
				if (textField_SPHC.getText().trim().length()>=0 && textField_SPTC.getText().trim().length()>=0 ) {
					if (soSPHC>tong) {
						JOptionPane.showMessageDialog(this, "Số lượng sản phẩm giờ hành chính vượt phép");
						return false;
					} else {
						if ((soSPTC+soSPHC)>tong) {
							JOptionPane.showMessageDialog(this, "Số lượng sản phẩm giờ tăng ca vượt phép");
							return false;
						}
					}
				} else
					JOptionPane.showMessageDialog(this, "Không được để trống");
				
			} catch (NumberFormatException e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Giá trị nhập vào phải là số và không được để trống");
			}
			
			
		}
		return true;
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
	public void xuatfile() {
		ArrayList<ChamCongCN1> arr =dao_ChamCongCN.getAllBangCong();
		try {
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("BangCong");
			XSSFRow row=null;
			Cell cell= null;
			row=sheet.createRow(3);
			
			cell=row.createCell(0,CellType.STRING);
			cell.setCellValue("Mã công nhân");
	
			cell=row.createCell(1,CellType.STRING);
			cell.setCellValue("Họ tên");
			
			cell=row.createCell(2,CellType.STRING);
			cell.setCellValue("Ngày chấm công");
			
			cell=row.createCell(3,CellType.BOOLEAN);
			cell.setCellValue("Điểm danh");
			
			cell=row.createCell(4,CellType.STRING);
			cell.setCellValue("Số sản phẩm hành chính");
			
			cell=row.createCell(5,CellType.STRING);
			cell.setCellValue("Số sản phẩm tăng ca");
			
			
			for(int i=0;i<arr.size();i++) {
				row=sheet.createRow(i+4);
				
				cell = row.createCell(0,CellType.STRING);
				cell.setCellValue(arr.get(i).getCongNhanNew().getMaCN());
				
				cell = row.createCell(1,CellType.STRING);
				cell.setCellValue(arr.get(i).getCongNhanNew().getHoTen());
				
				cell = row.createCell(2,CellType.STRING);
				cell.setCellValue(arr.get(i).getNgayCCDate().toString());
				
				cell = row.createCell(3,CellType.BOOLEAN);
				cell.setCellValue(arr.get(i).isDiemDanh()?"Có mặt":"Vắng mặt");
				
				cell = row.createCell(4,CellType.STRING);
				cell.setCellValue(arr.get(i).getSoSPHC());
				
				cell = row.createCell(5,CellType.STRING);
				cell.setCellValue(arr.get(i).getSoSPTC());
				
				
				
				
				
			}
			File f= new File("C:\\New folder\\BangCongCongNhan.xlsx");
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
	

//
//
//});
	
	
	
	
	
	
	// Xóa
	
	
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		
		if (o.equals(tableChamCong)) {
			int row = tableChamCong.getSelectedRow();
			String aString = modelChamCong.getValueAt(row, 0).toString().trim();
			String bString = modelChamCong.getValueAt(row, 2).toString().trim();
			String cString =modelChamCong.getValueAt(row, 3).toString().trim();
			String sqlString="SELECT  SUM(soLuong) from tb_CONGNHAN inner join tb_PHANCONG on tb_CONGNHAN.maCN = tb_PHANCONG.maCN inner join tb_SANPHAM on tb_PHANCONG.maSP=tb_SANPHAM.maSP inner join tb_HOPDONGSP on tb_SANPHAM.maSP=tb_HOPDONGSP.maSP where tb_CONGNHAN.maCN='"+aString+"' and tb_SANPHAM.tenSP='"+bString+"' and tb_PHANCONG.giaiDoan='"+cString+"'";
			String kgString = String.valueOf(dao_ChamCongCN.getTongSP(sqlString)+50);
			lblTongSP.setText(kgString);
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnChamCong)) {
			int row = tableChamCong.getSelectedRow();
			if (row!=-1) {
				if (kiemtra()) {
					them();
				} else
					JOptionPane.showMessageDialog(this, "Chấm công thất bại");
				
			} else
				JOptionPane.showMessageDialog(this, "Vui lòng chọn công nhân chấm công");
		}
		if (o.equals(chckbxDiemDanh)) {
			if (chckbxDiemDanh.isSelected()) {
				textField_SPHC.setEnabled(true);
				textField_SPTC.setEnabled(true);
			}
			else {
				textField_SPHC.setEnabled(false);
				textField_SPTC.setEnabled(false);
				textField_SPHC.setText("0");
				textField_SPTC.setText("0");
			}
		}
		if (o.equals(btnRefresh)) {
			xoaHetDuLieuTrenTableMode();
			docDuLieuDatabaseVaoTableChamCong();
		}
		if(o.equals(btnXuatFile)) {
			xuatfile();
		}
	}
}

