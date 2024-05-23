/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICE;

import MODEL.KhachHang;
import Repo.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author HK
 */
public class KhachHangService {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public ArrayList<KhachHang> getAll() {
        ArrayList<KhachHang> list = new ArrayList<>();
        sql = """
              SELECT * FROM KhachHang
              """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int add(KhachHang kh) {
        sql = """
            INSERT INTO KhachHang(MAKHACHHANG,HOTEN,GIOITINH,SDT,EMAIL,TRANGTHAI)
            VALUES(?,?,?,?,?,?,?)
            """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, kh.getMa());
            ps.setString(2, kh.getHoTen());
            ps.setString(3, kh.getGioiTinh());
            ps.setString(4, kh.getSdt());
            ps.setString(6, kh.getEmail());
            ps.setString(11, kh.getTrangThai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public KhachHang getMaKH(String ma) {
        KhachHang kh = null;
        sql = "select * from KhachHang where MAKHACHHANG = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {
                kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
            return kh;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean update(KhachHang kh) {
        int check = 0;
        sql = "UPDATE KhachHang SET TRANGTHAI = ? WHERE MAKHACHHANG = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setObject(1, kh.getTrangThai());
            ps.setObject(2, kh.getMa());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return check > 0;
    }

//    public ArrayList<KhachHang> tim(String tim, int page, String gioiTinhString, String trangTthai) {
//        ArrayList<KhachHang> list = new ArrayList<>();
//        String sql = """
//                     SELECT * FROM KhachHang 
//                     WHERE (MAKHACHHANG LIKE ? OR HOTEN LIKE ? OR SDT LIKE ? or EMAIL LIKE ?) 
//                           AND GIOITINH LIKE ? AND TRANGTHAI LIKE ?
//                     ORDER BY CAST(SUBSTRING(MAKHACHHANG, 3, LEN(MAKHACHHANG) - 2) AS INT) DESC
//                     OFFSET ? ROW FETCH NEXT 10 ROW ONLY
//                     """;
//        try {
//            con = DBConnect.getConnection();
//            ps = con.prepareStatement(sql);
//
////            ps.setObject(1, "%" + tim + "%");
////            ps.setObject(2, "%" + tim + "%");
////            ps.setObject(3, "%" + tim + "%");
////            ps.setObject(4, "%" + tim + "%");
////            ps.setObject(5, "%" + gioiTinhString + "%");
////            ps.setObject(6, "%" + trangTthai + "%");
////            ps.setObject(7, page * 10);
//            ps.setObject(1, "%" + tim + "%");
//            ps.setObject(2, "%" + tim + "%");
//            ps.setObject(3, "%" + gioiTinhString + "%");
//            ps.setObject(4, "%" + tim + "%");
//            ps.setObject(5, "%" + trangTthai + "%");
//            ps.setObject(6, page * 10);
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
//                list.add(kh);
//            }
//            return list;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

//    public ArrayList<KhachHang> countSearch(String tim, String gioiTinh, String trangTthai) {
//        ArrayList<KhachHang> list = new ArrayList<>();
//        String sql = """
//                    SELECT * FROM KhachHang 
//                                          WHERE (MaKhachHang LIKE ? OR HoTen LIKE ? OR
//                                                               SDT LIKE ? or Email LIKE ? OR 
//                                                               ) AND
//                                          GioiTinh LIKE ? AND TrangThai LIKE ?
//                     """;
//        try {
//            con = DBConnect.getConnection();
//            ps = con.prepareStatement(sql);
//
//            ps.setObject(1, "%" + tim + "%");
//            ps.setObject(2, "%" + tim + "%");
//            ps.setObject(3, "%" + gioiTinh + "%");
//            ps.setObject(4, "%" + tim + "%");
//            ps.setObject(5, "%" + tim + "%");
//            ps.setObject(6, "%" + trangTthai + "%");
//
////            ps.setObject(1, "%" + tim + "%");
////            ps.setObject(2, "%" + tim + "%");
////            ps.setObject(3, "%" + tim + "%");
////            ps.setObject(4, "%" + tim + "%");
////            ps.setObject(5, "%" + tim + "%");
////            ps.setObject(6, "%" + gioiTinh + "%");
////            ps.setObject(7, "%" + trangTthai + "%");
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
//                list.add(kh);
//            }
//            return list;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
