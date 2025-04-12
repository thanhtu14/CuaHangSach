/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.util.ArrayList;
import MODEL.Nhan_Vien_Model;

/**
 *
 * @author tuntt
 */
public class Nhan_Vien_Dao {

    private Connection conn;

    public Nhan_Vien_Dao() {
        this.conn = JDBC.getJDBCConnection();
    }

    public ArrayList<Nhan_Vien_Model> danhsachnhanvien() {
        ArrayList<Nhan_Vien_Model> dsnv = new ArrayList<>();
        String query = " SELECT nv.anhnhanvien, nv.manhanvien, nv.tennhanvien, nv.gioitinhnhanvien, nv.ngaysinhnhanvien, nv.sodienthoai, nv.diachinv, nv.emailnv, nv.ngayvaolam, nv.luong, cv.tenchucvu" 
                    + " FROM nhanvien nv "
                    + " LEFT JOIN chucvu cv ON nv.machucvu = cv.machucvu ";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String anhnv = rs.getString("anhnhanvien");
                String manv = rs.getString("manhanvien");
                String tennv = rs.getString("tennhanvien");
                String gioitinhnv = rs.getString("gioitinhnhanvien");
                String ngaysinhnv = rs.getString("ngaysinhnhanvien");
                String sdtnv = rs.getString("sodienthoai");
                String diachinv = rs.getString("diachinv");
                String emailnv = rs.getString("emailnv");
                String ngayvaolamnv = rs.getString("ngayvaolam");
                double luongnv = rs.getDouble("luong");
                String machucvunv = rs.getString("tenchucvu");

                Nhan_Vien_Model nv = new Nhan_Vien_Model(anhnv, manv, tennv, gioitinhnv, ngaysinhnv, sdtnv, diachinv, emailnv, ngayvaolamnv, luongnv, machucvunv);
                dsnv.add(nv);
                
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return dsnv;
    }
}
