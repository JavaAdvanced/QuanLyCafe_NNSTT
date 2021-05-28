/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.SQL;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pk.doiTuong.taiKhoan;

/**
 *
 * @author ADMIN
 */
public class connectDbSql {
    
    public java.sql.Connection con;
    public  connectDbSql(){
        try {
            String dbUrl = "jdbc:jtds:sqlserver://DESKTOP-14TH4JD:1433/thayhuy";
            con = DriverManager.getConnection(dbUrl, "tuan", "tuan25");
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
            System.out.println(sql);
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
     
    public ArrayList<taiKhoan> getAllTaiKhoan(){
        ArrayList<taiKhoan> arrtaiKhoan = null;
        String sql = "Select * From tblTaiKhoan";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtaiKhoan = new ArrayList<taiKhoan>();
            while(rs.next()){
                taiKhoan kh = new taiKhoan(rs.getInt(1),rs.getInt(4), rs.getString(2),rs.getString(3));
                arrtaiKhoan.add(kh);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrtaiKhoan; 
    }
 public int insertTaiKhoan(taiKhoan tk){
        int insert = 0;
        String sql = "insert tblTaiKhoan(usename,passWords, capDo)"
                + " values ('"+tk.getUseName()+"',"
                + " N'"+tk.getPass()+"', '"+tk.getCapDo()+"')";
        System.out.println(sql);
        try{
            Statement st = con.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
        }
        return insert;
    }
public boolean xoaTaiKhoan(int idtk){
        boolean check = false;
        try{
            String sql= "Delete From tblTaiKhoan Where idTk = '"+idtk+"'";
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                System.out.println(sql);
            check = true;
        }catch(SQLException ex){
            
        }
        return check;
    }

   
    
}
