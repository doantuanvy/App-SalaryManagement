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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
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
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;
import org.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import connectDB.ConnectDB;
import dao.DAO_CongNhan;
import entity.CongNhanNew;
import javax.swing.SwingConstants;

public class GUI_QuanLyCongNhan extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txthoTen;
	private JTextField txtmaCN;
	private JTextField txtCanCuoc;
	private DefaultTableModel model;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnXoaRong;
	private JButton btnThem;
	private DAO_CongNhan cn_dao;
	private JCheckBox checkGioiTinh;
	private JDatePickerImpl datePickerImpl;
	private JTextField txtTim;
	private JComboBox<String> comboLoc;
	private JButton btnTim;
	private JButton btnLoc;
	private JButton btntaiLai;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI_QuanLyCongNhan frame = new GUI_QuanLyCongNhan();
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
	public GUI_QuanLyCongNhan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 680);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try{
			ConnectDB.getInstance().connect();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		cn_dao = new DAO_CongNhan();
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 10, 1346, 623);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1.setBounds(10, 82, 1327, 332);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 53, 1327, 269);
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setAutoscrolls(true);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel_1.add(scrollPane);
		
		String[] cols= {"M?? C??ng Nh??n","H??? T??n","Gi???i t??nh","S??? ??i???n Tho???i","Ng??y Sinh","?????a Ch???","C??n C?????c"};
		model= new DefaultTableModel(cols,0);
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setPreferredWidth(1);
		table.getColumnModel().getColumn(2).setPreferredWidth(1);
		table.getColumnModel().getColumn(3).setPreferredWidth(1);
		table.getColumnModel().getColumn(4).setPreferredWidth(1);
		scrollPane.setViewportView(table);
		
		comboLoc = new JComboBox<String>();
		comboLoc.setBounds(717, 9, 281, 33);
		comboLoc.setFont(new Font("Tahoma", Font.PLAIN, 22));
		comboLoc.setModel(new DefaultComboBoxModel<String>(new String[] {"L???c Gi???i T??nh", "Nam", "N???"}));
		panel_1.add(comboLoc);
		
		txtTim = new JTextField();
		txtTim.setBounds(46, 9, 402, 33);
		txtTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTim.setColumns(10);
		panel_1.add(txtTim);
		
		btnTim = new JButton("");
		btnTim.setIcon(new ImageIcon(getClass().getClassLoader().getResource("search.png")));
		btnTim.setFont(new Font("Serif", Font.PLAIN, 25));
		btnTim.setBounds(462, 9, 41, 33);
		panel_1.add(btnTim);
		
		btnLoc = new JButton("");
		btnLoc.setIcon(new ImageIcon(getClass().getClassLoader().getResource("filter.png")));
		btnLoc.setFont(new Font("Serif", Font.PLAIN, 25));
		btnLoc.setBounds(1028, 9, 35, 33);
		panel_1.add(btnLoc);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaptionBorder);
		panel_2.setBounds(10, 422, 1327, 112);
		panel_2.setBorder(new TitledBorder(null, "Th\u00F4ng Tin Chi Ti\u1EBFt", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("M?? C??ng Nh??n: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(20, 15, 129, 33);
		panel_2.add(lblNewLabel_1);
		
		txtSDT = new JTextField();
		txtSDT.setBorder(new LineBorder(SystemColor.activeCaptionText));
		txtSDT.setBounds(565, 65, 226, 27);
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(txtSDT);
		txtSDT.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("H??? T??n:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(23, 59, 72, 33);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Gi???i T??nh:");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(434, 15, 103, 33);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Ng??y Sinh:");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(692, 15, 97, 33);
		panel_2.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("?????a Ch???:");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(846, 64, 72, 33);
		panel_2.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("S??? ??i???n Tho???i:");
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_5.setBounds(434, 64, 121, 33);
		panel_2.add(lblNewLabel_1_5);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBorder(new LineBorder(SystemColor.activeCaptionText));
		txtDiaChi.setColumns(10);
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDiaChi.setBounds(916, 65, 226, 27);
		panel_2.add(txtDiaChi);
		
		txthoTen = new JTextField();
		txthoTen.setBorder(new LineBorder(SystemColor.activeCaptionText));
		txthoTen.setColumns(10);
		txthoTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txthoTen.setBounds(165, 65, 226, 27);
		panel_2.add(txthoTen);
		
		txtmaCN = new JTextField();
		txtmaCN.setEditable(false);
		txtmaCN.setBorder(new LineBorder(SystemColor.activeCaptionText));
		txtmaCN.setColumns(10);
		txtmaCN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtmaCN.setBounds(165, 20, 226, 27);

		panel_2.add(txtmaCN);
		
		SqlDateModel model = new SqlDateModel();
		Properties p =  new Properties();
		p.put("text.date", "date");
		p.put("text.month", "month");
		p.put("text.year", "year");
		JDatePanelImpl impl = new JDatePanelImpl(model, p);
		datePickerImpl = new JDatePickerImpl(impl, new AbstractFormatter() {
			
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
		datePickerImpl.setBounds(799, 15, 226, 33);
		panel_2.add(datePickerImpl);
		
		checkGioiTinh = new JCheckBox("Nam");
		checkGioiTinh.setBackground(Color.LIGHT_GRAY);
		checkGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		checkGioiTinh.setBounds(567, 18, 79, 25);
		panel_2.add(checkGioiTinh);
		
		JLabel lbl_can_cuoc = new JLabel("C??n C?????c");
		lbl_can_cuoc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_can_cuoc.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_can_cuoc.setBounds(1055, 18, 91, 27);
		panel_2.add(lbl_can_cuoc);
		
		txtCanCuoc = new JTextField();
		txtCanCuoc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCanCuoc.setBounds(1162, 20, 155, 27);
		panel_2.add(txtCanCuoc);
		txtCanCuoc.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(10, 10, 1327, 68);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Th??ng Tin C??ng Nh??n");
		lblNewLabel.setBounds(373, 10, 449, 55);
		panel_3.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(204, 204, 255));
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBounds(10, 539, 1327, 74);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		btnXoaRong = new JButton("X??a R???ng");
		btnXoaRong.setBounds(500, 17, 185, 40);
		panel_4.add(btnXoaRong);
		btnXoaRong.setIcon(new ImageIcon(getClass().getClassLoader().getResource("blank.png")));
		btnXoaRong.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		btnThem = new JButton("Th??m");
		btnThem.setBounds(33, 17, 168, 40);
		panel_4.add(btnThem);
		btnThem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("add.png")));
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		btnSua = new JButton("S???a");
		btnSua.setBounds(236, 17, 100, 40);
		panel_4.add(btnSua);
		btnSua.setIcon(new ImageIcon(getClass().getClassLoader().getResource("edit.png")));
		
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		btnXoa = new JButton("X??a");
		btnXoa.setBounds(367, 17, 100, 40);
		panel_4.add(btnXoa);
		btnXoa.setIcon(new ImageIcon(getClass().getClassLoader().getResource("delete.png")));
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		btntaiLai = new JButton("T???i L???i");
		btntaiLai.setBounds(730, 17, 140, 40);
		panel_4.add(btntaiLai);
		btntaiLai.setIcon(new ImageIcon(getClass().getClassLoader().getResource("reset.png")));
		btntaiLai.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		JButton btnNewButton = new JButton("Xu???t File");
		btnNewButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("excel.png")));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				ArrayList<CongNhanNew> arr =cn_dao.getAllCongNhan();
				try {
					XSSFWorkbook workbook = new XSSFWorkbook();
					XSSFSheet sheet = workbook.createSheet("danhsach");
					XSSFRow row=null;
					Cell cell= null;
					row=sheet.createRow(3);
					
					cell=row.createCell(0,CellType.STRING);
					cell.setCellValue("M?? c??ng nh??n");

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
					cell.setCellValue("C??n c?????c");
					for(int i=0;i<arr.size();i++) {
						row=sheet.createRow(i+4);
						
						cell = row.createCell(0,CellType.STRING);
						cell.setCellValue(arr.get(i).getMaCN().trim());
						
						cell = row.createCell(1,CellType.STRING);
						cell.setCellValue(arr.get(i).getHoTen().trim());
						
						cell = row.createCell(2,CellType.BOOLEAN);
						cell.setCellValue(arr.get(i).isGioiTinh()?"Nam":"N???");
						
						cell = row.createCell(3,CellType.STRING);
						cell.setCellValue(arr.get(i).getsDT().trim());
						
						cell = row.createCell(4,CellType.STRING);
						cell.setCellValue(arr.get(i).getNgaySinh().toString());
						
						cell = row.createCell(5,CellType.STRING);
						cell.setCellValue(arr.get(i).getDiaChi().trim());
						
						cell = row.createCell(6,CellType.STRING);
						cell.setCellValue(arr.get(i).getcCCD().trim());
						
						
						
					}
					String filePath = "C:\\New folder\\danhsach.xlsx";
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
		btnNewButton.setBounds(918, 17, 178, 40);
		panel_4.add(btnNewButton);
		
		JButton btn_import = new JButton("nh???p t??? file");
		btn_import.addActionListener(new ActionListener() {
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
							XSSFCell excelcanCuoc = excelRow.getCell(6);
							Date h = (Date) excelRow.getCell(4).getDateCellValue();
//						    Date d=new Timestamp(h.getTime())
						    java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
//						    java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
				        
						        
							CongNhanNew cn = new CongNhanNew(
									excelMaCN.toString().trim(),
									excelHotenCN.toString().trim(),
									excelGioiTinh,
									excelSDT.toString().trim(),
									date,
									exceldiChi.toString().trim(),
									excelcanCuoc.toString().trim());
							cn_dao.create(cn);
							GUI_QuanLyCongNhan.this.model.addRow(new Object[] {
									excelMaCN.toString().trim(),
									excelHotenCN.toString().trim(),
									excelGioiTinh ?"Nam":"N???",//?"true":"false"
									excelSDT.toString().trim(),
									excelngaySinh.toString().trim(),
									exceldiChi.toString().trim(),
									excelcanCuoc.toString().trim()
							});
							
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
				}
				
			}
		});
		
		btn_import.setIcon(new ImageIcon(getClass().getClassLoader().getResource("excel import.png")));
		btn_import.setBounds(1137, 17, 168, 40);
		btn_import.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		panel_4.add(btn_import);

		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnXoa.addActionListener(this);
		checkGioiTinh.addActionListener(this);
		comboLoc.addActionListener(this);
		btntaiLai.addActionListener(this);
		btnTim.addActionListener(this);
		btnLoc.addActionListener(this);
		btntaiLai.addActionListener(this);
		Doculieuvaotabel();
		table.addMouseListener(new MouseListener() {
				
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
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
		        	txtmaCN.setText(table.getValueAt(row, 0).toString());
		        	txthoTen.setText(table.getValueAt(row, 1).toString());
//		        	checkGioiTinh.setSelected( table.getValueAt(row, 2)?"Nam":"N???");
		        	Boolean sex=false;
		        	if(table.getValueAt(row, 2).equals("Nam"))
		        		sex=true;
		        	
		        	checkGioiTinh.setSelected( sex);
		        	txtSDT.setText(table.getValueAt(row, 3).toString());
		        	datePickerImpl.getJFormattedTextField().setText(table.getValueAt(row, 4).toString());
		        	txtDiaChi.setText(table.getValueAt(row, 5).toString());
		        	txtCanCuoc.setText(table.getValueAt(row, 6).toString());
		        }
				
			}
		});
	
	}
	//ki???m tra c?? t??m th???y nh??n vi??n hay kh??ng
		public static boolean isEmpty(JTable jTable) {
	        if (jTable != null && jTable.getModel() != null) {
	            return jTable.getModel().getRowCount()<=0?true:false;
	        }
	        return false;
	    }
	public void clearInput() {
		txtmaCN.setText("");
		txthoTen.setText("");
		checkGioiTinh.setSelected(false);
		datePickerImpl.getJFormattedTextField().setText("");
		txtSDT.setText("");
		txtDiaChi.setText("");
		txtmaCN.setEditable(false);
		txtCanCuoc.setText("");
	}
	public String taoMaCN() {
		int maSoHD = cn_dao.getAllCongNhan().size();	
		
		String result= "CN"+(maSoHD+1);
		return result;
	}
	public  void taoMa() {
		String ma ="CN";
		String maSoHD = cn_dao.getMaLonNhat().trim();
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
		
		txtmaCN.setText(ma+(a+1));
//		textFieldMaHD.setText("HDNV0"+(maSoHD+1));
		
	}
//	public  void taoMa() {
//		String ma ="CN";
//		String maSoHD = cn_dao.getMaLonNhat().trim();
//		int a = Integer.parseInt(maSoHD.substring(4));
//		
//		if(a>=1&&a<=8) {
//			ma += "000";
//		}
//		else if(a>=9&&a<=98) {
//			ma += "00";
//		}
//		else if(a>=99&&a>=998) {
//			ma += "0";
//		}
//		
//		txtmaCN.setText(ma+(a+1));
//	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object o = e.getSource();
		if(o.equals(btnThem)){
//			new GUI_ThongTinThemCongNhan().setVisible(true);
//			this.setVisible(false);
			try {
				taoMa(); 
				txtmaCN.setEditable(false);
				txthoTen.requestFocus(true);
				
				if(kiemtra2()) {
					String macn = txtmaCN.getText();
					String tencn = txthoTen.getText();
					Boolean phai = checkGioiTinh.isSelected() ;
					String sdt = txtSDT.getText();
					java.sql.Date ngaysinh = (java.sql.Date) datePickerImpl.getModel().getValue();
					String diaChi = txtDiaChi.getText();
					String cccd = txtCanCuoc.getText();
					CongNhanNew cn = new CongNhanNew(macn,tencn,phai,sdt,ngaysinh,diaChi,cccd);
					
					if(!cn_dao.getAllCongNhan().contains(cn)) {
						try {
							cn_dao.create(cn);
							tailai();
							JOptionPane.showMessageDialog(this, "Th??m th??nh C??ng!");
						} catch (Exception e2) {
							e2.printStackTrace();
						}	
				}else {
					JOptionPane.showMessageDialog(this, "Tr??ng M?? C??ng Nh??n!");
				}
				}
			}catch (Exception e1) {
				// TODO: handle exception
			}
		}
		if(o.equals(btnSua)) {
			try {
					int row = table.getSelectedRow();
					if(row>=0) {
						CongNhanNew cn = suakh();
						if(cn_dao.Updata(cn)) {
							table.setValueAt(txthoTen.getText(), row, 1);
							table.setValueAt(checkGioiTinh.isSelected()?"Nam":"N???", row, 2);
							table.setValueAt(txtSDT.getText(), row, 3);
							table.setValueAt(cn.getNgaySinh(), row, 4);
							table.setValueAt(txtDiaChi.getText(), row, 5);
							table.setValueAt(txtCanCuoc.getText(), row, 6);
							JOptionPane.showMessageDialog(this, "S???a th??ng tin th??nh c??ng!");
						}
				}else
					JOptionPane.showMessageDialog(this, "Ch?? ??: B???n ph???i ch???n Kh??ch H??ng c???n s???a. ");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		if(o.equals(btnXoa)) {
			
			int row = table.getSelectedRow();
			if(row != -1){
				int hoiNhac = JOptionPane.showConfirmDialog(this, "Ch???c ch???n x??a kh??ng? ", "Ch?? ??", JOptionPane.YES_NO_OPTION);
				if(hoiNhac == JOptionPane.YES_OPTION) {
					String macn = (String) table.getValueAt(row, 0);
					if(cn_dao.delete(macn)) {
						model.removeRow(row);
						txtmaCN.setText("");
						txthoTen.setText("");
						txtSDT.setText("");
						datePickerImpl.setVisible(true);
						txtDiaChi.setText("");
						txtCanCuoc.setText("");
						JOptionPane.showMessageDialog(this, "???? x??a 1 Kh??ch H??ng!");
						
					}
				}
			}
			if(row==-1) {
				JOptionPane.showMessageDialog(this, "Ch?? ??: B???n ph???i ch???n Kh??ch H??ng.");
			}
		}
			if(o.equals(btnXoaRong)) {
				clearInput();
					}
			if(o.equals(btnTim)) {
				String tim =  txtTim.getText().trim();
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
							}
						}
					}
				}
					catch (Exception e2) {
					e2.printStackTrace();
				}
				if (isEmpty(table)) {
					JOptionPane.showMessageDialog(null, "Kh??ng t??m th???y nh??n vi??n n??o");
					tim="rong";
					Doculieuvaotabel();
					txtTim.setText("");
					txtTim.requestFocus();
				}
			}
			if(o.equals(btnLoc)) {
				int option = comboLoc.getSelectedIndex();
				model.setRowCount(0);
				if(option==0) {
					Doculieuvaotabel();
				}
				if(option==1) {
					List<CongNhanNew> list = cn_dao.getCongNhanGT("1");
					if(list!=null) {
						for (CongNhanNew cn :list) {
							model.addRow(new Object[] {
									cn.getMaCN(),
									cn.getHoTen(),
									cn.isGioiTinh()?"Nam":"N???",
									cn.getsDT(),
									cn.getNgaySinh(),
									cn.getDiaChi(),
									cn.getcCCD()
							});			
						}
					}else {
						return;
					}
				}
				if(option==2) {
					List<CongNhanNew> list = cn_dao.getCongNhanGT("0");
					if(list!=null) {
						for (CongNhanNew cn :list) {
							model.addRow(new Object[] {
									cn.getMaCN(),
									cn.getHoTen(),
									cn.isGioiTinh()?"Nam":"N???",
									cn.getsDT(),
									cn.getNgaySinh(),
									cn.getDiaChi(),
									cn.getcCCD()
							});			
						}
					}else {
						return;
					}
				}
			}
			if(o.equals(btntaiLai)) {
				tailai();
				
			}
	}
	
	public void tailai() {
		DefaultTableModel defaultTableModel =  (DefaultTableModel) table.getModel();
		defaultTableModel.getDataVector().removeAllElements();
		defaultTableModel.fireTableDataChanged();
		Doculieuvaotabel();
	}
	
	public void Doculieuvaotabel(){
		List<CongNhanNew> list = cn_dao.getAllCongNhan();
		for (CongNhanNew cn :list) {
					model.addRow(new Object[] {
							cn.getMaCN().trim(),
							cn.getHoTen().trim(),
							cn.isGioiTinh()?"Nam":"N???",
							cn.getsDT().trim(),
							cn.getNgaySinh(),
							cn.getDiaChi().trim(),
							cn.getcCCD().trim()
					});			
		}
	}
	
	private CongNhanNew suakh()  {
		int row = table.getSelectedRow();
		try {
			
				String maKhachHang = txtmaCN.getText();
				String hoTen = txthoTen.getText();
				boolean gioiTinh = checkGioiTinh.isSelected();
				String sDT = txtSDT.getText();
				
				java.sql.Date ngaysinh = (java.sql.Date) datePickerImpl.getModel().getValue();
				if(ngaysinh==null){
					ngaysinh = (Date) table.getValueAt(row, 4);
				}
				String diaChi = txtDiaChi.getText();
				String canCuoc = txtCanCuoc.getText();
				if(kiemtra( hoTen, sDT, ngaysinh, diaChi,canCuoc)) {
					return new CongNhanNew(maKhachHang,hoTen,gioiTinh,sDT,ngaysinh,diaChi,canCuoc);
				}
				
		} catch (Exception e) {
			
		}
		return null;
	}

	
	//?????c D??? li???u v??o theo m??
		public void Doculieuvaotabel1(String ma){
			ArrayList<CongNhanNew> list = cn_dao.getCongNhanma(ma);
//				CongNhanNew cn = cn_dao.getCongNhanma(ma);
							if(list != null) {
								for(CongNhanNew cn:list)
								model.addRow(new Object[] {
										cn.getMaCN().trim(),
										cn.getHoTen().trim(),
										cn.isGioiTinh()?"Nam":"N???",
										cn.getsDT().trim(),
										cn.getNgaySinh(),
										cn.getDiaChi().trim(),
										cn.getcCCD().trim(),	
								});
							}else {
								return;
							}
			
		}
		//?????c D??? li???u v??o theo t??n
		public void Doculieuvaotabel2(String ten){
			
				ArrayList<CongNhanNew> list = cn_dao.getCongNhanTen(ten);
							if(list != null) {
								for (CongNhanNew nv2 :list) {		
									model.addRow(new Object[] {
											nv2.getMaCN().trim(),
											nv2.getHoTen().trim(),
											nv2.isGioiTinh()?"Nam":"N???",
											nv2.getsDT().trim(),
											nv2.getNgaySinh(),
											nv2.getDiaChi().trim(),
											nv2.getcCCD().trim()
									});			
								}
							}else {
									return;
							}
														
		}
				
							

		//?????c D??? li???u v??o theo sdt
		public void Doculieuvaotabel3(String sdt){
			
			ArrayList<CongNhanNew>  list = cn_dao.getCongNhansdt(sdt);
				if(list != null) {
					for(CongNhanNew cn3:list)
							model.addRow(new Object[] {
									cn3.getMaCN().trim(),
									cn3.getHoTen().trim(),
									cn3.isGioiTinh()?"Nam":"N???",
									cn3.getsDT().trim(),
									cn3.getNgaySinh(),
									cn3.getDiaChi().trim(),
									cn3.getcCCD().trim(),
		
							});
				}else {
					return;
				}
	}
		
		private boolean kiemtra2() {
			String hoten = txthoTen.getText().trim();
			String sdt =  txtSDT.getText().trim();
			String diachi =  txtDiaChi.getText().trim();
			Date ngaySinh = (Date) datePickerImpl.getModel().getValue();
			String cccd = txtCanCuoc.getText().trim();
			if(hoten.length()==0) {
				JOptionPane.showMessageDialog(this,"Ch?? ??: Nh???p t??n r???ng");
				txthoTen.requestFocus(true);
				return false;
			}
			else if (!hoten.matches("^[A??????????????????????????????????????????????BCD??E??????????????????????????????FGHI????????????JKLMNO??????????????????????????????????????????????PQRSTU?????????????????????????????VWXY??????????????Z][a??????????????????????????????????????????????bcd??e??????????????????????????????fghi????????????jklmno??????????????????????????????????????????????pqrstu?????????????????????????????vwxy??????????????z]+ [A??????????????????????????????????????????????BCD??E??????????????????????????????FGHI????????????JKLMNO??????????????????????????????????????????????PQRSTU?????????????????????????????VWXY??????????????Z][a??????????????????????????????????????????????bcd??e??????????????????????????????fghi????????????jklmno??????????????????????????????????????????????pqrstu?????????????????????????????vwxy??????????????z]+(?: [A??????????????????????????????????????????????BCD??E??????????????????????????????FGHI????????????JKLMNO??????????????????????????????????????????????PQRSTU?????????????????????????????VWXY??????????????Z][a??????????????????????????????????????????????bcd??e??????????????????????????????fghi????????????jklmno??????????????????????????????????????????????pqrstu?????????????????????????????vwxy??????????????z]*)*")) {
				JOptionPane.showMessageDialog(this,"Ch?? ??: Nh???p t??n sai c?? ph??p! (Ph???i nh???p k?? t??? kh??ng c?? d???u)");
				txthoTen.requestFocus(true);
				return false;
			}
			if (!(sdt.length() > 0 && sdt.matches("[0-9]{10}$"))) {
				JOptionPane.showMessageDialog(this,"Ch?? ??: Nh???p s??? ??i???n tho???i sai c?? ph??p!L?? s??? v?? 10 k?? t???!)");
				txtSDT.requestFocus(true);
				return false;
			}
			
			if(!(ngaySinh!=null)) {
				JOptionPane.showMessageDialog(this, "Ch?? ??: Ng??y Sinh kh??ng ???????c r???ng!");
				datePickerImpl.getJFormattedTextField().setText("");
				return false;
			}
			else if(new java.util.Date().getYear() - 18 <= ngaySinh.getYear()) {
				JOptionPane.showMessageDialog(this,"C??NG NH??N PH???I ????? 18 TU???I - NH???P L???I NG??Y SINH");
				return false;
			}
			if (!(diachi.length() > 0 && !diachi.matches("^([a-z]+)((\\s{1}[a-z]+){1,})$"))) {
				JOptionPane.showMessageDialog(this,"Ch?? ??: Nh???p ?????a ch??? sai c?? ph??p! (kh??ng ???????c nh???p k?? t??? ?????c bi???t!)");
				txtDiaChi.requestFocus(true);
				return false;
			}
			if ((cccd.length()==0)) {
				JOptionPane.showMessageDialog(this,"Ch?? ??: C??n c?????c ??ang tr???ng!)");
				txtCanCuoc.requestFocus(true);
				return false;
			}
			else if ( !(cccd.matches("[0-9]{12}$"))) {
				JOptionPane.showMessageDialog(this,"Ch?? ??: C??n c?????c ph???i ????? 12 s???!)");
				txtCanCuoc.requestFocus(true);
				return false;
			}
			
			return true;
		}
		private boolean kiemtra( String hoTen,String sdt,Date ngaySinh,String diachi,String cccd) {
			
			
			
			if(hoTen.length()==0) {
				JOptionPane.showMessageDialog(this,"Ch?? ??: Nh???p t??n r???ng");
				txthoTen.requestFocus(true);
				return false;
			}
			else if (!hoTen.matches("^[A??????????????????????????????????????????????BCD??E??????????????????????????????FGHI????????????JKLMNO??????????????????????????????????????????????PQRSTU?????????????????????????????VWXY??????????????Z][a??????????????????????????????????????????????bcd??e??????????????????????????????fghi????????????jklmno??????????????????????????????????????????????pqrstu?????????????????????????????vwxy??????????????z]+ [A??????????????????????????????????????????????BCD??E??????????????????????????????FGHI????????????JKLMNO??????????????????????????????????????????????PQRSTU?????????????????????????????VWXY??????????????Z][a??????????????????????????????????????????????bcd??e??????????????????????????????fghi????????????jklmno??????????????????????????????????????????????pqrstu?????????????????????????????vwxy??????????????z]+(?: [A??????????????????????????????????????????????BCD??E??????????????????????????????FGHI????????????JKLMNO??????????????????????????????????????????????PQRSTU?????????????????????????????VWXY??????????????Z][a??????????????????????????????????????????????bcd??e??????????????????????????????fghi????????????jklmno??????????????????????????????????????????????pqrstu?????????????????????????????vwxy??????????????z]*)*")) {
				JOptionPane.showMessageDialog(this,"Ch?? ??: Nh???p t??n sai c?? ph??p! (Ph???i nh???p k?? t??? kh??ng c?? d???u)");
				txthoTen.requestFocus(true);
				return false;
			}
			if (!(sdt.length() > 0 && sdt.matches("[0-9]{10}$"))) {
				JOptionPane.showMessageDialog(this,"Ch?? ??: Nh???p s??? ??i???n tho???i sai c?? ph??p!L?? s??? v?? 10 k?? t???!)");
				txtSDT.requestFocus(true);
				return false;
			}
			
			if(!(ngaySinh!=null)) {
				JOptionPane.showMessageDialog(this, "Ch?? ??: Ng??y Sinh kh??ng ???????c r???ng!");
				datePickerImpl.getJFormattedTextField().setText("");
				return false;
			}
			else if(new java.util.Date().getYear() - 18 <= ngaySinh.getYear()) {
				JOptionPane.showMessageDialog(this,"C??NG NH??N PH???I ????? 18 TU???I - NH???P L???I NG??Y SINH");
				return false;
			}
			if (!(diachi.length() > 0 && !diachi.matches("^([a-z]+)((\\s{1}[a-z]+){1,})$"))) {
				JOptionPane.showMessageDialog(this,"Ch?? ??: Nh???p ?????a ch??? sai c?? ph??p! (kh??ng ???????c nh???p k?? t??? ?????c bi???t!)");
				txtDiaChi.requestFocus(true);
				return false;
			}
			if ((cccd.length()==0)) {
				JOptionPane.showMessageDialog(this,"Ch?? ??: C??n c?????c ??ang tr???ng!)");
				txtCanCuoc.requestFocus(true);
				return false;
			}
			else if ( !(cccd.matches("[0-9]{12}$"))) {
				JOptionPane.showMessageDialog(this,"Ch?? ??: C??n c?????c ph???i ????? 12 s???!)");
				txtCanCuoc.requestFocus(true);
				return false;
			}
			return true;
		}
}
