/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICE;

import MODEL.HoaDon;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import utils.JDBCHelper;

/**
 *
 * @author Dung Tran
 */
public class BanHangService {
    String getAllHD = "select * from HoaDon where TrangThai = 0 and ANTT = 1 order by IDHOADON  desc";
    String insertHD = """
                      INSERT INTO [dbo].[HoaDon]
                                 ([MAHOADON]
                                 ,[IDKHACHHANG]
                                 ,[IDNHANVIEN]
                                 ,[IDVOUCHER]
                                 ,[IDHDCT]
                                 ,[TONGTIEN]
                                 ,[NGAYTHANHTOAN]
                                 ,[NGAYTAO]
                                 ,[NGUOITAO]
                                 ,[TRANGTHAI]
                                 ,[ANTT])
                           VALUES(?,null,null,null,null,0,null,getdate(),null,0,1)
                      """;
    public List<HoaDon> selectbySQLHD(String Sql, Object... orgs){
        try {
            List<HoaDon> listHoaDon = new ArrayList<>();
            ResultSet rs = JDBCHelper.executeQuery(Sql, orgs);
            while (rs.next()) {                
                HoaDon hd = new HoaDon();
                hd.setIdHoaDon(rs.getInt("IDHOADON"));
                hd.setIdKhachHang(rs.getInt("IDKHACHHANG"));
                hd.setIdNhanVien(rs.getInt("IDNHANVIEN"));
                hd.setIdVoucher(rs.getInt("IDVOUCHER"));
                hd.setMaHoaDon(rs.getString("MAHOADON"));
                hd.setTongTien(rs.getDouble("TONGTIEN"));
                hd.setNgaytao(rs.getDate("NGAYTAO"));
                hd.setNgayThanhToan(rs.getDate("NGAYTHANHTOAN"));
                hd.setNguoiTao(rs.getString("NGUOITAO"));
                hd.setTrangThai(rs.getBoolean("TRANGTHAI"));
                listHoaDon.add(hd);
            }
            return listHoaDon;
        } catch (Exception e) {
                throw new RuntimeException(e);
        }
    }
    public List<HoaDon> getAllHD(){
        return selectbySQLHD(getAllHD);
    }
    public void addHoaDon(String MaHD){
        JDBCHelper.excuteUpdate(insertHD, MaHD);
    }
}
