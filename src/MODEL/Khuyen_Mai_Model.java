/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author tuntt
 */
public class Khuyen_Mai_Model {
    private String makhuyenmai;
    private String tenkhuyenmai;
    private double phantramkhuyenmai;
    private String ngaybatdau;
    private String ngayketthuc;

    public Khuyen_Mai_Model(String makhuyenmai, String tenkhuyenmai, double phantramkhuyenmai, String ngaybatdau, String ngayketthuc) {
        this.makhuyenmai = makhuyenmai;
        this.tenkhuyenmai = tenkhuyenmai;
        this.phantramkhuyenmai = phantramkhuyenmai;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
    }

    public void setMakhuyenmai(String makhuyenmai) {
        this.makhuyenmai = makhuyenmai;
    }

    public void setTenkhuyenmai(String tenkhuyenmai) {
        this.tenkhuyenmai = tenkhuyenmai;
    }

    public void setPhantramkhuyenmai(double phantramkhuyenmai) {
        this.phantramkhuyenmai = phantramkhuyenmai;
    }

    public void setNgaybatdau(String ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public void setNgayketthuc(String ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    public String getMakhuyenmai() {
        return makhuyenmai;
    }

    public String getTenkhuyenmai() {
        return tenkhuyenmai;
    }

    public double getPhantramkhuyenmai() {
        return phantramkhuyenmai;
    }

    public String getNgaybatdau() {
        return ngaybatdau;
    }

    public String getNgayketthuc() {
        return ngayketthuc;
    }
    
    
}
