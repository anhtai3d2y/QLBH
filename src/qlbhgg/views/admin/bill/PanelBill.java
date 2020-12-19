/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.views.admin.bill;

import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import qlbhgg.dao.BillDao;
import qlbhgg.dao.CustomerDao;
import qlbhgg.dao.GoodsDao;
import qlbhgg.dao.InvoicedetailsDao;
import qlbhgg.dao.UsersDao;
import qlbhgg.models.Bill;
import qlbhgg.models.Customers;
import qlbhgg.models.Invoicedetails;
import qlbhgg.models.Users;

/**
 *
 * @author acer
 */
public class PanelBill extends javax.swing.JPanel {

    /**
     * Creates new form PanelBill
     */
    public ArrayList<Bill> ListBills = BillDao.findAllBill();
    public int countBill = BillDao.countBill();
    public int setPageBill;

    public PanelBill() throws SQLException {
        initComponents();
        showBillList(ListBills, countBill);
    }

    public void startingStateQLHD() {
        jPanelBill1.setVisible(false);
        jPanelBill2.setVisible(false);
        jPanelBill3.setVisible(false);
        jPanelBill4.setVisible(false);
        jPanelBill5.setVisible(false);
    }

    public void showBillList(ArrayList<Bill> ListBills, int countBill) throws SQLException {
        startingStateQLHD();
        setPageBill = (countBill % 5 == 0) ? 0 : 1;
        jLabelPageBill.setText("/" + String.valueOf(countBill / 5 + setPageBill));
        int pageBill = (Integer.parseInt(jTextFieldPageBill.getText()) - 1) * 5;
        if (pageBill < countBill) {
            renderJPanelBill(ListBills.get(pageBill), jPanelBill1, jLabelIdBill1, jLabelDateBill1, jLabelIDStaffBill1, jLabelNameStaffBill1, jLabelCustomerNameBill1, jLabelCustomerPhonenumberBill1, jLabelCustomerAddressBill1, jLabelProductBill1, jLabelPriceBill1, jLabelDiscountBill1, jLabelTotalPriceBill1, jLabelNoteBill1);
        } else {
            jPanelBill1.setVisible(false);
        }
        if (pageBill + 1 < countBill) {
            renderJPanelBill(ListBills.get(pageBill + 1), jPanelBill2, jLabelIdBill2, jLabelDateBill2, jLabelIDStaffBill2, jLabelNameStaffBill2, jLabelCustomerNameBill2, jLabelCustomerPhonenumberBill2, jLabelCustomerAddressBill2, jLabelProductBill2, jLabelPriceBill2, jLabelDiscountBill2, jLabelTotalPriceBill2, jLabelNoteBill2);
        } else {
            jPanelBill2.setVisible(false);
        }
        if (pageBill + 2 < countBill) {
            renderJPanelBill(ListBills.get(pageBill + 2), jPanelBill3, jLabelIdBill3, jLabelDateBill3, jLabelIDStaffBill3, jLabelNameStaffBill3, jLabelCustomerNameBill3, jLabelCustomerPhonenumberBill3, jLabelCustomerAddressBill3, jLabelProductBill3, jLabelPriceBill3, jLabelDiscountBill3, jLabelTotalPriceBill3, jLabelNoteBill3);
        } else {
            jPanelBill3.setVisible(false);
        }
        if (pageBill + 3 < countBill) {
            renderJPanelBill(ListBills.get(pageBill + 3), jPanelBill4, jLabelIdBill4, jLabelDateBill4, jLabelIDStaffBill4, jLabelNameStaffBill4, jLabelCustomerNameBill4, jLabelCustomerPhonenumberBill4, jLabelCustomerAddressBill4, jLabelProductBill4, jLabelPriceBill4, jLabelDiscountBill4, jLabelTotalPriceBill4, jLabelNoteBill4);
        } else {
            jPanelBill4.setVisible(false);
        }
        if (pageBill + 4 < countBill) {
            renderJPanelBill(ListBills.get(pageBill + 4), jPanelBill5, jLabelIdBill5, jLabelDateBill5, jLabelIDStaffBill5, jLabelNameStaffBill5, jLabelCustomerNameBill5, jLabelCustomerPhonenumberBill5, jLabelCustomerAddressBill5, jLabelProductBill5, jLabelPriceBill5, jLabelDiscountBill5, jLabelTotalPriceBill5, jLabelNoteBill5);
        } else {
            jPanelBill5.setVisible(false);
        }
        jLabelFrameSearchBill.setIcon(scaleFrameSearch("/Image/FrameSearch.png"));
    }

    private void renderJPanelBill(Bill b, JPanel jpanel, JLabel jlabelIdBill, JLabel jlabelDateBill, JLabel jlabelIdStaffBill, JLabel jlabelNameStaffBill, JLabel jlabelCustomerNameBill, JLabel jlabelCustomerPhonenumberBill, JLabel jlabelCustomerAddressBill, JLabel jlabelProductBill, JLabel jlabelPriceBill, JLabel jlabelDiscountBill, JLabel jlabelTotalPriceBill, JLabel jlabelNoteBill) throws SQLException {
        jpanel.setVisible(true);
        jlabelIdBill.setText("ID:" + b.getCodebill());
        jlabelDateBill.setText(b.getCreationdate().toString());
        Users userCreateBill = UsersDao.findStaffById(b.getIduser());
        Customers customerBill = CustomerDao.findCustomerById(b.getCustomercode());
        ArrayList<Invoicedetails> ListInvoicedetailses = InvoicedetailsDao.findInvoicedetailsByIdBill(b.getCodebill());
        jlabelIdStaffBill.setText(userCreateBill.getId());
        jlabelNameStaffBill.setText(userCreateBill.getFullname());
        jlabelCustomerNameBill.setText(customerBill.getCustomername());
        jlabelCustomerPhonenumberBill.setText(customerBill.getPhonenumber());
        jlabelCustomerAddressBill.setText("<html>" + customerBill.getAddress() + "</html>");
        String productbill = "<html>";
        int count = 0;
        float price = 0, discount = 0;
        for (Invoicedetails iv : ListInvoicedetailses) {
            if (count < 3) {
                productbill += "- " + GoodsDao.findProductForBill(iv.getItemcode()).getItemname() + "<br>";
                count++;
            }
            price += iv.getPrice() * iv.getAmount();
            discount += (iv.getPrice() * iv.getAmount()) / 100 * iv.getDiscount();
        }
        productbill += "</html>";
        jlabelProductBill.setText(productbill);
        jlabelPriceBill.setText(String.format("%1$,.0f", price));
        jlabelDiscountBill.setText(String.format("%1$,.0f", discount));
        jlabelTotalPriceBill.setText(String.format("%1$,.0f", price - discount));
        if (b.getNote().equals("")) {
            jlabelNoteBill.setText("--------------------------");
        } else {
            jlabelNoteBill.setText(b.getNote());
        }
    }

    private ImageIcon scaleFrameSearch(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(280, 30, Image.SCALE_SMOOTH);
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

        jDashboardQLDH = new javax.swing.JPanel();
        jPanelBill5 = new javax.swing.JPanel();
        jCheckBoxAllBill5 = new javax.swing.JCheckBox();
        jLabelPriceBill5 = new javax.swing.JLabel();
        jLabelDiscountBill5 = new javax.swing.JLabel();
        jLabelTotalPriceBill5 = new javax.swing.JLabel();
        jLabelNoteBill5 = new javax.swing.JLabel();
        jLabelSettingBill5 = new javax.swing.JLabel();
        jPanelTTBill5 = new javax.swing.JPanel();
        jLabelDateBill5 = new javax.swing.JLabel();
        jLabelIdBill5 = new javax.swing.JLabel();
        jPanelTTStaffBill5 = new javax.swing.JPanel();
        jLabelNameStaffBill5 = new javax.swing.JLabel();
        jLabelIDStaffBill5 = new javax.swing.JLabel();
        jPanelCustomerBill5 = new javax.swing.JPanel();
        jLabelCustomerPhonenumberBill5 = new javax.swing.JLabel();
        jLabelCustomerNameBill5 = new javax.swing.JLabel();
        jLabelCustomerAddressBill5 = new javax.swing.JLabel();
        jPanelProductBill5 = new javax.swing.JPanel();
        jLabelProductBill5 = new javax.swing.JLabel();
        jPanelBill4 = new javax.swing.JPanel();
        jCheckBoxAllBill4 = new javax.swing.JCheckBox();
        jLabelPriceBill4 = new javax.swing.JLabel();
        jLabelDiscountBill4 = new javax.swing.JLabel();
        jLabelTotalPriceBill4 = new javax.swing.JLabel();
        jLabelNoteBill4 = new javax.swing.JLabel();
        jLabelSettingBill4 = new javax.swing.JLabel();
        jPanelTTBill4 = new javax.swing.JPanel();
        jLabelDateBill4 = new javax.swing.JLabel();
        jLabelIdBill4 = new javax.swing.JLabel();
        jPanelTTStaffBill4 = new javax.swing.JPanel();
        jLabelNameStaffBill4 = new javax.swing.JLabel();
        jLabelIDStaffBill4 = new javax.swing.JLabel();
        jPanelCustomerBill4 = new javax.swing.JPanel();
        jLabelCustomerPhonenumberBill4 = new javax.swing.JLabel();
        jLabelCustomerNameBill4 = new javax.swing.JLabel();
        jLabelCustomerAddressBill4 = new javax.swing.JLabel();
        jPanelProductBill4 = new javax.swing.JPanel();
        jLabelProductBill4 = new javax.swing.JLabel();
        jPanelBill3 = new javax.swing.JPanel();
        jCheckBoxAllBill3 = new javax.swing.JCheckBox();
        jLabelPriceBill3 = new javax.swing.JLabel();
        jLabelDiscountBill3 = new javax.swing.JLabel();
        jLabelTotalPriceBill3 = new javax.swing.JLabel();
        jLabelNoteBill3 = new javax.swing.JLabel();
        jLabelSettingBill3 = new javax.swing.JLabel();
        jPanelTTBill3 = new javax.swing.JPanel();
        jLabelDateBill3 = new javax.swing.JLabel();
        jLabelIdBill3 = new javax.swing.JLabel();
        jPanelTTStaffBill3 = new javax.swing.JPanel();
        jLabelNameStaffBill3 = new javax.swing.JLabel();
        jLabelIDStaffBill3 = new javax.swing.JLabel();
        jPanelCustomerBill3 = new javax.swing.JPanel();
        jLabelCustomerPhonenumberBill3 = new javax.swing.JLabel();
        jLabelCustomerNameBill3 = new javax.swing.JLabel();
        jLabelCustomerAddressBill3 = new javax.swing.JLabel();
        jPanelProductBill3 = new javax.swing.JPanel();
        jLabelProductBill3 = new javax.swing.JLabel();
        jPanelBill2 = new javax.swing.JPanel();
        jCheckBoxAllBill2 = new javax.swing.JCheckBox();
        jLabelPriceBill2 = new javax.swing.JLabel();
        jLabelDiscountBill2 = new javax.swing.JLabel();
        jLabelTotalPriceBill2 = new javax.swing.JLabel();
        jLabelNoteBill2 = new javax.swing.JLabel();
        jLabelSettingBill2 = new javax.swing.JLabel();
        jPanelTTBill2 = new javax.swing.JPanel();
        jLabelDateBill2 = new javax.swing.JLabel();
        jLabelIdBill2 = new javax.swing.JLabel();
        jPanelTTStaffBill2 = new javax.swing.JPanel();
        jLabelNameStaffBill2 = new javax.swing.JLabel();
        jLabelIDStaffBill2 = new javax.swing.JLabel();
        jPanelCustomerBill2 = new javax.swing.JPanel();
        jLabelCustomerPhonenumberBill2 = new javax.swing.JLabel();
        jLabelCustomerNameBill2 = new javax.swing.JLabel();
        jLabelCustomerAddressBill2 = new javax.swing.JLabel();
        jPanelProductBill2 = new javax.swing.JPanel();
        jLabelProductBill2 = new javax.swing.JLabel();
        jPanelBill1 = new javax.swing.JPanel();
        jCheckBoxAllBill1 = new javax.swing.JCheckBox();
        jLabelPriceBill1 = new javax.swing.JLabel();
        jLabelDiscountBill1 = new javax.swing.JLabel();
        jLabelTotalPriceBill1 = new javax.swing.JLabel();
        jLabelNoteBill1 = new javax.swing.JLabel();
        jLabelSettingBill1 = new javax.swing.JLabel();
        jPanelTTBill1 = new javax.swing.JPanel();
        jLabelDateBill1 = new javax.swing.JLabel();
        jLabelIdBill1 = new javax.swing.JLabel();
        jPanelTTStaffBill1 = new javax.swing.JPanel();
        jLabelNameStaffBill1 = new javax.swing.JLabel();
        jLabelIDStaffBill1 = new javax.swing.JLabel();
        jPanelCustomerBill1 = new javax.swing.JPanel();
        jLabelCustomerPhonenumberBill1 = new javax.swing.JLabel();
        jLabelCustomerNameBill1 = new javax.swing.JLabel();
        jLabelCustomerAddressBill1 = new javax.swing.JLabel();
        jPanelProductBill1 = new javax.swing.JPanel();
        jLabelProductBill1 = new javax.swing.JLabel();
        jPanelHeaderBill = new javax.swing.JPanel();
        jCheckBoxAllBill = new javax.swing.JCheckBox();
        jLabelTTBill = new javax.swing.JLabel();
        jLabelStaffBill = new javax.swing.JLabel();
        jLabelCustomerBill = new javax.swing.JLabel();
        jLabelProductBill = new javax.swing.JLabel();
        jLabelPriceBill = new javax.swing.JLabel();
        jLabelDiscountBill = new javax.swing.JLabel();
        jLabelTotalBill = new javax.swing.JLabel();
        jLabelNoteBill = new javax.swing.JLabel();
        jLabelSettingBill = new javax.swing.JLabel();
        jPanelControlPageBill = new javax.swing.JPanel();
        jTextFieldPageBill = new javax.swing.JTextField();
        jLabelPageBill = new javax.swing.JLabel();
        jLabelRightPageBill = new javax.swing.JLabel();
        jLabelLeftPageBill = new javax.swing.JLabel();
        jLabelSkipToEndPageBill = new javax.swing.JLabel();
        jLabelSkipToStartPageBill = new javax.swing.JLabel();
        jLabelSearchBill = new javax.swing.JLabel();
        jTextFieldSearchBill = new javax.swing.JTextField();
        jLabelFrameSearchBill = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDashboardQLDH.setBackground(new java.awt.Color(255, 255, 255));
        jDashboardQLDH.setForeground(new java.awt.Color(153, 255, 153));
        jDashboardQLDH.setPreferredSize(new java.awt.Dimension(1330, 870));
        jDashboardQLDH.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelBill5.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBill5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill5.setForeground(new java.awt.Color(255, 255, 255));
        jPanelBill5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBoxAllBill5.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxAllBill5.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxAllBill5.setBorder(null);
        jPanelBill5.add(jCheckBoxAllBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 20, 100));

        jLabelPriceBill5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPriceBill5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPriceBill5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPriceBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPriceBill5.setText("Thành tiền");
        jLabelPriceBill5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill5.add(jLabelPriceBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 110, 120));

        jLabelDiscountBill5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDiscountBill5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDiscountBill5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDiscountBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDiscountBill5.setText("Chiết khấu");
        jPanelBill5.add(jLabelDiscountBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 110, 120));

        jLabelTotalPriceBill5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalPriceBill5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalPriceBill5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTotalPriceBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalPriceBill5.setText("Tổng thu");
        jLabelTotalPriceBill5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill5.add(jLabelTotalPriceBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 0, 110, 120));

        jLabelNoteBill5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNoteBill5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNoteBill5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNoteBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNoteBill5.setText("Ghi chú");
        jPanelBill5.add(jLabelNoteBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 170, 120));

        jLabelSettingBill5.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingBill5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingBill5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSettingBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingBill5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSettingBill5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill5.add(jLabelSettingBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 0, 50, 120));

        jPanelTTBill5.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTTBill5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelTTBill5.setForeground(new java.awt.Color(255, 255, 255));
        jPanelTTBill5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDateBill5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDateBill5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDateBill5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDateBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDateBill5.setText("2020-12-14");
        jPanelTTBill5.add(jLabelDateBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 140, 30));

        jLabelIdBill5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdBill5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIdBill5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIdBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdBill5.setText("ID:?");
        jPanelTTBill5.add(jLabelIdBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 140, 30));

        jPanelBill5.add(jPanelTTBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 120));

        jPanelTTStaffBill5.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTTStaffBill5.setForeground(new java.awt.Color(255, 255, 255));
        jPanelTTStaffBill5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNameStaffBill5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaffBill5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNameStaffBill5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameStaffBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameStaffBill5.setText("Phạm Duy Tài");
        jPanelTTStaffBill5.add(jLabelNameStaffBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 160, 30));

        jLabelIDStaffBill5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIDStaffBill5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIDStaffBill5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIDStaffBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIDStaffBill5.setText("ID:US?");
        jPanelTTStaffBill5.add(jLabelIDStaffBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 160, 30));

        jPanelBill5.add(jPanelTTStaffBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 1, 158, 118));

        jPanelCustomerBill5.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCustomerBill5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelCustomerBill5.setForeground(new java.awt.Color(255, 255, 255));
        jPanelCustomerBill5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCustomerPhonenumberBill5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerPhonenumberBill5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerPhonenumberBill5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCustomerPhonenumberBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerPhonenumberBill5.setText("Số điện thoại");
        jPanelCustomerBill5.add(jLabelCustomerPhonenumberBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 180, 30));

        jLabelCustomerNameBill5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerNameBill5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerNameBill5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCustomerNameBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerNameBill5.setText("Tên khách hàng");
        jPanelCustomerBill5.add(jLabelCustomerNameBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 30));

        jLabelCustomerAddressBill5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerAddressBill5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerAddressBill5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCustomerAddressBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerAddressBill5.setText("Địa chỉ");
        jPanelCustomerBill5.add(jLabelCustomerAddressBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 180, 60));

        jPanelBill5.add(jPanelCustomerBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 180, 120));

        jPanelProductBill5.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProductBill5.setForeground(new java.awt.Color(255, 255, 255));
        jPanelProductBill5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelProductBill5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelProductBill5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelProductBill5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelProductBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProductBill5.setText("Sản phẩm");
        jPanelProductBill5.add(jLabelProductBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 120));

        jPanelBill5.add(jPanelProductBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 1, 248, 118));

        jDashboardQLDH.add(jPanelBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, -1, 120));

        jPanelBill4.setBackground(new java.awt.Color(215, 220, 222));
        jPanelBill4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill4.setForeground(new java.awt.Color(215, 220, 222));
        jPanelBill4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBoxAllBill4.setBackground(new java.awt.Color(215, 220, 222));
        jCheckBoxAllBill4.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxAllBill4.setBorder(null);
        jPanelBill4.add(jCheckBoxAllBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 20, 100));

        jLabelPriceBill4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPriceBill4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPriceBill4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPriceBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPriceBill4.setText("Thành tiền");
        jLabelPriceBill4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill4.add(jLabelPriceBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 110, 120));

        jLabelDiscountBill4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDiscountBill4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDiscountBill4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDiscountBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDiscountBill4.setText("Chiết khấu");
        jPanelBill4.add(jLabelDiscountBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 110, 120));

        jLabelTotalPriceBill4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalPriceBill4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalPriceBill4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTotalPriceBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalPriceBill4.setText("Tổng thu");
        jLabelTotalPriceBill4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill4.add(jLabelTotalPriceBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 0, 110, 120));

        jLabelNoteBill4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNoteBill4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNoteBill4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNoteBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNoteBill4.setText("Ghi chú");
        jPanelBill4.add(jLabelNoteBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 170, 120));

        jLabelSettingBill4.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingBill4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingBill4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSettingBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingBill4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSettingBill4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill4.add(jLabelSettingBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 0, 50, 120));

        jPanelTTBill4.setBackground(new java.awt.Color(215, 220, 222));
        jPanelTTBill4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelTTBill4.setForeground(new java.awt.Color(215, 220, 222));
        jPanelTTBill4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDateBill4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDateBill4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDateBill4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDateBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDateBill4.setText("2020-12-14");
        jPanelTTBill4.add(jLabelDateBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 140, 30));

        jLabelIdBill4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdBill4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIdBill4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIdBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdBill4.setText("ID:?");
        jPanelTTBill4.add(jLabelIdBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 140, 30));

        jPanelBill4.add(jPanelTTBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 120));

        jPanelTTStaffBill4.setBackground(new java.awt.Color(215, 220, 222));
        jPanelTTStaffBill4.setForeground(new java.awt.Color(215, 220, 222));
        jPanelTTStaffBill4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNameStaffBill4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaffBill4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNameStaffBill4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameStaffBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameStaffBill4.setText("Phạm Duy Tài");
        jPanelTTStaffBill4.add(jLabelNameStaffBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 160, 30));

        jLabelIDStaffBill4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIDStaffBill4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIDStaffBill4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIDStaffBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIDStaffBill4.setText("ID:US?");
        jPanelTTStaffBill4.add(jLabelIDStaffBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 160, 30));

        jPanelBill4.add(jPanelTTStaffBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 1, 158, 118));

        jPanelCustomerBill4.setBackground(new java.awt.Color(215, 220, 222));
        jPanelCustomerBill4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelCustomerBill4.setForeground(new java.awt.Color(215, 220, 222));
        jPanelCustomerBill4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCustomerPhonenumberBill4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerPhonenumberBill4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerPhonenumberBill4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCustomerPhonenumberBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerPhonenumberBill4.setText("Số điện thoại");
        jPanelCustomerBill4.add(jLabelCustomerPhonenumberBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 180, 30));

        jLabelCustomerNameBill4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerNameBill4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerNameBill4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCustomerNameBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerNameBill4.setText("Tên khách hàng");
        jPanelCustomerBill4.add(jLabelCustomerNameBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 30));

        jLabelCustomerAddressBill4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerAddressBill4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerAddressBill4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCustomerAddressBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerAddressBill4.setText("Địa chỉ");
        jPanelCustomerBill4.add(jLabelCustomerAddressBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 180, 60));

        jPanelBill4.add(jPanelCustomerBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 180, 120));

        jPanelProductBill4.setBackground(new java.awt.Color(215, 220, 222));
        jPanelProductBill4.setForeground(new java.awt.Color(215, 220, 222));
        jPanelProductBill4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelProductBill4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelProductBill4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelProductBill4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelProductBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProductBill4.setText("Sản phẩm");
        jPanelProductBill4.add(jLabelProductBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 120));

        jPanelBill4.add(jPanelProductBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 1, 248, 118));

        jDashboardQLDH.add(jPanelBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, -1, 120));

        jPanelBill3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBill3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill3.setForeground(new java.awt.Color(255, 255, 255));
        jPanelBill3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBoxAllBill3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxAllBill3.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxAllBill3.setBorder(null);
        jPanelBill3.add(jCheckBoxAllBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 20, 100));

        jLabelPriceBill3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPriceBill3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPriceBill3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPriceBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPriceBill3.setText("Thành tiền");
        jLabelPriceBill3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill3.add(jLabelPriceBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 110, 120));

        jLabelDiscountBill3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDiscountBill3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDiscountBill3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDiscountBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDiscountBill3.setText("Chiết khấu");
        jPanelBill3.add(jLabelDiscountBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 110, 120));

        jLabelTotalPriceBill3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalPriceBill3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalPriceBill3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTotalPriceBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalPriceBill3.setText("Tổng thu");
        jLabelTotalPriceBill3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill3.add(jLabelTotalPriceBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 0, 110, 120));

        jLabelNoteBill3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNoteBill3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNoteBill3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNoteBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNoteBill3.setText("Ghi chú");
        jPanelBill3.add(jLabelNoteBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 170, 120));

        jLabelSettingBill3.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingBill3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingBill3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSettingBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingBill3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSettingBill3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill3.add(jLabelSettingBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 0, 50, 120));

        jPanelTTBill3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTTBill3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelTTBill3.setForeground(new java.awt.Color(255, 255, 255));
        jPanelTTBill3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDateBill3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDateBill3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDateBill3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDateBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDateBill3.setText("2020-12-14");
        jPanelTTBill3.add(jLabelDateBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 140, 30));

        jLabelIdBill3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdBill3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIdBill3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIdBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdBill3.setText("ID:?");
        jPanelTTBill3.add(jLabelIdBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 140, 30));

        jPanelBill3.add(jPanelTTBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 120));

        jPanelTTStaffBill3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTTStaffBill3.setForeground(new java.awt.Color(255, 255, 255));
        jPanelTTStaffBill3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNameStaffBill3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaffBill3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNameStaffBill3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameStaffBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameStaffBill3.setText("Phạm Duy Tài");
        jPanelTTStaffBill3.add(jLabelNameStaffBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 160, 30));

        jLabelIDStaffBill3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIDStaffBill3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIDStaffBill3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIDStaffBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIDStaffBill3.setText("ID:US?");
        jPanelTTStaffBill3.add(jLabelIDStaffBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 160, 30));

        jPanelBill3.add(jPanelTTStaffBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 1, 158, 118));

        jPanelCustomerBill3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCustomerBill3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelCustomerBill3.setForeground(new java.awt.Color(255, 255, 255));
        jPanelCustomerBill3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCustomerPhonenumberBill3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerPhonenumberBill3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerPhonenumberBill3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCustomerPhonenumberBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerPhonenumberBill3.setText("Số điện thoại");
        jPanelCustomerBill3.add(jLabelCustomerPhonenumberBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 180, 30));

        jLabelCustomerNameBill3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerNameBill3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerNameBill3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCustomerNameBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerNameBill3.setText("Tên khách hàng");
        jPanelCustomerBill3.add(jLabelCustomerNameBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 30));

        jLabelCustomerAddressBill3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerAddressBill3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerAddressBill3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCustomerAddressBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerAddressBill3.setText("Địa chỉ");
        jPanelCustomerBill3.add(jLabelCustomerAddressBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 180, 60));

        jPanelBill3.add(jPanelCustomerBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 180, 120));

        jPanelProductBill3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProductBill3.setForeground(new java.awt.Color(255, 255, 255));
        jPanelProductBill3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelProductBill3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelProductBill3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelProductBill3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelProductBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProductBill3.setText("Sản phẩm");
        jPanelProductBill3.add(jLabelProductBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 120));

        jPanelBill3.add(jPanelProductBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 1, 248, 118));

        jDashboardQLDH.add(jPanelBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, -1, 120));

        jPanelBill2.setBackground(new java.awt.Color(215, 220, 222));
        jPanelBill2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill2.setForeground(new java.awt.Color(255, 255, 255));
        jPanelBill2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBoxAllBill2.setBackground(new java.awt.Color(215, 220, 222));
        jCheckBoxAllBill2.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxAllBill2.setBorder(null);
        jPanelBill2.add(jCheckBoxAllBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 20, 100));

        jLabelPriceBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPriceBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPriceBill2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPriceBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPriceBill2.setText("Thành tiền");
        jLabelPriceBill2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill2.add(jLabelPriceBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 110, 120));

        jLabelDiscountBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDiscountBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDiscountBill2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDiscountBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDiscountBill2.setText("Chiết khấu");
        jPanelBill2.add(jLabelDiscountBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 110, 120));

        jLabelTotalPriceBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalPriceBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalPriceBill2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTotalPriceBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalPriceBill2.setText("Tổng thu");
        jLabelTotalPriceBill2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill2.add(jLabelTotalPriceBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 0, 110, 120));

        jLabelNoteBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNoteBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNoteBill2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNoteBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNoteBill2.setText("Ghi chú");
        jPanelBill2.add(jLabelNoteBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 170, 120));

        jLabelSettingBill2.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingBill2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingBill2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSettingBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingBill2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSettingBill2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill2.add(jLabelSettingBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 0, 50, 120));

        jPanelTTBill2.setBackground(new java.awt.Color(215, 220, 222));
        jPanelTTBill2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelTTBill2.setForeground(new java.awt.Color(255, 255, 255));
        jPanelTTBill2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDateBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDateBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDateBill2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDateBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDateBill2.setText("2020-12-14");
        jPanelTTBill2.add(jLabelDateBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 140, 30));

        jLabelIdBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIdBill2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIdBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdBill2.setText("ID:?");
        jPanelTTBill2.add(jLabelIdBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 140, 30));

        jPanelBill2.add(jPanelTTBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 120));

        jPanelTTStaffBill2.setBackground(new java.awt.Color(215, 220, 222));
        jPanelTTStaffBill2.setForeground(new java.awt.Color(255, 255, 255));
        jPanelTTStaffBill2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNameStaffBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaffBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNameStaffBill2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameStaffBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameStaffBill2.setText("Phạm Duy Tài");
        jPanelTTStaffBill2.add(jLabelNameStaffBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 160, 30));

        jLabelIDStaffBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIDStaffBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIDStaffBill2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIDStaffBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIDStaffBill2.setText("ID:US?");
        jPanelTTStaffBill2.add(jLabelIDStaffBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 160, 30));

        jPanelBill2.add(jPanelTTStaffBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 1, 158, 118));

        jPanelCustomerBill2.setBackground(new java.awt.Color(215, 220, 222));
        jPanelCustomerBill2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelCustomerBill2.setForeground(new java.awt.Color(255, 255, 255));
        jPanelCustomerBill2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCustomerPhonenumberBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerPhonenumberBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerPhonenumberBill2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCustomerPhonenumberBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerPhonenumberBill2.setText("Số điện thoại");
        jPanelCustomerBill2.add(jLabelCustomerPhonenumberBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 180, 30));

        jLabelCustomerNameBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerNameBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerNameBill2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCustomerNameBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerNameBill2.setText("Tên khách hàng");
        jPanelCustomerBill2.add(jLabelCustomerNameBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 30));

        jLabelCustomerAddressBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerAddressBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerAddressBill2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCustomerAddressBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerAddressBill2.setText("Địa chỉ");
        jPanelCustomerBill2.add(jLabelCustomerAddressBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 180, 60));

        jPanelBill2.add(jPanelCustomerBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 180, 120));

        jPanelProductBill2.setBackground(new java.awt.Color(215, 220, 222));
        jPanelProductBill2.setForeground(new java.awt.Color(255, 255, 255));
        jPanelProductBill2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelProductBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelProductBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelProductBill2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelProductBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProductBill2.setText("Sản phẩm");
        jPanelProductBill2.add(jLabelProductBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 120));

        jPanelBill2.add(jPanelProductBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 1, 248, 118));

        jDashboardQLDH.add(jPanelBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, -1, 120));

        jPanelBill1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBill1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelBill1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBoxAllBill1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxAllBill1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxAllBill1.setBorder(null);
        jPanelBill1.add(jCheckBoxAllBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 20, 100));

        jLabelPriceBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPriceBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPriceBill1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPriceBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPriceBill1.setText("Thành tiền");
        jLabelPriceBill1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill1.add(jLabelPriceBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 110, 120));

        jLabelDiscountBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDiscountBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDiscountBill1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDiscountBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDiscountBill1.setText("Chiết khấu");
        jPanelBill1.add(jLabelDiscountBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 110, 120));

        jLabelTotalPriceBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalPriceBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalPriceBill1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTotalPriceBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalPriceBill1.setText("Tổng thu");
        jLabelTotalPriceBill1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill1.add(jLabelTotalPriceBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 0, 110, 120));

        jLabelNoteBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNoteBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNoteBill1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNoteBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNoteBill1.setText("--------------------------");
        jPanelBill1.add(jLabelNoteBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 170, 120));

        jLabelSettingBill1.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingBill1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingBill1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSettingBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingBill1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSettingBill1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill1.add(jLabelSettingBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 0, 50, 120));

        jPanelTTBill1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTTBill1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelTTBill1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelTTBill1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDateBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDateBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDateBill1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDateBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDateBill1.setText("2020-12-14");
        jPanelTTBill1.add(jLabelDateBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 140, 30));

        jLabelIdBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIdBill1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIdBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdBill1.setText("ID:?");
        jPanelTTBill1.add(jLabelIdBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 140, 30));

        jPanelBill1.add(jPanelTTBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 120));

        jPanelTTStaffBill1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTTStaffBill1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelTTStaffBill1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNameStaffBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaffBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNameStaffBill1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameStaffBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameStaffBill1.setText("Phạm Duy Tài");
        jPanelTTStaffBill1.add(jLabelNameStaffBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 160, 30));

        jLabelIDStaffBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIDStaffBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIDStaffBill1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIDStaffBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIDStaffBill1.setText("ID:US?");
        jPanelTTStaffBill1.add(jLabelIDStaffBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 160, 30));

        jPanelBill1.add(jPanelTTStaffBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 1, 158, 118));

        jPanelCustomerBill1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCustomerBill1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelCustomerBill1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelCustomerBill1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCustomerPhonenumberBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerPhonenumberBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerPhonenumberBill1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCustomerPhonenumberBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerPhonenumberBill1.setText("Số điện thoại");
        jPanelCustomerBill1.add(jLabelCustomerPhonenumberBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 180, 30));

        jLabelCustomerNameBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerNameBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerNameBill1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCustomerNameBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerNameBill1.setText("Tên khách hàng");
        jPanelCustomerBill1.add(jLabelCustomerNameBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 30));

        jLabelCustomerAddressBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerAddressBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerAddressBill1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCustomerAddressBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerAddressBill1.setText("Địa chỉ");
        jPanelCustomerBill1.add(jLabelCustomerAddressBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 180, 60));

        jPanelBill1.add(jPanelCustomerBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 180, 120));

        jPanelProductBill1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProductBill1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelProductBill1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelProductBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelProductBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelProductBill1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelProductBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProductBill1.setText("Sản phẩm");
        jPanelProductBill1.add(jLabelProductBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 120));

        jPanelBill1.add(jPanelProductBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 1, 248, 118));

        jDashboardQLDH.add(jPanelBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, 120));

        jPanelHeaderBill.setBackground(new java.awt.Color(102, 178, 255));
        jPanelHeaderBill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeaderBill.setForeground(new java.awt.Color(255, 255, 255));
        jPanelHeaderBill.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBoxAllBill.setBackground(new java.awt.Color(102, 178, 255));
        jCheckBoxAllBill.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxAllBill.setBorder(null);
        jPanelHeaderBill.add(jCheckBoxAllBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 20, 20));

        jLabelTTBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTTBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTTBill.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTTBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTTBill.setText("Hóa đơn");
        jLabelTTBill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeaderBill.add(jLabelTTBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 40));

        jLabelStaffBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelStaffBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelStaffBill.setForeground(new java.awt.Color(0, 0, 0));
        jLabelStaffBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStaffBill.setText("Nhân viên");
        jPanelHeaderBill.add(jLabelStaffBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 160, 40));

        jLabelCustomerBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelCustomerBill.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCustomerBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerBill.setText("Khách hàng");
        jLabelCustomerBill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeaderBill.add(jLabelCustomerBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 180, 40));

        jLabelProductBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelProductBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelProductBill.setForeground(new java.awt.Color(0, 0, 0));
        jLabelProductBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProductBill.setText("Sản phẩm");
        jPanelHeaderBill.add(jLabelProductBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 250, 40));

        jLabelPriceBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPriceBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPriceBill.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPriceBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPriceBill.setText("Thành tiền");
        jLabelPriceBill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeaderBill.add(jLabelPriceBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 110, 40));

        jLabelDiscountBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDiscountBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDiscountBill.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDiscountBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDiscountBill.setText("Chiết khấu");
        jPanelHeaderBill.add(jLabelDiscountBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 110, 40));

        jLabelTotalBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTotalBill.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTotalBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalBill.setText("Tổng thu");
        jLabelTotalBill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelTotalBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelHeaderBill.add(jLabelTotalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 0, 110, 40));

        jLabelNoteBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNoteBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNoteBill.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNoteBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNoteBill.setText("Ghi chú");
        jPanelHeaderBill.add(jLabelNoteBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 170, 40));

        jLabelSettingBill.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingBill.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSettingBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSettingBill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeaderBill.add(jLabelSettingBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 0, 50, 40));

        jDashboardQLDH.add(jPanelHeaderBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, -1, -1));

        jPanelControlPageBill.setBackground(new java.awt.Color(255, 255, 255));

        jTextFieldPageBill.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPageBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldPageBill.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldPageBill.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldPageBill.setText("1");
        jTextFieldPageBill.setBorder(null);
        jTextFieldPageBill.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPageBillKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPageBillKeyReleased(evt);
            }
        });

        jLabelPageBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPageBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPageBill.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPageBill.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPageBill.setText("/4");

        jLabelRightPageBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelRightPageBill.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRightPageBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRightPageBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px.png"))); // NOI18N
        jLabelRightPageBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRightPageBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRightPageBillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelRightPageBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelRightPageBillMouseExited(evt);
            }
        });

        jLabelLeftPageBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLeftPageBill.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLeftPageBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLeftPageBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px_1.png"))); // NOI18N
        jLabelLeftPageBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelLeftPageBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLeftPageBillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelLeftPageBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelLeftPageBillMouseExited(evt);
            }
        });

        jLabelSkipToEndPageBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSkipToEndPageBill.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSkipToEndPageBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSkipToEndPageBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px_1.png"))); // NOI18N
        jLabelSkipToEndPageBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSkipToEndPageBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSkipToEndPageBillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSkipToEndPageBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSkipToEndPageBillMouseExited(evt);
            }
        });

        jLabelSkipToStartPageBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSkipToStartPageBill.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSkipToStartPageBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSkipToStartPageBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px_1.png"))); // NOI18N
        jLabelSkipToStartPageBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSkipToStartPageBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSkipToStartPageBillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSkipToStartPageBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSkipToStartPageBillMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelControlPageBillLayout = new javax.swing.GroupLayout(jPanelControlPageBill);
        jPanelControlPageBill.setLayout(jPanelControlPageBillLayout);
        jPanelControlPageBillLayout.setHorizontalGroup(
            jPanelControlPageBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControlPageBillLayout.createSequentialGroup()
                .addGap(586, 586, 586)
                .addComponent(jLabelSkipToStartPageBill)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLeftPageBill)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPageBill, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPageBill, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelRightPageBill)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSkipToEndPageBill)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelControlPageBillLayout.setVerticalGroup(
            jPanelControlPageBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelControlPageBillLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanelControlPageBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelSkipToStartPageBill)
                    .addComponent(jLabelSkipToEndPageBill)
                    .addComponent(jLabelLeftPageBill)
                    .addComponent(jLabelRightPageBill)
                    .addGroup(jPanelControlPageBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldPageBill)
                        .addComponent(jLabelPageBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jDashboardQLDH.add(jPanelControlPageBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 820, 1330, -1));

        jLabelSearchBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSearchBill.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelSearchBill.setForeground(new java.awt.Color(120, 120, 120));
        jLabelSearchBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_search_20px_1.png"))); // NOI18N
        jLabelSearchBill.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jDashboardQLDH.add(jLabelSearchBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 120, 30, 30));

        jTextFieldSearchBill.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldSearchBill.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldSearchBill.setForeground(new java.awt.Color(120, 120, 120));
        jTextFieldSearchBill.setText("Tìm kiếm");
        jTextFieldSearchBill.setBorder(null);
        jTextFieldSearchBill.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldSearchBill.setOpaque(false);
        jTextFieldSearchBill.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldSearchBillFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldSearchBillFocusLost(evt);
            }
        });
        jTextFieldSearchBill.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchBillKeyReleased(evt);
            }
        });
        jDashboardQLDH.add(jTextFieldSearchBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 120, 240, 30));

        jLabelFrameSearchBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameSearchBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDashboardQLDH.add(jLabelFrameSearchBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 120, 280, 30));

        add(jDashboardQLDH, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 870));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPageBillKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPageBillKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPageBillKeyPressed

    private void jTextFieldPageBillKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPageBillKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPageBillKeyReleased

    private void jLabelRightPageBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightPageBillMouseClicked
        int jlabelrighta = Integer.parseInt(jTextFieldPageBill.getText());
        int jlabelrightb = countBill / 5 + setPageBill;
        if (jlabelrighta < jlabelrightb) {
            jTextFieldPageBill.setText(String.valueOf(Integer.parseInt(jTextFieldPageBill.getText()) + 1));

            try {
                showBillList(ListBills, countBill);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(PanelBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jLabelRightPageBillMouseClicked

    private void jLabelRightPageBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightPageBillMouseEntered
        // TODO add your handling code here:
        jLabelRightPageBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px_1.png")));
    }//GEN-LAST:event_jLabelRightPageBillMouseEntered

    private void jLabelRightPageBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightPageBillMouseExited
        // TODO add your handling code here:
        jLabelRightPageBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px.png")));
    }//GEN-LAST:event_jLabelRightPageBillMouseExited

    private void jLabelLeftPageBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftPageBillMouseClicked
        if (Integer.parseInt(jTextFieldPageBill.getText()) > 1) {
            jTextFieldPageBill.setText(String.valueOf(Integer.parseInt(jTextFieldPageBill.getText()) - 1));
            try {
                showBillList(ListBills, countBill);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(PanelBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelLeftPageBillMouseClicked

    private void jLabelLeftPageBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftPageBillMouseEntered
        // TODO add your handling code here:
        jLabelLeftPageBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px.png")));
    }//GEN-LAST:event_jLabelLeftPageBillMouseEntered

    private void jLabelLeftPageBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftPageBillMouseExited
        // TODO add your handling code here:
        jLabelLeftPageBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px_1.png")));
    }//GEN-LAST:event_jLabelLeftPageBillMouseExited

    private void jLabelSkipToEndPageBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndPageBillMouseClicked
        int jlabelrighta = Integer.parseInt(jTextFieldPageBill.getText());
        int jlabelrightb = countBill / 5 + setPageBill;
        if (jlabelrighta < jlabelrightb) {
            jTextFieldPageBill.setText(String.valueOf(countBill / 5 + setPageBill));
            try {
                showBillList(ListBills, countBill);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(PanelBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelSkipToEndPageBillMouseClicked

    private void jLabelSkipToEndPageBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndPageBillMouseEntered
        // TODO add your handling code here:
        jLabelSkipToEndPageBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px.png")));
    }//GEN-LAST:event_jLabelSkipToEndPageBillMouseEntered

    private void jLabelSkipToEndPageBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndPageBillMouseExited
        // TODO add your handling code here:
        jLabelSkipToEndPageBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px_1.png")));
    }//GEN-LAST:event_jLabelSkipToEndPageBillMouseExited

    private void jLabelSkipToStartPageBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartPageBillMouseClicked
        if (Integer.parseInt(jTextFieldPageBill.getText()) > 1) {
            jTextFieldPageBill.setText("1");
            try {
                showBillList(ListBills, countBill);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(PanelBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelSkipToStartPageBillMouseClicked

    private void jLabelSkipToStartPageBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartPageBillMouseEntered
        // TODO add your handling code here:
        jLabelSkipToStartPageBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px.png")));
    }//GEN-LAST:event_jLabelSkipToStartPageBillMouseEntered

    private void jLabelSkipToStartPageBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartPageBillMouseExited
        // TODO add your handling code here:
        jLabelSkipToStartPageBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px_1.png")));
    }//GEN-LAST:event_jLabelSkipToStartPageBillMouseExited

    private void jTextFieldSearchBillFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchBillFocusGained
        jTextFieldSearchBill.setText("");
    }//GEN-LAST:event_jTextFieldSearchBillFocusGained

    private void jTextFieldSearchBillFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchBillFocusLost
        if (jTextFieldPageBill.getText().equals("")) {
            jTextFieldPageBill.setText("Tìm kiếm");
        }
    }//GEN-LAST:event_jTextFieldSearchBillFocusLost

    private void jTextFieldSearchBillKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchBillKeyReleased
        if (jTextFieldSearchBill.getText().equals("")) {
            try {
                ListBills = BillDao.findAllBill();
                countBill = BillDao.countBill();
                showBillList(ListBills, countBill);
                jTextFieldPageBill.setText("1");
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(PanelBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }

        } else {
            try {
                ListBills = BillDao.searchBill(jTextFieldSearchBill.getText());
                countBill = BillDao.countsearchBill(jTextFieldSearchBill.getText());
                showBillList(ListBills, countBill);
                jTextFieldPageBill.setText("1");
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(PanelBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTextFieldSearchBillKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBoxAllBill;
    private javax.swing.JCheckBox jCheckBoxAllBill1;
    private javax.swing.JCheckBox jCheckBoxAllBill2;
    private javax.swing.JCheckBox jCheckBoxAllBill3;
    private javax.swing.JCheckBox jCheckBoxAllBill4;
    private javax.swing.JCheckBox jCheckBoxAllBill5;
    private javax.swing.JPanel jDashboardQLDH;
    private javax.swing.JLabel jLabelCustomerAddressBill1;
    private javax.swing.JLabel jLabelCustomerAddressBill2;
    private javax.swing.JLabel jLabelCustomerAddressBill3;
    private javax.swing.JLabel jLabelCustomerAddressBill4;
    private javax.swing.JLabel jLabelCustomerAddressBill5;
    private javax.swing.JLabel jLabelCustomerBill;
    private javax.swing.JLabel jLabelCustomerNameBill1;
    private javax.swing.JLabel jLabelCustomerNameBill2;
    private javax.swing.JLabel jLabelCustomerNameBill3;
    private javax.swing.JLabel jLabelCustomerNameBill4;
    private javax.swing.JLabel jLabelCustomerNameBill5;
    private javax.swing.JLabel jLabelCustomerPhonenumberBill1;
    private javax.swing.JLabel jLabelCustomerPhonenumberBill2;
    private javax.swing.JLabel jLabelCustomerPhonenumberBill3;
    private javax.swing.JLabel jLabelCustomerPhonenumberBill4;
    private javax.swing.JLabel jLabelCustomerPhonenumberBill5;
    private javax.swing.JLabel jLabelDateBill1;
    private javax.swing.JLabel jLabelDateBill2;
    private javax.swing.JLabel jLabelDateBill3;
    private javax.swing.JLabel jLabelDateBill4;
    private javax.swing.JLabel jLabelDateBill5;
    private javax.swing.JLabel jLabelDiscountBill;
    private javax.swing.JLabel jLabelDiscountBill1;
    private javax.swing.JLabel jLabelDiscountBill2;
    private javax.swing.JLabel jLabelDiscountBill3;
    private javax.swing.JLabel jLabelDiscountBill4;
    private javax.swing.JLabel jLabelDiscountBill5;
    private javax.swing.JLabel jLabelFrameSearchBill;
    private javax.swing.JLabel jLabelIDStaffBill1;
    private javax.swing.JLabel jLabelIDStaffBill2;
    private javax.swing.JLabel jLabelIDStaffBill3;
    private javax.swing.JLabel jLabelIDStaffBill4;
    private javax.swing.JLabel jLabelIDStaffBill5;
    private javax.swing.JLabel jLabelIdBill1;
    private javax.swing.JLabel jLabelIdBill2;
    private javax.swing.JLabel jLabelIdBill3;
    private javax.swing.JLabel jLabelIdBill4;
    private javax.swing.JLabel jLabelIdBill5;
    private javax.swing.JLabel jLabelLeftPageBill;
    private javax.swing.JLabel jLabelNameStaffBill1;
    private javax.swing.JLabel jLabelNameStaffBill2;
    private javax.swing.JLabel jLabelNameStaffBill3;
    private javax.swing.JLabel jLabelNameStaffBill4;
    private javax.swing.JLabel jLabelNameStaffBill5;
    private javax.swing.JLabel jLabelNoteBill;
    private javax.swing.JLabel jLabelNoteBill1;
    private javax.swing.JLabel jLabelNoteBill2;
    private javax.swing.JLabel jLabelNoteBill3;
    private javax.swing.JLabel jLabelNoteBill4;
    private javax.swing.JLabel jLabelNoteBill5;
    private javax.swing.JLabel jLabelPageBill;
    private javax.swing.JLabel jLabelPriceBill;
    private javax.swing.JLabel jLabelPriceBill1;
    private javax.swing.JLabel jLabelPriceBill2;
    private javax.swing.JLabel jLabelPriceBill3;
    private javax.swing.JLabel jLabelPriceBill4;
    private javax.swing.JLabel jLabelPriceBill5;
    private javax.swing.JLabel jLabelProductBill;
    private javax.swing.JLabel jLabelProductBill1;
    private javax.swing.JLabel jLabelProductBill2;
    private javax.swing.JLabel jLabelProductBill3;
    private javax.swing.JLabel jLabelProductBill4;
    private javax.swing.JLabel jLabelProductBill5;
    private javax.swing.JLabel jLabelRightPageBill;
    private javax.swing.JLabel jLabelSearchBill;
    private javax.swing.JLabel jLabelSettingBill;
    private javax.swing.JLabel jLabelSettingBill1;
    private javax.swing.JLabel jLabelSettingBill2;
    private javax.swing.JLabel jLabelSettingBill3;
    private javax.swing.JLabel jLabelSettingBill4;
    private javax.swing.JLabel jLabelSettingBill5;
    private javax.swing.JLabel jLabelSkipToEndPageBill;
    private javax.swing.JLabel jLabelSkipToStartPageBill;
    private javax.swing.JLabel jLabelStaffBill;
    private javax.swing.JLabel jLabelTTBill;
    private javax.swing.JLabel jLabelTotalBill;
    private javax.swing.JLabel jLabelTotalPriceBill1;
    private javax.swing.JLabel jLabelTotalPriceBill2;
    private javax.swing.JLabel jLabelTotalPriceBill3;
    private javax.swing.JLabel jLabelTotalPriceBill4;
    private javax.swing.JLabel jLabelTotalPriceBill5;
    private javax.swing.JPanel jPanelBill1;
    private javax.swing.JPanel jPanelBill2;
    private javax.swing.JPanel jPanelBill3;
    private javax.swing.JPanel jPanelBill4;
    private javax.swing.JPanel jPanelBill5;
    private javax.swing.JPanel jPanelControlPageBill;
    private javax.swing.JPanel jPanelCustomerBill1;
    private javax.swing.JPanel jPanelCustomerBill2;
    private javax.swing.JPanel jPanelCustomerBill3;
    private javax.swing.JPanel jPanelCustomerBill4;
    private javax.swing.JPanel jPanelCustomerBill5;
    private javax.swing.JPanel jPanelHeaderBill;
    private javax.swing.JPanel jPanelProductBill1;
    private javax.swing.JPanel jPanelProductBill2;
    private javax.swing.JPanel jPanelProductBill3;
    private javax.swing.JPanel jPanelProductBill4;
    private javax.swing.JPanel jPanelProductBill5;
    private javax.swing.JPanel jPanelTTBill1;
    private javax.swing.JPanel jPanelTTBill2;
    private javax.swing.JPanel jPanelTTBill3;
    private javax.swing.JPanel jPanelTTBill4;
    private javax.swing.JPanel jPanelTTBill5;
    private javax.swing.JPanel jPanelTTStaffBill1;
    private javax.swing.JPanel jPanelTTStaffBill2;
    private javax.swing.JPanel jPanelTTStaffBill3;
    private javax.swing.JPanel jPanelTTStaffBill4;
    private javax.swing.JPanel jPanelTTStaffBill5;
    private javax.swing.JTextField jTextFieldPageBill;
    private javax.swing.JTextField jTextFieldSearchBill;
    // End of variables declaration//GEN-END:variables
}
