/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.ThongKe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import pk.SQL.connectDbSql;
import pk.doiTuong.hanghoa;
import pk.doiTuong.tongSanPhamBan;

public class ThongKeHanghoa extends javax.swing.JPanel {

    public ThongKeHanghoa() {
        initComponents();
        this.setSize(783, 508);
        show_user();
    }
        connectDbSql con = new connectDbSql();
    public ArrayList<tongSanPhamBan> UserList() {
        ArrayList<tongSanPhamBan> UserList = new ArrayList<>();
        try {         
           
            
            String sql = "select top(15) tblChiTietHoaDon.idMon,tenMon,SUM(soLuong) as 'So luong',donGia"
                    + " from tblChiTietHoaDon,tblHangHoa "
                    + "where tblChiTietHoaDon.idMon = tblHangHoa.idMon "
                    + "group by tblChiTietHoaDon.idMon,tenMon,donGia";
            System.out.println(sql);
            Statement st = con.con.createStatement();
            ResultSet rs = st.executeQuery(sql);           
            tongSanPhamBan user;
            while(rs.next()) {
                user = new tongSanPhamBan(rs.getInt(1), rs.getInt(3), rs.getString(2),rs.getDouble(4),"LY");
                UserList.add(user);
            }
                     
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return UserList;
    }
    
    public void show_user() {
        ArrayList<tongSanPhamBan> list = UserList();
        System.out.println(list);
        DefaultTableModel tblModel = (DefaultTableModel)table_hanghoa.getModel();
        Object[] row = new Object[5];
        int slMon = 0;
        for(int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getIdMon();
            row[1] = list.get(i).getTenMon();
            row[2] = list.get(i).getLy();
            row[3] = list.get(i).getSoLuong();
            row[4] = list.get(i).getDonGia()*list.get(i).getSoLuong();
            slMon += list.get(i).getSoLuong();
            tblModel.addRow(row);
        }
        txtTong.setText(String.valueOf(slMon));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_hanghoa = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtTong = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 255), 3, true));

        table_hanghoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Món", "Tên Món", "LY", "Số lượng", "Thành tiền"
            }
        ));
        jScrollPane1.setViewportView(table_hanghoa);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Tổng số món");

        txtTong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtTong.setText("jLabel2");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("THỐNG KÊ THEO MÓN ĐƯỢC BÁN");

        jButton1.setText("REFRESH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtTong))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel2)
                        .addGap(67, 67, 67)
                        .addComponent(jButton1)))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTong))
                .addGap(91, 91, 91))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         DefaultTableModel tblModel = (DefaultTableModel)table_hanghoa.getModel();
        Object[] row = new Object[4];
        tblModel.setRowCount(0);
        show_user();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_hanghoa;
    private javax.swing.JLabel txtTong;
    // End of variables declaration//GEN-END:variables
}
