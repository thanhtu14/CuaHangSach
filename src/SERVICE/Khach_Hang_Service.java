package SERVICE;

import DAO.Khach_Hang_Dao;
import MODEL.San_Pham_Model;
import DAO.San_Pham_Dao;
import MODEL.Khach_Hang_Model;
import java.util.*;

public class Khach_Hang_Service{
    private ArrayList<Khach_Hang_Model> dskh;
    
    public Khach_Hang_Service( int i ){
        list();
    }
    public Khach_Hang_Service(){
        list();
    }
    public void list(){
        Khach_Hang_Dao khach_Hang_Dao = new Khach_Hang_Dao();
        dskh = new ArrayList<>();
        dskh = khach_Hang_Dao.danhsachkhachhang();
    }
    public ArrayList<Khach_Hang_Model> getList(){
        return dskh;
    }
    
    
    
}