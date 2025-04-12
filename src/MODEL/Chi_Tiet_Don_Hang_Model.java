/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author tuntt
 */
public class Chi_Tiet_Don_Hang_Model {
    private String madonhang;
    private String masach;
    private int soluongsachmua;
    private double giaban;

    public Chi_Tiet_Don_Hang_Model(String madonhang, String masach, int soluongsachmua, double giaban) {
        this.madonhang = madonhang;
        this.masach = masach;
        this.soluongsachmua = soluongsachmua;
        this.giaban = giaban;
    }

    public void setMadonhang(String madonhang) {
        this.madonhang = madonhang;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public void setSoluongsachmua(int soluongsachmua) {
        this.soluongsachmua = soluongsachmua;
    }

    public void setGiaban(double giaban) {
        this.giaban = giaban;
    }

    public String getMadonhang() {
        return madonhang;
    }

    public String getMasach() {
        return masach;
    }

    public int getSoluongsachmua() {
        return soluongsachmua;
    }

    public double getGiaban() {
        return giaban;
    }
    
    
}
