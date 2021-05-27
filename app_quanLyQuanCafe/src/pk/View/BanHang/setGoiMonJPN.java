/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.View.BanHang;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;

import javax.swing.JOptionPane;

import javax.swing.JTable;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import javax.swing.table.DefaultTableModel;
import pk.SQL.connectDbSql;
import pk.doiTuong.ChitietHoaDon;

import pk.doiTuong.HoaDon;
import pk.doiTuong.ban;
import pk.doiTuong.hanghoa;
import pk.doiTuong.loai;

/**
 *
 * @author VanThien
 */
public class setGoiMonJPN extends javax.swing.JPanel {

    /**
     * Creates new form setGoiMonJPN
     */
    public setGoiMonJPN() {
        initComponents();
        this.setSize(850, 511);
        jpnChonMon.setSize(460, 600);
        setValuedefault();
        settableList();
        showTableNV();
        setComboLoai();
    }
    connectDbSql con = new connectDbSql();

    public void setValuedefault() {
        jpnList.hide();
        jpnChonMon.hide();
        jlbBan.setText("0");
        txtSoLuong.setText("1");
        jlbMonSelect.setText("");
        btnXacNhanMon.setEnabled(false);
    }
    DefaultTableModel tbmodel = new DefaultTableModel();
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel moDelmonDagChon = new DefaultTableModel();

    public void settableList() {
        //  model.addColumn("id Món");
        model.addColumn("Món");
        model.addColumn("Số Lượng");
        model.addColumn("Thành Tiền ");
        tableList.setModel(model);
        moDelmonDagChon.addColumn("id Món");
        moDelmonDagChon.addColumn("Món");
        moDelmonDagChon.addColumn("Số Lượng");
        moDelmonDagChon.addColumn("");
        jtbMonDangChon.setModel(moDelmonDagChon);

        tbmodel.addColumn("STT");
        tbmodel.addColumn("TÊN BÀN");
        tbmodel.addColumn("TRẠNG THÁI");
    }

    public void showTableNV() {

        ArrayList<ban> arrTable = con.getBanTrong();

        tbmodel.setRowCount(0);
        if (arrTable != null) {

            for (ban l : arrTable) {

                tbmodel.addRow(new Object[]{String.valueOf(l.getIdBan()), l.getTenBan(), l.getTrangThai()});
            }
        } else {
            JOptionPane.showMessageDialog(null, "Không có bàn nào");
        }
        jtableBan.setModel(tbmodel);
        jtableBan.setSelectionMode(SINGLE_SELECTION); // Chỉ cho chọn 1 hàng

    }

    public void settablemonDagChon(ChitietHoaDon l) {
        //moDelmonDagChon.setRowCount(0);

        moDelmonDagChon.addRow(new Object[]{l.getIdMon(), l.getTenMon(), l.getSoLuong(), "delete"});
        Action delete = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtbMonDangChon = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());

                ((DefaultTableModel) jtbMonDangChon.getModel()).removeRow(modelRow);
            }
        };
        ButtonColumn buttonColumn = new ButtonColumn(jtbMonDangChon, delete, 3);
        buttonColumn.setMnemonic(KeyEvent.VK_D);
    }

    public void setTableMon() {

        String tenLoai = comboLoai.getSelectedItem().toString();
        ArrayList<hanghoa> arrTable = con.getMonbyidLoai(tenLoai);
        DefaultTableModel tbmodel = new DefaultTableModel();

        tbmodel.addColumn("MÃ MÓN");
        tbmodel.addColumn("TÊN MÓN");
        tbmodel.addColumn("ĐƠN GIÁ");
        if (arrTable != null) {

            for (hanghoa l : arrTable) {

                tbmodel.addRow(new Object[]{String.valueOf(l.getIdMon()), l.getTenMon(), l.getDonGia()});
            }
        } else {
            JOptionPane.showMessageDialog(null, "Không có món nào");
        }
        jtableMon.setModel(tbmodel);
        jtableMon.setSelectionMode(SINGLE_SELECTION); // Chỉ cho chọn 1 hàng

    }

    public void setComboLoai() {
        //comboLoai.removeAllItems();
        ArrayList<loai> l = new ArrayList<>();
        l = con.gettableLoai();

        for (loai i : l) {
            comboLoai.addItem(i.getTenLoai());
        }
    }

    public void insertMontoDABASE() {

        String idBan = jlbBan.getText();
        String idHD = con.FindHoaDonByban(idBan);
        int i = 0;
        for (i = 0; i < jtbMonDangChon.getRowCount(); i++) {
            String idMon = (String.valueOf(jtbMonDangChon.getValueAt(i, 0)));
            String tenMon = (String.valueOf(jtbMonDangChon.getValueAt(i, 1)));
            String soLuong = (String.valueOf(jtbMonDangChon.getValueAt(i, 2)));

            ChitietHoaDon ct = new ChitietHoaDon();
            ct.setMaHD(idHD);
            ct.setIdMon(Integer.valueOf(idMon));
            ct.setSoLuong(Integer.valueOf(soLuong));
            ct.setTenMon(tenMon);
            System.out.println(" mahoaDon : " + ct.getMaHD() + " ten mon : " + ct.getTenMon() + " Số lượng : " + ct.getSoLuong());
            con.KtraTonTaiMon(ct);
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

        jDialog = new javax.swing.JDialog();
        btnXacNhanSoLuong = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jlbMonSelect = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jpnChonMon = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboLoai = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtableMon = new javax.swing.JTable();
        jpnList = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jlbBan = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableList = new javax.swing.JTable();
        btnXacNhanMon = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtbMonDangChon = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jpnChonBan = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableBan = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jDialog.setTitle("Nhập Số Lượng : ");
        jDialog.setLocation(new java.awt.Point(300, 380));
        jDialog.setMinimumSize(new java.awt.Dimension(253, 198));
        jDialog.setModal(true);

        btnXacNhanSoLuong.setText("Xác Nhận");
        btnXacNhanSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanSoLuongActionPerformed(evt);
            }
        });

        jLabel7.setText(" Món : ");

        jlbMonSelect.setText("món");

        jLabel9.setText("Số Lượng");

        txtSoLuong.setText("jTextField1");

        jButton2.setText("Hủy");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogLayout = new javax.swing.GroupLayout(jDialog.getContentPane());
        jDialog.getContentPane().setLayout(jDialogLayout);
        jDialogLayout.setHorizontalGroup(
            jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogLayout.createSequentialGroup()
                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlbMonSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)))
                    .addGroup(jDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnXacNhanSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jDialogLayout.setVerticalGroup(
            jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbMonSelect)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(28, 28, 28)
                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhanSoLuong)
                    .addComponent(jButton2))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(255, 255, 255));

        jpnChonMon.setBackground(new java.awt.Color(255, 255, 255));
        jpnChonMon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpnChonMon.setMaximumSize(new java.awt.Dimension(10000, 32767));
        jpnChonMon.setMinimumSize(new java.awt.Dimension(200, 252));

        jLabel2.setText("Chọn Loại : ");

        comboLoai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboLoaiItemStateChanged(evt);
            }
        });
        comboLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboLoaiMouseClicked(evt);
            }
        });
        comboLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboLoaiActionPerformed(evt);
            }
        });

        jLabel3.setText("Chọn món  : ");

        jtableMon.setModel(new javax.swing.table.DefaultTableModel(
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
        jtableMon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableMonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtableMon);

        javax.swing.GroupLayout jpnChonMonLayout = new javax.swing.GroupLayout(jpnChonMon);
        jpnChonMon.setLayout(jpnChonMonLayout);
        jpnChonMonLayout.setHorizontalGroup(
            jpnChonMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnChonMonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnChonMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnChonMonLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(comboLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnChonMonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jpnChonMonLayout.setVerticalGroup(
            jpnChonMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnChonMonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnChonMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(comboLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnList.setBackground(new java.awt.Color(255, 255, 255));
        jpnList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Bàn Số :  ");

        jlbBan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlbBan.setText("jLabel6");

        tableList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Món", "Số lượng", ""
            }
        ));
        jScrollPane3.setViewportView(tableList);

        btnXacNhanMon.setText("Bổ Xung");
        btnXacNhanMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanMonActionPerformed(evt);
            }
        });

        jButton3.setText("Làm Mới");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jtbMonDangChon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Món", "Số lượng", ""
            }
        ));
        jScrollPane4.setViewportView(jtbMonDangChon);

        jLabel8.setText("Món đã gọi : ");

        jLabel10.setText("Bổ xung : ");

        javax.swing.GroupLayout jpnListLayout = new javax.swing.GroupLayout(jpnList);
        jpnList.setLayout(jpnListLayout);
        jpnListLayout.setHorizontalGroup(
            jpnListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jpnListLayout.createSequentialGroup()
                        .addGroup(jpnListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addGroup(jpnListLayout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(jLabel5)
                                .addGap(20, 20, 20)
                                .addComponent(jlbBan))
                            .addGroup(jpnListLayout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(btnXacNhanMon)
                                .addGap(47, 47, 47)
                                .addComponent(jButton3)))
                        .addGap(0, 129, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpnListLayout.setVerticalGroup(
            jpnListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnListLayout.createSequentialGroup()
                .addGroup(jpnListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbBan)
                    .addComponent(jLabel5))
                .addGap(2, 2, 2)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGroup(jpnListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnListLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnListLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(jpnListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXacNhanMon)
                            .addComponent(jButton3))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnChonBan.setBackground(new java.awt.Color(255, 255, 255));
        jpnChonBan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jtableBan.setModel(new javax.swing.table.DefaultTableModel(
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
        jtableBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableBanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtableBan);

        jLabel1.setText("Chọn bàn : ");

        javax.swing.GroupLayout jpnChonBanLayout = new javax.swing.GroupLayout(jpnChonBan);
        jpnChonBan.setLayout(jpnChonBanLayout);
        jpnChonBanLayout.setHorizontalGroup(
            jpnChonBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnChonBanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnChonBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnChonBanLayout.setVerticalGroup(
            jpnChonBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnChonBanLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpnChonMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnChonBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(430, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpnList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpnChonBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jpnChonMon, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(335, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboLoaiActionPerformed
        // TODO add your handling code here:
        //  setTableMon();
    }//GEN-LAST:event_comboLoaiActionPerformed

    private void comboLoaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboLoaiItemStateChanged
        // TODO add your handling code here:
        setTableMon();
    }//GEN-LAST:event_comboLoaiItemStateChanged

    private void comboLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboLoaiMouseClicked
        // TODO add your handling code here:
        setTableMon();
    }//GEN-LAST:event_comboLoaiMouseClicked

    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/DD");  // định dạng 
    Date date = new Date();  // Lấy ngày hiện tại 
    HoaDon h = new HoaDon();

    public static String maHD;
    int maMon;
    private void jtableBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableBanMouseClicked
        //CTHD = new ArrayList<>(); // Tạo Mảng mới chứa danh sách món cho bàn mới 

        int i = jtableBan.getSelectedRow();
        String trangThai = jtableBan.getValueAt(i, 2).toString().trim();

        int ban = Integer.valueOf(jtableBan.getValueAt(i, 0).toString().trim());
        jlbBan.setText(String.valueOf(ban));

        if (trangThai.equals("Trống")) {
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn muốn" + " đặt bàn này ?");

            if (confirm == JOptionPane.YES_OPTION) {
                model.setRowCount(0);
                System.out.println(dateFormat.format(date));
                jpnChonMon.setVisible(true);
                h.setIdBan(ban);
                Date date1 = null;
                try {
                    date1 = new SimpleDateFormat("yyyy/MM/DD").parse(dateFormat.format(date));
                } catch (ParseException ex) {
                    Logger.getLogger(setGoiMonJPN.class.getName()).log(Level.SEVERE, null, ex);
                }
                h.setNgay(date1);
                con.insertHoaDon(h);
                maHD = con.FindHoaDonByban(String.valueOf(ban)); // Lấy mã hóa đơn bằng idBan
                con.updateTrangThaiban(String.valueOf(ban), "Đã có");
                showTableNV(); // update lại trạng thái bàn 
                model.setRowCount(0);
                setListMontheoBan(maHD);
            }
        } else {

            int confirm = JOptionPane.showConfirmDialog(this, "Gọi thêm món "
                    + " cho bàn này ?");
            if (confirm == JOptionPane.YES_OPTION) {
                jpnChonMon.setVisible(true);
                maHD = con.FindHoaDonByban(String.valueOf(ban));
                System.out.println("ma hoa don tim dc la : " + maHD);
                setListMontheoBan(maHD);
            }
        }

    }//GEN-LAST:event_jtableBanMouseClicked

    private void jtableMonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableMonMouseClicked
        // TODO add your handling code here:
        int rowSelect = jtableMon.getSelectedRow();
        String tenMon = (String) jtableMon.getValueAt(rowSelect, 1);
        maMon = Integer.valueOf(jtableMon.getModel().getValueAt(rowSelect, 0).toString().trim());
        jlbMonSelect.setText(tenMon);
        jDialog.setVisible(true);
        System.out.println(tenMon);


    }//GEN-LAST:event_jtableMonMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jDialog.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    public static ArrayList<ChitietHoaDon> CTHD;

    private void btnXacNhanSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanSoLuongActionPerformed
        ChitietHoaDon ct;
        ct = new ChitietHoaDon();
        ct.setMaHD(maHD);
        ct.setSoLuong(Integer.valueOf(txtSoLuong.getText()));
        ct.setTenMon(jlbMonSelect.getText());
        ct.setIdMon(maMon);
        settablemonDagChon(ct); // Hiển thị danh sách món đang chọn

        btnXacNhanMon.setEnabled(true);
        jpnList.setVisible(true);
        jDialog.dispose();
    }//GEN-LAST:event_btnXacNhanSoLuongActionPerformed

    public void setListMontheoBan(String idHD) {
        model.setRowCount(0);
        ArrayList<ChitietHoaDon> DsmonTheoban = new ArrayList<>();
        DsmonTheoban = con.gettableChiTietHoaDon(idHD);
        for (ChitietHoaDon l : DsmonTheoban) {

            // model.addRow(new Object[]{l.getIdMon(),l.getTenMon(), l.getSoLuong()});
            model.addRow(new Object[]{l.getTenMon(), l.getSoLuong(), l.getThanhTien()});
        }

    }
    private void btnXacNhanMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanMonActionPerformed

        insertMontoDABASE();// insert vào database  
        btnXacNhanMon.setEnabled(false);
        setListMontheoBan(maHD);
        moDelmonDagChon.setRowCount(0);


    }//GEN-LAST:event_btnXacNhanMonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        btnXacNhanMon.setEnabled(false);
        setListMontheoBan(maHD);
        showTableNV();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXacNhanMon;
    private javax.swing.JButton btnXacNhanSoLuong;
    private javax.swing.JComboBox<String> comboLoai;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JDialog jDialog;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel jlbBan;
    private javax.swing.JLabel jlbMonSelect;
    private javax.swing.JPanel jpnChonBan;
    private javax.swing.JPanel jpnChonMon;
    private javax.swing.JPanel jpnList;
    private javax.swing.JTable jtableBan;
    private javax.swing.JTable jtableMon;
    private javax.swing.JTable jtbMonDangChon;
    private javax.swing.JTable tableList;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
