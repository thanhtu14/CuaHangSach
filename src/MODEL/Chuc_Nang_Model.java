/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author tuntt
 */
public class Chuc_Nang_Model {
    private String machucnang; 
    private String tenchucvu;

    public Chuc_Nang_Model(String machucnang, String tenchucvu) {
        this.machucnang = machucnang;
        this.tenchucvu = tenchucvu;
    }

    public void setMachucnang(String machucnang) {
        this.machucnang = machucnang;
    }

    public void setTenchucvu(String tenchucvu) {
        this.tenchucvu = tenchucvu;
    }

    public String getMachucnang() {
        return machucnang;
    }

    public String getTenchucvu() {
        return tenchucvu;
    }
    
    
}
