/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author tuntt
 */
public class Nha_Cung_Cap_Model {
    private String manhacungcap;
    private String tennhacungcap;
    private String diachinhacungcap;
    private String sdtnhacungcap;
    private String quocgianhacungcap;
    private String emailnhacungcap;

    public Nha_Cung_Cap_Model(String manhacungcap, String tennhacungcap, String diachinhacungcap, String sdtnhacungcap, String quocgianhacungcap, String emailnhacungcap) {
        this.manhacungcap = manhacungcap;
        this.tennhacungcap = tennhacungcap;
        this.diachinhacungcap = diachinhacungcap;
        this.sdtnhacungcap = sdtnhacungcap;
        this.quocgianhacungcap = quocgianhacungcap;
        this.emailnhacungcap = emailnhacungcap;
    }

    public void setManhacungcap(String manhacungcap) {
        this.manhacungcap = manhacungcap;
    }

    public void setTennhacungcap(String tennhacungcap) {
        this.tennhacungcap = tennhacungcap;
    }

    public void setDiachinhacungcap(String diachinhacungcap) {
        this.diachinhacungcap = diachinhacungcap;
    }

    public void setSdtnhacungcap(String sdtnhacungcap) {
        this.sdtnhacungcap = sdtnhacungcap;
    }

    public void setQuocgianhacungcap(String quocgianhacungcap) {
        this.quocgianhacungcap = quocgianhacungcap;
    }

    public void setEmailnhacungcap(String emailnhacungcap) {
        this.emailnhacungcap = emailnhacungcap;
    }

    public String getManhacungcap() {
        return manhacungcap;
    }

    public String getTennhacungcap() {
        return tennhacungcap;
    }

    public String getDiachinhacungcap() {
        return diachinhacungcap;
    }

    public String getSdtnhacungcap() {
        return sdtnhacungcap;
    }

    public String getQuocgianhacungcap() {
        return quocgianhacungcap;
    }

    public String getEmailnhacungcap() {
        return emailnhacungcap;
    }
    
}
