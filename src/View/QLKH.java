/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import MODEL.KhachHang;
import SERVICE.KhachHangService;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HK
 */
public class QLKH extends javax.swing.JFrame {
    
    DefaultTableModel model;
    DefaultTableModel model2;
    KhachHangService service = new KhachHangService();
    ArrayList<KhachHang> list = new ArrayList<>();
//    ArrayList<LichSuGiaoDich> listLSGD = new ArrayList<>();
    private Integer page = null;
    private Integer totalPages = null;
    private Integer size = 10;
    private String gioiTinh = null;
    private String trangThai = null;
    private String maKHSelected = null;

    /**
     * Creates new form QLKH
     */
    public QLKH() {
        initComponents();
        model = (DefaultTableModel) khTable.getModel();
        model2 = (DefaultTableModel) lsgdTb.getModel();
        page = 1;
        totalPages = (int) Math.ceil((double) service.getAll().size() / size);
        pageLb.setText(totalPages + "");
        currentPage.setText(page + "");
        gioiTinh = "";
        trangThai = "";
        showData(list);
//        try {
//            list = service.tim("", 0, "", "");
//            showData(list);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    
    private void showData(ArrayList<KhachHang> listKH) {
        model.setRowCount(0);
        for (KhachHang kh : listKH) {
            Object data[] = {
                kh.getMa(),
                kh.getHoTen(),
                kh.getGioiTinh(),
                kh.getSdt(),
                kh.getEmail(),
                kh.getTrangThai()
            };
            model.addRow(data);
        }
    }

//    private void showLSGD(ArrayList<LichSuGiaoDich> listGD) {
//        model2.setRowCount(0);
//        for (LichSuGiaoDich lsu : listGD) {
//            Object dataGD[] = {
//                lsu.getTenKH(),
//                lsu.getMaHD(),
//                lsu.getNgayGD(),
//                lsu.getTongtien(),
//                (Integer.valueOf(lsu.getTrangthaiHD()) == 1 ? "Đã thanh toán" : "Chờ thanh toán")
//            };
//            model2.addRow(dataGD);
//        }
//    }
    private void getIndex(int index) {
        KhachHang kh = list.get(index);
        maTxt.setText(kh.getMa());
        txtTen.setText(kh.getHoTen());
        String gt = kh.getGioiTinh();
        if (gt.equals("Nam")) {
            namRB.setSelected(true);
        } else {
            nuRB.setSelected(true);
        }
        sdtTxt.setText(kh.getSdt());
        txtEmail.setText(kh.getEmail());
        String tt = kh.getTrangThai();
        if (tt.equals("Còn hoạt động")) {
            conhdRB.setSelected(true);
        } else {
            ngunghdRB.setSelected(true);
        }
    }
    
    private void getMa(String ma) {
        KhachHang kh = service.getMaKH(ma);
        maTxt.setText(kh.getMa());
        txtTen.setText(kh.getHoTen());
        String gt = kh.getGioiTinh();
        if (gt.equals("Nam")) {
            namRB.setSelected(true);
        } else {
            nuRB.setSelected(true);
        }
        sdtTxt.setText(kh.getSdt());
        txtEmail.setText(kh.getEmail());
        String tt = kh.getTrangThai();
        if (tt.equals("Còn hoạt động")) {
            conhdRB.setSelected(true);
        } else {
            ngunghdRB.setSelected(true);
        }
    }
    
    private KhachHang getData() {
        int dem = 0;
        String ma = maTxt.getText();
        String ten = txtTen.getText();
        String sdt = sdtTxt.getText();
        String email = txtEmail.getText();
        String gt, tt;
        if (ten.trim().isEmpty() || sdt.trim().isEmpty() || email.trim().isEmpty()) {
            dem++;
            JOptionPane.showMessageDialog(this, "Không được để trống thông tin");
        }
        if (!ten.matches("^[\\p{L} ]+$")) {
            dem++;
            JOptionPane.showMessageDialog(this, "Tên không hợp lệ");
        }
        
        if (!sdt.matches("^[0-9]{10}$")) {
            dem++;
            JOptionPane.showMessageDialog(this, "SĐT không đúng định dạng");
        }
        if (!email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            dem++;
            JOptionPane.showMessageDialog(this, "Email không đúng định dạng Gmail");
        }
        if (namRB.isSelected() == true) {
            gt = "Nam";
        } else {
            gt = "Nữ";
        }
        if (conhdRB.isSelected() == true) {
            tt = "Còn hoạt động";
        } else {
            tt = "Ngừng hoạt động";
        }
        
        if (dem == 0) {
            return new KhachHang(ma, ten, gt, sdt, email, tt);
        } else {
            return null;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel17 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        conhdRB = new javax.swing.JRadioButton();
        ngunghdRB = new javax.swing.JRadioButton();
        jPanel23 = new javax.swing.JPanel();
        themBtn = new javax.swing.JButton();
        suaBtn = new javax.swing.JButton();
        moiBtn = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        namRB = new javax.swing.JRadioButton();
        nuRB = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        sdtTxt = new javax.swing.JTextField();
        maTxt = new javax.swing.JLabel();
        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel18 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        timkiemTxt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        khTable = new javax.swing.JTable();
        jPanel22 = new javax.swing.JPanel();
        locGTCBo = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        locTTCBo = new javax.swing.JComboBox<>();
        search = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lsgdTb = new javax.swing.JTable();
        prevBtn = new javax.swing.JButton();
        currentPage = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        pageLb = new javax.swing.JLabel();
        nextBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thiết lập thông tin khách hàng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        jLabel15.setText("Email:");

        jLabel16.setText("Trạng thái");

        conhdRB.setSelected(true);
        conhdRB.setText("Còn hoạt động");

        ngunghdRB.setText("Ngừng hoạt động");

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        themBtn.setBackground(new java.awt.Color(0, 102, 255));
        themBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        themBtn.setForeground(new java.awt.Color(255, 255, 255));
        themBtn.setText("Thêm");
        themBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themBtnActionPerformed(evt);
            }
        });

        suaBtn.setBackground(new java.awt.Color(0, 102, 255));
        suaBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        suaBtn.setForeground(new java.awt.Color(255, 255, 255));
        suaBtn.setText("Sửa");
        suaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaBtnActionPerformed(evt);
            }
        });

        moiBtn.setBackground(new java.awt.Color(0, 102, 255));
        moiBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        moiBtn.setForeground(new java.awt.Color(255, 255, 255));
        moiBtn.setText("Mới");
        moiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moiBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(themBtn)
                    .addComponent(suaBtn, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(moiBtn, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(themBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(suaBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(moiBtn)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setText("Mã khách hàng:");

        jLabel12.setText("Tên khách hàng:");

        jLabel13.setText("Giới tính:");

        namRB.setSelected(true);
        namRB.setText("Nam");

        nuRB.setText("Nữ");

        jLabel14.setText("Số điện thoại:");

        maTxt.setText(" ");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(29, 29, 29)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(namRB)
                        .addGap(18, 18, 18)
                        .addComponent(nuRB))
                    .addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(sdtTxt)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                        .addComponent(maTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(62, 62, 62)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(maTxt))
                .addGap(12, 12, 12)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(namRB)
                    .addComponent(nuRB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(sdtTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15))
                .addGap(28, 28, 28)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(conhdRB)
                        .addGap(35, 35, 35)
                        .addComponent(ngunghdRB)))
                .addGap(52, 52, 52)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(conhdRB)
                    .addComponent(ngunghdRB))
                .addGap(73, 73, 73))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Tìm kiếm");

        khTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã KH", "Họ tên KH", "Giới tính", "SĐT", "Email", "Trạng thái"
            }
        ));
        khTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                khTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(khTable);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lọc", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        locGTCBo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Nam", "Nữ" }));
        locGTCBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locGTCBoActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel19.setText("Giới tính:");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel20.setText("Trạng thái:");

        locTTCBo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Còn hoạt động", "Ngừng hoạt động" }));
        locTTCBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locTTCBoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19)
                    .addComponent(locGTCBo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(locTTCBo, 0, 197, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(locGTCBo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(locTTCBo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        search.setBackground(new java.awt.Color(0, 102, 255));
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timkiemTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(search)
                        .addGap(0, 119, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(timkiemTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Thông tin cá nhân", jPanel19);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        lsgdTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tên KH", "Mã hóa đơn", "Ngày GD", "Tổng tiền", "Trạng thái HĐ"
            }
        ));
        jScrollPane3.setViewportView(lsgdTb);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Lịch sử giao dịch", jPanel21);

        prevBtn.setBackground(new java.awt.Color(0, 102, 255));
        prevBtn.setForeground(new java.awt.Color(255, 255, 255));
        prevBtn.setText("Prev");
        prevBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevBtnActionPerformed(evt);
            }
        });

        currentPage.setText("01");

        jLabel21.setText("/");

        pageLb.setText(" ");

        nextBtn.setBackground(new java.awt.Color(0, 102, 255));
        nextBtn.setForeground(new java.awt.Color(255, 255, 255));
        nextBtn.setText("Next");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(prevBtn)
                .addGap(34, 34, 34)
                .addComponent(currentPage)
                .addGap(18, 18, 18)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pageLb, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nextBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prevBtn)
                    .addComponent(nextBtn)
                    .addComponent(pageLb)
                    .addComponent(jLabel21)
                    .addComponent(currentPage))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void themBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themBtnActionPerformed
//        KhachHang kh = getData();
//        if (kh != null) {
//            KhachHang existingKH = service.getMaKH(kh.getMa());
//
//            if (existingKH == null) {
//                int result = service.add(kh);
//
//                if (result > 0) {
//                    JOptionPane.showMessageDialog(this, "Thêm thành công");
//                    showData(service.tim("", 0, gioiTinh, trangThai));
//                } else {
//                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
//                }
//            } else {
//                JOptionPane.showMessageDialog(this, "Trùng mã");
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ");
//        }
    }//GEN-LAST:event_themBtnActionPerformed

    private void suaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaBtnActionPerformed
//        int row = khTable.getSelectedRow();
//        if (row < 0) {
//            JOptionPane.showMessageDialog(this, "Chọn khách hàng cần sửa");
//        } else {
//            int chon = JOptionPane.showConfirmDialog(this, "Bạn muốn cập nhật trạng thái của khách hàng này?");
//            if (chon == JOptionPane.YES_OPTION) {
//                boolean sua = service.update(getData());
//                try {
//                    showData(service.tim("", 0, gioiTinh, trangThai));
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                if (sua) {
//                    JOptionPane.showMessageDialog(this, "Cập nhật trạng thái thành công");
//                } else {
//                    JOptionPane.showMessageDialog(this, "Sửa thất bại");
//                }
//            }
//        }
    }//GEN-LAST:event_suaBtnActionPerformed

    private void moiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moiBtnActionPerformed
        maTxt.setText("");
        txtTen.setText("");
        namRB.setSelected(true);
        sdtTxt.setText("");
        txtEmail.setText("");
        conhdRB.setSelected(true);
        timkiemTxt.setText("");
    }//GEN-LAST:event_moiBtnActionPerformed

    private void khTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_khTableMouseClicked
        int row = khTable.getSelectedRow();
        String tim = timkiemTxt.getText();
        String ma = String.valueOf(khTable.getValueAt(row, 0));
        getMa(ma);
        System.out.println(ma);
        //String tim = timkiemTxt.getText();
        getIndex(row);
        KhachHang kh = list.get(row);
        maKHSelected = kh.getMa();
        System.out.println(kh.getMa());
//        try {
//            listLSGD = service.getAllLSGD(ma);
//            showLSGD(listLSGD);
//        } catch (Exception e) {
//        }
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_khTableMouseClicked

    private void locGTCBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locGTCBoActionPerformed
//        String locgt = (String) locGTCBo.getSelectedItem();
//        if (locgt.equals("All"));
//        gioiTinh = "";
//        if (locgt.equals("Nam")) {
//            gioiTinh = "Nam";
//        }
//        if (locgt.equals("Nữ")) {
//            gioiTinh = "Nữ";
//        }
//        list = service.tim(timkiemTxt.getText(), 0, gioiTinh, trangThai);
//        showData(list);
//        totalPages = (int) Math.ceil((double) service.countSearch(timkiemTxt.getText(), gioiTinh, trangThai).size() / size);
//        pageLb.setText(totalPages + "");
    }//GEN-LAST:event_locGTCBoActionPerformed

    private void locTTCBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locTTCBoActionPerformed
//        String loctt = (String) locTTCBo.getSelectedItem();
//        if (loctt.equals("All"));
//        trangThai = "";
//        if (loctt.equals("Còn hoạt động")) {
//            trangThai = "Còn hoạt động";
//        }
//        if (loctt.equals("Ngừng hoạt động")) {
//            trangThai = "Ngừng hoạt động";
//        }
//        list = service.tim(timkiemTxt.getText(), 0, gioiTinh, trangThai);
//        showData(list);
//        totalPages = (int) Math.ceil((double) service.countSearch(timkiemTxt.getText(), gioiTinh, trangThai).size() / size);
//        pageLb.setText(totalPages + "");
    }//GEN-LAST:event_locTTCBoActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
//        String tim = timkiemTxt.getText();
//        ArrayList<KhachHang> listKH = service.tim(tim, page - 1, gioiTinh, trangThai);
//        if (listKH != null) {
//            list = listKH;
//            showData(list);
//            totalPages = (int) Math.ceil((double) service.countSearch(tim, gioiTinh, trangThai).size() / size);
//            pageLb.setText(totalPages + "");
//        }
//        if (tim.equalsIgnoreCase("")) {
//            list = service.tim("", 0, gioiTinh, trangThai);
//            showData(list);
//            totalPages = (int) Math.ceil((double) service.getAll().size() / size);
//            pageLb.setText(totalPages + "");
//        }
    }//GEN-LAST:event_searchActionPerformed

    private void prevBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevBtnActionPerformed
//        if (page == 1) {
//            return;
//        }
//        page = page - 1;
//        currentPage.setText(page + "");
//        list = service.tim(timkiemTxt.getText(), page - 1, gioiTinh, trangThai);
//        showData(list);
    }//GEN-LAST:event_prevBtnActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
//        if (page >= totalPages) {
//            return;
//        }
//        page = page + 1;
//        currentPage.setText(page + "");
//        list = service.tim(timkiemTxt.getText(), page - 1, gioiTinh, trangThai);
//        showData(list);
    }//GEN-LAST:event_nextBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLKH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton conhdRB;
    private javax.swing.JLabel currentPage;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable khTable;
    private javax.swing.JComboBox<String> locGTCBo;
    private javax.swing.JComboBox<String> locTTCBo;
    private javax.swing.JTable lsgdTb;
    private javax.swing.JLabel maTxt;
    private javax.swing.JButton moiBtn;
    private javax.swing.JRadioButton namRB;
    private javax.swing.JButton nextBtn;
    private javax.swing.JRadioButton ngunghdRB;
    private javax.swing.JRadioButton nuRB;
    private javax.swing.JLabel pageLb;
    private javax.swing.JButton prevBtn;
    private javax.swing.JTextField sdtTxt;
    private javax.swing.JButton search;
    private javax.swing.JButton suaBtn;
    private javax.swing.JButton themBtn;
    private javax.swing.JTextField timkiemTxt;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
