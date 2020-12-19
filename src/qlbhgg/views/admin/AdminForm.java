/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.views.admin;

import Controller.InterfaceController.ListKind;
import Controller.InterfaceController.SetDashboard;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import java.awt.Image;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import qlbhgg.models.Users;
import qlbhgg.views.login.LoginForm;
import qlbhgg.views.staff.PanelProfileStaff;

/**
 *
 * @author acer
 */
public final class AdminForm extends javax.swing.JFrame {

    /**
     * Creates new form AdminForm
     */
    DefaultTableModel tableModel;
    public int XX, YY;
    public Users userLogin;
    
    public AdminForm(Users user) throws SQLException {
        userLogin = user;
        initComponents();
       
        SetDashboard sd = new SetDashboard(jPanelBody);
        sd.setView(jPanelQLDH, jLabelQLDH);
        ArrayList<ListKind> list = new ArrayList<>();
        list.add(new ListKind("QLDH", jPanelQLDH, jLabelQLDH));
        list.add(new ListKind("QLNV", jPanelQLNV, jLabelQLNV));
        list.add(new ListKind("QLK", jPanelQLK, jLabelQLK));
        list.add(new ListKind("QLNCC", jPanelQLNCC, jLabelQLNCC));
        list.add(new ListKind("TTKH", jPanelTTKH, jLabelTTKH));
        list.add(new ListKind("TK", jPanelTK, jLabelTK));
        sd.setEvent(list);
        jLabelUserLogin.setText(userLogin.getFullname());
    }
    private ImageIcon scaleImageProduct(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(78, 78, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }

    private ImageIcon scaleImageFrameStaff(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(380, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }

    private ImageIcon scaleImageAvatar(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(85, 85, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }

    private ImageIcon scaleImformationAvatar(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }

    private ImageIcon scaleButtonEdit(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(270, 40, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }

    private ImageIcon scaleButtonRefresh(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(130, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }

    private ImageIcon scaleButtonAddStaff(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(190, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }

    private ImageIcon scaleFrameSearch(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(280, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }
//    private void renderJDashboardImformationStaff(int n) throws SQLException {
//
//        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
//        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
//        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
//        u = ListUsers.get(pageStaff + n);
//        ListWorkday = WorkDayDao.findByUsername(u);
//        selectedMonth = cal.get(Calendar.MONTH);
//        selectedYear = cal.get(Calendar.YEAR);
//        showCalendar();
//        jLabelInformationNameStaff.setText(u.getFullname());
//        jLabelAvatarStaff.setIcon(scaleImformationAvatar(u.getImage_user()));
//        jLabelInformationId.setText(u.getId());
//        jLabelInformationUsername.setText(u.getUsername());
//        jLabelInformationGender.setText(u.getGender());
//        if (u.getGender().equals("Nam")) {
//            jLabelInformationGender1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_25px.png")));
//        } else {
//            jLabelInformationGender1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_female_25px.png")));
//        }
//        jLabelInformationBirthday.setText(u.getBirthday().toString());
//        jLabelInformationStartdate.setText(u.getStartdate().toString());
//        jLabelInformationAddress.setText(u.getAddress());
//        jLabelInformationEmail.setText(u.getEmail());
//        jLabelInformationPhonenumber.setText(u.getPhonenumber());
//        jLabelInformationBasicsalary.setText(String.format("%1$,.0f" + " VNĐ", u.getBasicsalary()));
//        jLabelInformationAllowance.setText(String.format("%1$,.0f" + " VNĐ", u.getAllowance()));
//        jLabelBBButtonEditStaff.setIcon(scaleButtonEdit("/Image/ButtonEditLight.png"));
//        jLabelBBButtonStatusStaff.setIcon(scaleButtonEdit("/Image/ButtonEditLight.png"));
//        jLabelBBButtonDeleteStaff.setIcon(scaleButtonEdit("/Image/ButtonEditLight.png"));
//        jLabelButtonEditStaff.setText("Sửa thông tin nhân viên");
//        jLabelBackToQLNV.setText("Quản lý nhân viên");
//        jLabelButtonEditPassword.setVisible(false);
//        jLabelBBButtonEditPassword.setVisible(false);
//        jLabelButtonDeleteStaff.setVisible(true);
//        jLabelBBButtonDeleteStaff.setVisible(true);
//        jLabelButtonStatusStaff.setVisible(true);
//        jLabelBBButtonStatusStaff.setVisible(true);
//        if (u.getStatus().equals("Hoạt động")) {
//            jLabelButtonStatusStaff.setText("Hoạt động");
//            jLabelButtonStatusStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px.png")));
//            jLabelButtonStatusStaff.setForeground(Color.green);
//        } else {
//            jLabelButtonStatusStaff.setText("Khóa");
//            jLabelButtonStatusStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px_1.png")));
//            jLabelButtonStatusStaff.setForeground(Color.red);
//        }
//    }
//
//    private void renderJDashboardProfile() throws SQLException {
//        
//        ListWorkday = WorkDayDao.findByUsername(userLogin);
//        selectedMonth = cal.get(Calendar.MONTH);
//        selectedYear = cal.get(Calendar.YEAR);
//        u = userLogin;
//        showCalendar();
//        jLabelInformationNameStaff.setText(userLogin.getFullname());
//        jLabelAvatarStaff.setIcon(scaleImformationAvatar(u.getImage_user()));
//        jLabelInformationId.setText(userLogin.getId());
//        jLabelInformationUsername.setText(userLogin.getUsername());
//        jLabelInformationGender.setText(userLogin.getGender());
//        if (u.getGender().equals("Nam")) {
//            jLabelInformationGender1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_25px.png")));
//        } else {
//            jLabelInformationGender1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_female_25px.png")));
//        }
//        jLabelInformationBirthday.setText(userLogin.getBirthday().toString());
//        jLabelInformationStartdate.setText(userLogin.getStartdate().toString());
//        jLabelInformationAddress.setText(userLogin.getAddress());
//        jLabelInformationEmail.setText(userLogin.getEmail());
//        jLabelInformationPhonenumber.setText(userLogin.getPhonenumber());
//        jLabelInformationBasicsalary.setText(String.format("%1$,.0f" + " VNĐ", userLogin.getBasicsalary()));
//        jLabelInformationAllowance.setText(String.format("%1$,.0f" + " VNĐ", userLogin.getAllowance()));
//        jLabelBBButtonEditStaff.setIcon(scaleButtonEdit("/Image/ButtonEditLight.png"));
//        jLabelButtonEditStaff.setText("Sửa thông tin cá nhân");
//        jLabelBBButtonEditPassword.setIcon(scaleButtonEdit("/Image/ButtonEditLight.png"));
//        jLabelBackToQLNV.setText("Quay lại");
//        jLabelButtonEditPassword.setVisible(true);
//        jLabelBBButtonEditPassword.setVisible(true);
//        jLabelButtonDeleteStaff.setVisible(false);
//        jLabelBBButtonDeleteStaff.setVisible(false);
//        jLabelButtonStatusStaff.setVisible(false);
//        jLabelBBButtonStatusStaff.setVisible(false);
//    }
//
//    public void popUpImageStaff(int n) {
//        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
//        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
//        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
//        Users u = ListUsers.get(pageStaff + n);
//        DisplayImage di = new DisplayImage(u.getFullname(), u.getImage_user());
//        di.setVisible(true);
//        di.pack();
//        di.setLocationRelativeTo(null);
//    }
//
//    public void popUpImageProduct(int n) {
//        setPageProduct = (countProduct % 7 == 0) ? 0 : 1;
//        jLabelPageProduct.setText("/" + String.valueOf(countProduct / 7 + setPageProduct));
//        int pageProduct = (Integer.parseInt(jTextFieldPageProduct.getText()) - 1) * 7;
//        Goods g = ListGoods.get(pageProduct + n);
//        DisplayImage di = new DisplayImage(g.getItemname(), g.getImageitem());
//        di.setVisible(true);
//        di.pack();
//        di.setLocationRelativeTo(null);
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //markinit


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBackground = new javax.swing.JPanel();
        jPanelMenu = new javax.swing.JPanel();
        jLabelLogout = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanelTK = new javax.swing.JPanel();
        jLabelTK = new javax.swing.JLabel();
        jPanelQLNV = new javax.swing.JPanel();
        jLabelQLNV = new javax.swing.JLabel();
        jPanelQLNCC = new javax.swing.JPanel();
        jLabelQLNCC = new javax.swing.JLabel();
        jPanelQLK = new javax.swing.JPanel();
        jLabelQLK = new javax.swing.JLabel();
        jPanelQLDH = new javax.swing.JPanel();
        jLabelQLDH = new javax.swing.JLabel();
        jPanelTTKH = new javax.swing.JPanel();
        jLabelTTKH = new javax.swing.JLabel();
        jPanelProfile = new javax.swing.JPanel();
        jLabelUserLogin = new javax.swing.JLabel();
        jPanelBody = new javax.swing.JPanel();
        jPanelBar = new javax.swing.JPanel();
        btnExit = new javax.swing.JLabel();
        btnMinimize = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setUndecorated(true);

        jBackground.setBackground(new java.awt.Color(255, 255, 255));
        jBackground.setForeground(new java.awt.Color(0, 0, 0));
        jBackground.setPreferredSize(new java.awt.Dimension(1600, 900));
        jBackground.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jBackgroundMouseDragged(evt);
            }
        });
        jBackground.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBackgroundMousePressed(evt);
            }
        });
        jBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMenu.setBackground(new java.awt.Color(0, 0, 0));
        jPanelMenu.setForeground(new java.awt.Color(0, 0, 0));
        jPanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelLogout.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogout.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelLogout.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_logout_rounded_left_20px_1.png"))); // NOI18N
        jLabelLogout.setText("  Đăng xuất");
        jLabelLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelLogoutMouseExited(evt);
            }
        });
        jPanelMenu.add(jLabelLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 850, 170, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gear_100px_1.png"))); // NOI18N
        jLabel6.setText("KMA-Gear");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelMenu.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 150));

        jPanelTK.setBackground(new java.awt.Color(0, 0, 0));
        jPanelTK.setForeground(new java.awt.Color(0, 0, 0));
        jPanelTK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelTKMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelTKMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelTKMouseExited(evt);
            }
        });

        jLabelTK.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTK.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTK.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_area_chart_30px.png"))); // NOI18N
        jLabelTK.setText("  Thống kê");
        jLabelTK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanelTKLayout = new javax.swing.GroupLayout(jPanelTK);
        jPanelTK.setLayout(jPanelTKLayout);
        jPanelTKLayout.setHorizontalGroup(
            jPanelTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTKLayout.createSequentialGroup()
                .addComponent(jLabelTK, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 104, Short.MAX_VALUE))
        );
        jPanelTKLayout.setVerticalGroup(
            jPanelTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTKLayout.createSequentialGroup()
                .addComponent(jLabelTK, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelMenu.add(jPanelTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 270, 60));

        jPanelQLNV.setBackground(new java.awt.Color(0, 0, 0));
        jPanelQLNV.setForeground(new java.awt.Color(0, 0, 0));
        jPanelQLNV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelQLNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelQLNVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelQLNVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelQLNVMouseExited(evt);
            }
        });

        jLabelQLNV.setBackground(new java.awt.Color(255, 255, 255));
        jLabelQLNV.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelQLNV.setForeground(new java.awt.Color(255, 255, 255));
        jLabelQLNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelQLNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_staff_30px.png"))); // NOI18N
        jLabelQLNV.setText("  Quản lý nhân viên");

        javax.swing.GroupLayout jPanelQLNVLayout = new javax.swing.GroupLayout(jPanelQLNV);
        jPanelQLNV.setLayout(jPanelQLNVLayout);
        jPanelQLNVLayout.setHorizontalGroup(
            jPanelQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQLNVLayout.createSequentialGroup()
                .addComponent(jLabelQLNV, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
        );
        jPanelQLNVLayout.setVerticalGroup(
            jPanelQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelQLNV, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelQLNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 270, 60));

        jPanelQLNCC.setBackground(new java.awt.Color(0, 0, 0));
        jPanelQLNCC.setForeground(new java.awt.Color(0, 0, 0));
        jPanelQLNCC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelQLNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelQLNCCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelQLNCCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelQLNCCMouseExited(evt);
            }
        });

        jLabelQLNCC.setBackground(new java.awt.Color(255, 255, 255));
        jLabelQLNCC.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelQLNCC.setForeground(new java.awt.Color(255, 255, 255));
        jLabelQLNCC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelQLNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_supplier_30px.png"))); // NOI18N
        jLabelQLNCC.setText("  Quản lý nhà cung cấp");

        javax.swing.GroupLayout jPanelQLNCCLayout = new javax.swing.GroupLayout(jPanelQLNCC);
        jPanelQLNCC.setLayout(jPanelQLNCCLayout);
        jPanelQLNCCLayout.setHorizontalGroup(
            jPanelQLNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelQLNCC, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        jPanelQLNCCLayout.setVerticalGroup(
            jPanelQLNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelQLNCC, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelQLNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 270, 60));

        jPanelQLK.setBackground(new java.awt.Color(0, 0, 0));
        jPanelQLK.setForeground(new java.awt.Color(0, 0, 0));
        jPanelQLK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelQLK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelQLKMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelQLKMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelQLKMouseExited(evt);
            }
        });

        jLabelQLK.setBackground(new java.awt.Color(0, 0, 0));
        jLabelQLK.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelQLK.setForeground(new java.awt.Color(255, 255, 255));
        jLabelQLK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelQLK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_warehouse_30px.png"))); // NOI18N
        jLabelQLK.setText("  Quản lý kho hàng");

        javax.swing.GroupLayout jPanelQLKLayout = new javax.swing.GroupLayout(jPanelQLK);
        jPanelQLK.setLayout(jPanelQLKLayout);
        jPanelQLKLayout.setHorizontalGroup(
            jPanelQLKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQLKLayout.createSequentialGroup()
                .addComponent(jLabelQLK, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 37, Short.MAX_VALUE))
        );
        jPanelQLKLayout.setVerticalGroup(
            jPanelQLKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelQLK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelQLK, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 270, 60));

        jPanelQLDH.setBackground(new java.awt.Color(0, 0, 0));
        jPanelQLDH.setForeground(new java.awt.Color(0, 0, 0));
        jPanelQLDH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelQLDH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelQLDHMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelQLDHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelQLDHMouseExited(evt);
            }
        });

        jLabelQLDH.setBackground(new java.awt.Color(255, 255, 255));
        jLabelQLDH.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelQLDH.setForeground(new java.awt.Color(255, 255, 255));
        jLabelQLDH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelQLDH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_bill_30px.png"))); // NOI18N
        jLabelQLDH.setText("  Quản lý đơn hàng");

        javax.swing.GroupLayout jPanelQLDHLayout = new javax.swing.GroupLayout(jPanelQLDH);
        jPanelQLDH.setLayout(jPanelQLDHLayout);
        jPanelQLDHLayout.setHorizontalGroup(
            jPanelQLDHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQLDHLayout.createSequentialGroup()
                .addComponent(jLabelQLDH, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 39, Short.MAX_VALUE))
        );
        jPanelQLDHLayout.setVerticalGroup(
            jPanelQLDHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQLDHLayout.createSequentialGroup()
                .addComponent(jLabelQLDH, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelMenu.add(jPanelQLDH, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 270, 60));

        jPanelTTKH.setBackground(new java.awt.Color(0, 0, 0));
        jPanelTTKH.setForeground(new java.awt.Color(0, 0, 0));
        jPanelTTKH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelTTKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelTTKHMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelTTKHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelTTKHMouseExited(evt);
            }
        });

        jLabelTTKH.setBackground(new java.awt.Color(0, 0, 0));
        jLabelTTKH.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTTKH.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTTKH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTTKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_customer_insight_30px.png"))); // NOI18N
        jLabelTTKH.setText("  Thông tin khách hàng");
        jLabelTTKH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanelTTKHLayout = new javax.swing.GroupLayout(jPanelTTKH);
        jPanelTTKH.setLayout(jPanelTTKHLayout);
        jPanelTTKHLayout.setHorizontalGroup(
            jPanelTTKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTTKHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTTKH, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
        );
        jPanelTTKHLayout.setVerticalGroup(
            jPanelTTKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTTKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelTTKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 270, 60));

        jPanelProfile.setBackground(new java.awt.Color(0, 0, 0));
        jPanelProfile.setForeground(new java.awt.Color(0, 0, 0));
        jPanelProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelProfileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelProfileMouseExited(evt);
            }
        });

        jLabelUserLogin.setBackground(new java.awt.Color(255, 255, 255));
        jLabelUserLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelUserLogin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUserLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUserLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_profiles_20px_1.png"))); // NOI18N
        jLabelUserLogin.setText("  Phạm Duy Tài 1");
        jLabelUserLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelUserLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelUserLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelUserLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelUserLoginMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelProfileLayout = new javax.swing.GroupLayout(jPanelProfile);
        jPanelProfile.setLayout(jPanelProfileLayout);
        jPanelProfileLayout.setHorizontalGroup(
            jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
            .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelProfileLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabelUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelProfileLayout.setVerticalGroup(
            jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelProfileLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabelUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanelMenu.add(jPanelProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 780, 270, 60));

        jBackground.add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 900));

        jPanelBody.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBody.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jBackground.add(jPanelBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 1330, 870));

        jPanelBar.setBackground(new java.awt.Color(0, 0, 0));

        btnExit.setBackground(new java.awt.Color(255, 255, 255));
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_close_window_25px_4.png"))); // NOI18N
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });

        btnMinimize.setBackground(new java.awt.Color(255, 255, 255));
        btnMinimize.setForeground(new java.awt.Color(255, 255, 255));
        btnMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_minimize_window_25px_2.png"))); // NOI18N
        btnMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelBarLayout = new javax.swing.GroupLayout(jPanelBar);
        jPanelBar.setLayout(jPanelBarLayout);
        jPanelBarLayout.setHorizontalGroup(
            jPanelBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBarLayout.createSequentialGroup()
                .addGap(0, 1278, Short.MAX_VALUE)
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelBarLayout.setVerticalGroup(
            jPanelBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jBackground.add(jPanelBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 1330, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1600, 900));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBackgroundMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackgroundMousePressed
        // TODO add your handling code here:
        XX = evt.getX();
        YY = evt.getY();
    }//GEN-LAST:event_jBackgroundMousePressed

    private void jBackgroundMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackgroundMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - XX, y - YY);
    }//GEN-LAST:event_jBackgroundMouseDragged

    private void jPanelQLDHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLDHMouseClicked
        // TODO add your handling code here:
//        qlhd = true;
//        qlk = false;
//        qlnv = false;
//        qlncc = false;
//        tk = false;
//        ttkh = false;
//        jPanelQLDH.setBackground(new java.awt.Color(102, 178, 255));
//        jPanelQLK.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelQLNV.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelQLNCC.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelTK.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelTTKH.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelBody.removeAll();
//        jPanelBody.add(jDashboardQLDH);
//        jPanelBody.repaint();
//        jPanelBody.revalidate();
    }//GEN-LAST:event_jPanelQLDHMouseClicked

    private void jPanelQLKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLKMouseClicked
        // TODO add your handling code here:
//        qlhd = false;
//        qlk = true;
//        qlnv = false;
//        qlncc = false;
//        tk = false;
//        ttkh = false;
//        jPanelQLDH.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelQLK.setBackground(new java.awt.Color(102, 178, 255));
//        jPanelQLNV.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelQLNCC.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelTK.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelTTKH.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelBody.removeAll();
////        jPanelBody.repaint();
////        jPanelBody.revalidate();
//        jPanelBody.add(jDashboardQLK);
//        jPanelBody.repaint();
//        jPanelBody.revalidate();
    }//GEN-LAST:event_jPanelQLKMouseClicked

    private void jPanelQLNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLNCCMouseClicked
        // TODO add your handling code here:
//        qlhd = false;
//        qlk = false;
//        qlnv = false;
//        qlncc = true;
//        tk = false;
//        ttkh = false;
//        jPanelQLDH.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelQLK.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelQLNV.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelQLNCC.setBackground(new java.awt.Color(102, 178, 255));
//        jPanelTK.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelTTKH.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelBody.removeAll();
////        jPanelBody.repaint();
////        jPanelBody.revalidate();
//        jPanelBody.add(jDashboardQLNCC);
//        jPanelBody.repaint();
//        jPanelBody.revalidate();
    }//GEN-LAST:event_jPanelQLNCCMouseClicked

    private void jPanelQLNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLNVMouseClicked
        // TODO add your handling code here:
//        qlhd = false;
//        qlk = false;
//        qlnv = true;
//        qlncc = false;
//        tk = false;
//        ttkh = false;
//        jPanelQLDH.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelQLK.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelQLNV.setBackground(new java.awt.Color(102, 178, 255));
//        jPanelQLNCC.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelTK.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelTTKH.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelBody.removeAll();
////        jPanelBody.repaint();
////        jPanelBody.revalidate();
//        jPanelBody.add(jDashboardQLNV);
//        jPanelBody.repaint();
//        jPanelBody.revalidate();
    }//GEN-LAST:event_jPanelQLNVMouseClicked

    private void jPanelTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelTKMouseClicked
        // TODO add your handling code here:
//        qlhd = false;
//        qlk = false;
//        qlnv = false;
//        qlncc = false;
//        tk = true;
//        ttkh = false;
//        jPanelQLDH.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelQLK.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelQLNV.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelQLNCC.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelTK.setBackground(new java.awt.Color(102, 178, 255));
//        jPanelTTKH.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelBody.removeAll();
////        jPanelBody.repaint();
////        jPanelBody.revalidate();
//        jPanelBody.add(jDashboardTK);
//        jPanelBody.repaint();
//        jPanelBody.revalidate();
    }//GEN-LAST:event_jPanelTKMouseClicked

    private void jPanelQLDHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLDHMouseEntered
       
    }//GEN-LAST:event_jPanelQLDHMouseEntered

    private void jPanelQLDHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLDHMouseExited
        
    }//GEN-LAST:event_jPanelQLDHMouseExited

    private void jPanelQLKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLKMouseEntered
       
    }//GEN-LAST:event_jPanelQLKMouseEntered

    private void jPanelQLKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLKMouseExited
       
    }//GEN-LAST:event_jPanelQLKMouseExited

    private void jPanelQLNCCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLNCCMouseEntered
       
    }//GEN-LAST:event_jPanelQLNCCMouseEntered

    private void jPanelQLNCCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLNCCMouseExited
        
    }//GEN-LAST:event_jPanelQLNCCMouseExited

    private void jPanelQLNVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLNVMouseEntered
        
    }//GEN-LAST:event_jPanelQLNVMouseEntered

    private void jPanelQLNVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLNVMouseExited
       
    }//GEN-LAST:event_jPanelQLNVMouseExited

    private void jPanelTKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelTKMouseEntered
        
    }//GEN-LAST:event_jPanelTKMouseEntered

    private void jPanelTKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelTKMouseExited
        
    }//GEN-LAST:event_jPanelTKMouseExited

    private void jPanelTTKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelTTKHMouseClicked
        // TODO add your handling code here:
//        qlhd = false;
//        qlk = false;
//        qlnv = false;
//        qlncc = false;
//        tk = false;
//        ttkh = true;
//        jPanelQLDH.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelQLK.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelQLNV.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelQLNCC.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelTK.setBackground(new java.awt.Color(0, 0, 0));
//        jPanelTTKH.setBackground(new java.awt.Color(102, 178, 255));
//        jPanelBody.removeAll();
////        jPanelBody.repaint();
////        jPanelBody.revalidate();
//        jPanelBody.add(jDashboardTTKH);
//        jPanelBody.repaint();
//        jPanelBody.revalidate();
    }//GEN-LAST:event_jPanelTTKHMouseClicked

    private void jPanelTTKHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelTTKHMouseEntered
        
    }//GEN-LAST:event_jPanelTTKHMouseEntered

    private void jPanelTTKHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelTTKHMouseExited
        
    }//GEN-LAST:event_jPanelTTKHMouseExited

    private void jLabelLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogoutMouseEntered
        jLabelLogout.setForeground(new java.awt.Color(102, 178, 255));
        jLabelLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_logout_rounded_left_20px.png")));
    }//GEN-LAST:event_jLabelLogoutMouseEntered

    private void jLabelLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogoutMouseExited
        jLabelLogout.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_logout_rounded_left_20px_1.png")));
    }//GEN-LAST:event_jLabelLogoutMouseExited

    private void jLabelLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogoutMouseClicked
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (!"Nimbus".equals(info.getName())) {
                } else {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        LoginForm lf = new LoginForm();
        lf.pack();
        lf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabelLogoutMouseClicked

    private void jLabelUserLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelUserLoginMouseClicked
        jPanelBody.removeAll();
        try {
            jPanelBody.add(new PanelProfileStaff(userLogin));
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        jPanelBody.validate();
        jPanelBody.repaint();
    }//GEN-LAST:event_jLabelUserLoginMouseClicked

    private void jPanelProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelProfileMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelProfileMouseClicked

    private void jPanelProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelProfileMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelProfileMouseEntered

    private void jPanelProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelProfileMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelProfileMouseExited

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        // TODO add your handling code here:
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_close_window_25px_3.png")));
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        // TODO add your handling code here:
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_close_window_25px_4.png")));
    }//GEN-LAST:event_btnExitMouseExited

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(AdminForm.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseEntered
        // TODO add your handling code here:
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_minimize_window_25px_1.png")));
    }//GEN-LAST:event_btnMinimizeMouseEntered

    private void btnMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseExited
        // TODO add your handling code here:
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_minimize_window_25px_2.png")));
    }//GEN-LAST:event_btnMinimizeMouseExited

    private void jLabelUserLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelUserLoginMouseEntered
        // TODO add your handling code here:
        jLabelUserLogin.setForeground(new java.awt.Color(102,178,255));
        jLabelUserLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_profiles_20px.png")));
    }//GEN-LAST:event_jLabelUserLoginMouseEntered

    private void jLabelUserLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelUserLoginMouseExited
        jLabelUserLogin.setForeground(new java.awt.Color(255,255,255));
        jLabelUserLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_profiles_20px_1.png")));
    }//GEN-LAST:event_jLabelUserLoginMouseExited

    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Users us = new Users();
                try {
                    new AdminForm(us).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JPanel jBackground;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelLogout;
    private javax.swing.JLabel jLabelQLDH;
    private javax.swing.JLabel jLabelQLK;
    private javax.swing.JLabel jLabelQLNCC;
    private javax.swing.JLabel jLabelQLNV;
    private javax.swing.JLabel jLabelTK;
    private javax.swing.JLabel jLabelTTKH;
    private javax.swing.JLabel jLabelUserLogin;
    private javax.swing.JPanel jPanelBar;
    private javax.swing.JPanel jPanelBody;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelProfile;
    private javax.swing.JPanel jPanelQLDH;
    private javax.swing.JPanel jPanelQLK;
    private javax.swing.JPanel jPanelQLNCC;
    private javax.swing.JPanel jPanelQLNV;
    private javax.swing.JPanel jPanelTK;
    private javax.swing.JPanel jPanelTTKH;
    // End of variables declaration//GEN-END:variables
}
