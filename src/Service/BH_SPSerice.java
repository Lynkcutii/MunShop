/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Repo.DBConnect;
import Model.BanHang_SP;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class BH_SPSerice {

    public ArrayList<BanHang_SP> getAllSP() {
        ArrayList<BanHang_SP> lst = new ArrayList<>();
        String sql = "select sct.id,s.ten_sp,m.ten_mau, sz.ten_size, c.ten_chat_lieu, t.ten_thuong_hieu, l.ten_loai,gia_ban,so_luong_ton from SPCT sct\n"
                + "join SanPham s on s.id = sct.id_sp\n"
                + "join Size sz on sz.id = sct.id_size\n"
                + "join ChatLieuVai c on c.id = sct.id_chat_lieu_vai\n"
                + "join ThuongHieu t on t.id = sct.id_thuong_hieu\n"
                + "join LoaiAo l on l.id = sct.id_loai_ao\n"
                + "join Mau m on m.id = sct.id_mau";
        Connection c = DBConnect.getConnection();
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                BanHang_SP bh = new BanHang_SP();
                bh.setId(rs.getInt("id"));
                bh.setTen(rs.getString("ten_sp"));
                bh.setMauS(rs.getString("ten_mau"));
                bh.setKt(rs.getString("ten_size"));
                bh.setChatLieu(rs.getString("ten_chat_lieu"));
                bh.setThuongHieu(rs.getString("ten_thuong_hieu"));
                bh.setLoai(rs.getString("ten_loai"));
                bh.setGia(rs.getDouble("gia_ban"));
                bh.setSoLuong(rs.getInt("so_luong_ton"));
                lst.add(bh);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lst;
    }

    public List<BanHang_SP> find(String ten) {
        List<BanHang_SP> lstTK = new ArrayList<>();

        String sql = "select sct.id, s.ten_sp, m.ten_mau, sz.ten_size, c.ten_chat_lieu, t.ten_thuong_hieu, l.ten_loai, gia_ban, so_luong_ton "
                + "from SPCT sct "
                + "join SanPham s on s.id = sct.id_sp "
                + "join Size sz on sz.id = sct.id_size "
                + "join ChatLieuVai c on c.id = sct.id_chat_lieu_vai "
                + "join ThuongHieu t on t.id = sct.id_thuong_hieu "
                + "join LoaiAo l on l.id = sct.id_loai_ao "
                + "join Mau m on m.id = sct.id_mau "
                + // Add a space here
                "where s.ten_sp like ?";
        Connection cn = DBConnect.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, ten);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                BanHang_SP bh = new BanHang_SP();
                bh.setId(rs.getInt("id"));
                bh.setTen(rs.getString("ten_sp"));
                bh.setMauS(rs.getString("ten_mau"));
                bh.setKt(rs.getString("ten_size"));
                bh.setChatLieu(rs.getString("ten_chat_lieu"));
                bh.setThuongHieu(rs.getString("ten_thuong_hieu"));
                bh.setLoai(rs.getString("ten_loai"));
                bh.setGia(rs.getDouble("gia_ban"));
                bh.setSoLuong(rs.getInt("so_luong_ton"));

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return lstTK;
    }

}
