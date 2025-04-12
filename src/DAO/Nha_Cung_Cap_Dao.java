/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import java.util.*;
import MODEL.Nha_Cung_Cap_Model;

/**
 *
 * @author tuntt
 */
public class Nha_Cung_Cap_Dao {
    private Connection conn;
    
    public Nha_Cung_Cap_Dao(){
        this.conn = JDBC.getJDBCConnection();
        
    }
    
    public ArrayList<Nha_Cung_Cap_Model> danh_sach_nha_cung_cap(){
        ArrayList<Nha_Cung_Cap_Model> dsncc =new ArrayList<>();
        String query = " SELECT * "
                + " FROM nhacungcap ";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            
            while( rs.next()){
                String ma = rs.getString("manhacungcap");
                String ten = rs.getString("tennhacungcap");
                String dc = rs.getString("diachincc");
                String sdt = rs.getString("sodienthoaincc");
                String qg = rs.getString("quocgiancc");
                String email = rs.getString("emailncc");
                
                Nha_Cung_Cap_Model ncc = new Nha_Cung_Cap_Model(ma, ten, dc, sdt, qg, email);
                dsncc.add(ncc);
            }
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return dsncc;
    }
}
