/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.views.admin.supplier;

import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import qlbhgg.dao.SupplierDao;
import qlbhgg.models.Suppliers;
import qlbhgg.views.admin.AdminForm;

/**
 *
 * @author acer
 */
public class PanelSupplier extends javax.swing.JPanel {

    /**
     * Creates new form PanelSupplier
     */
    public ArrayList<Suppliers> ListSuppliers = SupplierDao.findAllSupplier();
    public int countSupplier = SupplierDao.countSupplier();
    public int setPageSupplier;

    public PanelSupplier() throws SQLException {
        initComponents();
        showSupplierList(ListSuppliers, countSupplier);
    }

    public void startingStateQLNCC() {
        jPanelSupplier1.setVisible(false);
        jPanelSupplier2.setVisible(false);
        jPanelSupplier3.setVisible(false);
        jPanelSupplier4.setVisible(false);
        jPanelSupplier5.setVisible(false);
        jPanelSupplier6.setVisible(false);
        jPanelSupplier7.setVisible(false);
        jPanelSupplier8.setVisible(false);
    }

    public void showSupplierList(ArrayList<Suppliers> ListSuppliers, int countSupplier) throws SQLException {
        startingStateQLNCC();
        setPageSupplier = (countSupplier % 8 == 0) ? 0 : 1;
        jLabelPageSupplier.setText("/" + String.valueOf(countSupplier / 8 + setPageSupplier));
        int pageSupplier = (Integer.parseInt(jTextFieldPageSupplier.getText()) - 1) * 8;
        if (pageSupplier < countSupplier) {
            renderJPanelSupplier(ListSuppliers.get(pageSupplier), jPanelSupplier1, jLabelIdSupplier1, jLabelNameSupplier1, jLabelLogoSupplier1, jLabelNameTrading1, jLabelAddressSupplier1, jLabelEmailSupplier1, jLabelPhonenumberSupplier1);
        } else {
            jPanelSupplier1.setVisible(false);
        }
        if (pageSupplier + 1 < countSupplier) {
            renderJPanelSupplier(ListSuppliers.get(pageSupplier + 1), jPanelSupplier2, jLabelIdSupplier2, jLabelNameSupplier2, jLabelLogoSupplier2, jLabelNameTrading2, jLabelAddressSupplier2, jLabelEmailSupplier2, jLabelPhonenumberSupplier2);
        } else {
            jPanelSupplier2.setVisible(false);
        }
        if (pageSupplier + 2 < countSupplier) {
            renderJPanelSupplier(ListSuppliers.get(pageSupplier + 2), jPanelSupplier3, jLabelIdSupplier3, jLabelNameSupplier3, jLabelLogoSupplier3, jLabelNameTrading3, jLabelAddressSupplier3, jLabelEmailSupplier3, jLabelPhonenumberSupplier3);
        } else {
            jPanelSupplier3.setVisible(false);
        }
        if (pageSupplier + 3 < countSupplier) {
            renderJPanelSupplier(ListSuppliers.get(pageSupplier + 3), jPanelSupplier4, jLabelIdSupplier4, jLabelNameSupplier4, jLabelLogoSupplier4, jLabelNameTrading4, jLabelAddressSupplier4, jLabelEmailSupplier4, jLabelPhonenumberSupplier4);
        } else {
            jPanelSupplier4.setVisible(false);
        }
        if (pageSupplier + 4 < countSupplier) {
            renderJPanelSupplier(ListSuppliers.get(pageSupplier + 4), jPanelSupplier5, jLabelIdSupplier5, jLabelNameSupplier5, jLabelLogoSupplier5, jLabelNameTrading5, jLabelAddressSupplier5, jLabelEmailSupplier5, jLabelPhonenumberSupplier5);
        } else {
            jPanelSupplier5.setVisible(false);
        }
        if (pageSupplier + 5 < countSupplier) {
            renderJPanelSupplier(ListSuppliers.get(pageSupplier + 5), jPanelSupplier6, jLabelIdSupplier6, jLabelNameSupplier6, jLabelLogoSupplier6, jLabelNameTrading6, jLabelAddressSupplier6, jLabelEmailSupplier6, jLabelPhonenumberSupplier6);
        } else {
            jPanelSupplier6.setVisible(false);
        }
        if (pageSupplier + 6 < countSupplier) {
            renderJPanelSupplier(ListSuppliers.get(pageSupplier + 6), jPanelSupplier7, jLabelIdSupplier7, jLabelNameSupplier7, jLabelLogoSupplier7, jLabelNameTrading7, jLabelAddressSupplier7, jLabelEmailSupplier7, jLabelPhonenumberSupplier7);
        } else {
            jPanelSupplier7.setVisible(false);
        }
        if (pageSupplier + 7 < countSupplier) {
            renderJPanelSupplier(ListSuppliers.get(pageSupplier + 7), jPanelSupplier8, jLabelIdSupplier8, jLabelNameSupplier8, jLabelLogoSupplier8, jLabelNameTrading8, jLabelAddressSupplier8, jLabelEmailSupplier8, jLabelPhonenumberSupplier8);
        } else {
            jPanelSupplier8.setVisible(false);
        }
        jLabelFrameSearchSupplier.setIcon(scaleFrameSearch("/Image/FrameSearch.png"));
    }

    private void renderJPanelSupplier(Suppliers s, JPanel jpanel, JLabel jlabelIdSupplier, JLabel jlabelNameSupplier, JLabel jlabelLogoSupplier, JLabel jlabelNameTradingSupplier, JLabel jlabelAddressSupplier, JLabel jlabelEmailSupplier, JLabel jlabelPhonenumberSupplier) {
        jpanel.setVisible(true);
        jlabelIdSupplier.setText(s.getCompanycode());
        jlabelNameSupplier.setText(s.getCompanyname());
        jlabelLogoSupplier.setIcon(scaleImageProduct(s.getLogo()));
        jlabelNameTradingSupplier.setText("<html>" + s.getTradingname() + "</html>");
        jlabelEmailSupplier.setText(s.getEmail());
        jlabelAddressSupplier.setText("<html>" + s.getAddress() + "</html>");
        jlabelPhonenumberSupplier.setText(s.getPhonenumber());
    }

    public ImageIcon scaleFrameSearch(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(280, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }

    public ImageIcon scaleImageProduct(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(78, 78, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDashboardQLNCC = new javax.swing.JPanel();
        jPanelSupplier8 = new javax.swing.JPanel();
        jCheckBoxSupplier7 = new javax.swing.JCheckBox();
        jLabelIdSupplier8 = new javax.swing.JLabel();
        jLabelNameSupplier8 = new javax.swing.JLabel();
        jLabelLogoSupplier8 = new javax.swing.JLabel();
        jLabelNameTrading8 = new javax.swing.JLabel();
        jLabelAddressSupplier8 = new javax.swing.JLabel();
        jLabelEmailSupplier8 = new javax.swing.JLabel();
        jLabelPhonenumberSupplier8 = new javax.swing.JLabel();
        jLabelSettingSupplier8 = new javax.swing.JLabel();
        jPanelSupplier7 = new javax.swing.JPanel();
        jCheckBoxSupplier6 = new javax.swing.JCheckBox();
        jLabelIdSupplier7 = new javax.swing.JLabel();
        jLabelNameSupplier7 = new javax.swing.JLabel();
        jLabelLogoSupplier7 = new javax.swing.JLabel();
        jLabelNameTrading7 = new javax.swing.JLabel();
        jLabelAddressSupplier7 = new javax.swing.JLabel();
        jLabelEmailSupplier7 = new javax.swing.JLabel();
        jLabelPhonenumberSupplier7 = new javax.swing.JLabel();
        jLabelSettingSupplier7 = new javax.swing.JLabel();
        jPanelSupplier6 = new javax.swing.JPanel();
        jCheckBoxSupplier5 = new javax.swing.JCheckBox();
        jLabelIdSupplier6 = new javax.swing.JLabel();
        jLabelNameSupplier6 = new javax.swing.JLabel();
        jLabelLogoSupplier6 = new javax.swing.JLabel();
        jLabelNameTrading6 = new javax.swing.JLabel();
        jLabelAddressSupplier6 = new javax.swing.JLabel();
        jLabelEmailSupplier6 = new javax.swing.JLabel();
        jLabelPhonenumberSupplier6 = new javax.swing.JLabel();
        jLabelSettingSupplier6 = new javax.swing.JLabel();
        jPanelSupplier5 = new javax.swing.JPanel();
        jCheckBoxSupplier4 = new javax.swing.JCheckBox();
        jLabelIdSupplier5 = new javax.swing.JLabel();
        jLabelNameSupplier5 = new javax.swing.JLabel();
        jLabelLogoSupplier5 = new javax.swing.JLabel();
        jLabelNameTrading5 = new javax.swing.JLabel();
        jLabelAddressSupplier5 = new javax.swing.JLabel();
        jLabelEmailSupplier5 = new javax.swing.JLabel();
        jLabelPhonenumberSupplier5 = new javax.swing.JLabel();
        jLabelSettingSupplier5 = new javax.swing.JLabel();
        jPanelSupplier4 = new javax.swing.JPanel();
        jCheckBoxSupplier3 = new javax.swing.JCheckBox();
        jLabelIdSupplier4 = new javax.swing.JLabel();
        jLabelNameSupplier4 = new javax.swing.JLabel();
        jLabelLogoSupplier4 = new javax.swing.JLabel();
        jLabelNameTrading4 = new javax.swing.JLabel();
        jLabelAddressSupplier4 = new javax.swing.JLabel();
        jLabelEmailSupplier4 = new javax.swing.JLabel();
        jLabelPhonenumberSupplier4 = new javax.swing.JLabel();
        jLabelSettingSupplier4 = new javax.swing.JLabel();
        jPanelSupplier3 = new javax.swing.JPanel();
        jCheckBoxSupplier2 = new javax.swing.JCheckBox();
        jLabelIdSupplier3 = new javax.swing.JLabel();
        jLabelNameSupplier3 = new javax.swing.JLabel();
        jLabelLogoSupplier3 = new javax.swing.JLabel();
        jLabelNameTrading3 = new javax.swing.JLabel();
        jLabelAddressSupplier3 = new javax.swing.JLabel();
        jLabelEmailSupplier3 = new javax.swing.JLabel();
        jLabelPhonenumberSupplier3 = new javax.swing.JLabel();
        jLabelSettingSupplier3 = new javax.swing.JLabel();
        jPanelSupplier2 = new javax.swing.JPanel();
        jCheckBoxSupplier1 = new javax.swing.JCheckBox();
        jLabelIdSupplier2 = new javax.swing.JLabel();
        jLabelNameSupplier2 = new javax.swing.JLabel();
        jLabelLogoSupplier2 = new javax.swing.JLabel();
        jLabelNameTrading2 = new javax.swing.JLabel();
        jLabelAddressSupplier2 = new javax.swing.JLabel();
        jLabelEmailSupplier2 = new javax.swing.JLabel();
        jLabelPhonenumberSupplier2 = new javax.swing.JLabel();
        jLabelSettingSupplier2 = new javax.swing.JLabel();
        jPanelSupplier1 = new javax.swing.JPanel();
        jCheckBoxSupplier = new javax.swing.JCheckBox();
        jLabelIdSupplier1 = new javax.swing.JLabel();
        jLabelNameSupplier1 = new javax.swing.JLabel();
        jLabelLogoSupplier1 = new javax.swing.JLabel();
        jLabelNameTrading1 = new javax.swing.JLabel();
        jLabelAddressSupplier1 = new javax.swing.JLabel();
        jLabelEmailSupplier1 = new javax.swing.JLabel();
        jLabelPhonenumberSupplier1 = new javax.swing.JLabel();
        jLabelSettingSupplier1 = new javax.swing.JLabel();
        jPanelHeaderSupplier = new javax.swing.JPanel();
        jCheckBoxAll1 = new javax.swing.JCheckBox();
        jLabelMaSP1 = new javax.swing.JLabel();
        jLabelImage8 = new javax.swing.JLabel();
        jLabelName8 = new javax.swing.JLabel();
        jLabelType8 = new javax.swing.JLabel();
        jLabelCompany8 = new javax.swing.JLabel();
        jLabelPriceImport1 = new javax.swing.JLabel();
        jLabelPrice8 = new javax.swing.JLabel();
        jLabelSettings1 = new javax.swing.JLabel();
        jPanelControlPageSupplier = new javax.swing.JPanel();
        jTextFieldPageSupplier = new javax.swing.JTextField();
        jLabelPageSupplier = new javax.swing.JLabel();
        jLabelRightSupplier = new javax.swing.JLabel();
        jLabelLeftSupplier = new javax.swing.JLabel();
        jLabelSkipToEndSupplier = new javax.swing.JLabel();
        jLabelSkipToStartSupplier = new javax.swing.JLabel();
        jTextFieldSearchSupplier = new javax.swing.JTextField();
        jLabelSearchSupplier = new javax.swing.JLabel();
        jLabelFrameSearchSupplier = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1330, 870));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDashboardQLNCC.setBackground(new java.awt.Color(255, 255, 255));
        jDashboardQLNCC.setForeground(new java.awt.Color(255, 153, 153));
        jDashboardQLNCC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelSupplier8.setBackground(new java.awt.Color(215, 220, 222));
        jPanelSupplier8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier8.setForeground(new java.awt.Color(255, 255, 255));
        jPanelSupplier8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBoxSupplier7.setBackground(new java.awt.Color(215, 220, 222));
        jCheckBoxSupplier7.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxSupplier7.setBorder(null);
        jPanelSupplier8.add(jCheckBoxSupplier7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 20, 60));

        jLabelIdSupplier8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdSupplier8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelIdSupplier8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIdSupplier8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdSupplier8.setText("Mã nhà cung cấp");
        jLabelIdSupplier8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier8.add(jLabelIdSupplier8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelNameSupplier8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameSupplier8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameSupplier8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameSupplier8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameSupplier8.setText("Tên nhà cung cấp");
        jPanelSupplier8.add(jLabelNameSupplier8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 180, 80));

        jLabelLogoSupplier8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogoSupplier8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelLogoSupplier8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelLogoSupplier8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogoSupplier8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier8.add(jLabelLogoSupplier8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 80, 80));

        jLabelNameTrading8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameTrading8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameTrading8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameTrading8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameTrading8.setText("Tên giao dịch");
        jPanelSupplier8.add(jLabelNameTrading8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 210, 80));

        jLabelAddressSupplier8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressSupplier8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAddressSupplier8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddressSupplier8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddressSupplier8.setText("Địa chỉ");
        jLabelAddressSupplier8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier8.add(jLabelAddressSupplier8, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 220, 80));

        jLabelEmailSupplier8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailSupplier8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmailSupplier8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailSupplier8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmailSupplier8.setText("Email");
        jPanelSupplier8.add(jLabelEmailSupplier8, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 240, 80));

        jLabelPhonenumberSupplier8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPhonenumberSupplier8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPhonenumberSupplier8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPhonenumberSupplier8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPhonenumberSupplier8.setText("Số điện thoại");
        jLabelPhonenumberSupplier8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier8.add(jLabelPhonenumberSupplier8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 140, 80));

        jLabelSettingSupplier8.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingSupplier8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingSupplier8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSettingSupplier8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingSupplier8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jPanelSupplier8.add(jLabelSettingSupplier8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 70, 80));

        jDashboardQLNCC.add(jPanelSupplier8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 740, 1330, 80));

        jPanelSupplier7.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSupplier7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier7.setForeground(new java.awt.Color(255, 255, 255));
        jPanelSupplier7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBoxSupplier6.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxSupplier6.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxSupplier6.setBorder(null);
        jPanelSupplier7.add(jCheckBoxSupplier6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 20, 60));

        jLabelIdSupplier7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdSupplier7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelIdSupplier7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIdSupplier7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdSupplier7.setText("Mã nhà cung cấp");
        jLabelIdSupplier7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier7.add(jLabelIdSupplier7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelNameSupplier7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameSupplier7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameSupplier7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameSupplier7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameSupplier7.setText("Tên nhà cung cấp");
        jPanelSupplier7.add(jLabelNameSupplier7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 180, 80));

        jLabelLogoSupplier7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogoSupplier7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelLogoSupplier7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelLogoSupplier7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogoSupplier7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier7.add(jLabelLogoSupplier7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 80, 80));

        jLabelNameTrading7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameTrading7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameTrading7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameTrading7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameTrading7.setText("Tên giao dịch");
        jPanelSupplier7.add(jLabelNameTrading7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 210, 80));

        jLabelAddressSupplier7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressSupplier7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAddressSupplier7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddressSupplier7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddressSupplier7.setText("Địa chỉ");
        jLabelAddressSupplier7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier7.add(jLabelAddressSupplier7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 220, 80));

        jLabelEmailSupplier7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailSupplier7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmailSupplier7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailSupplier7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmailSupplier7.setText("Email");
        jPanelSupplier7.add(jLabelEmailSupplier7, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 240, 80));

        jLabelPhonenumberSupplier7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPhonenumberSupplier7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPhonenumberSupplier7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPhonenumberSupplier7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPhonenumberSupplier7.setText("Số điện thoại");
        jLabelPhonenumberSupplier7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier7.add(jLabelPhonenumberSupplier7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 140, 80));

        jLabelSettingSupplier7.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingSupplier7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingSupplier7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSettingSupplier7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingSupplier7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jPanelSupplier7.add(jLabelSettingSupplier7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 70, 80));

        jDashboardQLNCC.add(jPanelSupplier7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 1330, 80));

        jPanelSupplier6.setBackground(new java.awt.Color(215, 220, 222));
        jPanelSupplier6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier6.setForeground(new java.awt.Color(255, 255, 255));
        jPanelSupplier6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBoxSupplier5.setBackground(new java.awt.Color(215, 220, 222));
        jCheckBoxSupplier5.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxSupplier5.setBorder(null);
        jPanelSupplier6.add(jCheckBoxSupplier5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 20, 60));

        jLabelIdSupplier6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdSupplier6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelIdSupplier6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIdSupplier6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdSupplier6.setText("Mã nhà cung cấp");
        jLabelIdSupplier6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier6.add(jLabelIdSupplier6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelNameSupplier6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameSupplier6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameSupplier6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameSupplier6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameSupplier6.setText("Tên nhà cung cấp");
        jPanelSupplier6.add(jLabelNameSupplier6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 180, 80));

        jLabelLogoSupplier6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogoSupplier6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelLogoSupplier6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelLogoSupplier6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogoSupplier6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier6.add(jLabelLogoSupplier6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 80, 80));

        jLabelNameTrading6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameTrading6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameTrading6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameTrading6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameTrading6.setText("Tên giao dịch");
        jPanelSupplier6.add(jLabelNameTrading6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 210, 80));

        jLabelAddressSupplier6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressSupplier6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAddressSupplier6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddressSupplier6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddressSupplier6.setText("Địa chỉ");
        jLabelAddressSupplier6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier6.add(jLabelAddressSupplier6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 220, 80));

        jLabelEmailSupplier6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailSupplier6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmailSupplier6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailSupplier6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmailSupplier6.setText("Email");
        jPanelSupplier6.add(jLabelEmailSupplier6, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 240, 80));

        jLabelPhonenumberSupplier6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPhonenumberSupplier6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPhonenumberSupplier6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPhonenumberSupplier6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPhonenumberSupplier6.setText("Số điện thoại");
        jLabelPhonenumberSupplier6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier6.add(jLabelPhonenumberSupplier6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 140, 80));

        jLabelSettingSupplier6.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingSupplier6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingSupplier6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSettingSupplier6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingSupplier6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jPanelSupplier6.add(jLabelSettingSupplier6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 70, 80));

        jDashboardQLNCC.add(jPanelSupplier6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 1330, 80));

        jPanelSupplier5.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSupplier5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier5.setForeground(new java.awt.Color(255, 255, 255));
        jPanelSupplier5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBoxSupplier4.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxSupplier4.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxSupplier4.setBorder(null);
        jPanelSupplier5.add(jCheckBoxSupplier4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 20, 60));

        jLabelIdSupplier5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdSupplier5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelIdSupplier5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIdSupplier5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdSupplier5.setText("Mã nhà cung cấp");
        jLabelIdSupplier5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier5.add(jLabelIdSupplier5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelNameSupplier5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameSupplier5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameSupplier5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameSupplier5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameSupplier5.setText("Tên nhà cung cấp");
        jPanelSupplier5.add(jLabelNameSupplier5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 180, 80));

        jLabelLogoSupplier5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogoSupplier5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelLogoSupplier5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelLogoSupplier5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogoSupplier5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier5.add(jLabelLogoSupplier5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 80, 80));

        jLabelNameTrading5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameTrading5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameTrading5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameTrading5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameTrading5.setText("Tên giao dịch");
        jPanelSupplier5.add(jLabelNameTrading5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 210, 80));

        jLabelAddressSupplier5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressSupplier5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAddressSupplier5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddressSupplier5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddressSupplier5.setText("Địa chỉ");
        jLabelAddressSupplier5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier5.add(jLabelAddressSupplier5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 220, 80));

        jLabelEmailSupplier5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailSupplier5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmailSupplier5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailSupplier5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmailSupplier5.setText("Email");
        jPanelSupplier5.add(jLabelEmailSupplier5, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 240, 80));

        jLabelPhonenumberSupplier5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPhonenumberSupplier5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPhonenumberSupplier5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPhonenumberSupplier5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPhonenumberSupplier5.setText("Số điện thoại");
        jLabelPhonenumberSupplier5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier5.add(jLabelPhonenumberSupplier5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 140, 80));

        jLabelSettingSupplier5.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingSupplier5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingSupplier5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSettingSupplier5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingSupplier5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jPanelSupplier5.add(jLabelSettingSupplier5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 70, 80));

        jDashboardQLNCC.add(jPanelSupplier5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 1330, 80));

        jPanelSupplier4.setBackground(new java.awt.Color(215, 220, 222));
        jPanelSupplier4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier4.setForeground(new java.awt.Color(255, 255, 255));
        jPanelSupplier4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBoxSupplier3.setBackground(new java.awt.Color(215, 220, 222));
        jCheckBoxSupplier3.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxSupplier3.setBorder(null);
        jPanelSupplier4.add(jCheckBoxSupplier3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 20, 60));

        jLabelIdSupplier4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdSupplier4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelIdSupplier4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIdSupplier4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdSupplier4.setText("Mã nhà cung cấp");
        jLabelIdSupplier4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier4.add(jLabelIdSupplier4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelNameSupplier4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameSupplier4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameSupplier4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameSupplier4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameSupplier4.setText("Tên nhà cung cấp");
        jPanelSupplier4.add(jLabelNameSupplier4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 180, 80));

        jLabelLogoSupplier4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogoSupplier4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelLogoSupplier4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelLogoSupplier4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogoSupplier4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier4.add(jLabelLogoSupplier4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 80, 80));

        jLabelNameTrading4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameTrading4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameTrading4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameTrading4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameTrading4.setText("Tên giao dịch");
        jPanelSupplier4.add(jLabelNameTrading4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 210, 80));

        jLabelAddressSupplier4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressSupplier4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAddressSupplier4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddressSupplier4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddressSupplier4.setText("Địa chỉ");
        jLabelAddressSupplier4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier4.add(jLabelAddressSupplier4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 220, 80));

        jLabelEmailSupplier4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailSupplier4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmailSupplier4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailSupplier4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmailSupplier4.setText("Email");
        jPanelSupplier4.add(jLabelEmailSupplier4, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 240, 80));

        jLabelPhonenumberSupplier4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPhonenumberSupplier4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPhonenumberSupplier4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPhonenumberSupplier4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPhonenumberSupplier4.setText("Số điện thoại");
        jLabelPhonenumberSupplier4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier4.add(jLabelPhonenumberSupplier4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 140, 80));

        jLabelSettingSupplier4.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingSupplier4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingSupplier4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSettingSupplier4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingSupplier4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jPanelSupplier4.add(jLabelSettingSupplier4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 70, 80));

        jDashboardQLNCC.add(jPanelSupplier4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 1330, 80));

        jPanelSupplier3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSupplier3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier3.setForeground(new java.awt.Color(255, 255, 255));
        jPanelSupplier3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBoxSupplier2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxSupplier2.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxSupplier2.setBorder(null);
        jPanelSupplier3.add(jCheckBoxSupplier2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 20, 60));

        jLabelIdSupplier3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdSupplier3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelIdSupplier3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIdSupplier3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdSupplier3.setText("Mã nhà cung cấp");
        jLabelIdSupplier3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier3.add(jLabelIdSupplier3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelNameSupplier3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameSupplier3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameSupplier3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameSupplier3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameSupplier3.setText("Tên nhà cung cấp");
        jPanelSupplier3.add(jLabelNameSupplier3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 180, 80));

        jLabelLogoSupplier3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogoSupplier3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelLogoSupplier3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelLogoSupplier3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogoSupplier3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier3.add(jLabelLogoSupplier3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 80, 80));

        jLabelNameTrading3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameTrading3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameTrading3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameTrading3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameTrading3.setText("Tên giao dịch");
        jPanelSupplier3.add(jLabelNameTrading3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 210, 80));

        jLabelAddressSupplier3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressSupplier3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAddressSupplier3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddressSupplier3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddressSupplier3.setText("Địa chỉ");
        jLabelAddressSupplier3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier3.add(jLabelAddressSupplier3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 220, 80));

        jLabelEmailSupplier3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailSupplier3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmailSupplier3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailSupplier3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmailSupplier3.setText("Email");
        jPanelSupplier3.add(jLabelEmailSupplier3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 240, 80));

        jLabelPhonenumberSupplier3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPhonenumberSupplier3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPhonenumberSupplier3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPhonenumberSupplier3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPhonenumberSupplier3.setText("Số điện thoại");
        jLabelPhonenumberSupplier3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier3.add(jLabelPhonenumberSupplier3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 140, 80));

        jLabelSettingSupplier3.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingSupplier3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingSupplier3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSettingSupplier3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingSupplier3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jPanelSupplier3.add(jLabelSettingSupplier3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 70, 80));

        jDashboardQLNCC.add(jPanelSupplier3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 1330, 80));

        jPanelSupplier2.setBackground(new java.awt.Color(215, 220, 222));
        jPanelSupplier2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier2.setForeground(new java.awt.Color(255, 255, 255));
        jPanelSupplier2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBoxSupplier1.setBackground(new java.awt.Color(215, 220, 222));
        jCheckBoxSupplier1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxSupplier1.setBorder(null);
        jPanelSupplier2.add(jCheckBoxSupplier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 20, 60));

        jLabelIdSupplier2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdSupplier2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelIdSupplier2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIdSupplier2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdSupplier2.setText("Mã nhà cung cấp");
        jLabelIdSupplier2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier2.add(jLabelIdSupplier2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelNameSupplier2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameSupplier2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameSupplier2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameSupplier2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameSupplier2.setText("Tên nhà cung cấp");
        jPanelSupplier2.add(jLabelNameSupplier2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 180, 80));

        jLabelLogoSupplier2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogoSupplier2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelLogoSupplier2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelLogoSupplier2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogoSupplier2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier2.add(jLabelLogoSupplier2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 80, 80));

        jLabelNameTrading2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameTrading2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameTrading2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameTrading2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameTrading2.setText("Tên giao dịch");
        jPanelSupplier2.add(jLabelNameTrading2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 210, 80));

        jLabelAddressSupplier2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressSupplier2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAddressSupplier2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddressSupplier2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddressSupplier2.setText("Địa chỉ");
        jLabelAddressSupplier2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier2.add(jLabelAddressSupplier2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 220, 80));

        jLabelEmailSupplier2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailSupplier2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmailSupplier2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailSupplier2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmailSupplier2.setText("Email");
        jPanelSupplier2.add(jLabelEmailSupplier2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 240, 80));

        jLabelPhonenumberSupplier2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPhonenumberSupplier2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPhonenumberSupplier2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPhonenumberSupplier2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPhonenumberSupplier2.setText("Số điện thoại");
        jLabelPhonenumberSupplier2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier2.add(jLabelPhonenumberSupplier2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 140, 80));

        jLabelSettingSupplier2.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingSupplier2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingSupplier2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSettingSupplier2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingSupplier2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jPanelSupplier2.add(jLabelSettingSupplier2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 70, 80));

        jDashboardQLNCC.add(jPanelSupplier2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 1330, 80));

        jPanelSupplier1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSupplier1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelSupplier1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBoxSupplier.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxSupplier.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxSupplier.setBorder(null);
        jPanelSupplier1.add(jCheckBoxSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 20, 60));

        jLabelIdSupplier1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdSupplier1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelIdSupplier1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIdSupplier1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdSupplier1.setText("Mã nhà cung cấp");
        jLabelIdSupplier1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier1.add(jLabelIdSupplier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelNameSupplier1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameSupplier1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameSupplier1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameSupplier1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameSupplier1.setText("Tên nhà cung cấp");
        jPanelSupplier1.add(jLabelNameSupplier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 180, 80));

        jLabelLogoSupplier1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogoSupplier1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelLogoSupplier1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelLogoSupplier1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogoSupplier1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier1.add(jLabelLogoSupplier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 80, 80));

        jLabelNameTrading1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameTrading1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameTrading1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameTrading1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameTrading1.setText("Tên giao dịch");
        jPanelSupplier1.add(jLabelNameTrading1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 210, 80));

        jLabelAddressSupplier1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressSupplier1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAddressSupplier1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddressSupplier1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddressSupplier1.setText("Địa chỉ");
        jLabelAddressSupplier1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier1.add(jLabelAddressSupplier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 220, 80));

        jLabelEmailSupplier1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailSupplier1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmailSupplier1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailSupplier1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmailSupplier1.setText("Email");
        jPanelSupplier1.add(jLabelEmailSupplier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 240, 80));

        jLabelPhonenumberSupplier1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPhonenumberSupplier1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPhonenumberSupplier1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPhonenumberSupplier1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPhonenumberSupplier1.setText("Số điện thoại");
        jLabelPhonenumberSupplier1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier1.add(jLabelPhonenumberSupplier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 140, 80));

        jLabelSettingSupplier1.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingSupplier1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingSupplier1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSettingSupplier1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingSupplier1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jPanelSupplier1.add(jLabelSettingSupplier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 70, 80));

        jDashboardQLNCC.add(jPanelSupplier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1330, 80));

        jPanelHeaderSupplier.setBackground(new java.awt.Color(102, 178, 255));
        jPanelHeaderSupplier.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeaderSupplier.setForeground(new java.awt.Color(255, 255, 255));
        jPanelHeaderSupplier.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBoxAll1.setBackground(new java.awt.Color(102, 178, 255));
        jCheckBoxAll1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxAll1.setBorder(null);
        jPanelHeaderSupplier.add(jCheckBoxAll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 20, 20));

        jLabelMaSP1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMaSP1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelMaSP1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMaSP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMaSP1.setText("Mã nhà cung cấp");
        jLabelMaSP1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeaderSupplier.add(jLabelMaSP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 40));

        jLabelImage8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelImage8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelImage8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage8.setText("Tên nhà cung cấp");
        jPanelHeaderSupplier.add(jLabelImage8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 180, 40));

        jLabelName8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelName8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelName8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName8.setText("Logo");
        jLabelName8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeaderSupplier.add(jLabelName8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 80, 40));

        jLabelType8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelType8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelType8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelType8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelType8.setText("Tên giao dịch");
        jPanelHeaderSupplier.add(jLabelType8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 210, 40));

        jLabelCompany8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCompany8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelCompany8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCompany8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCompany8.setText("Địa chỉ");
        jLabelCompany8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeaderSupplier.add(jLabelCompany8, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 220, 40));

        jLabelPriceImport1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPriceImport1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPriceImport1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPriceImport1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPriceImport1.setText("Email");
        jPanelHeaderSupplier.add(jLabelPriceImport1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 240, 40));

        jLabelPrice8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPrice8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPrice8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPrice8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPrice8.setText("Số điện thoại");
        jLabelPrice8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeaderSupplier.add(jLabelPrice8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 140, 40));

        jLabelSettings1.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettings1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettings1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSettings1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettings1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jPanelHeaderSupplier.add(jLabelSettings1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 70, 40));

        jDashboardQLNCC.add(jPanelHeaderSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, -1));

        jPanelControlPageSupplier.setBackground(new java.awt.Color(255, 255, 255));

        jTextFieldPageSupplier.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPageSupplier.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldPageSupplier.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldPageSupplier.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldPageSupplier.setText("1");
        jTextFieldPageSupplier.setBorder(null);
        jTextFieldPageSupplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPageSupplierKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPageSupplierKeyReleased(evt);
            }
        });

        jLabelPageSupplier.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPageSupplier.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPageSupplier.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPageSupplier.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPageSupplier.setText("/4");

        jLabelRightSupplier.setBackground(new java.awt.Color(255, 255, 255));
        jLabelRightSupplier.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRightSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRightSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px.png"))); // NOI18N
        jLabelRightSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRightSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRightSupplierMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelRightSupplierMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelRightSupplierMouseExited(evt);
            }
        });

        jLabelLeftSupplier.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLeftSupplier.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLeftSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLeftSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px_1.png"))); // NOI18N
        jLabelLeftSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelLeftSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLeftSupplierMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelLeftSupplierMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelLeftSupplierMouseExited(evt);
            }
        });

        jLabelSkipToEndSupplier.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSkipToEndSupplier.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSkipToEndSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSkipToEndSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px_1.png"))); // NOI18N
        jLabelSkipToEndSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSkipToEndSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSkipToEndSupplierMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSkipToEndSupplierMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSkipToEndSupplierMouseExited(evt);
            }
        });

        jLabelSkipToStartSupplier.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSkipToStartSupplier.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSkipToStartSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSkipToStartSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px_1.png"))); // NOI18N
        jLabelSkipToStartSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSkipToStartSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSkipToStartSupplierMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSkipToStartSupplierMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSkipToStartSupplierMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelControlPageSupplierLayout = new javax.swing.GroupLayout(jPanelControlPageSupplier);
        jPanelControlPageSupplier.setLayout(jPanelControlPageSupplierLayout);
        jPanelControlPageSupplierLayout.setHorizontalGroup(
            jPanelControlPageSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControlPageSupplierLayout.createSequentialGroup()
                .addGap(586, 586, 586)
                .addComponent(jLabelSkipToStartSupplier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLeftSupplier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPageSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPageSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelRightSupplier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSkipToEndSupplier)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelControlPageSupplierLayout.setVerticalGroup(
            jPanelControlPageSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelControlPageSupplierLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanelControlPageSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelSkipToStartSupplier)
                    .addComponent(jLabelSkipToEndSupplier)
                    .addComponent(jLabelLeftSupplier)
                    .addComponent(jLabelRightSupplier)
                    .addGroup(jPanelControlPageSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldPageSupplier)
                        .addComponent(jLabelPageSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jDashboardQLNCC.add(jPanelControlPageSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 820, 1330, -1));

        jTextFieldSearchSupplier.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldSearchSupplier.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldSearchSupplier.setForeground(new java.awt.Color(120, 120, 120));
        jTextFieldSearchSupplier.setText("Tìm kiếm");
        jTextFieldSearchSupplier.setBorder(null);
        jTextFieldSearchSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldSearchSupplier.setOpaque(false);
        jTextFieldSearchSupplier.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldSearchSupplierFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldSearchSupplierFocusLost(evt);
            }
        });
        jTextFieldSearchSupplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchSupplierKeyReleased(evt);
            }
        });
        jDashboardQLNCC.add(jTextFieldSearchSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 90, 240, 30));

        jLabelSearchSupplier.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSearchSupplier.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelSearchSupplier.setForeground(new java.awt.Color(120, 120, 120));
        jLabelSearchSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_search_20px_1.png"))); // NOI18N
        jLabelSearchSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jDashboardQLNCC.add(jLabelSearchSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 90, 30, 30));

        jLabelFrameSearchSupplier.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameSearchSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDashboardQLNCC.add(jLabelFrameSearchSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 90, 280, 30));

        add(jDashboardQLNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPageSupplierKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPageSupplierKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPageSupplierKeyPressed

    private void jTextFieldPageSupplierKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPageSupplierKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPageSupplierKeyReleased

    private void jLabelRightSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightSupplierMouseClicked
        int jlabelrighta = Integer.parseInt(jTextFieldPageSupplier.getText());
        int jlabelrightb = countSupplier / 8 + setPageSupplier;
        if (jlabelrighta < jlabelrightb) {
            jTextFieldPageSupplier.setText(String.valueOf(Integer.parseInt(jTextFieldPageSupplier.getText()) + 1));

            try {
                showSupplierList(ListSuppliers, countSupplier);
            } catch (SQLException ex) {
                Logger.getLogger(PanelSupplier.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jLabelRightSupplierMouseClicked

    private void jLabelRightSupplierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightSupplierMouseEntered
        jLabelRightSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px_1.png")));
    }//GEN-LAST:event_jLabelRightSupplierMouseEntered

    private void jLabelRightSupplierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightSupplierMouseExited
        jLabelRightSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px.png")));
    }//GEN-LAST:event_jLabelRightSupplierMouseExited

    private void jLabelLeftSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftSupplierMouseClicked
        if (Integer.parseInt(jTextFieldPageSupplier.getText()) > 1) {
            jTextFieldPageSupplier.setText(String.valueOf(Integer.parseInt(jTextFieldPageSupplier.getText()) - 1));
            try {
                showSupplierList(ListSuppliers, countSupplier);
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelLeftSupplierMouseClicked

    private void jLabelLeftSupplierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftSupplierMouseEntered
        jLabelLeftSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px.png")));
    }//GEN-LAST:event_jLabelLeftSupplierMouseEntered

    private void jLabelLeftSupplierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftSupplierMouseExited
        jLabelLeftSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px_1.png")));
    }//GEN-LAST:event_jLabelLeftSupplierMouseExited

    private void jLabelSkipToEndSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndSupplierMouseClicked
        int jlabelrighta = Integer.parseInt(jTextFieldPageSupplier.getText());
        int jlabelrightb = countSupplier / 8 + setPageSupplier;
        if (jlabelrighta < jlabelrightb) {
            jTextFieldPageSupplier.setText(String.valueOf(countSupplier / 8 + setPageSupplier));
            try {
                showSupplierList(ListSuppliers, countSupplier);
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelSkipToEndSupplierMouseClicked

    private void jLabelSkipToEndSupplierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndSupplierMouseEntered
        jLabelSkipToEndSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px.png")));
    }//GEN-LAST:event_jLabelSkipToEndSupplierMouseEntered

    private void jLabelSkipToEndSupplierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndSupplierMouseExited
        jLabelSkipToEndSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px_1.png")));
    }//GEN-LAST:event_jLabelSkipToEndSupplierMouseExited

    private void jLabelSkipToStartSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartSupplierMouseClicked
        if (Integer.parseInt(jTextFieldPageSupplier.getText()) > 1) {
            jTextFieldPageSupplier.setText("1");
            try {
                showSupplierList(ListSuppliers, countSupplier);
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelSkipToStartSupplierMouseClicked

    private void jLabelSkipToStartSupplierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartSupplierMouseEntered
        jLabelSkipToStartSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px.png")));
    }//GEN-LAST:event_jLabelSkipToStartSupplierMouseEntered

    private void jLabelSkipToStartSupplierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartSupplierMouseExited
        jLabelSkipToStartSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px_1.png")));
    }//GEN-LAST:event_jLabelSkipToStartSupplierMouseExited

    private void jTextFieldSearchSupplierFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchSupplierFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchSupplierFocusGained

    private void jTextFieldSearchSupplierFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchSupplierFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchSupplierFocusLost

    private void jTextFieldSearchSupplierKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchSupplierKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchSupplierKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBoxAll1;
    private javax.swing.JCheckBox jCheckBoxSupplier;
    private javax.swing.JCheckBox jCheckBoxSupplier1;
    private javax.swing.JCheckBox jCheckBoxSupplier2;
    private javax.swing.JCheckBox jCheckBoxSupplier3;
    private javax.swing.JCheckBox jCheckBoxSupplier4;
    private javax.swing.JCheckBox jCheckBoxSupplier5;
    private javax.swing.JCheckBox jCheckBoxSupplier6;
    private javax.swing.JCheckBox jCheckBoxSupplier7;
    private javax.swing.JPanel jDashboardQLNCC;
    private javax.swing.JLabel jLabelAddressSupplier1;
    private javax.swing.JLabel jLabelAddressSupplier2;
    private javax.swing.JLabel jLabelAddressSupplier3;
    private javax.swing.JLabel jLabelAddressSupplier4;
    private javax.swing.JLabel jLabelAddressSupplier5;
    private javax.swing.JLabel jLabelAddressSupplier6;
    private javax.swing.JLabel jLabelAddressSupplier7;
    private javax.swing.JLabel jLabelAddressSupplier8;
    private javax.swing.JLabel jLabelCompany8;
    private javax.swing.JLabel jLabelEmailSupplier1;
    private javax.swing.JLabel jLabelEmailSupplier2;
    private javax.swing.JLabel jLabelEmailSupplier3;
    private javax.swing.JLabel jLabelEmailSupplier4;
    private javax.swing.JLabel jLabelEmailSupplier5;
    private javax.swing.JLabel jLabelEmailSupplier6;
    private javax.swing.JLabel jLabelEmailSupplier7;
    private javax.swing.JLabel jLabelEmailSupplier8;
    private javax.swing.JLabel jLabelFrameSearchSupplier;
    private javax.swing.JLabel jLabelIdSupplier1;
    private javax.swing.JLabel jLabelIdSupplier2;
    private javax.swing.JLabel jLabelIdSupplier3;
    private javax.swing.JLabel jLabelIdSupplier4;
    private javax.swing.JLabel jLabelIdSupplier5;
    private javax.swing.JLabel jLabelIdSupplier6;
    private javax.swing.JLabel jLabelIdSupplier7;
    private javax.swing.JLabel jLabelIdSupplier8;
    private javax.swing.JLabel jLabelImage8;
    private javax.swing.JLabel jLabelLeftSupplier;
    private javax.swing.JLabel jLabelLogoSupplier1;
    private javax.swing.JLabel jLabelLogoSupplier2;
    private javax.swing.JLabel jLabelLogoSupplier3;
    private javax.swing.JLabel jLabelLogoSupplier4;
    private javax.swing.JLabel jLabelLogoSupplier5;
    private javax.swing.JLabel jLabelLogoSupplier6;
    private javax.swing.JLabel jLabelLogoSupplier7;
    private javax.swing.JLabel jLabelLogoSupplier8;
    private javax.swing.JLabel jLabelMaSP1;
    private javax.swing.JLabel jLabelName8;
    private javax.swing.JLabel jLabelNameSupplier1;
    private javax.swing.JLabel jLabelNameSupplier2;
    private javax.swing.JLabel jLabelNameSupplier3;
    private javax.swing.JLabel jLabelNameSupplier4;
    private javax.swing.JLabel jLabelNameSupplier5;
    private javax.swing.JLabel jLabelNameSupplier6;
    private javax.swing.JLabel jLabelNameSupplier7;
    private javax.swing.JLabel jLabelNameSupplier8;
    private javax.swing.JLabel jLabelNameTrading1;
    private javax.swing.JLabel jLabelNameTrading2;
    private javax.swing.JLabel jLabelNameTrading3;
    private javax.swing.JLabel jLabelNameTrading4;
    private javax.swing.JLabel jLabelNameTrading5;
    private javax.swing.JLabel jLabelNameTrading6;
    private javax.swing.JLabel jLabelNameTrading7;
    private javax.swing.JLabel jLabelNameTrading8;
    private javax.swing.JLabel jLabelPageSupplier;
    private javax.swing.JLabel jLabelPhonenumberSupplier1;
    private javax.swing.JLabel jLabelPhonenumberSupplier2;
    private javax.swing.JLabel jLabelPhonenumberSupplier3;
    private javax.swing.JLabel jLabelPhonenumberSupplier4;
    private javax.swing.JLabel jLabelPhonenumberSupplier5;
    private javax.swing.JLabel jLabelPhonenumberSupplier6;
    private javax.swing.JLabel jLabelPhonenumberSupplier7;
    private javax.swing.JLabel jLabelPhonenumberSupplier8;
    private javax.swing.JLabel jLabelPrice8;
    private javax.swing.JLabel jLabelPriceImport1;
    private javax.swing.JLabel jLabelRightSupplier;
    private javax.swing.JLabel jLabelSearchSupplier;
    private javax.swing.JLabel jLabelSettingSupplier1;
    private javax.swing.JLabel jLabelSettingSupplier2;
    private javax.swing.JLabel jLabelSettingSupplier3;
    private javax.swing.JLabel jLabelSettingSupplier4;
    private javax.swing.JLabel jLabelSettingSupplier5;
    private javax.swing.JLabel jLabelSettingSupplier6;
    private javax.swing.JLabel jLabelSettingSupplier7;
    private javax.swing.JLabel jLabelSettingSupplier8;
    private javax.swing.JLabel jLabelSettings1;
    private javax.swing.JLabel jLabelSkipToEndSupplier;
    private javax.swing.JLabel jLabelSkipToStartSupplier;
    private javax.swing.JLabel jLabelType8;
    private javax.swing.JPanel jPanelControlPageSupplier;
    private javax.swing.JPanel jPanelHeaderSupplier;
    private javax.swing.JPanel jPanelSupplier1;
    private javax.swing.JPanel jPanelSupplier2;
    private javax.swing.JPanel jPanelSupplier3;
    private javax.swing.JPanel jPanelSupplier4;
    private javax.swing.JPanel jPanelSupplier5;
    private javax.swing.JPanel jPanelSupplier6;
    private javax.swing.JPanel jPanelSupplier7;
    private javax.swing.JPanel jPanelSupplier8;
    private javax.swing.JTextField jTextFieldPageSupplier;
    private javax.swing.JTextField jTextFieldSearchSupplier;
    // End of variables declaration//GEN-END:variables
}
