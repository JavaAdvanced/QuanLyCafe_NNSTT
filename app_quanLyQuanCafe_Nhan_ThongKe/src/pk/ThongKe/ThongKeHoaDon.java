package pk.ThongKe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import pk.SQL.connectDbSql;
import pk.doiTuong.HoaDon;

public class ThongKeHoaDon extends javax.swing.JPanel {

    /**
     * Creates new form ThongKeHoaDon
     */
    public ThongKeHoaDon() {
        initComponents();
        this.setSize(783, 508);
        show_user();
    }
    connectDbSql con = new connectDbSql();
    public ArrayList<HoaDon> UserList() {
        ArrayList<HoaDon> UserList = new ArrayList<>();
        try {         
            
            
            String sql = "Select * from tblHoaDon where tongTien > 0";
            Statement st = con.con.createStatement();
            ResultSet rs = st.executeQuery(sql);     
            HoaDon user;
            while(rs.next()) {
                user = new HoaDon(rs.getString("MaHD"),
                rs.getInt("idBan"), rs.getDate("ngay"), rs.getDouble("tongTien")); 
                UserList.add(user);
            }
                     
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return UserList;
    }
    
    public void show_user() {
        ArrayList<HoaDon> list = UserList();
        DefaultTableModel tblModel = (DefaultTableModel)table_hoadon4.getModel();
        Object[] row = new Object[4];
        
        int soHD = 0;
        float tongTien = 0;
        for(int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMaHD();
            row[1] = list.get(i).getIdBan();
            row[2] = list.get(i).getNgay();
            row[3] = list.get(i).getTongTien();
            tblModel.addRow(row);
            soHD = soHD + 1;
            tongTien = (float) (tongTien + list.get(i).getTongTien());
        }
        txtTong.setText(String.valueOf(soHD));
        txtTongTien.setText(String.valueOf(tongTien)+" VNĐ");
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnRef = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_hoadon4 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtTong = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTo = new com.toedter.calendar.JDateChooser();
        txtDen = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3));
        setForeground(new java.awt.Color(0, 51, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("THỐNG KÊ THEO HÓA ĐƠN");

        btnRef.setText("REFRESH");
        btnRef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefActionPerformed(evt);
            }
        });

        table_hoadon4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaHD", "Id Bán", "Ngày", "Tổng tiền"
            }
        ));
        jScrollPane6.setViewportView(table_hoadon4);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setText("SỐ HÓA ĐƠN:");

        txtTong.setForeground(new java.awt.Color(255, 51, 51));
        txtTong.setText("jLabel3");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 255));
        jLabel3.setText("TỔNG SỐ TIỀN:");

        txtTongTien.setForeground(new java.awt.Color(255, 51, 51));
        txtTongTien.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtTong))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTongTien)))
                .addGap(0, 61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTong))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTongTien))
                .addGap(24, 24, 24))
        );

        jLabel4.setText("Từ");

        jLabel5.setText("Đến");

        jButton1.setText("Thống kê");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(jLabel1)
                        .addGap(71, 71, 71)
                        .addComponent(btnRef))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96)
                                .addComponent(jButton1))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(btnRef))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addComponent(txtTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addGap(36, 36, 36)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefActionPerformed
        // TODO add your handling code here:
//        jPanel1.removeAll();
        DefaultTableModel tblModel = (DefaultTableModel)table_hoadon4.getModel();
        Object[] row = new Object[4];
        tblModel.setRowCount(0);
        show_user();
    }//GEN-LAST:event_btnRefActionPerformed

     public ArrayList<HoaDon> thongKe(String date1, String date2) {
        ArrayList<HoaDon> UserList = new ArrayList<>();
        try {         
            
            
            String sql = "SELECT * FROM tblhoadon "
                    + "WHERE Ngay BETWEEN  CAST('"+date1+"' AS DATE) AND "
                    + "CAST('"+date2+"' AS DATE) and tongTien > 0";
            Statement st = con.con.createStatement();
            ResultSet rs = st.executeQuery(sql);     
            HoaDon user;
            while(rs.next()) {
                user = new HoaDon(rs.getString("MaHD"),
                rs.getInt("idBan"), rs.getDate("ngay"), rs.getDouble("tongTien")); 
                UserList.add(user);
            }
                     
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return UserList;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTu = txtTo.getDate();
        Date dateDen = txtDen.getDate();
        String d1 = sdf.format(dateTu);
        String d2 = sdf.format(dateDen);
        DefaultTableModel tblModel = (DefaultTableModel)table_hoadon4.getModel();
        Object[] row = new Object[4];
        tblModel.setRowCount(0);
        
        ArrayList<HoaDon> list = thongKe(d1,d2);
        
        int soHD = 0;
        float tongTien = 0;
        for(int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMaHD();
            row[1] = list.get(i).getIdBan();
            row[2] = list.get(i).getNgay();
            row[3] = list.get(i).getTongTien();
            tblModel.addRow(row);
            soHD = soHD + 1;
            tongTien = (float) (tongTien + list.get(i).getTongTien());
        }
        txtTong.setText(String.valueOf(soHD));
        txtTongTien.setText(String.valueOf(tongTien)+" VNĐ");
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRef;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jLayout;
    private javax.swing.JPanel jLayout1;
    private javax.swing.JPanel jLayout2;
    private javax.swing.JPanel jLayout3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable table_hoadon;
    private javax.swing.JTable table_hoadon1;
    private javax.swing.JTable table_hoadon2;
    private javax.swing.JTable table_hoadon3;
    private javax.swing.JTable table_hoadon4;
    private com.toedter.calendar.JDateChooser txtDen;
    private com.toedter.calendar.JDateChooser txtTo;
    private javax.swing.JLabel txtTong;
    private javax.swing.JLabel txtTongTien;
    // End of variables declaration//GEN-END:variables
}
