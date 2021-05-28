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
public class hanghoa {

    private int idMon ;
    private String tenMon;
    private Double donGia;
    private int idLoai;

    public int getIdMon() {
        return idMon;
    }

    public void setIdMon(int idMon) {
        this.idMon = idMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public int getIdLoai() {
        return idLoai;
    }

    public void setIdLoai(int idLoai) {
        this.idLoai = idLoai;
    }

    public hanghoa(int idMon, String tenMon, Double donGia, int idLoai) {
        this.idMon = idMon;
        this.tenMon = tenMon;
        this.donGia = donGia;
        this.idLoai = idLoai;
    }

    public hanghoa() {
    }
    
    

    

    
}
