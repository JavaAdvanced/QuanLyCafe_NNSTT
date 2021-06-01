/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.doiTuong;

/**
 *
 * @author VanThien
 */
public class ChitietHoaDon {

   
  

    public ChitietHoaDon(String maHD, int idMon, int soLuong, double maGiamGia, double thanhTien) {
        this.maHD = maHD;
        this.idMon = idMon;
        this.soLuong = soLuong;
        this.maGiamGia = maGiamGia;
        this.thanhTien = thanhTien;
    }
    private String maHD;
    private String tenMon;
    private int idMon;
    private int soLuong;
    private double maGiamGia;
    private double thanhTien;

    public ChitietHoaDon() {
    }

    
    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getIdMon() {
        return idMon;
    }

    public void setIdMon(int idMon) {
        this.idMon = idMon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getMaGiamGia() {
        return maGiamGia;
    }

    public void setMaGiamGia(double maGiamGia) {
        this.maGiamGia = maGiamGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

}