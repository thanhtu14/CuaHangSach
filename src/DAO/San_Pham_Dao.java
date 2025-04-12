/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.util.ArrayList;
import MODEL.San_Pham_Model;
/**
 *
 * @author tuntt
 */
public class San_Pham_Dao {
     private Connection conn;

    public San_Pham_Dao() {
        this.conn = JDBC.getJDBCConnection();
    }

    public ArrayList<San_Pham_Model> danhsachsanpham() {
        ArrayList<San_Pham_Model> dssp = new ArrayList<>();
        String query = " SELECT s.anhsach, s.masach, s.tensach, tg.tentacgia, tl.tentheloai, s.sotrang, s.giaban, s.soluong "
                + " FROM sach s "
                + " LEFT JOIN sach_tacgia stg ON s.masach = stg.masach "
                + " LEFT JOIN tacgia tg ON stg.matacgia = tg.matacgia "
                + " LEFT JOIN sach_theloai stl ON s.masach = stl.masach "
                + " LEFT JOIN theloai tl ON stl.matheloai = tl.matheloai ";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String anh = rs.getString("anhsach");
                String ma = rs.getString("masach");
                String ten = rs.getString("tensach");
                String tentg= rs.getString("tentacgia");
                String theloai = rs.getString("tentheloai");
                int sotrang = rs.getInt("sotrang");
                double giaban = rs.getDouble("giaban");
                int soluong = rs.getInt("soluong");
               
                San_Pham_Model sp = new San_Pham_Model(anh,ma,ten,tentg,theloai,sotrang,giaban,soluong);
                dssp.add(sp);
                
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return dssp;
    }
}
