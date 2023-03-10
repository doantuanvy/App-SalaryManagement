package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import connectDB.ConnectDB;
import dao.DAO_DangNhap;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;


public class GUI_DangNhap extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPassWord;
	private JButton btnThot;
	private AbstractButton btnngNhp;
	private static String dnma;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_DangNhap frame = new GUI_DangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public GUI_DangNhap() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Đăng nhập");
		setBounds(100, 100, 1036, 599);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
			
		try{
			ConnectDB.getInstance().connect();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		new DAO_DangNhap();
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
	    
		addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	                System.exit(1);
	            }
	        });
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(10, 115, 979, 308);
		contentPane.add(panel_1_1);
		panel_1_1.setBackground(new Color(204, 204, 255));
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblNewLabel_1 = new JLabel("Tài khoản");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(209, 34, 100, 29);
		panel_1_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Serif", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(209, 135, 100, 29);
		panel_1_1.add(lblNewLabel_1_1);
		
		txtUserName = new JTextField("NV0001");
		txtUserName.setForeground(Color.DARK_GRAY);
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtUserName.setToolTipText("User Name");
		txtUserName.setColumns(10);
		txtUserName.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		txtUserName.setBounds(209, 64, 600, 40);
		panel_1_1.add(txtUserName);
		
		txtPassWord = new JPasswordField("123456");
		txtPassWord.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtPassWord.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		txtPassWord.setBounds(209, 170, 600, 40);
		panel_1_1.add(txtPassWord);
		
		btnngNhp = new JButton("Đăng nhập");
		btnngNhp.setVerticalAlignment(SwingConstants.TOP);
		btnngNhp.setToolTipText("Đăng nhập");
		btnngNhp.setBounds(295, 258, 190, 39);
		panel_1_1.add(btnngNhp);
//		btnngNhp.setIcon(new ImageIcon("\\data\\\\img\\\\hoadonnhap.png"));
		btnngNhp.setIcon(new ImageIcon(getClass().getClassLoader().getResource("hoadonnhap.png")));
		btnngNhp.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		btnngNhp.setBorder(UIManager.getBorder("Button.border"));
		btnThot = new JButton(" Thoát");
		btnThot.setVerticalAlignment(SwingConstants.BOTTOM);
		btnThot.setToolTipText(" Thoát");
		btnThot.setBounds(542, 258, 190, 39);
		panel_1_1.add(btnThot);
		btnThot.setIcon(new ImageIcon(getClass().getClassLoader().getResource("logout.png")));
		btnThot.setBorder(UIManager.getBorder("Button.border"));
		btnThot.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		Date date = new Date();
	    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
	    String strDate = dateFormat.format(date);
		JLabel lblNgay = new JLabel(strDate);
		lblNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgay.setBounds(862, 11, 107, 30);
		panel_1_1.add(lblNgay);
		
		JCheckBox chckbxshowpass = new JCheckBox("   hiện mật khẩu");
		chckbxshowpass.setBackground(new Color(253, 245, 230));
		chckbxshowpass.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		chckbxshowpass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxshowpass.isSelected()) {
					txtPassWord.setEchoChar((char)0);
				}else {
					txtPassWord.setEchoChar('*');
				}
			}
		});
		chckbxshowpass.setBounds(212, 217, 121, 23);
		panel_1_1.add(chckbxshowpass);
		
//		JLabel background=new JLabel(new ImageIcon("data\\img\\bg.jpg"));
		JLabel background=new JLabel(new ImageIcon(getClass().getClassLoader().getResource("bg.jpg")));
//		JLabel background=new JLabel(new ImageIcon("\\\\img\\\\bg.jpg"));
		background.setBounds(0, 0, 1010, 550);
		contentPane.add(background);
		background.setToolTipText("form đăng nhập");
		background.setLayout(new FlowLayout());
		btnThot.addActionListener(this);	
		btnngNhp.addActionListener(this);
		setResizable(false);
		
	}
	
	
	
	@SuppressWarnings("deprecation")
	@Override
public void actionPerformed(ActionEvent e ) {
	Object o = e.getSource();
		if(o.equals(btnThot))
			System.exit(0);
		if(o.equals(btnngNhp)) {
			if(txtUserName.getText().equals("")) {
//				Icon icon = new javax.swing.ImageIcon(getClass().getResource("//data//img//icons8-login-50.png"));
				JOptionPane.showMessageDialog(this, "Vui lòng nhập tài khoản", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}else {
				if(txtPassWord.getPassword().equals("")) {
					JOptionPane.showMessageDialog(this, "thông báo: Vui lòng nhập mật khẩu!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					
				}else {
					ConnectDB.getInstance();
					Connection con = ConnectDB.getConnection();
					try {
						
						String stmt = "select *from TaiKhoan where tenTK=? AND matKhau=?";
						PreparedStatement ps = con.prepareStatement(stmt);
						ps.setString(1, txtUserName.getText());
						ps.setString(2, txtPassWord.getText());	
						
						ResultSet rs = ps.executeQuery();
						if(rs.next()){
							GUI_DangNhap.dnma=rs.getString(1);
							this.setVisible(false);
							new GUI_TabpanelMenu().setVisible(true);
						}else {
							JOptionPane.showMessageDialog(this, "Tài khoản hoặc Mật khẩu không chính xác!");
							txtPassWord.setText("");
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
			
		}
		
	}

	

	public static String getDnma() {
		return dnma;
	}
}

