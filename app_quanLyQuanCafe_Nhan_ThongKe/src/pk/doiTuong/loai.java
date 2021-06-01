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
public class loai {
    private int idLoai;
    private String tenLoai;

    public loai(int idLoai, String tenLoai) {
        this.idLoai = idLoai;
        this.tenLoai = tenLoai;
    }

   
    public int getIdLoai() {
        return idLoai;
    }

    public void setIdLoai(int idLoai) {
        this.idLoai = idLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    
    
}