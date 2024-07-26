package com.mycompany.ui;

import com.mycompany.ui.DoiMatKhauJDialog;
import com.mycompany.utils.Auth;
import com.mycompany.utils.MsgBox;
import com.mycompany.utils.XImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

public class EduSysJFrame extends javax.swing.JFrame {

    public EduSysJFrame() {
        initComponents();
        init();
    }

    void init() {
        setIconImage(XImage.getAppIcon());
        setLocationRelativeTo(null);
        setTitle("HỆ THỐNG QUẢN LÝ ĐÀO TẠO EDUSYS");
        new Timer(5000, new ActionListener() {
            SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a");

            @Override
            public void actionPerformed(ActionEvent e) {
                lblDongHo.setText(format.format(new Date()));
            }
        }).start();
        this.openWelcome();
        this.openLogin();
    }

    void openWelcome() {
        new ChaoJDialog(this, true).setVisible(true);
    }

    void openLogin() {
        new DangNhapJDialog(this, true).setVisible(true);
    }

    void openDoiMatKhau() {
        if (Auth.isLogin()) {
            new DoiMatKhauJDialog(this, true).setVisible(true);
        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }

    }

    void openChuyenDe() {
        if (Auth.isLogin()) {
            new ChuyenDeJDialog(this, true).setVisible(true);
        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }

    void openNguoiHoc() {
        if (Auth.isLogin()) {
            new NguoiHocJDialog(this, true).setVisible(true);
        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }

    void openKhoaHoc() {
        if (Auth.isLogin()) {
            new KhoaHocJDialog(this, true).setVisible(true);
        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }

    void openHocVien() {
        if (Auth.isLogin()) {
            new HocVienJDialog(this, true).setVisible(true);
        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }

    void openNhanVien() {
        if (Auth.isLogin()) {
            new NhanVienJDialog(this, true).setVisible(true);
        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }

    void dangXuat() {
        Auth.clear();
        openLogin();
    }

    void ketThuc() {
        if (MsgBox.confirm(this, "Bạn muốn kết thúc làm việc ?"));
        System.exit(0);
    }

    void openGioiThieu() {
        new GioiThieuJDialog(this, true).setVisible(true);
    }
    void openThongKe() {
        if (Auth.isLogin()) {
            new ThongKeJDialog(this, true).setVisible(true);

        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mnb = new javax.swing.JToolBar();
        btnDangXuat = new javax.swing.JButton();
        btnKetThuc = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnChuyenDe = new javax.swing.JButton();
        btnNguoiHoc = new javax.swing.JButton();
        btnKhoaHoc = new javax.swing.JButton();
        btnHocVien = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnHuongDan = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblDongHo = new javax.swing.JLabel();
        lblTrangThai = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuHeThong = new javax.swing.JMenu();
        mniDangNhap = new javax.swing.JMenuItem();
        mniDangXuat = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mniDoiMatKhau = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mniKetThuc = new javax.swing.JMenuItem();
        mnuQuanLy = new javax.swing.JMenu();
        mniQLNguoiHoc = new javax.swing.JMenuItem();
        mniQLChuyenDe = new javax.swing.JMenuItem();
        mniQLKhoaHoc = new javax.swing.JMenuItem();
        mniQLNhanVien = new javax.swing.JMenuItem();
        mnuThongKe = new javax.swing.JMenu();
        mniTKNguoiHoc = new javax.swing.JMenuItem();
        mniTKBangDiem = new javax.swing.JMenuItem();
        mniTKKhoaHoc = new javax.swing.JMenuItem();
        mniTKDoanhThu = new javax.swing.JMenuItem();
        mnuTroGiup = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem14 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mnb.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mnb.setRollover(true);

        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/Log out.png"))); // NOI18N
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.setFocusable(false);
        btnDangXuat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDangXuat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });
        mnb.add(btnDangXuat);

        btnKetThuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/Stop.png"))); // NOI18N
        btnKetThuc.setText("Kết thúc");
        btnKetThuc.setFocusable(false);
        btnKetThuc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKetThuc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetThucActionPerformed(evt);
            }
        });
        mnb.add(btnKetThuc);
        mnb.add(jSeparator1);

        btnChuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/Lists.png"))); // NOI18N
        btnChuyenDe.setText("Chuyên đề");
        btnChuyenDe.setFocusable(false);
        btnChuyenDe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChuyenDe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenDeActionPerformed(evt);
            }
        });
        mnb.add(btnChuyenDe);

        btnNguoiHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/User.png"))); // NOI18N
        btnNguoiHoc.setText("Người học");
        btnNguoiHoc.setFocusable(false);
        btnNguoiHoc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNguoiHoc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNguoiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNguoiHocActionPerformed(evt);
            }
        });
        mnb.add(btnNguoiHoc);

        btnKhoaHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/Certificate.png"))); // NOI18N
        btnKhoaHoc.setText("Khóa học");
        btnKhoaHoc.setFocusable(false);
        btnKhoaHoc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKhoaHoc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoaHocActionPerformed(evt);
            }
        });
        mnb.add(btnKhoaHoc);

        btnHocVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/Conference.png"))); // NOI18N
        btnHocVien.setText("Học viên");
        btnHocVien.setFocusable(false);
        btnHocVien.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHocVien.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHocVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHocVienActionPerformed(evt);
            }
        });
        mnb.add(btnHocVien);
        mnb.add(jSeparator2);

        btnHuongDan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/Globe.png"))); // NOI18N
        btnHuongDan.setText("Hướng dẫn");
        btnHuongDan.setFocusable(false);
        btnHuongDan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHuongDan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mnb.add(btnHuongDan);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblDongHo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/Alarm.png"))); // NOI18N
        lblDongHo.setText("12:12:12 PM");

        lblTrangThai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/Info.png"))); // NOI18N
        lblTrangThai.setText("HỆ QUẢN LÝ ĐÀO TẠO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTrangThai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblDongHo, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addComponent(lblTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/logo.png"))); // NOI18N

        mnuHeThong.setText("Hệ thống");

        mniDangNhap.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/Key.png"))); // NOI18N
        mniDangNhap.setText("Đăng nhập");
        mniDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDangNhapActionPerformed(evt);
            }
        });
        mnuHeThong.add(mniDangNhap);

        mniDangXuat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/Log out.png"))); // NOI18N
        mniDangXuat.setText("Đăng xuất");
        mniDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDangXuatActionPerformed(evt);
            }
        });
        mnuHeThong.add(mniDangXuat);
        mnuHeThong.add(jSeparator3);

        mniDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/Refresh.png"))); // NOI18N
        mniDoiMatKhau.setText("Đổi mật khẩu");
        mniDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDoiMatKhauActionPerformed(evt);
            }
        });
        mnuHeThong.add(mniDoiMatKhau);
        mnuHeThong.add(jSeparator4);

        mniKetThuc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        mniKetThuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/Stop.png"))); // NOI18N
        mniKetThuc.setText("Kết thúc");
        mniKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniKetThucActionPerformed(evt);
            }
        });
        mnuHeThong.add(mniKetThuc);

        jMenuBar1.add(mnuHeThong);

        mnuQuanLy.setText("Quản lý");

        mniQLNguoiHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/User.png"))); // NOI18N
        mniQLNguoiHoc.setText("Người học");
        mniQLNguoiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQLNguoiHocActionPerformed(evt);
            }
        });
        mnuQuanLy.add(mniQLNguoiHoc);

        mniQLChuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/Lists.png"))); // NOI18N
        mniQLChuyenDe.setText("Chuyên đề");
        mniQLChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQLChuyenDeActionPerformed(evt);
            }
        });
        mnuQuanLy.add(mniQLChuyenDe);

        mniQLKhoaHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/Certificate.png"))); // NOI18N
        mniQLKhoaHoc.setText("Khóa học");
        mniQLKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQLKhoaHocActionPerformed(evt);
            }
        });
        mnuQuanLy.add(mniQLKhoaHoc);

        mniQLNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/User group.png"))); // NOI18N
        mniQLNhanVien.setText("Nhân viên");
        mniQLNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQLNhanVienActionPerformed(evt);
            }
        });
        mnuQuanLy.add(mniQLNhanVien);

        jMenuBar1.add(mnuQuanLy);

        mnuThongKe.setText("Thống kê");

        mniTKNguoiHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/Clien list.png"))); // NOI18N
        mniTKNguoiHoc.setText("Người học từng năm");
        mniTKNguoiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTKNguoiHocActionPerformed(evt);
            }
        });
        mnuThongKe.add(mniTKNguoiHoc);

        mniTKBangDiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/Card file.png"))); // NOI18N
        mniTKBangDiem.setText("Bảng điểm khóa...");
        mniTKBangDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTKBangDiemActionPerformed(evt);
            }
        });
        mnuThongKe.add(mniTKBangDiem);

        mniTKKhoaHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/Bar chart.png"))); // NOI18N
        mniTKKhoaHoc.setText("Điểm từng khóa học");
        mniTKKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTKKhoaHocActionPerformed(evt);
            }
        });
        mnuThongKe.add(mniTKKhoaHoc);

        mniTKDoanhThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/Dollar.png"))); // NOI18N
        mniTKDoanhThu.setText("Doanh thu từng chuyên đề...");
        mniTKDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTKDoanhThuActionPerformed(evt);
            }
        });
        mnuThongKe.add(mniTKDoanhThu);

        jMenuBar1.add(mnuThongKe);

        mnuTroGiup.setText("Trợ giúp");

        jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/Globe.png"))); // NOI18N
        jMenuItem13.setText("Hướng dẫn sử dụng");
        mnuTroGiup.add(jMenuItem13);
        mnuTroGiup.add(jSeparator5);

        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/Home.png"))); // NOI18N
        jMenuItem14.setText("Giới thiệu sản phẩm");
        jMenuItem14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem14MouseClicked(evt);
            }
        });
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        mnuTroGiup.add(jMenuItem14);

        jMenuBar1.add(mnuTroGiup);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mnb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mnb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNguoiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNguoiHocActionPerformed
        openNguoiHoc();
    }//GEN-LAST:event_btnNguoiHocActionPerformed

    private void mniDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDangXuatActionPerformed
        dangXuat();
    }//GEN-LAST:event_mniDangXuatActionPerformed

    private void mniDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDoiMatKhauActionPerformed
        openDoiMatKhau();
    }//GEN-LAST:event_mniDoiMatKhauActionPerformed

    private void mniDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDangNhapActionPerformed
        openLogin();
    }//GEN-LAST:event_mniDangNhapActionPerformed

    private void mniKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniKetThucActionPerformed
        ketThuc();
    }//GEN-LAST:event_mniKetThucActionPerformed

    private void btnKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetThucActionPerformed
        ketThuc();
    }//GEN-LAST:event_btnKetThucActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        dangXuat();
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenDeActionPerformed
        openChuyenDe();
    }//GEN-LAST:event_btnChuyenDeActionPerformed

    private void mniQLChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQLChuyenDeActionPerformed
        openChuyenDe();
    }//GEN-LAST:event_mniQLChuyenDeActionPerformed

    private void mniQLNguoiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQLNguoiHocActionPerformed
        openNguoiHoc();
    }//GEN-LAST:event_mniQLNguoiHocActionPerformed

    private void btnKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoaHocActionPerformed
        openKhoaHoc();
    }//GEN-LAST:event_btnKhoaHocActionPerformed

    private void mniQLKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQLKhoaHocActionPerformed
        openKhoaHoc();
    }//GEN-LAST:event_mniQLKhoaHocActionPerformed

    private void btnHocVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHocVienActionPerformed
        openHocVien();
    }//GEN-LAST:event_btnHocVienActionPerformed

    private void mniQLNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQLNhanVienActionPerformed
        openNhanVien();
    }//GEN-LAST:event_mniQLNhanVienActionPerformed

    private void jMenuItem14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem14MouseClicked

    }//GEN-LAST:event_jMenuItem14MouseClicked

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        openGioiThieu();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void mniTKNguoiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTKNguoiHocActionPerformed
        // TODO add your handling code here:
        openThongKe();
        
    }//GEN-LAST:event_mniTKNguoiHocActionPerformed

    private void mniTKBangDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTKBangDiemActionPerformed
        // TODO add your handling code here:
        openThongKe();
    }//GEN-LAST:event_mniTKBangDiemActionPerformed

    private void mniTKKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTKKhoaHocActionPerformed
        // TODO add your handling code here:
        openThongKe();
    }//GEN-LAST:event_mniTKKhoaHocActionPerformed

    private void mniTKDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTKDoanhThuActionPerformed
        // TODO add your handling code here:
        openThongKe();
    }//GEN-LAST:event_mniTKDoanhThuActionPerformed

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
            java.util.logging.Logger.getLogger(EduSysJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EduSysJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EduSysJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EduSysJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EduSysJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChuyenDe;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnHocVien;
    private javax.swing.JButton btnHuongDan;
    private javax.swing.JButton btnKetThuc;
    private javax.swing.JButton btnKhoaHoc;
    private javax.swing.JButton btnNguoiHoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JLabel lblDongHo;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JToolBar mnb;
    private javax.swing.JMenuItem mniDangNhap;
    private javax.swing.JMenuItem mniDangXuat;
    private javax.swing.JMenuItem mniDoiMatKhau;
    private javax.swing.JMenuItem mniKetThuc;
    private javax.swing.JMenuItem mniQLChuyenDe;
    private javax.swing.JMenuItem mniQLKhoaHoc;
    private javax.swing.JMenuItem mniQLNguoiHoc;
    private javax.swing.JMenuItem mniQLNhanVien;
    private javax.swing.JMenuItem mniTKBangDiem;
    private javax.swing.JMenuItem mniTKDoanhThu;
    private javax.swing.JMenuItem mniTKKhoaHoc;
    private javax.swing.JMenuItem mniTKNguoiHoc;
    private javax.swing.JMenu mnuHeThong;
    private javax.swing.JMenu mnuQuanLy;
    private javax.swing.JMenu mnuThongKe;
    private javax.swing.JMenu mnuTroGiup;
    // End of variables declaration//GEN-END:variables
}
