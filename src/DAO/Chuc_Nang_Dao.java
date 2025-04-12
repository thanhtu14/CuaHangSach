/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import MODEL.Chuc_Nang_Model;
import java.util.ArrayList;
import java.sql.*;
/**
 * 
 *
 * @author tuntt
 */
public class Chuc_Nang_Dao {
    private Connection conn;
    
    public Chuc_Nang_Dao(){
        this.conn = JDBC.getJDBCConnection();
    }
    public ArrayList<Chuc_Nang_Model> danhsachchucnang() {
        ArrayList<Chuc_Nang_Model> dscn = new ArrayList<>();
        String query = " SELECT * "
                + " FROM chucnang  ";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("machucnang");
                String ten = rs.getString("tenchucvu");

                Chuc_Nang_Model cn = new Chuc_Nang_Model(ma, ten);
                dscn.add(cn);
                
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return dscn;
    }
}
