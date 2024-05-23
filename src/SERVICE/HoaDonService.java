/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import MODEL.HoaDon;
import MODEL.KhachHang;
import Repo.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HK
 */
public class HoaDonService {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    public ArrayList<HoaDon> getAll(){
        ArrayList<HoaDon> list = new ArrayList<>();
    try {
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT MaHD, TongTien, NgayTao, TrangThai FROM HoaDon " +
                     "WHERE HoaDon.TrangThai = 0";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            list.add(new HoaDon(
                rs.getString(1),     // MaHD
                rs.getDouble(2),  // TongTien
                rs.getDate(3),    // NgayTao
                rs.getString(4)   // TrangThai
            ));
        }
        conn.close();
    } catch(Exception e) {
        e.printStackTrace();
    }
    return list;
}
}
