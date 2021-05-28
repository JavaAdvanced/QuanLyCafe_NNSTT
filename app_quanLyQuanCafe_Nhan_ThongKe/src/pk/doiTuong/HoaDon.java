/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.doiTuong;

import java.util.Date;

/**
 *
 * @author VanThien
 */
public class HoaDon {

   private String maHD;
   private int idBan;
   private Date ngay = new Date();
   private Double tongTien ;

    public HoaDon(String maHD, int idBan, Date ngay, Double tongTien) {
        this.maHD = maHD;
        this.idBan = idBan;
        this.ngay = ngay;
        this.tongTien = tongTien;
    }

    public HoaDon() {
       
    }

   
   
    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }
   
    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public int getIdBan() {
        return idBan;
    }

    public void setIdBan(int idBan) {
        this.idBan = idBan;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }
   
}
