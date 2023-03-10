/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import connectDB.ConnectDB;
import dao.DAO_PhanCong;
import dao.DAO_ThongKe;
import entity.ChiTietHopDong;
import entity.CongNhanNew;
import entity.NhanVienNew;
import entity.PhieuLuongCongNhan_ThongKe;
import entity.PhieuLuongNhanVien_ThongKe;


public class GUI_ThongKe extends javax.swing.JFrame {

    /**
     * Creates new form GUI_ThongKE
     */
    public GUI_ThongKe() {
    	
    	 try{
 			ConnectDB.getInstance().connect();
 		}catch (SQLException e) {
 			e.printStackTrace();
 		}
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        pnLuong = new javax.swing.JPanel();
        lbLuong = new javax.swing.JLabel();
        lbNhanVien = new javax.swing.JLabel();
        lbCongNhan = new javax.swing.JLabel();
        btLuongNV = new javax.swing.JButton();
        btLuongCN = new javax.swing.JButton();
        lbLuongNV = new javax.swing.JLabel();
        lbLuongCN = new javax.swing.JLabel();
        cbLuongNV = new javax.swing.JComboBox<>();
        cbLuongCN = new javax.swing.JComboBox<>();
        pnNhanSu = new javax.swing.JPanel();
        lbNhanSu = new javax.swing.JLabel();
        btGioiTinhNV = new javax.swing.JButton();
        btGioiTinhCN = new javax.swing.JButton();
        lbGioiTinhNhanVien = new javax.swing.JLabel();
        lbGioiTinhCN = new javax.swing.JLabel();
        pnHopDong = new javax.swing.JPanel();
        lbHopDong = new javax.swing.JLabel();
        btGiaTriHD = new javax.swing.JButton();
        btTrangThai = new javax.swing.JButton();
        lbGiaTri = new javax.swing.JLabel();
        lbTrangThai = new javax.swing.JLabel();
        
        phanCong = new DAO_PhanCong();
        thongKe = new DAO_ThongKe();
        

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 1360, 680);


        pnLuong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbLuong.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lbLuong.setText("Th???ng k?? l????ng");

        lbNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbNhanVien.setText("Nh??n vi??n");

        lbCongNhan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbCongNhan.setText("C??ng nh??n");

        btLuongNV.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("luong.png"))); // NOI18N
        btLuongNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if(cbLuongNV.getSelectedIndex()!=-1) {
    				bieuDoLuongNV(thongKe.getAllPhieuLuongNhanVien(),Integer.parseInt(cbLuongNV.getSelectedItem().toString()));
    				
    			}else {
    				JOptionPane.showMessageDialog(null, "PH???I CH???N TH??NG ????? XEM TH???NG K??!");
    			}
            }
        });

        btLuongCN.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("luongcn.png"))); // NOI18N
        btLuongCN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cbLuongCN.getSelectedIndex()!=-1) {
					bieuDoLuongCN(thongKe.getAllPhieuLuongCongNhan(),Integer.parseInt(cbLuongCN.getSelectedItem().toString()));
					
				}else {
					JOptionPane.showMessageDialog(null, "PH???I CH???N TH??NG ????? XEM TH???NG K??!");
				}
			}
		});

        lbLuongNV.setText("Ch???n th??ng");

        lbLuongCN.setText("Ch???n th??ng");

        cbLuongNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4","5","6","7","8","9","10","11","12" }));

        cbLuongCN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4","5","6","7","8","9","10","11","12" }));

        javax.swing.GroupLayout pnLuongLayout = new javax.swing.GroupLayout(pnLuong);
        pnLuong.setLayout(pnLuongLayout);
        pnLuongLayout.setHorizontalGroup(
            pnLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLuongLayout.createSequentialGroup()
                .addGap(50)
                .addComponent(lbLuong)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnLuongLayout.createSequentialGroup()
                .addGap(130)
                .addComponent(lbNhanVien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbCongNhan)
                .addGap(120))
            .addGroup(pnLuongLayout.createSequentialGroup()
                .addGap(75)
                .addGroup(pnLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnLuongLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lbLuongNV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbLuongNV, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbLuongCN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbLuongCN, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120))
                    .addGroup(pnLuongLayout.createSequentialGroup()
                        .addComponent(btLuongNV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btLuongCN)
                        .addGap(75))))
        );
        pnLuongLayout.setVerticalGroup(
            pnLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLuongLayout.createSequentialGroup()
                .addGap(3)
                .addComponent(lbLuong)
                .addGroup(pnLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnLuongLayout.createSequentialGroup()
                        .addGap(3)
                        .addComponent(lbCongNhan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btLuongCN))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLuongLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNhanVien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btLuongNV, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLuongCN)
                    .addComponent(lbLuongNV)
                    .addComponent(cbLuongNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbLuongCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(3, Short.MAX_VALUE))
        );

        pnNhanSu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbNhanSu.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lbNhanSu.setText("Th???ng k?? nh??n s???");

        btGioiTinhNV.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("NV.png"))); // NOI18N
        btGioiTinhNV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jframePieChartGioiTinhNV.setVisible(true);
			}
		});

        btGioiTinhCN.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("tuoiNV.png"))); // NOI18N
        btGioiTinhCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jframePieChartGioiTinhCN.setVisible(true);
            }
        });

        lbGioiTinhNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbGioiTinhNhanVien.setText("Gi???i t??nh nh??n vi??n");

        lbGioiTinhCN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbGioiTinhCN.setText("Gi???i t??nh c??ng nh??n");

        javax.swing.GroupLayout pnNhanSuLayout = new javax.swing.GroupLayout(pnNhanSu);
        pnNhanSu.setLayout(pnNhanSuLayout);
        pnNhanSuLayout.setHorizontalGroup(
            pnNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNhanSuLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(pnNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnNhanSuLayout.createSequentialGroup()
                        .addComponent(lbNhanSu)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnNhanSuLayout.createSequentialGroup()
                        .addComponent(btGioiTinhNV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                        .addComponent(btGioiTinhCN)
                        .addGap(105, 105, 105))))
            .addGroup(pnNhanSuLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(lbGioiTinhNhanVien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbGioiTinhCN)
                .addGap(148, 148, 148))
        );
        pnNhanSuLayout.setVerticalGroup(
            pnNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNhanSuLayout.createSequentialGroup()
                .addGap(3)
                .addGroup(pnNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btGioiTinhCN)
                    .addGroup(pnNhanSuLayout.createSequentialGroup()
                        .addComponent(lbNhanSu)
                        .addGap(3)
                        .addComponent(btGioiTinhNV)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGioiTinhNhanVien)
                    .addComponent(lbGioiTinhCN))
                .addContainerGap(3, Short.MAX_VALUE))
        );

        pnHopDong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbHopDong.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lbHopDong.setText("Th???ng k?? h???p ?????ng");

        btGiaTriHD.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("iconbarchart.png"))); // NOI18N
        btGiaTriHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jframeBarChatGTHD.setVisible(true);
            }
        });

        btTrangThai.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("pie-chart-icon-design-vector.jpg"))); // NOI18N
        btTrangThai.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jframePieChartTTTTHD.setVisible(true);
			}
		});
        
        lbGiaTri.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbGiaTri.setText("Gi?? tr??? h???p ?????ng");

        lbTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbTrangThai.setText("Tr???ng th??i thanh to??n");

        javax.swing.GroupLayout pnHopDongLayout = new javax.swing.GroupLayout(pnHopDong);
        pnHopDong.setLayout(pnHopDongLayout);
        pnHopDongLayout.setHorizontalGroup(
            pnHopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHopDongLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbHopDong)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHopDongLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(pnHopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHopDongLayout.createSequentialGroup()
                        .addGroup(pnHopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btTrangThai)
                            .addComponent(btGiaTriHD))
                        .addGap(45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHopDongLayout.createSequentialGroup()
                        .addComponent(lbTrangThai)
                        .addGap(145, 145, 145))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHopDongLayout.createSequentialGroup()
                        .addComponent(lbGiaTri)
                        .addGap(169, 169, 169))))
        );
        pnHopDongLayout.setVerticalGroup(
            pnHopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHopDongLayout.createSequentialGroup()
                .addGap(3)
                .addComponent(lbHopDong)
                .addGap(80)
                .addComponent(btGiaTriHD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbGiaTri)
                .addGap(80)
                .addComponent(btTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTrangThai)
                .addContainerGap(6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnNhanSu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(pnHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnHopDong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnNhanSu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        
        jframePieChartGioiTinhCN = new JFrame();
		jframePieChartGioiTinhCN.setSize(900,700);
		jframePieChartGioiTinhCN.setLocationRelativeTo(null);
		JFreeChart pieChartGioiTinhCN = createPieChartGioiTinhCN(createDatasetPieGioiTinhCN());
        ChartPanel chartPanelpieChartGioiTinhCN = new ChartPanel(pieChartGioiTinhCN);
		jframePieChartGioiTinhCN.getContentPane().add(chartPanelpieChartGioiTinhCN);
		
		jframePieChartGioiTinhNV = new JFrame();
		jframePieChartGioiTinhNV.setSize(900,700);
		jframePieChartGioiTinhNV.setLocationRelativeTo(null);
		JFreeChart pieChartGioiTinhNV = createPieChartGioiTinhNV(createDatasetPieGioiTinhNV());
        ChartPanel chartPanelpieChartGioiTinhNV = new ChartPanel(pieChartGioiTinhNV);
		jframePieChartGioiTinhNV.getContentPane().add(chartPanelpieChartGioiTinhNV);

		jframeBarChatGTHD = new JFrame();
		jframeBarChatGTHD.setSize(900,700);
		jframeBarChatGTHD.setLocationRelativeTo(null);
		JFreeChart jFreeChartGiaTriHopDong = createChartGiaTriHopDong(thongKe.getAllChiTietHopDong());
		ChartPanel chartPanelGiaTriHopDong = new ChartPanel(jFreeChartGiaTriHopDong);
		chartPanelGiaTriHopDong.setPreferredSize(new java.awt.Dimension(560, 367));
		jframeBarChatGTHD.getContentPane().add(chartPanelGiaTriHopDong);
		
		jframePieChartTTTTHD = new JFrame();
		jframePieChartTTTTHD.setSize(900,700);
		jframePieChartTTTTHD.setLocationRelativeTo(null);
		JFreeChart pieChart = createPieChartTinhTrangThanhToanHD(createDatasetPieTinhTrangThanhToanHD());
        ChartPanel chartPanelpieChart = new ChartPanel(pieChart);
		jframePieChartTTTTHD.getContentPane().add(chartPanelpieChart);
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btLuongNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLuongNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btLuongNVActionPerformed

    private void btGioiTinhCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGioiTinhCNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btGioiTinhCNActionPerformed

    private void btGiaTriHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGiaTriHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btGiaTriHDActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_ThongKe().setVisible(true);
            }
        });
    }
    public JFreeChart createPieChartGioiTinhCN(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "T????ng quan gi???i t??nh c???a c??ng nh??n", dataset, true, true, true);
        return chart;
    }
    
    public PieDataset createDatasetPieGioiTinhCN() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		double x=0,y=0;
		 for(CongNhanNew congNhan : phanCong.getAllCongNhan()) {
			 if(congNhan.isGioiTinh()==true)
				 x++;
			 else
				 y++;
		 }
		 dataset.setValue("N???", y);
		 dataset.setValue("Nam" , x);
	    return dataset;
    }
    public CategoryDataset createDatasetLuongTrongNam() {
		 DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		 double mot=0,hai=0,ba=0,bon=0,nam=0,sau=0,bay=0,tam=0,chin=0,muoi=0,muoiMot=0,muoiHai=0;
		 for(PhieuLuongCongNhan_ThongKe phieuLuongCongNhan : thongKe.getAllPhieuLuongCongNhan()) {
			 if(phieuLuongCongNhan.getNgay()==1 ) {
					mot+=phieuLuongCongNhan.getThanhTien();
				 }
				 if(phieuLuongCongNhan.getNgay()==2) {
						hai+=phieuLuongCongNhan.getThanhTien();
					 }
				 if(phieuLuongCongNhan.getNgay()==3 ) {
						ba+=phieuLuongCongNhan.getThanhTien();
					 }
				 if(phieuLuongCongNhan.getNgay()==4) {
						bon+=phieuLuongCongNhan.getThanhTien();
					 }
				 if(phieuLuongCongNhan.getNgay()==5) {
						nam+=phieuLuongCongNhan.getThanhTien();
					 }
				 if(phieuLuongCongNhan.getNgay()==6) {
						sau+=phieuLuongCongNhan.getThanhTien();
					 }
				 if(phieuLuongCongNhan.getNgay()==7) {
						bay+=phieuLuongCongNhan.getThanhTien();
					 }
				 if(phieuLuongCongNhan.getNgay()==8) {
						tam+=phieuLuongCongNhan.getThanhTien();
					 }
				 if(phieuLuongCongNhan.getNgay()==9) {
						chin+=phieuLuongCongNhan.getThanhTien();
					 }
				 if(phieuLuongCongNhan.getNgay()==10) {
						muoi+=phieuLuongCongNhan.getThanhTien();
					 }
				 if(phieuLuongCongNhan.getNgay()==11) {
						muoiMot+=phieuLuongCongNhan.getThanhTien();
					 }
				 if(phieuLuongCongNhan.getNgay()==12) {
						muoiHai+=phieuLuongCongNhan.getThanhTien();
					 }
		 }
		 for (PhieuLuongNhanVien_ThongKe  phieuLuongNhanVien : thongKe.getAllPhieuLuongNhanVien()) {
			 if(phieuLuongNhanVien.getNgayCC()==1) {
					mot+= phieuLuongNhanVien.getThanhTien();
				 }
			 if(phieuLuongNhanVien.getNgayCC()==2) {
					hai+= phieuLuongNhanVien.getThanhTien();
				 }
			 if(phieuLuongNhanVien.getNgayCC()==3) {
					ba+= phieuLuongNhanVien.getThanhTien();
				 }
			 if(phieuLuongNhanVien.getNgayCC()==4) {
					bon+= phieuLuongNhanVien.getThanhTien();
				 }
			 if(phieuLuongNhanVien.getNgayCC()==5) {
					nam+= phieuLuongNhanVien.getThanhTien();
				 }
			 if(phieuLuongNhanVien.getNgayCC()==6) {
					sau+= phieuLuongNhanVien.getThanhTien();
				 }
			 if(phieuLuongNhanVien.getNgayCC()==7) {
					bay+= phieuLuongNhanVien.getThanhTien();
				 }
			 if(phieuLuongNhanVien.getNgayCC()==8) {
					tam+= phieuLuongNhanVien.getThanhTien();
				 }
			 if(phieuLuongNhanVien.getNgayCC()==9) {
					chin+= phieuLuongNhanVien.getThanhTien();
				 }
			 if(phieuLuongNhanVien.getNgayCC()==10) {
					muoi+= phieuLuongNhanVien.getThanhTien();
				 }
			 if(phieuLuongNhanVien.getNgayCC()==11) {
					muoiMot+= phieuLuongNhanVien.getThanhTien();
				 }
			 if(phieuLuongNhanVien.getNgayCC()==12) {
					muoiHai+= phieuLuongNhanVien.getThanhTien();
				 }
		}
		 dataset.addValue(mot,"Th??nh ti???n",1+"");
		 dataset.addValue(hai,"Th??nh ti???n",2+"");
		 dataset.addValue(ba,"Th??nh ti???n",3+"");
		 dataset.addValue(bon,"Th??nh ti???n",4+"");
		 dataset.addValue(nam,"Th??nh ti???n",5+"");
		 dataset.addValue(sau,"Th??nh ti???n",6+"");
		 dataset.addValue(bay,"Th??nh ti???n",7+"");
		 dataset.addValue(tam,"Th??nh ti???n",8+"");
		 dataset.addValue(chin,"Th??nh ti???n",9+"");
		 dataset.addValue(muoi,"Th??nh ti???n",10+"");
		 dataset.addValue(muoiMot,"Th??nh ti???n",11+"");
		 dataset.addValue(muoiHai,"Th??nh ti???n",12+"");
		 return dataset;
		 }
    
    public JFreeChart createChartLuongNV(List<PhieuLuongNhanVien_ThongKe> list, int mouth ) {
		 CategoryDataset categoryDataset = createDatasetLuongNV(mouth);
		 double tong=0;
		 for (PhieuLuongNhanVien_ThongKe phieuLuongNhanVien:list) {
			if(phieuLuongNhanVien.getNgayCC()==mouth)
				tong+=phieuLuongNhanVien.getThanhTien();
		}
		 JFreeChart barChart = ChartFactory.createBarChart(
				    "L????ng nh??n vi??n trong th??ng "+mouth+"\n"+"T???ng l????ng: "+NumberFormat.getCurrencyInstance(new Locale("vi","VN")).format(tong),
	                "M?? ng?????i h?????ng l????ng", "L????ng",
	                categoryDataset, PlotOrientation.VERTICAL, false, false, false);
		 return barChart;  
	}
    public CategoryDataset createDatasetLuongNV(int mouth) {
		 DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		 for(PhieuLuongNhanVien_ThongKe phieuLuongNhanVien : thongKe.getAllPhieuLuongNhanVien()) {
			 if (phieuLuongNhanVien.getNgayCC()==mouth) {
				 dataset.addValue(phieuLuongNhanVien.getThanhTien(),"",phieuLuongNhanVien.getMaNguoiHuong());
			 }	 
		 }
		 return dataset;	 
	}
    public void bieuDoLuongNV(List<PhieuLuongNhanVien_ThongKe> list,int month) {
		JFrame jframeBarChartLuongNV = new JFrame();
		jframeBarChartLuongNV.setSize(900,700);
		jframeBarChartLuongNV.setLocationRelativeTo(null);
		JFreeChart jFreeChartLuongNV = createChartLuongNV(list, month);
		ChartPanel chartPanelLuongNV = new ChartPanel(jFreeChartLuongNV);
		jframeBarChartLuongNV.getContentPane().add(chartPanelLuongNV);
		jframeBarChartLuongNV.setVisible(true);
	}
    
    public PieDataset createDatasetPieGioiTinhNV() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		double x=0,y=0;
		 for(NhanVienNew nhanVienHanhChinh : thongKe.getAllNhanVienHanhChinh()) {
			 if(nhanVienHanhChinh.isGioiTinh()==true)
				 x++;
			 else
				 y++;
		 }
		 dataset.setValue("N???", y);
		 dataset.setValue("Nam" , x);
	    return dataset;
    }
    
    public JFreeChart createPieChartGioiTinhNV(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "T????ng quan gi???i t??nh c???a nh??n vi??n", dataset, true, true, true);
        return chart;
    }
    
    public JFreeChart createChartLuongCN(List<PhieuLuongCongNhan_ThongKe> list, int mouth ) {
		 CategoryDataset categoryDataset = createDatasetLuongCN(mouth);
		 double tong = 0;
		 for (PhieuLuongCongNhan_ThongKe phieuLuongCongNhan:list) {
				if(phieuLuongCongNhan.getNgay()==mouth)
					tong+=phieuLuongCongNhan.getThanhTien();
			}
		 JFreeChart barChart = ChartFactory.createBarChart(
	                "L????ng c??ng nh??n trong th??ng "+mouth+"\nT???ng l????ng: "+NumberFormat.getCurrencyInstance(new Locale("vi","VN")).format(tong),
	                "M?? ng?????i h?????ng l????ng", "Th??nh ti???n",
	                categoryDataset, PlotOrientation.VERTICAL, false, false, false);
		 return barChart;
	}
    
    public CategoryDataset createDatasetLuongCN(int mouth) {
		 DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		 for(PhieuLuongCongNhan_ThongKe phieuLuongCongNhan : thongKe.getAllPhieuLuongCongNhan()) {
			 if (phieuLuongCongNhan.getNgay()==mouth) {
				 dataset.addValue(phieuLuongCongNhan.getThanhTien(),"",phieuLuongCongNhan.getMaNguoiHuong());
			 }	 
		 }
		 return dataset;	
	}
    public void bieuDoLuongCN(List<PhieuLuongCongNhan_ThongKe> list,int month) {
		JFrame jframeBarChartLuongCN = new JFrame();
		jframeBarChartLuongCN.setSize(900,700);
		jframeBarChartLuongCN.setLocationRelativeTo(null);
		JFreeChart jFreeChartLuongCN = createChartLuongCN(list, month);
		ChartPanel chartPanelLuongCN = new ChartPanel(jFreeChartLuongCN);
		jframeBarChartLuongCN.getContentPane().add(chartPanelLuongCN);
		jframeBarChartLuongCN.setVisible(true);

	}
    public JFreeChart createChartGiaTriHopDong(List<ChiTietHopDong> list ) {
		 CategoryDataset categoryDataset = createDatasetGiaTriHD();
		 double tongGiaTri = 0;
		 for(ChiTietHopDong chiTietHopDong : list) {
			 tongGiaTri+=(chiTietHopDong.getGiaTri()*chiTietHopDong.getSoLuong());
			 }
		 JFreeChart barChart = ChartFactory.createBarChart(
	                "Gi?? tr??? t???t c??? c??c h???p ?????ng: "+NumberFormat.getCurrencyInstance(new Locale("vi","VN")).format(tongGiaTri),
	                "M?? h???p ?????ng", "Gi?? tr??? h???p ?????ng",
	                categoryDataset, PlotOrientation.VERTICAL, false, false, false);
		 return barChart;
		 }
		 public CategoryDataset createDatasetGiaTriHD() {
			 DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			 for(ChiTietHopDong chiTietHopDong : thongKe.getAllChiTietHopDong()) {
				 dataset.addValue(chiTietHopDong.getGiaTri(),"Gi?? tr???",chiTietHopDong.getMaHD());
				 }
			 return dataset;
		 }
		 public PieDataset createDatasetPieTinhTrangThanhToanHD() {
			 DefaultPieDataset dataset = new DefaultPieDataset();
			 double x=0,y=0;
			 for(ChiTietHopDong chiTietHopDong : thongKe.getAllChiTietHopDong()) {
				 if(chiTietHopDong.isTinhTrang()==true)
					 x++;
				 else
					 y++;
			 }
			 dataset.setValue("Ch??a thanh to??n", y);
			 dataset.setValue("???? thanh to??n" , x);
			 return dataset;
		    }
		 public JFreeChart createPieChartTinhTrangThanhToanHD(PieDataset dataset) {
		        JFreeChart chart = ChartFactory.createPieChart(
		                "T??nh tr???ng thanh to??n c???a t???t c??? c??c h???p ?????ng", dataset, true, true, true);
		        return chart;
		    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGiaTriHD;
    private javax.swing.JButton btGioiTinhCN;
    private javax.swing.JButton btGioiTinhNV;
    private javax.swing.JButton btLuongCN;
    private javax.swing.JButton btLuongNV;
    private javax.swing.JButton btTrangThai;
    private javax.swing.JComboBox<String> cbLuongCN;
    private javax.swing.JComboBox<String> cbLuongNV;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel lbCongNhan;
    private javax.swing.JLabel lbGiaTri;
    private javax.swing.JLabel lbGioiTinhCN;
    private javax.swing.JLabel lbGioiTinhNhanVien;
    private javax.swing.JLabel lbHopDong;
    private javax.swing.JLabel lbLuong;
    private javax.swing.JLabel lbLuongCN;
    private javax.swing.JLabel lbLuongNV;
    private javax.swing.JLabel lbNhanSu;
    private javax.swing.JLabel lbNhanVien;
    private javax.swing.JLabel lbTrangThai;
    private javax.swing.JPanel pnHopDong;
    private javax.swing.JPanel pnLuong;
    private javax.swing.JPanel pnNhanSu;
    
    private DAO_PhanCong phanCong;
    private static DAO_ThongKe thongKe;
    
    private JFrame jframeBarChatGTHD;
    private JFrame jframePieChartTTTTHD;
    private JFrame jframePieChartGioiTinhCN;
    private JFrame jframePieChartGioiTinhNV;
    // End of variables declaration//GEN-END:variables
}
