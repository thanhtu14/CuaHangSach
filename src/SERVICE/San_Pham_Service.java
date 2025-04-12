package SERVICE;

import DAO.Nhan_Vien_Dao;
import MODEL.San_Pham_Model;
import DAO.San_Pham_Dao;
import MODEL.Nhan_Vien_Model;
import java.util.*;

public class San_Pham_Service{
    private ArrayList<San_Pham_Model> dssp;
    
    public San_Pham_Service( int i ){
        list();
    }
    public San_Pham_Service(){
        list();
    }
    public void list(){
        San_Pham_Dao san_Pham_Dao = new San_Pham_Dao();
        dssp = new ArrayList<>();
        dssp = san_Pham_Dao.danhsachsanpham();
    }
    public ArrayList<San_Pham_Model> getList(){
        return dssp;
    }
    
    
    
}