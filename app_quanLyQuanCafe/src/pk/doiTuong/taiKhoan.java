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
public class taiKhoan {
    private int idTK, capDo;
    private String useName, pass;
   
    public static taiKhoan tk;

    public taiKhoan(int idTK, int capDo, String useName, String pass) {
        this.idTK = idTK;
        this.capDo = capDo;
        this.useName = useName;
        this.pass = pass;
    }

    public taiKhoan() {
    }

    
    
    public int getIdTK() {
        return idTK;
    }

    public int getCapDo() {
        return capDo;
    }

    public String getUseName() {
        return useName;
    }

    public String getPass() {
        return pass;
    }

    public void setIdTK(int idTK) {
        this.idTK = idTK;
    }

    public void setCapDo(int capDo) {
        this.capDo = capDo;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
