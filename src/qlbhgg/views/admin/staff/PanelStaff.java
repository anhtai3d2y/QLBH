/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.views.admin.staff;

import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import qlbhgg.dao.UsersDao;
import qlbhgg.models.Users;
import qlbhgg.views.common.ConfirmDeleteStaff;
import qlbhgg.views.common.ConfirmOperations;
import qlbhgg.views.common.DisplayImage;

/**
 *
 * @author acer
 */
public class PanelStaff extends javax.swing.JPanel {

    /**
     * Creates new form PanelStaff
     */
    public ArrayList<Users> ListUsers = UsersDao.findStaff();
    public int countStaff = UsersDao.countStaff();
    public int setPageStaff;
    public Users u;

    public PanelStaff() throws SQLException {
        initComponents();
        showStaffList(ListUsers, countStaff);
    }

    public void startingStateQLNV() {
        jPanelStaff1.setVisible(false);
        jPanelStaff2.setVisible(false);
        jPanelStaff3.setVisible(false);
        jPanelStaff4.setVisible(false);
        jPanelStaff5.setVisible(false);
        jPanelStaff6.setVisible(false);
    }

    public void showStaffList(ArrayList<Users> ListUsers, int countStaff) throws SQLException {
        startingStateQLNV();
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        jLabelBBButtonAddStaff.setIcon(scaleButtonAddStaff("/Image/ButtonEditBlue.png"));
        jLabelBBButtonRefreshStaffList.setIcon(scaleButtonRefresh("/Image/ButtonEditLight.png"));
        if (pageStaff < countStaff) {
            renderJPanelStaff(ListUsers.get(pageStaff), jPanelStaff1, jLabelNameStaff1, jLabelGenderStaff1, jLabelAvatar1, jLabelFrameStaff1, jLabelAddressStaff1, jLabelEmailStaff1, jLabelStatusStaff1);
        } else {
            jPanelStaff1.setVisible(false);
        }
        if (pageStaff + 1 < countStaff) {
            renderJPanelStaff(ListUsers.get(pageStaff + 1), jPanelStaff2, jLabelNameStaff2, jLabelGenderStaff2, jLabelAvatar2, jLabelFrameStaff2, jLabelAddressStaff2, jLabelEmailStaff2, jLabelStatusStaff2);
        } else {
            jPanelStaff2.setVisible(false);
        }
        if (pageStaff + 2 < countStaff) {
            renderJPanelStaff(ListUsers.get(pageStaff + 2), jPanelStaff3, jLabelNameStaff3, jLabelGenderStaff3, jLabelAvatar3, jLabelFrameStaff3, jLabelAddressStaff3, jLabelEmailStaff3, jLabelStatusStaff3);
        } else {
            jPanelStaff3.setVisible(false);
        }
        if (pageStaff + 3 < countStaff) {
            renderJPanelStaff(ListUsers.get(pageStaff + 3), jPanelStaff4, jLabelNameStaff4, jLabelGenderStaff4, jLabelAvatar4, jLabelFrameStaff4, jLabelAddressStaff4, jLabelEmailStaff4, jLabelStatusStaff4);
        } else {
            jPanelStaff4.setVisible(false);
        }
        if (pageStaff + 4 < countStaff) {
            renderJPanelStaff(ListUsers.get(pageStaff + 4), jPanelStaff5, jLabelNameStaff5, jLabelGenderStaff5, jLabelAvatar5, jLabelFrameStaff5, jLabelAddressStaff5, jLabelEmailStaff5, jLabelStatusStaff5);
        } else {
            jPanelStaff5.setVisible(false);
        }
        if (pageStaff + 5 < countStaff) {
            renderJPanelStaff(ListUsers.get(pageStaff + 5), jPanelStaff6, jLabelNameStaff6, jLabelGenderStaff6, jLabelAvatar6, jLabelFrameStaff6, jLabelAddressStaff6, jLabelEmailStaff6, jLabelStatusStaff6);
        } else {
            jPanelStaff6.setVisible(false);
        }
        if (pageStaff + 6 < countStaff) {
            renderJPanelStaff(ListUsers.get(pageStaff + 6), jPanelStaff7, jLabelNameStaff7, jLabelGenderStaff7, jLabelAvatar7, jLabelFrameStaff7, jLabelAddressStaff7, jLabelEmailStaff7, jLabelStatusStaff7);
        } else {
            jPanelStaff7.setVisible(false);
        }
        if (pageStaff + 7 < countStaff) {
            renderJPanelStaff(ListUsers.get(pageStaff + 7), jPanelStaff8, jLabelNameStaff8, jLabelGenderStaff8, jLabelAvatar8, jLabelFrameStaff8, jLabelAddressStaff8, jLabelEmailStaff8, jLabelStatusStaff8);
        } else {
            jPanelStaff8.setVisible(false);
        }
        if (pageStaff + 8 < countStaff) {
            renderJPanelStaff(ListUsers.get(pageStaff + 8), jPanelStaff9, jLabelNameStaff9, jLabelGenderStaff9, jLabelAvatar9, jLabelFrameStaff9, jLabelAddressStaff9, jLabelEmailStaff9, jLabelStatusStaff9);
        } else {
            jPanelStaff9.setVisible(false);
        }
        jLabelFrameSearchStaff.setIcon(scaleFrameSearch("/Image/FrameSearch.png"));
    }

    private void renderJPanelStaff(Users u, JPanel jpanel, JLabel jlabelNameStaff, JLabel jlabelGender, JLabel jlabelAvatar, JLabel jlabelFrameStaff, JLabel jlabelAddressStaff, JLabel jlabelEmailStaff, JLabel jLabelStatusStaff) {
        jpanel.setVisible(true);
        jpanel.setEnabled(true);
        jlabelNameStaff.setText(u.getFullname());
        jlabelGender.setText(u.getGender());
        if (u.getGender().equals("Nam")) {
            jlabelGender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_20px.png")));
        } else {
            jlabelGender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_female_20px.png")));
        }
        if (u.getStatus().equals("Hoạt động")) {
            jLabelStatusStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px.png")));
        } else {
            jLabelStatusStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px_1.png")));
        }
        jlabelAddressStaff.setText("<html>" + u.getAddress() + "</html>");
        jlabelFrameStaff.setIcon(scaleImageFrameStaff("/Image/Imformation.png"));
        jlabelAvatar.setIcon(scaleImageAvatar(u.getImage_user()));
        jlabelEmailStaff.setText(u.getEmail());
    }

    private ImageIcon scaleImageAvatar(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(85, 85, Image.SCALE_SMOOTH);
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

    private ImageIcon scaleFrameSearch(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(280, 30, Image.SCALE_SMOOTH);
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

    private ImageIcon scaleButtonRefresh(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(130, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }

    public void popUpImageStaff(int n) {
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        Users u = ListUsers.get(pageStaff + n);
        DisplayImage di = new DisplayImage(u.getFullname(), u.getImage_user());
        di.setVisible(true);
        di.pack();
        di.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDashboardQLNV = new javax.swing.JPanel();
        jPanelList = new javax.swing.JPanel();
        jPanelStaff1 = new javax.swing.JPanel();
        jLabelEditStaff1 = new javax.swing.JLabel();
        jLabelDeleteStaff1 = new javax.swing.JLabel();
        jLabelStatusStaff1 = new javax.swing.JLabel();
        jLabelGenderStaff1 = new javax.swing.JLabel();
        jLabelNameStaff1 = new javax.swing.JLabel();
        jLabelAddressStaff1 = new javax.swing.JLabel();
        jLabelEmailStaff1 = new javax.swing.JLabel();
        jLabelMessengerStaff1 = new javax.swing.JLabel();
        jLabelAvatarClick1 = new javax.swing.JLabel();
        jLabelFrameStaff1 = new javax.swing.JLabel();
        jLabelAvatar1 = new javax.swing.JLabel();
        jPanelStaff2 = new javax.swing.JPanel();
        jLabelDeleteStaff2 = new javax.swing.JLabel();
        jLabelEditStaff2 = new javax.swing.JLabel();
        jLabelStatusStaff2 = new javax.swing.JLabel();
        jLabelGenderStaff2 = new javax.swing.JLabel();
        jLabelNameStaff2 = new javax.swing.JLabel();
        jLabelAddressStaff2 = new javax.swing.JLabel();
        jLabelEmailStaff2 = new javax.swing.JLabel();
        jLabelMessengerStaff2 = new javax.swing.JLabel();
        jLabelAvatarClick2 = new javax.swing.JLabel();
        jLabelFrameStaff2 = new javax.swing.JLabel();
        jLabelAvatar2 = new javax.swing.JLabel();
        jPanelStaff3 = new javax.swing.JPanel();
        jLabelDeleteStaff3 = new javax.swing.JLabel();
        jLabelStatusStaff3 = new javax.swing.JLabel();
        jLabelGenderStaff3 = new javax.swing.JLabel();
        jLabelEditStaff3 = new javax.swing.JLabel();
        jLabelNameStaff3 = new javax.swing.JLabel();
        jLabelAddressStaff3 = new javax.swing.JLabel();
        jLabelEmailStaff3 = new javax.swing.JLabel();
        jLabelMessengerStaff3 = new javax.swing.JLabel();
        jLabelAvatarClick3 = new javax.swing.JLabel();
        jLabelFrameStaff3 = new javax.swing.JLabel();
        jLabelAvatar3 = new javax.swing.JLabel();
        jPanelStaff7 = new javax.swing.JPanel();
        jLabelDeleteStaff7 = new javax.swing.JLabel();
        jLabelStatusStaff7 = new javax.swing.JLabel();
        jLabelGenderStaff7 = new javax.swing.JLabel();
        jLabelNameStaff7 = new javax.swing.JLabel();
        jLabelEditStaff7 = new javax.swing.JLabel();
        jLabelAddressStaff7 = new javax.swing.JLabel();
        jLabelEmailStaff7 = new javax.swing.JLabel();
        jLabelMessengerStaff7 = new javax.swing.JLabel();
        jLabelAvatarClick7 = new javax.swing.JLabel();
        jLabelFrameStaff7 = new javax.swing.JLabel();
        jLabelAvatar7 = new javax.swing.JLabel();
        jPanelStaff8 = new javax.swing.JPanel();
        jLabelDeleteStaff8 = new javax.swing.JLabel();
        jLabelStatusStaff8 = new javax.swing.JLabel();
        jLabelGenderStaff8 = new javax.swing.JLabel();
        jLabelEditStaff8 = new javax.swing.JLabel();
        jLabelNameStaff8 = new javax.swing.JLabel();
        jLabelAddressStaff8 = new javax.swing.JLabel();
        jLabelEmailStaff8 = new javax.swing.JLabel();
        jLabelMessengerStaff8 = new javax.swing.JLabel();
        jLabelAvatarClick8 = new javax.swing.JLabel();
        jLabelFrameStaff8 = new javax.swing.JLabel();
        jLabelAvatar8 = new javax.swing.JLabel();
        jPanelStaff9 = new javax.swing.JPanel();
        jLabelDeleteStaff9 = new javax.swing.JLabel();
        jLabelStatusStaff9 = new javax.swing.JLabel();
        jLabelGenderStaff9 = new javax.swing.JLabel();
        jLabelNameStaff9 = new javax.swing.JLabel();
        jLabelEditStaff9 = new javax.swing.JLabel();
        jLabelAddressStaff9 = new javax.swing.JLabel();
        jLabelEmailStaff9 = new javax.swing.JLabel();
        jLabelMessengerStaff9 = new javax.swing.JLabel();
        jLabelAvatarClick9 = new javax.swing.JLabel();
        jLabelFrameStaff9 = new javax.swing.JLabel();
        jLabelAvatar9 = new javax.swing.JLabel();
        jPanelStaff4 = new javax.swing.JPanel();
        jLabelDeleteStaff4 = new javax.swing.JLabel();
        jLabelStatusStaff4 = new javax.swing.JLabel();
        jLabelGenderStaff4 = new javax.swing.JLabel();
        jLabelNameStaff4 = new javax.swing.JLabel();
        jLabelEditStaff4 = new javax.swing.JLabel();
        jLabelAddressStaff4 = new javax.swing.JLabel();
        jLabelEmailStaff4 = new javax.swing.JLabel();
        jLabelMessengerStaff4 = new javax.swing.JLabel();
        jLabelAvatarClick4 = new javax.swing.JLabel();
        jLabelFrameStaff4 = new javax.swing.JLabel();
        jLabelAvatar4 = new javax.swing.JLabel();
        jPanelStaff5 = new javax.swing.JPanel();
        jLabelDeleteStaff5 = new javax.swing.JLabel();
        jLabelStatusStaff5 = new javax.swing.JLabel();
        jLabelGenderStaff5 = new javax.swing.JLabel();
        jLabelEditStaff5 = new javax.swing.JLabel();
        jLabelNameStaff5 = new javax.swing.JLabel();
        jLabelAddressStaff5 = new javax.swing.JLabel();
        jLabelEmailStaff5 = new javax.swing.JLabel();
        jLabelMessengerStaff5 = new javax.swing.JLabel();
        jLabelAvatarClick5 = new javax.swing.JLabel();
        jLabelFrameStaff5 = new javax.swing.JLabel();
        jLabelAvatar5 = new javax.swing.JLabel();
        jPanelStaff6 = new javax.swing.JPanel();
        jLabelDeleteStaff6 = new javax.swing.JLabel();
        jLabelStatusStaff6 = new javax.swing.JLabel();
        jLabelGenderStaff6 = new javax.swing.JLabel();
        jLabelNameStaff6 = new javax.swing.JLabel();
        jLabelEditStaff6 = new javax.swing.JLabel();
        jLabelAddressStaff6 = new javax.swing.JLabel();
        jLabelEmailStaff6 = new javax.swing.JLabel();
        jLabelMessengerStaff6 = new javax.swing.JLabel();
        jLabelAvatarClick6 = new javax.swing.JLabel();
        jLabelFrameStaff6 = new javax.swing.JLabel();
        jLabelAvatar6 = new javax.swing.JLabel();
        jPanelControlPageStaff = new javax.swing.JPanel();
        jTextFieldPageStaff = new javax.swing.JTextField();
        jLabelPageStaff = new javax.swing.JLabel();
        jLabelRight2 = new javax.swing.JLabel();
        jLabelLeft2 = new javax.swing.JLabel();
        jLabelSkipToEnd2 = new javax.swing.JLabel();
        jLabelSkipToStart2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelTitleQLNV = new javax.swing.JLabel();
        jTextFieldSearchStaff = new javax.swing.JTextField();
        jLabelSearchStaff = new javax.swing.JLabel();
        jLabelButtonAddStaff = new javax.swing.JLabel();
        jLabelBBButtonAddStaff = new javax.swing.JLabel();
        jLabelButtonRefreshStaffList = new javax.swing.JLabel();
        jLabelBBButtonRefreshStaffList = new javax.swing.JLabel();
        jLabelFrameSearchStaff = new javax.swing.JLabel();
        jPanelInfor = new javax.swing.JPanel();

        jDashboardQLNV.setBackground(new java.awt.Color(255, 255, 255));
        jDashboardQLNV.setForeground(new java.awt.Color(0, 0, 0));
        jDashboardQLNV.setPreferredSize(new java.awt.Dimension(1330, 790));
        jDashboardQLNV.setLayout(new java.awt.CardLayout());

        jPanelList.setBackground(new java.awt.Color(255, 255, 255));
        jPanelList.setPreferredSize(new java.awt.Dimension(1330, 870));
        jPanelList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelStaff1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelStaff1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelStaff1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelEditStaff1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEditStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png"))); // NOI18N
        jLabelEditStaff1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelEditStaff1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditStaff1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelEditStaff1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelEditStaff1MouseExited(evt);
            }
        });
        jPanelStaff1.add(jLabelEditStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 147, 45, 30));

        jLabelDeleteStaff1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDeleteStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDeleteStaff1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDeleteStaff1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff1MouseExited(evt);
            }
        });
        jPanelStaff1.add(jLabelDeleteStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 147, 45, 30));

        jLabelStatusStaff1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStatusStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px.png"))); // NOI18N
        jLabelStatusStaff1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelStatusStaff1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelStatusStaff1MouseClicked(evt);
            }
        });
        jPanelStaff1.add(jLabelStatusStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 148, 45, 30));

        jLabelGenderStaff1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelGenderStaff1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelGenderStaff1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelGenderStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_20px.png"))); // NOI18N
        jLabelGenderStaff1.setText("Nam");
        jLabelGenderStaff1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff1.add(jLabelGenderStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 130, -1));

        jLabelNameStaff1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaff1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelNameStaff1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameStaff1.setText("Phạm Duy Tài");
        jLabelNameStaff1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameStaff1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNameStaff1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameStaff1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameStaff1MouseExited(evt);
            }
        });
        jPanelStaff1.add(jLabelNameStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 210, -1));

        jLabelAddressStaff1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressStaff1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAddressStaff1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddressStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_marker_20px.png"))); // NOI18N
        jLabelAddressStaff1.setText("Đồng Mai, Hà Đông, Hà Nội");
        jLabelAddressStaff1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff1.add(jLabelAddressStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 240, 30));

        jLabelEmailStaff1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailStaff1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEmailStaff1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gmail_20px_1.png"))); // NOI18N
        jLabelEmailStaff1.setText("anhtai3d2y@gmail.com");
        jLabelEmailStaff1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff1.add(jLabelEmailStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 240, 30));

        jLabelMessengerStaff1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMessengerStaff1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMessengerStaff1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMessengerStaff1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMessengerStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png"))); // NOI18N
        jLabelMessengerStaff1.setText("Nhắn tin");
        jLabelMessengerStaff1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMessengerStaff1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff1MouseExited(evt);
            }
        });
        jPanelStaff1.add(jLabelMessengerStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 184, 30));

        jLabelAvatarClick1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatarClick1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatarClick1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAvatarClick1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAvatarClick1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAvatarClick1MouseEntered(evt);
            }
        });
        jPanelStaff1.add(jLabelAvatarClick1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jLabelFrameStaff1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFrameStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Imformation.png"))); // NOI18N
        jPanelStaff1.add(jLabelFrameStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 200));

        jLabelAvatar1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatar1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelStaff1.add(jLabelAvatar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jPanelList.add(jPanelStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 380, 200));

        jPanelStaff2.setBackground(new java.awt.Color(255, 255, 255));
        jPanelStaff2.setForeground(new java.awt.Color(255, 255, 255));
        jPanelStaff2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDeleteStaff2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDeleteStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDeleteStaff2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDeleteStaff2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff2MouseExited(evt);
            }
        });
        jPanelStaff2.add(jLabelDeleteStaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 147, 45, 30));

        jLabelEditStaff2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEditStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png"))); // NOI18N
        jLabelEditStaff2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelEditStaff2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditStaff2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelEditStaff2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelEditStaff2MouseExited(evt);
            }
        });
        jPanelStaff2.add(jLabelEditStaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 147, 45, 30));

        jLabelStatusStaff2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStatusStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px.png"))); // NOI18N
        jLabelStatusStaff2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelStatusStaff2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelStatusStaff2MouseClicked(evt);
            }
        });
        jPanelStaff2.add(jLabelStatusStaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 148, 45, 30));

        jLabelGenderStaff2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelGenderStaff2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelGenderStaff2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelGenderStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_20px.png"))); // NOI18N
        jLabelGenderStaff2.setText("Nam");
        jLabelGenderStaff2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff2.add(jLabelGenderStaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 130, -1));

        jLabelNameStaff2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaff2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelNameStaff2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameStaff2.setText("Phạm Duy Tài");
        jLabelNameStaff2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameStaff2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNameStaff2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameStaff2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameStaff2MouseExited(evt);
            }
        });
        jPanelStaff2.add(jLabelNameStaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 210, -1));

        jLabelAddressStaff2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressStaff2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAddressStaff2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddressStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_marker_20px.png"))); // NOI18N
        jLabelAddressStaff2.setText("Đồng Mai, Hà Đông, Hà Nội");
        jLabelAddressStaff2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff2.add(jLabelAddressStaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 240, 30));

        jLabelEmailStaff2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailStaff2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEmailStaff2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gmail_20px_1.png"))); // NOI18N
        jLabelEmailStaff2.setText("anhtai3d2y@gmail.com");
        jLabelEmailStaff2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff2.add(jLabelEmailStaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 240, 30));

        jLabelMessengerStaff2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMessengerStaff2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMessengerStaff2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMessengerStaff2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMessengerStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png"))); // NOI18N
        jLabelMessengerStaff2.setText("Nhắn tin");
        jLabelMessengerStaff2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMessengerStaff2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff2MouseExited(evt);
            }
        });
        jPanelStaff2.add(jLabelMessengerStaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 184, 30));

        jLabelAvatarClick2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatarClick2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatarClick2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAvatarClick2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAvatarClick2MouseClicked(evt);
            }
        });
        jPanelStaff2.add(jLabelAvatarClick2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jLabelFrameStaff2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFrameStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Imformation.png"))); // NOI18N
        jPanelStaff2.add(jLabelFrameStaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 200));

        jLabelAvatar2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatar2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelStaff2.add(jLabelAvatar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jPanelList.add(jPanelStaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 380, 200));

        jPanelStaff3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelStaff3.setForeground(new java.awt.Color(255, 255, 255));
        jPanelStaff3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDeleteStaff3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDeleteStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDeleteStaff3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDeleteStaff3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff3MouseExited(evt);
            }
        });
        jPanelStaff3.add(jLabelDeleteStaff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 147, 45, 30));

        jLabelStatusStaff3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStatusStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px.png"))); // NOI18N
        jLabelStatusStaff3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelStatusStaff3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelStatusStaff3MouseClicked(evt);
            }
        });
        jPanelStaff3.add(jLabelStatusStaff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 148, 45, 30));

        jLabelGenderStaff3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelGenderStaff3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelGenderStaff3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelGenderStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_20px.png"))); // NOI18N
        jLabelGenderStaff3.setText("Nam");
        jLabelGenderStaff3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff3.add(jLabelGenderStaff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 130, -1));

        jLabelEditStaff3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEditStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png"))); // NOI18N
        jLabelEditStaff3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelEditStaff3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditStaff3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelEditStaff3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelEditStaff3MouseExited(evt);
            }
        });
        jPanelStaff3.add(jLabelEditStaff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 147, 45, 30));

        jLabelNameStaff3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaff3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelNameStaff3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameStaff3.setText("Phạm Duy Tài");
        jLabelNameStaff3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameStaff3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNameStaff3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameStaff3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameStaff3MouseExited(evt);
            }
        });
        jPanelStaff3.add(jLabelNameStaff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 210, -1));

        jLabelAddressStaff3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressStaff3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAddressStaff3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddressStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_marker_20px.png"))); // NOI18N
        jLabelAddressStaff3.setText("Đồng Mai, Hà Đông, Hà Nội");
        jLabelAddressStaff3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff3.add(jLabelAddressStaff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 240, 30));

        jLabelEmailStaff3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailStaff3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEmailStaff3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gmail_20px_1.png"))); // NOI18N
        jLabelEmailStaff3.setText("anhtai3d2y@gmail.com");
        jLabelEmailStaff3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff3.add(jLabelEmailStaff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 240, 30));

        jLabelMessengerStaff3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMessengerStaff3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMessengerStaff3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMessengerStaff3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMessengerStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png"))); // NOI18N
        jLabelMessengerStaff3.setText("Nhắn tin");
        jLabelMessengerStaff3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMessengerStaff3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff3MouseExited(evt);
            }
        });
        jPanelStaff3.add(jLabelMessengerStaff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 184, 30));

        jLabelAvatarClick3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatarClick3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatarClick3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAvatarClick3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAvatarClick3MouseClicked(evt);
            }
        });
        jPanelStaff3.add(jLabelAvatarClick3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jLabelFrameStaff3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFrameStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Imformation.png"))); // NOI18N
        jPanelStaff3.add(jLabelFrameStaff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 200));

        jLabelAvatar3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatar3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelStaff3.add(jLabelAvatar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jPanelList.add(jPanelStaff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 190, 380, 200));

        jPanelStaff7.setBackground(new java.awt.Color(255, 255, 255));
        jPanelStaff7.setForeground(new java.awt.Color(255, 255, 255));
        jPanelStaff7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDeleteStaff7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDeleteStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDeleteStaff7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDeleteStaff7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff7MouseExited(evt);
            }
        });
        jPanelStaff7.add(jLabelDeleteStaff7, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 147, 45, 30));

        jLabelStatusStaff7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStatusStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px.png"))); // NOI18N
        jLabelStatusStaff7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelStatusStaff7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelStatusStaff7MouseClicked(evt);
            }
        });
        jPanelStaff7.add(jLabelStatusStaff7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 148, 45, 30));

        jLabelGenderStaff7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelGenderStaff7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelGenderStaff7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelGenderStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_20px.png"))); // NOI18N
        jLabelGenderStaff7.setText("Nam");
        jLabelGenderStaff7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff7.add(jLabelGenderStaff7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 130, -1));

        jLabelNameStaff7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaff7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelNameStaff7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameStaff7.setText("Phạm Duy Tài");
        jLabelNameStaff7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameStaff7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNameStaff7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameStaff7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameStaff7MouseExited(evt);
            }
        });
        jPanelStaff7.add(jLabelNameStaff7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 210, -1));

        jLabelEditStaff7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEditStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png"))); // NOI18N
        jLabelEditStaff7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelEditStaff7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditStaff7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelEditStaff7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelEditStaff7MouseExited(evt);
            }
        });
        jPanelStaff7.add(jLabelEditStaff7, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 147, 45, 30));

        jLabelAddressStaff7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressStaff7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAddressStaff7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddressStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_marker_20px.png"))); // NOI18N
        jLabelAddressStaff7.setText("Đồng Mai, Hà Đông, Hà Nội");
        jLabelAddressStaff7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff7.add(jLabelAddressStaff7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 240, 30));

        jLabelEmailStaff7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailStaff7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEmailStaff7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gmail_20px_1.png"))); // NOI18N
        jLabelEmailStaff7.setText("anhtai3d2y@gmail.com");
        jLabelEmailStaff7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff7.add(jLabelEmailStaff7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 240, 30));

        jLabelMessengerStaff7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMessengerStaff7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMessengerStaff7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMessengerStaff7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMessengerStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png"))); // NOI18N
        jLabelMessengerStaff7.setText("Nhắn tin");
        jLabelMessengerStaff7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMessengerStaff7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff7MouseExited(evt);
            }
        });
        jPanelStaff7.add(jLabelMessengerStaff7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 184, 30));

        jLabelAvatarClick7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatarClick7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatarClick7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAvatarClick7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAvatarClick7MouseClicked(evt);
            }
        });
        jPanelStaff7.add(jLabelAvatarClick7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jLabelFrameStaff7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFrameStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Imformation.png"))); // NOI18N
        jPanelStaff7.add(jLabelFrameStaff7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 200));

        jLabelAvatar7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatar7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatar7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelStaff7.add(jLabelAvatar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jPanelList.add(jPanelStaff7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 610, 380, 200));

        jPanelStaff8.setBackground(new java.awt.Color(255, 255, 255));
        jPanelStaff8.setForeground(new java.awt.Color(255, 255, 255));
        jPanelStaff8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDeleteStaff8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDeleteStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDeleteStaff8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDeleteStaff8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff8MouseExited(evt);
            }
        });
        jPanelStaff8.add(jLabelDeleteStaff8, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 147, 45, 30));

        jLabelStatusStaff8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStatusStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px.png"))); // NOI18N
        jLabelStatusStaff8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelStatusStaff8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelStatusStaff8MouseClicked(evt);
            }
        });
        jPanelStaff8.add(jLabelStatusStaff8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 148, 45, 30));

        jLabelGenderStaff8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelGenderStaff8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelGenderStaff8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelGenderStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_20px.png"))); // NOI18N
        jLabelGenderStaff8.setText("Nam");
        jLabelGenderStaff8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff8.add(jLabelGenderStaff8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 130, -1));

        jLabelEditStaff8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEditStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png"))); // NOI18N
        jLabelEditStaff8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelEditStaff8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditStaff8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelEditStaff8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelEditStaff8MouseExited(evt);
            }
        });
        jPanelStaff8.add(jLabelEditStaff8, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 147, 45, 30));

        jLabelNameStaff8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaff8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelNameStaff8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameStaff8.setText("Phạm Duy Tài");
        jLabelNameStaff8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameStaff8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNameStaff8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameStaff8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameStaff8MouseExited(evt);
            }
        });
        jPanelStaff8.add(jLabelNameStaff8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 210, -1));

        jLabelAddressStaff8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressStaff8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAddressStaff8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddressStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_marker_20px.png"))); // NOI18N
        jLabelAddressStaff8.setText("Đồng Mai, Hà Đông, Hà Nội");
        jLabelAddressStaff8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff8.add(jLabelAddressStaff8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 240, 30));

        jLabelEmailStaff8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailStaff8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEmailStaff8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gmail_20px_1.png"))); // NOI18N
        jLabelEmailStaff8.setText("anhtai3d2y@gmail.com");
        jLabelEmailStaff8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff8.add(jLabelEmailStaff8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 240, 30));

        jLabelMessengerStaff8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMessengerStaff8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMessengerStaff8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMessengerStaff8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMessengerStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png"))); // NOI18N
        jLabelMessengerStaff8.setText("Nhắn tin");
        jLabelMessengerStaff8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMessengerStaff8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff8MouseExited(evt);
            }
        });
        jPanelStaff8.add(jLabelMessengerStaff8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 184, 30));

        jLabelAvatarClick8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatarClick8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatarClick8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAvatarClick8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAvatarClick8MouseClicked(evt);
            }
        });
        jPanelStaff8.add(jLabelAvatarClick8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jLabelFrameStaff8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff8.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFrameStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Imformation.png"))); // NOI18N
        jPanelStaff8.add(jLabelFrameStaff8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 200));

        jLabelAvatar8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatar8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatar8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelStaff8.add(jLabelAvatar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jPanelList.add(jPanelStaff8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 610, 380, 200));

        jPanelStaff9.setBackground(new java.awt.Color(255, 255, 255));
        jPanelStaff9.setForeground(new java.awt.Color(255, 255, 255));
        jPanelStaff9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDeleteStaff9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDeleteStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDeleteStaff9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDeleteStaff9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff9MouseExited(evt);
            }
        });
        jPanelStaff9.add(jLabelDeleteStaff9, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 147, 45, 30));

        jLabelStatusStaff9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStatusStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px.png"))); // NOI18N
        jLabelStatusStaff9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelStatusStaff9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelStatusStaff9MouseClicked(evt);
            }
        });
        jPanelStaff9.add(jLabelStatusStaff9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 148, 45, 30));

        jLabelGenderStaff9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelGenderStaff9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelGenderStaff9.setForeground(new java.awt.Color(0, 0, 0));
        jLabelGenderStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_20px.png"))); // NOI18N
        jLabelGenderStaff9.setText("Nam");
        jLabelGenderStaff9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff9.add(jLabelGenderStaff9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 130, -1));

        jLabelNameStaff9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaff9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelNameStaff9.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameStaff9.setText("Phạm Duy Tài");
        jLabelNameStaff9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameStaff9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNameStaff9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameStaff9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameStaff9MouseExited(evt);
            }
        });
        jPanelStaff9.add(jLabelNameStaff9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 210, -1));

        jLabelEditStaff9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEditStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png"))); // NOI18N
        jLabelEditStaff9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelEditStaff9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditStaff9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelEditStaff9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelEditStaff9MouseExited(evt);
            }
        });
        jPanelStaff9.add(jLabelEditStaff9, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 147, 45, 30));

        jLabelAddressStaff9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressStaff9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAddressStaff9.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddressStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_marker_20px.png"))); // NOI18N
        jLabelAddressStaff9.setText("Đồng Mai, Hà Đông, Hà Nội");
        jLabelAddressStaff9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff9.add(jLabelAddressStaff9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 240, 30));

        jLabelEmailStaff9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailStaff9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEmailStaff9.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gmail_20px_1.png"))); // NOI18N
        jLabelEmailStaff9.setText("anhtai3d2y@gmail.com");
        jLabelEmailStaff9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff9.add(jLabelEmailStaff9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 240, 30));

        jLabelMessengerStaff9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMessengerStaff9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMessengerStaff9.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMessengerStaff9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMessengerStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png"))); // NOI18N
        jLabelMessengerStaff9.setText("Nhắn tin");
        jLabelMessengerStaff9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMessengerStaff9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff9MouseExited(evt);
            }
        });
        jPanelStaff9.add(jLabelMessengerStaff9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 184, 30));

        jLabelAvatarClick9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatarClick9.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatarClick9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAvatarClick9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAvatarClick9MouseClicked(evt);
            }
        });
        jPanelStaff9.add(jLabelAvatarClick9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jLabelFrameStaff9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff9.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFrameStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Imformation.png"))); // NOI18N
        jPanelStaff9.add(jLabelFrameStaff9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 200));

        jLabelAvatar9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatar9.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatar9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelStaff9.add(jLabelAvatar9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jPanelList.add(jPanelStaff9, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 610, 380, 200));

        jPanelStaff4.setBackground(new java.awt.Color(255, 255, 255));
        jPanelStaff4.setForeground(new java.awt.Color(255, 255, 255));
        jPanelStaff4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDeleteStaff4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDeleteStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDeleteStaff4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDeleteStaff4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff4MouseExited(evt);
            }
        });
        jPanelStaff4.add(jLabelDeleteStaff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 147, 45, 30));

        jLabelStatusStaff4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStatusStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px.png"))); // NOI18N
        jLabelStatusStaff4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelStatusStaff4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelStatusStaff4MouseClicked(evt);
            }
        });
        jPanelStaff4.add(jLabelStatusStaff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 148, 45, 30));

        jLabelGenderStaff4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelGenderStaff4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelGenderStaff4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelGenderStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_20px.png"))); // NOI18N
        jLabelGenderStaff4.setText("Nam");
        jLabelGenderStaff4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff4.add(jLabelGenderStaff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 130, -1));

        jLabelNameStaff4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaff4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelNameStaff4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameStaff4.setText("Phạm Duy Tài");
        jLabelNameStaff4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameStaff4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNameStaff4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameStaff4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameStaff4MouseExited(evt);
            }
        });
        jPanelStaff4.add(jLabelNameStaff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 210, -1));

        jLabelEditStaff4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEditStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png"))); // NOI18N
        jLabelEditStaff4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelEditStaff4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditStaff4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelEditStaff4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelEditStaff4MouseExited(evt);
            }
        });
        jPanelStaff4.add(jLabelEditStaff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 147, 45, 30));

        jLabelAddressStaff4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressStaff4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAddressStaff4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddressStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_marker_20px.png"))); // NOI18N
        jLabelAddressStaff4.setText("Đồng Mai, Hà Đông, Hà Nội");
        jLabelAddressStaff4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff4.add(jLabelAddressStaff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 240, 30));

        jLabelEmailStaff4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailStaff4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEmailStaff4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gmail_20px_1.png"))); // NOI18N
        jLabelEmailStaff4.setText("anhtai3d2y@gmail.com");
        jLabelEmailStaff4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff4.add(jLabelEmailStaff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 240, 30));

        jLabelMessengerStaff4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMessengerStaff4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMessengerStaff4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMessengerStaff4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMessengerStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png"))); // NOI18N
        jLabelMessengerStaff4.setText("Nhắn tin");
        jLabelMessengerStaff4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMessengerStaff4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff4MouseExited(evt);
            }
        });
        jPanelStaff4.add(jLabelMessengerStaff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 184, 30));

        jLabelAvatarClick4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatarClick4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatarClick4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAvatarClick4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAvatarClick4MouseClicked(evt);
            }
        });
        jPanelStaff4.add(jLabelAvatarClick4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jLabelFrameStaff4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFrameStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Imformation.png"))); // NOI18N
        jPanelStaff4.add(jLabelFrameStaff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 200));

        jLabelAvatar4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatar4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelStaff4.add(jLabelAvatar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jPanelList.add(jPanelStaff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 380, 200));

        jPanelStaff5.setBackground(new java.awt.Color(255, 255, 255));
        jPanelStaff5.setForeground(new java.awt.Color(255, 255, 255));
        jPanelStaff5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDeleteStaff5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDeleteStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDeleteStaff5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDeleteStaff5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff5MouseExited(evt);
            }
        });
        jPanelStaff5.add(jLabelDeleteStaff5, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 147, 45, 30));

        jLabelStatusStaff5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStatusStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px.png"))); // NOI18N
        jLabelStatusStaff5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelStatusStaff5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelStatusStaff5MouseClicked(evt);
            }
        });
        jPanelStaff5.add(jLabelStatusStaff5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 148, 45, 30));

        jLabelGenderStaff5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelGenderStaff5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelGenderStaff5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelGenderStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_20px.png"))); // NOI18N
        jLabelGenderStaff5.setText("Nam");
        jLabelGenderStaff5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff5.add(jLabelGenderStaff5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 130, -1));

        jLabelEditStaff5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEditStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png"))); // NOI18N
        jLabelEditStaff5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelEditStaff5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditStaff5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelEditStaff5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelEditStaff5MouseExited(evt);
            }
        });
        jPanelStaff5.add(jLabelEditStaff5, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 147, 45, 30));

        jLabelNameStaff5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaff5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelNameStaff5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameStaff5.setText("Phạm Duy Tài");
        jLabelNameStaff5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameStaff5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNameStaff5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameStaff5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameStaff5MouseExited(evt);
            }
        });
        jPanelStaff5.add(jLabelNameStaff5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 210, -1));

        jLabelAddressStaff5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressStaff5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAddressStaff5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddressStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_marker_20px.png"))); // NOI18N
        jLabelAddressStaff5.setText("Đồng Mai, Hà Đông, Hà Nội");
        jLabelAddressStaff5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff5.add(jLabelAddressStaff5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 240, 30));

        jLabelEmailStaff5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailStaff5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEmailStaff5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gmail_20px_1.png"))); // NOI18N
        jLabelEmailStaff5.setText("anhtai3d2y@gmail.com");
        jLabelEmailStaff5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff5.add(jLabelEmailStaff5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 240, 30));

        jLabelMessengerStaff5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMessengerStaff5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMessengerStaff5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMessengerStaff5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMessengerStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png"))); // NOI18N
        jLabelMessengerStaff5.setText("Nhắn tin");
        jLabelMessengerStaff5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMessengerStaff5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff5MouseExited(evt);
            }
        });
        jPanelStaff5.add(jLabelMessengerStaff5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 184, 30));

        jLabelAvatarClick5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatarClick5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatarClick5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAvatarClick5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAvatarClick5MouseClicked(evt);
            }
        });
        jPanelStaff5.add(jLabelAvatarClick5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jLabelFrameStaff5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFrameStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Imformation.png"))); // NOI18N
        jPanelStaff5.add(jLabelFrameStaff5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 200));

        jLabelAvatar5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatar5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatar5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelStaff5.add(jLabelAvatar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jPanelList.add(jPanelStaff5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, 380, 200));

        jPanelStaff6.setBackground(new java.awt.Color(255, 255, 255));
        jPanelStaff6.setForeground(new java.awt.Color(255, 255, 255));
        jPanelStaff6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDeleteStaff6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDeleteStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDeleteStaff6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDeleteStaff6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff6MouseExited(evt);
            }
        });
        jPanelStaff6.add(jLabelDeleteStaff6, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 147, 45, 30));

        jLabelStatusStaff6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStatusStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px.png"))); // NOI18N
        jLabelStatusStaff6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelStatusStaff6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelStatusStaff6MouseClicked(evt);
            }
        });
        jPanelStaff6.add(jLabelStatusStaff6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 148, 45, 30));

        jLabelGenderStaff6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelGenderStaff6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelGenderStaff6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelGenderStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_20px.png"))); // NOI18N
        jLabelGenderStaff6.setText("Nam");
        jLabelGenderStaff6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff6.add(jLabelGenderStaff6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 130, -1));

        jLabelNameStaff6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaff6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelNameStaff6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameStaff6.setText("Phạm Duy Tài");
        jLabelNameStaff6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameStaff6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNameStaff6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameStaff6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameStaff6MouseExited(evt);
            }
        });
        jPanelStaff6.add(jLabelNameStaff6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 210, -1));

        jLabelEditStaff6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEditStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png"))); // NOI18N
        jLabelEditStaff6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelEditStaff6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditStaff6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelEditStaff6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelEditStaff6MouseExited(evt);
            }
        });
        jPanelStaff6.add(jLabelEditStaff6, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 147, 45, 30));

        jLabelAddressStaff6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressStaff6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAddressStaff6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddressStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_marker_20px.png"))); // NOI18N
        jLabelAddressStaff6.setText("Đồng Mai, Hà Đông, Hà Nội");
        jLabelAddressStaff6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff6.add(jLabelAddressStaff6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 240, 30));

        jLabelEmailStaff6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailStaff6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEmailStaff6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gmail_20px_1.png"))); // NOI18N
        jLabelEmailStaff6.setText("anhtai3d2y@gmail.com");
        jLabelEmailStaff6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff6.add(jLabelEmailStaff6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 240, 30));

        jLabelMessengerStaff6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMessengerStaff6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMessengerStaff6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMessengerStaff6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMessengerStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png"))); // NOI18N
        jLabelMessengerStaff6.setText("Nhắn tin");
        jLabelMessengerStaff6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMessengerStaff6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff6MouseExited(evt);
            }
        });
        jPanelStaff6.add(jLabelMessengerStaff6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 184, 30));

        jLabelAvatarClick6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatarClick6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatarClick6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAvatarClick6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAvatarClick6MouseClicked(evt);
            }
        });
        jPanelStaff6.add(jLabelAvatarClick6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jLabelFrameStaff6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFrameStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Imformation.png"))); // NOI18N
        jPanelStaff6.add(jLabelFrameStaff6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 200));

        jLabelAvatar6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatar6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatar6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelStaff6.add(jLabelAvatar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jPanelList.add(jPanelStaff6, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 400, 380, 200));

        jPanelControlPageStaff.setBackground(new java.awt.Color(255, 255, 255));

        jTextFieldPageStaff.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPageStaff.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldPageStaff.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldPageStaff.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldPageStaff.setText("1");
        jTextFieldPageStaff.setBorder(null);
        jTextFieldPageStaff.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPageStaffKeyReleased(evt);
            }
        });

        jLabelPageStaff.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPageStaff.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPageStaff.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPageStaff.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPageStaff.setText("/4");

        jLabelRight2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelRight2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRight2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRight2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px.png"))); // NOI18N
        jLabelRight2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRight2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRight2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelRight2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelRight2MouseExited(evt);
            }
        });

        jLabelLeft2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLeft2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLeft2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLeft2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px_1.png"))); // NOI18N
        jLabelLeft2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelLeft2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLeft2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelLeft2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelLeft2MouseExited(evt);
            }
        });

        jLabelSkipToEnd2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSkipToEnd2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSkipToEnd2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSkipToEnd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px_1.png"))); // NOI18N
        jLabelSkipToEnd2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSkipToEnd2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSkipToEnd2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSkipToEnd2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSkipToEnd2MouseExited(evt);
            }
        });

        jLabelSkipToStart2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSkipToStart2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSkipToStart2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSkipToStart2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px_1.png"))); // NOI18N
        jLabelSkipToStart2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSkipToStart2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSkipToStart2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSkipToStart2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSkipToStart2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelControlPageStaffLayout = new javax.swing.GroupLayout(jPanelControlPageStaff);
        jPanelControlPageStaff.setLayout(jPanelControlPageStaffLayout);
        jPanelControlPageStaffLayout.setHorizontalGroup(
            jPanelControlPageStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControlPageStaffLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSkipToStart2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLeft2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPageStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPageStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelRight2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSkipToEnd2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelControlPageStaffLayout.setVerticalGroup(
            jPanelControlPageStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelControlPageStaffLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelControlPageStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelSkipToStart2)
                    .addComponent(jLabelSkipToEnd2)
                    .addComponent(jLabelLeft2)
                    .addComponent(jLabelRight2)
                    .addGroup(jPanelControlPageStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldPageStaff)
                        .addComponent(jLabelPageStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanelList.add(jPanelControlPageStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 820, 200, 30));
        jPanelList.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 1330, 10));

        jLabelTitleQLNV.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTitleQLNV.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitleQLNV.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTitleQLNV.setText("Quản lý nhân viên");
        jPanelList.add(jLabelTitleQLNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 230, -1));

        jTextFieldSearchStaff.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldSearchStaff.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldSearchStaff.setForeground(new java.awt.Color(120, 120, 120));
        jTextFieldSearchStaff.setText("Tìm kiếm");
        jTextFieldSearchStaff.setBorder(null);
        jTextFieldSearchStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldSearchStaff.setOpaque(false);
        jTextFieldSearchStaff.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldSearchStaffFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldSearchStaffFocusLost(evt);
            }
        });
        jTextFieldSearchStaff.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchStaffKeyReleased(evt);
            }
        });
        jPanelList.add(jTextFieldSearchStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 120, 240, 30));

        jLabelSearchStaff.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSearchStaff.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelSearchStaff.setForeground(new java.awt.Color(120, 120, 120));
        jLabelSearchStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_search_20px_1.png"))); // NOI18N
        jLabelSearchStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanelList.add(jLabelSearchStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 120, 30, 30));

        jLabelButtonAddStaff.setBackground(new java.awt.Color(255, 255, 255));
        jLabelButtonAddStaff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelButtonAddStaff.setForeground(new java.awt.Color(0, 0, 0));
        jLabelButtonAddStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelButtonAddStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_20px.png"))); // NOI18N
        jLabelButtonAddStaff.setText("Thêm nhân viên");
        jLabelButtonAddStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelButtonAddStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelButtonAddStaffMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelButtonAddStaffMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelButtonAddStaffMouseExited(evt);
            }
        });
        jPanelList.add(jLabelButtonAddStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 190, 30));

        jLabelBBButtonAddStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBBButtonAddStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelList.add(jLabelBBButtonAddStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 190, 30));

        jLabelButtonRefreshStaffList.setBackground(new java.awt.Color(255, 255, 255));
        jLabelButtonRefreshStaffList.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelButtonRefreshStaffList.setForeground(new java.awt.Color(0, 0, 0));
        jLabelButtonRefreshStaffList.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelButtonRefreshStaffList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_refresh_20px.png"))); // NOI18N
        jLabelButtonRefreshStaffList.setText("Làm mới");
        jLabelButtonRefreshStaffList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelButtonRefreshStaffList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelButtonRefreshStaffListMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelButtonRefreshStaffListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelButtonRefreshStaffListMouseExited(evt);
            }
        });
        jPanelList.add(jLabelButtonRefreshStaffList, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 120, 130, 30));

        jLabelBBButtonRefreshStaffList.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBBButtonRefreshStaffList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelList.add(jLabelBBButtonRefreshStaffList, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 120, 130, 30));

        jLabelFrameSearchStaff.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameSearchStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanelList.add(jLabelFrameSearchStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 120, 280, 30));

        jDashboardQLNV.add(jPanelList, "card2");

        javax.swing.GroupLayout jPanelInforLayout = new javax.swing.GroupLayout(jPanelInfor);
        jPanelInfor.setLayout(jPanelInforLayout);
        jPanelInforLayout.setHorizontalGroup(
            jPanelInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1330, Short.MAX_VALUE)
        );
        jPanelInforLayout.setVerticalGroup(
            jPanelInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );

        jDashboardQLNV.add(jPanelInfor, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1330, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jDashboardQLNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jDashboardQLNV, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelEditStaff1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff1MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff);
        EditStaff es = new EditStaff(u, "Sửa thông tin nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelEditStaff1MouseClicked

    private void jLabelEditStaff1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff1MouseEntered
        jLabelEditStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px_1.png")));
    }//GEN-LAST:event_jLabelEditStaff1MouseEntered

    private void jLabelEditStaff1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff1MouseExited
        // TODO add your handling code here:
        jLabelEditStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png")));
    }//GEN-LAST:event_jLabelEditStaff1MouseExited

    private void jLabelDeleteStaff1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff1MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff);
        ConfirmDeleteStaff cd = new ConfirmDeleteStaff(u);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_jLabelDeleteStaff1MouseClicked

    private void jLabelDeleteStaff1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff1MouseEntered
        // TODO add your handling code here:
        jLabelDeleteStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDeleteStaff1MouseEntered

    private void jLabelDeleteStaff1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff1MouseExited
        // TODO add your handling code here:
        jLabelDeleteStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDeleteStaff1MouseExited

    private void jLabelStatusStaff1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStatusStaff1MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff);
        ConfirmOperations co = new ConfirmOperations(u);
        co.setVisible(true);
        co.pack();
    }//GEN-LAST:event_jLabelStatusStaff1MouseClicked

    private void jLabelNameStaff1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff1MouseClicked
        // TODO add your handling code here:
        jLabelNameStaff1.setForeground(new java.awt.Color(0, 0, 0));
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff);
        jDashboardQLNV.removeAll();
        jDashboardQLNV.add(jPanelInfor);
        jDashboardQLNV.validate();
        jDashboardQLNV.repaint();
    }//GEN-LAST:event_jLabelNameStaff1MouseClicked

    private void jLabelNameStaff1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff1MouseEntered
        // TODO add your handling code here:
        jLabelNameStaff1.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelNameStaff1MouseEntered

    private void jLabelNameStaff1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff1MouseExited
        // TODO add your handling code here:
        jLabelNameStaff1.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameStaff1MouseExited

    private void jLabelMessengerStaff1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff1MouseEntered
        // TODO add your handling code here:
        jLabelMessengerStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px_2.png")));
        jLabelMessengerStaff1.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelMessengerStaff1MouseEntered

    private void jLabelMessengerStaff1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff1MouseExited
        // TODO add your handling code here:
        jLabelMessengerStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png")));
        jLabelMessengerStaff1.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelMessengerStaff1MouseExited

    private void jLabelAvatarClick1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarClick1MouseClicked
        // TODO add your handling code here:
        popUpImageStaff(0);
    }//GEN-LAST:event_jLabelAvatarClick1MouseClicked

    private void jLabelAvatarClick1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarClick1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelAvatarClick1MouseEntered

    private void jLabelDeleteStaff2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff2MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 1);
        ConfirmDeleteStaff cd = new ConfirmDeleteStaff(u);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_jLabelDeleteStaff2MouseClicked

    private void jLabelDeleteStaff2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff2MouseEntered
        // TODO add your handling code here:
        jLabelDeleteStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDeleteStaff2MouseEntered

    private void jLabelDeleteStaff2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff2MouseExited
        // TODO add your handling code here:
        jLabelDeleteStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDeleteStaff2MouseExited

    private void jLabelEditStaff2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff2MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 1);
        EditStaff es = new EditStaff(u, "Sửa thông tin nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelEditStaff2MouseClicked

    private void jLabelEditStaff2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff2MouseEntered
        // TODO add your handling code here:
        jLabelEditStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px_1.png")));
    }//GEN-LAST:event_jLabelEditStaff2MouseEntered

    private void jLabelEditStaff2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff2MouseExited
        // TODO add your handling code here:
        jLabelEditStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png")));
    }//GEN-LAST:event_jLabelEditStaff2MouseExited

    private void jLabelStatusStaff2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStatusStaff2MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 1);
        ConfirmOperations co = new ConfirmOperations(u);
        co.setVisible(true);
        co.pack();
    }//GEN-LAST:event_jLabelStatusStaff2MouseClicked

    private void jLabelNameStaff2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff2MouseClicked
        jLabelNameStaff1.setForeground(new java.awt.Color(0, 0, 0));
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 1);
        jDashboardQLNV.removeAll();
        try {
            jDashboardQLNV.add(new PanelInforStaff(u));
        } catch (SQLException ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDashboardQLNV.validate();
        jDashboardQLNV.repaint();
    }//GEN-LAST:event_jLabelNameStaff2MouseClicked

    private void jLabelNameStaff2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff2MouseEntered
        // TODO add your handling code here:
        jLabelNameStaff2.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelNameStaff2MouseEntered

    private void jLabelNameStaff2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff2MouseExited
        // TODO add your handling code here:
        jLabelNameStaff2.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameStaff2MouseExited

    private void jLabelMessengerStaff2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff2MouseEntered
        // TODO add your handling code here:
        jLabelMessengerStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px_2.png")));
        jLabelMessengerStaff2.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelMessengerStaff2MouseEntered

    private void jLabelMessengerStaff2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff2MouseExited
        // TODO add your handling code here:
        jLabelMessengerStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png")));
        jLabelMessengerStaff2.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelMessengerStaff2MouseExited

    private void jLabelAvatarClick2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarClick2MouseClicked
        // TODO add your handling code here:
        popUpImageStaff(1);
    }//GEN-LAST:event_jLabelAvatarClick2MouseClicked

    private void jLabelDeleteStaff3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff3MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 2);
        ConfirmDeleteStaff cd = new ConfirmDeleteStaff(u);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_jLabelDeleteStaff3MouseClicked

    private void jLabelDeleteStaff3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff3MouseEntered
        // TODO add your handling code here:
        jLabelDeleteStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDeleteStaff3MouseEntered

    private void jLabelDeleteStaff3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff3MouseExited
        // TODO add your handling code here:
        jLabelDeleteStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDeleteStaff3MouseExited

    private void jLabelStatusStaff3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStatusStaff3MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 2);
        ConfirmOperations co = new ConfirmOperations(u);
        co.setVisible(true);
        co.pack();
    }//GEN-LAST:event_jLabelStatusStaff3MouseClicked

    private void jLabelEditStaff3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff3MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 2);
        EditStaff es = new EditStaff(u, "Sửa thông tin nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelEditStaff3MouseClicked

    private void jLabelEditStaff3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff3MouseEntered
        // TODO add your handling code here:
        jLabelEditStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px_1.png")));
    }//GEN-LAST:event_jLabelEditStaff3MouseEntered

    private void jLabelEditStaff3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff3MouseExited
        // TODO add your handling code here:
        jLabelEditStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png")));
    }//GEN-LAST:event_jLabelEditStaff3MouseExited

    private void jLabelNameStaff3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff3MouseClicked
        jLabelNameStaff1.setForeground(new java.awt.Color(0, 0, 0));
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 2);
        jDashboardQLNV.removeAll();
        try {
            jDashboardQLNV.add(new PanelInforStaff(u));
        } catch (SQLException ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDashboardQLNV.validate();
        jDashboardQLNV.repaint();
    }//GEN-LAST:event_jLabelNameStaff3MouseClicked

    private void jLabelNameStaff3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff3MouseEntered
        // TODO add your handling code here:
        jLabelNameStaff3.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelNameStaff3MouseEntered

    private void jLabelNameStaff3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff3MouseExited
        // TODO add your handling code here:
        jLabelNameStaff3.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameStaff3MouseExited

    private void jLabelMessengerStaff3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff3MouseEntered
        // TODO add your handling code here:
        jLabelMessengerStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px_2.png")));
        jLabelMessengerStaff3.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelMessengerStaff3MouseEntered

    private void jLabelMessengerStaff3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff3MouseExited
        // TODO add your handling code here:
        jLabelMessengerStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png")));
        jLabelMessengerStaff3.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelMessengerStaff3MouseExited

    private void jLabelAvatarClick3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarClick3MouseClicked
        // TODO add your handling code here:
        popUpImageStaff(2);
    }//GEN-LAST:event_jLabelAvatarClick3MouseClicked

    private void jLabelDeleteStaff7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff7MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 6);
        ConfirmDeleteStaff cd = new ConfirmDeleteStaff(u);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_jLabelDeleteStaff7MouseClicked

    private void jLabelDeleteStaff7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff7MouseEntered
        jLabelDeleteStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDeleteStaff7MouseEntered

    private void jLabelDeleteStaff7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff7MouseExited
        jLabelDeleteStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDeleteStaff7MouseExited

    private void jLabelStatusStaff7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStatusStaff7MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 6);
        ConfirmOperations co = new ConfirmOperations(u);
        co.setVisible(true);
        co.pack();
    }//GEN-LAST:event_jLabelStatusStaff7MouseClicked

    private void jLabelNameStaff7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff7MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 6);
        jDashboardQLNV.removeAll();
        try {
            jDashboardQLNV.add(new PanelInforStaff(u));
        } catch (SQLException ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDashboardQLNV.validate();
        jDashboardQLNV.repaint();
    }//GEN-LAST:event_jLabelNameStaff7MouseClicked

    private void jLabelNameStaff7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff7MouseEntered
        jLabelNameStaff7.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelNameStaff7MouseEntered

    private void jLabelNameStaff7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff7MouseExited
        jLabelNameStaff7.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameStaff7MouseExited

    private void jLabelEditStaff7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff7MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 6);
        EditStaff es = new EditStaff(u, "Sửa thông tin nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelEditStaff7MouseClicked

    private void jLabelEditStaff7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff7MouseEntered
        jLabelEditStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px_1.png")));
    }//GEN-LAST:event_jLabelEditStaff7MouseEntered

    private void jLabelEditStaff7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff7MouseExited
        jLabelEditStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png")));
    }//GEN-LAST:event_jLabelEditStaff7MouseExited

    private void jLabelMessengerStaff7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff7MouseEntered
        jLabelMessengerStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px_2.png")));
        jLabelMessengerStaff7.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelMessengerStaff7MouseEntered

    private void jLabelMessengerStaff7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff7MouseExited
        jLabelMessengerStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png")));
        jLabelMessengerStaff7.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelMessengerStaff7MouseExited

    private void jLabelAvatarClick7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarClick7MouseClicked
        // TODO add your handling code here:
        popUpImageStaff(6);
    }//GEN-LAST:event_jLabelAvatarClick7MouseClicked

    private void jLabelDeleteStaff8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff8MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 7);
        ConfirmDeleteStaff cd = new ConfirmDeleteStaff(u);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_jLabelDeleteStaff8MouseClicked

    private void jLabelDeleteStaff8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff8MouseEntered
        jLabelDeleteStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDeleteStaff8MouseEntered

    private void jLabelDeleteStaff8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff8MouseExited
        jLabelDeleteStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDeleteStaff8MouseExited

    private void jLabelStatusStaff8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStatusStaff8MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 7);
        ConfirmOperations co = new ConfirmOperations(u);
        co.setVisible(true);
        co.pack();
    }//GEN-LAST:event_jLabelStatusStaff8MouseClicked

    private void jLabelEditStaff8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff8MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 7);
        EditStaff es = new EditStaff(u, "Sửa thông tin nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelEditStaff8MouseClicked

    private void jLabelEditStaff8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff8MouseEntered
        jLabelEditStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px_1.png")));
    }//GEN-LAST:event_jLabelEditStaff8MouseEntered

    private void jLabelEditStaff8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff8MouseExited
        jLabelEditStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png")));
    }//GEN-LAST:event_jLabelEditStaff8MouseExited

    private void jLabelNameStaff8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff8MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 7);
        jDashboardQLNV.removeAll();
        try {
            jDashboardQLNV.add(new PanelInforStaff(u));
        } catch (SQLException ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDashboardQLNV.validate();
        jDashboardQLNV.repaint();
    }//GEN-LAST:event_jLabelNameStaff8MouseClicked

    private void jLabelNameStaff8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff8MouseEntered
        jLabelNameStaff8.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelNameStaff8MouseEntered

    private void jLabelNameStaff8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff8MouseExited
        jLabelNameStaff8.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameStaff8MouseExited

    private void jLabelMessengerStaff8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff8MouseEntered
        jLabelMessengerStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px_2.png")));
        jLabelMessengerStaff8.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelMessengerStaff8MouseEntered

    private void jLabelMessengerStaff8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff8MouseExited
        jLabelMessengerStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png")));
        jLabelMessengerStaff8.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelMessengerStaff8MouseExited

    private void jLabelAvatarClick8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarClick8MouseClicked
        popUpImageStaff(7);
    }//GEN-LAST:event_jLabelAvatarClick8MouseClicked

    private void jLabelDeleteStaff9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff9MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 8);
        ConfirmDeleteStaff cd = new ConfirmDeleteStaff(u);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_jLabelDeleteStaff9MouseClicked

    private void jLabelDeleteStaff9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff9MouseEntered
        jLabelDeleteStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDeleteStaff9MouseEntered

    private void jLabelDeleteStaff9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff9MouseExited
        jLabelDeleteStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDeleteStaff9MouseExited

    private void jLabelStatusStaff9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStatusStaff9MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 8);
        ConfirmOperations co = new ConfirmOperations(u);
        co.setVisible(true);
        co.pack();
    }//GEN-LAST:event_jLabelStatusStaff9MouseClicked

    private void jLabelNameStaff9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff9MouseClicked
        jLabelNameStaff1.setForeground(new java.awt.Color(0, 0, 0));
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 8);
        jDashboardQLNV.removeAll();
        try {
            jDashboardQLNV.add(new PanelInforStaff(u));
        } catch (SQLException ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDashboardQLNV.validate();
        jDashboardQLNV.repaint();
    }//GEN-LAST:event_jLabelNameStaff9MouseClicked

    private void jLabelNameStaff9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff9MouseEntered
        jLabelNameStaff9.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelNameStaff9MouseEntered

    private void jLabelNameStaff9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff9MouseExited
        jLabelNameStaff9.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameStaff9MouseExited

    private void jLabelEditStaff9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff9MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 8);
        EditStaff es = new EditStaff(u, "Sửa thông tin nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelEditStaff9MouseClicked

    private void jLabelEditStaff9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff9MouseEntered
        jLabelEditStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px_1.png")));
    }//GEN-LAST:event_jLabelEditStaff9MouseEntered

    private void jLabelEditStaff9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff9MouseExited
        jLabelEditStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png")));
    }//GEN-LAST:event_jLabelEditStaff9MouseExited

    private void jLabelMessengerStaff9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff9MouseEntered
        jLabelMessengerStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px_2.png")));
        jLabelMessengerStaff9.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelMessengerStaff9MouseEntered

    private void jLabelMessengerStaff9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff9MouseExited
        jLabelMessengerStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png")));
        jLabelMessengerStaff9.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelMessengerStaff9MouseExited

    private void jLabelAvatarClick9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarClick9MouseClicked
        popUpImageStaff(8);
    }//GEN-LAST:event_jLabelAvatarClick9MouseClicked

    private void jLabelDeleteStaff4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff4MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 3);
        ConfirmDeleteStaff cd = new ConfirmDeleteStaff(u);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_jLabelDeleteStaff4MouseClicked

    private void jLabelDeleteStaff4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff4MouseEntered
        // TODO add your handling code here:
        jLabelDeleteStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDeleteStaff4MouseEntered

    private void jLabelDeleteStaff4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff4MouseExited
        jLabelDeleteStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDeleteStaff4MouseExited

    private void jLabelStatusStaff4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStatusStaff4MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 3);
        ConfirmOperations co = new ConfirmOperations(u);
        co.setVisible(true);
        co.pack();
    }//GEN-LAST:event_jLabelStatusStaff4MouseClicked

    private void jLabelNameStaff4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff4MouseClicked
        jLabelNameStaff1.setForeground(new java.awt.Color(0, 0, 0));
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 3);
        jDashboardQLNV.removeAll();
        try {
            jDashboardQLNV.add(new PanelInforStaff(u));
        } catch (SQLException ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDashboardQLNV.validate();
        jDashboardQLNV.repaint();
    }//GEN-LAST:event_jLabelNameStaff4MouseClicked

    private void jLabelNameStaff4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff4MouseEntered
        // TODO add your handling code here:
        jLabelNameStaff4.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelNameStaff4MouseEntered

    private void jLabelNameStaff4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff4MouseExited
        // TODO add your handling code here:
        jLabelNameStaff4.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameStaff4MouseExited

    private void jLabelEditStaff4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff4MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 3);
        EditStaff es = new EditStaff(u, "Sửa thông tin nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelEditStaff4MouseClicked

    private void jLabelEditStaff4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff4MouseEntered
        // TODO add your handling code here:
        jLabelEditStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px_1.png")));
    }//GEN-LAST:event_jLabelEditStaff4MouseEntered

    private void jLabelEditStaff4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff4MouseExited
        // TODO add your handling code here:
        jLabelEditStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png")));
    }//GEN-LAST:event_jLabelEditStaff4MouseExited

    private void jLabelMessengerStaff4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff4MouseEntered
        // TODO add your handling code here:
        jLabelMessengerStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px_2.png")));
        jLabelMessengerStaff4.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelMessengerStaff4MouseEntered

    private void jLabelMessengerStaff4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff4MouseExited
        // TODO add your handling code here:
        jLabelMessengerStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png")));
        jLabelMessengerStaff4.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelMessengerStaff4MouseExited

    private void jLabelAvatarClick4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarClick4MouseClicked
        // TODO add your handling code here:
        popUpImageStaff(3);
    }//GEN-LAST:event_jLabelAvatarClick4MouseClicked

    private void jLabelDeleteStaff5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff5MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 4);
        ConfirmDeleteStaff cd = new ConfirmDeleteStaff(u);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_jLabelDeleteStaff5MouseClicked

    private void jLabelDeleteStaff5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff5MouseEntered
        jLabelDeleteStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDeleteStaff5MouseEntered

    private void jLabelDeleteStaff5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff5MouseExited
        jLabelDeleteStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDeleteStaff5MouseExited

    private void jLabelStatusStaff5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStatusStaff5MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 4);
        ConfirmOperations co = new ConfirmOperations(u);
        co.setVisible(true);
        co.pack();
    }//GEN-LAST:event_jLabelStatusStaff5MouseClicked

    private void jLabelEditStaff5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff5MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 4);
        EditStaff es = new EditStaff(u, "Sửa thông tin nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelEditStaff5MouseClicked

    private void jLabelEditStaff5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff5MouseEntered
        // TODO add your handling code here:
        jLabelEditStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px_1.png")));
    }//GEN-LAST:event_jLabelEditStaff5MouseEntered

    private void jLabelEditStaff5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff5MouseExited
        // TODO add your handling code here:
        jLabelEditStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png")));
    }//GEN-LAST:event_jLabelEditStaff5MouseExited

    private void jLabelNameStaff5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff5MouseClicked
        jLabelNameStaff1.setForeground(new java.awt.Color(0, 0, 0));
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 4);
        jDashboardQLNV.removeAll();
        try {
            jDashboardQLNV.add(new PanelInforStaff(u));
        } catch (SQLException ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDashboardQLNV.validate();
        jDashboardQLNV.repaint();
    }//GEN-LAST:event_jLabelNameStaff5MouseClicked

    private void jLabelNameStaff5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff5MouseEntered
        // TODO add your handling code here:
        jLabelNameStaff5.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelNameStaff5MouseEntered

    private void jLabelNameStaff5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff5MouseExited
        // TODO add your handling code here:
        jLabelNameStaff5.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameStaff5MouseExited

    private void jLabelMessengerStaff5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff5MouseEntered
        // TODO add your handling code here:
        jLabelMessengerStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px_2.png")));
        jLabelMessengerStaff5.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelMessengerStaff5MouseEntered

    private void jLabelMessengerStaff5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff5MouseExited
        // TODO add your handling code here:
        jLabelMessengerStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png")));
        jLabelMessengerStaff5.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelMessengerStaff5MouseExited

    private void jLabelAvatarClick5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarClick5MouseClicked
        // TODO add your handling code here:
        popUpImageStaff(4);
    }//GEN-LAST:event_jLabelAvatarClick5MouseClicked

    private void jLabelDeleteStaff6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff6MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 5);
        ConfirmDeleteStaff cd = new ConfirmDeleteStaff(u);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_jLabelDeleteStaff6MouseClicked

    private void jLabelDeleteStaff6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff6MouseEntered
        jLabelDeleteStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDeleteStaff6MouseEntered

    private void jLabelDeleteStaff6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff6MouseExited
        jLabelDeleteStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDeleteStaff6MouseExited

    private void jLabelStatusStaff6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStatusStaff6MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 5);
        ConfirmOperations co = new ConfirmOperations(u);
        co.setVisible(true);
        co.pack();
    }//GEN-LAST:event_jLabelStatusStaff6MouseClicked

    private void jLabelNameStaff6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff6MouseClicked
        jLabelNameStaff1.setForeground(new java.awt.Color(0, 0, 0));
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 5);
        jDashboardQLNV.removeAll();
        try {
            jDashboardQLNV.add(new PanelInforStaff(u));
        } catch (SQLException ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDashboardQLNV.validate();
        jDashboardQLNV.repaint();
    }//GEN-LAST:event_jLabelNameStaff6MouseClicked

    private void jLabelNameStaff6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff6MouseEntered
        // TODO add your handling code here:
        jLabelNameStaff6.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelNameStaff6MouseEntered

    private void jLabelNameStaff6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff6MouseExited
        // TODO add your handling code here:
        jLabelNameStaff6.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameStaff6MouseExited

    private void jLabelEditStaff6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff6MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 5);
        EditStaff es = new EditStaff(u, "Sửa thông tin nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelEditStaff6MouseClicked

    private void jLabelEditStaff6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff6MouseEntered
        // TODO add your handling code here:
        jLabelEditStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px_1.png")));
    }//GEN-LAST:event_jLabelEditStaff6MouseEntered

    private void jLabelEditStaff6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff6MouseExited
        // TODO add your handling code here:
        jLabelEditStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png")));
    }//GEN-LAST:event_jLabelEditStaff6MouseExited

    private void jLabelMessengerStaff6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff6MouseEntered
        // TODO add your handling code here:
        jLabelMessengerStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px_2.png")));
        jLabelMessengerStaff6.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelMessengerStaff6MouseEntered

    private void jLabelMessengerStaff6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff6MouseExited
        // TODO add your handling code here:
        jLabelMessengerStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png")));
        jLabelMessengerStaff6.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelMessengerStaff6MouseExited

    private void jLabelAvatarClick6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarClick6MouseClicked
        // TODO add your handling code here:
        popUpImageStaff(5);
    }//GEN-LAST:event_jLabelAvatarClick6MouseClicked

    private void jTextFieldPageStaffKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPageStaffKeyReleased
        try {
            showStaffList(ListUsers, countStaff);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(PanelStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldPageStaffKeyReleased

    private void jLabelRight2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRight2MouseClicked
        // TODO add your handling code here:
        int jlabelrighta = Integer.parseInt(jTextFieldPageStaff.getText());
        int jlabelrightb = countStaff / 9 + setPageStaff;
        if (jlabelrighta < jlabelrightb) {
            jTextFieldPageStaff.setText(String.valueOf(jlabelrighta + 1));
            try {
                showStaffList(ListUsers, countStaff);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(PanelStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelRight2MouseClicked

    private void jLabelRight2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRight2MouseEntered
        // TODO add your handling code here:
        jLabelRight2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px_1.png")));
    }//GEN-LAST:event_jLabelRight2MouseEntered

    private void jLabelRight2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRight2MouseExited
        // TODO add your handling code here:
        jLabelRight2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px.png")));
    }//GEN-LAST:event_jLabelRight2MouseExited

    private void jLabelLeft2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeft2MouseClicked
        // TODO add your handling code here:
        int jlabelrighta = Integer.parseInt(jTextFieldPageStaff.getText());
        if (Integer.parseInt(jTextFieldPageStaff.getText()) > 1) {
            jTextFieldPageStaff.setText(String.valueOf(jlabelrighta - 1));
            try {
                showStaffList(ListUsers, countStaff);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(PanelStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelLeft2MouseClicked

    private void jLabelLeft2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeft2MouseEntered
        // TODO add your handling code here:
        jLabelLeft2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px.png")));
    }//GEN-LAST:event_jLabelLeft2MouseEntered

    private void jLabelLeft2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeft2MouseExited
        // TODO add your handling code here:
        jLabelLeft2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px_1.png")));
    }//GEN-LAST:event_jLabelLeft2MouseExited

    private void jLabelSkipToEnd2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEnd2MouseClicked
        // TODO add your handling code here:
        int jlabelrighta = Integer.parseInt(jTextFieldPageStaff.getText());
        int jlabelrightb = countStaff / 9 + setPageStaff;
        if (jlabelrighta < jlabelrightb) {
            jTextFieldPageStaff.setText(String.valueOf(countStaff / 9 + setPageStaff));
            try {
                showStaffList(ListUsers, countStaff);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(PanelStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelSkipToEnd2MouseClicked

    private void jLabelSkipToEnd2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEnd2MouseEntered
        // TODO add your handling code here:
        jLabelSkipToEnd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px.png")));
    }//GEN-LAST:event_jLabelSkipToEnd2MouseEntered

    private void jLabelSkipToEnd2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEnd2MouseExited
        // TODO add your handling code here:
        jLabelSkipToEnd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px_1.png")));
    }//GEN-LAST:event_jLabelSkipToEnd2MouseExited

    private void jLabelSkipToStart2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStart2MouseClicked
        // TODO add your handling code here:
        if (Integer.parseInt(jTextFieldPageStaff.getText()) > 1) {
            jTextFieldPageStaff.setText("1");
            try {
                showStaffList(ListUsers, countStaff);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(PanelStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelSkipToStart2MouseClicked

    private void jLabelSkipToStart2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStart2MouseEntered
        // TODO add your handling code here:
        jLabelSkipToStart2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px.png")));
    }//GEN-LAST:event_jLabelSkipToStart2MouseEntered

    private void jLabelSkipToStart2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStart2MouseExited
        // TODO add your handling code here:
        jLabelSkipToStart2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px_1.png")));
    }//GEN-LAST:event_jLabelSkipToStart2MouseExited

    private void jTextFieldSearchStaffFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchStaffFocusGained
        jTextFieldSearchStaff.setText("");
    }//GEN-LAST:event_jTextFieldSearchStaffFocusGained

    private void jTextFieldSearchStaffFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchStaffFocusLost
        if (jTextFieldSearchStaff.getText().equals("")) {
            jTextFieldSearchStaff.setText("Tìm kiếm");
        }
    }//GEN-LAST:event_jTextFieldSearchStaffFocusLost

    private void jTextFieldSearchStaffKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchStaffKeyReleased

        String searchKey = jTextFieldSearchStaff.getText();

        try {
            ListUsers = UsersDao.searchStaff(searchKey);
            countStaff = UsersDao.countStaffSearch(searchKey);
            showStaffList(ListUsers, countStaff);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(PanelStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jTextFieldSearchStaffKeyReleased

    private void jLabelButtonAddStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonAddStaffMouseClicked
        EditStaff es = new EditStaff(null, "Thêm nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelButtonAddStaffMouseClicked

    private void jLabelButtonAddStaffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonAddStaffMouseEntered
        // TODO add your handling code here:
        jLabelBBButtonAddStaff.setIcon(scaleButtonAddStaff("/Image/ButtonEditDark.png"));
    }//GEN-LAST:event_jLabelButtonAddStaffMouseEntered

    private void jLabelButtonAddStaffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonAddStaffMouseExited
        jLabelBBButtonAddStaff.setIcon(scaleButtonAddStaff("/Image/ButtonEditBlue.png"));
    }//GEN-LAST:event_jLabelButtonAddStaffMouseExited

    private void jLabelButtonRefreshStaffListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonRefreshStaffListMouseClicked
        try {
            ListUsers = UsersDao.findStaff();
            countStaff = UsersDao.countStaff();
            showStaffList(ListUsers, countStaff);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(PanelStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jLabelButtonRefreshStaffListMouseClicked

    private void jLabelButtonRefreshStaffListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonRefreshStaffListMouseEntered
        // TODO add your handling code here:
        jLabelBBButtonRefreshStaffList.setIcon(scaleButtonRefresh("/Image/ButtonEditDark.png"));
    }//GEN-LAST:event_jLabelButtonRefreshStaffListMouseEntered

    private void jLabelButtonRefreshStaffListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonRefreshStaffListMouseExited
        jLabelBBButtonRefreshStaffList.setIcon(scaleButtonRefresh("/Image/ButtonEditLight.png"));
    }//GEN-LAST:event_jLabelButtonRefreshStaffListMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jDashboardQLNV;
    private javax.swing.JLabel jLabelAddressStaff1;
    private javax.swing.JLabel jLabelAddressStaff2;
    private javax.swing.JLabel jLabelAddressStaff3;
    private javax.swing.JLabel jLabelAddressStaff4;
    private javax.swing.JLabel jLabelAddressStaff5;
    private javax.swing.JLabel jLabelAddressStaff6;
    private javax.swing.JLabel jLabelAddressStaff7;
    private javax.swing.JLabel jLabelAddressStaff8;
    private javax.swing.JLabel jLabelAddressStaff9;
    private javax.swing.JLabel jLabelAvatar1;
    private javax.swing.JLabel jLabelAvatar2;
    private javax.swing.JLabel jLabelAvatar3;
    private javax.swing.JLabel jLabelAvatar4;
    private javax.swing.JLabel jLabelAvatar5;
    private javax.swing.JLabel jLabelAvatar6;
    private javax.swing.JLabel jLabelAvatar7;
    private javax.swing.JLabel jLabelAvatar8;
    private javax.swing.JLabel jLabelAvatar9;
    private javax.swing.JLabel jLabelAvatarClick1;
    private javax.swing.JLabel jLabelAvatarClick2;
    private javax.swing.JLabel jLabelAvatarClick3;
    private javax.swing.JLabel jLabelAvatarClick4;
    private javax.swing.JLabel jLabelAvatarClick5;
    private javax.swing.JLabel jLabelAvatarClick6;
    private javax.swing.JLabel jLabelAvatarClick7;
    private javax.swing.JLabel jLabelAvatarClick8;
    private javax.swing.JLabel jLabelAvatarClick9;
    private javax.swing.JLabel jLabelBBButtonAddStaff;
    private javax.swing.JLabel jLabelBBButtonRefreshStaffList;
    private javax.swing.JLabel jLabelButtonAddStaff;
    private javax.swing.JLabel jLabelButtonRefreshStaffList;
    private javax.swing.JLabel jLabelDeleteStaff1;
    private javax.swing.JLabel jLabelDeleteStaff2;
    private javax.swing.JLabel jLabelDeleteStaff3;
    private javax.swing.JLabel jLabelDeleteStaff4;
    private javax.swing.JLabel jLabelDeleteStaff5;
    private javax.swing.JLabel jLabelDeleteStaff6;
    private javax.swing.JLabel jLabelDeleteStaff7;
    private javax.swing.JLabel jLabelDeleteStaff8;
    private javax.swing.JLabel jLabelDeleteStaff9;
    private javax.swing.JLabel jLabelEditStaff1;
    private javax.swing.JLabel jLabelEditStaff2;
    private javax.swing.JLabel jLabelEditStaff3;
    private javax.swing.JLabel jLabelEditStaff4;
    private javax.swing.JLabel jLabelEditStaff5;
    private javax.swing.JLabel jLabelEditStaff6;
    private javax.swing.JLabel jLabelEditStaff7;
    private javax.swing.JLabel jLabelEditStaff8;
    private javax.swing.JLabel jLabelEditStaff9;
    private javax.swing.JLabel jLabelEmailStaff1;
    private javax.swing.JLabel jLabelEmailStaff2;
    private javax.swing.JLabel jLabelEmailStaff3;
    private javax.swing.JLabel jLabelEmailStaff4;
    private javax.swing.JLabel jLabelEmailStaff5;
    private javax.swing.JLabel jLabelEmailStaff6;
    private javax.swing.JLabel jLabelEmailStaff7;
    private javax.swing.JLabel jLabelEmailStaff8;
    private javax.swing.JLabel jLabelEmailStaff9;
    private javax.swing.JLabel jLabelFrameSearchStaff;
    private javax.swing.JLabel jLabelFrameStaff1;
    private javax.swing.JLabel jLabelFrameStaff2;
    private javax.swing.JLabel jLabelFrameStaff3;
    private javax.swing.JLabel jLabelFrameStaff4;
    private javax.swing.JLabel jLabelFrameStaff5;
    private javax.swing.JLabel jLabelFrameStaff6;
    private javax.swing.JLabel jLabelFrameStaff7;
    private javax.swing.JLabel jLabelFrameStaff8;
    private javax.swing.JLabel jLabelFrameStaff9;
    private javax.swing.JLabel jLabelGenderStaff1;
    private javax.swing.JLabel jLabelGenderStaff2;
    private javax.swing.JLabel jLabelGenderStaff3;
    private javax.swing.JLabel jLabelGenderStaff4;
    private javax.swing.JLabel jLabelGenderStaff5;
    private javax.swing.JLabel jLabelGenderStaff6;
    private javax.swing.JLabel jLabelGenderStaff7;
    private javax.swing.JLabel jLabelGenderStaff8;
    private javax.swing.JLabel jLabelGenderStaff9;
    private javax.swing.JLabel jLabelLeft2;
    private javax.swing.JLabel jLabelMessengerStaff1;
    private javax.swing.JLabel jLabelMessengerStaff2;
    private javax.swing.JLabel jLabelMessengerStaff3;
    private javax.swing.JLabel jLabelMessengerStaff4;
    private javax.swing.JLabel jLabelMessengerStaff5;
    private javax.swing.JLabel jLabelMessengerStaff6;
    private javax.swing.JLabel jLabelMessengerStaff7;
    private javax.swing.JLabel jLabelMessengerStaff8;
    private javax.swing.JLabel jLabelMessengerStaff9;
    private javax.swing.JLabel jLabelNameStaff1;
    private javax.swing.JLabel jLabelNameStaff2;
    private javax.swing.JLabel jLabelNameStaff3;
    private javax.swing.JLabel jLabelNameStaff4;
    private javax.swing.JLabel jLabelNameStaff5;
    private javax.swing.JLabel jLabelNameStaff6;
    private javax.swing.JLabel jLabelNameStaff7;
    private javax.swing.JLabel jLabelNameStaff8;
    private javax.swing.JLabel jLabelNameStaff9;
    private javax.swing.JLabel jLabelPageStaff;
    private javax.swing.JLabel jLabelRight2;
    private javax.swing.JLabel jLabelSearchStaff;
    private javax.swing.JLabel jLabelSkipToEnd2;
    private javax.swing.JLabel jLabelSkipToStart2;
    private javax.swing.JLabel jLabelStatusStaff1;
    private javax.swing.JLabel jLabelStatusStaff2;
    private javax.swing.JLabel jLabelStatusStaff3;
    private javax.swing.JLabel jLabelStatusStaff4;
    private javax.swing.JLabel jLabelStatusStaff5;
    private javax.swing.JLabel jLabelStatusStaff6;
    private javax.swing.JLabel jLabelStatusStaff7;
    private javax.swing.JLabel jLabelStatusStaff8;
    private javax.swing.JLabel jLabelStatusStaff9;
    private javax.swing.JLabel jLabelTitleQLNV;
    private javax.swing.JPanel jPanelControlPageStaff;
    private javax.swing.JPanel jPanelInfor;
    private javax.swing.JPanel jPanelList;
    private javax.swing.JPanel jPanelStaff1;
    private javax.swing.JPanel jPanelStaff2;
    private javax.swing.JPanel jPanelStaff3;
    private javax.swing.JPanel jPanelStaff4;
    private javax.swing.JPanel jPanelStaff5;
    private javax.swing.JPanel jPanelStaff6;
    private javax.swing.JPanel jPanelStaff7;
    private javax.swing.JPanel jPanelStaff8;
    private javax.swing.JPanel jPanelStaff9;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldPageStaff;
    private javax.swing.JTextField jTextFieldSearchStaff;
    // End of variables declaration//GEN-END:variables
}
