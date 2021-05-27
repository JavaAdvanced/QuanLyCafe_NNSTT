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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pk.doiTuong.ban;
import pk.doiTuong.nhanVien;
import pk.doiTuong.taiKhoan;
import pk.doiTuong.*;
/**
 *
 * @author ADMIN
 */
public class connectDbSql {
    
    public java.sql.Connection con;
    public  connectDbSql(){
        try {
            String dbUrl = "jdbc:jtds:sqlserver://DESKTOP-1D7R3OL:1433/quanLyQuanCafe";
            con = DriverManager.getConnection(dbUrl, "sa", "sa");
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
 
    public ArrayList<nhanVien> timNhanVien(String tenNv){
        ArrayList<nhanVien> arrNV = null;
        String sql;
            sql = "Select * From tblTtNhanVien where tenNv LIKE '"+tenNv+"%'";
            System.out.println(sql);
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrNV = new ArrayList<nhanVien>();
            while(rs.next()){
                nhanVien nv = new nhanVien(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7));
                arrNV.add(nv);
                System.out.println(sql);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrNV;
    } 
    
    //Ban Hang
    public ArrayList<ban> getBanTrong() {
        ArrayList<ban> arrNV = null;
        String sql = "Select * From tblban ";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrNV = new ArrayList<ban>();
            while (rs.next()) {
                ban kh = new ban(rs.getInt(1), rs.getString(3),
                        rs.getString(2));
                arrNV.add(kh);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrNV;
    }
    public ArrayList<ban> getBanbyTrangThai(String trangThai) {
        ArrayList<ban> arrNV = null;
        String sql = "Select * From tblban where trangThai = N'"+trangThai+"'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrNV = new ArrayList<ban>();
            while (rs.next()) {
                ban kh = new ban(rs.getInt(1), rs.getString(3),
                        rs.getString(2));
                arrNV.add(kh);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Bàn trống !");
        }
        return arrNV;
    }
    public ArrayList<hanghoa> getMonbyidLoai(String tenLoai) {
        ArrayList<hanghoa> arrNV = null;
        String sql = "Select * From tblHangHoa as hh , tblLoai as l "
                + "where tenLoai = N'" + tenLoai + "' and  hh.idloai = l.idloai";
        // String sql = "Select * From tblHangHoa";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrNV = new ArrayList<hanghoa>();
            while (rs.next()) {
                hanghoa tk = new hanghoa(rs.getInt(1), rs.getString(2), rs.getDouble(3),
                        rs.getInt(4));
                arrNV.add(tk);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrNV;
    }
    
    public ArrayList<loai> gettableLoai() {
        ArrayList<loai> arr = null;
        String sql = "Select * From tblLoai";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arr = new ArrayList<loai>();
            while (rs.next()) {
                loai tk = new loai(rs.getInt(1), rs.getString(2));
                arr.add(tk);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arr;
    }

    

    public String insertHoaDon(HoaDon hd) {
        String idValue = "";
        String sql = "set DateFormat YMD insert into tblHoaDon(idBan,ngay)"
                + " values (?,?)";
        System.out.println(sql);
        try {
            PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, hd.getIdBan());
            st.setDate(2, new java.sql.Date(hd.getNgay().getTime()));
            int insert = st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                idValue = rs.getString(1);
            }

            // Giá trị của ID (Vị trí 1 theo thiết kế của bảng)
            System.out.println("ID value: " + idValue);
            return idValue;

        } catch (SQLException ex) {
            return null;

        }

    }

   

    public void updateTrangThaiban(String idBan,String TrangThai) {

        String sql = "update tblban set trangThai = ? where idBan = ?";
        try {
             PreparedStatement st = con.prepareStatement(sql);
              st.setString(1, TrangThai);
              st.setString(2, idBan);
              st.executeUpdate();
            System.out.println(sql +idBan +TrangThai );
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update không thành công !");
        }

    }

    public String FindHoaDonByban(String idban) //tìm mã hóa đơn lớn nhát theo bàn
    {
        String idHD = "";
        String sql = "SELECT maHD, MAX(RIGHT(maHD, 3)) FROM tblHoaDon"
                + "	group by maHD"
                + "	having MAX(RIGHT(maHD, 3)) in (SELECT distinct  top(1) MAX(RIGHT(maHD, 3)) FROM tblHoaDon"
                + "	where idban = '" + idban + "')";
        
        try {
          Statement  st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            idHD = rs.getString(1);

        } catch (SQLException ex) {
            Logger.getLogger(connectDbSql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idHD;
    }

    public void insertChiTietHoaDon(ChitietHoaDon hd) {
        String sql = "insert  tblChiTietHoaDon(maHD,idMon,soLuong,maGiamGia,thanhTien)"
                + "values(?,?,?,?,?)";

        System.out.println(sql);
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, hd.getMaHD());
            st.setInt(2, hd.getIdMon());
            st.setInt(3, hd.getSoLuong());
            st.setDouble(4, hd.getMaGiamGia());
            st.setDouble(5, hd.getThanhTien());
            st.executeUpdate();
            System.out.println("đang insert");
       

    }   catch (SQLException ex) {
            Logger.getLogger(connectDbSql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void UpdatesoLuongMon(ChitietHoaDon hd) {
        String sql = "update tblChitietHoaDon set soLuong = soLuong + ?  where "
                + "maHD = ? and idMon =  ?";

        System.out.println(sql);
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, hd.getSoLuong());
            st.setString(2, hd.getMaHD());
            st.setInt(3, hd.getIdMon());
            st.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update không thành công !");
        }
    }
    public void UpdChuyenBan(String maHD ,int ban2) {
        String sql = "update tblHoaDon set idBan =  ?  where "
                + "maHD = ? ";

        System.out.println(sql);
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, ban2);
            st.setString(2, maHD);
            st.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update không thành công !");
        }
    }
    public void UpdatetienHoaDon(String maHD, String TongTien) {
        String sql = "update tblHoaDon set TongTien =  ?  where "
                + "maHD = ? ";

        System.out.println(sql);
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, TongTien);
            st.setString(2, maHD);
            st.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update không thành công !");
        }
    }
    public void UpdateChiTietHoaDon(ChitietHoaDon hd) {
        String sql = "update tblChitietHoaDon set soLuong =  ? ,MaGiamGia = ? ,ThanhTien = ? "
                + "where "
                + "maHD = ? and idMon =  ?";

        
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, hd.getSoLuong());
            st.setDouble(2, hd.getMaGiamGia());
            st.setDouble(3, hd.getThanhTien());
            st.setString(4, hd.getMaHD());
            st.setInt(5, hd.getIdMon());
            st.executeUpdate();
            System.out.println("mã giam gia :" +hd.getMaGiamGia());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update không thành công !");
        }
    }
    
    public void KtraTonTaiMon(ChitietHoaDon hd) {
        String sql = "select * from tblChiTietHoaDon as ct "
                + "where maHD = ? and  idMon=?";

        try {
            System.out.println("Đang kiểm tra : ");
            PreparedStatement st;

            st = con.prepareStatement(sql);

            st.setString(1, hd.getMaHD());
            st.setInt(2, hd.getIdMon());

            ResultSet rs = st.executeQuery();
 
                if (rs.next())
                    UpdatesoLuongMon(hd);
                    
                else {

                    insertChiTietHoaDon(hd);
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(connectDbSql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<ChitietHoaDon> gettableChiTietHoaDon(String idHD) {
        ArrayList<ChitietHoaDon> arr = new ArrayList<ChitietHoaDon>();

        try {
            String sql = "Select * From tblChitietHoaDon as ct , tblhanghoa as hh"
                    + " where maHD = ? and ct.idMon = hh.idmon";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, idHD);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                ChitietHoaDon ct = new ChitietHoaDon();
                ct.setMaHD(rs.getString("MaHD"));
                ct.setIdMon(rs.getInt("IdMon"));
                ct.setSoLuong(rs.getInt("SoLuong"));
                ct.setMaGiamGia(rs.getInt("MaGiamGia"));
                ct.setThanhTien(rs.getDouble("ThanhTien"));
                ct.setTenMon(rs.getString("tenMon"));
                arr.add(ct);

            }
            return arr;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " loi : gettableChiTietHoaDoni !");
        }
        return arr;
    }
        public ArrayList<ChitietHoaDon> getHoaDonCuoi(String idHD) {
        ArrayList<ChitietHoaDon> arr = new ArrayList<ChitietHoaDon>();

        try {
            String sql = "Select * From tblChitietHoaDon as ct , tblhanghoa as hh"
                    + " where maHD = ? and ct.idMon = hh.idmon";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, idHD);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                ChitietHoaDon ct = new ChitietHoaDon();
                ct.setMaHD(rs.getString("MaHD"));
                ct.setIdMon(rs.getInt("IdMon"));
                ct.setSoLuong(rs.getInt("SoLuong"));
                ct.setMaGiamGia(rs.getInt("MaGiamGia"));
                ct.setThanhTien(rs.getDouble("ThanhTien"));
                ct.setTenMon(rs.getString("tenMon"));
                arr.add(ct);

            }
            return arr;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " loi : gettableChiTietHoaDoni !");
        }
        return arr;
    }

   
    



}
