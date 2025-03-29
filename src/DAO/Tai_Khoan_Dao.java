/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import MODEL.Tai_Khoan_Model;

/**
 *
 * @author tuntt
 */
public class Tai_Khoan_Dao {

    private Connection conn;

    public Tai_Khoan_Dao() {
        this.conn = JDBC.getJDBCConnection();// kết nối database
    }

    public Tai_Khoan_Model taikhoandangnhap(String manv) {
        String query = " SELECT nv.manhanvien, tknv.matkhau, cv.machucvu "
                + " FROM nhanvien nv "
                + " LEFT JOIN taikhoannhanvien tknv ON nv.manhanvien = tknv.manhanvien"
                + " LEFT JOIN chucvu cv ON nv.machucvu = cv.machucvu"
                + " WHERE nv.manhanvien = ? ";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, manv);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Tai_Khoan_Model(
                        rs.getString("manhanvien"),
                        rs.getString("matkhau"),
                        rs.getString("machucvu")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
