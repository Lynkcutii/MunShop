/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICE;

import MODEL.Voucher;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import utils.JDBCHelper;

/**
 *
 * @author Dung Tran
 */
public class VoucherService {
    String getAll = "select * from Voucher where TrangThai = 1 order by IDVOUCHER desc";
    String insertVC = "INSERT INTO [dbo].[VOUCHER]\n"
                    + "           ([MAVOUCHER]\n"
                    + "           ,[TENVOUCHER]\n"
                    + "           ,[DONTOITHIEU]\n"
                    + "           ,[MUCGIAMGIA]\n"
                    + "           ,[LOAIVC]\n"
                    + "           ,[SOLUONG]\n"
                    + "           ,[NGAYBATDAU]\n"
                    + "           ,[NGAYKETTHUC]\n"
                    + "           ,[NGAYTAO]\n"
                    + "           ,[TRANGTHAI])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?,?,?,getdate(),1)";
    String updateSL = "UPDATE [dbo].[VOUCHER]\n"
            + "   SET [SOLUONG] = ?\n"
            + " WHERE MAVOUCHER = ?";
    String updateVC = "UPDATE [dbo].[VOUCHER]\n"
                    + "   SET [MAVOUCHER] = ?\n"
                    + "      ,[TENVOUCHER] = ?\n"
                    + "      ,[DONTOITHIEU] = ?\n"
                    + "      ,[MUCGIAMGIA] = ?\n"
                    + "      ,[LOAIVC] = ?\n"
                    + "      ,[SOLUONG] = ?"
                    + "      ,[NGAYBATDAU] = ?\n"
                    + "      ,[NGAYKETTHUC] = ?\n"
                    + "      ,[NGAYSUA] = getdate()\n"
                    + " WHERE IDVoucher = ?";
    String searchVC = "select * from VOUCHER where (TENVOUCHER like ? "
                    + "or DONTOITHIEU like ? or MUCGIAMGIA like ? "
                    + "or LOAIVC like ? or SOLUONG like ? or MAVOUCHER like ?) and TrangThai = 1";
    
    public List<Voucher> selectbySQLVoucher(String Sql, Object... orgs){
        try {
            List<Voucher> listVoucher = new ArrayList<>();
            ResultSet rs = JDBCHelper.executeQuery(Sql, orgs);
            while (rs.next()) {                
                 Voucher vc = new Voucher();
                vc.setId(rs.getInt("IDVOUCHER"));
                vc.setMaVoucher(rs.getString("MAVOUCHER"));
                vc.setTenVoucher(rs.getString("TENVOUCHER"));
                vc.setDonToiThieu(rs.getDouble("DONTOITHIEU"));
                vc.setMucGiamGia(rs.getDouble("MUCGIAMGIA"));
                vc.setLoaiGG(rs.getString("LOAIVC"));
                vc.setSoLuong(rs.getInt("SOLUONG"));
                vc.setNgayBatDau(rs.getDate("NGAYBATDAU"));
                vc.setNgayKetThuc(rs.getDate("NGAYKETTHUC"));
                vc.setNgayTao(rs.getDate("NGAYTAO"));
                vc.setTrangThai(rs.getBoolean("TRANGTHAI"));
                listVoucher.add(vc);
            }
            return listVoucher;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public  List<Voucher> getAllVoucher(){
        return selectbySQLVoucher(getAll);
    }
    public void addVC(String maVC){
        JDBCHelper.excuteUpdate(insertVC, maVC);
    }
    public void updateSL(Voucher vc){
        JDBCHelper.excuteUpdate(updateSL,vc.getSoLuong()-1,vc.getMaVoucher());
    }
    public void updateVC(Voucher vc,int id){
        JDBCHelper.excuteUpdate(updateVC, id);
    }
    public void searchVC(String ma){
        JDBCHelper.excuteUpdate(searchVC, ma);
    }
}
