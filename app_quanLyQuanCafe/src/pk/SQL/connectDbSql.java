/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.SQL;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import pk.doiTuong.taiKhoan;

/**
 *
 * @author ADMIN
 */
public class connectDbSql {
    
    private java.sql.Connection con;
    public  connectDbSql(){
        try {
            String dbUrl = "jdbc:jtds:sqlserver://DESKTOP-1GG0LVP:1433/quanLyQuanCafe";
            con = DriverManager.getConnection(dbUrl, "sa", "1234");
            System.out.println("Thanh CONg");
        } catch (Exception e) {
            
        }
    }
    
    public boolean kiemTraDN(taiKhoan tk)
    {
        boolean check = false;
        String sql;
            sql = "Select * From tblTaiKhoan Where passWords = '"+tk.getPass()+ "'and usename = '"+tk.getUseName()+"'";
            System.out.println(sql);
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                check = true;
                
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi đăng nhập !");
        }
        return check; 
    }
    
        public taiKhoan GetTaiKhoan(String name, String pass){
        taiKhoan td = null;
        String sql;
            sql = "SELECT * FROM tblTaikhoan Where usename = '"+name+"' AND passWords='"+pass+"'";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
               td  = new taiKhoan(rs.getInt(1),rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return td;
    }
public int getCap(taiKhoan tk)
    {
        int lvtk =0;
        String sql;
            sql = "Select capDo From tblTaiKhoan Where usename = '"+tk.getUseName()+"' AND passWords='"+tk.getPass()+"'";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                lvtk = rs.getInt(1);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return lvtk; 
    }    
}
