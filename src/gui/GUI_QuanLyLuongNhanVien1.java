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
import dao.DAO_PhieuLuongNhanVien1;
import entity.HopDongNV;
import entity.NhanVienNew;
import entity.PhieuLuongNVnew;
import entity.PhieuLuongNhanVien1;
import entity.TangCa1;

public class GUI_QuanLyLuongNhanVien1  extends JFrame implements ActionListener, MouseListener {
	TangCa1 tangca= new TangCa1("a","a",2,200000);
	DefaultTableModel model_NhanVien, model_PhieuLuong;
	JTable table_NhanVien,table_PhieuLuong;
	JButton btnTinhLuong;
	JComboBox cb1_thang;
	DAO_PhieuLuongNhanVien1 dao_PhieuLuongNhanVien1;
	String thang[]= {"1","2","3","4","5","6","7","8","9","10","11","12"};
	JLabel lbl_soNgayLam,lbl_soGioTangCa,lbl_tienUng,lbl_thang,lbl_nam;
	JTextField txt_soNgayLam,txt_soGioTangCa,txt_tienUng,txt_thang,txt_nam;
	JButton btnXuatFile;
	public GUI_QuanLyLuongNhanVien1()
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
		
		JLabel lblNewLabel = new JLabel("Quản lý lương nhân viên");
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
		
		JLabel lblNewLabel_1 = new JLabel("Nhân viên");
		lblNewLabel_1.setForeground(new Color(0,0,0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(5, 5, 500, 30);
		panel_1.add(lblNewLabel_1);
		
		String[] head_NhanVien= {"Mã Nhân Viên","Họ tên","Giới Tính","SDT","Hệ số lương","Lương cơ bản"};
		model_NhanVien=new DefaultTableModel(head_NhanVien,0);
		table_NhanVien=new JTable(model_NhanVien);
		JScrollPane scrollPane_NhanVien=new JScrollPane(table_NhanVien);
		scrollPane_NhanVien.setBounds(5,75,800,200);
	    panel_1.add(scrollPane_NhanVien);
	    //số ngày làm
	    txt_soNgayLam = new JTextField();
	    txt_soNgayLam.setEditable(false);
	    txt_soNgayLam.setForeground(Color.BLUE);
	    txt_soNgayLam.setFont(new Font("Times New Roman", Font.BOLD, 20));
	    txt_soNgayLam.setBounds(940,75,100,30);
		panel_1.add(txt_soNgayLam);
		txt_soNgayLam.setColumns(10);
		
		lbl_soNgayLam= new JLabel("Số ngày làm:");
		lbl_soNgayLam.setBounds(810,75,130,30);
		panel_1.add(lbl_soNgayLam);
		lbl_soNgayLam.setFont(new Font("Times New Roman", Font.BOLD, 20));
		//số giờ tăng ca
		txt_soGioTangCa = new JTextField();
		txt_soGioTangCa.setEditable(false);
		txt_soGioTangCa.setForeground(Color.BLUE);
		txt_soGioTangCa.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txt_soGioTangCa.setBounds(1220,75,100,30);
		panel_1.add(txt_soGioTangCa);
		txt_soGioTangCa.setColumns(10);
		
		lbl_soGioTangCa= new JLabel("Số giờ tăng ca:");
		lbl_soGioTangCa.setBounds(1090,75,180,30);
		panel_1.add(lbl_soGioTangCa);
		lbl_soGioTangCa.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
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
		
		String[] head_phieuluong= {"Mã NV","Tên NV","Thành Tiền","Thực Lãnh","Tiền Ứng","Tháng lương","Năm Lương","Số Ngày Làm","Số giờ tăng ca"};
		model_PhieuLuong=new DefaultTableModel(head_phieuluong, 0);
		table_PhieuLuong=new JTable(model_PhieuLuong);
		JScrollPane scrollPane_phieuluong = new JScrollPane(table_PhieuLuong);
		scrollPane_phieuluong.setBounds(5, 40,1360 ,175 );
		panel_2.add(scrollPane_phieuluong);
		
		
		
		
		btnTinhLuong=new JButton("Tính lương");
		btnTinhLuong.setBounds(630,220,100,30);
		panel_2.add(btnTinhLuong);
		
		btnXuatFile=new JButton("Xuất file");
		btnXuatFile.setBounds(750,220,100,30);
		panel_2.add(btnXuatFile);
		
		
		
		
		dao_PhieuLuongNhanVien1=new DAO_PhieuLuongNhanVien1();
		
		
		
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DocDuLieuVaoTablePL();
		DocDuLieuVaoTableNV();
		
		btnTinhLuong.addActionListener(this);
		btnXuatFile.addActionListener(this);
		table_NhanVien.addMouseListener(this);
		
		
	}
	
	
	
//	public static void main(String[] args)
//	{
//		new GUI_QuanLyLuongNhanVien1().setVisible(true);
//		
//	}
	
	
	
	//đọc tất cả dữ liệu vào bảng phiếu lương
		public void DocDuLieuVaoTablePL()
		{
			List<PhieuLuongNhanVien1> dsPL=dao_PhieuLuongNhanVien1.getAllPhieuLuongNhanVien();
			for (PhieuLuongNhanVien1 phieuLuongNV1 : dsPL) {
				model_PhieuLuong.addRow(new Object[] {
					phieuLuongNV1.getNv().getMaNV(),phieuLuongNV1.getNv().getHoTen(),phieuLuongNV1.getThanhTien(),phieuLuongNV1.getThucLanh(),phieuLuongNV1.getTienUng(),phieuLuongNV1.getThangLuong(),phieuLuongNV1.getNamLuong(),phieuLuongNV1.getSoNgayLam(),phieuLuongNV1.getSoGioTangCa()	
						});
			}
		}
		
		// đọc tất cả dữ liệu và bảng nhân viên+hợp đồng
		public void DocDuLieuVaoTableNV()
		{   
			List<HopDongNV> ds=dao_PhieuLuongNhanVien1.getAllHD_NV();
			for (HopDongNV hd : ds) {
				model_NhanVien.addRow(new Object[] {
					hd.getCn().getMaNV(),hd.getCn().getHoTen(),hd.getCn().isGioiTinh()? "Nam" : "Nu",hd.getCn().getsDT(),hd.getHeSoLuong(),hd.getLuongCoBan()	
						});
			}
		}
		
		
		// lấy số ngày làm trả về text field
		public void getSoNgayLam()
		{
			int nam=Integer.parseInt(txt_nam.getText().toString());
			int thang=Integer.parseInt(cb1_thang.getSelectedItem().toString());
	    	//String c="a";
	    	
	    	//String e="2022";
			int row_all=table_NhanVien.getSelectedRow();
			String maNV=model_NhanVien.getValueAt(row_all, 0).toString();
					
	    	String kgString="select COUNT(*) from tb_CHAMCONGNV1 where ngayCC BETWEEN '"+nam+"-"+thang+"-01 00:00:00' AND '"+nam+"-"+thang+"-30 23:59:59' and diemDanh=1 and maNV='"+maNV+"'";
	    	
	    	
	    	int soNgayLam;
	    	soNgayLam=dao_PhieuLuongNhanVien1.getSoNgayLam(kgString);
	    	
	    	txt_soNgayLam.setText(Integer.toString(soNgayLam));
		}
		
		//lấy số giờ tăng  ca trả về text field
		public void getSoGioTangCa()
		{   int nam=Integer.parseInt(txt_nam.getText().toString());
		    int thang=Integer.parseInt(cb1_thang.getSelectedItem().toString());
		    
			int row_all=table_NhanVien.getSelectedRow();
			String maNV=model_NhanVien.getValueAt(row_all, 0).toString();
					
	    	String kgString1="SELECT SUM(soGioTC) FROM tb_CHAMCONGNV1 WHERE ngayCC BETWEEN '"+nam+"-"+thang+"-01 00:00:00' AND '"+nam+"-"+thang+"-30 23:59:59' and diemDanh=1 and maNV='"+maNV+"'";
	    	
	    	
	    	int soGioTangCa;
	    	soGioTangCa=dao_PhieuLuongNhanVien1.getSoGioTangCa(kgString1);
	    	
	    	txt_soGioTangCa.setText(Integer.toString(soGioTangCa));
		}
		
		
		//tính lương
		// Lương = lương cơ bản /28 * số ngày làm*hệ số lương + số giờ tăng ca * lương cơ bản của bảng tăng ca*hệ số lương tăng ca - tiền ứng
		public float tinhLuong_thanhtien()
		{
			int row_all=table_NhanVien.getSelectedRow();
			float luongCoBan = Float.parseFloat(model_NhanVien.getValueAt(row_all, 5).toString());
			int songaylam=Integer.parseInt(txt_soNgayLam.getText().toString());
			float hesoluong = Float.parseFloat(model_NhanVien.getValueAt(row_all, 4).toString());
			int sogiotangca=Integer.parseInt(txt_soGioTangCa.getText().toString());
			float tienung=Float.parseFloat(txt_tienUng.getText().toString());
			float luongcobantangca=tangca.getDonGia();
			float hesoluongtangca=tangca.getHeSoLuong();
			
			float thanhtien  = (luongCoBan/28)*songaylam*hesoluong+sogiotangca*luongcobantangca*hesoluongtangca-tienung;
			
			return thanhtien;
			
		}
		
		public float tinhluong_thucLanh()
		{   float thucLanh = 0;
		    
		    float thanhtien=tinhLuong_thanhtien();
		    
		    thucLanh=thanhtien-(thanhtien/100)*10;
			
			return thucLanh;
		}
		
		// đọc dữ liệu vào table sau khi tính lương 
		public void docDuLieuVaoTablePLLAN2()
		{   
			int nam=Integer.parseInt(txt_nam.getText().toString());
		    int thang=Integer.parseInt(cb1_thang.getSelectedItem().toString());
			int row_all=table_NhanVien.getSelectedRow();
		    String maNV=model_NhanVien.getValueAt(row_all, 0).toString(); 
		    String tenNV=model_NhanVien.getValueAt(row_all, 1).toString(); 
		    float tienung=Float.parseFloat(txt_tienUng.getText().toString());
		    int songaylam=Integer.parseInt(txt_soNgayLam.getText().toString());
		    int sogiotangca=Integer.parseInt(txt_soGioTangCa.getText().toString());
			model_PhieuLuong.addRow(new Object[] {
					maNV,tenNV,tinhLuong_thanhtien(),tinhluong_thucLanh(),tienung,thang,nam,songaylam,sogiotangca
						});
		}
		
		
		
		//tạo mã
		public  String taoMa() {
			String ma ="PLNV";
			String maSoHD = dao_PhieuLuongNhanVien1.getMaLonNhat().trim();
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
		
		public void themPLvaoDATA()
		{   String maPLNV=taoMa();
			int nam=Integer.parseInt(txt_nam.getText().toString());
		    int thang=Integer.parseInt(cb1_thang.getSelectedItem().toString()); 
			int row_all=table_NhanVien.getSelectedRow(); 
			String maNV=model_NhanVien.getValueAt(row_all, 0).toString().trim();
			NhanVienNew nv=new NhanVienNew(maNV);
		    float tienung=Float.parseFloat(txt_tienUng.getText().toString());
		    int songaylam=Integer.parseInt(txt_soNgayLam.getText().toString());
		    int sogiotangca=Integer.parseInt(txt_soGioTangCa.getText().toString());
		    PhieuLuongNhanVien1 plnv1=new PhieuLuongNhanVien1(maPLNV,tinhLuong_thanhtien(),nv,tinhluong_thucLanh(),tienung,songaylam,sogiotangca,null,thang,nam);
		    ArrayList<PhieuLuongNhanVien1> list;
		    dao_PhieuLuongNhanVien1.themPLNV(plnv1);
		}
		
		private void xoaHetDuLieuTrenTableModel() {
			DefaultTableModel dm = (DefaultTableModel) table_PhieuLuong.getModel();
			dm.getDataVector().removeAllElements();
			dm.fireTableDataChanged();

	}
		
		
		//xuất file
		public void xuatfile() {
			ArrayList<PhieuLuongNhanVien1> arr =dao_PhieuLuongNhanVien1.getAllPhieuLuongNhanVien();
			try {
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet sheet = workbook.createSheet("BangLuong");
				XSSFRow row=null;
				Cell cell= null;
				row=sheet.createRow(3);
				
				cell=row.createCell(0,CellType.STRING);
				cell.setCellValue("Mã PLNV");
		
				cell=row.createCell(1,CellType.STRING);
				cell.setCellValue("Thành Tiền");
				
				cell=row.createCell(2,CellType.STRING);
				cell.setCellValue("Mã Nhân Viên");
				
				cell=row.createCell(3,CellType.BOOLEAN);
				cell.setCellValue("Thực Lãnh");
				
				cell=row.createCell(4,CellType.STRING);
				cell.setCellValue("Tiền ứng");
				
				cell=row.createCell(5,CellType.STRING);
				cell.setCellValue("Số ngày làm");
				
				cell=row.createCell(6,CellType.STRING);
				cell.setCellValue("Số giờ tăng ca");
				
				cell=row.createCell(7,CellType.STRING);
				cell.setCellValue("Mã người chấm");
				
				cell=row.createCell(8,CellType.STRING);
				cell.setCellValue("Tháng lương");
				
				cell=row.createCell(9,CellType.STRING);
				cell.setCellValue("Năm lương");
				
				
				for(int i=0;i<arr.size();i++) {
					row=sheet.createRow(i+8);
					
					cell = row.createCell(0,CellType.STRING);
					cell.setCellValue(arr.get(i).getMaPLNV());
					
					cell = row.createCell(1,CellType.STRING);
					cell.setCellValue(arr.get(i).getThanhTien());
					
					cell = row.createCell(2,CellType.STRING);
					cell.setCellValue(arr.get(i).getNv().getMaNV());
					
					cell = row.createCell(3,CellType.BOOLEAN);
					cell.setCellValue(arr.get(i).getThucLanh());
					
					cell = row.createCell(4,CellType.STRING);
					cell.setCellValue(arr.get(i).getTienUng());
					
					cell = row.createCell(5,CellType.STRING);
					cell.setCellValue(arr.get(i).getSoNgayLam());
					
					cell = row.createCell(6,CellType.STRING);
					cell.setCellValue(arr.get(i).getSoGioTangCa());
					
					cell = row.createCell(7,CellType.STRING);
					cell.setCellValue(arr.get(i).getMaNguoiCham());
					
					cell = row.createCell(8,CellType.STRING);
					cell.setCellValue(arr.get(i).getThangLuong());
					
					cell = row.createCell(9,CellType.STRING);
					cell.setCellValue(arr.get(i).getNamLuong());
					
					
					
					
					
				}
				File f= new File("C:\\New folder\\BangLuongNV.xlsx");
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
	public void mouseClicked(MouseEvent e) {
		
			int row_all = table_NhanVien.getSelectedRow();
			if(row_all==-1) {
				JOptionPane.showMessageDialog(this, "Hãy chọn nhân viên ") ;
			}
			else {
				getSoNgayLam();
				getSoGioTangCa();

			
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
		
		Object o = e.getSource();
		// TODO Auto-generated method stub
		
		if(o.equals(btnTinhLuong)) {
			int row_all = table_NhanVien.getSelectedRow();
			if(row_all==-1) {
				JOptionPane.showMessageDialog(this, "Hãy chọn nhân viên muốn tính lương ") ;
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
