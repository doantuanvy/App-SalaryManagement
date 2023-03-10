package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import dao.DAO_DangNhap;
import entity.DangNhap;

public class GUI_ThongTinTK extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTenTK;
	private JPasswordField txtmkCu;
	private JPasswordField txtMK1;
	private JPasswordField txtMK2;
	private JButton btnDoiMK;
	private DAO_DangNhap dn_dao;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI_ThongTinTK frame = new GUI_ThongTinTK();
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
	public GUI_ThongTinTK() {
		setBounds(100, 100, 763, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	    contentPane.setLayout(null);
	 
		try{
			ConnectDB.getInstance().connect();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		dn_dao = new DAO_DangNhap();
	    
	    JLabel lblNewLabel = new JLabel("Thông Tin Tài Khoản");
	    lblNewLabel.setForeground(Color.ORANGE);
	    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
	    lblNewLabel.setBounds(223, 10, 385, 84);
	    contentPane.add(lblNewLabel);
	    
	    txtTenTK = new JTextField();
	    txtTenTK.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    txtTenTK.setColumns(10);
	    txtTenTK.setBounds(278, 138, 330, 31);
	    txtTenTK.setText(GUI_DangNhap.getDnma());
	    contentPane.add(txtTenTK);
	    
	    JLabel lblNewLabel_1 = new JLabel("Tên Tài Khoản:");
	    lblNewLabel_1.setForeground(Color.ORANGE);
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    lblNewLabel_1.setBounds(126, 137, 137, 33);
	    contentPane.add(lblNewLabel_1);
	    
	    txtmkCu = new JPasswordField();
	    txtmkCu.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    txtmkCu.setColumns(10);
	    txtmkCu.setBounds(275, 182, 330, 31);
	    contentPane.add(txtmkCu);
	    
	    JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu cũ: ");
	    lblNewLabel_1_1.setForeground(Color.ORANGE);
	    lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    lblNewLabel_1_1.setBounds(147, 181, 122, 33);
	    contentPane.add(lblNewLabel_1_1);
	    
	    txtMK1 = new JPasswordField();
	    txtMK1.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    txtMK1.setColumns(10);
	    txtMK1.setBounds(278, 241, 330, 31);
	    contentPane.add(txtMK1);
	    
	    JLabel lblNewLabel_1_2 = new JLabel("Mật Khẩu Mới:");
	    lblNewLabel_1_2.setForeground(Color.ORANGE);
	    lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    lblNewLabel_1_2.setBounds(135, 240, 128, 33);
	    contentPane.add(lblNewLabel_1_2);
	    
	    txtMK2 = new JPasswordField();
	    txtMK2.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    txtMK2.setColumns(10);
	    txtMK2.setBounds(278, 302, 330, 31);
	    contentPane.add(txtMK2);
	    
	    JLabel lblNewLabel_1_3 = new JLabel("Xác Nhận Mật Khẩu: ");
	    lblNewLabel_1_3.setForeground(Color.ORANGE);
	    lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    lblNewLabel_1_3.setBounds(81, 301, 188, 33);
	    contentPane.add(lblNewLabel_1_3);
	    
	    btnDoiMK = new JButton("Đổi Mật Khẩu");
	    btnDoiMK.setFont(new Font("Tahoma", Font.PLAIN, 22));
	    btnDoiMK.setBounds(307, 366, 182, 42);
	    contentPane.add(btnDoiMK);

	    JLabel background=new JLabel(new ImageIcon("data\\\\\\\\img\\\\\\\\12.jpg"));
	    background.setBackground(Color.GRAY);
	    background.setFont(new Font("Tahoma", Font.PLAIN, 23));
	    background.setBounds(10, 0, 729, 479);
	    getContentPane().add(background);
	    background.setLayout(new FlowLayout());
	    
	    btnDoiMK.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnDoiMK)) {
			
				String tenTK = txtTenTK.getText().trim();
				String mKCu = txtmkCu.getText().trim();
				String mKMoi1 =  txtMK1.getText().trim();
				String mKMoi2 =  txtMK2.getText().trim();
				String dn= dn_dao.getTKTen(tenTK);
				if(!dn.trim().equals(mKCu)) {
					JOptionPane.showMessageDialog(this, "Chú ý: Sai Mật Khẩu Cũ!");
					
				}else {
					if(!mKMoi1.equals(mKMoi2)) {
						JOptionPane.showMessageDialog(this, "Chú ý: Xác Nhận Mật Khẩu Mới Không Khớp!");
						
					}else {
						
							DangNhap dNhap= new DangNhap(tenTK, mKMoi1, null, null); 
							
							if(dn_dao.Updata(dNhap,tenTK)) {
								JOptionPane.showMessageDialog(this, "Đổi Mật khẩu Thành Công!");
							} else
								JOptionPane.showMessageDialog(this, "Đổi Mật khẩu Thất bại");
						}
					}

				}
			}
			
			
			
	
	public DangNhap suaMK1() {
			try {
				String txttk = txtTenTK.getText();
				String txtmk = txtMK2.getText();
				return new DangNhap(txttk,txtmk,null,null);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		return null;
	}
	
	public boolean kiemtra() {
		String MK1 = txtMK1.getText().trim();
		String MK2 = txtMK2.getText().trim();
		if(!(MK1.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Chú ý: Mật khẩu mới không được rỗng!");
			return false;
		}
		if (!(MK2.length() > 0 )) {
			JOptionPane.showMessageDialog(this,"Chú ý: Mật khẩu xác nhận sai!)");
			return false;
		}
		return true;
	}
}

