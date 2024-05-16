/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICE;

import MODEL.KhachHang;
import REPO.DBConnect1;
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
            con = DBConnect1.getConnection();
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
            INSERT INTO KhachHang(MaKhachHang,HoTen,GioiTinh,SDT,Email,TrangThai)
            VALUES(?,?,?,?,?,?,?)
            """;
        try {
            con = DBConnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, kh.getMa());
            ps.setString(2, kh.getTen());
            ps.setString(3, kh.getGioitinh());
            ps.setString(4, kh.getSdt());
            ps.setString(5, kh.getEmail());
            ps.setString(7, kh.getTrangthai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public KhachHang getMaKH(String ma) {
        KhachHang kh = null;
        sql = "select * from KhachHang where MaKhachHang = ?";
        try {
            con = DBConnect1.getConnection();
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
        sql = "UPDATE KhachHang SET TrangThai = ? WHERE MaKhchHang = ?";
        try {
            con = DBConnect1.getConnection();
            ps = con.prepareStatement(sql);

            ps.setObject(1, kh.getTrangthai());
            ps.setObject(2, kh.getMa());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return check > 0;
    }

    public ArrayList<KhachHang> tim(String tim, int page, String gioiTinhString, String trangTthai) {
        ArrayList<KhachHang> list = new ArrayList<>();
        String sql = """
                     SELECT * FROM KhachHang 
                     WHERE (MaKhachHang LIKE ? OR HoTen LIKE ? OR SDT LIKE ? or Email LIKE ?) 
                           AND GioiTinh LIKE ? AND TrangThai LIKE ?
                     ORDER BY CAST(SUBSTRING(MaKhachHang, 3, LEN(MaKhachHang) - 2) AS INT) DESC
                     OFFSET ? ROW FETCH NEXT 10 ROW ONLY
                     """;
        try {
            con = DBConnect1.getConnection();
            ps = con.prepareStatement(sql);

            ps.setObject(1, "%" + tim + "%");
            ps.setObject(2, "%" + tim + "%");
            ps.setObject(3, "%" + tim + "%");
            ps.setObject(4, "%" + tim + "%");
            ps.setObject(5, "%" + gioiTinhString + "%");
            ps.setObject(6, "%" + trangTthai + "%");
            ps.setObject(7, page * 10);
            rs = ps.executeQuery();

            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<KhachHang> countSearch(String tim, String gioiTinh, String trangTthai) {
        ArrayList<KhachHang> list = new ArrayList<>();
        String sql = """
                    SELECT * FROM KhachHang 
                                          WHERE (MaKhachHang LIKE ? OR HoTen LIKE ? OR
                                                               SDT LIKE ? or Email LIKE ? OR 
                                                               ) AND
                                          GioiTinh LIKE ? AND TrangThai LIKE ?
                     """;
        try {
            con = DBConnect1.getConnection();
            ps = con.prepareStatement(sql);

            ps.setObject(1, "%" + tim + "%");
            ps.setObject(2, "%" + tim + "%");
            ps.setObject(3, "%" + tim + "%");
            ps.setObject(4, "%" + tim + "%");
            ps.setObject(5, "%" + tim + "%");
            ps.setObject(6, "%" + gioiTinh + "%");
            ps.setObject(7, "%" + trangTthai + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    public ArrayList<LichSuGiaoDich> getAllLSGD(String maKH) {
//        ArrayList<LichSuGiaoDich> list = new ArrayList<>();
//        String sql = """
//                     SELECT KH.TenKH, HD.MaHoaDon, HD.NgayThanhToan, HD.ThanhTien, HD.TrangThai
//                     FROM KhachHang KH
//                     JOIN HoaDon HD
//                     ON KH.MaKH = HD.MaKhachHang
//                     WHERE MaKH = ?
//                     """;
//        try {
//            con = DBConnect.getConnection();
//            ps = con.prepareStatement(sql);
//
//            ps.setString(1, maKH);
//
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//                String ten = rs.getString("TenKH");
//                String mahd = rs.getString("MaHoaDon");
//                Date ngaygd = rs.getDate("NgayThanhToan");
//                Float tongtien = rs.getFloat("ThanhTien");
//                String tt = rs.getString("TrangThai");
//
//                LichSuGiaoDich lsu = new LichSuGiaoDich(ten, mahd, tt, ngaygd, tongtien);
//                list.add(lsu);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // Đóng tài nguyên (result set, statement, connection) trong khối finally
//            // để đảm bảo chúng được đóng ngay cả khi có lỗi xảy ra.
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (ps != null) {
//                    ps.close();
//                }
//                if (con != null) {
//                    con.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return list;
//    }
}
