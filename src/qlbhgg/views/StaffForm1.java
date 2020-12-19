/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.views;

import qlbhgg.views.admin.staff.EditStaff;
import qlbhgg.views.common.ChancePassword;
import qlbhgg.views.common.ConfirmOperations;
import qlbhgg.views.common.DisplayImage;
import qlbhgg.views.common.ConfirmDeleteStaff;
import qlbhgg.views.login.LoginForm;
import qlbhgg.views.admin.AdminForm;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import qlbhgg.dao.UsersDao;
import qlbhgg.dao.GoodsDao;
import qlbhgg.dao.TypeOfGoodDao;
import qlbhgg.dao.WorkDayDao;
import qlbhgg.dao.BillDao;
import qlbhgg.dao.CustomerDao;
import qlbhgg.dao.InvoicedetailsDao;
import qlbhgg.dao.SupplierDao;

import qlbhgg.models.Bill;
import qlbhgg.models.Customers;
import qlbhgg.models.Goods;
import qlbhgg.models.Users;
import qlbhgg.models.WorkDay;
import qlbhgg.models.Invoicedetails;
import qlbhgg.models.Suppliers;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author acer
 */
public final class StaffForm1 extends javax.swing.JFrame {

    /**
     * Creates new form AdminForm
     */
    DefaultTableModel tableModel;
    public int XX, YY;
    public boolean qlhd, qlk = false, qlnv = false, qlncc = false, tk = false, ttkh = false, profile = false;
    public ArrayList<Goods> ListGoods = GoodsDao.findAll();
    public ArrayList<Users> ListUsers = UsersDao.findStaff();
    public ArrayList<Bill> ListBills = BillDao.findAllBill();
    public ArrayList<Suppliers> ListSuppliers = SupplierDao.findAllSupplier();
    public ArrayList<Customers> ListCustomers = CustomerDao.findAllCustomer();
    public ArrayList<WorkDay> ListWorkday = new ArrayList<>();
    private final ArrayList<JLabel> ListLabelDaysCalendar = new ArrayList<JLabel>();
    public int countProduct = GoodsDao.countProduct();
    public int countStaff = UsersDao.countStaff();
    public int countBill = BillDao.countBill();
    public int countSupplier = SupplierDao.countSupplier();
    public int setPageProduct, setPageStaff, setPageBill, setPageSupplier, setPageCustomer;
    public int thisStaff;

    Calendar cal = new GregorianCalendar();
    public int selectedMonth = cal.get(Calendar.MONTH);
    public int selectedYear = cal.get(Calendar.YEAR);
    public int dayEarlier = 0;
    public int numberOfWorking;
    public Users u, userLogin;

    public StaffForm1(Users user) throws SQLException {
        userLogin = user;
        startingState();
    }

    public void startingState() throws SQLException {
        this.qlhd = true;
        initComponents3();
        initComponents2();
        initComponents();

        jTableCustomer.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
        jTableCustomer.getTableHeader().setOpaque(false);
        jTableCustomer.getTableHeader().setBackground(new Color(102, 178, 255));
        jTableCustomer.setRowHeight(25);
        jPanelQLDH.setBackground(new java.awt.Color(102, 178, 255));
        jPanelBody.removeAll();
        jPanelBody.repaint();
        jPanelBody.revalidate();
        jPanelBody.add(jDashboardQLDH);
        jPanelBody.repaint();
        jPanelBody.revalidate();
        showBillList(ListBills, countBill);
        showTableCustomer();
        addLabelDays();
        jLabelUserLogin.setText(userLogin.getFullname());
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
        setPageBill = (countStaff % 5 == 0) ? 0 : 1;
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

    

    public void showCalendar() throws SQLException {
        numberOfWorking = WorkDayDao.countWorkDay(u.getId(), selectedMonth + 1, selectedYear);
        String titleCalendar = "Tháng " + String.valueOf(selectedMonth + 1) + " - " + String.valueOf(selectedYear);
        jLabelNumberOfWorking.setText("- Số buổi: " + String.valueOf(numberOfWorking) + "/28");
        jPanelCalendar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, titleCalendar, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(153, 153, 255))); // NOI18N
        for (int i = 41; i > 34; i--) {
            ListLabelDaysCalendar.get(i).setText("");
        }
        ListLabelDaysCalendar.get(dayEarlier).setBackground(new java.awt.Color(255, 255, 255));
        jLabelTitleStatistical.setText("Bảng công và doanh số: " + titleCalendar);

        int cDay = cal.get(Calendar.DATE);
        int cMonth = cal.get(Calendar.MONTH);
        int cYear = cal.get(Calendar.YEAR);
        GregorianCalendar gCal = new GregorianCalendar(selectedYear, selectedMonth, 1);
        int days = gCal.getActualMaximum(Calendar.DATE);
        int startInWeek = gCal.get(Calendar.DAY_OF_WEEK);

        gCal = new GregorianCalendar(selectedYear, selectedMonth, days);
        int totalweeks = gCal.getActualMaximum(Calendar.WEEK_OF_MONTH);

        int count = 1;

        for (int i = 1; i <= totalweeks; i++) {
            for (int j = 1; j <= 7; j++) {
                ListLabelDaysCalendar.get(count - 1).setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                if (selectedMonth <= cMonth && selectedYear <= cYear) {
                    if ((selectedYear <= cYear && selectedMonth < cMonth) || selectedYear < cYear) {
                        ListLabelDaysCalendar.get(count - 1).setForeground(new java.awt.Color(207, 40, 40));
                    } else if ((count - startInWeek + 1) < cDay) {
                        ListLabelDaysCalendar.get(count - 1).setForeground(new java.awt.Color(207, 40, 40));
                    } else {
                        ListLabelDaysCalendar.get(count - 1).setForeground(new java.awt.Color(0, 0, 0));
                    }
                    for (WorkDay workDay : ListWorkday) {
                        if (workDay.getWorkday().getDate() == (count - startInWeek + 1) && workDay.getWorkday().getMonth() == selectedMonth && (workDay.getWorkday().getYear() + 1900) == selectedYear) {
                            ListLabelDaysCalendar.get(count - 1).setForeground(new java.awt.Color(12, 194, 105));
                            ListLabelDaysCalendar.get(count - 1).setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(12, 194, 105)));
                        }
                    }
                } else {
                    ListLabelDaysCalendar.get(count - 1).setForeground(new java.awt.Color(0, 0, 0));
                }
                if (count < startInWeek || (count - startInWeek + 1) > 31) {
                    ListLabelDaysCalendar.get(count - 1).setText("");
                } else {
                    if (cDay == (count - startInWeek + 1) && cMonth == selectedMonth && cYear == selectedYear) {
                        ListLabelDaysCalendar.get(count - 1).setOpaque(true);
                        ListLabelDaysCalendar.get(count - 1).setText(String.valueOf(count - startInWeek + 1));
                        ListLabelDaysCalendar.get(count - 1).setBackground(new java.awt.Color(156, 176, 253));
                        dayEarlier = count - 1;
                    } else {
                        ListLabelDaysCalendar.get(count - 1).setText(String.valueOf(count - startInWeek + 1));
                    }
                }
                count++;
            }
        }
    }

    public void showTableCustomer() {
        jLabelFrameSearchCustomer.setIcon(scaleFrameSearch("/Image/FrameSearch.png"));
        DefaultTableModel tblModel = (DefaultTableModel) jTableCustomer.getModel();
        for (Customers c : ListCustomers) {
            String row[] = {c.getCustomercode(), c.getCustomername(), c.getTradingname(), c.getAddress(), c.getEmail(), c.getPhonenumber()};
            tblModel.addRow(row);
        }
    }

    public void addLabelDays() {
        ListLabelDaysCalendar.add(jLabelDayCalendar1);
        ListLabelDaysCalendar.add(jLabelDayCalendar2);
        ListLabelDaysCalendar.add(jLabelDayCalendar3);
        ListLabelDaysCalendar.add(jLabelDayCalendar4);
        ListLabelDaysCalendar.add(jLabelDayCalendar5);
        ListLabelDaysCalendar.add(jLabelDayCalendar6);
        ListLabelDaysCalendar.add(jLabelDayCalendar7);
        ListLabelDaysCalendar.add(jLabelDayCalendar8);
        ListLabelDaysCalendar.add(jLabelDayCalendar9);
        ListLabelDaysCalendar.add(jLabelDayCalendar10);
        ListLabelDaysCalendar.add(jLabelDayCalendar11);
        ListLabelDaysCalendar.add(jLabelDayCalendar12);
        ListLabelDaysCalendar.add(jLabelDayCalendar13);
        ListLabelDaysCalendar.add(jLabelDayCalendar14);
        ListLabelDaysCalendar.add(jLabelDayCalendar15);
        ListLabelDaysCalendar.add(jLabelDayCalendar16);
        ListLabelDaysCalendar.add(jLabelDayCalendar17);
        ListLabelDaysCalendar.add(jLabelDayCalendar18);
        ListLabelDaysCalendar.add(jLabelDayCalendar19);
        ListLabelDaysCalendar.add(jLabelDayCalendar20);
        ListLabelDaysCalendar.add(jLabelDayCalendar21);
        ListLabelDaysCalendar.add(jLabelDayCalendar22);
        ListLabelDaysCalendar.add(jLabelDayCalendar23);
        ListLabelDaysCalendar.add(jLabelDayCalendar24);
        ListLabelDaysCalendar.add(jLabelDayCalendar25);
        ListLabelDaysCalendar.add(jLabelDayCalendar26);
        ListLabelDaysCalendar.add(jLabelDayCalendar27);
        ListLabelDaysCalendar.add(jLabelDayCalendar28);
        ListLabelDaysCalendar.add(jLabelDayCalendar29);
        ListLabelDaysCalendar.add(jLabelDayCalendar30);
        ListLabelDaysCalendar.add(jLabelDayCalendar31);
        ListLabelDaysCalendar.add(jLabelDayCalendar32);
        ListLabelDaysCalendar.add(jLabelDayCalendar33);
        ListLabelDaysCalendar.add(jLabelDayCalendar34);
        ListLabelDaysCalendar.add(jLabelDayCalendar35);
        ListLabelDaysCalendar.add(jLabelDayCalendar36);
        ListLabelDaysCalendar.add(jLabelDayCalendar37);
        ListLabelDaysCalendar.add(jLabelDayCalendar38);
        ListLabelDaysCalendar.add(jLabelDayCalendar39);
        ListLabelDaysCalendar.add(jLabelDayCalendar40);
        ListLabelDaysCalendar.add(jLabelDayCalendar41);
        ListLabelDaysCalendar.add(jLabelDayCalendar42);
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
    private void renderJDashboardProfile() throws SQLException {
        
        ListWorkday = WorkDayDao.findByUsername(userLogin);
        selectedMonth = cal.get(Calendar.MONTH);
        selectedYear = cal.get(Calendar.YEAR);
        u = userLogin;
        showCalendar();
        jLabelInformationNameStaff.setText(userLogin.getFullname());
        jLabelAvatarStaff.setIcon(scaleImformationAvatar(u.getImage_user()));
        jLabelInformationId.setText(userLogin.getId());
        jLabelInformationUsername.setText(userLogin.getUsername());
        jLabelInformationGender.setText(userLogin.getGender());
        if (u.getGender().equals("Nam")) {
            jLabelInformationGender1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_25px.png")));
        } else {
            jLabelInformationGender1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_female_25px.png")));
        }
        jLabelInformationBirthday.setText(userLogin.getBirthday().toString());
        jLabelInformationStartdate.setText(userLogin.getStartdate().toString());
        jLabelInformationAddress.setText(userLogin.getAddress());
        jLabelInformationEmail.setText(userLogin.getEmail());
        jLabelInformationPhonenumber.setText(userLogin.getPhonenumber());
        jLabelInformationBasicsalary.setText(String.format("%1$,.0f" + " VNĐ", userLogin.getBasicsalary()));
        jLabelInformationAllowance.setText(String.format("%1$,.0f" + " VNĐ", userLogin.getAllowance()));
        jLabelBBButtonEditStaff.setIcon(scaleButtonEdit("/Image/ButtonEditLight.png"));
        jLabelButtonEditStaff.setText("Sửa thông tin cá nhân");
        jLabelBBButtonEditPassword.setIcon(scaleButtonEdit("/Image/ButtonEditLight.png"));
        jLabelBackToQLNV.setText("Quay lại");
        jLabelButtonEditPassword.setVisible(true);
        jLabelBBButtonEditPassword.setVisible(true);
        jLabelButtonDeleteStaff.setVisible(false);
        jLabelBBButtonDeleteStaff.setVisible(false);
        jLabelButtonStatusStaff.setVisible(false);
        jLabelBBButtonStatusStaff.setVisible(false);
    }

    public void popUpImageStaff(Users u) {
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
    private void initComponents2() {

        
    }
    //markinit

    private void initComponents3() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBackground = new javax.swing.JPanel();
        btnExit = new javax.swing.JLabel();
        btnMinimize = new javax.swing.JLabel();
        jPanelMenu = new javax.swing.JPanel();
        jLabelLogout = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanelQLBH = new javax.swing.JPanel();
        jLabelQLBH = new javax.swing.JLabel();
        jPanelQLDH = new javax.swing.JPanel();
        jLabelQLDH = new javax.swing.JLabel();
        jPanelTTKH = new javax.swing.JPanel();
        jLabelTTKH = new javax.swing.JLabel();
        jPanelTK = new javax.swing.JPanel();
        jLabelTK = new javax.swing.JLabel();
        jPanelBody = new javax.swing.JPanel();
        jDashboardQLBH = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
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
        jDashboardTTKH = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCustomer = new javax.swing.JTable();
        jTextFieldSearchCustomer = new javax.swing.JTextField();
        jLabelSearchCustomer = new javax.swing.JLabel();
        jLabelFrameSearchCustomer = new javax.swing.JLabel();
        jDashboardTK = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jDashboardProfile = new javax.swing.JPanel();
        jLabelButtonEditPassword = new javax.swing.JLabel();
        jLabelBBButtonEditPassword = new javax.swing.JLabel();
        jLabelButtonDeleteStaff = new javax.swing.JLabel();
        jLabelBBButtonDeleteStaff = new javax.swing.JLabel();
        jLabelButtonStatusStaff = new javax.swing.JLabel();
        jLabelBBButtonStatusStaff = new javax.swing.JLabel();
        jLabelBackToQLNV = new javax.swing.JLabel();
        jLabelButtonEditStaff = new javax.swing.JLabel();
        jLabelBBButtonEditStaff = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabelFrameAvatar = new javax.swing.JLabel();
        jLabelAvatarStaff = new javax.swing.JLabel();
        jLabelInformationNameStaff = new javax.swing.JLabel();
        jLabelTT = new javax.swing.JLabel();
        jLabelInformationUsername = new javax.swing.JLabel();
        jLabelInformationId = new javax.swing.JLabel();
        jLabelInformationGender = new javax.swing.JLabel();
        jLabelInformationBirthday = new javax.swing.JLabel();
        jLabelInformationStartdate = new javax.swing.JLabel();
        jLabelInformationAddress = new javax.swing.JLabel();
        jLabelInformationPhonenumber = new javax.swing.JLabel();
        jLabelInformationEmail = new javax.swing.JLabel();
        jLabelInformationBasicsalary = new javax.swing.JLabel();
        jLabelInformationAllowance = new javax.swing.JLabel();
        jLabelInformationId1 = new javax.swing.JLabel();
        jLabelInformationUsername1 = new javax.swing.JLabel();
        jLabelInformationGender1 = new javax.swing.JLabel();
        jLabelInformationBirthday1 = new javax.swing.JLabel();
        jLabelInformationStartdate1 = new javax.swing.JLabel();
        jLabelInformationAddress1 = new javax.swing.JLabel();
        jLabelInformationEmail1 = new javax.swing.JLabel();
        jLabelInformationPhonenumber1 = new javax.swing.JLabel();
        jLabelInformationBasicsalary1 = new javax.swing.JLabel();
        jLabelInformationAllowance1 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabelPreviousYear = new javax.swing.JLabel();
        jPanelCalendar = new javax.swing.JPanel();
        jLabelDayCalendar43 = new javax.swing.JLabel();
        jLabelDayCalendar44 = new javax.swing.JLabel();
        jLabelDayCalendar45 = new javax.swing.JLabel();
        jLabelDayCalendar46 = new javax.swing.JLabel();
        jLabelDayCalendar47 = new javax.swing.JLabel();
        jLabelDayCalendar48 = new javax.swing.JLabel();
        jLabelDayCalendar49 = new javax.swing.JLabel();
        jLabelDayCalendar1 = new javax.swing.JLabel();
        jLabelDayCalendar2 = new javax.swing.JLabel();
        jLabelDayCalendar3 = new javax.swing.JLabel();
        jLabelDayCalendar4 = new javax.swing.JLabel();
        jLabelDayCalendar5 = new javax.swing.JLabel();
        jLabelDayCalendar6 = new javax.swing.JLabel();
        jLabelDayCalendar7 = new javax.swing.JLabel();
        jLabelDayCalendar8 = new javax.swing.JLabel();
        jLabelDayCalendar9 = new javax.swing.JLabel();
        jLabelDayCalendar10 = new javax.swing.JLabel();
        jLabelDayCalendar11 = new javax.swing.JLabel();
        jLabelDayCalendar12 = new javax.swing.JLabel();
        jLabelDayCalendar13 = new javax.swing.JLabel();
        jLabelDayCalendar14 = new javax.swing.JLabel();
        jLabelDayCalendar15 = new javax.swing.JLabel();
        jLabelDayCalendar16 = new javax.swing.JLabel();
        jLabelDayCalendar17 = new javax.swing.JLabel();
        jLabelDayCalendar18 = new javax.swing.JLabel();
        jLabelDayCalendar19 = new javax.swing.JLabel();
        jLabelDayCalendar20 = new javax.swing.JLabel();
        jLabelDayCalendar21 = new javax.swing.JLabel();
        jLabelDayCalendar22 = new javax.swing.JLabel();
        jLabelDayCalendar23 = new javax.swing.JLabel();
        jLabelDayCalendar24 = new javax.swing.JLabel();
        jLabelDayCalendar25 = new javax.swing.JLabel();
        jLabelDayCalendar26 = new javax.swing.JLabel();
        jLabelDayCalendar27 = new javax.swing.JLabel();
        jLabelDayCalendar28 = new javax.swing.JLabel();
        jLabelDayCalendar29 = new javax.swing.JLabel();
        jLabelDayCalendar30 = new javax.swing.JLabel();
        jLabelDayCalendar31 = new javax.swing.JLabel();
        jLabelDayCalendar32 = new javax.swing.JLabel();
        jLabelDayCalendar33 = new javax.swing.JLabel();
        jLabelDayCalendar34 = new javax.swing.JLabel();
        jLabelDayCalendar35 = new javax.swing.JLabel();
        jLabelDayCalendar36 = new javax.swing.JLabel();
        jLabelDayCalendar37 = new javax.swing.JLabel();
        jLabelDayCalendar38 = new javax.swing.JLabel();
        jLabelDayCalendar39 = new javax.swing.JLabel();
        jLabelDayCalendar40 = new javax.swing.JLabel();
        jLabelDayCalendar41 = new javax.swing.JLabel();
        jLabelDayCalendar42 = new javax.swing.JLabel();
        jLabelNextYear = new javax.swing.JLabel();
        jLabelTitleStatistical = new javax.swing.JLabel();
        jLabelNumberOfWorking = new javax.swing.JLabel();
        jLabelNumberOfStatistical = new javax.swing.JLabel();
        jLabelNumberOfSalary = new javax.swing.JLabel();
        jLabelPreviousMonth = new javax.swing.JLabel();
        jLabelNextMonth = new javax.swing.JLabel();
        jLabelNameCalendar = new javax.swing.JLabel();
        jLabelUserLogin = new javax.swing.JLabel();

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

        btnExit.setBackground(new java.awt.Color(255, 255, 255));
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_close_window_25px_2.png"))); // NOI18N
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
        jBackground.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1567, 0, 30, 30));

        btnMinimize.setBackground(new java.awt.Color(255, 255, 255));
        btnMinimize.setForeground(new java.awt.Color(255, 255, 255));
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
        jBackground.add(btnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1545, 0, 20, 30));

        jPanelMenu.setBackground(new java.awt.Color(0, 0, 0));
        jPanelMenu.setForeground(new java.awt.Color(0, 0, 0));
        jPanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelLogout.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogout.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelLogout.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_logout_rounded_left_20px_1.png"))); // NOI18N
        jLabelLogout.setText("Đăng xuất");
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

        jPanelQLBH.setBackground(new java.awt.Color(0, 0, 0));
        jPanelQLBH.setForeground(new java.awt.Color(0, 0, 0));
        jPanelQLBH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelQLBH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelQLBHMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelQLBHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelQLBHMouseExited(evt);
            }
        });

        jLabelQLBH.setBackground(new java.awt.Color(255, 255, 255));
        jLabelQLBH.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelQLBH.setForeground(new java.awt.Color(255, 255, 255));
        jLabelQLBH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelQLBH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_online_shop_sale_30px.png"))); // NOI18N
        jLabelQLBH.setText("  Quản lý bán hàng");

        javax.swing.GroupLayout jPanelQLBHLayout = new javax.swing.GroupLayout(jPanelQLBH);
        jPanelQLBH.setLayout(jPanelQLBHLayout);
        jPanelQLBHLayout.setHorizontalGroup(
            jPanelQLBHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQLBHLayout.createSequentialGroup()
                .addComponent(jLabelQLBH, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 37, Short.MAX_VALUE))
        );
        jPanelQLBHLayout.setVerticalGroup(
            jPanelQLBHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelQLBH, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelQLBH, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 270, 60));

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
                .addComponent(jLabelQLDH, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 41, Short.MAX_VALUE))
        );
        jPanelQLDHLayout.setVerticalGroup(
            jPanelQLDHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQLDHLayout.createSequentialGroup()
                .addComponent(jLabelQLDH, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelMenu.add(jPanelQLDH, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 270, 60));

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

        jPanelMenu.add(jPanelTTKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 270, 60));

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
                .addComponent(jLabelTK, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 101, Short.MAX_VALUE))
        );
        jPanelTKLayout.setVerticalGroup(
            jPanelTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTKLayout.createSequentialGroup()
                .addComponent(jLabelTK, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelMenu.add(jPanelTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 270, 60));

        jBackground.add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 900));

        jPanelBody.setLayout(new java.awt.CardLayout());

        jDashboardQLBH.setBackground(new java.awt.Color(255, 255, 255));
        jDashboardQLBH.setForeground(new java.awt.Color(255, 153, 153));
        jDashboardQLBH.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đã chọn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 341, Short.MAX_VALUE)
        );

        jDashboardQLBH.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 990, 370));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thanh toán", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 761, Short.MAX_VALUE)
        );

        jDashboardQLBH.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 340, 790));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chọn sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );

        jDashboardQLBH.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 420));

        jPanelBody.add(jDashboardQLBH, "card5");

        jDashboardQLDH.setBackground(new java.awt.Color(255, 255, 255));
        jDashboardQLDH.setForeground(new java.awt.Color(153, 255, 153));
        jDashboardQLDH.setPreferredSize(new java.awt.Dimension(1330, 790));
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

        jDashboardQLDH.add(jPanelBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, -1, 120));

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

        jDashboardQLDH.add(jPanelBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, -1, 120));

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

        jDashboardQLDH.add(jPanelBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, -1, 120));

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

        jDashboardQLDH.add(jPanelBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, -1, 120));

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

        jDashboardQLDH.add(jPanelBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, 120));

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

        jDashboardQLDH.add(jPanelHeaderBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));

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

        jDashboardQLDH.add(jPanelControlPageBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 740, 1330, -1));

        jLabelSearchBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSearchBill.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelSearchBill.setForeground(new java.awt.Color(120, 120, 120));
        jLabelSearchBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_search_20px_1.png"))); // NOI18N
        jLabelSearchBill.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jDashboardQLDH.add(jLabelSearchBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 40, 30, 30));

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
        jDashboardQLDH.add(jTextFieldSearchBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 40, 240, 30));

        jLabelFrameSearchBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameSearchBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDashboardQLDH.add(jLabelFrameSearchBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 40, 280, 30));

        jPanelBody.add(jDashboardQLDH, "card4");

        jDashboardTTKH.setBackground(new java.awt.Color(255, 255, 255));
        jDashboardTTKH.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableCustomer.setBackground(new java.awt.Color(255, 255, 255));
        jTableCustomer.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTableCustomer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableCustomer.setForeground(new java.awt.Color(0, 0, 0));
        jTableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Giao dịch", "Địa chỉ", "Email", "Số điện thoại"
            }
        ));
        jTableCustomer.setFocusable(false);
        jTableCustomer.setRowHeight(25);
        jTableCustomer.setSelectionBackground(new java.awt.Color(215, 220, 222));
        jTableCustomer.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTableCustomer.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableCustomer);
        if (jTableCustomer.getColumnModel().getColumnCount() > 0) {
            jTableCustomer.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        jDashboardTTKH.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1330, 710));

        jTextFieldSearchCustomer.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldSearchCustomer.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldSearchCustomer.setForeground(new java.awt.Color(120, 120, 120));
        jTextFieldSearchCustomer.setText("Tìm kiếm");
        jTextFieldSearchCustomer.setBorder(null);
        jTextFieldSearchCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldSearchCustomer.setOpaque(false);
        jTextFieldSearchCustomer.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldSearchCustomerFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldSearchCustomerFocusLost(evt);
            }
        });
        jTextFieldSearchCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchCustomerKeyReleased(evt);
            }
        });
        jDashboardTTKH.add(jTextFieldSearchCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 40, 240, 30));

        jLabelSearchCustomer.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSearchCustomer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelSearchCustomer.setForeground(new java.awt.Color(120, 120, 120));
        jLabelSearchCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_search_20px_1.png"))); // NOI18N
        jLabelSearchCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jDashboardTTKH.add(jLabelSearchCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 40, 30, 30));

        jLabelFrameSearchCustomer.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameSearchCustomer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDashboardTTKH.add(jLabelFrameSearchCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 40, 280, 30));

        jPanelBody.add(jDashboardTTKH, "card8");

        jDashboardTK.setBackground(new java.awt.Color(215, 220, 222));
        jDashboardTK.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );

        jDashboardTK.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 290, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );

        jDashboardTK.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 420, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );

        jDashboardTK.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 430, -1));

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        jDashboardTK.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 210, 90));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );

        jDashboardTK.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 430, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );

        jDashboardTK.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 70, -1, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        jDashboardTK.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 200, 90));

        jPanel8.setBackground(new java.awt.Color(126, 157, 177));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        jDashboardTK.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 200, 110));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        jDashboardTK.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 210, 110));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );

        jDashboardTK.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 420, -1));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );

        jDashboardTK.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 510, 430, -1));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );

        jDashboardTK.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 510, -1, -1));

        jPanelBody.add(jDashboardTK, "card5");

        jDashboardProfile.setBackground(new java.awt.Color(255, 255, 255));
        jDashboardProfile.setForeground(new java.awt.Color(255, 255, 255));
        jDashboardProfile.setPreferredSize(new java.awt.Dimension(1330, 790));
        jDashboardProfile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelButtonEditPassword.setBackground(new java.awt.Color(255, 255, 255));
        jLabelButtonEditPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelButtonEditPassword.setForeground(new java.awt.Color(0, 0, 0));
        jLabelButtonEditPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelButtonEditPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_password_25px.png"))); // NOI18N
        jLabelButtonEditPassword.setText("Đổi mật khẩu");
        jLabelButtonEditPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelButtonEditPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelButtonEditPasswordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelButtonEditPasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelButtonEditPasswordMouseExited(evt);
            }
        });
        jDashboardProfile.add(jLabelButtonEditPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 20, 270, 40));

        jLabelBBButtonEditPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBBButtonEditPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jDashboardProfile.add(jLabelBBButtonEditPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 20, 270, 40));

        jLabelButtonDeleteStaff.setBackground(new java.awt.Color(255, 255, 255));
        jLabelButtonDeleteStaff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelButtonDeleteStaff.setForeground(new java.awt.Color(0, 0, 0));
        jLabelButtonDeleteStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelButtonDeleteStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelButtonDeleteStaff.setText("Xóa nhân viên");
        jLabelButtonDeleteStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelButtonDeleteStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelButtonDeleteStaffMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelButtonDeleteStaffMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelButtonDeleteStaffMouseExited(evt);
            }
        });
        jDashboardProfile.add(jLabelButtonDeleteStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 270, 40));

        jLabelBBButtonDeleteStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBBButtonDeleteStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jDashboardProfile.add(jLabelBBButtonDeleteStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 270, 40));

        jLabelButtonStatusStaff.setBackground(new java.awt.Color(255, 255, 255));
        jLabelButtonStatusStaff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelButtonStatusStaff.setForeground(new java.awt.Color(51, 255, 51));
        jLabelButtonStatusStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelButtonStatusStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px.png"))); // NOI18N
        jLabelButtonStatusStaff.setText("Hoạt động");
        jLabelButtonStatusStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelButtonStatusStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelButtonStatusStaffMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelButtonStatusStaffMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelButtonStatusStaffMouseExited(evt);
            }
        });
        jDashboardProfile.add(jLabelButtonStatusStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 270, 40));

        jLabelBBButtonStatusStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBBButtonStatusStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jDashboardProfile.add(jLabelBBButtonStatusStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 270, 40));

        jLabelBackToQLNV.setBackground(new java.awt.Color(255, 255, 255));
        jLabelBackToQLNV.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabelBackToQLNV.setForeground(new java.awt.Color(0, 0, 0));
        jLabelBackToQLNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_back_20px.png"))); // NOI18N
        jLabelBackToQLNV.setText("Quản lý nhân viên");
        jLabelBackToQLNV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelBackToQLNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBackToQLNVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelBackToQLNVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelBackToQLNVMouseExited(evt);
            }
        });
        jDashboardProfile.add(jLabelBackToQLNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 220, 40));

        jLabelButtonEditStaff.setBackground(new java.awt.Color(255, 255, 255));
        jLabelButtonEditStaff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelButtonEditStaff.setForeground(new java.awt.Color(0, 0, 0));
        jLabelButtonEditStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelButtonEditStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png"))); // NOI18N
        jLabelButtonEditStaff.setText("Sửa thông tin nhân viên");
        jLabelButtonEditStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelButtonEditStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelButtonEditStaffMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelButtonEditStaffMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelButtonEditStaffMouseExited(evt);
            }
        });
        jDashboardProfile.add(jLabelButtonEditStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 270, 40));

        jLabelBBButtonEditStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBBButtonEditStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jDashboardProfile.add(jLabelBBButtonEditStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 270, 40));
        jDashboardProfile.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 1230, 10));

        jLabelFrameAvatar.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameAvatar.setForeground(new java.awt.Color(0, 0, 0));
        jLabelFrameAvatar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFrameAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/FrameAvatar.png"))); // NOI18N
        jLabelFrameAvatar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelFrameAvatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelFrameAvatarMouseClicked(evt);
            }
        });
        jDashboardProfile.add(jLabelFrameAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 200, 200));

        jLabelAvatarStaff.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatarStaff.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatarStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDashboardProfile.add(jLabelAvatarStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 200, 200));

        jLabelInformationNameStaff.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationNameStaff.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabelInformationNameStaff.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationNameStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInformationNameStaff.setText("Phạm Duy Tài");
        jDashboardProfile.add(jLabelInformationNameStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 240, -1));

        jLabelTT.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTT.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabelTT.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTT.setText(" / Thông tin chi tiết:");
        jLabelTT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jDashboardProfile.add(jLabelTT, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 220, 40));

        jLabelInformationUsername.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationUsername.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelInformationUsername.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationUsername.setText("Tên đăng nhập:");
        jDashboardProfile.add(jLabelInformationUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 440, 30));

        jLabelInformationId.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationId.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelInformationId.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationId.setText("Mã nhân viên:");
        jDashboardProfile.add(jLabelInformationId, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 440, 30));

        jLabelInformationGender.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationGender.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelInformationGender.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationGender.setText("Giới tính:");
        jDashboardProfile.add(jLabelInformationGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, 440, 30));

        jLabelInformationBirthday.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationBirthday.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelInformationBirthday.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationBirthday.setText("Ngày sinh:");
        jDashboardProfile.add(jLabelInformationBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, 440, 30));

        jLabelInformationStartdate.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationStartdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelInformationStartdate.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationStartdate.setText("Ngày bắt đầu:");
        jDashboardProfile.add(jLabelInformationStartdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, 440, 30));

        jLabelInformationAddress.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationAddress.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelInformationAddress.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationAddress.setText("Địa chỉ:");
        jDashboardProfile.add(jLabelInformationAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 580, 440, 30));

        jLabelInformationPhonenumber.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationPhonenumber.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelInformationPhonenumber.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationPhonenumber.setText("Số điện thoại:");
        jDashboardProfile.add(jLabelInformationPhonenumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 660, 440, 30));

        jLabelInformationEmail.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationEmail.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelInformationEmail.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationEmail.setText("Email:");
        jDashboardProfile.add(jLabelInformationEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 620, 440, 30));

        jLabelInformationBasicsalary.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationBasicsalary.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelInformationBasicsalary.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationBasicsalary.setText("Lương cơ bản:");
        jDashboardProfile.add(jLabelInformationBasicsalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 700, 440, 30));

        jLabelInformationAllowance.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationAllowance.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelInformationAllowance.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationAllowance.setText("Trợ cấp:");
        jDashboardProfile.add(jLabelInformationAllowance, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 740, 440, 30));

        jLabelInformationId1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationId1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationId1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationId1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_identification_documents_25px.png"))); // NOI18N
        jLabelInformationId1.setText("Mã nhân viên:");
        jDashboardProfile.add(jLabelInformationId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 160, 30));

        jLabelInformationUsername1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationUsername1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationUsername1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationUsername1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_name_25px.png"))); // NOI18N
        jLabelInformationUsername1.setText("Tên đăng nhập:");
        jDashboardProfile.add(jLabelInformationUsername1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 160, 30));

        jLabelInformationGender1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationGender1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationGender1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationGender1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_25px.png"))); // NOI18N
        jLabelInformationGender1.setText("Giới tính:");
        jDashboardProfile.add(jLabelInformationGender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 120, 30));

        jLabelInformationBirthday1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationBirthday1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationBirthday1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationBirthday1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_birthday_25px.png"))); // NOI18N
        jLabelInformationBirthday1.setText("Ngày sinh:");
        jDashboardProfile.add(jLabelInformationBirthday1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 130, 30));

        jLabelInformationStartdate1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationStartdate1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationStartdate1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationStartdate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_maintenance_date_25px.png"))); // NOI18N
        jLabelInformationStartdate1.setText("Ngày bắt đầu:");
        jDashboardProfile.add(jLabelInformationStartdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 150, 30));

        jLabelInformationAddress1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationAddress1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationAddress1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationAddress1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_home_address_25px.png"))); // NOI18N
        jLabelInformationAddress1.setText("Địa chỉ:");
        jDashboardProfile.add(jLabelInformationAddress1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 580, 100, 30));

        jLabelInformationEmail1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationEmail1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationEmail1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationEmail1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gmail_25px_1.png"))); // NOI18N
        jLabelInformationEmail1.setText("Email:");
        jDashboardProfile.add(jLabelInformationEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 620, 90, 30));

        jLabelInformationPhonenumber1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationPhonenumber1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationPhonenumber1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationPhonenumber1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_phone_25px.png"))); // NOI18N
        jLabelInformationPhonenumber1.setText("Số điện thoại:");
        jDashboardProfile.add(jLabelInformationPhonenumber1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 660, 150, 30));

        jLabelInformationBasicsalary1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationBasicsalary1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationBasicsalary1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationBasicsalary1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_paycheque_25px.png"))); // NOI18N
        jLabelInformationBasicsalary1.setText("Lương cơ bản:");
        jDashboardProfile.add(jLabelInformationBasicsalary1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 700, 150, 30));

        jLabelInformationAllowance1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationAllowance1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationAllowance1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationAllowance1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_loyalty_card_25px.png"))); // NOI18N
        jLabelInformationAllowance1.setText("Trợ cấp:");
        jDashboardProfile.add(jLabelInformationAllowance1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 740, 100, 30));
        jDashboardProfile.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 445, 440, 10));
        jDashboardProfile.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 485, 440, 10));
        jDashboardProfile.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 405, 440, 10));
        jDashboardProfile.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 525, 440, 10));
        jDashboardProfile.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 565, 440, 10));
        jDashboardProfile.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 605, 440, 10));
        jDashboardProfile.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 765, 440, 10));
        jDashboardProfile.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 645, 440, 10));
        jDashboardProfile.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 685, 440, 10));
        jDashboardProfile.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 725, 440, 10));

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jDashboardProfile.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, 10, 700));

        jLabelPreviousYear.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPreviousYear.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPreviousYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPreviousYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_down_40px.png"))); // NOI18N
        jLabelPreviousYear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelPreviousYear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPreviousYearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelPreviousYearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelPreviousYearMouseExited(evt);
            }
        });
        jDashboardProfile.add(jLabelPreviousYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 300, 60, 20));

        jPanelCalendar.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCalendar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tháng 12 2020", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(153, 153, 255))); // NOI18N
        jPanelCalendar.setForeground(new java.awt.Color(255, 255, 255));

        jLabelDayCalendar43.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar43.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar43.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar43.setText("CN");
        jLabelDayCalendar43.setOpaque(true);
        jLabelDayCalendar43.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar43);

        jLabelDayCalendar44.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar44.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar44.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar44.setText("T2");
        jLabelDayCalendar44.setOpaque(true);
        jLabelDayCalendar44.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar44);

        jLabelDayCalendar45.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar45.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar45.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar45.setText("T3");
        jLabelDayCalendar45.setOpaque(true);
        jLabelDayCalendar45.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar45);

        jLabelDayCalendar46.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar46.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar46.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar46.setText("T4");
        jLabelDayCalendar46.setOpaque(true);
        jLabelDayCalendar46.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar46);

        jLabelDayCalendar47.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar47.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar47.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar47.setText("T5");
        jLabelDayCalendar47.setOpaque(true);
        jLabelDayCalendar47.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar47);

        jLabelDayCalendar48.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar48.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar48.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar48.setText("T6");
        jLabelDayCalendar48.setOpaque(true);
        jLabelDayCalendar48.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar48);

        jLabelDayCalendar49.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar49.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar49.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar49.setText("T7");
        jLabelDayCalendar49.setOpaque(true);
        jLabelDayCalendar49.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar49);

        jLabelDayCalendar1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar1.setText("1");
        jLabelDayCalendar1.setOpaque(true);
        jLabelDayCalendar1.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar1);

        jLabelDayCalendar2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar2.setText("1");
        jLabelDayCalendar2.setOpaque(true);
        jLabelDayCalendar2.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar2);

        jLabelDayCalendar3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar3.setText("1");
        jLabelDayCalendar3.setOpaque(true);
        jLabelDayCalendar3.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar3);

        jLabelDayCalendar4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar4.setText("1");
        jLabelDayCalendar4.setOpaque(true);
        jLabelDayCalendar4.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar4);

        jLabelDayCalendar5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar5.setText("1");
        jLabelDayCalendar5.setOpaque(true);
        jLabelDayCalendar5.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar5);

        jLabelDayCalendar6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar6.setText("1");
        jLabelDayCalendar6.setOpaque(true);
        jLabelDayCalendar6.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar6);

        jLabelDayCalendar7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar7.setText("1");
        jLabelDayCalendar7.setOpaque(true);
        jLabelDayCalendar7.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar7);

        jLabelDayCalendar8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar8.setText("1");
        jLabelDayCalendar8.setOpaque(true);
        jLabelDayCalendar8.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar8);

        jLabelDayCalendar9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar9.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar9.setText("1");
        jLabelDayCalendar9.setOpaque(true);
        jLabelDayCalendar9.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar9);

        jLabelDayCalendar10.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar10.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar10.setText("1");
        jLabelDayCalendar10.setOpaque(true);
        jLabelDayCalendar10.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar10);

        jLabelDayCalendar11.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar11.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar11.setText("1");
        jLabelDayCalendar11.setOpaque(true);
        jLabelDayCalendar11.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar11);

        jLabelDayCalendar12.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar12.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar12.setText("1");
        jLabelDayCalendar12.setOpaque(true);
        jLabelDayCalendar12.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar12);

        jLabelDayCalendar13.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar13.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar13.setText("1");
        jLabelDayCalendar13.setOpaque(true);
        jLabelDayCalendar13.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar13);

        jLabelDayCalendar14.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar14.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar14.setText("1");
        jLabelDayCalendar14.setOpaque(true);
        jLabelDayCalendar14.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar14);

        jLabelDayCalendar15.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar15.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar15.setText("1");
        jLabelDayCalendar15.setOpaque(true);
        jLabelDayCalendar15.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar15);

        jLabelDayCalendar16.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar16.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar16.setText("1");
        jLabelDayCalendar16.setOpaque(true);
        jLabelDayCalendar16.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar16);

        jLabelDayCalendar17.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar17.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar17.setText("1");
        jLabelDayCalendar17.setOpaque(true);
        jLabelDayCalendar17.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar17);

        jLabelDayCalendar18.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar18.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar18.setText("1");
        jLabelDayCalendar18.setOpaque(true);
        jLabelDayCalendar18.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar18);

        jLabelDayCalendar19.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar19.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar19.setText("1");
        jLabelDayCalendar19.setOpaque(true);
        jLabelDayCalendar19.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar19);

        jLabelDayCalendar20.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar20.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar20.setText("1");
        jLabelDayCalendar20.setOpaque(true);
        jLabelDayCalendar20.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar20);

        jLabelDayCalendar21.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar21.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar21.setText("1");
        jLabelDayCalendar21.setOpaque(true);
        jLabelDayCalendar21.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar21);

        jLabelDayCalendar22.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar22.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar22.setText("1");
        jLabelDayCalendar22.setOpaque(true);
        jLabelDayCalendar22.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar22);

        jLabelDayCalendar23.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar23.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar23.setText("1");
        jLabelDayCalendar23.setOpaque(true);
        jLabelDayCalendar23.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar23);

        jLabelDayCalendar24.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar24.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar24.setText("1");
        jLabelDayCalendar24.setOpaque(true);
        jLabelDayCalendar24.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar24);

        jLabelDayCalendar25.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar25.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar25.setText("1");
        jLabelDayCalendar25.setOpaque(true);
        jLabelDayCalendar25.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar25);

        jLabelDayCalendar26.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar26.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar26.setText("1");
        jLabelDayCalendar26.setOpaque(true);
        jLabelDayCalendar26.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar26);

        jLabelDayCalendar27.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar27.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar27.setText("1");
        jLabelDayCalendar27.setOpaque(true);
        jLabelDayCalendar27.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar27);

        jLabelDayCalendar28.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar28.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar28.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar28.setText("1");
        jLabelDayCalendar28.setOpaque(true);
        jLabelDayCalendar28.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar28);

        jLabelDayCalendar29.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar29.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar29.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar29.setText("1");
        jLabelDayCalendar29.setOpaque(true);
        jLabelDayCalendar29.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar29);

        jLabelDayCalendar30.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar30.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar30.setText("1");
        jLabelDayCalendar30.setOpaque(true);
        jLabelDayCalendar30.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar30);

        jLabelDayCalendar31.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar31.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar31.setText("1");
        jLabelDayCalendar31.setOpaque(true);
        jLabelDayCalendar31.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar31);

        jLabelDayCalendar32.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar32.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar32.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar32.setText("1");
        jLabelDayCalendar32.setOpaque(true);
        jLabelDayCalendar32.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar32);

        jLabelDayCalendar33.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar33.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar33.setText("1");
        jLabelDayCalendar33.setOpaque(true);
        jLabelDayCalendar33.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar33);

        jLabelDayCalendar34.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar34.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar34.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar34.setText("1");
        jLabelDayCalendar34.setOpaque(true);
        jLabelDayCalendar34.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar34);

        jLabelDayCalendar35.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar35.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar35.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar35.setText("1");
        jLabelDayCalendar35.setOpaque(true);
        jLabelDayCalendar35.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar35);

        jLabelDayCalendar36.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar36.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar36.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar36.setText("15");
        jLabelDayCalendar36.setOpaque(true);
        jLabelDayCalendar36.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar36);

        jLabelDayCalendar37.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar37.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar37.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar37.setText("15");
        jLabelDayCalendar37.setOpaque(true);
        jLabelDayCalendar37.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar37);

        jLabelDayCalendar38.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar38.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar38.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar38.setText("15");
        jLabelDayCalendar38.setOpaque(true);
        jLabelDayCalendar38.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar38);

        jLabelDayCalendar39.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar39.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar39.setText("15");
        jLabelDayCalendar39.setOpaque(true);
        jLabelDayCalendar39.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar39);

        jLabelDayCalendar40.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar40.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar40.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar40.setText("15");
        jLabelDayCalendar40.setOpaque(true);
        jLabelDayCalendar40.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar40);

        jLabelDayCalendar41.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar41.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar41.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar41.setText("15");
        jLabelDayCalendar41.setOpaque(true);
        jLabelDayCalendar41.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar41);

        jLabelDayCalendar42.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar42.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar42.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar42.setText("15");
        jLabelDayCalendar42.setOpaque(true);
        jLabelDayCalendar42.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar42);

        jDashboardProfile.add(jPanelCalendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 320, 420, 430));

        jLabelNextYear.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNextYear.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNextYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNextYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_up_40px.png"))); // NOI18N
        jLabelNextYear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNextYear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNextYearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNextYearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNextYearMouseExited(evt);
            }
        });
        jDashboardProfile.add(jLabelNextYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 300, 60, 20));

        jLabelTitleStatistical.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTitleStatistical.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabelTitleStatistical.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTitleStatistical.setText("Bảng công và doanh số:");
        jLabelTitleStatistical.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jDashboardProfile.add(jLabelTitleStatistical, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 600, 40));

        jLabelNumberOfWorking.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumberOfWorking.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelNumberOfWorking.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNumberOfWorking.setText("- Số buổi:");
        jDashboardProfile.add(jLabelNumberOfWorking, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, 560, 30));

        jLabelNumberOfStatistical.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumberOfStatistical.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelNumberOfStatistical.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNumberOfStatistical.setText("- Doanh số:");
        jDashboardProfile.add(jLabelNumberOfStatistical, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, 560, 30));

        jLabelNumberOfSalary.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumberOfSalary.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelNumberOfSalary.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNumberOfSalary.setText("- Lương:");
        jDashboardProfile.add(jLabelNumberOfSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 180, 560, 30));

        jLabelPreviousMonth.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPreviousMonth.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPreviousMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPreviousMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_left_40px.png"))); // NOI18N
        jLabelPreviousMonth.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelPreviousMonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPreviousMonthMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelPreviousMonthMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelPreviousMonthMouseExited(evt);
            }
        });
        jDashboardProfile.add(jLabelPreviousMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 500, 30, 60));

        jLabelNextMonth.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNextMonth.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNextMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNextMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_right_40px.png"))); // NOI18N
        jLabelNextMonth.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNextMonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNextMonthMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNextMonthMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNextMonthMouseExited(evt);
            }
        });
        jDashboardProfile.add(jLabelNextMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 500, 30, 60));

        jLabelNameCalendar.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameCalendar.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabelNameCalendar.setForeground(new java.awt.Color(102, 102, 102));
        jLabelNameCalendar.setText("Bảng chấm công");
        jDashboardProfile.add(jLabelNameCalendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 760, 100, -1));

        jPanelBody.add(jDashboardProfile, "card8");

        jBackground.add(jPanelBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 1330, 790));

        jLabelUserLogin.setBackground(new java.awt.Color(255, 255, 255));
        jLabelUserLogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelUserLogin.setForeground(new java.awt.Color(0, 0, 0));
        jLabelUserLogin.setText("Phạm Duy Tài");
        jLabelUserLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelUserLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelUserLoginMouseClicked(evt);
            }
        });
        jBackground.add(jLabelUserLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 60, 150, 20));

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
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_close_window_25px_2.png")));
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
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_minimize_window_25px.png")));
    }//GEN-LAST:event_btnMinimizeMouseExited

    private void jPanelQLDHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLDHMouseClicked
        // TODO add your handling code here:
        qlhd = true;
        qlk = false;
        qlnv = false;
        qlncc = false;
        tk = false;
        ttkh = false;
        jPanelQLDH.setBackground(new java.awt.Color(102, 178, 255));
        jPanelQLBH.setBackground(new java.awt.Color(0, 0, 0));
        jPanelTK.setBackground(new java.awt.Color(0, 0, 0));
        jPanelTTKH.setBackground(new java.awt.Color(0, 0, 0));
        jPanelBody.removeAll();
        jPanelBody.add(jDashboardQLDH);
        jPanelBody.repaint();
        jPanelBody.revalidate();
    }//GEN-LAST:event_jPanelQLDHMouseClicked

    private void jPanelQLBHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLBHMouseClicked
        // TODO add your handling code here:
        qlhd = false;
        qlk = false;
        qlnv = false;
        qlncc = true;
        tk = false;
        ttkh = false;
        jPanelQLDH.setBackground(new java.awt.Color(0, 0, 0));
        jPanelQLBH.setBackground(new java.awt.Color(102, 178, 255));
        jPanelTK.setBackground(new java.awt.Color(0, 0, 0));
        jPanelTTKH.setBackground(new java.awt.Color(0, 0, 0));
        jPanelBody.removeAll();
        jPanelBody.add(jDashboardQLBH);
        jPanelBody.repaint();
        jPanelBody.revalidate();
    }//GEN-LAST:event_jPanelQLBHMouseClicked

    private void jPanelTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelTKMouseClicked
        // TODO add your handling code here:
        qlhd = false;
        qlk = false;
        qlnv = false;
        qlncc = false;
        tk = true;
        ttkh = false;
        jPanelQLDH.setBackground(new java.awt.Color(0, 0, 0));
        jPanelQLBH.setBackground(new java.awt.Color(0, 0, 0));
        jPanelTK.setBackground(new java.awt.Color(102, 178, 255));
        jPanelTTKH.setBackground(new java.awt.Color(0, 0, 0));
        jPanelBody.removeAll();
//        jPanelBody.repaint();
//        jPanelBody.revalidate();
        jPanelBody.add(jDashboardTK);
        jPanelBody.repaint();
        jPanelBody.revalidate();
    }//GEN-LAST:event_jPanelTKMouseClicked

    private void jPanelQLDHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLDHMouseEntered
        // TODO add your handling code here:
        if (!qlhd) {
            jPanelQLDH.setBackground(new java.awt.Color(102, 102, 102));
        }
    }//GEN-LAST:event_jPanelQLDHMouseEntered

    private void jPanelQLDHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLDHMouseExited
        // TODO add your handling code here:
        if (!qlhd) {
            jPanelQLDH.setBackground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_jPanelQLDHMouseExited

    private void jPanelQLBHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLBHMouseEntered
        // TODO add your handling code here:
        if (!qlncc) {
            jPanelQLBH.setBackground(new java.awt.Color(102, 102, 102));
        }
    }//GEN-LAST:event_jPanelQLBHMouseEntered

    private void jPanelQLBHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLBHMouseExited
        // TODO add your handling code here:
        if (!qlncc) {
            jPanelQLBH.setBackground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_jPanelQLBHMouseExited

    private void jPanelTKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelTKMouseEntered
        // TODO add your handling code here:
        if (!tk) {
            jPanelTK.setBackground(new java.awt.Color(102, 102, 102));
        }
    }//GEN-LAST:event_jPanelTKMouseEntered

    private void jPanelTKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelTKMouseExited
        // TODO add your handling code here:
        if (!tk) {
            jPanelTK.setBackground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_jPanelTKMouseExited

    private void jPanelTTKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelTTKHMouseClicked
        // TODO add your handling code here:
        qlhd = false;
        qlk = false;
        qlnv = false;
        qlncc = false;
        tk = false;
        ttkh = true;
        jPanelQLDH.setBackground(new java.awt.Color(0, 0, 0));
        jPanelQLBH.setBackground(new java.awt.Color(0, 0, 0));
        jPanelTK.setBackground(new java.awt.Color(0, 0, 0));
        jPanelTTKH.setBackground(new java.awt.Color(102, 178, 255));
        jPanelBody.removeAll();
//        jPanelBody.repaint();
//        jPanelBody.revalidate();
        jPanelBody.add(jDashboardTTKH);
        jPanelBody.repaint();
        jPanelBody.revalidate();
    }//GEN-LAST:event_jPanelTTKHMouseClicked

    private void jPanelTTKHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelTTKHMouseEntered
        // TODO add your handling code here:
        if (!ttkh) {
            jPanelTTKH.setBackground(new java.awt.Color(102, 102, 102));
        }
    }//GEN-LAST:event_jPanelTTKHMouseEntered

    private void jPanelTTKHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelTTKHMouseExited
        // TODO add your handling code here:
        if (!ttkh) {
            jPanelTTKH.setBackground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_jPanelTTKHMouseExited

    private void jLabelBackToQLNVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBackToQLNVMouseExited
        // TODO add your handling code here:
        jLabelBackToQLNV.setForeground(new java.awt.Color(0, 0, 0));
        jLabelBackToQLNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_back_20px.png")));
    }//GEN-LAST:event_jLabelBackToQLNVMouseExited

    private void jLabelBackToQLNVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBackToQLNVMouseEntered
        // TODO add your handling code here:
        jLabelBackToQLNV.setForeground(new java.awt.Color(0, 142, 255));
        jLabelBackToQLNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_back_20px_1.png")));
    }//GEN-LAST:event_jLabelBackToQLNVMouseEntered

    private void jLabelBackToQLNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBackToQLNVMouseClicked
        // TODO add your handling code here:
        if(profile){
        jLabelBackToQLNV.setForeground(new java.awt.Color(0, 0, 0));
        jLabelBackToQLNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_back_20px.png")));
        jPanelBody.removeAll();
        jPanelBody.add(jDashboardQLDH);
        jPanelBody.repaint();
        jPanelBody.revalidate();
        }
        else{
        jLabelBackToQLNV.setForeground(new java.awt.Color(0, 0, 0));
        jLabelBackToQLNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_back_20px.png")));
        
        jPanelBody.removeAll();
        jPanelBody.repaint();
        jPanelBody.revalidate();
        }
        
    }//GEN-LAST:event_jLabelBackToQLNVMouseClicked

    private void jLabelFrameAvatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelFrameAvatarMouseClicked
        // TODO add your handling code here:
        popUpImageStaff(userLogin);
    }//GEN-LAST:event_jLabelFrameAvatarMouseClicked

    private void jLabelPreviousYearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPreviousYearMouseEntered
        // TODO add your handling code here:
        jLabelPreviousYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_down_40px_1.png")));

    }//GEN-LAST:event_jLabelPreviousYearMouseEntered

    private void jLabelPreviousYearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPreviousYearMouseExited
        // TODO add your handling code here:
        jLabelPreviousYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_down_40px.png")));
    }//GEN-LAST:event_jLabelPreviousYearMouseExited

    private void jLabelNextYearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNextYearMouseEntered
        // TODO add your handling code here:
        jLabelNextYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_up_40px_1.png")));
    }//GEN-LAST:event_jLabelNextYearMouseEntered

    private void jLabelNextYearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNextYearMouseExited
        // TODO add your handling code here:
        jLabelNextYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_up_40px.png")));
    }//GEN-LAST:event_jLabelNextYearMouseExited

    private void jLabelNextYearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNextYearMouseClicked
        // TODO add your handling code here:
        selectedYear++;
        try {
            showCalendar();
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelNextYearMouseClicked

    private void jLabelPreviousYearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPreviousYearMouseClicked
        // TODO add your handling code here:
        selectedYear--;
        try {
            showCalendar();
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelPreviousYearMouseClicked

    private void jLabelPreviousMonthMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPreviousMonthMouseEntered
        // TODO add your handling code here:
        jLabelPreviousMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_left_40px_1.png")));
    }//GEN-LAST:event_jLabelPreviousMonthMouseEntered

    private void jLabelPreviousMonthMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPreviousMonthMouseExited
        // TODO add your handling code here:
        jLabelPreviousMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_left_40px.png")));
    }//GEN-LAST:event_jLabelPreviousMonthMouseExited

    private void jLabelNextMonthMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNextMonthMouseEntered
        // TODO add your handling code here:
        jLabelNextMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_right_40px_1.png")));
    }//GEN-LAST:event_jLabelNextMonthMouseEntered

    private void jLabelNextMonthMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNextMonthMouseExited
        // TODO add your handling code here:
        jLabelNextMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_right_40px.png")));
    }//GEN-LAST:event_jLabelNextMonthMouseExited

    private void jLabelPreviousMonthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPreviousMonthMouseClicked
        // TODO add your handling code here:
        if (selectedMonth == 0) {
            selectedMonth = 11;
            selectedYear--;
        } else {
            selectedMonth--;
        }
        try {
            showCalendar();
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelPreviousMonthMouseClicked

    private void jLabelNextMonthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNextMonthMouseClicked
        // TODO add your handling code here:
        if (selectedMonth == 11) {
            selectedMonth = 0;
            selectedYear++;
        } else {
            selectedMonth++;
        }
        try {
            showCalendar();
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelNextMonthMouseClicked

    private void jLabelButtonEditStaffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonEditStaffMouseEntered
        // TODO add your handling code here:
        jLabelBBButtonEditStaff.setIcon(scaleButtonEdit("/Image/ButtonEditDark.png"));
    }//GEN-LAST:event_jLabelButtonEditStaffMouseEntered

    private void jLabelButtonEditStaffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonEditStaffMouseExited
        // TODO add your handling code here:
        jLabelBBButtonEditStaff.setIcon(scaleButtonEdit("/Image/ButtonEditLight.png"));
    }//GEN-LAST:event_jLabelButtonEditStaffMouseExited

    private void jLabelButtonStatusStaffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonStatusStaffMouseEntered
        jLabelBBButtonStatusStaff.setIcon(scaleButtonEdit("/Image/ButtonEditDark.png"));
    }//GEN-LAST:event_jLabelButtonStatusStaffMouseEntered

    private void jLabelButtonStatusStaffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonStatusStaffMouseExited
        jLabelBBButtonStatusStaff.setIcon(scaleButtonEdit("/Image/ButtonEditLight.png"));
    }//GEN-LAST:event_jLabelButtonStatusStaffMouseExited

    private void jLabelButtonEditStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonEditStaffMouseClicked
        EditStaff es = new EditStaff(u, "Sửa thông tin nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelButtonEditStaffMouseClicked

    private void jLabelButtonStatusStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonStatusStaffMouseClicked
        ConfirmOperations co = new ConfirmOperations(u);
        co.setVisible(true);
        co.pack();
    }//GEN-LAST:event_jLabelButtonStatusStaffMouseClicked

    private void jLabelButtonDeleteStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonDeleteStaffMouseClicked
        ConfirmDeleteStaff cd = new ConfirmDeleteStaff(u);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_jLabelButtonDeleteStaffMouseClicked

    private void jLabelButtonDeleteStaffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonDeleteStaffMouseEntered
        // TODO add your handling code here:
        jLabelBBButtonDeleteStaff.setIcon(scaleButtonEdit("/Image/ButtonEditDark.png"));
        jLabelButtonDeleteStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
        jLabelButtonDeleteStaff.setForeground(new java.awt.Color(255, 92, 92));
    }//GEN-LAST:event_jLabelButtonDeleteStaffMouseEntered

    private void jLabelButtonDeleteStaffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonDeleteStaffMouseExited
        // TODO add your handling code here:
        jLabelBBButtonDeleteStaff.setIcon(scaleButtonEdit("/Image/ButtonEditLight.png"));
        jLabelButtonDeleteStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
        jLabelButtonDeleteStaff.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelButtonDeleteStaffMouseExited

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
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
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
//        if (jTextFieldSearchProduct.getText().equals("")) {
//            try {
//                ListBills = BillDao.findAllBill();
//                countBill = BillDao.countBill();
//                showBillList(ListBills, countBill);
//                jTextFieldPageBill.setText("1");
//            } catch (SQLException ex) {
//                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        } else {
//            try {
//                ListBills = BillDao.searchBill(jTextFieldSearchBill.getText());
//                countBill = BillDao.countsearchBill(jTextFieldSearchBill.getText());
//                showBillList(ListBills, countBill);
//                jTextFieldPageBill.setText("1");
//            } catch (SQLException ex) {
//                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }

    }//GEN-LAST:event_jTextFieldSearchBillKeyReleased

    private void jTextFieldSearchCustomerFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchCustomerFocusGained
        if (jTextFieldSearchCustomer.getText().equals("Tìm kiếm")) {
            jTextFieldSearchCustomer.setText("");
        }
    }//GEN-LAST:event_jTextFieldSearchCustomerFocusGained

    private void jTextFieldSearchCustomerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchCustomerFocusLost
        if (jTextFieldSearchCustomer.getText().equals("")) {
            jTextFieldSearchCustomer.setText("Tìm kiếm");
        }
    }//GEN-LAST:event_jTextFieldSearchCustomerFocusLost

    private void jTextFieldSearchCustomerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchCustomerKeyReleased
        DefaultTableModel tblModel = (DefaultTableModel) jTableCustomer.getModel();
        int rowcount = tblModel.getRowCount();
        for (int i = rowcount - 1; i >= 0; i--) {
            tblModel.removeRow(i);
        }
        try {
            ListCustomers = CustomerDao.searchCustomer(jTextFieldSearchCustomer.getText());
            showTableCustomer();
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTextFieldSearchCustomerKeyReleased

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
        
        profile = true;
        jPanelBody.removeAll();
        jPanelBody.add(jDashboardProfile);
        jPanelBody.repaint();
        jPanelBody.revalidate();

        try {
            renderJDashboardProfile();
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jLabelUserLoginMouseClicked

    private void jLabelButtonEditPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonEditPasswordMouseClicked
        ChancePassword cp = new ChancePassword(userLogin);

        cp.pack();
        cp.setVisible(true);
    }//GEN-LAST:event_jLabelButtonEditPasswordMouseClicked

    private void jLabelButtonEditPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonEditPasswordMouseEntered
        jLabelBBButtonEditPassword.setIcon(scaleButtonEdit("/Image/ButtonEditDark.png"));
    }//GEN-LAST:event_jLabelButtonEditPasswordMouseEntered

    private void jLabelButtonEditPasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonEditPasswordMouseExited
        jLabelBBButtonEditPassword.setIcon(scaleButtonEdit("/Image/ButtonEditLight.png"));
    }//GEN-LAST:event_jLabelButtonEditPasswordMouseExited

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
    private javax.swing.JCheckBox jCheckBoxAllBill;
    private javax.swing.JCheckBox jCheckBoxAllBill1;
    private javax.swing.JCheckBox jCheckBoxAllBill2;
    private javax.swing.JCheckBox jCheckBoxAllBill3;
    private javax.swing.JCheckBox jCheckBoxAllBill4;
    private javax.swing.JCheckBox jCheckBoxAllBill5;
    private javax.swing.JPanel jDashboardProfile;
    private javax.swing.JPanel jDashboardQLBH;
    private javax.swing.JPanel jDashboardQLDH;
    private javax.swing.JPanel jDashboardTK;
    private javax.swing.JPanel jDashboardTTKH;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelAvatarStaff;
    private javax.swing.JLabel jLabelBBButtonDeleteStaff;
    private javax.swing.JLabel jLabelBBButtonEditPassword;
    private javax.swing.JLabel jLabelBBButtonEditStaff;
    private javax.swing.JLabel jLabelBBButtonStatusStaff;
    private javax.swing.JLabel jLabelBackToQLNV;
    private javax.swing.JLabel jLabelButtonDeleteStaff;
    private javax.swing.JLabel jLabelButtonEditPassword;
    private javax.swing.JLabel jLabelButtonEditStaff;
    private javax.swing.JLabel jLabelButtonStatusStaff;
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
    private javax.swing.JLabel jLabelDayCalendar1;
    private javax.swing.JLabel jLabelDayCalendar10;
    private javax.swing.JLabel jLabelDayCalendar11;
    private javax.swing.JLabel jLabelDayCalendar12;
    private javax.swing.JLabel jLabelDayCalendar13;
    private javax.swing.JLabel jLabelDayCalendar14;
    private javax.swing.JLabel jLabelDayCalendar15;
    private javax.swing.JLabel jLabelDayCalendar16;
    private javax.swing.JLabel jLabelDayCalendar17;
    private javax.swing.JLabel jLabelDayCalendar18;
    private javax.swing.JLabel jLabelDayCalendar19;
    private javax.swing.JLabel jLabelDayCalendar2;
    private javax.swing.JLabel jLabelDayCalendar20;
    private javax.swing.JLabel jLabelDayCalendar21;
    private javax.swing.JLabel jLabelDayCalendar22;
    private javax.swing.JLabel jLabelDayCalendar23;
    private javax.swing.JLabel jLabelDayCalendar24;
    private javax.swing.JLabel jLabelDayCalendar25;
    private javax.swing.JLabel jLabelDayCalendar26;
    private javax.swing.JLabel jLabelDayCalendar27;
    private javax.swing.JLabel jLabelDayCalendar28;
    private javax.swing.JLabel jLabelDayCalendar29;
    private javax.swing.JLabel jLabelDayCalendar3;
    private javax.swing.JLabel jLabelDayCalendar30;
    private javax.swing.JLabel jLabelDayCalendar31;
    private javax.swing.JLabel jLabelDayCalendar32;
    private javax.swing.JLabel jLabelDayCalendar33;
    private javax.swing.JLabel jLabelDayCalendar34;
    private javax.swing.JLabel jLabelDayCalendar35;
    private javax.swing.JLabel jLabelDayCalendar36;
    private javax.swing.JLabel jLabelDayCalendar37;
    private javax.swing.JLabel jLabelDayCalendar38;
    private javax.swing.JLabel jLabelDayCalendar39;
    private javax.swing.JLabel jLabelDayCalendar4;
    private javax.swing.JLabel jLabelDayCalendar40;
    private javax.swing.JLabel jLabelDayCalendar41;
    private javax.swing.JLabel jLabelDayCalendar42;
    private javax.swing.JLabel jLabelDayCalendar43;
    private javax.swing.JLabel jLabelDayCalendar44;
    private javax.swing.JLabel jLabelDayCalendar45;
    private javax.swing.JLabel jLabelDayCalendar46;
    private javax.swing.JLabel jLabelDayCalendar47;
    private javax.swing.JLabel jLabelDayCalendar48;
    private javax.swing.JLabel jLabelDayCalendar49;
    private javax.swing.JLabel jLabelDayCalendar5;
    private javax.swing.JLabel jLabelDayCalendar6;
    private javax.swing.JLabel jLabelDayCalendar7;
    private javax.swing.JLabel jLabelDayCalendar8;
    private javax.swing.JLabel jLabelDayCalendar9;
    private javax.swing.JLabel jLabelDiscountBill;
    private javax.swing.JLabel jLabelDiscountBill1;
    private javax.swing.JLabel jLabelDiscountBill2;
    private javax.swing.JLabel jLabelDiscountBill3;
    private javax.swing.JLabel jLabelDiscountBill4;
    private javax.swing.JLabel jLabelDiscountBill5;
    private javax.swing.JLabel jLabelFrameAvatar;
    private javax.swing.JLabel jLabelFrameSearchBill;
    private javax.swing.JLabel jLabelFrameSearchCustomer;
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
    private javax.swing.JLabel jLabelInformationAddress;
    private javax.swing.JLabel jLabelInformationAddress1;
    private javax.swing.JLabel jLabelInformationAllowance;
    private javax.swing.JLabel jLabelInformationAllowance1;
    private javax.swing.JLabel jLabelInformationBasicsalary;
    private javax.swing.JLabel jLabelInformationBasicsalary1;
    private javax.swing.JLabel jLabelInformationBirthday;
    private javax.swing.JLabel jLabelInformationBirthday1;
    private javax.swing.JLabel jLabelInformationEmail;
    private javax.swing.JLabel jLabelInformationEmail1;
    private javax.swing.JLabel jLabelInformationGender;
    private javax.swing.JLabel jLabelInformationGender1;
    private javax.swing.JLabel jLabelInformationId;
    private javax.swing.JLabel jLabelInformationId1;
    private javax.swing.JLabel jLabelInformationNameStaff;
    private javax.swing.JLabel jLabelInformationPhonenumber;
    private javax.swing.JLabel jLabelInformationPhonenumber1;
    private javax.swing.JLabel jLabelInformationStartdate;
    private javax.swing.JLabel jLabelInformationStartdate1;
    private javax.swing.JLabel jLabelInformationUsername;
    private javax.swing.JLabel jLabelInformationUsername1;
    private javax.swing.JLabel jLabelLeftPageBill;
    private javax.swing.JLabel jLabelLogout;
    private javax.swing.JLabel jLabelNameCalendar;
    private javax.swing.JLabel jLabelNameStaffBill1;
    private javax.swing.JLabel jLabelNameStaffBill2;
    private javax.swing.JLabel jLabelNameStaffBill3;
    private javax.swing.JLabel jLabelNameStaffBill4;
    private javax.swing.JLabel jLabelNameStaffBill5;
    private javax.swing.JLabel jLabelNextMonth;
    private javax.swing.JLabel jLabelNextYear;
    private javax.swing.JLabel jLabelNoteBill;
    private javax.swing.JLabel jLabelNoteBill1;
    private javax.swing.JLabel jLabelNoteBill2;
    private javax.swing.JLabel jLabelNoteBill3;
    private javax.swing.JLabel jLabelNoteBill4;
    private javax.swing.JLabel jLabelNoteBill5;
    private javax.swing.JLabel jLabelNumberOfSalary;
    private javax.swing.JLabel jLabelNumberOfStatistical;
    private javax.swing.JLabel jLabelNumberOfWorking;
    private javax.swing.JLabel jLabelPageBill;
    private javax.swing.JLabel jLabelPreviousMonth;
    private javax.swing.JLabel jLabelPreviousYear;
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
    private javax.swing.JLabel jLabelQLBH;
    private javax.swing.JLabel jLabelQLDH;
    private javax.swing.JLabel jLabelRightPageBill;
    private javax.swing.JLabel jLabelSearchBill;
    private javax.swing.JLabel jLabelSearchCustomer;
    private javax.swing.JLabel jLabelSettingBill;
    private javax.swing.JLabel jLabelSettingBill1;
    private javax.swing.JLabel jLabelSettingBill2;
    private javax.swing.JLabel jLabelSettingBill3;
    private javax.swing.JLabel jLabelSettingBill4;
    private javax.swing.JLabel jLabelSettingBill5;
    private javax.swing.JLabel jLabelSkipToEndPageBill;
    private javax.swing.JLabel jLabelSkipToStartPageBill;
    private javax.swing.JLabel jLabelStaffBill;
    private javax.swing.JLabel jLabelTK;
    private javax.swing.JLabel jLabelTT;
    private javax.swing.JLabel jLabelTTBill;
    private javax.swing.JLabel jLabelTTKH;
    private javax.swing.JLabel jLabelTitleStatistical;
    private javax.swing.JLabel jLabelTotalBill;
    private javax.swing.JLabel jLabelTotalPriceBill1;
    private javax.swing.JLabel jLabelTotalPriceBill2;
    private javax.swing.JLabel jLabelTotalPriceBill3;
    private javax.swing.JLabel jLabelTotalPriceBill4;
    private javax.swing.JLabel jLabelTotalPriceBill5;
    private javax.swing.JLabel jLabelUserLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelBill1;
    private javax.swing.JPanel jPanelBill2;
    private javax.swing.JPanel jPanelBill3;
    private javax.swing.JPanel jPanelBill4;
    private javax.swing.JPanel jPanelBill5;
    private javax.swing.JPanel jPanelBody;
    private javax.swing.JPanel jPanelCalendar;
    private javax.swing.JPanel jPanelControlPageBill;
    private javax.swing.JPanel jPanelCustomerBill1;
    private javax.swing.JPanel jPanelCustomerBill2;
    private javax.swing.JPanel jPanelCustomerBill3;
    private javax.swing.JPanel jPanelCustomerBill4;
    private javax.swing.JPanel jPanelCustomerBill5;
    private javax.swing.JPanel jPanelHeaderBill;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelProductBill1;
    private javax.swing.JPanel jPanelProductBill2;
    private javax.swing.JPanel jPanelProductBill3;
    private javax.swing.JPanel jPanelProductBill4;
    private javax.swing.JPanel jPanelProductBill5;
    private javax.swing.JPanel jPanelQLBH;
    private javax.swing.JPanel jPanelQLDH;
    private javax.swing.JPanel jPanelTK;
    private javax.swing.JPanel jPanelTTBill1;
    private javax.swing.JPanel jPanelTTBill2;
    private javax.swing.JPanel jPanelTTBill3;
    private javax.swing.JPanel jPanelTTBill4;
    private javax.swing.JPanel jPanelTTBill5;
    private javax.swing.JPanel jPanelTTKH;
    private javax.swing.JPanel jPanelTTStaffBill1;
    private javax.swing.JPanel jPanelTTStaffBill2;
    private javax.swing.JPanel jPanelTTStaffBill3;
    private javax.swing.JPanel jPanelTTStaffBill4;
    private javax.swing.JPanel jPanelTTStaffBill5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTableCustomer;
    private javax.swing.JTextField jTextFieldPageBill;
    private javax.swing.JTextField jTextFieldSearchBill;
    private javax.swing.JTextField jTextFieldSearchCustomer;
    // End of variables declaration//GEN-END:variables
}
