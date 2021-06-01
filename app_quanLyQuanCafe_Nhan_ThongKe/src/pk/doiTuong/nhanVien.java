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
public class nhanVien {
    
    private String maNV,tenNv ,gioiTinh,Sdt,diaChi;
    private int caLam,tienLuong;

    public String getMaNV() {
        return maNV;
    }

    public String getTenNv() {
        return tenNv;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getSdt() {
        return Sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public int getCaLam() {
        return caLam;
    }

    public int getTienLuong() {
        return tienLuong;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setCaLam(int caLam) {
        this.caLam = caLam;
    }

    public void setTienLuong(int tienLuong) {
        this.tienLuong = tienLuong;
    }

    public nhanVien(String maNV, String tenNv, String gioiTinh, String Sdt, String diaChi, int caLam, int tienLuong) {
        this.maNV = maNV;
        this.tenNv = tenNv;
        this.gioiTinh = gioiTinh;
        this.Sdt = Sdt;
        this.diaChi = diaChi;
        this.caLam = caLam;
        this.tienLuong = tienLuong;
    }

    public nhanVien() {
    }
    
    
    
    
}
