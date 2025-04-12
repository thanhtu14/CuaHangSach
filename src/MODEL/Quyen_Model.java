/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author tuntt
 */
public class Quyen_Model {
    private String maquyen;
    private String tenquyen;

    public Quyen_Model(String maquyen, String tenquyen) {
        this.maquyen = maquyen;
        this.tenquyen = tenquyen;
    }

    public void setMaquyen(String maquyen) {
        this.maquyen = maquyen;
    }

    public void setTenquyen(String tenquyen) {
        this.tenquyen = tenquyen;
    }

    public String getMaquyen() {
        return maquyen;
    }

    public String getTenquyen() {
        return tenquyen;
    }
    
    
}
