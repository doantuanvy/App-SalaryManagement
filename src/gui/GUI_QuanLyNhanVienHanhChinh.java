package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField.AbstractFormatter;
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
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import connectDB.ConnectDB;
import dao.DAO_NhanVienHanhChinh;
import entity.CongNhanNew;
import entity.NhanVienHanhChinh;

public class GUI_QuanLyNhanVienHanhChinh extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtMa;
	private JTextField txtHoTen;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtDVCongTac1;
	private DefaultTableModel model;
	private JDatePickerImpl datePickerImplNgaySinh;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnXoaRong;
	private JButton btnSua;
	private JButton btnTaiLai;
	private JCheckBox checkGioiTinh;
	private DAO_NhanVienHanhChinh nv_Dao;
	private JTextField txtTim;
	private JButton btnTim;
	private JTextField txtCanCuoc;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI_QuanLyNhanVienHanhChinh frame = new GUI_QuanLyNhanVienHanhChinh();
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
	public GUI_QuanLyNhanVienHanhChinh() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 680);
		contentPane = new JPanel();
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
		
		nv_Dao = new DAO_NhanVienHanhChinh();
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 10, 1326, 76);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Th??ng Tin Nh??n Vi??n");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 45));
		lblNewLabel.setBounds(468, 10, 440, 55);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.inactiveCaptionText, SystemColor.inactiveCaptionText, SystemColor.inactiveCaptionText, SystemColor.inactiveCaptionText));
		panel_1.setBounds(10, 90, 1326, 265);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 17));
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBounds(10, 53, 1306, 206);
		panel_1.add(scrollPane);
		
		String[] cols= {"M?? C??ng Nh??n","H??? T??n","Gi???i t??nh","S??? ??i???n Tho???i","Ng??y Sinh","?????a Ch???","????n V??? C??ng T??c","C??n C?????c"};
		model= new DefaultTableModel(cols,0);
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setPreferredWidth(1);
		table.getColumnModel().getColumn(2).setPreferredWidth(1);
		table.getColumnModel().getColumn(3).setPreferredWidth(1);
		table.getColumnModel().getColumn(4).setPreferredWidth(1);
		scrollPane.setViewportView(table);
		
		txtTim = new JTextField();
		txtTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTim.setBounds(10, 12, 375, 34);
		panel_1.add(txtTim);
		txtTim.setColumns(10);
		
		btnTim = new JButton("");
		btnTim.setIcon(new ImageIcon(getClass().getClassLoader().getResource("search.png")));
		
		btnTim.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		btnTim.setBounds(395, 11, 49, 34);
		panel_1.add(btnTim);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaptionBorder);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(10, 548, 1326, 85);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		btnThem = new JButton("Th??m");
		btnThem.setSelectedIcon(null);
		btnThem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("add.png")));
		btnThem.setFont(new Font("Serif", Font.PLAIN, 22));
		btnThem.setBounds(29, 21, 110, 40);
		panel_2.add(btnThem);
		
		 btnXoa = new JButton("X??a");
		 btnXoa.setIcon(new ImageIcon(getClass().getClassLoader().getResource("delete.png")));
		btnXoa.setFont(new Font("Serif", Font.PLAIN, 22));
		btnXoa.setBounds(178, 21, 110, 40);
		panel_2.add(btnXoa);
		
		btnXoaRong = new JButton("X??a R???ng");
		btnXoaRong.setIcon(new ImageIcon(getClass().getClassLoader().getResource("blank.png")));
		btnXoaRong.setFont(new Font("Serif", Font.PLAIN, 22));
		btnXoaRong.setBounds(512, 21, 170, 40);
		panel_2.add(btnXoaRong);
		
		 btnSua = new JButton("S???a");
		 btnSua.setIcon(new ImageIcon(getClass().getClassLoader().getResource("edit.png")));
		btnSua.setFont(new Font("Serif", Font.PLAIN, 22));
		btnSua.setBounds(347, 21, 110, 40);
		panel_2.add(btnSua);
		
		 btnTaiLai = new JButton("T???i L???i");
		 btnTaiLai.setIcon(new ImageIcon(getClass().getClassLoader().getResource("reset.png")));
		 btnTaiLai.setBounds(725, 21, 160, 40);
		 panel_2.add(btnTaiLai);
		 btnTaiLai.setFont(new Font("Serif", Font.PLAIN, 22));
		 
		 JButton btnNewButton = new JButton("Xu???t File");
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		ArrayList<NhanVienHanhChinh> arr = nv_Dao.getAllNhanVienHanhChinh();
				try {
					XSSFWorkbook workbook = new XSSFWorkbook();
					XSSFSheet sheet = workbook.createSheet("danhsach");
					XSSFRow row=null;
					Cell cell= null;
					row=sheet.createRow(3);
					
					cell=row.createCell(0,CellType.STRING);
					cell.setCellValue("M?? nh??n vi??n");

					cell=row.createCell(1,CellType.STRING);
					cell.setCellValue("H??? t??n");
					
					cell=row.createCell(2,CellType.BOOLEAN);
					cell.setCellValue("Gi???i t??nh");
					
					cell=row.createCell(3,CellType.STRING);
					cell.setCellValue("S??? ??i???n tho???i");
					
					cell=row.createCell(4,CellType.STRING);
					cell.setCellValue("Ng??y sinh");
					
					cell=row.createCell(5,CellType.STRING);
					cell.setCellValue("??i??? ch???");
					
					cell=row.createCell(6,CellType.STRING);
					cell.setCellValue("????n v??? c??ng t??c");
					
					cell=row.createCell(6,CellType.STRING);
					cell.setCellValue("C??n c?????c");
					for(int i=0;i<arr.size();i++) {
						row=sheet.createRow(i+4);
						
						cell = row.createCell(0,CellType.STRING);
						cell.setCellValue(arr.get(i).getMaNhanVien().trim());
						
						cell = row.createCell(1,CellType.STRING);
						cell.setCellValue(arr.get(i).getHoTen().trim());
						
						cell = row.createCell(2,CellType.BOOLEAN);
						cell.setCellValue(arr.get(i).getGioiTinh()?"Nam":"N???");
						
						cell = row.createCell(3,CellType.STRING);
						cell.setCellValue(arr.get(i).getSdt().trim());
						
						cell = row.createCell(4,CellType.STRING);
						cell.setCellValue(arr.get(i).getNgaySinh().toString());
						
						cell = row.createCell(5,CellType.STRING);
						cell.setCellValue(arr.get(i).getDiaChi().trim());
						
						cell = row.createCell(6,CellType.STRING);
						cell.setCellValue(arr.get(i).getCanCuoc().trim());
						
						
						
					}
					String filePath = "C:\\New folder\\danhsachcongnhan.xlsx";
					File f= new File(filePath);
					try {
						FileOutputStream fis =new FileOutputStream(f);
						workbook.write(fis);
						fis.close();
					} catch (Exception e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null,"Xu???t file th???t b???i do kh??ng t??m ???????c ???????ng d???n" );
						return;
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Xu???t file th??nh c??ng");
		 	
		 	}
		 });
		 btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		 btnNewButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("excel.png")));
		 btnNewButton.setBounds(915, 21, 166, 40);
		 panel_2.add(btnNewButton);
		 
		 JButton btnNewButton_1 = new JButton("Nh???p t??? exel");
		 btnNewButton_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		File excelFile;
				@SuppressWarnings("unused")
				FileInputStream excelFIS = null;
				BufferedInputStream excelBIS = null;
				XSSFWorkbook excelJtableImport=null;
				//ch???n path m???c ?????nh
				String defaultCurrentDirectoryPath ="E:\\eclipse";
				JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
				int excelChooser = excelFileChooser.showOpenDialog(null);
				//ch???n open
				if(excelChooser == JFileChooser.APPROVE_OPTION) {
					try {
						excelFile = excelFileChooser.getSelectedFile();
						excelFIS =new FileInputStream(excelFile);
						excelBIS = new BufferedInputStream(excelFIS);
						
						excelJtableImport = new XSSFWorkbook(excelBIS);
						XSSFSheet excelSheet = excelJtableImport.getSheetAt(0);
						//l???p qua d??ng, c???t c???a excel
						for(int row=0;row<excelSheet.getLastRowNum();row++) {
							XSSFRow excelRow = excelSheet.getRow(row+1);
							
							
							XSSFCell excelMaCN = excelRow.getCell(0);
							XSSFCell excelHotenCN = excelRow.getCell(1);
							boolean excelGioiTinh = excelRow.getCell(2).getBooleanCellValue();
							XSSFCell excelSDT = excelRow.getCell(3);
							XSSFCell excelngaySinh =   excelRow.getCell(4);
							XSSFCell exceldiChi = excelRow.getCell(5);
							XSSFCell exceldonvi = excelRow.getCell(6);
							XSSFCell excelcanCuoc = excelRow.getCell(7);
//							Date h = (Date) excelRow.getCell(4).getDateCellValue();
						    java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
						        
							NhanVienHanhChinh nv = new NhanVienHanhChinh(
									excelMaCN.toString().trim(),
									excelHotenCN.toString().trim(),
									excelGioiTinh,
									excelSDT.toString().trim(),
									date,
									exceldiChi.toString().trim(),
									exceldonvi.toString().trim(),
									excelcanCuoc.toString().trim());
							nv_Dao.create(nv);
							GUI_QuanLyNhanVienHanhChinh.this.model.addRow(new Object[] {
									excelMaCN.toString().trim(),
									excelHotenCN.toString().trim(),
									excelGioiTinh ?"Nam":"N???",//?"true":"false"
									excelSDT.toString().trim(),
									excelngaySinh.toString().trim(),
									exceldiChi.toString().trim(),
									exceldonvi.toString().trim(),
									excelcanCuoc.toString().trim()
							});
							
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
				}
				
		 	}
		 });
		 btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		 btnNewButton_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("excel import.png")));
		 btnNewButton_1.setBounds(1109, 21, 187, 40);
		 panel_2.add(btnNewButton_1);
		 btnTaiLai.addActionListener(this);
		
		JPanel lable_9 = new JPanel();
		lable_9.setBounds(10, 365, 1326, 173);
		contentPane.add(lable_9);
		lable_9.setBackground(SystemColor.controlHighlight);
		lable_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lable_9.setBorder(new TitledBorder(null, "Th\u00F4ng Tin Chi ti\u1EBFt", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lable_9.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("M?? C??ng Nh??n: ");
		lblNewLabel_1.setBounds(21, 10, 154, 33);
		lable_9.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		
		txtMa = new JTextField();
		txtMa.setEditable(false);
		txtMa.setBounds(172, 14, 220, 30);
		lable_9.add(txtMa);
		txtMa.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtMa.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("S??? ??i???n Thoai:");
		lblNewLabel_1_2.setBounds(406, 10, 154, 33);
		lable_9.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		
		txtSDT = new JTextField();
		txtSDT.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtSDT.setBounds(555, 17, 226, 30);
		lable_9.add(txtSDT);
		txtSDT.setColumns(10);
		
		SqlDateModel model1 = new SqlDateModel();
		Properties p =  new Properties();
		p.put("text.date", "date");
		p.put("text.month", "month");
		p.put("text.year", "year");
		JDatePanelImpl impl1 = new JDatePanelImpl(model1, p);
		
		SqlDateModel model2 = new SqlDateModel();
		JDatePanelImpl impl2 = new JDatePanelImpl(model2, p);
		datePickerImplNgaySinh = new JDatePickerImpl(impl2, new AbstractFormatter() {
			
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
				// TODO Auto-generated method stub
				return null;
			}
		});
		datePickerImplNgaySinh.getJFormattedTextField().setFont(new Font("Times New Roman", Font.PLAIN, 20));
		datePickerImplNgaySinh.setTextEditable(true);
		datePickerImplNgaySinh.getJFormattedTextField().setBorder(new LineBorder(new Color(171, 173, 179)));
		datePickerImplNgaySinh.setBounds(555, 61, 226, 30);
		lable_9.add(datePickerImplNgaySinh);
		
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Ng??y Sinh:");
		lblNewLabel_1_2_1.setBounds(437, 57, 114, 33);
		lable_9.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		
		
		
		txtHoTen = new JTextField();
		txtHoTen.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtHoTen.setBounds(172, 57, 220, 30);
		lable_9.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("H??? T??n:");
		lblNewLabel_1_1.setBounds(82, 54, 87, 33);
		lable_9.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Gi???i T??nh:");
		lblNewLabel_1_1_1.setBounds(61, 110, 98, 33);
		lable_9.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		
		JLabel lblNewLabel_1_2_2 = new JLabel("?????a Ch???:");
		lblNewLabel_1_2_2.setBounds(467, 110, 78, 33);
		lable_9.add(lblNewLabel_1_2_2);
		lblNewLabel_1_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtDiaChi.setBounds(555, 114, 226, 30);
		lable_9.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblNewLabel_1_2_5 = new JLabel("????n V??? C??ng T??c:");
		lblNewLabel_1_2_5.setBounds(812, 27, 186, 33);
		lable_9.add(lblNewLabel_1_2_5);
		lblNewLabel_1_2_5.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		
		txtDVCongTac1 = new JTextField();
		txtDVCongTac1.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtDVCongTac1.setBounds(996, 30, 226, 30);
		lable_9.add(txtDVCongTac1);
		txtDVCongTac1.setColumns(10);
		
		checkGioiTinh = new JCheckBox("Nam");
		checkGioiTinh.setBackground(SystemColor.controlHighlight);
		checkGioiTinh.setBorder(new LineBorder(new Color(0, 0, 0)));
		checkGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkGioiTinh.setBounds(172, 113, 211, 27);
		lable_9.add(checkGioiTinh);
		
		btnThem.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnTim.addActionListener(this);
//		btnLoc.addActionListener(this);
		btnTaiLai.addActionListener(this);
		txtDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtDVCongTac1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMa.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		txtCanCuoc = new JTextField();
		txtCanCuoc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCanCuoc.setBounds(996, 99, 226, 30);
		txtCanCuoc.setBorder(new LineBorder(new Color(0, 0, 0)));
		lable_9.add(txtCanCuoc);
		txtCanCuoc.setColumns(10);
		
		JLabel lblCanCuoc = new JLabel("C??n C?????c");
		lblCanCuoc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCanCuoc.setBounds(888, 99, 98, 27);
		lable_9.add(lblCanCuoc);
		
		//h??m ?????c d??? li???u l??n table
		Doculieuvaotabel();
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
		        if(row!=-1) {
		        	txtMa.setText(table.getValueAt(row, 0).toString());
		        	txtHoTen.setText(table.getValueAt(row, 1).toString());
		        	
//		        	checkGioiTinh.setSelected( table.getValueAt(row, 2)?"Nam":"N???");
		        	Boolean sex=false;
		        	if(table.getValueAt(row, 2).equals("Nam"))
		        		sex=true;
		        	
		        	checkGioiTinh.setSelected( sex);
		        	txtSDT.setText(table.getValueAt(row, 3).toString());
		        	datePickerImplNgaySinh.getJFormattedTextField().setText(table.getValueAt(row, 4).toString());
		        	txtDiaChi.setText(table.getValueAt(row, 5).toString());
		        	txtDVCongTac1.setText(table.getValueAt(row, 6).toString());
		        	txtCanCuoc.setText(table.getValueAt(row, 7).toString());
				
			}
		}}
		);
	}
	//ki???m tra c?? t??m th???y nh??n vi??n hay kh??ng
	public static boolean isEmpty(JTable jTable) {
        if (jTable != null && jTable.getModel() != null) {
            return jTable.getModel().getRowCount()<=0?true:false;
        }
        return false;
    }
	public String taoMaCN() {
		int maSoHD = nv_Dao.getAllNhanVienHanhChinh().size();	
		
		String result= "NV"+(maSoHD+1);
		return result;
	}
	public  void taoMa() {
		String ma ="NV";
		String maSoHD = nv_Dao.getMaLonNhat().trim();
		int a = Integer.parseInt(maSoHD.substring(2));
		
		if(a>=1&&a<=8) {
			ma += "000";
		}
		else if(a>=9&&a<=98) {
			ma += "00";
		}
		else if(a>=99&&a>=998) {
			ma += "0";
		}
		
		txtMa.setText(ma+(a+1));
//		textFieldMaHD.setText("HDNV0"+(maSoHD+1));
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object o = e.getSource();
		if(o.equals(btnThem)){
//			new GUI_ThongTinThemNhanVien().setVisible(true);
//			this.setVisible(false);
			
			try {
				taoMa();
				txtMa.setEditable(false);
				txtHoTen.requestFocus();
				if(kiemtra() ) {
					String maNV =txtMa.getText();
					String tenNV = txtHoTen.getText();
					boolean gioiTinh = checkGioiTinh.isSelected();
					String sdt= txtSDT.getText();
					java.sql.Date NgaySinh = (java.sql.Date) datePickerImplNgaySinh.getModel().getValue();
					String diaChi = txtDiaChi.getText();
					String donVi = txtDVCongTac1.getText();
					String cccd = txtCanCuoc.getText();
					NhanVienHanhChinh nv= new NhanVienHanhChinh(maNV,tenNV,gioiTinh,sdt,NgaySinh,diaChi,donVi,cccd);
				if(!nv_Dao.getAllNhanVienHanhChinh().contains(nv)) {
					try {
						nv_Dao.create(nv);
						tailai();
						JOptionPane.showMessageDialog(this, "Th??m th??nh C??ng!");
					} catch (Exception e2) {
						e2.printStackTrace();
					}	
			}else {
				JOptionPane.showMessageDialog(this, "Tr??ng M?? C??ng Nh??n!");
				}
			}
				}
			 catch (Exception e2) {
				e2.printStackTrace();
			 	}
			}
				
				
		if(o.equals(btnXoaRong)) {
					txtMa.setText("");
					txtMa.setEditable(true);
					txtHoTen.setText("");
					checkGioiTinh.setSelected(false);
					txtSDT.setText("");
					datePickerImplNgaySinh.getJFormattedTextField().setText("");
					txtDiaChi.setText("");
					txtDVCongTac1.setText("");
				}
		if(o.equals(btnSua)) {
			try {	
					int row = table.getSelectedRow();
					if(row>=0) {
						NhanVienHanhChinh nv = suakh();
						if(nv_Dao.Updata(nv)) {
							model.setRowCount(0);
							Doculieuvaotabel();
							JOptionPane.showMessageDialog(this, "S???a th??ng tin th??nh c??ng!");
						}
				}else
					JOptionPane.showMessageDialog(this, "B???n ph???i ch???n Kh??ch H??ng c???n s???a. ");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if(row != -1){
				int hoiNhac = JOptionPane.showConfirmDialog(this, "Ch???c ch???n x??a kh??ng? ", "Ch?? ??", JOptionPane.YES_NO_OPTION);
				if(hoiNhac == JOptionPane.YES_OPTION) {
					String maKH = (String) table.getValueAt(row, 0);
					if(nv_Dao.delete(maKH)) {
						model.removeRow(row);
						txtMa.setText("");
						txtHoTen.setText("");
						txtSDT.setText("");
						datePickerImplNgaySinh.setVisible(true);
						txtDiaChi.setText("");
						txtDVCongTac1.setText("");
						JOptionPane.showMessageDialog(this, "???? x??a 1 Kh??ch H??ng!");
						
					}
				}
			}
		}
		if(o.equals(btnTim)){
			String tim = txtTim.getText();
			DefaultTableModel model1 = (DefaultTableModel) table.getModel();
			model1.setRowCount(0);
			try {
				//theo ma
				if(tim.length()!=0 ) {
					Doculieuvaotabel1(tim);
					if(isEmpty(table)) {
						System.err.println("ko thay nv theo ma");
						Doculieuvaotabel2(tim);
						if(isEmpty(table)) {
							System.err.println("ko thay nv theo ten");
							Doculieuvaotabel3(tim);
							if(isEmpty(table)) {
								System.err.println("ko thay nv theo ten");
								DoculieuvaotabelPb(tim);
							}
						}	
					}
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			if (isEmpty(table)) {
				JOptionPane.showMessageDialog(null, "Kh??ng t??m th???y nh??n vi??n n??o");
				tim="rong";
				Doculieuvaotabel();
				txtTim.setText("");
				//????a tr??? chu???t l???i
				txtTim.requestFocus();
			}
		}
		if(o.equals(btnTaiLai)) {
			tailai();
		}
//		if(o.equals(btnLoc)){
//			ArrayList<NhanVienHanhChinh> list = null;
//			int select = comboGioitinh.getSelectedIndex();
//			if(select==0) {
//				int select1 = combodvct.getSelectedIndex();
//				if(select1==0){
//					
//					int select3 = combochucvu.getSelectedIndex();
//					if(select3==0) {
//						list = nv_Dao.locnhanvien("","","");
//					}
//					if(select3==1) {
//						
//						list = nv_Dao.locnhanvien("","","T??? Tr?????ng");
//					}
//					if(select3==2) {
//						list = nv_Dao.locnhanvien("","","Nh??n vi??n");
//						
//					}
//					if(select3==3) {
//						list = nv_Dao.locnhanvien("","","T???p s???");
//					}
//				}
//				if(select1==1){
//					list = nv_Dao.locnhanvien("", "T??? Ch???m C??ng","");
//					int select3 = combochucvu.getSelectedIndex();
//					if(select3==0) {
//						list = nv_Dao.locnhanvien("", "T??? Ch???m C??ng","");
//					}
//					if(select3==1) {
//						list = nv_Dao.locnhanvien("", "T??? Ch???m C??ng","Nh??n vi??n");
//					}
//					if(select3==2) {
//						list = nv_Dao.locnhanvien("", "T??? Ch???m C??ng","T??? Tr?????ng");
//					}
//					if(select3==3) {
//						list = nv_Dao.locnhanvien("", "T??? Ch???m C??ng","T???p s???");
//					}
//				}
//				if(select1==2){
//					list = nv_Dao.locnhanvien("", "T??? Qu???n Kho","");
//					int select3 = combochucvu.getSelectedIndex();
//					if(select3==0) {
//						list = nv_Dao.locnhanvien("", "T??? Qu???n Kho","");
//					}
//					if(select3==1) {
//						list = nv_Dao.locnhanvien("", "T??? Qu???n Kho","Nh??n vi??n");
//					}
//					if(select3==2) {
//						list = nv_Dao.locnhanvien("", "T??? Qu???n Kho","T??? Tr?????ng");
//					}
//					if(select3==3) {
//						list = nv_Dao.locnhanvien("", "T??? Qu???n Kho","T???p s???");
//					}
//				}
//				if(select1==3){
//					list = nv_Dao.locnhanvien("", "T??? K??? To??n","");
//					int select3 = combochucvu.getSelectedIndex();
//					if(select3==0) {
//						list = nv_Dao.locnhanvien("", "T??? K??? To??n","");
//					}
//					if(select3==1) {
//						list = nv_Dao.locnhanvien("", "T??? K??? To??n","Nh??n vi??n");
//					}
//					if(select3==2) {
//						list = nv_Dao.locnhanvien("", "T??? K??? To??n","T??? Tr?????ng");
//					}
//					if(select3==3) {
//						list = nv_Dao.locnhanvien("", "T??? K??? To??n","T???p s???");
//					}
//				}
//			}
//			if(select==1) {
//				int select1 = combodvct.getSelectedIndex();
//					if(select1==0){
//						list = nv_Dao.locnhanvien("Nam","","");
//						int select3 = combochucvu.getSelectedIndex();
//						if(select3==0) {
//							list = nv_Dao.locnhanvien("Nam", "","");
//						}
//						if(select3==1) {
//							list = nv_Dao.locnhanvien("Nam", "","Nh??n vi??n");
//						}
//						if(select3==2) {
//							list = nv_Dao.locnhanvien("Nam", "","T??? Tr?????ng");
//						}
//						if(select3==3) {
//							list = nv_Dao.locnhanvien("Nam", "","T???p s???");
//						}
//					}
//					if(select1==1){
//						list = nv_Dao.locnhanvien("Nam", "T??? Ch???m C??ng","");
//						int select3 = combochucvu.getSelectedIndex();
//						if(select3==0) {
//							list = nv_Dao.locnhanvien("Nam", "T??? Ch???m C??ng","");
//						}
//						if(select3==1) {
//							list = nv_Dao.locnhanvien("Nam", "T??? Ch???m C??ng","Nh??n vi??n");
//						}
//						if(select3==2) {
//							list = nv_Dao.locnhanvien("Nam", "T??? Ch???m C??ng","T??? Tr?????ng");
//						}
//						if(select3==3) {
//							list = nv_Dao.locnhanvien("Nam", "T??? Ch???m C??ng","T???p s???");
//						}
//					}
//					if(select1==2){
//						list = nv_Dao.locnhanvien("Nam", "T??? Qu???n Kho","");
//						int select3 = combochucvu.getSelectedIndex();
//						if(select3==0) {
//							list = nv_Dao.locnhanvien("Nam", "T??? Qu???n Kho","");
//							
//						}
//						if(select3==1) {
//							list = nv_Dao.locnhanvien("Nam", "T??? Qu???n Kho","Nh??n vi??n");
//							
//						}
//						if(select3==2) {
//							list = nv_Dao.locnhanvien("Nam", "T??? Qu???n Kho","T??? Tr?????ng");
//							
//						}
//						if(select3==3) {
//							list = nv_Dao.locnhanvien("Nam", "T??? Qu???n Kho","T???p s???");
//							
//						}
//					}
//					if(select1==3){
//						list = nv_Dao.locnhanvien("Nam", "T??? K??? To??n","");
//						int select3 = combochucvu.getSelectedIndex();
//						if(select3==3) {
//							if(select3==0) {
//								list = nv_Dao.locnhanvien("Nam", "T??? K??? To??n","");
//								
//							}
//							if(select3==1) {
//								list = nv_Dao.locnhanvien("Nam", "T??? K??? To??n","Nh??n vi??n");
//								
//							}
//							if(select3==2) {
//								list = nv_Dao.locnhanvien("Nam", "T??? K??? To??n","T??? Tr?????ng");
//								
//							}
//							if(select3==3) {
//								list = nv_Dao.locnhanvien("Nam", "T??? K??? To??n","T???p s???");
//								
//							}
//						}
//					}
//			}
//			if(select==2) {
//				int select1 = combodvct.getSelectedIndex();
//				if(select1==0){
//					list = nv_Dao.locnhanvien("N???","","");
//					int select3 = combochucvu.getSelectedIndex();
//					if(select3==0) {
//						list = nv_Dao.locnhanvien("N???", "","");
//					}
//					if(select3==1) {
//						list = nv_Dao.locnhanvien("N???", "","Nh??n vi??n");
//					}
//					if(select3==2) {
//						list = nv_Dao.locnhanvien("N???", "","T??? Tr?????ng");
//					}
//					if(select3==3) {
//						list = nv_Dao.locnhanvien("N???", "","T???p s???");
//					}
//				}
//				if(select1==1){
//					list = nv_Dao.locnhanvien("N???", "T??? Ch???m C??ng","");
//					int select3 = combochucvu.getSelectedIndex();
//					if(select3==0) {
//						list = nv_Dao.locnhanvien("N???", "T??? Ch???m C??ng","");
//					}
//					if(select3==1) {
//						list = nv_Dao.locnhanvien("N???", "T??? Ch???m C??ng","Nh??n vi??n");
//					}
//					if(select3==2) {
//						list = nv_Dao.locnhanvien("N???", "T??? Ch???m C??ng","T??? Tr?????ng");
//					}
//					if(select3==3) {
//						list = nv_Dao.locnhanvien("N???", "T??? Ch???m C??ng","T???p s???");
//					}
//				}
//				if(select1==2){
//					list = nv_Dao.locnhanvien("N???", "T??? Qu???n Kho","");
//					int select3 = combochucvu.getSelectedIndex();
//					if(select3==0) {
//						list = nv_Dao.locnhanvien("N???", "T??? Qu???n Kho","");
//						
//					}
//					if(select3==1) {
//						list = nv_Dao.locnhanvien("N???", "T??? Qu???n Kho","Nh??n vi??n");
//						
//					}
//					if(select3==2) {
//						list = nv_Dao.locnhanvien("N???", "T??? Qu???n Kho","T??? Tr?????ng");
//						
//					}
//					if(select3==3) {
//						list = nv_Dao.locnhanvien("N???", "T??? Qu???n Kho","T???p s???");
//						
//					}
//				}
//				if(select1==3){
//					list = nv_Dao.locnhanvien("N???", "T??? K??? To??n","");
//					int select3 = combochucvu.getSelectedIndex();
//					if(select3==3) {
//						if(select3==0) {
//							list = nv_Dao.locnhanvien("N???", "T??? K??? To??n","");
//							
//						}
//						if(select3==1) {
//							list = nv_Dao.locnhanvien("N???", "T??? K??? To??n","Nh??n vi??n");
//							
//						}
//						if(select3==2) {
//							list = nv_Dao.locnhanvien("N???", "T??? K??? To??n","T??? Tr?????ng");
//							
//						}
//						if(select3==3) {
//							list = nv_Dao.locnhanvien("N???", "T??? K??? To??n","T???p s???");
//							
//						}
//					}
//				}
//			}
//			model.setRowCount(0);
//			for (NhanVienHanhChinh nv :list) {
//				model.addRow(new Object[] {
//						nv.getMaNhanVien(),
//						nv.getHoTen(),
//						nv.getGioiTinh(),
//						nv.getSdt(),
//						nv.getNgaySinh(),
//						nv.getDiaChi(),
//						nv.getDonViCongTac(),
//				});			
//	}
//			
//		}
	}
	
	public void tailai() {
		DefaultTableModel defaultTableModel =  (DefaultTableModel) table.getModel();
		defaultTableModel.getDataVector().removeAllElements();
		defaultTableModel.fireTableDataChanged();
		Doculieuvaotabel();
	}
	public void Doculieuvaotabel(){
		List<NhanVienHanhChinh> list = nv_Dao.getAllNhanVienHanhChinh();
		
		for (NhanVienHanhChinh nv :list) {
					model.addRow(new Object[] {
							nv.getMaNhanVien().trim(),
							nv.getHoTen().trim(),
							nv.getGioiTinh()?"Nam":"N???",
							nv.getSdt().trim(),
							nv.getNgaySinh(),
							nv.getDiaChi().trim(),
							nv.getDonViCongTac().trim(),
							nv.getCanCuoc().trim(),
					});			
		}
	}
	//?????c D??? li???u v??o theo m??
	public void Doculieuvaotabel1(String ma){
		
		List<NhanVienHanhChinh> list = nv_Dao.getnhanvienma(ma);
						
						if(list != null) {
							for(NhanVienHanhChinh nv1 :list) {
								model.addRow(new Object[] {
									nv1.getMaNhanVien().trim(),
									nv1.getHoTen().trim(),
									nv1.getGioiTinh()?"Nam":"N???",
									nv1.getSdt().trim(),
									nv1.getNgaySinh(),
									nv1.getDiaChi().trim(),
									nv1.getDonViCongTac().trim(),
									nv1.getCanCuoc().trim()
									
							});
							}
							
						}else {
							return;
						}
		
	}
	//?????c D??? li???u v??o theo t??n
	public void Doculieuvaotabel2(String ten){
		
			ArrayList<NhanVienHanhChinh> list = nv_Dao.getnhanvienten(ten);
						if(list != null) {
							for (NhanVienHanhChinh nv2 :list) {		
								model.addRow(new Object[] {
										nv2.getMaNhanVien().trim(),
										nv2.getHoTen().trim(),
										nv2.getGioiTinh(),
										nv2.getSdt().trim(),
										nv2.getNgaySinh(),
										nv2.getDiaChi().trim(),
										nv2.getDonViCongTac().trim(),
										nv2.getCanCuoc().trim()
								});			
							}
						}else {
								return;
						}
													
	}
			
						

	//?????c D??? li???u v??o theo sdt
	public void Doculieuvaotabel3(String sdt){
		
			NhanVienHanhChinh nv3 = nv_Dao.getnhanviensdt(sdt);
			if(nv3 != null) {
						model.addRow(new Object[] {
								nv3.getMaNhanVien(),
								nv3.getHoTen(),
								nv3.getGioiTinh(),
								nv3.getSdt(),
								nv3.getNgaySinh(),
								nv3.getDiaChi(),
								nv3.getDonViCongTac(),
								
						});
			}else {
				return;
			}
		
					

}
	//t??m theo ph??ng 
	public void DoculieuvaotabelPb(String sdt){
		
		ArrayList<NhanVienHanhChinh> list  = nv_Dao.locTheoPhong(sdt);
		if(list != null) {
			for(NhanVienHanhChinh nv3:list) {
				
					model.addRow(new Object[] {
							nv3.getMaNhanVien().trim(),
							nv3.getHoTen().trim(),
							nv3.getGioiTinh()?"Nam":"N???",
							nv3.getSdt().trim(),
							nv3.getNgaySinh(),
							nv3.getDiaChi().trim(),
							nv3.getDonViCongTac().trim(),
							
					});
			}
		}else {
			return;
		}
	
				

}
	private NhanVienHanhChinh suakh()  {
		int row = table.getSelectedRow();
		try {
			if(kiemtra()) {
				String maKhachHang = txtMa.getText().trim();
				String hoTen = txtHoTen.getText();
				Boolean gioiTinh = checkGioiTinh.isSelected()? true: false;
				String sDT = txtSDT.getText();
				java.sql.Date ngaysinh = (java.sql.Date) datePickerImplNgaySinh.getModel().getValue();
				String diaChi = txtDiaChi.getText();
				
				if(ngaysinh==null)
					ngaysinh = (Date) table.getValueAt(row, 4);
				
				String donViCongTac = txtDVCongTac1.getText();
				String canCuoc = txtCanCuoc.getText();
				return new NhanVienHanhChinh(maKhachHang,hoTen,gioiTinh,sDT
						,ngaysinh,diaChi,donViCongTac,canCuoc);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private boolean kiemtra() {
		String ma = txtMa.getText().trim();
		String hoten = txtHoTen.getText().trim();
		String sdt =  txtSDT.getText().trim();
		String diachi =  txtDiaChi.getText().trim();
		String donVicongtac=  txtDVCongTac1.getText().trim();
		String cccd=txtCanCuoc.getText().trim();
		
//		if(!(ma.length() > 0 && ma.matches("[A-Z0-9]{3,8}$"))) {
//			JOptionPane.showMessageDialog(this, "Ch?? ??: Nh???p m?? sai c?? ph??p! (m?? ph???i nh???p ch??? in hoa kh??ng d???u v?? s??? ????? d??i 3-8)");
//			return false;
//		}
		if(hoten.length()==0) {
			JOptionPane.showMessageDialog(this,"Ch?? ??: Nh???p t??n r???ng");
			txtHoTen.requestFocus(true);
			return false;
		}
		else if (!hoten.matches("^[A??????????????????????????????????????????????BCD??E??????????????????????????????FGHI????????????JKLMNO??????????????????????????????????????????????PQRSTU?????????????????????????????VWXY??????????????Z][a??????????????????????????????????????????????bcd??e??????????????????????????????fghi????????????jklmno??????????????????????????????????????????????pqrstu?????????????????????????????vwxy??????????????z]+ [A??????????????????????????????????????????????BCD??E??????????????????????????????FGHI????????????JKLMNO??????????????????????????????????????????????PQRSTU?????????????????????????????VWXY??????????????Z][a??????????????????????????????????????????????bcd??e??????????????????????????????fghi????????????jklmno??????????????????????????????????????????????pqrstu?????????????????????????????vwxy??????????????z]+(?: [A??????????????????????????????????????????????BCD??E??????????????????????????????FGHI????????????JKLMNO??????????????????????????????????????????????PQRSTU?????????????????????????????VWXY??????????????Z][a??????????????????????????????????????????????bcd??e??????????????????????????????fghi????????????jklmno??????????????????????????????????????????????pqrstu?????????????????????????????vwxy??????????????z]*)*")) {
			JOptionPane.showMessageDialog(this,"Ch?? ??: Nh???p t??n sai c?? ph??p! (Ph???i nh???p k?? t??? kh??ng c?? d???u)");
			txtHoTen.requestFocus(true);
			return false;
		}
		if (!(sdt.length() > 0 && sdt.matches("[0-9]{10}$"))) {
			JOptionPane.showMessageDialog(this,"Ch?? ??: Nh???p s??? ??i???n tho???i sai c?? ph??p!L?? s??? v?? 10 k?? t???!)");
			txtSDT.requestFocus(true);
			return false;
		}
		if (!(diachi.length() > 0 && diachi.matches("[/A-Za-z0-9*a-zA-Z??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????\\s\\\\.,'\\\\-]+"))) {
			JOptionPane.showMessageDialog(this,"Ch?? ??: Nh???p ?????a ch??? sai c?? ph??p! (kh??ng ???????c nh???p k?? t??? ?????c bi???t!)");
			txtDiaChi.requestFocus(true);
			return false;
		}

		if (!(cccd.length()>0)) {
			JOptionPane.showMessageDialog(this,"Ch?? ??: C??n c?????c ??ang tr???ng!)");
			txtCanCuoc.requestFocus(true);
			return false;
		}else if ( !(cccd.matches("[0-9]{12}$"))) {
			JOptionPane.showMessageDialog(this,"Ch?? ??: C??n c?????c ph???i ????? 12 s???!)");
			txtCanCuoc.requestFocus(true);
			return false;
		}
		if (!(donVicongtac.length() > 0 && donVicongtac.matches("[A-Za-z0-9*a-zA-Z??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????\\s\\\\.,'\\\\-]+"))) {
			JOptionPane.showMessageDialog(this,"Ch?? ??: Nh???p ????n v??? c??ng t??c sai! (Kh??ng nh???p k?? t??? ?????c bi???t!)");
			txtDVCongTac1.requestFocus(true);
			return false;
		}
		return true;
	}
}
