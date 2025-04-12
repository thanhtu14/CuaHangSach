/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import MODEL.Quyen_Model;
import java.sql.*;
import java.util.ArrayList;
 /**
 *
 * @author tuntt
 */
public class Quyen_Dao {
    private Connection conn;
    
    public Quyen_Dao(){
        this.conn = JDBC.getJDBCConnection();
    }
    
    public ArrayList<Quyen_Model> danhsachquyen() {
        ArrayList<Quyen_Model> dsq = new ArrayList<>();
        String query = " SELECT * "
                + " FROM quyen  ";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("maquyen");
                String ten = rs.getString("tenquyen");

                Quyen_Model q = new Quyen_Model(ma, ten);
                dsq.add(q);
                
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return dsq;
    }
}
