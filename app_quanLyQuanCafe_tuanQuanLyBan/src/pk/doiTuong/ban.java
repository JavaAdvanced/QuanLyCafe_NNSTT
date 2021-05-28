/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.doiTuong;

/**
 *
 * @author Minh Tuan
 */
public class ban {
    private String tenBan,trangThai;
    private int idBan;

    public String getTenBan() {
        return tenBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getIdBan() {
        return idBan;
    }

    public void setIdBan(int idBan) {
        this.idBan = idBan;
    }
    public ban(int idBan,  String tenBan, String trangThai) {
        this.idBan=idBan;
        this.tenBan=tenBan;
        this.trangThai=trangThai;
    }

    public ban(){
        
    }
}
