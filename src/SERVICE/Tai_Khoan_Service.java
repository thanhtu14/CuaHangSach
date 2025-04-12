/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICE;

import DAO.Tai_Khoan_Dao;
import MODEL.Tai_Khoan_Model;
import java.util.ArrayList;

/**
 *
 * @author tuntt
 */
public class Tai_Khoan_Service {

    private ArrayList<Tai_Khoan_Model> dstk;

    public Tai_Khoan_Service(int i) {
        list();
    }

    public Tai_Khoan_Service() {
        list();
    }

    public void list() {
        Tai_Khoan_Dao tai_Khoan_Dao = new Tai_Khoan_Dao();
        dstk = new ArrayList<>();
        dstk = tai_Khoan_Dao.danhsachtaikhoan();
    }

    public ArrayList<Tai_Khoan_Model> getList() {
        return dstk;
    }

    public boolean kiem_tra_mat_khau(String id, String pass) {
        for (int i = 0; i < dstk.size(); i++) {
            Tai_Khoan_Model tk = dstk.get(i);
            if (tk.getMadangnhap().equals(id)) {
                if (tk.getPassword().equals(pass)) {
                    return true; // đúng cả id và pass
                }
            }
        }
        return false;
    }
    public String ma_quyen(String id){
        String ma = "";
        for( int i = 0 ; i < dstk.size() ; i ++){
            Tai_Khoan_Model tk = dstk.get(i);
            if( tk.getMadangnhap().equals(id)){
                ma = tk.getMaquyen();
                return ma;
            }
        }
        return ma;
    }

    public ArrayList<String> Ten_chuc_nang(String maquyen) {
        ArrayList<String> dscn = new ArrayList<>();
        for (int i = 0; i < dstk.size(); i++) {
            String ten_chuc_nang = "";
            Tai_Khoan_Model tk = dstk.get(i);
            if(tk.getMaquyen().equals(maquyen)){
                ten_chuc_nang = tk.getTenchucnang();
                dscn.add(ten_chuc_nang);
            }
        }
        return dscn ;
    }
    
    public ArrayList<String> Ma_chuc_nang( String maquyen){
        ArrayList<String> dsma_chuc_nang = new ArrayList<>();
        for( int i = 0 ; i <dstk.size(); i ++){
            Tai_Khoan_Model tk =  dstk.get(i);
            if( tk.getMaquyen().equals(maquyen)){
                dsma_chuc_nang.add(tk.getMachucnang());
            }
        }
        return dsma_chuc_nang;
    }
    
    public int[] Hanh_dong_cua_chuc_nang( String maquyen, String machucnang){
        int hanh_dong[] = { 0 , 0 , 0 , 0 , 0};// xem thêm sủa xóa tìm
        for( int i = 0 ; i <dstk.size() ; i ++){
            Tai_Khoan_Model tk = dstk.get(i);
            if( tk.getMaquyen().equals(maquyen)){
                if( tk.getMachucnang().equals(machucnang)){
                    hanh_dong[0] = tk.getXem();
                    hanh_dong[1] = tk.getThem();
                    hanh_dong[2] = tk.getSua();
                    hanh_dong[3] = tk.getXoa();
                    hanh_dong[4] = tk.getTim();
                }
            }
        }
         
        return hanh_dong;
    }
}
