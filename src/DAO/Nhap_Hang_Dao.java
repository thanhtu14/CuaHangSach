/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.util.*;
import MODEL.Nhap_Hang_Model;

/**
 *
 * @author tuntt
 */
public class Nhap_Hang_Dao {

    private Connection conn;

    public Nhap_Hang_Dao() {
        this.conn = JDBC.getJDBCConnection();
    }

    public ArrayList<Nhap_Hang_Model> danh_sach_nhap_hang() {
        ArrayList<Nhap_Hang_Model> dsnh = new ArrayList<>();
        String query = " SELECT *"
                + " FROM nhaphang";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String manh = rs.getString("manhaphang");
                String mancc = rs.getString("manhacungcap");
                String manv = rs.getString("manhanvien");
                String ngay = rs.getString("ngaynhaphang");
                double tien = rs.getDouble("tongtiennhaphang");

                Nhap_Hang_Model nh = new Nhap_Hang_Model(manh, mancc, manv, ngay, tien);
                dsnh.add(nh);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return dsnh;
    }
}
