package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import connectDB.ConnectDB;
import dao.DAO_PhieuLuongCongNhan1;
import entity.CongNhanNew;

import entity.PhanCongnew;
import entity.PhieuLuongCongNhan1;

import entity.TangCa1;


public class GUI_QuanLyLuongCongNhan1 extends JFrame implements ActionListener, MouseListener {
	TangCa1 tangca= new TangCa1("a","a",2,200000);
	DefaultTableModel model_CongNhan, model_PhieuLuongCN;
	JTable table_CongNhan, table_PhieuLuongCN;
	JButton btnTinhLuong,btnXuatFile;
	JLabel lbl_soSPHC,lbl_soSPTC,lbl_tienUng,lbl_thang,lbl_nam;
	JTextField txt_soSPHC, txt_soSPTC,txt_tienUng,txt_nam,txt_thang;
	JComboBox cb1_thang;
	String thang[]= {"1","2","3","4","5","6","7","8","9","10","11","12"};
	DAO_PhieuLuongCongNhan1 dao_PhieuLuongCongNhan1;
	
	public GUI_QuanLyLuongCongNhan1()
	{
		setSize(1360,650);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		// tiêu đề
		JPanel panel_tieude = new JPanel();
		panel_tieude.setBackground(new Color(220, 220, 220));
		panel_tieude.setBounds(0, 0,1360, 50);
		getContentPane().add(panel_tieude);
		panel_tieude.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản lý lương công nhân");
		lblNewLabel.setForeground(new Color(0,0,0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(5, 10, 500, 30);
		panel_tieude.add(lblNewLabel);
		
		// bảng nhân viên
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBounds(0,55,1360,295);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
				
		JLabel lblNewLabel_1 = new JLabel("Công Nhân");
		lblNewLabel_1.setForeground(new Color(0,0,0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(5, 5, 500, 30);
		panel_1.add(lblNewLabel_1);
		
		String[] head_CongNhan= {"Mã công nhân","Tên công nhân","Giới tính","sdt","Mã phân công","Đơn giá"};
		model_CongNhan=new DefaultTableModel(head_CongNhan,0);
		table_CongNhan=new JTable(model_CongNhan);
		JScrollPane scrollPane_CongNhan=new JScrollPane(table_CongNhan);
		scrollPane_CongNhan.setBounds(5,75,800,200);
	    panel_1.add(scrollPane_CongNhan);
	    
	  //số ngày sản phẩm hành chính(hoàn thành)
	    txt_soSPHC= new JTextField();
	    txt_soSPHC.setEditable(false);
	    txt_soSPHC.setForeground(Color.BLUE);
	    txt_soSPHC.setFont(new Font("Times New Roman", Font.BOLD, 20));
	    txt_soSPHC.setBounds(940,75,100,30);
		panel_1.add(txt_soSPHC);
		txt_soSPHC.setColumns(10);
		
		lbl_soSPHC= new JLabel("Số SPHC:");
		lbl_soSPHC.setBounds(810,75,130,30);
		panel_1.add(lbl_soSPHC);
		lbl_soSPHC.setFont(new Font("Times New Roman", Font.BOLD, 20));
	    //số sản phẩm tăng ca
		txt_soSPTC = new JTextField();
		txt_soSPTC.setEditable(false);
		txt_soSPTC.setForeground(Color.BLUE);
		txt_soSPTC.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txt_soSPTC.setBounds(1220,75,100,30);
		panel_1.add(txt_soSPTC);
		txt_soSPTC.setColumns(10);
		
		lbl_soSPTC= new JLabel("Số SPTC:");
		lbl_soSPTC.setBounds(1090,75,180,30);
		panel_1.add(lbl_soSPTC);
		lbl_soSPTC.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		
		//năm
		lbl_nam = new JLabel("Năm:");
		lbl_nam.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lbl_nam.setBounds(1090,120,180,30);
		panel_1.add(lbl_nam);
		txt_nam = new JTextField();
		txt_nam.setBounds(1220,120,100,30 );
		panel_1.add(txt_nam);
		txt_nam.setColumns(10);
				
		// tháng
		lbl_thang=new JLabel("Tháng");
		lbl_thang.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lbl_thang.setBounds(810,120,180,30);
		panel_1.add(lbl_thang);
				
		cb1_thang=new JComboBox(thang);
		cb1_thang.setFont(new Font("Times New Roman", Font.BOLD, 17));
		cb1_thang.setBounds(940,120,100,30);
		panel_1.add(cb1_thang);
				
		//tiền ứng
		lbl_tienUng = new JLabel("Tiền ứng:");
		lbl_tienUng.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lbl_tienUng.setBounds(810,165,180,30);
		panel_1.add(lbl_tienUng);
		txt_tienUng = new JTextField();
		txt_tienUng.setBounds(940,165,100,30 );
		panel_1.add(txt_tienUng);
		txt_tienUng.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(220, 220, 220));
		panel_2.setBounds(0,355, 1360,295);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Phiếu lương");
		lblNewLabel_2.setForeground(new Color(0,0,0));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(5, 5, 500, 30);
		panel_2.add(lblNewLabel_2);
		
		String[] head_phieuluong= {"Mã CN","Tên CN","Thành Tiền","Thực Lãnh","Tiền Ứng","Tháng lương","Năm Lương","Số SPHC","Số SPTC"};
		model_PhieuLuongCN=new DefaultTableModel(head_phieuluong, 0);
		table_PhieuLuongCN=new JTable(model_PhieuLuongCN);
		JScrollPane scrollPane_phieuluong = new JScrollPane(table_PhieuLuongCN);
		scrollPane_phieuluong.setBounds(5, 40,1360 ,175 );
		panel_2.add(scrollPane_phieuluong);
		
		btnTinhLuong=new JButton("Tính lương");
		btnTinhLuong.setBounds(630,220,100,30);
		panel_2.add(btnTinhLuong);
		
		btnXuatFile=new JButton("Xuất file");
		btnXuatFile.setBounds(750,220,100,30);
		panel_2.add(btnXuatFile);
	    
		dao_PhieuLuongCongNhan1=new DAO_PhieuLuongCongNhan1();
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table_CongNhan.addMouseListener(this);
		btnTinhLuong.addActionListener(this);
		btnXuatFile.addActionListener(this);
		DocDuLieuVaoTableCN();
		DocDuLieuVaoTablePL();

	}
	// đọc dữ liệu và bảng công nhân
	public void DocDuLieuVaoTableCN()
	{   
		List<PhanCongnew> ds=dao_PhieuLuongCongNhan1.getAllPC_CN();
		for (PhanCongnew pc : ds) {
			model_CongNhan.addRow(new Object[] {
				pc.getCn().getMaCN(),pc.getCn().getHoTen(),pc.getCn().isGioiTinh()? "Nam" : "Nu",pc.getCn().getsDT(),pc.getMaPC(),pc.getDonGia()	
					});
		}
	}
	
	//lấy số sản phẩm tăng ca về text field
	public void getSoSanPhamTangCa()
	{
		int nam=Integer.parseInt(txt_nam.getText().toString());
		int thang=Integer.parseInt(cb1_thang.getSelectedItem().toString());
    	//String c="a";
    	
    	//String e="2022";
		int row_all=table_CongNhan.getSelectedRow();
		String maCN=model_CongNhan.getValueAt(row_all, 0).toString();
				
		String kgString1="SELECT SUM(soSPTC) FROM tb_CHAMCONGCN1 WHERE ngayCC BETWEEN '"+nam+"-"+thang+"-01 00:00:00' AND '"+nam+"-"+thang+"-30 23:59:59' and diemDanh=1 and maCN='"+maCN+"'";
    	
    	
    	int soSanPhamTangCa;
    	soSanPhamTangCa=dao_PhieuLuongCongNhan1.getSoSanPhamTangCa(kgString1);
    	
    	txt_soSPTC.setText(Integer.toString(soSanPhamTangCa));
	}
	//lấy số sản phẩm hành chính về text field
	public void getSoSanPhamHanhChinh()
	{
		int nam=Integer.parseInt(txt_nam.getText().toString());
		int thang=Integer.parseInt(cb1_thang.getSelectedItem().toString());
    	//String c="a";
    	
    	//String e="2022";
		int row_all=table_CongNhan.getSelectedRow();
		String maCN=model_CongNhan.getValueAt(row_all, 0).toString();
				
		String kgString1="SELECT SUM(soSPHC) FROM tb_CHAMCONGCN1 WHERE ngayCC BETWEEN '"+nam+"-"+thang+"-01 00:00:00' AND '"+nam+"-"+thang+"-30 23:59:59' and diemDanh=1 and maCN='"+maCN+"'";
    	
    	
    	int soSanPhamHanhChinh;
    	soSanPhamHanhChinh=dao_PhieuLuongCongNhan1.getSoSanPhamHanhChinh(kgString1);
    	
    	txt_soSPHC.setText(Integer.toString(soSanPhamHanhChinh));
	}
	
	
	//tính lương
	// lương=số lượng sản phẩm(HT)*dongiaPC+soLuongTC*dongiaTC-tienung
			public float tinhLuong_thanhtien()
			{
				int row_all=table_CongNhan.getSelectedRow();
				float dongiaPC=Float.parseFloat(model_CongNhan.getValueAt(row_all, 5).toString());
				int soluongSPHT=Integer.parseInt(txt_soSPHC.getText().toString());
				int soLuongSPTC=Integer.parseInt(txt_soSPTC.getText().toString());
				float tienUng=Float.parseFloat(txt_tienUng.getText().toString());
				
				float tienung=Float.parseFloat(txt_tienUng.getText().toString());
				float dongiaTC=tangca.getDonGia();
				float hesoluongTC=tangca.getHeSoLuong();
				
				float thanhtien  = soluongSPHT*dongiaPC+soLuongSPTC*dongiaTC*hesoluongTC-tienUng;
				
				return thanhtien;
				
			}
			
			//thực lãnh
			public float tinhLuong_thuclanh()
			{
				float thucLanh = 0;
			    
			    float thanhtien=tinhLuong_thanhtien();
			    
			    thucLanh=thanhtien-(thanhtien/100)*10;
				
				return thucLanh;
			}
			
			
			// đọc dữ liệu vào table sau khi tính lương 
			public void docDuLieuVaoTablePLLAN2()
			{   
				int nam=Integer.parseInt(txt_nam.getText().toString());
			    int thang=Integer.parseInt(cb1_thang.getSelectedItem().toString());
				int row_all=table_CongNhan.getSelectedRow();
			    String maCN=model_CongNhan.getValueAt(row_all, 0).toString(); 
			    String tenCN=model_CongNhan.getValueAt(row_all, 1).toString(); 
			    float tienung=Float.parseFloat(txt_tienUng.getText().toString());
			    int soSPHC=Integer.parseInt(txt_soSPHC.getText().toString());
			    int soSPTC=Integer.parseInt(txt_soSPTC.getText().toString());
				model_PhieuLuongCN.addRow(new Object[] {
						maCN,tenCN,tinhLuong_thanhtien(),tinhLuong_thuclanh(),tienung,thang,nam,soSPHC,soSPTC
							});
			}
			
			public  String taoMa() {
				String ma ="PLCN";
				String maSoHD = dao_PhieuLuongCongNhan1.getMaLonNhat().trim();
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
				
				return ma+(a+1);
				
				//textFieldMaHD.setText(ma+(a+1));
			}
			
			// thêm vào data
			public void themPLvaoDATA()
			{   String maPLCN=taoMa();
				int nam=Integer.parseInt(txt_nam.getText().toString());
			    int thang=Integer.parseInt(cb1_thang.getSelectedItem().toString()); 
				int row_all=table_CongNhan.getSelectedRow(); 
				String maCN=model_CongNhan.getValueAt(row_all, 0).toString().trim();
				CongNhanNew cn=new CongNhanNew(maCN);
			    float tienung=Float.parseFloat(txt_tienUng.getText().toString());
			    int soSPHC=Integer.parseInt(txt_soSPHC.getText().toString());
			    int soSPTC=Integer.parseInt(txt_soSPTC.getText().toString());
			    PhieuLuongCongNhan1 plcn1=new PhieuLuongCongNhan1(maPLCN,tinhLuong_thanhtien(),cn,tinhLuong_thuclanh(),tienung,soSPHC,soSPTC,null,thang,nam);
			    ArrayList<PhieuLuongCongNhan1> list;
			    dao_PhieuLuongCongNhan1.themPLCN(plcn1);
			}
	
	
	  private void xoaHetDuLieuTrenTableModel() {
			DefaultTableModel dm = (DefaultTableModel) table_PhieuLuongCN.getModel();
			dm.getDataVector().removeAllElements();
			dm.fireTableDataChanged();

		}
	  
	  
	 // đọc all dữ liệu phiếu lương công nhân 
	  public void DocDuLieuVaoTablePL()
		{
			List<PhieuLuongCongNhan1> dsPL=dao_PhieuLuongCongNhan1.getAllPhieuLuongCongNhan();
			for (PhieuLuongCongNhan1 phieuLuongCN : dsPL) {
				model_PhieuLuongCN.addRow(new Object[] {
					phieuLuongCN.getCn().getMaCN(),phieuLuongCN.getCn().getHoTen(),phieuLuongCN.getThanhTien(),phieuLuongCN.getThucLanh(),phieuLuongCN.getTienUng(),phieuLuongCN.getThangLuong(),phieuLuongCN.getNamLuong(),phieuLuongCN.getTongSPHC(),phieuLuongCN.getTongSPTC()	
						});
			}
		}
	  
	  
	  //xuất file
	  public void xuatfile() {
			ArrayList<PhieuLuongCongNhan1> arr =dao_PhieuLuongCongNhan1.getAllPhieuLuongCongNhan();
			try {
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet sheet = workbook.createSheet("BangLuong");
				XSSFRow row=null;
				Cell cell= null;
				row=sheet.createRow(3);
				
				cell=row.createCell(0,CellType.STRING);
				cell.setCellValue("Mã PLCN");
		
				cell=row.createCell(1,CellType.STRING);
				cell.setCellValue("Thành Tiền");
				
				cell=row.createCell(2,CellType.STRING);
				cell.setCellValue("Mã Công Nhan");
				
				cell=row.createCell(3,CellType.BOOLEAN);
				cell.setCellValue("Thực Lãnh");
				
				cell=row.createCell(4,CellType.STRING);
				cell.setCellValue("Tiền ứng");
				
				cell=row.createCell(5,CellType.STRING);
				cell.setCellValue("Số SPHC");
				
				cell=row.createCell(6,CellType.STRING);
				cell.setCellValue("Số SPTC");
				
				cell=row.createCell(7,CellType.STRING);
				cell.setCellValue("Mã người chấm");
				
				cell=row.createCell(8,CellType.STRING);
				cell.setCellValue("Tháng lương");
				
				cell=row.createCell(9,CellType.STRING);
				cell.setCellValue("Năm lương");
				
				
				for(int i=0;i<arr.size();i++) {
					row=sheet.createRow(i+8);
					
					cell = row.createCell(0,CellType.STRING);
					cell.setCellValue(arr.get(i).getMaPLCN());
					
					cell = row.createCell(1,CellType.STRING);
					cell.setCellValue(arr.get(i).getThanhTien());
					
					cell = row.createCell(2,CellType.STRING);
					cell.setCellValue(arr.get(i).getCn().getMaCN());
					
					cell = row.createCell(3,CellType.BOOLEAN);
					cell.setCellValue(arr.get(i).getThucLanh());
					
					cell = row.createCell(4,CellType.STRING);
					cell.setCellValue(arr.get(i).getTienUng());
					
					cell = row.createCell(5,CellType.STRING);
					cell.setCellValue(arr.get(i).getTongSPHC());
					
					cell = row.createCell(6,CellType.STRING);
					cell.setCellValue(arr.get(i).getTongSPTC());
					
					cell = row.createCell(7,CellType.STRING);
					cell.setCellValue(arr.get(i).getMaNguoiCham());
					
					cell = row.createCell(8,CellType.STRING);
					cell.setCellValue(arr.get(i).getThangLuong());
					
					cell = row.createCell(9,CellType.STRING);
					cell.setCellValue(arr.get(i).getNamLuong());
					
					
					
					
					
				}
				File f= new File("C:\\New folder\\BangLuongCN.xlsx");
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
//	public static void main(String[] args)
//	{
//		new GUI_QuanLyLuongCongNhan1().setVisible(true);
//	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row_all = table_CongNhan.getSelectedRow();
		if(row_all==-1) {
			JOptionPane.showMessageDialog(this, "Hãy chọn công nhân ") ;
		}
		else {
			getSoSanPhamTangCa();
			getSoSanPhamHanhChinh();
			
			

		
		}
		// TODO Auto-generated method stub
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnTinhLuong)) {
			int row_all = table_CongNhan.getSelectedRow();
			if(row_all==-1) {
				JOptionPane.showMessageDialog(this, "Hãy chọn công nhân muốn tính lương ") ;
			}
			else {
			docDuLieuVaoTablePLLAN2();
			themPLvaoDATA();
			xoaHetDuLieuTrenTableModel();
			DocDuLieuVaoTablePL();
			
			
			}
		}
		if(o.equals(btnXuatFile))
		{
			xuatfile();
		}
		
	}

}
