/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pk.View.nhanVien;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pk.SQL.connectDbSql;
import pk.View.trangChinh;
import pk.doiTuong.nhanVien;

/**
 *
 * @author ADMIN
 */
public class showNhanVien extends javax.swing.JPanel {

    /** Creates new form showNhanVien */
    public static showNhanVien nvs;
    public showNhanVien() {
        nvs = this;
        initComponents();
        this.setSize(850, 511);
        showTableNV();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTimKiem = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblList = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        timKiem = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204), 3));

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTimKiem.setText("THÔNG TIN NHÂN VIÊN");

        tblList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblList.setRowHeight(30);
        tblList.setRowMargin(5);
        jScrollPane1.setViewportView(tblList);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("THÊM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("SỬA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("XÓA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        timKiem.setText("Tìm kiếm");
        timKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timKiemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(txtTimKiem)
                .addContainerGap(363, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(txtTimKiem)
                .addGap(18, 18, 18)
                .addComponent(timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                        .addContainerGap(175, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    connectDbSql con = new connectDbSql();
    public void showTableNV() {
        ArrayList<nhanVien> arrTable = con.getNhanVien();
        DefaultTableModel tbmodel = new DefaultTableModel();

        tbmodel.addColumn("MANV");
        tbmodel.addColumn("TÊN NV");
        tbmodel.addColumn("GIỚI TÍNH");
        tbmodel.addColumn("SĐT");
        tbmodel.addColumn("ĐỊA CHỈ");
        tbmodel.addColumn("CA");
        tbmodel.addColumn("LƯƠNG");
        if (arrTable != null) {
            int sotk = 0;
            for (nhanVien l : arrTable) {
                sotk++;
                tbmodel.addRow(new Object[]{l.getMaNV(),l.getTenNv(),l.getGioiTinh(),l.getSdt(),
                l.getDiaChi(),l.getCaLam(),l.getTienLuong()});
            }
        } else {
            JOptionPane.showMessageDialog(null, "Không có tài khoản nào");
        }
        tblList.setModel(tbmodel);
        for(int i = 0; i < tblList.getColumnCount();i++){
            Class<?> col = tblList.getColumnClass(i);
            tblList.setDefaultEditor(col, null);
        }        
    }
    private void timKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timKiemMouseClicked
        // TODO add your handling code here:
        timKiem.setText("");
    }//GEN-LAST:event_timKiemMouseClicked

    trangChinh tc;
    public static int them,sua;
    public static String maNV;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        them = 2;
        System.out.println("SHOW" + them);
        themSuaNhanVien  themNV = new themSuaNhanVien(tc, true);
        themNV.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        sua = 3;
        int select=tblList.getSelectedRow();
                if(select<0){
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn !");
                }else{
                    maNV = (String) tblList.getValueAt(select, 0);
                    System.out.println(maNV);
                    themSuaNhanVien s = new themSuaNhanVien(tc, true,maNV);
                    s.setVisible(true);
                }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int[] selectedRows = tblList.getSelectedRows();
        if (selectedRows.length <= 0) {
            JOptionPane.showMessageDialog(null, "Bạn chưa tài khoản nào!");
        } else {
            ArrayList<String> listNv = new ArrayList<String>();
            String NV = "";
            for (int i : selectedRows) {
                maNV = (String) tblList.getValueAt(i, 0);
                listNv.add(maNV);
                System.out.println(maNV);
                String tenNV = (String) tblList.getValueAt(i, 1);

                NV += tenNV + "\n";
            }
            int qs;
            qs = JOptionPane.showConfirmDialog(null, "Xóa Nhân Viên: \n " + NV, "Xóa", JOptionPane.YES_NO_OPTION);
            if (qs == JOptionPane.YES_OPTION) {
                boolean xoa = con.xoaNV(maNV);
                System.out.println(xoa);
                if (xoa == true) {
                    showNhanVien.nvs.showTableNV();
                    showNhanVien.nvs.updateUI();
                    try{
                    }catch(Exception e){

                    }
                }else
                    JOptionPane.showMessageDialog(null, "Không xóa đưowjc NV !");
            }}
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblList;
    private javax.swing.JTextField timKiem;
    private javax.swing.JLabel txtTimKiem;
    // End of variables declaration//GEN-END:variables

}
