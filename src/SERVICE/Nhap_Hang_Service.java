/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICE;


import java.util.*;
import MODEL.Nhap_Hang_Model;
import DAO.Nhap_Hang_Dao;

/**
 *
 * @author tuntt
 */
public class Nhap_Hang_Service {
    private ArrayList<Nhap_Hang_Model> dsnh ;
    
    public Nhap_Hang_Service(){
        list();
    }
    
    public void list(){
        Nhap_Hang_Dao nhap_Hang_Dao = new Nhap_Hang_Dao();
        dsnh = new ArrayList<>();
        dsnh = nhap_Hang_Dao.danh_sach_nhap_hang();
    }
    
    public ArrayList<Nhap_Hang_Model> getList(){
        return this.dsnh;
    }
    
    
}
