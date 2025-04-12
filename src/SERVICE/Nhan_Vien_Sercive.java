/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICE;

import MODEL.Nhan_Vien_Model;
import DAO.Nhan_Vien_Dao;
import java.util.*;
/**
 *
 * @author tuntt
 */
public  class Nhan_Vien_Sercive {
    private ArrayList<Nhan_Vien_Model> dsnv;
    
    public Nhan_Vien_Sercive( int i ){
        list();
    }
    public Nhan_Vien_Sercive(){
        list();
    }
    public void list(){
        Nhan_Vien_Dao Nhan_Vien_Dao = new Nhan_Vien_Dao();
        dsnv = new ArrayList<>();
        dsnv = Nhan_Vien_Dao.danhsachnhanvien();
    }
    public ArrayList<Nhan_Vien_Model> getList(){
        return dsnv;
    }
    
   

}
