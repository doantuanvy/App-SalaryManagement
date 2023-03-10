package gui;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import gui.ClockThread;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JOptionPane;

public class GUI_TrangChu extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel txtma;
	private JButton btnthongtin;
	private JButton btnQuanLyTK;
	ClockThread clockThread;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI_TrangChu frame = new GUI_TrangChu();
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
	public GUI_TrangChu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 710);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	    contentPane.setLayout(null);
	
	    
	    JLabel lblNewLabel = new JLabel("Mã NV:");
	    lblNewLabel.setBounds(1101, 20, 107, 60);
	    lblNewLabel.setBackground(Color.GRAY);
	    lblNewLabel.setForeground(new Color(255, 0, 0));
	    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
	    getContentPane().add(lblNewLabel);
	    
	    btnthongtin = new JButton("Thông Tin");
	    btnthongtin.setForeground(new Color(255, 0, 0));
	    btnthongtin.setBackground(new Color(255, 128, 128));
	    btnthongtin.setBounds(1107, 90, 229, 32);
	    btnthongtin.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    contentPane.add(btnthongtin);
	    
	    txtma = new JLabel("Mã NV");
	    txtma.setBounds(1208, 26, 138, 54);
	    txtma.setFont(new Font("Tahoma", Font.PLAIN, 30));
	    txtma.setForeground(new Color(255, 0, 0));
	    txtma.setText(GUI_DangNhap.getDnma());
	    contentPane.add(txtma);
	    
	    Font fontGio =new Font("Arial",Font.BOLD,22);
		Font fontTen =new Font("Arial",Font.BOLD,55);
		Font fontND =new Font("Arial",Font.BOLD | Font.ITALIC,15);
	    
	    JLabel lblNewLabel_DongHo = new JLabel("New label");
	    lblNewLabel_DongHo.setBounds(663, 90, 301, 93);
	    lblNewLabel_DongHo.setFont(fontGio);
		lblNewLabel_DongHo.setForeground(Color.RED);
	    contentPane.add(lblNewLabel_DongHo);
	    clockThread = new ClockThread(lblNewLabel_DongHo);
		clockThread.start();
		
		JLabel lblNewLabel_CongTy = new JLabel("CÔNG TY MAY GÒ VẤP");
	    lblNewLabel_CongTy.setForeground(new Color(255, 0, 0));
	    lblNewLabel_CongTy.setFont(new Font("Tahoma", Font.BOLD, 50));
	    lblNewLabel_CongTy.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_CongTy.setBounds(408, 301, 596, 141);
	    contentPane.add(lblNewLabel_CongTy);
	    
	    JLabel lblNewLabel_DiaChi = new JLabel("Địa chỉ: 12 Nguyễn Văn Bảo....");
	    lblNewLabel_DiaChi.setForeground(new Color(255, 0, 0));
	    lblNewLabel_DiaChi.setFont(new Font("Tahoma", Font.PLAIN, 28));
	    lblNewLabel_DiaChi.setBounds(10, 600, 704, 63);
	    contentPane.add(lblNewLabel_DiaChi);
		
	    btnQuanLyTK = new JButton("Quản Lý Tài Khoản");
	    btnQuanLyTK.setForeground(new Color(255, 0, 0));
	    btnQuanLyTK.setBackground(new Color(255, 128, 128));
	    btnQuanLyTK.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    btnQuanLyTK.setBounds(1107, 150, 229, 32);
	    contentPane.add(btnQuanLyTK);
	    
	    JLabel background=new JLabel(new ImageIcon(getClass().getClassLoader().getResource("bg.jpg")));
	    background.setBounds(10, 0, 1336, 663);
	    background.setBackground(Color.GRAY);
	    background.setFont(new Font("Tahoma", Font.PLAIN, 23));
	    getContentPane().add(background);
	    background.setLayout(new FlowLayout());
	    
	    JLabel lblNewLabel_logo = new JLabel(new ImageIcon("logo.jpg"));
	    lblNewLabel_logo.setBounds(30, 63, 163, 141);
	    lblNewLabel_logo.setBackground(Color.GRAY);
	    lblNewLabel_logo.setFont(new Font("Tahoma", Font.PLAIN, 23));
	    contentPane.add(lblNewLabel_logo);

	    btnthongtin.addActionListener(this);
	    btnQuanLyTK.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnthongtin)) {
			new GUI_ThongTinTK().setVisible(true);
			this.setVisible(false);
		}
		if(o.equals(btnQuanLyTK)) {
			String ma = GUI_DangNhap.getDnma(); 
			if(ma.matches("QL01")) {
				new GUI_QuanLyTaiKhoan().setVisible(true);
				this.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(this, "Chú ý:Chức năng này chỉ dành cho quản lý!");
			}	
		}
		
	}
}
