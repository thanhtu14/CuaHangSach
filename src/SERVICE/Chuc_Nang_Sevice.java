/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICE;

import MODEL.Chuc_Nang_Model;
import DAO.Chuc_Nang_Dao;
import java.util.*;
/**
 *
 * @author tuntt
 */
public class Chuc_Nang_Sevice {
    private ArrayList<Chuc_Nang_Model> dscn;
    
    public Chuc_Nang_Sevice(){
        list();
    }
    public void list(){
         Chuc_Nang_Dao chuc_Nang_Dao = new Chuc_Nang_Dao();
        dscn = new ArrayList<>();
        dscn = chuc_Nang_Dao.danhsachchucnang();
    }

    public ArrayList<Chuc_Nang_Model> getList() {
        return dscn;
    }
    
    // dùng để lấy ra danh sách các mã chức năng có trong database
    public ArrayList<String> so_luong_chuc_nang(){
        ArrayList< String > slcn = new ArrayList<>();
        for( int i = 0 ; i < dscn.size(); i ++){
            Chuc_Nang_Model cn = dscn.get(i);
            slcn.add(cn.getMachucnang());
        }
        return slcn;
    }
    
}
