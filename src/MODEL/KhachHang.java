/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.util.Date;

/**
 *
 * @author HK
 */
public class KhachHang {
    private String ma, hoTen, gioiTinh, sdt;
//    private Date ngaySinh;
    private String email;
    private String trangThai;

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

//    public Date getNgaySinh() {
//        return ngaySinh;
//    }
//
//    public void setNgaySinh(Date ngaySinh) {
//        this.ngaySinh = ngaySinh;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public KhachHang(String ma, String hoTen, String gioiTinh, String sdt, String email,String trangThai) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
//        this.ngaySinh = ngaySinh;
        this.email = email;
        this.trangThai = trangThai;
    }

    public KhachHang() {
    }

}
