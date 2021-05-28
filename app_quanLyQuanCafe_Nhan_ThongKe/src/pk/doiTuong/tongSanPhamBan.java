/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.doiTuong;

/**
 *
 * @author ADMIN
 */
public class tongSanPhamBan {
    private int idMon,soLuong;
    private String tenMon,Ly;
    private double donGia;

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public tongSanPhamBan(int idMon, int soLuong, String tenMon, double donGia,String Ly) {
        this.idMon = idMon;
        this.soLuong = soLuong;
        this.tenMon = tenMon;
        this.donGia = donGia;
        this.Ly = Ly;
    }

    public String getLy() {
        return Ly;
    }

    
    public void setLy(String Ly) {
        this.Ly = Ly;
    }

    public int getIdMon() {
        return idMon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public String getTenMon() {
        return tenMon;
    }


    public void setIdMon(int idMon) {
        this.idMon = idMon;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    
}
