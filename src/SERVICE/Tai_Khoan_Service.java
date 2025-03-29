/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICE;

import DAO.Tai_Khoan_Dao;
import MODEL.Tai_Khoan_Model;
/**
 *
 * @author tuntt
 */
public class Tai_Khoan_Service {
    private Tai_Khoan_Dao tk_dao  = new Tai_Khoan_Dao();
    
    public String getPassword( String manv){
        Tai_Khoan_Model tk_model = tk_dao.taikhoandangnhap(manv);
        if( tk_model != null){
            return tk_model.getPassword();
        }
        return null;
    }
    public String getMachucvu( String manv){
        Tai_Khoan_Model tk_model = tk_dao.taikhoandangnhap(manv);
        if( tk_model != null){
            return tk_model.getMachucvu();
        }
        return null;
    }
}
