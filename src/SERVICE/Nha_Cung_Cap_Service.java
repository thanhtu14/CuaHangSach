/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICE;

import MODEL.Nha_Cung_Cap_Model;
import DAO.Nha_Cung_Cap_Dao;
import java.util.*;
/**
 *
 * @author tuntt
 */
public class Nha_Cung_Cap_Service {
    private ArrayList<Nha_Cung_Cap_Model> dsncc;
    
    public Nha_Cung_Cap_Service(){
        list();
    }
    
    public void list(){
        Nha_Cung_Cap_Dao nha_Cung_Cap_Dao = new Nha_Cung_Cap_Dao();
        dsncc = new ArrayList<>();
        dsncc = nha_Cung_Cap_Dao.danh_sach_nha_cung_cap();
    }
    
    public ArrayList<Nha_Cung_Cap_Model> getList(){
        return this.dsncc;
    }
    
}
