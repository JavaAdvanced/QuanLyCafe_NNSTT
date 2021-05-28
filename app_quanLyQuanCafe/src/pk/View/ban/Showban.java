/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.View.ban;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pk.SQL.connectDbSql;
import pk.doiTuong.ban;

/**
 *
 * @author Minh Tuan
 */
public class Showban extends javax.swing.JFrame {

    connectDbSql con = new connectDbSql();
    Vector ds = new Vector();//lưu trữ tieu đề cho table
    Vector data = new Vector();//lưu dữ liệu cho table 
    public static Showban qlb;
    /**
     * Creates new form Showban
     */
    public ArrayList<ban> getBan() {
        String sql = "select * from tblBan";
        ArrayList<ban> list = new ArrayList<ban>();
        try {
            PreparedStatement preparedStatement = con.con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            //Duyệt từng phần tử hàng trong bảng, add vào ArrayList list
            while (rs.next()) {
                ban b = new ban(rs.getInt("idBan"), rs.getString("tenBan"), rs.getString("trangThai"));
                list.add(b);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Showban.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Showban() {
        initComponents();
        qlb=this;
        getBan();
        showdata();
        ds.add("idBan");
        ds.add("tenBan");
        ds.add("trangThai");
        jTable2.setModel(new DefaultTableModel(data,ds));
        this.setSize(783, 387);
        
    }
    public void showdata(){
        DefaultTableModel tableModel = new DefaultTableModel();
        Vector column = new Vector();
        column.add("id");
        column.add("ten ban");
        column.add("trang thai");
        
        tableModel.setColumnIdentifiers(column);
        ArrayList<ban> b = getBan();
        for (int i = 0; i < b.size(); i++) {
            ban b2 = b.get(i);// lấy ra từng hàng trong bảng sql, i =0 là hàng 1, i = 1 là hàng 2
            Vector row = new Vector();
            row.add(b2.getIdBan());
            row.add(b2.getTenBan());
            row.add(b2.getTrangThai());
            
            tableModel.addRow(row);
        }
        jTable1.setModel(tableModel);
       
//         
//          data.add(them); jTable1.setModel(new DefaultTableModel(data,ds));
//        String sql = "select * from tblBan";
//        PreparedStatement preparedStatement = con.con.prepareStatement(sql);
//        ResultSet
        /**
         * ds.add("idBan"); ds.add("tenBan"); ds.add("trangThai");
         * jTable1.setModel(new DefaultTableModel(data,ds));//set lại dữ liệu để
         * lưu vào table String query = "SELECT *FROM tblBan";
         *
         *
         * PreparedStatement ps = con.con.prepareStatement(query); ResultSet rs
         * = ps.executeQuery(); while(rs.next()) {
         *
         *
         * String id=rs.getString("idBan"); String tb=rs.getString("tenBan");
         * String tt=rs.getString("trangThai");
         *
         * Vector them=new Vector(); them.add(id); them.add(tb); them.add(tt);
         *
         * data.add(them); jTable1.setModel(new DefaultTableModel(data,ds));
         *
         * }
         */
    }
    public void xoa(){
        ArrayList<ban> b = getBan();
         int i = jTable1.getSelectedRow();
        if (i==-1) {
            JOptionPane.showMessageDialog(null, "chọn dòng xóa"); 
        }
        else
            if (b.size()==0) {
                JOptionPane.showMessageDialog(null, "không có hông tin để xóa"); 
            
        }
            else
            {
                int idb = Integer.parseInt(jTable1.getModel().getValueAt(i, 0).toString());//lấy giá trị ô trong bảng hàng i cột 0
                int n = JOptionPane.showConfirmDialog(jPanel2, "Bạn có muốn xóa bàn "+idb+" không?",  "Thông Báo", JOptionPane.YES_NO_OPTION);
                if(n == JOptionPane.YES_OPTION){
                        
                      try {
                        Statement stmt = con.con.createStatement();
                        stmt.executeUpdate("delete from tblHoaDon where idBan="+idb);
                        stmt.executeUpdate("delete from tblBan where idBan="+idb);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }         
                      getBan();
                      showdata();
                }
                   
              
    }
    }
    public void loc(){
        
        
        try {
            String ban = "select * from tblBan";
            PreparedStatement ps = con.con.prepareStatement(ban); 
         ResultSet rs= ps.executeQuery(); 
         
         while(rs.next()) {
             if (tk.getText().equals(rs.getString("idBan")) || tk.getText().equals(rs.getString("trangthai")) ) {
                 String id=rs.getString("idBan") ;
                 String tb= rs.getString("tenBan");
                 String tt=rs.getString("trangThai");
                 Vector rowVector=new Vector();
                 rowVector.add(id);
                 rowVector.add(tb);
                 rowVector.add(tt);
                 data.add(rowVector);
                 jTable2.setModel(new DefaultTableModel(data,ds));
             }
             
                 
             
          }
        } catch (Exception e) {
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        tk = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(204, 153, 0));

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(46, 46, 46))
        );

        tk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk/iconImages/1.png"))); // NOI18N
        jButton2.setText("Lọc");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 168, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 286, 114));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tk, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tkActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        int n=jTable2.getRowCount();
        while (n!=0) {
            int i = 0;
            data.remove(i);
            jTable2.setModel(new DefaultTableModel(data,ds));
            n=n-1;
        
        }
        
        loc();
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        xoa();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        them tb = new them();
        tb.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField tk;
    // End of variables declaration//GEN-END:variables
}
