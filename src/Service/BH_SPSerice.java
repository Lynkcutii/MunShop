/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Repo.DBConnect1;
import Model.BanHang_SP;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class BH_SPSerice {
    public ArrayList<BanHang_SP> getAllSP(){
        ArrayList<BanHang_SP> lst = new ArrayList<>();
        String sql = "select sct.IDSPCT,s.TENSP,m.TENMAU,z.TENSIZE,c.TENCHATLIEU,t.TENTHUONGHIEU,SOLUONG,GIA from SanPhamChiTiet sct \n" +
"join SanPham s on s.IDSANPHAM= sct.IDSANPHAM\n" +
"join MauSac m on m.IDMAUSAC = sct.IDMAUSAC\n" +
"join ChatLieu c on c.IDCHATLIEU = sct.IDCHATLIEU\n" +
"join Size z on z.IDSIZE = sct.IDSIZE\n" +
"join ThuongHieu t on t.IDTHUONGHIEU = sct.IDTHUONGHIEU";
        Connection c = DBConnect1.getConnection();
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                BanHang_SP bh = new BanHang_SP();
                bh.setId(rs.getInt("IDSPCT"));
                bh.setTen(rs.getString("TENSP"));
                bh.setMauS(rs.getString("TENMAU"));
                bh.setKt(rs.getString("TENSIZE"));
                bh.setChatLieu(rs.getString("TENCHATLIEU"));
                bh.setThuongHieu(rs.getString("TENTHUONGHIEU"));
                bh.setSoLuong(rs.getInt("SOLUONG"));
                bh.setGia(rs.getDouble("GIA"));
                
                lst.add(bh);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lst;
    }
 public List<BanHang_SP> find(String ten) {
        List<BanHang_SP> lstTK = new ArrayList<>();
        
        String sql = "SELECT sct.IDSPCT, s.TENSP, m.TENMAU, c.TENCHATLIEU, z.TENSIZE, t.TENTHUONGHIEU, SOLUONG, GIA " +
                     "FROM SanPhamChiTiet sct " +
                     "JOIN SanPham s ON s.IDSANPHAM = sct.IDSANPHAM " +
                     "JOIN MauSac m ON m.IDMAUSAC = sct.IDMAUSAC " +
                     "JOIN ChatLieu c ON c.IDCHATLIEU = sct.IDCHATLIEU " +
                     "JOIN Size z ON z.IDSIZE = sct.IDSIZE " +
                     "JOIN ThuongHieu t ON t.IDTHUONGHIEU = sct.IDTHUONGHIEU " +
                     "WHERE s.TENSP LIKE ?";
        
        try (Connection cn = DBConnect1.getConnection();
             PreparedStatement pstm = cn.prepareStatement(sql)) {
             
            pstm.setString(1, "%" + ten + "%"); // Sử dụng % để tìm kiếm tất cả các giá trị chứa mã ma
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    BanHang_SP bh = new BanHang_SP();
                    bh.setId(rs.getInt("IDSPCT"));
                    bh.setTen(rs.getString("TENSP"));
                    bh.setMauS(rs.getString("TENMAU"));
                    bh.setKt(rs.getString("TENSIZE"));
                    bh.setChatLieu(rs.getString("TENCHATLIEU"));
                    bh.setThuongHieu(rs.getString("TENTHUONGHIEU"));
                    bh.setSoLuong(rs.getInt("SOLUONG"));
                    bh.setGia(rs.getDouble("GIA"));
                    
                    lstTK.add(bh); // Thêm đối tượng vào danh sách
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lstTK;
    }


    
    
}
