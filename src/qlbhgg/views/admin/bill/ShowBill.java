/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.views.admin.bill;

/**
 *
 * @author acer
 */
public class ShowBill extends javax.swing.JPanel {

    /**
     * Creates new form EditBill
     */
    public ShowBill() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelNote = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabelIdBill = new javax.swing.JLabel();
        jLabelDateBill = new javax.swing.JLabel();
        jLabelStaffBill = new javax.swing.JLabel();
        jLabelCustomerName = new javax.swing.JLabel();
        jLabelCustomerPhonenumber = new javax.swing.JLabel();
        jLabelCustomerAddress = new javax.swing.JLabel();
        jLabelCustomerEmail = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabelTotalPrice = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabelDiscount = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabelPrice = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabelHistoryEdit = new javax.swing.JLabel();
        jButtonEditBill = new javax.swing.JButton();
        jButtonDeleteBill = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCustomer = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 83, 1227, 10));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Ghi chú:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 690, -1, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Thông tin hóa đơn");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nhân viên bán hàng:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 140, -1));

        jLabelNote.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNote.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNote.setText("note: đã trả trước 200k");
        jPanel1.add(jLabelNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 750, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Ngày tạo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 80, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Khách hàng");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, -1, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Họ và tên:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Điện thoại:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 80, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Email:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 140, -1));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 10, 170));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Địa chỉ:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 140, -1));

        jLabelIdBill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIdBill.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIdBill.setText("?");
        jPanel1.add(jLabelIdBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, -1, -1));

        jLabelDateBill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDateBill.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDateBill.setText("?");
        jPanel1.add(jLabelDateBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 80, -1));

        jLabelStaffBill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelStaffBill.setForeground(new java.awt.Color(0, 0, 0));
        jLabelStaffBill.setText("?");
        jPanel1.add(jLabelStaffBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 140, -1));

        jLabelCustomerName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerName.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCustomerName.setText("?");
        jPanel1.add(jLabelCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, -1, -1));

        jLabelCustomerPhonenumber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerPhonenumber.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCustomerPhonenumber.setText("?");
        jPanel1.add(jLabelCustomerPhonenumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, 80, -1));

        jLabelCustomerAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerAddress.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCustomerAddress.setText("?");
        jPanel1.add(jLabelCustomerAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 140, -1));

        jLabelCustomerEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerEmail.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCustomerEmail.setText("?");
        jPanel1.add(jLabelCustomerEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 140, -1));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, 10, 170));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Thanh toán");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 110, -1, 40));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Tổng tiền:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 160, -1, -1));

        jLabelTotalPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalPrice.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTotalPrice.setText("?");
        jPanel1.add(jLabelTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 160, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Chiết khấu:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, 80, -1));

        jLabelDiscount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDiscount.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDiscount.setText("?");
        jPanel1.add(jLabelDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 190, 80, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Tổng thu:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 220, 100, -1));

        jLabelPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPrice.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPrice.setText("?");
        jPanel1.add(jLabelPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 220, 90, -1));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 120, 10, 170));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Lịch sử sửa đơn");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 110, -1, 40));

        jLabelHistoryEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelHistoryEdit.setForeground(new java.awt.Color(0, 0, 0));
        jLabelHistoryEdit.setText("Lịch sử");
        jPanel1.add(jLabelHistoryEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 170, 150, 80));

        jButtonEditBill.setBackground(new java.awt.Color(102, 178, 255));
        jButtonEditBill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonEditBill.setForeground(new java.awt.Color(0, 0, 0));
        jButtonEditBill.setText("Sửa");
        jPanel1.add(jButtonEditBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 60, -1, -1));

        jButtonDeleteBill.setBackground(new java.awt.Color(102, 178, 255));
        jButtonDeleteBill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonDeleteBill.setForeground(new java.awt.Color(0, 0, 0));
        jButtonDeleteBill.setText("Xóa");
        jPanel1.add(jButtonDeleteBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 60, -1, -1));

        jTableCustomer.setBackground(new java.awt.Color(255, 255, 255));
        jTableCustomer.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTableCustomer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableCustomer.setForeground(new java.awt.Color(0, 0, 0));
        jTableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "ádads", "chuột", "222", "1", "221"},
                {"2", "ssss", "bàn phím", "2", "1", "1"},
                {null, null, "Tổng", "224", "2", "222"}
            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Giá", "Chiết khấu", "Thành tiền"
            }
        ));
        jTableCustomer.setFocusable(false);
        jTableCustomer.setRowHeight(25);
        jTableCustomer.setSelectionBackground(new java.awt.Color(215, 220, 222));
        jTableCustomer.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTableCustomer.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableCustomer);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 1200, 370));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Thông tin hóa đơn");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, 40));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Mã hóa đơn:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDeleteBill;
    private javax.swing.JButton jButtonEditBill;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCustomerAddress;
    private javax.swing.JLabel jLabelCustomerEmail;
    private javax.swing.JLabel jLabelCustomerName;
    private javax.swing.JLabel jLabelCustomerPhonenumber;
    private javax.swing.JLabel jLabelDateBill;
    private javax.swing.JLabel jLabelDiscount;
    private javax.swing.JLabel jLabelHistoryEdit;
    private javax.swing.JLabel jLabelIdBill;
    private javax.swing.JLabel jLabelNote;
    private javax.swing.JLabel jLabelPrice;
    private javax.swing.JLabel jLabelStaffBill;
    private javax.swing.JLabel jLabelTotalPrice;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTableCustomer;
    // End of variables declaration//GEN-END:variables
}