/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author tuntt
 */
public class Chuc_Vu_Model {
    private String machucvu;
    private String tenchucvu;

    public Chuc_Vu_Model(String machucvu, String tenchucvu) {
        this.machucvu = machucvu;
        this.tenchucvu = tenchucvu;
    }

    public void setMachucvu(String machucvu) {
        this.machucvu = machucvu;
    }

    public void setTenchucvu(String tenchucvu) {
        this.tenchucvu = tenchucvu;
    }

    public String getMachucvu() {
        return machucvu;
    }

    public String getTenchucvu() {
        return tenchucvu;
    }
    
    
}
