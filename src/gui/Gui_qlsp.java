package gui;
// bỏ hình ảnh thêm ghi chhú
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;

import dao.DAO_SanPham;
import entity.LoaiSanPham;
import entity.SanPham;

public class Gui_qlsp extends JFrame implements ActionListener, MouseListener {
	DefaultTableModel model;
	JTable table;
	
	JTextField txtMa,txtTen,txtMoTa,txtTimKiem;
	JTextField txtGhiChu;
	JButton btnThem,btnSua,btnXoa,btnTimKiem,btnXoaRong,btnTaiLai;
	private DAO_SanPham dao_SanPham;
	public Gui_qlsp()
	{
		setSize(1360,680);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220,220, 220));
		panel_1.setBounds(0,0,1360 ,670);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản lý sản phẩm");
		lblNewLabel.setForeground(new Color(0,0,0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(630, 5, 300, 30);
		panel_1.add(lblNewLabel);
		
		String[] head= {"Mã sản phẩm","Tên sản phẩm","Mô tả","Ghi chú"};
		model=new DefaultTableModel(head, 0);
		table=new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(30,35,1300,300);
		panel_1.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("Mã sản phẩm:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1.setBounds(30,360 , 150, 30);
		panel_1.add(lblNewLabel_1);
		txtMa = new JTextField();
		txtMa.setBounds(180,360 ,700 ,30 );
		panel_1.add(txtMa);
		txtMa.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tên sản phẩm:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_2.setBounds(30,400 , 150, 30);
		panel_1.add(lblNewLabel_2);
		txtTen = new JTextField();
		txtTen.setBounds(180,400 ,700 ,30 );
		panel_1.add(txtTen);
		txtTen.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Mô Tả:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_3.setBounds(30,440 , 150, 30);
		panel_1.add(lblNewLabel_3);
		txtMoTa = new JTextField();
		txtMoTa.setBounds(180,440 ,700 ,30 );
		panel_1.add(txtMoTa);
		txtMoTa.setColumns(10);
		
		JLabel lblNewLabel_4= new JLabel("Ghi chú:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_4.setBounds(30,480 , 150, 30);
		panel_1.add(lblNewLabel_4);
		txtGhiChu = new JTextField();
		txtGhiChu.setBounds(180,480 ,700 ,50 );
		panel_1.add(txtGhiChu);
		
		
		
		
		
		
		
		btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(224, 255, 255));
		btnThem.setBounds(30,540 ,100 ,30 );
		panel_1.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setBackground(new Color(224, 255, 255));
		btnSua.setBounds(150,540 ,100 ,30 );
		panel_1.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBackground(new Color(224, 255, 255));
		btnXoa.setBounds(270,540 ,100 ,30 );
		panel_1.add(btnXoa);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(new Color(224, 255, 255));
		btnTimKiem.setBounds(390,540 ,100 ,30 );
		panel_1.add(btnTimKiem);
		txtTimKiem=new JTextField();
		txtTimKiem.setBounds(495,540 ,300 ,30 );
		panel_1.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		btnXoaRong=new JButton("Xóa rỗng");
		btnXoaRong.setBackground(new Color(224,255,255));
		btnXoaRong.setBounds(800,540,100,30);
		panel_1.add(btnXoaRong);
		
		btnTaiLai=new JButton("Tải lại");
		btnTaiLai.setBackground(new Color(224,255,255));
		btnTaiLai.setBounds(905,540,100,30);
		panel_1.add(btnTaiLai);
		
		
		
		
		
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTimKiem.addActionListener(this);
		table.addMouseListener(this);
		btnXoaRong.addActionListener(this);
		btnTaiLai.addActionListener(this);
		
		
		dao_SanPham=new DAO_SanPham();
		
		try {
			ConnectDB.getInstance().connect();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DocDuLieuVaoTabel();
		
	}
	
	// đọc dữ liệu lên table
	public void DocDuLieuVaoTabel(){
		 
	        
	       
		
		List<SanPham> ds = dao_SanPham.getAllSanPham();
		for (SanPham sp :ds) {
			
			model.addRow(new Object[] {
					sp.getMaSP(),sp.getTenSP(),sp.getMoTa(),sp.getHinhAnh()
					});
			
		}
		
	}
	
	
	
	//xóa dữ liệu trên bảng
	private void xoaHetDuLieuTrenTableModel() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();

}
	
	
	
	public boolean kiemTraNhapSanPham()
	{
		String maSP=txtMa.getText();
		String tenSP=txtTen.getText();
		String moTa=txtMoTa.getText();
		String ghiChu=txtGhiChu.getText();
		
		if (!(tenSP.length()>0)) {
			JOptionPane.showMessageDialog(this, "Nhập tên sản phẩm");
			return false;
		}
		
		if(!(moTa.length()>0)){
			JOptionPane.showMessageDialog(this,"Nhập mô tả.");
			return false;
		}
		
		if(!(ghiChu.length()>0)){
			JOptionPane.showMessageDialog(this,"Nhập ghi chú.");
			return false;
		}
		return true;
	}
	
	public void xoaRong() {
		
		txtMa.setText("");
		txtTen.setText("");
		txtMoTa.setText("");
		txtGhiChu.setText("");
		
	}
	
	
public void DoculieuvaotabelTheoMa(String ma){
		
		SanPham sp = dao_SanPham.getnhanvienmaSP(ma);
					
					if(sp != null) {
						model.addRow(new Object[] {
								sp.getMaSP(),
								sp.getTenSP(),
								sp.getMoTa(),
								sp.getHinhAnh()
								
								
						});
					}else {
						return;
					}
	
}   




/*public void taoMaHD() {
	int maSoSanPham = dao_SanPham.getAllSanPham().size();	
	
	txtMa.setText("SP0"+(maSoSanPham+1));

}*/
		

	

		
				
			
			
		

	
	
	
	
	
	
//	public static void main(String[] args)
//	{
//		new Gui_qlsp().setVisible(true);
//	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row=table.getSelectedRow();
		txtMa.setText(model.getValueAt(row, 0).toString().trim());
		txtTen.setText(model.getValueAt(row, 1).toString().trim());
		txtMoTa.setText(model.getValueAt(row, 2).toString().trim());
		txtGhiChu.setText(model.getValueAt(row, 3).toString().trim());
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
		if(o.equals(btnThem))
		{
			if(kiemTraNhapSanPham())
			{
				String maSP=txtMa.getText();
				String tenSP=txtTen.getText();
				String moTa=txtMoTa.getText();
				String ghiChu=txtGhiChu.getText();
				SanPham sanPham=new SanPham(maSP,tenSP,moTa,ghiChu);
				ArrayList<SanPham> list;
				
				    try {
				    	list=dao_SanPham.getAllSanPham();
						if(list.contains(sanPham))
						{
							JOptionPane.showMessageDialog(null, "Trùng");
							return ;
						}
						
						else{    
							dao_SanPham.themSanPham(sanPham);
							xoaHetDuLieuTrenTableModel();
							DocDuLieuVaoTabel();
							JOptionPane.showMessageDialog(null, "Thêm thành công");
						}
				    }catch(Exception e1)
				    {
				    	e1.printStackTrace();
				    }
			}
			
			
		
		}
		if(o.equals(btnXoa))
		{
			
				ArrayList<SanPham> list=dao_SanPham.getAllSanPham();
				int row=table.getSelectedRow();
				String maSanPham=model.getValueAt(row, 0).toString().trim();
				if(dao_SanPham.deleteSanPham(maSanPham)) {
					xoaHetDuLieuTrenTableModel();
					DocDuLieuVaoTabel();
					
				}
			
		}
		if(o.equals(btnXoaRong))
		{
			xoaRong();
		}
		if(o.equals(btnTimKiem))
		{
			String tim = txtTimKiem.getText();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			try {
				DoculieuvaotabelTheoMa(tim);
				if(tim.equals("")) {
					tim="rong";
					DocDuLieuVaoTabel();
				}
			} catch (Exception e2) {
				
			}
		}
		
		if(o.equals(btnTaiLai))
		{
			xoaHetDuLieuTrenTableModel();
			DocDuLieuVaoTabel();
		}
		if(o.equals(btnSua))
		{
			suaSP();
		}
	}
	
	
	
	public void suaSP() {
		int row = table.getSelectedRow();
		if(row!=-1) {
			if(kiemTraNhapSanPham()) {
				String maSP = txtMa.getText();
				String tenSP = txtTen.getText();
				String moTa = txtMoTa.getText();
				String ghiChu = txtGhiChu.getText();
				
				SanPham sanPham = new SanPham(maSP,tenSP,moTa,ghiChu);
				
				String dieuKien = table.getValueAt(row,0).toString();
				
				if(dao_SanPham.updateSanPham(sanPham,dieuKien)) {
					table.setValueAt(txtMa.getText(), row, 0);
					table.setValueAt(txtTen.getText(), row, 1);
					table.setValueAt(txtMoTa.getText(), row, 2);
					table.setValueAt(txtGhiChu.getText(), row, 3);
					
					
					JOptionPane.showMessageDialog(this,"Đã sửa thành công");
				}
				else {
					JOptionPane.showMessageDialog(this, "Không sửa được mã sản phẩm");
				}
			}
		}
		else
			JOptionPane.showMessageDialog(this, "Bạn phải chọn sản phẩm cần sửa.");
	}

}
