/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.util.ArrayList;
import MODEL.Don_Hang_Model;
import com.mysql.cj.protocol.Resultset;
/**
 *
 * @author tuntt
 */
public class Don_Hang_Dao {
    private Connection conn;
    
    public Don_Hang_Dao(){
        this.conn = JDBC.getJDBCConnection();
    }
    public ArrayList<Don_Hang_Model> danhsachdonhang(){
        ArrayList<Don_Hang_Model> dsdh = new ArrayList<>();
        String query = " SELECT * "
                + " FROM donhang";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next() ){
                String madh = rs.getString("madonhang");
                String makh = rs.getString("makhachhang");
                String manv = rs.getString("manhanvien");
                String ngaymua = rs.getString("ngaymua");
                double tongtien = rs.getDouble("tongsotien");
                
                Don_Hang_Model dh = new Don_Hang_Model(madh, makh, manv, ngaymua, tongtien);
                dsdh.add(dh);
            }
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return dsdh;
    }
}
