/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.views.admin.warehouse;

import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import qlbhgg.dao.GoodsDao;
import qlbhgg.dao.TypeOfGoodDao;
import qlbhgg.models.Goods;
import qlbhgg.views.admin.AdminForm;
import qlbhgg.views.common.DisplayImage;

/**
 *
 * @author acer
 */
public class PanelWarehouse extends javax.swing.JPanel {

    /**
     * Creates new form PanelWarehouse
     */
    
    public ArrayList<Goods> ListGoods = GoodsDao.findAll();
    public int countProduct = GoodsDao.countProduct();
    public int setPageProduct;
    
    public PanelWarehouse() throws SQLException{
        initComponents();
        
        
        TypeOfGoodDao.setComboboxType(jComboBoxType);
        showProducts(ListGoods, countProduct);
        
    }
    
    public void startingStateQLK() {
        jPanelGood1.setVisible(false);
        jPanelGood2.setVisible(false);
        jPanelGood3.setVisible(false);
        jPanelGood4.setVisible(false);
        jPanelGood5.setVisible(false);
        jPanelGood6.setVisible(false);
        jPanelGood7.setVisible(false);
    }
    
    private void showProducts(ArrayList<Goods> ListGoods, int countProduct) throws SQLException {
        startingStateQLK();
        setPageProduct = (countProduct % 7 == 0) ? 0 : 1;
        jLabelPageProduct.setText("/" + String.valueOf(countProduct / 7 + setPageProduct));
        int pageProduct = (Integer.parseInt(jTextFieldPageProduct.getText()) - 1) * 7;
        if (pageProduct < countProduct) {
            renderJPanelGood(ListGoods.get(pageProduct), jPanelGood1, jLabelMSP1, jLabelImage1, jLabelName1, jLabelType1, jLabelCompany1, jLabelImportPrice1, jLabelPrice1, jLabelAmount1, jLabelUnit1);
        } else {
            jPanelGood1.setVisible(false);
        }
        if (pageProduct + 1 < countProduct) {
            renderJPanelGood(ListGoods.get(pageProduct + 1), jPanelGood2, jLabelMSP2, jLabelImage2, jLabelName2, jLabelType2, jLabelCompany2, jLabelImportPrice2, jLabelPrice2, jLabelAmount2, jLabelUnit2);
        } else {
            jPanelGood2.setVisible(false);
        }
        if (pageProduct + 2 < countProduct) {
            renderJPanelGood(ListGoods.get(pageProduct + 2), jPanelGood3, jLabelMSP3, jLabelImage3, jLabelName3, jLabelType3, jLabelCompany3, jLabelImportPrice3, jLabelPrice3, jLabelAmount3, jLabelUnit3);
        } else {
            jPanelGood3.setVisible(false);
        }
        if (pageProduct + 3 < countProduct) {
            renderJPanelGood(ListGoods.get(pageProduct + 3), jPanelGood4, jLabelMSP4, jLabelImage4, jLabelName4, jLabelType4, jLabelCompany4, jLabelImportPrice4, jLabelPrice4, jLabelAmount4, jLabelUnit4);
        } else {
            jPanelGood4.setVisible(false);
        }
        if (pageProduct + 4 < countProduct) {
            renderJPanelGood(ListGoods.get(pageProduct + 4), jPanelGood5, jLabelMSP5, jLabelImage5, jLabelName5, jLabelType5, jLabelCompany5, jLabelImportPrice5, jLabelPrice5, jLabelAmount5, jLabelUnit5);
        } else {
            jPanelGood5.setVisible(false);
        }
        if (pageProduct + 5 < countProduct) {
            renderJPanelGood(ListGoods.get(pageProduct + 5), jPanelGood6, jLabelMSP6, jLabelImage6, jLabelName6, jLabelType6, jLabelCompany6, jLabelImportPrice6, jLabelPrice6, jLabelAmount6, jLabelUnit6);
        } else {
            jPanelGood6.setVisible(false);
        }
        if (pageProduct + 6 < countProduct) {
            renderJPanelGood(ListGoods.get(pageProduct + 6), jPanelGood7, jLabelMSP7, jLabelImage7, jLabelName7, jLabelType7, jLabelCompany7, jLabelImportPrice7, jLabelPrice7, jLabelAmount7, jLabelUnit7);
        } else {
            jPanelGood7.setVisible(false);
        }
        jLabelFrameSearchProduct.setIcon(scaleFrameSearch("/Image/FrameSearch.png"));
    }
    
    private void renderJPanelGood(Goods g, JPanel jpanel, JLabel jlabelMSP, JLabel jlabelImage, JLabel jlabelName, JLabel jlabelType, JLabel jlabelCompany, JLabel jlabelImportPrice, JLabel jlabelPrice, JLabel jlabelAmount, JLabel jlabelUnit) {
        jpanel.setVisible(true);
        jpanel.setEnabled(true);
        jlabelMSP.setText(g.getItemcode());
        jlabelImage.setIcon(scaleImageProduct(g.getImageitem()));
        String productName = "<html>" + g.getItemname() + "</html>";
        jlabelName.setText(productName);
        jlabelType.setText("<html>" + g.getTypecode() + "</html>");
        jlabelCompany.setText(g.getCompanycode());
        jlabelImportPrice.setText(String.format("%1$,.0f", g.getImportprice()));
        jlabelPrice.setText(String.format("%1$,.0f", g.getPrice()));
        jlabelAmount.setText(Integer.toString(g.getAmount()));
        jlabelUnit.setText(g.getUnit());
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
    public void popUpImageProduct(int n) {
        setPageProduct = (countProduct % 7 == 0) ? 0 : 1;
        jLabelPageProduct.setText("/" + String.valueOf(countProduct / 7 + setPageProduct));
        int pageProduct = (Integer.parseInt(jTextFieldPageProduct.getText()) - 1) * 7;
        Goods g = ListGoods.get(pageProduct + n);
        DisplayImage di = new DisplayImage(g.getItemname(), g.getImageitem());
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

        jDashboardQLK = new javax.swing.JPanel();
        jButtonAddCustomer = new javax.swing.JButton();
        jButtonEditCustomer = new javax.swing.JButton();
        jButtonDeleteCustomer = new javax.swing.JButton();
        jPanelSelectPage = new javax.swing.JPanel();
        jPanelControlPageProduct = new javax.swing.JPanel();
        jTextFieldPageProduct = new javax.swing.JTextField();
        jLabelPageProduct = new javax.swing.JLabel();
        jLabelRight = new javax.swing.JLabel();
        jLabelLeft = new javax.swing.JLabel();
        jLabelSkipToEnd = new javax.swing.JLabel();
        jLabelSkipToStart = new javax.swing.JLabel();
        jPanelGood6 = new javax.swing.JPanel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabelMSP6 = new javax.swing.JLabel();
        jLabelImage6 = new javax.swing.JLabel();
        jLabelName6 = new javax.swing.JLabel();
        jLabelType6 = new javax.swing.JLabel();
        jLabelCompany6 = new javax.swing.JLabel();
        jLabelImportPrice6 = new javax.swing.JLabel();
        jLabelPrice6 = new javax.swing.JLabel();
        jLabelAmount6 = new javax.swing.JLabel();
        jLabelUnit6 = new javax.swing.JLabel();
        jLabelSetting6 = new javax.swing.JLabel();
        jPanelGood1 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabelMSP1 = new javax.swing.JLabel();
        jLabelImage1 = new javax.swing.JLabel();
        jLabelName1 = new javax.swing.JLabel();
        jLabelType1 = new javax.swing.JLabel();
        jLabelCompany1 = new javax.swing.JLabel();
        jLabelImportPrice1 = new javax.swing.JLabel();
        jLabelPrice1 = new javax.swing.JLabel();
        jLabelAmount1 = new javax.swing.JLabel();
        jLabelUnit1 = new javax.swing.JLabel();
        jLabelSetting1 = new javax.swing.JLabel();
        jPanelHeader = new javax.swing.JPanel();
        jCheckBoxAll = new javax.swing.JCheckBox();
        jLabelMaSP = new javax.swing.JLabel();
        jLabelImage = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabelType = new javax.swing.JLabel();
        jLabelCompany = new javax.swing.JLabel();
        jLabelPriceImport = new javax.swing.JLabel();
        jLabelPrice = new javax.swing.JLabel();
        jLabelAmount = new javax.swing.JLabel();
        jLabelUnit = new javax.swing.JLabel();
        jLabelSettings = new javax.swing.JLabel();
        jPanelGood5 = new javax.swing.JPanel();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabelMSP5 = new javax.swing.JLabel();
        jLabelImage5 = new javax.swing.JLabel();
        jLabelName5 = new javax.swing.JLabel();
        jLabelType5 = new javax.swing.JLabel();
        jLabelCompany5 = new javax.swing.JLabel();
        jLabelImportPrice5 = new javax.swing.JLabel();
        jLabelPrice5 = new javax.swing.JLabel();
        jLabelAmount5 = new javax.swing.JLabel();
        jLabelUnit5 = new javax.swing.JLabel();
        jLabelSetting5 = new javax.swing.JLabel();
        jPanelGood2 = new javax.swing.JPanel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabelMSP2 = new javax.swing.JLabel();
        jLabelImage2 = new javax.swing.JLabel();
        jLabelName2 = new javax.swing.JLabel();
        jLabelType2 = new javax.swing.JLabel();
        jLabelCompany2 = new javax.swing.JLabel();
        jLabelImportPrice2 = new javax.swing.JLabel();
        jLabelPrice2 = new javax.swing.JLabel();
        jLabelAmount2 = new javax.swing.JLabel();
        jLabelUnit2 = new javax.swing.JLabel();
        jLabelSetting2 = new javax.swing.JLabel();
        jPanelGood3 = new javax.swing.JPanel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabelMSP3 = new javax.swing.JLabel();
        jLabelImage3 = new javax.swing.JLabel();
        jLabelName3 = new javax.swing.JLabel();
        jLabelType3 = new javax.swing.JLabel();
        jLabelCompany3 = new javax.swing.JLabel();
        jLabelImportPrice3 = new javax.swing.JLabel();
        jLabelPrice3 = new javax.swing.JLabel();
        jLabelAmount3 = new javax.swing.JLabel();
        jLabelUnit3 = new javax.swing.JLabel();
        jLabelSetting3 = new javax.swing.JLabel();
        jPanelGood7 = new javax.swing.JPanel();
        jCheckBox7 = new javax.swing.JCheckBox();
        jLabelMSP7 = new javax.swing.JLabel();
        jLabelImage7 = new javax.swing.JLabel();
        jLabelName7 = new javax.swing.JLabel();
        jLabelType7 = new javax.swing.JLabel();
        jLabelCompany7 = new javax.swing.JLabel();
        jLabelImportPrice7 = new javax.swing.JLabel();
        jLabelPrice7 = new javax.swing.JLabel();
        jLabelAmount7 = new javax.swing.JLabel();
        jLabelUnit7 = new javax.swing.JLabel();
        jLabelSetting7 = new javax.swing.JLabel();
        jPanelGood4 = new javax.swing.JPanel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabelMSP4 = new javax.swing.JLabel();
        jLabelImage4 = new javax.swing.JLabel();
        jLabelName4 = new javax.swing.JLabel();
        jLabelType4 = new javax.swing.JLabel();
        jLabelCompany4 = new javax.swing.JLabel();
        jLabelImportPrice4 = new javax.swing.JLabel();
        jLabelPrice4 = new javax.swing.JLabel();
        jLabelAmount4 = new javax.swing.JLabel();
        jLabelUnit4 = new javax.swing.JLabel();
        jLabelSetting4 = new javax.swing.JLabel();
        jPanelControlQLK = new javax.swing.JPanel();
        jComboBoxType = new javax.swing.JComboBox<>();
        jTextFieldSearchProduct = new javax.swing.JTextField();
        jLabelSearchProduct = new javax.swing.JLabel();
        jLabelFrameSearchProduct = new javax.swing.JLabel();

        jDashboardQLK.setBackground(new java.awt.Color(255, 255, 255));
        jDashboardQLK.setForeground(new java.awt.Color(255, 255, 255));
        jDashboardQLK.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAddCustomer.setBackground(new java.awt.Color(102, 178, 255));
        jButtonAddCustomer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAddCustomer.setForeground(new java.awt.Color(0, 0, 0));
        jButtonAddCustomer.setText("Thêm");
        jDashboardQLK.add(jButtonAddCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, -1, -1));

        jButtonEditCustomer.setBackground(new java.awt.Color(102, 178, 255));
        jButtonEditCustomer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonEditCustomer.setForeground(new java.awt.Color(0, 0, 0));
        jButtonEditCustomer.setText("Sửa");
        jDashboardQLK.add(jButtonEditCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, -1, -1));

        jButtonDeleteCustomer.setBackground(new java.awt.Color(102, 178, 255));
        jButtonDeleteCustomer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonDeleteCustomer.setForeground(new java.awt.Color(0, 0, 0));
        jButtonDeleteCustomer.setText("Xóa");
        jDashboardQLK.add(jButtonDeleteCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 50, -1, -1));

        jPanelSelectPage.setBackground(new java.awt.Color(255, 255, 255));

        jPanelControlPageProduct.setBackground(new java.awt.Color(255, 255, 255));

        jTextFieldPageProduct.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPageProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldPageProduct.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldPageProduct.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldPageProduct.setText("1");
        jTextFieldPageProduct.setBorder(null);
        jTextFieldPageProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPageProductKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPageProductKeyReleased(evt);
            }
        });

        jLabelPageProduct.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPageProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPageProduct.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPageProduct.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPageProduct.setText("/4");

        jLabelRight.setBackground(new java.awt.Color(255, 255, 255));
        jLabelRight.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px.png"))); // NOI18N
        jLabelRight.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRightMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelRightMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelRightMouseExited(evt);
            }
        });

        jLabelLeft.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLeft.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLeft.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px_1.png"))); // NOI18N
        jLabelLeft.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelLeft.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLeftMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelLeftMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelLeftMouseExited(evt);
            }
        });

        jLabelSkipToEnd.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSkipToEnd.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSkipToEnd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSkipToEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px_1.png"))); // NOI18N
        jLabelSkipToEnd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSkipToEnd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSkipToEndMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSkipToEndMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSkipToEndMouseExited(evt);
            }
        });

        jLabelSkipToStart.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSkipToStart.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSkipToStart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSkipToStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px_1.png"))); // NOI18N
        jLabelSkipToStart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSkipToStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSkipToStartMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSkipToStartMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSkipToStartMouseExited(evt);
            }
        });

        jPanelGood6.setBackground(new java.awt.Color(215, 220, 222));
        jPanelGood6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood6.setForeground(new java.awt.Color(255, 255, 255));
        jPanelGood6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox6.setBackground(new java.awt.Color(215, 220, 222));
        jCheckBox6.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox6.setBorder(null);
        jPanelGood6.add(jCheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 20, 50));

        jLabelMSP6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMSP6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMSP6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMSP6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMSP6.setText("Mã sản phẩm");
        jLabelMSP6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood6.add(jLabelMSP6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelImage6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelImage6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelImage6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImage6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImage6MouseClicked(evt);
            }
        });
        jPanelGood6.add(jLabelImage6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 80, 80));

        jLabelName6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelName6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelName6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName6.setText("Tên sản phẩm");
        jLabelName6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood6.add(jLabelName6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 170, 80));

        jLabelType6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelType6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelType6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelType6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelType6.setText("Loại");
        jPanelGood6.add(jLabelType6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 110, 80));

        jLabelCompany6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCompany6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCompany6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCompany6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCompany6.setText("Nhà cung cấp");
        jLabelCompany6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood6.add(jLabelCompany6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 210, 80));

        jLabelImportPrice6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImportPrice6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImportPrice6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelImportPrice6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImportPrice6.setText("Giá vốn");
        jPanelGood6.add(jLabelImportPrice6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 150, 80));

        jLabelPrice6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPrice6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPrice6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPrice6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPrice6.setText("Giá bán");
        jLabelPrice6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood6.add(jLabelPrice6, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 150, 80));

        jLabelAmount6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAmount6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAmount6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAmount6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAmount6.setText("Số lượng");
        jPanelGood6.add(jLabelAmount6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 90, 80));

        jLabelUnit6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelUnit6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelUnit6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelUnit6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUnit6.setText("Đơn vị tính");
        jLabelUnit6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood6.add(jLabelUnit6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 100, 80));

        jLabelSetting6.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSetting6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSetting6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSetting6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSetting6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jPanelGood6.add(jLabelSetting6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 80, 80));

        jPanelGood1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelGood1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelGood1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setBorder(null);
        jPanelGood1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 20, 50));

        jLabelMSP1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMSP1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMSP1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMSP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMSP1.setText("Mã sản phẩm");
        jLabelMSP1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood1.add(jLabelMSP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelImage1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelImage1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelImage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImage1MouseClicked(evt);
            }
        });
        jPanelGood1.add(jLabelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 80, 80));

        jLabelName1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelName1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName1.setText("Tên sản phẩm");
        jLabelName1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood1.add(jLabelName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 170, 80));

        jLabelType1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelType1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelType1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelType1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelType1.setText("Loại");
        jPanelGood1.add(jLabelType1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 110, 80));

        jLabelCompany1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCompany1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCompany1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCompany1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCompany1.setText("Nhà cung cấp");
        jLabelCompany1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood1.add(jLabelCompany1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 210, 80));

        jLabelImportPrice1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImportPrice1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImportPrice1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelImportPrice1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImportPrice1.setText("Giá vốn");
        jPanelGood1.add(jLabelImportPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 150, 80));

        jLabelPrice1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPrice1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPrice1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPrice1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPrice1.setText("Giá bán");
        jLabelPrice1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood1.add(jLabelPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 150, 80));

        jLabelAmount1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAmount1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAmount1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAmount1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAmount1.setText("Số lượng");
        jPanelGood1.add(jLabelAmount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 90, 80));

        jLabelUnit1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelUnit1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelUnit1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelUnit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUnit1.setText("Đơn vị tính");
        jLabelUnit1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood1.add(jLabelUnit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 100, 80));

        jLabelSetting1.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSetting1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSetting1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSetting1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSetting1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jPanelGood1.add(jLabelSetting1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 80, 80));

        jPanelHeader.setBackground(new java.awt.Color(102, 178, 255));
        jPanelHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeader.setForeground(new java.awt.Color(255, 255, 255));
        jPanelHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBoxAll.setBackground(new java.awt.Color(102, 178, 255));
        jCheckBoxAll.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxAll.setBorder(null);
        jPanelHeader.add(jCheckBoxAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 20, 20));

        jLabelMaSP.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMaSP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelMaSP.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMaSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMaSP.setText("Mã sản phẩm");
        jLabelMaSP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeader.add(jLabelMaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 40));

        jLabelImage.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelImage.setForeground(new java.awt.Color(0, 0, 0));
        jLabelImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage.setText("Ảnh");
        jPanelHeader.add(jLabelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 80, 40));

        jLabelName.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelName.setForeground(new java.awt.Color(0, 0, 0));
        jLabelName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName.setText("Tên sản phẩm");
        jLabelName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeader.add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 170, 40));

        jLabelType.setBackground(new java.awt.Color(255, 255, 255));
        jLabelType.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelType.setForeground(new java.awt.Color(0, 0, 0));
        jLabelType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelType.setText("Loại");
        jPanelHeader.add(jLabelType, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 110, 40));

        jLabelCompany.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCompany.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelCompany.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCompany.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCompany.setText("Nhà cung cấp");
        jLabelCompany.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeader.add(jLabelCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 210, 40));

        jLabelPriceImport.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPriceImport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPriceImport.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPriceImport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPriceImport.setText("Giá vốn");
        jPanelHeader.add(jLabelPriceImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 150, 40));

        jLabelPrice.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPrice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPrice.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPrice.setText("Giá bán");
        jLabelPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeader.add(jLabelPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 150, 40));

        jLabelAmount.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAmount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAmount.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAmount.setText("Số lượng");
        jPanelHeader.add(jLabelAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 90, 40));

        jLabelUnit.setBackground(new java.awt.Color(255, 255, 255));
        jLabelUnit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelUnit.setForeground(new java.awt.Color(0, 0, 0));
        jLabelUnit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUnit.setText("Đơn vị tính");
        jLabelUnit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeader.add(jLabelUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 100, 40));

        jLabelSettings.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettings.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettings.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSettings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jPanelHeader.add(jLabelSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 80, 40));

        jPanelGood5.setBackground(new java.awt.Color(255, 255, 255));
        jPanelGood5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood5.setForeground(new java.awt.Color(255, 255, 255));
        jPanelGood5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox5.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox5.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox5.setBorder(null);
        jPanelGood5.add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 20, 50));

        jLabelMSP5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMSP5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMSP5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMSP5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMSP5.setText("Mã sản phẩm");
        jLabelMSP5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood5.add(jLabelMSP5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelImage5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelImage5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelImage5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImage5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImage5MouseClicked(evt);
            }
        });
        jPanelGood5.add(jLabelImage5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 80, 80));

        jLabelName5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelName5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelName5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName5.setText("Tên sản phẩm");
        jLabelName5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood5.add(jLabelName5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 170, 80));

        jLabelType5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelType5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelType5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelType5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelType5.setText("Loại");
        jPanelGood5.add(jLabelType5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 110, 80));

        jLabelCompany5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCompany5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCompany5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCompany5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCompany5.setText("Nhà cung cấp");
        jLabelCompany5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood5.add(jLabelCompany5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 210, 80));

        jLabelImportPrice5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImportPrice5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImportPrice5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelImportPrice5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImportPrice5.setText("Giá vốn");
        jPanelGood5.add(jLabelImportPrice5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 150, 80));

        jLabelPrice5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPrice5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPrice5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPrice5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPrice5.setText("Giá bán");
        jLabelPrice5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood5.add(jLabelPrice5, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 150, 80));

        jLabelAmount5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAmount5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAmount5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAmount5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAmount5.setText("Số lượng");
        jPanelGood5.add(jLabelAmount5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 90, 80));

        jLabelUnit5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelUnit5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelUnit5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelUnit5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUnit5.setText("Đơn vị tính");
        jLabelUnit5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood5.add(jLabelUnit5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 100, 80));

        jLabelSetting5.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSetting5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSetting5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSetting5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSetting5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jPanelGood5.add(jLabelSetting5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 80, 80));

        jPanelGood2.setBackground(new java.awt.Color(215, 220, 222));
        jPanelGood2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood2.setForeground(new java.awt.Color(255, 255, 255));
        jPanelGood2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox2.setBackground(new java.awt.Color(215, 220, 222));
        jCheckBox2.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setBorder(null);
        jPanelGood2.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 20, 50));

        jLabelMSP2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMSP2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMSP2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMSP2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMSP2.setText("Mã sản phẩm");
        jLabelMSP2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood2.add(jLabelMSP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelImage2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelImage2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelImage2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImage2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImage2MouseClicked(evt);
            }
        });
        jPanelGood2.add(jLabelImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 80, 80));

        jLabelName2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelName2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName2.setText("Tên sản phẩm");
        jLabelName2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood2.add(jLabelName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 170, 80));

        jLabelType2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelType2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelType2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelType2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelType2.setText("Loại");
        jPanelGood2.add(jLabelType2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 110, 80));

        jLabelCompany2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCompany2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCompany2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCompany2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCompany2.setText("Nhà cung cấp");
        jLabelCompany2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood2.add(jLabelCompany2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 210, 80));

        jLabelImportPrice2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImportPrice2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImportPrice2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelImportPrice2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImportPrice2.setText("Giá vốn");
        jPanelGood2.add(jLabelImportPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 150, 80));

        jLabelPrice2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPrice2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPrice2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPrice2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPrice2.setText("Giá bán");
        jLabelPrice2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood2.add(jLabelPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 150, 80));

        jLabelAmount2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAmount2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAmount2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAmount2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAmount2.setText("Số lượng");
        jPanelGood2.add(jLabelAmount2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 90, 80));

        jLabelUnit2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelUnit2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelUnit2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelUnit2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUnit2.setText("Đơn vị tính");
        jLabelUnit2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood2.add(jLabelUnit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 100, 80));

        jLabelSetting2.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSetting2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSetting2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSetting2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSetting2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jPanelGood2.add(jLabelSetting2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 80, 80));

        jPanelGood3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelGood3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood3.setForeground(new java.awt.Color(255, 255, 255));
        jPanelGood3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setBorder(null);
        jPanelGood3.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 20, 50));

        jLabelMSP3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMSP3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMSP3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMSP3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMSP3.setText("Mã sản phẩm");
        jLabelMSP3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood3.add(jLabelMSP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelImage3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelImage3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelImage3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImage3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImage3MouseClicked(evt);
            }
        });
        jPanelGood3.add(jLabelImage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 80, 80));

        jLabelName3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelName3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelName3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName3.setText("Tên sản phẩm");
        jLabelName3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood3.add(jLabelName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 170, 80));

        jLabelType3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelType3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelType3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelType3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelType3.setText("Loại");
        jPanelGood3.add(jLabelType3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 110, 80));

        jLabelCompany3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCompany3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCompany3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCompany3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCompany3.setText("Nhà cung cấp");
        jLabelCompany3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood3.add(jLabelCompany3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 210, 80));

        jLabelImportPrice3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImportPrice3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImportPrice3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelImportPrice3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImportPrice3.setText("Giá vốn");
        jPanelGood3.add(jLabelImportPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 150, 80));

        jLabelPrice3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPrice3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPrice3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPrice3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPrice3.setText("Giá bán");
        jLabelPrice3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood3.add(jLabelPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 150, 80));

        jLabelAmount3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAmount3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAmount3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAmount3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAmount3.setText("Số lượng");
        jPanelGood3.add(jLabelAmount3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 90, 80));

        jLabelUnit3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelUnit3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelUnit3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelUnit3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUnit3.setText("Đơn vị tính");
        jLabelUnit3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood3.add(jLabelUnit3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 100, 80));

        jLabelSetting3.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSetting3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSetting3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSetting3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSetting3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jPanelGood3.add(jLabelSetting3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 80, 80));

        jPanelGood7.setBackground(new java.awt.Color(255, 255, 255));
        jPanelGood7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood7.setForeground(new java.awt.Color(255, 255, 255));
        jPanelGood7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox7.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox7.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox7.setBorder(null);
        jPanelGood7.add(jCheckBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 20, 50));

        jLabelMSP7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMSP7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMSP7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMSP7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMSP7.setText("Mã sản phẩm");
        jLabelMSP7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood7.add(jLabelMSP7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelImage7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelImage7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelImage7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImage7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImage7MouseClicked(evt);
            }
        });
        jPanelGood7.add(jLabelImage7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 80, 80));

        jLabelName7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelName7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelName7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName7.setText("Tên sản phẩm");
        jLabelName7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood7.add(jLabelName7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 170, 80));

        jLabelType7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelType7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelType7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelType7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelType7.setText("Loại");
        jPanelGood7.add(jLabelType7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 110, 80));

        jLabelCompany7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCompany7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCompany7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCompany7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCompany7.setText("Nhà cung cấp");
        jLabelCompany7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood7.add(jLabelCompany7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 210, 80));

        jLabelImportPrice7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImportPrice7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImportPrice7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelImportPrice7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImportPrice7.setText("Giá vốn");
        jPanelGood7.add(jLabelImportPrice7, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 150, 80));

        jLabelPrice7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPrice7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPrice7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPrice7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPrice7.setText("Giá bán");
        jLabelPrice7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood7.add(jLabelPrice7, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 150, 80));

        jLabelAmount7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAmount7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAmount7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAmount7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAmount7.setText("Số lượng");
        jPanelGood7.add(jLabelAmount7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 90, 80));

        jLabelUnit7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelUnit7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelUnit7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelUnit7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUnit7.setText("Đơn vị tính");
        jLabelUnit7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood7.add(jLabelUnit7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 100, 80));

        jLabelSetting7.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSetting7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSetting7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSetting7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSetting7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jPanelGood7.add(jLabelSetting7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 80, 80));

        jPanelGood4.setBackground(new java.awt.Color(215, 220, 222));
        jPanelGood4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood4.setForeground(new java.awt.Color(255, 255, 255));
        jPanelGood4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox4.setBackground(new java.awt.Color(215, 220, 222));
        jCheckBox4.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setBorder(null);
        jPanelGood4.add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 20, 50));

        jLabelMSP4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMSP4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMSP4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMSP4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMSP4.setText("Mã sản phẩm");
        jLabelMSP4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood4.add(jLabelMSP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelImage4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelImage4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelImage4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImage4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImage4MouseClicked(evt);
            }
        });
        jPanelGood4.add(jLabelImage4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 80, 80));

        jLabelName4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelName4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelName4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName4.setText("Tên sản phẩm");
        jLabelName4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood4.add(jLabelName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 170, 80));

        jLabelType4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelType4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelType4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelType4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelType4.setText("Loại");
        jPanelGood4.add(jLabelType4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 110, 80));

        jLabelCompany4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCompany4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCompany4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCompany4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCompany4.setText("Nhà cung cấp");
        jLabelCompany4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood4.add(jLabelCompany4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 210, 80));

        jLabelImportPrice4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImportPrice4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImportPrice4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelImportPrice4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImportPrice4.setText("Giá vốn");
        jPanelGood4.add(jLabelImportPrice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 150, 80));

        jLabelPrice4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPrice4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPrice4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPrice4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPrice4.setText("Giá bán");
        jLabelPrice4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood4.add(jLabelPrice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 150, 80));

        jLabelAmount4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAmount4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAmount4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAmount4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAmount4.setText("Số lượng");
        jPanelGood4.add(jLabelAmount4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 90, 80));

        jLabelUnit4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelUnit4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelUnit4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelUnit4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUnit4.setText("Đơn vị tính");
        jLabelUnit4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood4.add(jLabelUnit4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 100, 80));

        jLabelSetting4.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSetting4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSetting4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSetting4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSetting4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jPanelGood4.add(jLabelSetting4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 80, 80));

        javax.swing.GroupLayout jPanelControlPageProductLayout = new javax.swing.GroupLayout(jPanelControlPageProduct);
        jPanelControlPageProduct.setLayout(jPanelControlPageProductLayout);
        jPanelControlPageProductLayout.setHorizontalGroup(
            jPanelControlPageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControlPageProductLayout.createSequentialGroup()
                .addGap(586, 586, 586)
                .addComponent(jLabelSkipToStart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLeft)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPageProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPageProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelRight)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSkipToEnd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanelGood1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelControlPageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelGood6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelGood5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelGood4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelGood3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelGood2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelGood7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelControlPageProductLayout.setVerticalGroup(
            jPanelControlPageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelControlPageProductLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelGood1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelGood2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelGood3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelGood4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelGood5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelGood6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelGood7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelControlPageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelSkipToStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelSkipToEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldPageProduct)
                    .addComponent(jLabelPageProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelSelectPageLayout = new javax.swing.GroupLayout(jPanelSelectPage);
        jPanelSelectPage.setLayout(jPanelSelectPageLayout);
        jPanelSelectPageLayout.setHorizontalGroup(
            jPanelSelectPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSelectPageLayout.createSequentialGroup()
                .addComponent(jPanelControlPageProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelSelectPageLayout.setVerticalGroup(
            jPanelSelectPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSelectPageLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jPanelControlPageProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDashboardQLK.add(jPanelSelectPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1330, 730));

        jPanelControlQLK.setBackground(new java.awt.Color(255, 255, 255));
        jPanelControlQLK.setForeground(new java.awt.Color(255, 255, 255));
        jPanelControlQLK.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxType.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxType.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        jComboBoxType.setBorder(null);
        jComboBoxType.setFocusable(false);
        jComboBoxType.setLightWeightPopupEnabled(false);
        jComboBoxType.setName(""); // NOI18N
        jComboBoxType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTypeActionPerformed(evt);
            }
        });
        jPanelControlQLK.add(jComboBoxType, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jTextFieldSearchProduct.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldSearchProduct.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldSearchProduct.setForeground(new java.awt.Color(120, 120, 120));
        jTextFieldSearchProduct.setText("Tìm kiếm");
        jTextFieldSearchProduct.setBorder(null);
        jTextFieldSearchProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldSearchProduct.setOpaque(false);
        jTextFieldSearchProduct.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldSearchProductFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldSearchProductFocusLost(evt);
            }
        });
        jTextFieldSearchProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchProductKeyReleased(evt);
            }
        });
        jPanelControlQLK.add(jTextFieldSearchProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 80, 240, 30));

        jLabelSearchProduct.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSearchProduct.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelSearchProduct.setForeground(new java.awt.Color(120, 120, 120));
        jLabelSearchProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_search_20px_1.png"))); // NOI18N
        jLabelSearchProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanelControlQLK.add(jLabelSearchProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 80, 30, 30));

        jLabelFrameSearchProduct.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameSearchProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanelControlQLK.add(jLabelFrameSearchProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 80, 280, 30));

        jDashboardQLK.add(jPanelControlQLK, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 1330, 180));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jDashboardQLK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jDashboardQLK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPageProductKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPageProductKeyPressed

    }//GEN-LAST:event_jTextFieldPageProductKeyPressed

    private void jTextFieldPageProductKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPageProductKeyReleased
        // TODO add your handling code here:
        try {
            showProducts(ListGoods, countProduct);
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldPageProductKeyReleased

    private void jLabelRightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightMouseClicked
        // TODO add your handling code here:
        int jlabelrighta = Integer.parseInt(jTextFieldPageProduct.getText());
        int jlabelrightb = countProduct / 7 + setPageProduct;
        if (jlabelrighta < jlabelrightb) {
            jTextFieldPageProduct.setText(String.valueOf(Integer.parseInt(jTextFieldPageProduct.getText()) + 1));
            try {
                showProducts(ListGoods, countProduct);
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelRightMouseClicked

    private void jLabelRightMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightMouseEntered
        // TODO add your handling code here:
        jLabelRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px_1.png")));
    }//GEN-LAST:event_jLabelRightMouseEntered

    private void jLabelRightMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightMouseExited
        // TODO add your handling code here:

        jLabelRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px.png")));
    }//GEN-LAST:event_jLabelRightMouseExited

    private void jLabelLeftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftMouseClicked
        // TODO add your handling code here:
        if (Integer.parseInt(jTextFieldPageProduct.getText()) > 1) {
            jTextFieldPageProduct.setText(String.valueOf(Integer.parseInt(jTextFieldPageProduct.getText()) - 1));
            try {
                showProducts(ListGoods, countProduct);
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelLeftMouseClicked

    private void jLabelLeftMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftMouseEntered
        // TODO add your handling code here:
        jLabelLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px.png")));
    }//GEN-LAST:event_jLabelLeftMouseEntered

    private void jLabelLeftMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftMouseExited
        // TODO add your handling code here:
        jLabelLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px_1.png")));
    }//GEN-LAST:event_jLabelLeftMouseExited

    private void jLabelSkipToEndMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndMouseClicked
        // TODO add your handling code here:
        int jlabelrighta = Integer.parseInt(jTextFieldPageProduct.getText());
        int jlabelrightb = countProduct / 7 + setPageProduct;
        if (jlabelrighta < jlabelrightb) {
            jTextFieldPageProduct.setText(String.valueOf(countProduct / 7 + setPageProduct));
            try {
                showProducts(ListGoods, countProduct);
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelSkipToEndMouseClicked

    private void jLabelSkipToEndMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndMouseEntered
        // TODO add your handling code here:
        jLabelSkipToEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px.png")));
    }//GEN-LAST:event_jLabelSkipToEndMouseEntered

    private void jLabelSkipToEndMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndMouseExited
        // TODO add your handling code here:
        jLabelSkipToEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px_1.png")));
    }//GEN-LAST:event_jLabelSkipToEndMouseExited

    private void jLabelSkipToStartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartMouseClicked
        // TODO add your handling code here:
        if (Integer.parseInt(jTextFieldPageProduct.getText()) > 1) {
            jTextFieldPageProduct.setText("1");
            try {
                showProducts(ListGoods, countProduct);
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelSkipToStartMouseClicked

    private void jLabelSkipToStartMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartMouseEntered
        // TODO add your handling code here:
        jLabelSkipToStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px.png")));
    }//GEN-LAST:event_jLabelSkipToStartMouseEntered

    private void jLabelSkipToStartMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartMouseExited
        // TODO add your handling code here:
        jLabelSkipToStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px_1.png")));
    }//GEN-LAST:event_jLabelSkipToStartMouseExited

    private void jLabelImage1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage1MouseClicked
        // TODO add your handling code here:
        popUpImageProduct(0);
    }//GEN-LAST:event_jLabelImage1MouseClicked

    private void jLabelImage2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage2MouseClicked
        // TODO add your handling code here:
        popUpImageProduct(1);
    }//GEN-LAST:event_jLabelImage2MouseClicked

    private void jLabelImage3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage3MouseClicked
        // TODO add your handling code here:
        popUpImageProduct(2);
    }//GEN-LAST:event_jLabelImage3MouseClicked

    private void jLabelImage4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage4MouseClicked
        // TODO add your handling code here:
        popUpImageProduct(3);
    }//GEN-LAST:event_jLabelImage4MouseClicked

    private void jLabelImage5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage5MouseClicked
        // TODO add your handling code here:
        popUpImageProduct(4);
    }//GEN-LAST:event_jLabelImage5MouseClicked

    private void jLabelImage6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage6MouseClicked
        // TODO add your handling code here:
        popUpImageProduct(5);
    }//GEN-LAST:event_jLabelImage6MouseClicked

    private void jLabelImage7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage7MouseClicked
        // TODO add your handling code here:
        popUpImageProduct(6);
    }//GEN-LAST:event_jLabelImage7MouseClicked

    private void jComboBoxTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTypeActionPerformed
        if (jComboBoxType.getSelectedItem().toString().equals("Tất cả")) {
            try {
                ListGoods = GoodsDao.findAll();
                countProduct = GoodsDao.countProduct();
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            try {
                ListGoods = GoodsDao.findBy(jComboBoxType.getSelectedItem().toString());
                countProduct = GoodsDao.countProductBy(jComboBoxType.getSelectedItem().toString());
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        try {
            showProducts(ListGoods, countProduct);
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxTypeActionPerformed

    private void jTextFieldSearchProductFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchProductFocusGained
        jTextFieldSearchProduct.setText("");
    }//GEN-LAST:event_jTextFieldSearchProductFocusGained

    private void jTextFieldSearchProductFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchProductFocusLost
        if (jTextFieldSearchProduct.getText().equals("")) {
            jTextFieldSearchProduct.setText("Tìm kiếm");
        }
    }//GEN-LAST:event_jTextFieldSearchProductFocusLost

    private void jTextFieldSearchProductKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchProductKeyReleased
        try {
            ListGoods = GoodsDao.searchProduct(jTextFieldSearchProduct.getText());
            countProduct = GoodsDao.countSearchProduct(jTextFieldSearchProduct.getText());
            showProducts(ListGoods, countProduct);
            jTextFieldPageProduct.setText("1");
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldSearchProductKeyReleased

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddCustomer;
    private javax.swing.JButton jButtonDeleteCustomer;
    private javax.swing.JButton jButtonEditCustomer;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBoxAll;
    private javax.swing.JComboBox<String> jComboBoxType;
    private javax.swing.JPanel jDashboardQLK;
    private javax.swing.JLabel jLabelAmount;
    private javax.swing.JLabel jLabelAmount1;
    private javax.swing.JLabel jLabelAmount2;
    private javax.swing.JLabel jLabelAmount3;
    private javax.swing.JLabel jLabelAmount4;
    private javax.swing.JLabel jLabelAmount5;
    private javax.swing.JLabel jLabelAmount6;
    private javax.swing.JLabel jLabelAmount7;
    private javax.swing.JLabel jLabelCompany;
    private javax.swing.JLabel jLabelCompany1;
    private javax.swing.JLabel jLabelCompany2;
    private javax.swing.JLabel jLabelCompany3;
    private javax.swing.JLabel jLabelCompany4;
    private javax.swing.JLabel jLabelCompany5;
    private javax.swing.JLabel jLabelCompany6;
    private javax.swing.JLabel jLabelCompany7;
    private javax.swing.JLabel jLabelFrameSearchProduct;
    private javax.swing.JLabel jLabelImage;
    private javax.swing.JLabel jLabelImage1;
    private javax.swing.JLabel jLabelImage2;
    private javax.swing.JLabel jLabelImage3;
    private javax.swing.JLabel jLabelImage4;
    private javax.swing.JLabel jLabelImage5;
    private javax.swing.JLabel jLabelImage6;
    private javax.swing.JLabel jLabelImage7;
    private javax.swing.JLabel jLabelImportPrice1;
    private javax.swing.JLabel jLabelImportPrice2;
    private javax.swing.JLabel jLabelImportPrice3;
    private javax.swing.JLabel jLabelImportPrice4;
    private javax.swing.JLabel jLabelImportPrice5;
    private javax.swing.JLabel jLabelImportPrice6;
    private javax.swing.JLabel jLabelImportPrice7;
    private javax.swing.JLabel jLabelLeft;
    private javax.swing.JLabel jLabelMSP1;
    private javax.swing.JLabel jLabelMSP2;
    private javax.swing.JLabel jLabelMSP3;
    private javax.swing.JLabel jLabelMSP4;
    private javax.swing.JLabel jLabelMSP5;
    private javax.swing.JLabel jLabelMSP6;
    private javax.swing.JLabel jLabelMSP7;
    private javax.swing.JLabel jLabelMaSP;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelName1;
    private javax.swing.JLabel jLabelName2;
    private javax.swing.JLabel jLabelName3;
    private javax.swing.JLabel jLabelName4;
    private javax.swing.JLabel jLabelName5;
    private javax.swing.JLabel jLabelName6;
    private javax.swing.JLabel jLabelName7;
    private javax.swing.JLabel jLabelPageProduct;
    private javax.swing.JLabel jLabelPrice;
    private javax.swing.JLabel jLabelPrice1;
    private javax.swing.JLabel jLabelPrice2;
    private javax.swing.JLabel jLabelPrice3;
    private javax.swing.JLabel jLabelPrice4;
    private javax.swing.JLabel jLabelPrice5;
    private javax.swing.JLabel jLabelPrice6;
    private javax.swing.JLabel jLabelPrice7;
    private javax.swing.JLabel jLabelPriceImport;
    private javax.swing.JLabel jLabelRight;
    private javax.swing.JLabel jLabelSearchProduct;
    private javax.swing.JLabel jLabelSetting1;
    private javax.swing.JLabel jLabelSetting2;
    private javax.swing.JLabel jLabelSetting3;
    private javax.swing.JLabel jLabelSetting4;
    private javax.swing.JLabel jLabelSetting5;
    private javax.swing.JLabel jLabelSetting6;
    private javax.swing.JLabel jLabelSetting7;
    private javax.swing.JLabel jLabelSettings;
    private javax.swing.JLabel jLabelSkipToEnd;
    private javax.swing.JLabel jLabelSkipToStart;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JLabel jLabelType1;
    private javax.swing.JLabel jLabelType2;
    private javax.swing.JLabel jLabelType3;
    private javax.swing.JLabel jLabelType4;
    private javax.swing.JLabel jLabelType5;
    private javax.swing.JLabel jLabelType6;
    private javax.swing.JLabel jLabelType7;
    private javax.swing.JLabel jLabelUnit;
    private javax.swing.JLabel jLabelUnit1;
    private javax.swing.JLabel jLabelUnit2;
    private javax.swing.JLabel jLabelUnit3;
    private javax.swing.JLabel jLabelUnit4;
    private javax.swing.JLabel jLabelUnit5;
    private javax.swing.JLabel jLabelUnit6;
    private javax.swing.JLabel jLabelUnit7;
    private javax.swing.JPanel jPanelControlPageProduct;
    private javax.swing.JPanel jPanelControlQLK;
    private javax.swing.JPanel jPanelGood1;
    private javax.swing.JPanel jPanelGood2;
    private javax.swing.JPanel jPanelGood3;
    private javax.swing.JPanel jPanelGood4;
    private javax.swing.JPanel jPanelGood5;
    private javax.swing.JPanel jPanelGood6;
    private javax.swing.JPanel jPanelGood7;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelSelectPage;
    private javax.swing.JTextField jTextFieldPageProduct;
    private javax.swing.JTextField jTextFieldSearchProduct;
    // End of variables declaration//GEN-END:variables
}
