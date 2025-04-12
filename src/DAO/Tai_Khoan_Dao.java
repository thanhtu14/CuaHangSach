/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import MODEL.Tai_Khoan_Model;
import java.util.ArrayList;

/**
 *
 * @author tuntt
 */
public class Tai_Khoan_Dao {

    private Connection conn;

    public Tai_Khoan_Dao() {
        this.conn = JDBC.getJDBCConnection();// kết nối database
    }

   public ArrayList<Tai_Khoan_Model> danhsachtaikhoan(){
       ArrayList<Tai_Khoan_Model> dstk = new ArrayList<>();
       String query = "SELECT tk.manhanvien, nv.tennhanvien, tk.matkhau, q.maquyen, q.tenquyen, cn.machucnang, cn.tenchucvu, qcn.xem, qcn.them, qcn.sua, qcn.xoa, qcn.tim"
               + " FROM nhanvien nv "
               + " LEFT JOIN taikhoannhanvien tk ON nv.manhanvien = tk.manhanvien"
               + " LEFT JOIN quyen q ON tk.maquyen = q.maquyen"
               + " LEFT JOIN quyen_chucnang qcn ON q.maquyen = qcn.maquyen"
               + " LEFT JOIN chucnang cn ON qcn.machucnang = cn.machucnang";
       try {
           PreparedStatement stmt = conn.prepareStatement(query);
           ResultSet rs = stmt.executeQuery();
           while(rs.next()){
               String manv = rs.getString("manhanvien");
               String tennv = rs.getString("tennhanvien");
               String mk = rs.getString("matkhau");
               String maq = rs.getString("maquyen");
               String tenq = rs.getString("tenquyen");
               String macn = rs.getString("machucnang");
               String tencn = rs.getString("tenchucvu");
               int xem = rs.getInt("xem");
               int them = rs.getInt("them");
               int sua = rs.getInt("sua");
               int xoa = rs.getInt("xoa");
               int tim = rs.getInt("tim");
               
              Tai_Khoan_Model tk = new Tai_Khoan_Model(manv,tennv,mk,maq,tenq,macn,tencn,xem,them,sua,xoa,tim);
              dstk.add(tk);
           }
           rs.close();
           stmt.close();
           conn.close();
           
       } catch (SQLException ex) {
           ex.printStackTrace();
       }
       
       return dstk;
   }

}
