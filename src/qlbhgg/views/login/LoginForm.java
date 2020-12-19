/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.views.login;

<<<<<<< Updated upstream:src/qlbhgg/views/login/LoginForm.java
import qlbhgg.views.admin.AdminForm;
=======
<<<<<<< HEAD:src/qlbhgg/views/login/LoginForm.java
<<<<<<< HEAD:src/qlbhgg/views/login/LoginForm.java
import qlbhgg.views.admin.AdminForm;
=======
>>>>>>> 1d8032b0d1e15e63244a73933322ec0773a9ce98:src/JavaForm/LoginForm.java
=======
>>>>>>> 1d8032b0d1e15e63244a73933322ec0773a9ce98:src/JavaForm/LoginForm.java
>>>>>>> Stashed changes:src/JavaForm/LoginForm.java
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
<<<<<<< Updated upstream:src/qlbhgg/views/login/LoginForm.java
=======
<<<<<<< HEAD:src/qlbhgg/views/login/LoginForm.java
<<<<<<< HEAD:src/qlbhgg/views/login/LoginForm.java
>>>>>>> Stashed changes:src/JavaForm/LoginForm.java
import qlbhgg.models.Users;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlbhgg.views.staff.StaffForm;
<<<<<<< Updated upstream:src/qlbhgg/views/login/LoginForm.java
=======
=======
import JavaClassObject.Users;
>>>>>>> 1d8032b0d1e15e63244a73933322ec0773a9ce98:src/JavaForm/LoginForm.java
=======
import JavaClassObject.Users;
>>>>>>> 1d8032b0d1e15e63244a73933322ec0773a9ce98:src/JavaForm/LoginForm.java
>>>>>>> Stashed changes:src/JavaForm/LoginForm.java

/**
 *
 * @author acer
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    int XX, YY;
    public String un;

    public String getUsername() {
        return un;
    }

    public LoginForm() {
        initComponents();
//        jLabelMK.setVisible(true);
//        jLabelTK.setVisible(true);
        jErrorIcon1.setVisible(false);
        jErrorIcon2.setVisible(false);
        jClearPassword.setVisible(false);
        jClearUsername.setVisible(false);
    }

<<<<<<< Updated upstream:src/qlbhgg/views/login/LoginForm.java
    public void Signin() throws SQLException {
        lbWrongPass.setText("");
=======
<<<<<<< HEAD:src/qlbhgg/views/login/LoginForm.java
<<<<<<< HEAD:src/qlbhgg/views/login/LoginForm.java
    public void Signin() throws SQLException {
        lbWrongPass.setText("");
=======
=======
>>>>>>> 1d8032b0d1e15e63244a73933322ec0773a9ce98:src/JavaForm/LoginForm.java
    public void Signin() {
        lbWrongPass.setText("");
        lbQuenMK.setText("");
        lbQuenMK.setEnabled(false);
<<<<<<< HEAD:src/qlbhgg/views/login/LoginForm.java
>>>>>>> 1d8032b0d1e15e63244a73933322ec0773a9ce98:src/JavaForm/LoginForm.java
=======
>>>>>>> 1d8032b0d1e15e63244a73933322ec0773a9ce98:src/JavaForm/LoginForm.java
>>>>>>> Stashed changes:src/JavaForm/LoginForm.java
        lbWrongUsername.setText("");
        jErrorIcon1.setVisible(false);
        jErrorIcon2.setVisible(false);
        String userName = txtUsername.getText();
        String passWord = String.valueOf(jPasswordField.getPassword());
        String Sql = "select * from users where user_name = '" + userName + "'";
<<<<<<< Updated upstream:src/qlbhgg/views/login/LoginForm.java

=======
<<<<<<< HEAD:src/qlbhgg/views/login/LoginForm.java
<<<<<<< HEAD:src/qlbhgg/views/login/LoginForm.java

=======
>>>>>>> 1d8032b0d1e15e63244a73933322ec0773a9ce98:src/JavaForm/LoginForm.java
=======
>>>>>>> 1d8032b0d1e15e63244a73933322ec0773a9ce98:src/JavaForm/LoginForm.java
>>>>>>> Stashed changes:src/JavaForm/LoginForm.java
        if ("".equals(userName) || "".equals(passWord)) {
            lbWrongPass.setText("Bạn chưa điền đủ thông tin đăng nhập!");
        } else {
            try {
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
                Statement myStmt = myConn.createStatement();
                ResultSet myRs = myStmt.executeQuery(Sql);
                if (myRs.next()) {
                    Users user = Users.getFromResultSet(myRs);
                    if (txtUsername.getText().equals(user.getUsername())) {
                        if (user.checkPassword(String.valueOf(jPasswordField.getPassword()))) {
<<<<<<< Updated upstream:src/qlbhgg/views/login/LoginForm.java
                            if (user.getStatus().equals("Khóa")) {
                                lbWrongPass.setText("Tài khoản của bạn đã bị khóa");
                            } else {
                                try {
                                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                                            if ("Windows".equals(info.getName())) {
                                                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                                break;
                                            }
                                        }
                                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
                                        java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                                    }
                                if ("Quản lý".equals(user.getRole())) {
                                    AdminForm af = new AdminForm(user);
                                    af.setVisible(true);
                                    af.pack();
                                    af.setLocationRelativeTo(null);

                                } else {
                                    StaffForm sf = new StaffForm(user);
                                    sf.setVisible(true);
                                    sf.pack();
                                    sf.setLocationRelativeTo(null);
                                }
                                this.dispose();
=======
<<<<<<< HEAD:src/qlbhgg/views/login/LoginForm.java
<<<<<<< HEAD:src/qlbhgg/views/login/LoginForm.java
                            if (user.getStatus().equals("Khóa")) {
                                lbWrongPass.setText("Tài khoản của bạn đã bị khóa");
                            } else {
                                try {
                                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                                            if ("Windows".equals(info.getName())) {
                                                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                                break;
                                            }
                                        }
                                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
                                        java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                                    }
                                if ("Quản lý".equals(user.getRole())) {
                                    AdminForm af = new AdminForm(user);
                                    af.setVisible(true);
                                    af.pack();
                                    af.setLocationRelativeTo(null);

                                } else {
                                    StaffForm sf = new StaffForm(user);
                                    sf.setVisible(true);
                                    sf.pack();
                                    sf.setLocationRelativeTo(null);
                                }
                                this.dispose();
=======
=======
>>>>>>> 1d8032b0d1e15e63244a73933322ec0773a9ce98:src/JavaForm/LoginForm.java
                            if ("Quản lý".equals(user.getRole())) {
                                try {
                                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                                        if ("Windows".equals(info.getName())) {
                                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                            break;
                                        }
                                    }
                                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
                                    java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                                }
                                AdminForm af = new AdminForm(user);
                                af.setVisible(true);
                                af.pack();
                                af.setLocationRelativeTo(null);

                            } else {
                                StaffForm sf = new StaffForm();
                                sf.setVisible(true);
                                sf.pack();
                                sf.setLocationRelativeTo(null);
<<<<<<< HEAD:src/qlbhgg/views/login/LoginForm.java
>>>>>>> 1d8032b0d1e15e63244a73933322ec0773a9ce98:src/JavaForm/LoginForm.java
=======
>>>>>>> 1d8032b0d1e15e63244a73933322ec0773a9ce98:src/JavaForm/LoginForm.java
>>>>>>> Stashed changes:src/JavaForm/LoginForm.java
                            }
                        } else {
                            lbWrongPass.setText("Mật khẩu không chính xác.");
                            lbQuenMK.setText("Quên mật khẩu?");
                            lbQuenMK.setEnabled(true);
                            jErrorIcon2.setVisible(true);
                        }
                    }
<<<<<<< Updated upstream:src/qlbhgg/views/login/LoginForm.java
                } else {
=======
<<<<<<< HEAD:src/qlbhgg/views/login/LoginForm.java
<<<<<<< HEAD:src/qlbhgg/views/login/LoginForm.java
                } else {
=======
                }
                else {
>>>>>>> 1d8032b0d1e15e63244a73933322ec0773a9ce98:src/JavaForm/LoginForm.java
=======
                }
                else {
>>>>>>> 1d8032b0d1e15e63244a73933322ec0773a9ce98:src/JavaForm/LoginForm.java
>>>>>>> Stashed changes:src/JavaForm/LoginForm.java
                    lbWrongUsername.setText("Tài khoản không tồn tại.");
                    jErrorIcon1.setVisible(true);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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

        pnBackground = new javax.swing.JPanel();
        btnMinimize = new javax.swing.JLabel();
        lbDiscord = new javax.swing.JLabel();
        lbExit = new javax.swing.JLabel();
        lbRazer = new javax.swing.JLabel();
        lbTwitch = new javax.swing.JLabel();
        lbController = new javax.swing.JLabel();
        lbDell = new javax.swing.JLabel();
        lbGarena = new javax.swing.JLabel();
        lbCorsair = new javax.swing.JLabel();
        lbLogitech = new javax.swing.JLabel();
        jPanelLogin = new javax.swing.JPanel();
        jLabelMK = new javax.swing.JLabel();
        jLabelTK = new javax.swing.JLabel();
        jUsericon = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jClearUsername = new javax.swing.JLabel();
        jErrorIcon1 = new javax.swing.JLabel();
        lbWrongUsername = new javax.swing.JLabel();
        jSeparatorUsername = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        lbDangNhap = new javax.swing.JLabel();
        jLook = new javax.swing.JLabel();
        jClearPassword = new javax.swing.JLabel();
        jErrorIcon2 = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jSeparatorPass = new javax.swing.JSeparator();
        lbQuenMK = new javax.swing.JLabel();
        lbWrongPass = new javax.swing.JLabel();
        jLabelSign = new javax.swing.JLabel();
        btnSign = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnBackground.setBackground(new java.awt.Color(255, 255, 255));
        pnBackground.setPreferredSize(new java.awt.Dimension(1280, 720));
        pnBackground.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnBackgroundMouseDragged(evt);
            }
        });
        pnBackground.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnBackgroundMousePressed(evt);
            }
        });
        pnBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMinimize.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnMinimize.setForeground(new java.awt.Color(0, 0, 0));
        btnMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_minimize_window_25px.png"))); // NOI18N
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
        pnBackground.add(btnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 0, 20, 30));

        lbDiscord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_discord_100px.png"))); // NOI18N
        lbDiscord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbDiscordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbDiscordMouseExited(evt);
            }
        });
        pnBackground.add(lbDiscord, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 480, 100, 70));

        lbExit.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbExit.setForeground(new java.awt.Color(0, 0, 0));
        lbExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_close_window_25px_2.png"))); // NOI18N
        lbExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbExitMouseExited(evt);
            }
        });
        pnBackground.add(lbExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 0, 30, 30));

        lbRazer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_razer_100px.png"))); // NOI18N
        lbRazer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbRazerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbRazerMouseExited(evt);
            }
        });
        pnBackground.add(lbRazer, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 70, 100, 90));

        lbTwitch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_twitch_100px.png"))); // NOI18N
        lbTwitch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbTwitchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbTwitchMouseExited(evt);
            }
        });
        pnBackground.add(lbTwitch, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 100, 90));

        lbController.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_game_controller_100px_2.png"))); // NOI18N
        lbController.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbControllerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbControllerMouseExited(evt);
            }
        });
        pnBackground.add(lbController, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 100, 90));

        lbDell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_dell_100px_2.png"))); // NOI18N
        lbDell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbDellMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbDellMouseExited(evt);
            }
        });
        pnBackground.add(lbDell, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 100, 90));

        lbGarena.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_garena_100px_2.png"))); // NOI18N
        lbGarena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbGarenaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbGarenaMouseExited(evt);
            }
        });
        pnBackground.add(lbGarena, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 120, 100, 90));

        lbCorsair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_corsair_100px_2.png"))); // NOI18N
        lbCorsair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbCorsairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbCorsairMouseExited(evt);
            }
        });
        pnBackground.add(lbCorsair, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 100, 90));

        lbLogitech.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_logitech_100px_2.png"))); // NOI18N
        lbLogitech.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbLogitechMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbLogitechMouseExited(evt);
            }
        });
        pnBackground.add(lbLogitech, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 310, 100, 90));

        jPanelLogin.setBackground(new java.awt.Color(0, 0, 0));
        jPanelLogin.setLayout(null);

        jLabelMK.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMK.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMK.setForeground(new java.awt.Color(204, 204, 204));
        jLabelMK.setText("Mật khẩu");
        jLabelMK.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanelLogin.add(jLabelMK);
        jLabelMK.setBounds(90, 340, 90, 40);

        jLabelTK.setBackground(new java.awt.Color(0, 0, 0));
        jLabelTK.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTK.setForeground(new java.awt.Color(204, 204, 204));
        jLabelTK.setText("Tài khoản");
        jLabelTK.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanelLogin.add(jLabelTK);
        jLabelTK.setBounds(90, 260, 90, 40);
<<<<<<< Updated upstream:src/qlbhgg/views/login/LoginForm.java
=======
<<<<<<< HEAD:src/qlbhgg/views/login/LoginForm.java
<<<<<<< HEAD:src/qlbhgg/views/login/LoginForm.java
=======
>>>>>>> 1d8032b0d1e15e63244a73933322ec0773a9ce98:src/JavaForm/LoginForm.java
>>>>>>> Stashed changes:src/JavaForm/LoginForm.java

        jUsericon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jUsericon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_user_20px.png"))); // NOI18N
        jPanelLogin.add(jUsericon);
        jUsericon.setBounds(50, 260, 30, 40);

        txtUsername.setBackground(new java.awt.Color(0, 0, 0));
        txtUsername.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(255, 255, 255));
        txtUsername.setToolTipText("");
        txtUsername.setBorder(null);
        txtUsername.setCaretColor(new java.awt.Color(255, 255, 255));
        txtUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt);
            }
        });
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsernameKeyReleased(evt);
            }
        });
        jPanelLogin.add(txtUsername);
        txtUsername.setBounds(90, 260, 200, 40);

        jClearUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jClearUsername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_cancel_15px.png"))); // NOI18N
        jClearUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jClearUsername.setRequestFocusEnabled(false);
        jClearUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jClearUsernameMouseClicked(evt);
            }
        });
        jPanelLogin.add(jClearUsername);
        jClearUsername.setBounds(290, 260, 50, 40);
<<<<<<< Updated upstream:src/qlbhgg/views/login/LoginForm.java
=======
<<<<<<< HEAD:src/qlbhgg/views/login/LoginForm.java

=======

        jUsericon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jUsericon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_user_20px.png"))); // NOI18N
        jPanelLogin.add(jUsericon);
        jUsericon.setBounds(50, 260, 30, 40);

        txtUsername.setBackground(new java.awt.Color(0, 0, 0));
        txtUsername.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(255, 255, 255));
        txtUsername.setToolTipText("");
        txtUsername.setBorder(null);
        txtUsername.setCaretColor(new java.awt.Color(255, 255, 255));
        txtUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt);
            }
        });
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsernameKeyReleased(evt);
            }
        });
        jPanelLogin.add(txtUsername);
        txtUsername.setBounds(90, 260, 200, 40);

        jClearUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jClearUsername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_cancel_15px.png"))); // NOI18N
        jClearUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jClearUsername.setRequestFocusEnabled(false);
        jClearUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jClearUsernameMouseClicked(evt);
            }
        });
        jPanelLogin.add(jClearUsername);
        jClearUsername.setBounds(290, 260, 50, 40);

>>>>>>> 1d8032b0d1e15e63244a73933322ec0773a9ce98:src/JavaForm/LoginForm.java
        jErrorIcon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jErrorIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_error_20px.png"))); // NOI18N
        jPanelLogin.add(jErrorIcon1);
        jErrorIcon1.setBounds(340, 270, 20, 20);

        lbWrongUsername.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbWrongUsername.setForeground(new java.awt.Color(255, 102, 102));
        lbWrongUsername.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanelLogin.add(lbWrongUsername);
        lbWrongUsername.setBounds(50, 310, 320, 20);

        jSeparatorUsername.setForeground(new java.awt.Color(255, 255, 255));
        jPanelLogin.add(jSeparatorUsername);
        jSeparatorUsername.setBounds(50, 300, 280, 10);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("K M A - G E A R");
        jPanelLogin.add(jLabel1);
        jLabel1.setBounds(110, 160, 179, 29);

        lbDangNhap.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        lbDangNhap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gear_125px.png"))); // NOI18N
        jPanelLogin.add(lbDangNhap);
        lbDangNhap.setBounds(140, 30, 110, 110);

        jLook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_lock_20px.png"))); // NOI18N
        jPanelLogin.add(jLook);
        jLook.setBounds(50, 340, 30, 40);

        jClearPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jClearPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_cancel_15px.png"))); // NOI18N
        jClearPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jClearPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jClearPasswordMouseClicked(evt);
            }
        });
        jPanelLogin.add(jClearPassword);
        jClearPassword.setBounds(290, 340, 50, 40);

        jErrorIcon2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jErrorIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_error_20px.png"))); // NOI18N
        jPanelLogin.add(jErrorIcon2);
        jErrorIcon2.setBounds(340, 350, 20, 20);

        jPasswordField.setBackground(new java.awt.Color(0, 0, 0));
        jPasswordField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPasswordField.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField.setBorder(null);
        jPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordFieldFocusLost(evt);
            }
        });
        jPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordFieldKeyReleased(evt);
            }
        });
        jPanelLogin.add(jPasswordField);
        jPasswordField.setBounds(90, 340, 200, 40);

=======
>>>>>>> Stashed changes:src/JavaForm/LoginForm.java

        jErrorIcon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jErrorIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_error_20px.png"))); // NOI18N
        jPanelLogin.add(jErrorIcon1);
        jErrorIcon1.setBounds(340, 270, 20, 20);

        lbWrongUsername.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbWrongUsername.setForeground(new java.awt.Color(255, 102, 102));
        lbWrongUsername.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanelLogin.add(lbWrongUsername);
        lbWrongUsername.setBounds(50, 310, 320, 20);

        jSeparatorUsername.setForeground(new java.awt.Color(255, 255, 255));
        jPanelLogin.add(jSeparatorUsername);
        jSeparatorUsername.setBounds(50, 300, 280, 10);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("K M A - G E A R");
        jPanelLogin.add(jLabel1);
        jLabel1.setBounds(110, 160, 179, 29);

        lbDangNhap.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        lbDangNhap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gear_125px.png"))); // NOI18N
        jPanelLogin.add(lbDangNhap);
        lbDangNhap.setBounds(140, 30, 110, 110);

        jLook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_lock_20px.png"))); // NOI18N
        jPanelLogin.add(jLook);
        jLook.setBounds(50, 340, 30, 40);

        jClearPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jClearPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_cancel_15px.png"))); // NOI18N
        jClearPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jClearPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jClearPasswordMouseClicked(evt);
            }
        });
        jPanelLogin.add(jClearPassword);
        jClearPassword.setBounds(290, 340, 50, 40);

        jErrorIcon2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jErrorIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_error_20px.png"))); // NOI18N
        jPanelLogin.add(jErrorIcon2);
        jErrorIcon2.setBounds(340, 350, 20, 20);

        jPasswordField.setBackground(new java.awt.Color(0, 0, 0));
        jPasswordField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPasswordField.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField.setBorder(null);
        jPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordFieldFocusLost(evt);
            }
        });
        jPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordFieldKeyReleased(evt);
            }
        });
        jPanelLogin.add(jPasswordField);
        jPasswordField.setBounds(90, 340, 200, 40);

<<<<<<< Updated upstream:src/qlbhgg/views/login/LoginForm.java
=======
>>>>>>> 1d8032b0d1e15e63244a73933322ec0773a9ce98:src/JavaForm/LoginForm.java
>>>>>>> Stashed changes:src/JavaForm/LoginForm.java
        jSeparatorPass.setForeground(new java.awt.Color(255, 255, 255));
        jPanelLogin.add(jSeparatorPass);
        jSeparatorPass.setBounds(50, 380, 280, 10);

        lbQuenMK.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbQuenMK.setForeground(new java.awt.Color(255, 102, 102));
        lbQuenMK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
<<<<<<< Updated upstream:src/qlbhgg/views/login/LoginForm.java
        lbQuenMK.setText("Quên mật khẩu?");
=======
<<<<<<< HEAD:src/qlbhgg/views/login/LoginForm.java
<<<<<<< HEAD:src/qlbhgg/views/login/LoginForm.java
        lbQuenMK.setText("Quên mật khẩu?");
=======
>>>>>>> 1d8032b0d1e15e63244a73933322ec0773a9ce98:src/JavaForm/LoginForm.java
=======
>>>>>>> 1d8032b0d1e15e63244a73933322ec0773a9ce98:src/JavaForm/LoginForm.java
>>>>>>> Stashed changes:src/JavaForm/LoginForm.java
        lbQuenMK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbQuenMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbQuenMKMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbQuenMKMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbQuenMKMouseExited(evt);
            }
        });
        jPanelLogin.add(lbQuenMK);
<<<<<<< Updated upstream:src/qlbhgg/views/login/LoginForm.java
        lbQuenMK.setBounds(50, 410, 120, 20);
=======
<<<<<<< HEAD:src/qlbhgg/views/login/LoginForm.java
<<<<<<< HEAD:src/qlbhgg/views/login/LoginForm.java
        lbQuenMK.setBounds(50, 410, 120, 20);
=======
        lbQuenMK.setBounds(240, 390, 120, 20);
>>>>>>> 1d8032b0d1e15e63244a73933322ec0773a9ce98:src/JavaForm/LoginForm.java
=======
        lbQuenMK.setBounds(240, 390, 120, 20);
>>>>>>> 1d8032b0d1e15e63244a73933322ec0773a9ce98:src/JavaForm/LoginForm.java
>>>>>>> Stashed changes:src/JavaForm/LoginForm.java

        lbWrongPass.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbWrongPass.setForeground(new java.awt.Color(255, 102, 102));
        lbWrongPass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanelLogin.add(lbWrongPass);
        lbWrongPass.setBounds(50, 390, 320, 20);

        jLabelSign.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSign.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelSign.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSign.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSign.setText("Đăng nhập");
        jLabelSign.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelLogin.add(jLabelSign);
        jLabelSign.setBounds(140, 470, 130, 40);

        btnSign.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSign.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagePng/SignButtonGreen.png"))); // NOI18N
        btnSign.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSign.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSignMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSignMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSignMouseExited(evt);
            }
        });
        jPanelLogin.add(btnSign);
        btnSign.setBounds(100, 450, 200, 80);

<<<<<<< Updated upstream:src/qlbhgg/views/login/LoginForm.java
        pnBackground.add(jPanelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 390, 560));
=======
<<<<<<< HEAD:src/qlbhgg/views/login/LoginForm.java
<<<<<<< HEAD:src/qlbhgg/views/login/LoginForm.java
        pnBackground.add(jPanelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 390, 560));
=======
        pnBackground.add(jPanelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 390, 560));
>>>>>>> 1d8032b0d1e15e63244a73933322ec0773a9ce98:src/JavaForm/LoginForm.java
=======
        pnBackground.add(jPanelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 390, 560));
>>>>>>> 1d8032b0d1e15e63244a73933322ec0773a9ce98:src/JavaForm/LoginForm.java
>>>>>>> Stashed changes:src/JavaForm/LoginForm.java

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 1211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1210, 590));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lbExitMouseClicked

    private void lbDiscordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDiscordMouseEntered
        // TODO add your handling code here:
        lbDiscord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_discord_100px_1.png")));
    }//GEN-LAST:event_lbDiscordMouseEntered

    private void lbDiscordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDiscordMouseExited
        // TODO add your handling code here:
        lbDiscord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_discord_100px.png")));
    }//GEN-LAST:event_lbDiscordMouseExited

    private void lbExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMouseEntered
        // TODO add your handling code here:
        lbExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_close_window_25px_3.png")));
    }//GEN-LAST:event_lbExitMouseEntered

    private void lbExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMouseExited
        // TODO add your handling code here:
        lbExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_close_window_25px_2.png")));
    }//GEN-LAST:event_lbExitMouseExited

    private void lbTwitchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTwitchMouseEntered
        // TODO add your handling code here:
        lbTwitch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_twitch_100px_1.png")));
    }//GEN-LAST:event_lbTwitchMouseEntered

    private void lbTwitchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTwitchMouseExited
        // TODO add your handling code here:
        lbTwitch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_twitch_100px.png")));
    }//GEN-LAST:event_lbTwitchMouseExited

    private void lbControllerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbControllerMouseEntered
        // TODO add your handling code here:
        lbController.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_game_controller_100px_1.png")));
    }//GEN-LAST:event_lbControllerMouseEntered

    private void lbControllerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbControllerMouseExited
        // TODO add your handling code here:
        lbController.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_game_controller_100px_2.png")));
    }//GEN-LAST:event_lbControllerMouseExited

    private void lbDellMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDellMouseEntered
        // TODO add your handling code here:
        lbDell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_dell_100px_1.png")));
    }//GEN-LAST:event_lbDellMouseEntered

    private void lbDellMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDellMouseExited
        // TODO add your handling code here:
        lbDell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_dell_100px_2.png")));
    }//GEN-LAST:event_lbDellMouseExited

    private void lbGarenaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbGarenaMouseEntered
        // TODO add your handling code here:
        lbGarena.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_garena_100px_1.png")));
    }//GEN-LAST:event_lbGarenaMouseEntered

    private void lbGarenaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbGarenaMouseExited
        // TODO add your handling code here:
        lbGarena.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_garena_100px_2.png")));
    }//GEN-LAST:event_lbGarenaMouseExited

    private void lbCorsairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCorsairMouseEntered
        // TODO add your handling code here:
        lbCorsair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_corsair_100px_3.png")));
    }//GEN-LAST:event_lbCorsairMouseEntered

    private void lbCorsairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCorsairMouseExited
        // TODO add your handling code here:
        lbCorsair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_corsair_100px_2.png")));
    }//GEN-LAST:event_lbCorsairMouseExited

    private void lbLogitechMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogitechMouseEntered
        // TODO add your handling code here:
        lbLogitech.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_logitech_100px_1.png")));
    }//GEN-LAST:event_lbLogitechMouseEntered

    private void lbLogitechMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogitechMouseExited
        // TODO add your handling code here:
        lbLogitech.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_logitech_100px_2.png")));
    }//GEN-LAST:event_lbLogitechMouseExited

    private void btnSignMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSignMouseEntered
        // TODO add your handling code here:
        btnSign.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagePng/SignButtonWhite.png")));
        lbLogitech.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_logitech_100px_1.png")));
        lbCorsair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_corsair_100px_3.png")));
        lbGarena.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_garena_100px_1.png")));
        lbDell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_dell_100px_1.png")));
        lbController.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_game_controller_100px_1.png")));
        lbTwitch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_twitch_100px_1.png")));
        lbRazer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_razer_100px_1.png")));
        lbDiscord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_discord_100px_1.png")));
    }//GEN-LAST:event_btnSignMouseEntered

    private void btnSignMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSignMouseExited
        // TODO add your handling code here:
        btnSign.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagePng/SignButtonGreen.png")));
        lbLogitech.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_logitech_100px_2.png")));
        lbCorsair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_corsair_100px_2.png")));
        lbGarena.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_garena_100px_2.png")));
        lbDell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_dell_100px_2.png")));
        lbController.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_game_controller_100px_2.png")));
        lbTwitch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_twitch_100px.png")));
        lbRazer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_razer_100px.png")));
        lbDiscord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_discord_100px.png")));

    }//GEN-LAST:event_btnSignMouseExited

    private void btnSignMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSignMouseClicked
        try {
            // TODO add your handling code here:
            Signin();
        } catch (SQLException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSignMouseClicked

    private void btnMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseEntered
        // TODO add your handling code here:
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_minimize_window_25px_1.png")));
    }//GEN-LAST:event_btnMinimizeMouseEntered

    private void btnMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseExited
        // TODO add your handling code here:
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_minimize_window_25px.png")));
    }//GEN-LAST:event_btnMinimizeMouseExited

    private void lbQuenMKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQuenMKMouseEntered
        // TODO add your handling code here:
        lbQuenMK.setForeground(new java.awt.Color(255, 0, 0));
    }//GEN-LAST:event_lbQuenMKMouseEntered

    private void lbQuenMKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQuenMKMouseExited
        // TODO add your handling code here:
        lbQuenMK.setForeground(new java.awt.Color(255, 102, 102));
    }//GEN-LAST:event_lbQuenMKMouseExited

    private void txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyPressed
//        // TODO add your handling code here:
        if (!txtUsername.getText().equals("")) {
            jClearUsername.setVisible(true);
        } else {
            jClearUsername.setVisible(false);
        }
        jLabelTK.setVisible(false);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                Signin();
            } catch (SQLException ex) {
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtUsernameKeyPressed

    private void jPasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldKeyPressed
//        // TODO add your handling code here:

        jLabelMK.setVisible(false);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                Signin();
            } catch (SQLException ex) {
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jPasswordFieldKeyPressed

    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusLost
        if (txtUsername.getText().equals("")) {
            jLabelTK.setVisible(true);
        }
    }//GEN-LAST:event_txtUsernameFocusLost

    private void jPasswordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldFocusLost
        // TODO add your handling code here:
        if (String.valueOf(jPasswordField.getPassword()).equals("")) {
            jLabelMK.setVisible(true);
        }
    }//GEN-LAST:event_jPasswordFieldFocusLost

    private void jClearUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jClearUsernameMouseClicked
        // TODO add your handling code here:
        txtUsername.setText("");
        jClearUsername.setVisible(false);
        jLabelTK.setVisible(true);
    }//GEN-LAST:event_jClearUsernameMouseClicked

    private void jClearPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jClearPasswordMouseClicked
        // TODO add your handling code here:
        jPasswordField.setText("");
        jClearPassword.setVisible(false);
        jLabelMK.setVisible(true);
    }//GEN-LAST:event_jClearPasswordMouseClicked

    private void pnBackgroundMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnBackgroundMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - XX, y - YY);
    }//GEN-LAST:event_pnBackgroundMouseDragged

    private void pnBackgroundMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnBackgroundMousePressed
        // TODO add your handling code here:
        XX = evt.getX();
        YY = evt.getY();
    }//GEN-LAST:event_pnBackgroundMousePressed

    private void lbRazerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRazerMouseExited
        // TODO add your handling code here:
        lbRazer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_razer_100px.png")));
    }//GEN-LAST:event_lbRazerMouseExited

    private void lbRazerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRazerMouseEntered
        // TODO add your handling code here:
        lbRazer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_razer_100px_1.png")));
    }//GEN-LAST:event_lbRazerMouseEntered

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(LoginForm.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void txtUsernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyReleased
        // TODO add your handling code here:
        if (!txtUsername.getText().equals("")) {
            jClearUsername.setVisible(true);
        } else {
            jClearUsername.setVisible(false);
            jLabelTK.setVisible(true);
        }
    }//GEN-LAST:event_txtUsernameKeyReleased

    private void jPasswordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldKeyReleased
        // TODO add your handling code here:
        if (!String.valueOf(jPasswordField.getPassword()).equals("")) {
            jClearPassword.setVisible(true);
        } else {
            jClearPassword.setVisible(false);
            jLabelMK.setVisible(true);
        }
    }//GEN-LAST:event_jPasswordFieldKeyReleased

    private void lbQuenMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQuenMKMouseClicked
<<<<<<< Updated upstream:src/qlbhgg/views/login/LoginForm.java
        ForgotPassword fp = new ForgotPassword();
        fp.setVisible(true);
        fp.pack();
=======
<<<<<<< HEAD:src/qlbhgg/views/login/LoginForm.java
<<<<<<< HEAD:src/qlbhgg/views/login/LoginForm.java
        ForgotPassword fp = new ForgotPassword();
        fp.setVisible(true);
        fp.pack();
=======
        // TODO add your handling code here:
        
>>>>>>> 1d8032b0d1e15e63244a73933322ec0773a9ce98:src/JavaForm/LoginForm.java
=======
        // TODO add your handling code here:
        
>>>>>>> 1d8032b0d1e15e63244a73933322ec0773a9ce98:src/JavaForm/LoginForm.java
>>>>>>> Stashed changes:src/JavaForm/LoginForm.java
    }//GEN-LAST:event_lbQuenMKMouseClicked

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
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JLabel btnSign;
    private javax.swing.JLabel jClearPassword;
    private javax.swing.JLabel jClearUsername;
    private javax.swing.JLabel jErrorIcon1;
    private javax.swing.JLabel jErrorIcon2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelMK;
    private javax.swing.JLabel jLabelSign;
    private javax.swing.JLabel jLabelTK;
    private javax.swing.JLabel jLook;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JSeparator jSeparatorPass;
    private javax.swing.JSeparator jSeparatorUsername;
    private javax.swing.JLabel jUsericon;
    private javax.swing.JLabel lbController;
    private javax.swing.JLabel lbCorsair;
    private javax.swing.JLabel lbDangNhap;
    private javax.swing.JLabel lbDell;
    private javax.swing.JLabel lbDiscord;
    private javax.swing.JLabel lbExit;
    private javax.swing.JLabel lbGarena;
    private javax.swing.JLabel lbLogitech;
    private javax.swing.JLabel lbQuenMK;
    private javax.swing.JLabel lbRazer;
    private javax.swing.JLabel lbTwitch;
    private javax.swing.JLabel lbWrongPass;
    private javax.swing.JLabel lbWrongUsername;
    private javax.swing.JPanel pnBackground;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
