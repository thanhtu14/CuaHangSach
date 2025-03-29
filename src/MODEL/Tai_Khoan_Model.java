/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author tuntt
 */
public class Tai_Khoan_Model {
    private String madangnhap;
    private String password;
    private String machucvu;
    
    public Tai_Khoan_Model( String ma , String pass, String machucvu){
        this.madangnhap = ma;
        this.password = pass;
        this.machucvu = machucvu;
    }

    public String getMadangnhap() {
        return madangnhap;
    }

    public String getPassword() {
        return password;
    }

    public String getMachucvu() {
        return machucvu;
    }

    public void setMadangnhap(String madangnhap) {
        this.madangnhap = madangnhap;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMachucvu(String machucvu) {
        this.machucvu = machucvu;
    }
    
}
