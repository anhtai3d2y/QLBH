/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaForm;

import ConnectToTheDatabase.UsersConnectToDatabase;
import JavaClassObject.Users;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author acer
 */
public class ForgotPassword extends javax.swing.JFrame {

    /**
     * Creates new form ForgotPassword
     */
    public ArrayList<Users> ListUser = new ArrayList<Users>();
    public boolean checkButton = true;
    int pincode;
    String username;

    public ForgotPassword() {
        initComponents();
        jButtonSendcode.setVisible(false);
        jLabel2.setVisible(false);
        jPanelCard.removeAll();
        jPanelCard.add(jPanelEnterUsername);
        jPanelCard.repaint();
        jPanelCard.revalidate();
        jSeparatorBack.setVisible(false);
        jLabelBack.setVisible(false);
        jLabelPassword.setVisible(false);
        jLabelPassword1.setVisible(false);
        jSeparatorBackPassword.setVisible(false);
    }

    private void enterUsername() {
        if (!jTextFieldUsername.getText().equals("")) {
            if (checkButton) {
                try {
                    ListUser = UsersConnectToDatabase.findUserLogin(jTextFieldUsername.getText());
                    if (ListUser.size() == 0) {
                        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
                        jLabel2.setText("Tài khoản không tồn tại");
                        jLabel2.setVisible(true);
                        jButtonSendcode.setVisible(false);
                    } else {
                        jLabel1.setText("<html>Vui lòng kiểm tra email và nhập mã xác minh:</html>");
                        jLabel2.setVisible(false);
                        jButtonSendcode.setVisible(true);
                        username = jTextFieldUsername.getText();
                        pincode = MailHandle.MailHandle.SendPincode(ListUser.get(0).getEmail(), "Lấy lại mật khẩu đăng nhập KMA-Gear");
                        
                        jTextFieldUsername.setText("");
                        checkButton = false;
                        jLabelBack.setVisible(true);
                        System.out.println(pincode);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ForgotPassword.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                if (jTextFieldUsername.getText().equals(String.valueOf(pincode))) {
                    jPanelCard.removeAll();
                    jPanelCard.add(jPanelChancePassword);
                    jPanelCard.repaint();
                    jPanelCard.revalidate();
                } else {
                    jLabel2.setText("Mã xác minh không đúng");
                    jLabel2.setVisible(true);
                }
            }

        } else {
            jLabel2.setForeground(new java.awt.Color(255, 0, 0));
            jLabel2.setText("Bạn chưa nhập tài khoản");
            jLabel2.setVisible(true);
            jButtonSendcode.setVisible(false);
        }
    }
    private void enterPassword(){
        if(checkPassword(String.valueOf(jPasswordFieldPassword.getPassword())) && checkConfirmPassword(String.valueOf(jPasswordFieldConfirmPassword.getPassword()), String.valueOf(jPasswordFieldPassword.getPassword()))){
            UsersConnectToDatabase.chancePassword(username, String.valueOf(jPasswordFieldPassword.getPassword()));
            jLabelPassword1.setText("Cập nhật mật khẩu thành công");
            jLabelPassword1.setForeground(Color.green);
            jLabelPassword1.setVisible(true);
        }
        else{
            jLabelPassword1.setText("Bạn phải nhập đủ thông tin");
            jLabelPassword1.setForeground(Color.red);
            jLabelPassword1.setVisible(true);
        }
    }

    public static boolean checkPassword(String password) {
        return !password.equals("") && Pattern.matches("^[a-zA-Z0-9]+$", password);
    }

    public static boolean checkConfirmPassword(String confirmpassword, String password) {
        return !confirmpassword.equals("") && confirmpassword.equals(password);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBG = new javax.swing.JPanel();
        jPanelCard = new javax.swing.JPanel();
        jPanelEnterUsername = new javax.swing.JPanel();
        jLabelBack = new javax.swing.JLabel();
        jSeparatorBack = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonSendcode = new javax.swing.JButton();
        jButtonOK = new javax.swing.JButton();
        jPanelChancePassword = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPasswordFieldConfirmPassword = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabelPassword1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jButtonOKPassword = new javax.swing.JButton();
        jLabelBackPassword = new javax.swing.JLabel();
        jSeparatorBackPassword = new javax.swing.JSeparator();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        jPanelTitle = new javax.swing.JPanel();
        lbExit = new javax.swing.JLabel();
        jLabelTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(450, 280));

        jPanelBG.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBG.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelCard.setLayout(new java.awt.CardLayout());

        jPanelEnterUsername.setBackground(new java.awt.Color(255, 255, 255));
        jPanelEnterUsername.setPreferredSize(new java.awt.Dimension(450, 250));
        jPanelEnterUsername.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelBack.setBackground(new java.awt.Color(255, 255, 255));
        jLabelBack.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelBack.setForeground(new java.awt.Color(102, 178, 255));
        jLabelBack.setText("Quay lại");
        jLabelBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelBackMouseExited(evt);
            }
        });
        jPanelEnterUsername.add(jLabelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 70, -1));

        jSeparatorBack.setForeground(new java.awt.Color(102, 178, 255));
        jPanelEnterUsername.add(jSeparatorBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 70, 10));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Tài khoản không tồn tại");
        jPanelEnterUsername.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 290, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Vui lòng nhập tài khoản:");
        jPanelEnterUsername.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 400, 50));

        jTextFieldUsername.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldUsername.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldUsername.setBorder(null);
        jTextFieldUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldUsernameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldUsernameKeyTyped(evt);
            }
        });
        jPanelEnterUsername.add(jTextFieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 290, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanelEnterUsername.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 290, 10));

        jButtonSendcode.setBackground(new java.awt.Color(70, 163, 242));
        jButtonSendcode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonSendcode.setForeground(new java.awt.Color(0, 0, 0));
        jButtonSendcode.setText("Gửi mã");
        jButtonSendcode.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSendcode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonSendcodeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonSendcodeMouseExited(evt);
            }
        });
        jButtonSendcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendcodeActionPerformed(evt);
            }
        });
        jPanelEnterUsername.add(jButtonSendcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 100, 30));

        jButtonOK.setBackground(new java.awt.Color(70, 163, 242));
        jButtonOK.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonOK.setForeground(new java.awt.Color(0, 0, 0));
        jButtonOK.setText("Tiếp tục");
        jButtonOK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonOKMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonOKMouseExited(evt);
            }
        });
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });
        jPanelEnterUsername.add(jButtonOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 120, 40));

        jPanelCard.add(jPanelEnterUsername, "card2");

        jPanelChancePassword.setBackground(new java.awt.Color(255, 255, 255));
        jPanelChancePassword.setPreferredSize(new java.awt.Dimension(450, 250));
        jPanelChancePassword.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Xác nhận mật khẩu mới:");
        jPanelChancePassword.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 230, -1));

        jPasswordFieldConfirmPassword.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordFieldConfirmPassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPasswordFieldConfirmPassword.setForeground(new java.awt.Color(0, 0, 0));
        jPasswordFieldConfirmPassword.setBorder(null);
        jPasswordFieldConfirmPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldConfirmPasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordFieldConfirmPasswordKeyReleased(evt);
            }
        });
        jPanelChancePassword.add(jPasswordFieldConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 390, 30));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanelChancePassword.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 390, 10));

        jLabelPassword1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPassword1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPassword1.setForeground(new java.awt.Color(255, 0, 0));
        jLabelPassword1.setText("Mật khẩu xác nhận không trùng khớp");
        jPanelChancePassword.add(jLabelPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 290, -1));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanelChancePassword.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 390, 10));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Mật khẩu mới:");
        jPanelChancePassword.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 28, 230, -1));

        jLabelPassword.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPassword.setForeground(new java.awt.Color(255, 0, 0));
        jLabelPassword.setText("Mật khẩu chỉ được bao gồm kí tự chữ hoặc số");
        jPanelChancePassword.add(jLabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 290, -1));

        jButtonOKPassword.setBackground(new java.awt.Color(70, 163, 242));
        jButtonOKPassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonOKPassword.setForeground(new java.awt.Color(0, 0, 0));
        jButtonOKPassword.setText("Xác nhận");
        jButtonOKPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonOKPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonOKPasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonOKPasswordMouseExited(evt);
            }
        });
        jButtonOKPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKPasswordActionPerformed(evt);
            }
        });
        jPanelChancePassword.add(jButtonOKPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 120, 40));

        jLabelBackPassword.setBackground(new java.awt.Color(255, 255, 255));
        jLabelBackPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelBackPassword.setForeground(new java.awt.Color(102, 178, 255));
        jLabelBackPassword.setText("Quay lại");
        jLabelBackPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelBackPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBackPasswordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelBackPasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelBackPasswordMouseExited(evt);
            }
        });
        jPanelChancePassword.add(jLabelBackPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 70, -1));

        jSeparatorBackPassword.setForeground(new java.awt.Color(102, 178, 255));
        jPanelChancePassword.add(jSeparatorBackPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 70, 10));

        jPasswordFieldPassword.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordFieldPassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPasswordFieldPassword.setForeground(new java.awt.Color(0, 0, 0));
        jPasswordFieldPassword.setBorder(null);
        jPasswordFieldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldPasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordFieldPasswordKeyReleased(evt);
            }
        });
        jPanelChancePassword.add(jPasswordFieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 52, 390, 30));

        jPanelCard.add(jPanelChancePassword, "card3");

        jPanelBG.add(jPanelCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 450, 250));

        jPanelTitle.setBackground(new java.awt.Color(0, 0, 0));

        lbExit.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbExit.setForeground(new java.awt.Color(0, 0, 0));
        lbExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_close_window_25px_4.png"))); // NOI18N
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

        jLabelTitle.setBackground(new java.awt.Color(0, 0, 0));
        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gear_25px.png"))); // NOI18N
        jLabelTitle.setText("Quên mật khẩu | Không thể đăng nhập");

        javax.swing.GroupLayout jPanelTitleLayout = new javax.swing.GroupLayout(jPanelTitle);
        jPanelTitle.setLayout(jPanelTitleLayout);
        jPanelTitleLayout.setHorizontalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTitleLayout.createSequentialGroup()
                .addComponent(jLabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(lbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelTitleLayout.setVerticalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTitleLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelBG.add(jPanelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_lbExitMouseClicked

    private void lbExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMouseEntered
        // TODO add your handling code here:
        lbExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_close_window_25px_3.png")));
    }//GEN-LAST:event_lbExitMouseEntered

    private void lbExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMouseExited
        // TODO add your handling code here:
        lbExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_close_window_25px_4.png")));
    }//GEN-LAST:event_lbExitMouseExited

    private void jButtonOKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOKMouseEntered
        jButtonOK.setBackground(new java.awt.Color(139, 195, 224));
    }//GEN-LAST:event_jButtonOKMouseEntered

    private void jButtonOKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOKMouseExited
        jButtonOK.setBackground(new java.awt.Color(70, 163, 242));
    }//GEN-LAST:event_jButtonOKMouseExited

    private void jButtonSendcodeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSendcodeMouseEntered
        jButtonSendcode.setBackground(new java.awt.Color(139, 195, 224));
    }//GEN-LAST:event_jButtonSendcodeMouseEntered

    private void jButtonSendcodeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSendcodeMouseExited
        jButtonSendcode.setBackground(new java.awt.Color(70, 163, 242));
    }//GEN-LAST:event_jButtonSendcodeMouseExited

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        enterUsername();
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jTextFieldUsernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsernameKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && !checkButton) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldUsernameKeyTyped

    private void jButtonSendcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendcodeActionPerformed
        pincode = MailHandle.MailHandle.SendPincode(ListUser.get(0).getEmail(), "Quên mật khẩu đăng nhập KMA-Gear");
    }//GEN-LAST:event_jButtonSendcodeActionPerformed

    private void jLabelBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBackMouseEntered
        jSeparatorBack.setVisible(true);
    }//GEN-LAST:event_jLabelBackMouseEntered

    private void jLabelBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBackMouseExited
        jSeparatorBack.setVisible(false);
    }//GEN-LAST:event_jLabelBackMouseExited

    private void jLabelBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBackMouseClicked
        jButtonSendcode.setVisible(false);
        Random rd = new Random();
        pincode = rd.nextInt();
        checkButton = true;
        jLabelBack.setVisible(false);
        jLabel1.setText("Vui lòng nhập tài khoản:");
    }//GEN-LAST:event_jLabelBackMouseClicked

    private void jTextFieldUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsernameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            enterUsername();
        }
    }//GEN-LAST:event_jTextFieldUsernameKeyPressed

    private void jButtonOKPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOKPasswordMouseEntered
        jButtonOKPassword.setBackground(new java.awt.Color(139, 195, 224));
    }//GEN-LAST:event_jButtonOKPasswordMouseEntered

    private void jButtonOKPasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOKPasswordMouseExited
        jButtonOKPassword.setBackground(new java.awt.Color(70, 163, 242));
    }//GEN-LAST:event_jButtonOKPasswordMouseExited

    private void jButtonOKPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKPasswordActionPerformed
        enterPassword();
    }//GEN-LAST:event_jButtonOKPasswordActionPerformed

    private void jLabelBackPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBackPasswordMouseClicked
        jButtonSendcode.setVisible(false);
        Random rd = new Random();
        pincode = rd.nextInt();
        checkButton = true;
        jLabelBack.setVisible(false);
        jLabel1.setText("Vui lòng nhập tài khoản:");
        jTextFieldUsername.setText("");
        jPasswordFieldPassword.setText("");
        jPasswordFieldConfirmPassword.setText("");
        jPanelCard.removeAll();
        jPanelCard.add(jPanelEnterUsername);
        jPanelCard.repaint();
        jPanelCard.revalidate();
    }//GEN-LAST:event_jLabelBackPasswordMouseClicked

    private void jLabelBackPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBackPasswordMouseEntered
        jSeparatorBackPassword.setVisible(true);
    }//GEN-LAST:event_jLabelBackPasswordMouseEntered

    private void jLabelBackPasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBackPasswordMouseExited
        jSeparatorBackPassword.setVisible(false);
    }//GEN-LAST:event_jLabelBackPasswordMouseExited

    private void jPasswordFieldPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordKeyReleased
        if (!checkPassword(String.valueOf(jPasswordFieldPassword.getPassword()))) {
            jLabelPassword.setVisible(true);
            jLabelPassword.setForeground(Color.red);
        } else {
            jLabelPassword.setVisible(false);
        }
        if (!checkConfirmPassword(String.valueOf(jPasswordFieldConfirmPassword.getPassword()), String.valueOf(jPasswordFieldPassword.getPassword()))) {
            jLabelPassword1.setVisible(true);
            jLabelPassword1.setForeground(Color.red);
            jLabelPassword1.setText("Mật khẩu xác nhận không trùng khớp");
        } else {
            jLabelPassword1.setVisible(false);
        }
    }//GEN-LAST:event_jPasswordFieldPasswordKeyReleased

    private void jPasswordFieldConfirmPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldConfirmPasswordKeyReleased
        if (!checkConfirmPassword(String.valueOf(jPasswordFieldConfirmPassword.getPassword()), String.valueOf(jPasswordFieldPassword.getPassword()))) {
            jLabelPassword1.setVisible(true);
            jLabelPassword1.setForeground(Color.red);
            jLabelPassword1.setText("Mật khẩu xác nhận không trùng khớp");
        } else {
            jLabelPassword1.setVisible(false);
        }
    }//GEN-LAST:event_jPasswordFieldConfirmPasswordKeyReleased

    private void jPasswordFieldConfirmPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldConfirmPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            enterPassword();
        }
    }//GEN-LAST:event_jPasswordFieldConfirmPasswordKeyPressed

    private void jPasswordFieldPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            enterPassword();
        }
    }//GEN-LAST:event_jPasswordFieldPasswordKeyPressed

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
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOK;
    private javax.swing.JButton jButtonOKPassword;
    private javax.swing.JButton jButtonSendcode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelBack;
    private javax.swing.JLabel jLabelBackPassword;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelPassword1;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelBG;
    private javax.swing.JPanel jPanelCard;
    private javax.swing.JPanel jPanelChancePassword;
    private javax.swing.JPanel jPanelEnterUsername;
    private javax.swing.JPanel jPanelTitle;
    private javax.swing.JPasswordField jPasswordFieldConfirmPassword;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparatorBack;
    private javax.swing.JSeparator jSeparatorBackPassword;
    private javax.swing.JTextField jTextFieldUsername;
    private javax.swing.JLabel lbExit;
    // End of variables declaration//GEN-END:variables
}