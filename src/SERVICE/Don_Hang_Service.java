/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICE;

import MODEL.Don_Hang_Model;
import DAO.Don_Hang_Dao;
import java.util.*;

/**
 *
 * @author tuntt
 */
public class Don_Hang_Service {
    private ArrayList<Don_Hang_Model> dsdh;
    
    public Don_Hang_Service( int i){
        list();
    }
    public Don_Hang_Service(){
        list();
    }
    public void list(){
        Don_Hang_Dao dh = new Don_Hang_Dao();
        dsdh = new ArrayList<Don_Hang_Model>();
        dsdh = dh.danhsachdonhang();
    }
    public ArrayList<Don_Hang_Model> getList(){
        return dsdh;
    }
    
}
