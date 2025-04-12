/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import MODEL.Khach_Hang_Model;
import java.util.ArrayList;

/**
 *
 * @author tuntt
 */
public class Khach_Hang_Dao {

    private Connection conn;
    
    public Khach_Hang_Dao(){
        this.conn = JDBC.getJDBCConnection();
    }

    public ArrayList<Khach_Hang_Model> danhsachkhachhang() {
        ArrayList<Khach_Hang_Model> dskh = new ArrayList<>();
        String query = "SELECT * "
                + " FROM khachhang";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String makh = rs.getString("makhachhang");
                String tenkh = rs.getString("tenkhachhang");
                String gioitinhkh = rs.getString("gioitinhkhachhang");
                String sdtkh = rs.getString("sodienthoai");
                String diachikh = rs.getString("diachikh");
                String emailkh = rs.getString("emailkh");

                Khach_Hang_Model kh = new Khach_Hang_Model(makh, tenkh, gioitinhkh, sdtkh, diachikh, emailkh);
                dskh.add(kh);

            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return dskh;
    }
}
