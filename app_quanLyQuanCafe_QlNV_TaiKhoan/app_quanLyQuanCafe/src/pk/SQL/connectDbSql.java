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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pk.doiTuong.nhanVien;
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

    
public ArrayList<taiKhoan> getByTaiKhoan(int id){
        ArrayList<taiKhoan> arrTaiKhoan = null;
        String sql = "Select * From tblTaiKhoan where idTk = '"+id+"'";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrTaiKhoan = new ArrayList<taiKhoan>();
            while(rs.next()){
                taiKhoan tk = new taiKhoan(rs.getInt(1),rs.getInt(4),rs.getString(2), rs.getString(3));
                arrTaiKhoan.add(tk);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrTaiKhoan; 
    }
public int updateTaiKhoan(taiKhoan tk, int idtk){
        int update = 0;
        String sql = "update tblTaiKhoan set usename = N'"+tk.getUseName()+"',"
                + "passWords= '"+tk.getPass()+"',"
                + "capDo = "+tk.getCapDo()+" where idTk = '"+idtk+"'";
        System.out.println(sql);
        try{
            Statement st = con.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update không thành công !");
        }
        return update;
    }

//NHAN VIEN
public ArrayList<nhanVien> getNhanVien(){
        ArrayList<nhanVien> arrNV = null;
        String sql = "Select * From tblTtNhanVien";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrNV = new ArrayList<nhanVien>();
            while(rs.next()){
                nhanVien kh = new nhanVien(rs.getString(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7));
                arrNV.add(kh);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrNV; 
    }

 public int themNv(nhanVien nv){
        int insert = 0;
        String sql = "insert tblTtNhanVien (tenNv,gioiTinh,SDT,diaChi, caLam,tienLuong)"
                + " values (N'"+nv.getTenNv()+"','"+nv.getGioiTinh()+"','"+nv.getSdt()+"',N'"+nv.getDiaChi()+"',"
                + ""+nv.getCaLam()+","+nv.getTienLuong()+")";
        System.out.println(sql);
        try{
            Statement st = con.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
        }
        return insert;
    }
 public ArrayList<nhanVien> getByNhanVien(String maNV){
        ArrayList<nhanVien> arrNV = null;
        String sql = "Select * From tblTtNhanVien where maNv = '"+maNV+"'";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrNV = new ArrayList<nhanVien>();
            while(rs.next()){
                nhanVien tk = new nhanVien(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7));
                arrNV.add(tk);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrNV; 
    }
 public int suaNV(nhanVien nv, String maNV){
        int update = 0;
        String sql = "update tblTtNhanVien set tenNv = N'"+nv.getTenNv()+"',sdt= '"+nv.getSdt()+"',"
                + "caLam = "+nv.getCaLam()+ ", tienLuong = "+nv.getTienLuong()+","
                + "diaChi = N'"+nv.getDiaChi()+"',gioiTinh = '"+nv.getGioiTinh()+"'"
                + " where maNV = '"+maNV+"'";
        System.out.println(sql);
        try{
            Statement st = con.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update không thành công !");
        }
        return update;
    }
 public boolean xoaNV(String maNV){
        boolean check = false;
        try{
            String sql= "Delete From tblTtNhanVien Where maNV = '"+maNV+"'";
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                System.out.println(sql);
            check = true;
        }catch(SQLException ex){
            
        }
        return check;
    }
}
