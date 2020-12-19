/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaForm;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import ConnectToTheDatabase.UsersConnectToDatabase;
import ConnectToTheDatabase.GoodsConnectToDatabase;
import ConnectToTheDatabase.TypeOfGoodConnectToDatabase;
import ConnectToTheDatabase.WorkDayConnectToDatabase;
import ConnectToTheDatabase.BillConnectToDatabase;
import ConnectToTheDatabase.CustomerConnectToDatabase;
import ConnectToTheDatabase.InvoicedetailsConnectToDatabase;
import ConnectToTheDatabase.SupplierConnectToDatabase;

import JavaClassObject.Bill;
import JavaClassObject.Customers;
import JavaClassObject.Goods;
import JavaClassObject.Users;
import JavaClassObject.WorkDay;
import JavaClassObject.Invoicedetails;
import JavaClassObject.Suppliers;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

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
    public boolean qlhd, qlk = false, qlnv = false, qlncc = false, tk = false, ttkh = false;
    public ArrayList<Goods> ListGoods = GoodsConnectToDatabase.findAll();
    public ArrayList<Users> ListUsers = UsersConnectToDatabase.findStaff();
    public ArrayList<Bill> ListBills = BillConnectToDatabase.findAllBill();
    public ArrayList<Suppliers> ListSuppliers = SupplierConnectToDatabase.findAllSupplier();
    public ArrayList<WorkDay> ListWorkday = new ArrayList<>();
    private final ArrayList<JLabel> ListLabelDaysCalendar = new ArrayList<JLabel>();
    public int countProduct = GoodsConnectToDatabase.countProduct();
    public int countStaff = UsersConnectToDatabase.countStaff();
    public int countBill = BillConnectToDatabase.countBill();
    public int countSupplier = SupplierConnectToDatabase.countSupplier();
    public int setPageProduct, setPageStaff, setPageBill, setPageSupplier, setPageCustomer;
    public int thisStaff;

    Calendar cal = new GregorianCalendar();
    public int selectedMonth = cal.get(Calendar.MONTH);
    public int selectedYear = cal.get(Calendar.YEAR);
    public int dayEarlier = 0;
    public int numberOfWorking;
    public Users u;

    public AdminForm(Users userLogin) throws SQLException {
        startingState();
    }

    public void startingState() throws SQLException {
        this.qlhd = true;
        initComponents();
        jPanelQLDH.setBackground(new java.awt.Color(102, 178, 255));
        jPanelBody.removeAll();
        jPanelBody.repaint();
        jPanelBody.revalidate();
        jPanelBody.add(jDashboardQLDH);
        jPanelBody.repaint();
        jPanelBody.revalidate();

        jLabelBBButtonRefreshStaffList.setIcon(scaleButtonRefresh("/Image/ButtonEditLight.png"));
        jLabelBBButtonAddStaff.setIcon(scaleButtonAddStaff("/Image/ButtonEditBlue.png"));

        jTextFieldPageProduct.setText("1");
        jTextFieldPageStaff.setText("1");
        TypeOfGoodConnectToDatabase.setComboboxType(jComboBoxType);
        showProducts(ListGoods, countProduct);
        showStaffList(ListUsers, countStaff);
        showBillList(ListBills, countBill);
        showSupplierList(ListSuppliers, countSupplier);
        addLabelDays();
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

    public void startingStateQLNV() {
        jPanelStaff1.setVisible(false);
        jPanelStaff2.setVisible(false);
        jPanelStaff3.setVisible(false);
        jPanelStaff4.setVisible(false);
        jPanelStaff5.setVisible(false);
        jPanelStaff6.setVisible(false);
    }

    public void startingStateQLHD() {
        jPanelBill1.setVisible(false);
        jPanelBill2.setVisible(false);
        jPanelBill3.setVisible(false);
        jPanelBill4.setVisible(false);
        jPanelBill5.setVisible(false);
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

    public void showStaffList(ArrayList<Users> ListUsers, int countStaff) throws SQLException {
        startingStateQLNV();
        setPageStaff = (countStaff % 6 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 6 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 6;
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
        jLabelFrameSearchStaff.setIcon(scaleFrameSearch("/Image/FrameSearch.png"));
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
    }

    public void showCalendar() throws SQLException {
        numberOfWorking = WorkDayConnectToDatabase.countWorkDay(u.getId(), selectedMonth + 1, selectedYear);
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
        Users userCreateBill = UsersConnectToDatabase.findStaffById(b.getIduser());
        Customers customerBill = CustomerConnectToDatabase.findCustomerById(b.getCustomercode());
        ArrayList<Invoicedetails> ListInvoicedetailses = InvoicedetailsConnectToDatabase.findInvoicedetailsByIdBill(b.getCodebill());
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
                productbill += "- "+GoodsConnectToDatabase.findProductForBill(iv.getItemcode()).getItemname() + "<br>";
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
        if(b.getNote().equals("")){
            jlabelNoteBill.setText("--------------------------");
        }else{
            jlabelNoteBill.setText(b.getNote());
        }
    }
    private void renderJPanelSupplier(Suppliers s, JPanel jpanel, JLabel jlabelIdSupplier, JLabel jlabelNameSupplier, JLabel jlabelLogoSupplier, JLabel jlabelNameTradingSupplier, JLabel jlabelAddressSupplier, JLabel jlabelEmailSupplier, JLabel jlabelPhonenumberSupplier){
        jpanel.setVisible(true);
        jlabelIdSupplier.setText(s.getCompanycode());
        jlabelNameSupplier.setText(s.getCompanyname());
        jlabelLogoSupplier.setIcon(scaleImageProduct(s.getLogo()));
        jlabelNameTradingSupplier.setText("<html>" + s.getTradingname() + "</html>");
        jlabelEmailSupplier.setText(s.getEmail());
        jlabelAddressSupplier.setText("<html>" + s.getAddress() + "</html>");
        jlabelPhonenumberSupplier.setText(s.getPhonenumber());
    }

    private void renderJDashboardImformationStaff(int n) throws SQLException {

        setPageStaff = (countStaff % 6 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 6 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 6;
        u = ListUsers.get(pageStaff + n);
        ListWorkday = WorkDayConnectToDatabase.findByUsername(u);
        selectedMonth = cal.get(Calendar.MONTH);
        selectedYear = cal.get(Calendar.YEAR);
        showCalendar();
        jLabelInformationNameStaff.setText(u.getFullname());
        jLabelAvatarStaff.setIcon(scaleImformationAvatar(u.getImage_user()));
        jLabelInformationId.setText(u.getId());
        jLabelInformationUsername.setText(u.getUsername());
        jLabelInformationGender.setText(u.getGender());
        if (u.getGender().equals("Nam")) {
            jLabelInformationGender1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_25px.png")));
        } else {
            jLabelInformationGender1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_female_25px.png")));
        }
        jLabelInformationBirthday.setText(u.getBirthday().toString());
        jLabelInformationStartdate.setText(u.getStartdate().toString());
        jLabelInformationAddress.setText(u.getAddress());
        jLabelInformationEmail.setText(u.getEmail());
        jLabelInformationPhonenumber.setText(u.getPhonenumber());
        jLabelInformationBasicsalary.setText(String.format("%1$,.0f" + " VNĐ", u.getBasicsalary()));
        jLabelInformationAllowance.setText(String.format("%1$,.0f" + " VNĐ", u.getAllowance()));
        jLabelBBButtonEditStaff.setIcon(scaleButtonEdit("/Image/ButtonEditLight.png"));
        jLabelBBButtonStatusStaff.setIcon(scaleButtonEdit("/Image/ButtonEditLight.png"));
        jLabelBBButtonDeleteStaff.setIcon(scaleButtonEdit("/Image/ButtonEditLight.png"));
        if(u.getStatus().equals("Hoạt động")){
            jLabelButtonStatusStaff.setText("Hoạt động");
            jLabelButtonStatusStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px.png")));
            jLabelButtonStatusStaff.setForeground(Color.green);
        }else{
            jLabelButtonStatusStaff.setText("Khóa");
            jLabelButtonStatusStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px_1.png")));
            jLabelButtonStatusStaff.setForeground(Color.red);
        }
    }

    public void popUpImageStaff(int n) {
        setPageStaff = (countStaff % 6 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 6 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 6;
        Users u = ListUsers.get(pageStaff + n);
        DisplayImage di = new DisplayImage(u.getFullname(), u.getImage_user());
        di.setVisible(true);
        di.pack();
        di.setLocationRelativeTo(null);
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

        jBackground = new javax.swing.JPanel();
        btnExit = new javax.swing.JLabel();
        btnMinimize = new javax.swing.JLabel();
        jPanelMenu = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanelTK = new javax.swing.JPanel();
        jLabelTK = new javax.swing.JLabel();
        jPanelQLNV = new javax.swing.JPanel();
        jLabelQLNV = new javax.swing.JLabel();
        jPanelQLNCC = new javax.swing.JPanel();
        jLabelQLNCC = new javax.swing.JLabel();
        jPanelQLK = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelQLDH = new javax.swing.JPanel();
        jLabelQLDH = new javax.swing.JLabel();
        jPanelTTKH = new javax.swing.JPanel();
        jLabelTTKH = new javax.swing.JLabel();
        jPanelBody = new javax.swing.JPanel();
        jDashboardQLK = new javax.swing.JPanel();
        jPanelSelectPage = new javax.swing.JPanel();
        jPanelControlPageProduct = new javax.swing.JPanel();
        jTextFieldPageProduct = new javax.swing.JTextField();
        jLabelPageProduct = new javax.swing.JLabel();
        jLabelRight = new javax.swing.JLabel();
        jLabelLeft = new javax.swing.JLabel();
        jLabelSkipToEnd = new javax.swing.JLabel();
        jLabelSkipToStart = new javax.swing.JLabel();
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
        jPanelControlQLK = new javax.swing.JPanel();
        jComboBoxType = new javax.swing.JComboBox<>();
        jTextFieldSearchProduct = new javax.swing.JTextField();
        jLabelSearchProduct = new javax.swing.JLabel();
        jLabelFrameSearchProduct = new javax.swing.JLabel();
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
        jPanelControlPageProduct1 = new javax.swing.JPanel();
        jTextFieldPageSupplier = new javax.swing.JTextField();
        jLabelPageSupplier = new javax.swing.JLabel();
        jLabelRightSupplier = new javax.swing.JLabel();
        jLabelLeftSupplier = new javax.swing.JLabel();
        jLabelSkipToEndSupplier = new javax.swing.JLabel();
        jLabelSkipToStartSupplier = new javax.swing.JLabel();
        jDashboardQLNV = new javax.swing.JPanel();
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
        jPanelControlPageStaff = new javax.swing.JPanel();
        jTextFieldPageStaff = new javax.swing.JTextField();
        jLabelPageStaff = new javax.swing.JLabel();
        jLabelRight2 = new javax.swing.JLabel();
        jLabelLeft2 = new javax.swing.JLabel();
        jLabelSkipToEnd2 = new javax.swing.JLabel();
        jLabelSkipToStart2 = new javax.swing.JLabel();
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
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelTitleQLNV = new javax.swing.JLabel();
        jTextFieldSearchStaff = new javax.swing.JTextField();
        jLabelSearchStaff = new javax.swing.JLabel();
        jLabelButtonAddStaff = new javax.swing.JLabel();
        jLabelBBButtonAddStaff = new javax.swing.JLabel();
        jLabelButtonRefreshStaffList = new javax.swing.JLabel();
        jLabelBBButtonRefreshStaffList = new javax.swing.JLabel();
        jLabelFrameSearchStaff = new javax.swing.JLabel();
        jDashboardTK = new javax.swing.JPanel();
        jDashboardTTKH = new javax.swing.JPanel();
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
        jDashboardInformationStaff = new javax.swing.JPanel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setUndecorated(true);

        jBackground.setBackground(new java.awt.Color(255, 255, 255));
        jBackground.setForeground(new java.awt.Color(255, 255, 255));
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
        jLabelTK.setText("Thống kê");
        jLabelTK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanelTKLayout = new javax.swing.GroupLayout(jPanelTK);
        jPanelTK.setLayout(jPanelTKLayout);
        jPanelTKLayout.setHorizontalGroup(
            jPanelTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTKLayout.createSequentialGroup()
                .addComponent(jLabelTK, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 125, Short.MAX_VALUE))
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
        jLabelQLNV.setText("Quản lý nhân viên");

        javax.swing.GroupLayout jPanelQLNVLayout = new javax.swing.GroupLayout(jPanelQLNV);
        jPanelQLNV.setLayout(jPanelQLNVLayout);
        jPanelQLNVLayout.setHorizontalGroup(
            jPanelQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQLNVLayout.createSequentialGroup()
                .addComponent(jLabelQLNV, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 48, Short.MAX_VALUE))
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
        jLabelQLNCC.setText("Quản lý nhà cung cấp");

        javax.swing.GroupLayout jPanelQLNCCLayout = new javax.swing.GroupLayout(jPanelQLNCC);
        jPanelQLNCC.setLayout(jPanelQLNCCLayout);
        jPanelQLNCCLayout.setHorizontalGroup(
            jPanelQLNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQLNCCLayout.createSequentialGroup()
                .addComponent(jLabelQLNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
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

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_warehouse_30px.png"))); // NOI18N
        jLabel1.setText("Quản lý kho hàng");

        javax.swing.GroupLayout jPanelQLKLayout = new javax.swing.GroupLayout(jPanelQLK);
        jPanelQLK.setLayout(jPanelQLKLayout);
        jPanelQLKLayout.setHorizontalGroup(
            jPanelQLKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQLKLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 58, Short.MAX_VALUE))
        );
        jPanelQLKLayout.setVerticalGroup(
            jPanelQLKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
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
        jLabelQLDH.setText("Quản lý đơn hàng");

        javax.swing.GroupLayout jPanelQLDHLayout = new javax.swing.GroupLayout(jPanelQLDH);
        jPanelQLDH.setLayout(jPanelQLDHLayout);
        jPanelQLDHLayout.setHorizontalGroup(
            jPanelQLDHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQLDHLayout.createSequentialGroup()
                .addComponent(jLabelQLDH, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 56, Short.MAX_VALUE))
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
        jLabelTTKH.setText("Thông tin khách hàng");
        jLabelTTKH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanelTTKHLayout = new javax.swing.GroupLayout(jPanelTTKH);
        jPanelTTKH.setLayout(jPanelTTKHLayout);
        jPanelTTKHLayout.setHorizontalGroup(
            jPanelTTKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTTKHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTTKH, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanelTTKHLayout.setVerticalGroup(
            jPanelTTKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTTKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelTTKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 270, 60));

        jBackground.add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 900));

        jPanelBody.setLayout(new java.awt.CardLayout());

        jDashboardQLK.setBackground(new java.awt.Color(255, 255, 255));
        jDashboardQLK.setForeground(new java.awt.Color(255, 255, 255));
        jDashboardQLK.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        );
        jPanelControlPageProductLayout.setVerticalGroup(
            jPanelControlPageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelControlPageProductLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanelControlPageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelSkipToStart)
                    .addComponent(jLabelSkipToEnd)
                    .addComponent(jLabelLeft)
                    .addComponent(jLabelRight)
                    .addGroup(jPanelControlPageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldPageProduct)
                        .addComponent(jLabelPageProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

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

        javax.swing.GroupLayout jPanelSelectPageLayout = new javax.swing.GroupLayout(jPanelSelectPage);
        jPanelSelectPage.setLayout(jPanelSelectPageLayout);
        jPanelSelectPageLayout.setHorizontalGroup(
            jPanelSelectPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGood1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelSelectPageLayout.createSequentialGroup()
                .addGroup(jPanelSelectPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelControlPageProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelGood6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelGood5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelGood4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelGood3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelGood2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelGood7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelSelectPageLayout.setVerticalGroup(
            jPanelSelectPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSelectPageLayout.createSequentialGroup()
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
                .addGap(0, 0, 0)
                .addComponent(jPanelControlPageProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDashboardQLK.add(jPanelSelectPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1330, 650));

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

        jDashboardQLK.add(jPanelControlQLK, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 140));

        jPanelBody.add(jDashboardQLK, "card3");

        jDashboardQLNCC.setBackground(new java.awt.Color(255, 153, 153));
        jDashboardQLNCC.setForeground(new java.awt.Color(255, 153, 153));
        jDashboardQLNCC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelSupplier8.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSupplier8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier8.setForeground(new java.awt.Color(255, 255, 255));
        jPanelSupplier8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBoxSupplier7.setBackground(new java.awt.Color(255, 255, 255));
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
        jPanelSupplier8.add(jLabelAddressSupplier8, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 280, 80));

        jLabelEmailSupplier8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailSupplier8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmailSupplier8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailSupplier8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmailSupplier8.setText("Email");
        jPanelSupplier8.add(jLabelEmailSupplier8, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 180, 80));

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

        jDashboardQLNCC.add(jPanelSupplier8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 1330, 80));

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
        jPanelSupplier7.add(jLabelAddressSupplier7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 280, 80));

        jLabelEmailSupplier7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailSupplier7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmailSupplier7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailSupplier7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmailSupplier7.setText("Email");
        jPanelSupplier7.add(jLabelEmailSupplier7, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 180, 80));

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

        jDashboardQLNCC.add(jPanelSupplier7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 1330, 80));

        jPanelSupplier6.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSupplier6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier6.setForeground(new java.awt.Color(255, 255, 255));
        jPanelSupplier6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBoxSupplier5.setBackground(new java.awt.Color(255, 255, 255));
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
        jPanelSupplier6.add(jLabelAddressSupplier6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 280, 80));

        jLabelEmailSupplier6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailSupplier6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmailSupplier6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailSupplier6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmailSupplier6.setText("Email");
        jPanelSupplier6.add(jLabelEmailSupplier6, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 180, 80));

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

        jDashboardQLNCC.add(jPanelSupplier6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 1330, 80));

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
        jPanelSupplier5.add(jLabelAddressSupplier5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 280, 80));

        jLabelEmailSupplier5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailSupplier5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmailSupplier5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailSupplier5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmailSupplier5.setText("Email");
        jPanelSupplier5.add(jLabelEmailSupplier5, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 180, 80));

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

        jDashboardQLNCC.add(jPanelSupplier5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 1330, 80));

        jPanelSupplier4.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSupplier4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier4.setForeground(new java.awt.Color(255, 255, 255));
        jPanelSupplier4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBoxSupplier3.setBackground(new java.awt.Color(255, 255, 255));
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
        jPanelSupplier4.add(jLabelAddressSupplier4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 280, 80));

        jLabelEmailSupplier4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailSupplier4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmailSupplier4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailSupplier4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmailSupplier4.setText("Email");
        jPanelSupplier4.add(jLabelEmailSupplier4, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 180, 80));

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

        jDashboardQLNCC.add(jPanelSupplier4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 1330, 80));

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
        jPanelSupplier3.add(jLabelAddressSupplier3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 280, 80));

        jLabelEmailSupplier3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailSupplier3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmailSupplier3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailSupplier3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmailSupplier3.setText("Email");
        jPanelSupplier3.add(jLabelEmailSupplier3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 180, 80));

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

        jDashboardQLNCC.add(jPanelSupplier3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 1330, 80));

        jPanelSupplier2.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSupplier2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier2.setForeground(new java.awt.Color(255, 255, 255));
        jPanelSupplier2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBoxSupplier1.setBackground(new java.awt.Color(255, 255, 255));
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
        jPanelSupplier2.add(jLabelAddressSupplier2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 280, 80));

        jLabelEmailSupplier2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailSupplier2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmailSupplier2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailSupplier2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmailSupplier2.setText("Email");
        jPanelSupplier2.add(jLabelEmailSupplier2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 180, 80));

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

        jDashboardQLNCC.add(jPanelSupplier2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1330, 80));

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
        jPanelSupplier1.add(jLabelAddressSupplier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 280, 80));

        jLabelEmailSupplier1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailSupplier1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmailSupplier1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailSupplier1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmailSupplier1.setText("Email");
        jPanelSupplier1.add(jLabelEmailSupplier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 180, 80));

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

        jDashboardQLNCC.add(jPanelSupplier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1330, 80));

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
        jPanelHeaderSupplier.add(jLabelCompany8, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 280, 40));

        jLabelPriceImport1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPriceImport1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPriceImport1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPriceImport1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPriceImport1.setText("Email");
        jPanelHeaderSupplier.add(jLabelPriceImport1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 180, 40));

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

        jDashboardQLNCC.add(jPanelHeaderSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, -1));

        jPanelControlPageProduct1.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout jPanelControlPageProduct1Layout = new javax.swing.GroupLayout(jPanelControlPageProduct1);
        jPanelControlPageProduct1.setLayout(jPanelControlPageProduct1Layout);
        jPanelControlPageProduct1Layout.setHorizontalGroup(
            jPanelControlPageProduct1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControlPageProduct1Layout.createSequentialGroup()
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
        jPanelControlPageProduct1Layout.setVerticalGroup(
            jPanelControlPageProduct1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelControlPageProduct1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanelControlPageProduct1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelSkipToStartSupplier)
                    .addComponent(jLabelSkipToEndSupplier)
                    .addComponent(jLabelLeftSupplier)
                    .addComponent(jLabelRightSupplier)
                    .addGroup(jPanelControlPageProduct1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldPageSupplier)
                        .addComponent(jLabelPageSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jDashboardQLNCC.add(jPanelControlPageProduct1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 740, 1330, -1));

        jPanelBody.add(jDashboardQLNCC, "card5");

        jDashboardQLNV.setBackground(new java.awt.Color(255, 255, 255));
        jDashboardQLNV.setForeground(new java.awt.Color(0, 0, 0));
        jDashboardQLNV.setPreferredSize(new java.awt.Dimension(1330, 790));
        jDashboardQLNV.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jDashboardQLNV.add(jPanelStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 380, 200));

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

        jDashboardQLNV.add(jPanelStaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 100, 380, 200));

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

        jDashboardQLNV.add(jPanelControlPageStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 720, 200, 30));

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

        jDashboardQLNV.add(jPanelStaff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, 380, 200));

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

        jDashboardQLNV.add(jPanelStaff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 300, 380, 200));

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

        jDashboardQLNV.add(jPanelStaff5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 500, 380, 200));

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

        jDashboardQLNV.add(jPanelStaff6, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 500, 380, 200));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jDashboardQLNV.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 10, 590));
        jDashboardQLNV.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 80, 1330, 10));

        jLabelTitleQLNV.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTitleQLNV.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitleQLNV.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTitleQLNV.setText("Quản lý nhân viên");
        jDashboardQLNV.add(jLabelTitleQLNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 230, -1));

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
        jDashboardQLNV.add(jTextFieldSearchStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(1081, 50, 240, 30));

        jLabelSearchStaff.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSearchStaff.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelSearchStaff.setForeground(new java.awt.Color(120, 120, 120));
        jLabelSearchStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_search_20px_1.png"))); // NOI18N
        jLabelSearchStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jDashboardQLNV.add(jLabelSearchStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 50, 30, 30));

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
        jDashboardQLNV.add(jLabelButtonAddStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 190, 30));

        jLabelBBButtonAddStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBBButtonAddStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jDashboardQLNV.add(jLabelBBButtonAddStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 190, 30));

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
        jDashboardQLNV.add(jLabelButtonRefreshStaffList, new org.netbeans.lib.awtextra.AbsoluteConstraints(885, 50, 130, 30));

        jLabelBBButtonRefreshStaffList.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBBButtonRefreshStaffList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jDashboardQLNV.add(jLabelBBButtonRefreshStaffList, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 50, 130, 30));

        jLabelFrameSearchStaff.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameSearchStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDashboardQLNV.add(jLabelFrameSearchStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 50, 280, 30));

        jPanelBody.add(jDashboardQLNV, "card5");

        jDashboardTK.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jDashboardTKLayout = new javax.swing.GroupLayout(jDashboardTK);
        jDashboardTK.setLayout(jDashboardTKLayout);
        jDashboardTKLayout.setHorizontalGroup(
            jDashboardTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1330, Short.MAX_VALUE)
        );
        jDashboardTKLayout.setVerticalGroup(
            jDashboardTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );

        jPanelBody.add(jDashboardTK, "card5");

        jDashboardTTKH.setBackground(new java.awt.Color(0, 204, 102));

        javax.swing.GroupLayout jDashboardTTKHLayout = new javax.swing.GroupLayout(jDashboardTTKH);
        jDashboardTTKH.setLayout(jDashboardTTKHLayout);
        jDashboardTTKHLayout.setHorizontalGroup(
            jDashboardTTKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1330, Short.MAX_VALUE)
        );
        jDashboardTTKHLayout.setVerticalGroup(
            jDashboardTTKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );

        jPanelBody.add(jDashboardTTKH, "card8");

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

        jDashboardInformationStaff.setBackground(new java.awt.Color(255, 255, 255));
        jDashboardInformationStaff.setForeground(new java.awt.Color(255, 255, 255));
        jDashboardInformationStaff.setPreferredSize(new java.awt.Dimension(1330, 790));
        jDashboardInformationStaff.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jDashboardInformationStaff.add(jLabelButtonDeleteStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 270, 40));

        jLabelBBButtonDeleteStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBBButtonDeleteStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jDashboardInformationStaff.add(jLabelBBButtonDeleteStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 270, 40));

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
        jDashboardInformationStaff.add(jLabelButtonStatusStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 270, 40));

        jLabelBBButtonStatusStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBBButtonStatusStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jDashboardInformationStaff.add(jLabelBBButtonStatusStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 270, 40));

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
        jDashboardInformationStaff.add(jLabelBackToQLNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 220, 40));

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
        jDashboardInformationStaff.add(jLabelButtonEditStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 270, 40));

        jLabelBBButtonEditStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBBButtonEditStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jDashboardInformationStaff.add(jLabelBBButtonEditStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 270, 40));
        jDashboardInformationStaff.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 1230, 10));

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
        jDashboardInformationStaff.add(jLabelFrameAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 200, 200));

        jLabelAvatarStaff.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatarStaff.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatarStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDashboardInformationStaff.add(jLabelAvatarStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 200, 200));

        jLabelInformationNameStaff.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationNameStaff.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabelInformationNameStaff.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationNameStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInformationNameStaff.setText("Phạm Duy Tài");
        jDashboardInformationStaff.add(jLabelInformationNameStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 240, -1));

        jLabelTT.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTT.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabelTT.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTT.setText(" / Thông tin chi tiết:");
        jLabelTT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jDashboardInformationStaff.add(jLabelTT, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 220, 40));

        jLabelInformationUsername.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationUsername.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelInformationUsername.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationUsername.setText("Tên đăng nhập:");
        jDashboardInformationStaff.add(jLabelInformationUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 440, 30));

        jLabelInformationId.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationId.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelInformationId.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationId.setText("Mã nhân viên:");
        jDashboardInformationStaff.add(jLabelInformationId, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 440, 30));

        jLabelInformationGender.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationGender.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelInformationGender.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationGender.setText("Giới tính:");
        jDashboardInformationStaff.add(jLabelInformationGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, 440, 30));

        jLabelInformationBirthday.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationBirthday.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelInformationBirthday.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationBirthday.setText("Ngày sinh:");
        jDashboardInformationStaff.add(jLabelInformationBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, 440, 30));

        jLabelInformationStartdate.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationStartdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelInformationStartdate.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationStartdate.setText("Ngày bắt đầu:");
        jDashboardInformationStaff.add(jLabelInformationStartdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, 440, 30));

        jLabelInformationAddress.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationAddress.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelInformationAddress.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationAddress.setText("Địa chỉ:");
        jDashboardInformationStaff.add(jLabelInformationAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 580, 440, 30));

        jLabelInformationPhonenumber.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationPhonenumber.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelInformationPhonenumber.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationPhonenumber.setText("Số điện thoại:");
        jDashboardInformationStaff.add(jLabelInformationPhonenumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 660, 440, 30));

        jLabelInformationEmail.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationEmail.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelInformationEmail.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationEmail.setText("Email:");
        jDashboardInformationStaff.add(jLabelInformationEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 620, 440, 30));

        jLabelInformationBasicsalary.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationBasicsalary.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelInformationBasicsalary.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationBasicsalary.setText("Lương cơ bản:");
        jDashboardInformationStaff.add(jLabelInformationBasicsalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 700, 440, 30));

        jLabelInformationAllowance.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationAllowance.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelInformationAllowance.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationAllowance.setText("Trợ cấp:");
        jDashboardInformationStaff.add(jLabelInformationAllowance, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 740, 440, 30));

        jLabelInformationId1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationId1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationId1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationId1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_identification_documents_25px.png"))); // NOI18N
        jLabelInformationId1.setText("Mã nhân viên:");
        jDashboardInformationStaff.add(jLabelInformationId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 160, 30));

        jLabelInformationUsername1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationUsername1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationUsername1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationUsername1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_name_25px.png"))); // NOI18N
        jLabelInformationUsername1.setText("Tên đăng nhập:");
        jDashboardInformationStaff.add(jLabelInformationUsername1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 160, 30));

        jLabelInformationGender1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationGender1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationGender1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationGender1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_25px.png"))); // NOI18N
        jLabelInformationGender1.setText("Giới tính:");
        jDashboardInformationStaff.add(jLabelInformationGender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 120, 30));

        jLabelInformationBirthday1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationBirthday1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationBirthday1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationBirthday1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_birthday_25px.png"))); // NOI18N
        jLabelInformationBirthday1.setText("Ngày sinh:");
        jDashboardInformationStaff.add(jLabelInformationBirthday1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 130, 30));

        jLabelInformationStartdate1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationStartdate1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationStartdate1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationStartdate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_maintenance_date_25px.png"))); // NOI18N
        jLabelInformationStartdate1.setText("Ngày bắt đầu:");
        jDashboardInformationStaff.add(jLabelInformationStartdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 150, 30));

        jLabelInformationAddress1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationAddress1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationAddress1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationAddress1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_home_address_25px.png"))); // NOI18N
        jLabelInformationAddress1.setText("Địa chỉ:");
        jDashboardInformationStaff.add(jLabelInformationAddress1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 580, 100, 30));

        jLabelInformationEmail1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationEmail1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationEmail1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationEmail1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gmail_25px_1.png"))); // NOI18N
        jLabelInformationEmail1.setText("Email:");
        jDashboardInformationStaff.add(jLabelInformationEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 620, 90, 30));

        jLabelInformationPhonenumber1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationPhonenumber1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationPhonenumber1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationPhonenumber1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_phone_25px.png"))); // NOI18N
        jLabelInformationPhonenumber1.setText("Số điện thoại:");
        jDashboardInformationStaff.add(jLabelInformationPhonenumber1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 660, 150, 30));

        jLabelInformationBasicsalary1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationBasicsalary1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationBasicsalary1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationBasicsalary1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_paycheque_25px.png"))); // NOI18N
        jLabelInformationBasicsalary1.setText("Lương cơ bản:");
        jDashboardInformationStaff.add(jLabelInformationBasicsalary1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 700, 150, 30));

        jLabelInformationAllowance1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationAllowance1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationAllowance1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationAllowance1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_loyalty_card_25px.png"))); // NOI18N
        jLabelInformationAllowance1.setText("Trợ cấp:");
        jDashboardInformationStaff.add(jLabelInformationAllowance1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 740, 100, 30));
        jDashboardInformationStaff.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 445, 440, 10));
        jDashboardInformationStaff.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 485, 440, 10));
        jDashboardInformationStaff.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 405, 440, 10));
        jDashboardInformationStaff.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 525, 440, 10));
        jDashboardInformationStaff.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 565, 440, 10));
        jDashboardInformationStaff.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 605, 440, 10));
        jDashboardInformationStaff.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 765, 440, 10));
        jDashboardInformationStaff.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 645, 440, 10));
        jDashboardInformationStaff.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 685, 440, 10));
        jDashboardInformationStaff.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 725, 440, 10));

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jDashboardInformationStaff.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, 10, 700));

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
        jDashboardInformationStaff.add(jLabelPreviousYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 300, 60, 20));

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

        jDashboardInformationStaff.add(jPanelCalendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 320, 420, 430));

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
        jDashboardInformationStaff.add(jLabelNextYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 300, 60, 20));

        jLabelTitleStatistical.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTitleStatistical.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabelTitleStatistical.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTitleStatistical.setText("Bảng công và doanh số:");
        jLabelTitleStatistical.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jDashboardInformationStaff.add(jLabelTitleStatistical, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 600, 40));

        jLabelNumberOfWorking.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumberOfWorking.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelNumberOfWorking.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNumberOfWorking.setText("- Số buổi:");
        jDashboardInformationStaff.add(jLabelNumberOfWorking, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, 560, 30));

        jLabelNumberOfStatistical.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumberOfStatistical.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelNumberOfStatistical.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNumberOfStatistical.setText("- Doanh số:");
        jDashboardInformationStaff.add(jLabelNumberOfStatistical, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, 560, 30));

        jLabelNumberOfSalary.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumberOfSalary.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelNumberOfSalary.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNumberOfSalary.setText("- Lương:");
        jDashboardInformationStaff.add(jLabelNumberOfSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 180, 560, 30));

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
        jDashboardInformationStaff.add(jLabelPreviousMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 500, 30, 60));

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
        jDashboardInformationStaff.add(jLabelNextMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 500, 30, 60));

        jLabelNameCalendar.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameCalendar.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabelNameCalendar.setForeground(new java.awt.Color(102, 102, 102));
        jLabelNameCalendar.setText("Bảng chấm công");
        jDashboardInformationStaff.add(jLabelNameCalendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 760, 100, -1));

        jPanelBody.add(jDashboardInformationStaff, "card8");

        jBackground.add(jPanelBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 1330, 790));

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
        jPanelQLK.setBackground(new java.awt.Color(0, 0, 0));
        jPanelQLNV.setBackground(new java.awt.Color(0, 0, 0));
        jPanelQLNCC.setBackground(new java.awt.Color(0, 0, 0));
        jPanelTK.setBackground(new java.awt.Color(0, 0, 0));
        jPanelTTKH.setBackground(new java.awt.Color(0, 0, 0));
        jPanelBody.removeAll();
        jPanelBody.add(jDashboardQLDH);
        jPanelBody.repaint();
        jPanelBody.revalidate();
    }//GEN-LAST:event_jPanelQLDHMouseClicked

    private void jPanelQLKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLKMouseClicked
        // TODO add your handling code here:
        qlhd = false;
        qlk = true;
        qlnv = false;
        qlncc = false;
        tk = false;
        ttkh = false;
        jPanelQLDH.setBackground(new java.awt.Color(0, 0, 0));
        jPanelQLK.setBackground(new java.awt.Color(102, 178, 255));
        jPanelQLNV.setBackground(new java.awt.Color(0, 0, 0));
        jPanelQLNCC.setBackground(new java.awt.Color(0, 0, 0));
        jPanelTK.setBackground(new java.awt.Color(0, 0, 0));
        jPanelTTKH.setBackground(new java.awt.Color(0, 0, 0));
        jPanelBody.removeAll();
//        jPanelBody.repaint();
//        jPanelBody.revalidate();
        jPanelBody.add(jDashboardQLK);
        jPanelBody.repaint();
        jPanelBody.revalidate();
    }//GEN-LAST:event_jPanelQLKMouseClicked

    private void jPanelQLNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLNCCMouseClicked
        // TODO add your handling code here:
        qlhd = false;
        qlk = false;
        qlnv = false;
        qlncc = true;
        tk = false;
        ttkh = false;
        jPanelQLDH.setBackground(new java.awt.Color(0, 0, 0));
        jPanelQLK.setBackground(new java.awt.Color(0, 0, 0));
        jPanelQLNV.setBackground(new java.awt.Color(0, 0, 0));
        jPanelQLNCC.setBackground(new java.awt.Color(102, 178, 255));
        jPanelTK.setBackground(new java.awt.Color(0, 0, 0));
        jPanelTTKH.setBackground(new java.awt.Color(0, 0, 0));
        jPanelBody.removeAll();
//        jPanelBody.repaint();
//        jPanelBody.revalidate();
        jPanelBody.add(jDashboardQLNCC);
        jPanelBody.repaint();
        jPanelBody.revalidate();
    }//GEN-LAST:event_jPanelQLNCCMouseClicked

    private void jPanelQLNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLNVMouseClicked
        // TODO add your handling code here:
        qlhd = false;
        qlk = false;
        qlnv = true;
        qlncc = false;
        tk = false;
        ttkh = false;
        jPanelQLDH.setBackground(new java.awt.Color(0, 0, 0));
        jPanelQLK.setBackground(new java.awt.Color(0, 0, 0));
        jPanelQLNV.setBackground(new java.awt.Color(102, 178, 255));
        jPanelQLNCC.setBackground(new java.awt.Color(0, 0, 0));
        jPanelTK.setBackground(new java.awt.Color(0, 0, 0));
        jPanelTTKH.setBackground(new java.awt.Color(0, 0, 0));
        jPanelBody.removeAll();
//        jPanelBody.repaint();
//        jPanelBody.revalidate();
        jPanelBody.add(jDashboardQLNV);
        jPanelBody.repaint();
        jPanelBody.revalidate();
    }//GEN-LAST:event_jPanelQLNVMouseClicked

    private void jPanelTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelTKMouseClicked
        // TODO add your handling code here:
        qlhd = false;
        qlk = false;
        qlnv = false;
        qlncc = false;
        tk = true;
        ttkh = false;
        jPanelQLDH.setBackground(new java.awt.Color(0, 0, 0));
        jPanelQLK.setBackground(new java.awt.Color(0, 0, 0));
        jPanelQLNV.setBackground(new java.awt.Color(0, 0, 0));
        jPanelQLNCC.setBackground(new java.awt.Color(0, 0, 0));
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

    private void jPanelQLKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLKMouseEntered
        // TODO add your handling code here:
        if (!qlk) {
            jPanelQLK.setBackground(new java.awt.Color(102, 102, 102));
        }
    }//GEN-LAST:event_jPanelQLKMouseEntered

    private void jPanelQLKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLKMouseExited
        // TODO add your handling code here:
        if (!qlk) {
            jPanelQLK.setBackground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_jPanelQLKMouseExited

    private void jPanelQLNCCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLNCCMouseEntered
        // TODO add your handling code here:
        if (!qlncc) {
            jPanelQLNCC.setBackground(new java.awt.Color(102, 102, 102));
        }
    }//GEN-LAST:event_jPanelQLNCCMouseEntered

    private void jPanelQLNCCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLNCCMouseExited
        // TODO add your handling code here:
        if (!qlncc) {
            jPanelQLNCC.setBackground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_jPanelQLNCCMouseExited

    private void jPanelQLNVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLNVMouseEntered
        // TODO add your handling code here:
        if (!qlnv) {
            jPanelQLNV.setBackground(new java.awt.Color(102, 102, 102));
        }
    }//GEN-LAST:event_jPanelQLNVMouseEntered

    private void jPanelQLNVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQLNVMouseExited
        // TODO add your handling code here:
        if (!qlnv) {
            jPanelQLNV.setBackground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_jPanelQLNVMouseExited

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
        jPanelQLK.setBackground(new java.awt.Color(0, 0, 0));
        jPanelQLNV.setBackground(new java.awt.Color(0, 0, 0));
        jPanelQLNCC.setBackground(new java.awt.Color(0, 0, 0));
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

    private void jLabelSkipToStartMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartMouseEntered
        // TODO add your handling code here:
        jLabelSkipToStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px.png")));
    }//GEN-LAST:event_jLabelSkipToStartMouseEntered

    private void jLabelSkipToStartMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartMouseExited
        // TODO add your handling code here:
        jLabelSkipToStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px_1.png")));

    }//GEN-LAST:event_jLabelSkipToStartMouseExited

    private void jLabelLeftMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftMouseEntered
        // TODO add your handling code here:
        jLabelLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px.png")));
    }//GEN-LAST:event_jLabelLeftMouseEntered

    private void jLabelLeftMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftMouseExited
        // TODO add your handling code here:
        jLabelLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px_1.png")));
    }//GEN-LAST:event_jLabelLeftMouseExited

    private void jLabelRightMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightMouseEntered
        // TODO add your handling code here:
        jLabelRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px_1.png")));
    }//GEN-LAST:event_jLabelRightMouseEntered

    private void jLabelRightMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightMouseExited
        // TODO add your handling code here:

        jLabelRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px.png")));
    }//GEN-LAST:event_jLabelRightMouseExited

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

    private void jComboBoxTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTypeActionPerformed
        if (jComboBoxType.getSelectedItem().toString().equals("Tất cả")) {
            try {
                ListGoods = GoodsConnectToDatabase.findAll();
                countProduct = GoodsConnectToDatabase.countProduct();
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            try {
                ListGoods = GoodsConnectToDatabase.findBy(jComboBoxType.getSelectedItem().toString());
                countProduct = GoodsConnectToDatabase.countProductBy(jComboBoxType.getSelectedItem().toString());
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

    private void jLabelNameStaff1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff1MouseEntered
        // TODO add your handling code here:
        jLabelNameStaff1.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelNameStaff1MouseEntered

    private void jLabelNameStaff1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff1MouseExited
        // TODO add your handling code here:
        jLabelNameStaff1.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameStaff1MouseExited

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

    private void jLabelNameStaff4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff4MouseEntered
        // TODO add your handling code here:
        jLabelNameStaff4.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelNameStaff4MouseEntered

    private void jLabelNameStaff4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff4MouseExited
        // TODO add your handling code here:
        jLabelNameStaff4.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameStaff4MouseExited

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

    private void jLabelNameStaff6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff6MouseEntered
        // TODO add your handling code here:
        jLabelNameStaff6.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelNameStaff6MouseEntered

    private void jLabelNameStaff6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff6MouseExited
        // TODO add your handling code here:
        jLabelNameStaff6.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameStaff6MouseExited

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

    private void jTextFieldPageStaffKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPageStaffKeyReleased
        // TODO add your handling code here:
        try {
            showStaffList(ListUsers, countStaff);
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldPageStaffKeyReleased

    private void jLabelRight2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRight2MouseClicked
        // TODO add your handling code here:
        int jlabelrighta = Integer.parseInt(jTextFieldPageStaff.getText());
        int jlabelrightb = countStaff / 6 + setPageStaff;
        if (jlabelrighta < jlabelrightb) {
            jTextFieldPageStaff.setText(String.valueOf(jlabelrighta + 1));
            try {
                showStaffList(ListUsers, countStaff);
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
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
        int jlabelrightb = countStaff / 6 + setPageStaff;
        if (jlabelrighta < jlabelrightb) {
            jTextFieldPageStaff.setText(String.valueOf(countStaff / 6 + setPageStaff));
            try {
                showStaffList(ListUsers, countStaff);
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
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

    private void jLabelAvatarClick1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarClick1MouseClicked
        // TODO add your handling code here:
        popUpImageStaff(0);
    }//GEN-LAST:event_jLabelAvatarClick1MouseClicked

    private void jLabelAvatarClick2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarClick2MouseClicked
        // TODO add your handling code here:
        popUpImageStaff(1);
    }//GEN-LAST:event_jLabelAvatarClick2MouseClicked

    private void jLabelAvatarClick3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarClick3MouseClicked
        // TODO add your handling code here:
        popUpImageStaff(2);
    }//GEN-LAST:event_jLabelAvatarClick3MouseClicked

    private void jLabelAvatarClick4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarClick4MouseClicked
        // TODO add your handling code here:
        popUpImageStaff(3);
    }//GEN-LAST:event_jLabelAvatarClick4MouseClicked

    private void jLabelAvatarClick5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarClick5MouseClicked
        // TODO add your handling code here:
        popUpImageStaff(4);
    }//GEN-LAST:event_jLabelAvatarClick5MouseClicked

    private void jLabelAvatarClick6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarClick6MouseClicked
        // TODO add your handling code here:
        popUpImageStaff(5);
    }//GEN-LAST:event_jLabelAvatarClick6MouseClicked

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

    private void jLabelNameStaff1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff1MouseClicked
        // TODO add your handling code here:
        jLabelNameStaff1.setForeground(new java.awt.Color(0, 0, 0));
        jPanelBody.removeAll();
        jPanelBody.add(jDashboardInformationStaff);
        jPanelBody.repaint();
        jPanelBody.revalidate();
        try {
            renderJDashboardImformationStaff(0);
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        thisStaff = 0;
    }//GEN-LAST:event_jLabelNameStaff1MouseClicked

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
        jLabelBackToQLNV.setForeground(new java.awt.Color(0, 0, 0));
        jLabelBackToQLNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_back_20px.png")));
        try {
            showStaffList(ListUsers, countStaff);
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        jPanelBody.removeAll();
        jPanelBody.add(jDashboardQLNV);
        jPanelBody.repaint();
        jPanelBody.revalidate();
    }//GEN-LAST:event_jLabelBackToQLNVMouseClicked

    private void jLabelFrameAvatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelFrameAvatarMouseClicked
        // TODO add your handling code here:
        popUpImageStaff(thisStaff);
    }//GEN-LAST:event_jLabelFrameAvatarMouseClicked

    private void jLabelNameStaff2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff2MouseClicked
        // TODO add your handling code here:
        jLabelNameStaff2.setForeground(new java.awt.Color(0, 0, 0));
        jPanelBody.removeAll();
        jPanelBody.add(jDashboardInformationStaff);
        jPanelBody.repaint();
        jPanelBody.revalidate();
        try {
            renderJDashboardImformationStaff(1);
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        thisStaff = 1;
    }//GEN-LAST:event_jLabelNameStaff2MouseClicked

    private void jLabelNameStaff3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff3MouseClicked
        // TODO add your handling code here:
        jLabelNameStaff3.setForeground(new java.awt.Color(0, 0, 0));
        jPanelBody.removeAll();
        jPanelBody.add(jDashboardInformationStaff);
        jPanelBody.repaint();
        jPanelBody.revalidate();
        try {
            renderJDashboardImformationStaff(2);
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        thisStaff = 2;
    }//GEN-LAST:event_jLabelNameStaff3MouseClicked

    private void jLabelNameStaff4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff4MouseClicked
        // TODO add your handling code here:
        jLabelNameStaff4.setForeground(new java.awt.Color(0, 0, 0));
        jPanelBody.removeAll();
        jPanelBody.add(jDashboardInformationStaff);
        jPanelBody.repaint();
        jPanelBody.revalidate();
        try {
            renderJDashboardImformationStaff(3);
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        thisStaff = 3;
    }//GEN-LAST:event_jLabelNameStaff4MouseClicked

    private void jLabelNameStaff5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff5MouseClicked
        // TODO add your handling code here:
        jLabelNameStaff5.setForeground(new java.awt.Color(0, 0, 0));
        jPanelBody.removeAll();
        jPanelBody.add(jDashboardInformationStaff);
        jPanelBody.repaint();
        jPanelBody.revalidate();
        try {
            renderJDashboardImformationStaff(4);
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        thisStaff = 4;
    }//GEN-LAST:event_jLabelNameStaff5MouseClicked

    private void jLabelNameStaff6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff6MouseClicked
        // TODO add your handling code here:
        jLabelNameStaff6.setForeground(new java.awt.Color(0, 0, 0));
        jPanelBody.removeAll();
        jPanelBody.add(jDashboardInformationStaff);
        jPanelBody.repaint();
        jPanelBody.revalidate();
        try {
            renderJDashboardImformationStaff(5);
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        thisStaff = 5;
    }//GEN-LAST:event_jLabelNameStaff6MouseClicked

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

    private void jLabelStatusStaff1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStatusStaff1MouseClicked
        setPageStaff = (countStaff % 6 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 6 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 6;
        u = ListUsers.get(pageStaff);
        ConfirmOperations co = new ConfirmOperations(u);
        co.setVisible(true);
        co.pack();
    }//GEN-LAST:event_jLabelStatusStaff1MouseClicked

    private void jLabelStatusStaff2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStatusStaff2MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 6 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 6 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 6;
        u = ListUsers.get(pageStaff + 1);
        ConfirmOperations co = new ConfirmOperations(u);
        co.setVisible(true);
        co.pack();

    }//GEN-LAST:event_jLabelStatusStaff2MouseClicked

    private void jLabelStatusStaff3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStatusStaff3MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 6 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 6 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 6;
        u = ListUsers.get(pageStaff + 2);
        ConfirmOperations co = new ConfirmOperations(u);
        co.setVisible(true);
        co.pack();
    }//GEN-LAST:event_jLabelStatusStaff3MouseClicked

    private void jLabelStatusStaff4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStatusStaff4MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 6 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 6 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 6;
        u = ListUsers.get(pageStaff + 3);
        ConfirmOperations co = new ConfirmOperations(u);
        co.setVisible(true);
        co.pack();
    }//GEN-LAST:event_jLabelStatusStaff4MouseClicked

    private void jLabelStatusStaff5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStatusStaff5MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 6 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 6 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 6;
        u = ListUsers.get(pageStaff + 4);
        ConfirmOperations co = new ConfirmOperations(u);
        co.setVisible(true);
        co.pack();
    }//GEN-LAST:event_jLabelStatusStaff5MouseClicked

    private void jLabelStatusStaff6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStatusStaff6MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 6 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 6 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 6;
        u = ListUsers.get(pageStaff + 5);
        ConfirmOperations co = new ConfirmOperations(u);
        co.setVisible(true);
        co.pack();
    }//GEN-LAST:event_jLabelStatusStaff6MouseClicked

    private void jLabelDeleteStaff1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff1MouseEntered
        // TODO add your handling code here:
        jLabelDeleteStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDeleteStaff1MouseEntered

    private void jLabelDeleteStaff1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff1MouseExited
        // TODO add your handling code here:
        jLabelDeleteStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDeleteStaff1MouseExited

    private void jLabelDeleteStaff2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff2MouseEntered
        // TODO add your handling code here:
        jLabelDeleteStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDeleteStaff2MouseEntered

    private void jLabelDeleteStaff2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff2MouseExited
        // TODO add your handling code here:
        jLabelDeleteStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDeleteStaff2MouseExited

    private void jLabelDeleteStaff3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff3MouseEntered
        // TODO add your handling code here:
        jLabelDeleteStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDeleteStaff3MouseEntered

    private void jLabelDeleteStaff3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff3MouseExited
        // TODO add your handling code here:
        jLabelDeleteStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDeleteStaff3MouseExited

    private void jLabelDeleteStaff4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff4MouseEntered
        // TODO add your handling code here:
        jLabelDeleteStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDeleteStaff4MouseEntered

    private void jLabelDeleteStaff4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff4MouseExited
        jLabelDeleteStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDeleteStaff4MouseExited

    private void jLabelDeleteStaff5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff5MouseEntered
        jLabelDeleteStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDeleteStaff5MouseEntered

    private void jLabelDeleteStaff5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff5MouseExited
        jLabelDeleteStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDeleteStaff5MouseExited

    private void jLabelDeleteStaff6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff6MouseEntered
        jLabelDeleteStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDeleteStaff6MouseEntered

    private void jLabelDeleteStaff6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff6MouseExited
        jLabelDeleteStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDeleteStaff6MouseExited

    private void jLabelEditStaff1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff1MouseEntered
        jLabelEditStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px_1.png")));
    }//GEN-LAST:event_jLabelEditStaff1MouseEntered

    private void jLabelEditStaff1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff1MouseExited
        // TODO add your handling code here:
        jLabelEditStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png")));
    }//GEN-LAST:event_jLabelEditStaff1MouseExited

    private void jLabelEditStaff2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff2MouseEntered
        // TODO add your handling code here:
        jLabelEditStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px_1.png")));
    }//GEN-LAST:event_jLabelEditStaff2MouseEntered

    private void jLabelEditStaff2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff2MouseExited
        // TODO add your handling code here:
        jLabelEditStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png")));
    }//GEN-LAST:event_jLabelEditStaff2MouseExited

    private void jLabelEditStaff3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff3MouseEntered
        // TODO add your handling code here:
        jLabelEditStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px_1.png")));
    }//GEN-LAST:event_jLabelEditStaff3MouseEntered

    private void jLabelEditStaff3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff3MouseExited
        // TODO add your handling code here:
        jLabelEditStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png")));
    }//GEN-LAST:event_jLabelEditStaff3MouseExited

    private void jLabelEditStaff4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff4MouseEntered
        // TODO add your handling code here:
        jLabelEditStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px_1.png")));
    }//GEN-LAST:event_jLabelEditStaff4MouseEntered

    private void jLabelEditStaff4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff4MouseExited
        // TODO add your handling code here:
        jLabelEditStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png")));
    }//GEN-LAST:event_jLabelEditStaff4MouseExited

    private void jLabelEditStaff5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff5MouseEntered
        // TODO add your handling code here:
        jLabelEditStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px_1.png")));
    }//GEN-LAST:event_jLabelEditStaff5MouseEntered

    private void jLabelEditStaff5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff5MouseExited
        // TODO add your handling code here:
        jLabelEditStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png")));
    }//GEN-LAST:event_jLabelEditStaff5MouseExited

    private void jLabelEditStaff6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff6MouseEntered
        // TODO add your handling code here:
        jLabelEditStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px_1.png")));
    }//GEN-LAST:event_jLabelEditStaff6MouseEntered

    private void jLabelEditStaff6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff6MouseExited
        // TODO add your handling code here:
        jLabelEditStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png")));
    }//GEN-LAST:event_jLabelEditStaff6MouseExited

    private void jLabelDeleteStaff1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff1MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 6 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 6 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 6;
        u = ListUsers.get(pageStaff);
        ConfirmDeleteStaff cd = new ConfirmDeleteStaff(u);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_jLabelDeleteStaff1MouseClicked

    private void jLabelDeleteStaff2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff2MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 6 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 6 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 6;
        u = ListUsers.get(pageStaff + 1);
        ConfirmDeleteStaff cd = new ConfirmDeleteStaff(u);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_jLabelDeleteStaff2MouseClicked

    private void jLabelDeleteStaff3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff3MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 6 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 6 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 6;
        u = ListUsers.get(pageStaff + 2);
        ConfirmDeleteStaff cd = new ConfirmDeleteStaff(u);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_jLabelDeleteStaff3MouseClicked

    private void jLabelDeleteStaff4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff4MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 6 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 6 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 6;
        u = ListUsers.get(pageStaff + 3);
        ConfirmDeleteStaff cd = new ConfirmDeleteStaff(u);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_jLabelDeleteStaff4MouseClicked

    private void jLabelDeleteStaff5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff5MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 6 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 6 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 6;
        u = ListUsers.get(pageStaff + 4);
        ConfirmDeleteStaff cd = new ConfirmDeleteStaff(u);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_jLabelDeleteStaff5MouseClicked

    private void jLabelDeleteStaff6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff6MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 6 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 6 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 6;
        u = ListUsers.get(pageStaff + 5);
        ConfirmDeleteStaff cd = new ConfirmDeleteStaff(u);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_jLabelDeleteStaff6MouseClicked

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

    private void jLabelEditStaff1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff1MouseClicked
        setPageStaff = (countStaff % 6 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 6 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 6;
        u = ListUsers.get(pageStaff);
        EditStaff es = new EditStaff(u, "Sửa thông tin nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelEditStaff1MouseClicked

    private void jLabelEditStaff2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff2MouseClicked
        setPageStaff = (countStaff % 6 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 6 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 6;
        u = ListUsers.get(pageStaff + 1);
        EditStaff es = new EditStaff(u, "Sửa thông tin nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelEditStaff2MouseClicked

    private void jLabelEditStaff3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff3MouseClicked
        setPageStaff = (countStaff % 6 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 6 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 6;
        u = ListUsers.get(pageStaff + 2);
        EditStaff es = new EditStaff(u, "Sửa thông tin nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelEditStaff3MouseClicked

    private void jLabelEditStaff4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff4MouseClicked
        setPageStaff = (countStaff % 6 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 6 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 6;
        u = ListUsers.get(pageStaff + 3);
        EditStaff es = new EditStaff(u, "Sửa thông tin nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelEditStaff4MouseClicked

    private void jLabelEditStaff5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff5MouseClicked
        setPageStaff = (countStaff % 6 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 6 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 6;
        u = ListUsers.get(pageStaff + 4);
        EditStaff es = new EditStaff(u, "Sửa thông tin nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelEditStaff5MouseClicked

    private void jLabelEditStaff6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff6MouseClicked
        setPageStaff = (countStaff % 6 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 6 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 6;
        u = ListUsers.get(pageStaff + 5);
        EditStaff es = new EditStaff(u, "Sửa thông tin nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelEditStaff6MouseClicked

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
            ListUsers = UsersConnectToDatabase.searchStaff(searchKey);
            countStaff = UsersConnectToDatabase.countStaffSearch(searchKey);
            showStaffList(ListUsers, countStaff);
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTextFieldSearchStaffKeyReleased

    private void jLabelButtonRefreshStaffListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonRefreshStaffListMouseClicked
        // TODO add your handling code here:
        try {
            ListUsers = UsersConnectToDatabase.findStaff();
            countStaff = UsersConnectToDatabase.countStaff();
            showStaffList(ListUsers, countStaff);
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelButtonRefreshStaffListMouseClicked

    private void jLabelButtonRefreshStaffListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonRefreshStaffListMouseEntered
        // TODO add your handling code here:
        jLabelBBButtonRefreshStaffList.setIcon(scaleButtonRefresh("/Image/ButtonEditDark.png"));
    }//GEN-LAST:event_jLabelButtonRefreshStaffListMouseEntered

    private void jLabelButtonRefreshStaffListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonRefreshStaffListMouseExited
        jLabelBBButtonRefreshStaffList.setIcon(scaleButtonRefresh("/Image/ButtonEditLight.png"));
    }//GEN-LAST:event_jLabelButtonRefreshStaffListMouseExited

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
            ListGoods = GoodsConnectToDatabase.searchProduct(jTextFieldSearchProduct.getText());
            countProduct = GoodsConnectToDatabase.countSearchProduct(jTextFieldSearchProduct.getText());
            showProducts(ListGoods, countProduct);
            jTextFieldPageProduct.setText("1");
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldSearchProductKeyReleased

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
        if(jTextFieldPageBill.getText().equals("")){
            jTextFieldPageBill.setText("Tìm kiếm");
        }
    }//GEN-LAST:event_jTextFieldSearchBillFocusLost

    private void jTextFieldSearchBillKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchBillKeyReleased
        if(jTextFieldSearchProduct.getText().equals("")){
            try {
                ListBills = BillConnectToDatabase.findAllBill();
                countBill = BillConnectToDatabase.countBill();
                showBillList(ListBills, countBill);
                jTextFieldPageBill.setText("1");
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            try {
                ListBills = BillConnectToDatabase.searchBill(jTextFieldSearchBill.getText());
                countBill = BillConnectToDatabase.countsearchBill(jTextFieldSearchBill.getText());
                showBillList(ListBills, countBill);
                jTextFieldPageBill.setText("1");
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_jTextFieldSearchBillKeyReleased

    private void jTextFieldPageSupplierKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPageSupplierKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPageSupplierKeyPressed

    private void jTextFieldPageSupplierKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPageSupplierKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPageSupplierKeyReleased

    private void jLabelRightSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightSupplierMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelRightSupplierMouseClicked

    private void jLabelRightSupplierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightSupplierMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelRightSupplierMouseEntered

    private void jLabelRightSupplierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightSupplierMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelRightSupplierMouseExited

    private void jLabelLeftSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftSupplierMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelLeftSupplierMouseClicked

    private void jLabelLeftSupplierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftSupplierMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelLeftSupplierMouseEntered

    private void jLabelLeftSupplierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftSupplierMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelLeftSupplierMouseExited

    private void jLabelSkipToEndSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndSupplierMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelSkipToEndSupplierMouseClicked

    private void jLabelSkipToEndSupplierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndSupplierMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelSkipToEndSupplierMouseEntered

    private void jLabelSkipToEndSupplierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndSupplierMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelSkipToEndSupplierMouseExited

    private void jLabelSkipToStartSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartSupplierMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelSkipToStartSupplierMouseClicked

    private void jLabelSkipToStartSupplierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartSupplierMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelSkipToStartSupplierMouseEntered

    private void jLabelSkipToStartSupplierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartSupplierMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelSkipToStartSupplierMouseExited

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
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBoxAll;
    private javax.swing.JCheckBox jCheckBoxAll1;
    private javax.swing.JCheckBox jCheckBoxAllBill;
    private javax.swing.JCheckBox jCheckBoxAllBill1;
    private javax.swing.JCheckBox jCheckBoxAllBill2;
    private javax.swing.JCheckBox jCheckBoxAllBill3;
    private javax.swing.JCheckBox jCheckBoxAllBill4;
    private javax.swing.JCheckBox jCheckBoxAllBill5;
    private javax.swing.JCheckBox jCheckBoxSupplier;
    private javax.swing.JCheckBox jCheckBoxSupplier1;
    private javax.swing.JCheckBox jCheckBoxSupplier2;
    private javax.swing.JCheckBox jCheckBoxSupplier3;
    private javax.swing.JCheckBox jCheckBoxSupplier4;
    private javax.swing.JCheckBox jCheckBoxSupplier5;
    private javax.swing.JCheckBox jCheckBoxSupplier6;
    private javax.swing.JCheckBox jCheckBoxSupplier7;
    private javax.swing.JComboBox<String> jComboBoxType;
    private javax.swing.JPanel jDashboardInformationStaff;
    private javax.swing.JPanel jDashboardQLDH;
    private javax.swing.JPanel jDashboardQLK;
    private javax.swing.JPanel jDashboardQLNCC;
    private javax.swing.JPanel jDashboardQLNV;
    private javax.swing.JPanel jDashboardTK;
    private javax.swing.JPanel jDashboardTTKH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelAddressStaff1;
    private javax.swing.JLabel jLabelAddressStaff2;
    private javax.swing.JLabel jLabelAddressStaff3;
    private javax.swing.JLabel jLabelAddressStaff4;
    private javax.swing.JLabel jLabelAddressStaff5;
    private javax.swing.JLabel jLabelAddressStaff6;
    private javax.swing.JLabel jLabelAddressSupplier1;
    private javax.swing.JLabel jLabelAddressSupplier2;
    private javax.swing.JLabel jLabelAddressSupplier3;
    private javax.swing.JLabel jLabelAddressSupplier4;
    private javax.swing.JLabel jLabelAddressSupplier5;
    private javax.swing.JLabel jLabelAddressSupplier6;
    private javax.swing.JLabel jLabelAddressSupplier7;
    private javax.swing.JLabel jLabelAddressSupplier8;
    private javax.swing.JLabel jLabelAmount;
    private javax.swing.JLabel jLabelAmount1;
    private javax.swing.JLabel jLabelAmount2;
    private javax.swing.JLabel jLabelAmount3;
    private javax.swing.JLabel jLabelAmount4;
    private javax.swing.JLabel jLabelAmount5;
    private javax.swing.JLabel jLabelAmount6;
    private javax.swing.JLabel jLabelAmount7;
    private javax.swing.JLabel jLabelAvatar1;
    private javax.swing.JLabel jLabelAvatar2;
    private javax.swing.JLabel jLabelAvatar3;
    private javax.swing.JLabel jLabelAvatar4;
    private javax.swing.JLabel jLabelAvatar5;
    private javax.swing.JLabel jLabelAvatar6;
    private javax.swing.JLabel jLabelAvatarClick1;
    private javax.swing.JLabel jLabelAvatarClick2;
    private javax.swing.JLabel jLabelAvatarClick3;
    private javax.swing.JLabel jLabelAvatarClick4;
    private javax.swing.JLabel jLabelAvatarClick5;
    private javax.swing.JLabel jLabelAvatarClick6;
    private javax.swing.JLabel jLabelAvatarStaff;
    private javax.swing.JLabel jLabelBBButtonAddStaff;
    private javax.swing.JLabel jLabelBBButtonDeleteStaff;
    private javax.swing.JLabel jLabelBBButtonEditStaff;
    private javax.swing.JLabel jLabelBBButtonRefreshStaffList;
    private javax.swing.JLabel jLabelBBButtonStatusStaff;
    private javax.swing.JLabel jLabelBackToQLNV;
    private javax.swing.JLabel jLabelButtonAddStaff;
    private javax.swing.JLabel jLabelButtonDeleteStaff;
    private javax.swing.JLabel jLabelButtonEditStaff;
    private javax.swing.JLabel jLabelButtonRefreshStaffList;
    private javax.swing.JLabel jLabelButtonStatusStaff;
    private javax.swing.JLabel jLabelCompany;
    private javax.swing.JLabel jLabelCompany1;
    private javax.swing.JLabel jLabelCompany2;
    private javax.swing.JLabel jLabelCompany3;
    private javax.swing.JLabel jLabelCompany4;
    private javax.swing.JLabel jLabelCompany5;
    private javax.swing.JLabel jLabelCompany6;
    private javax.swing.JLabel jLabelCompany7;
    private javax.swing.JLabel jLabelCompany8;
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
    private javax.swing.JLabel jLabelDeleteStaff1;
    private javax.swing.JLabel jLabelDeleteStaff2;
    private javax.swing.JLabel jLabelDeleteStaff3;
    private javax.swing.JLabel jLabelDeleteStaff4;
    private javax.swing.JLabel jLabelDeleteStaff5;
    private javax.swing.JLabel jLabelDeleteStaff6;
    private javax.swing.JLabel jLabelDiscountBill;
    private javax.swing.JLabel jLabelDiscountBill1;
    private javax.swing.JLabel jLabelDiscountBill2;
    private javax.swing.JLabel jLabelDiscountBill3;
    private javax.swing.JLabel jLabelDiscountBill4;
    private javax.swing.JLabel jLabelDiscountBill5;
    private javax.swing.JLabel jLabelEditStaff1;
    private javax.swing.JLabel jLabelEditStaff2;
    private javax.swing.JLabel jLabelEditStaff3;
    private javax.swing.JLabel jLabelEditStaff4;
    private javax.swing.JLabel jLabelEditStaff5;
    private javax.swing.JLabel jLabelEditStaff6;
    private javax.swing.JLabel jLabelEmailStaff1;
    private javax.swing.JLabel jLabelEmailStaff2;
    private javax.swing.JLabel jLabelEmailStaff3;
    private javax.swing.JLabel jLabelEmailStaff4;
    private javax.swing.JLabel jLabelEmailStaff5;
    private javax.swing.JLabel jLabelEmailStaff6;
    private javax.swing.JLabel jLabelEmailSupplier1;
    private javax.swing.JLabel jLabelEmailSupplier2;
    private javax.swing.JLabel jLabelEmailSupplier3;
    private javax.swing.JLabel jLabelEmailSupplier4;
    private javax.swing.JLabel jLabelEmailSupplier5;
    private javax.swing.JLabel jLabelEmailSupplier6;
    private javax.swing.JLabel jLabelEmailSupplier7;
    private javax.swing.JLabel jLabelEmailSupplier8;
    private javax.swing.JLabel jLabelFrameAvatar;
    private javax.swing.JLabel jLabelFrameSearchBill;
    private javax.swing.JLabel jLabelFrameSearchProduct;
    private javax.swing.JLabel jLabelFrameSearchStaff;
    private javax.swing.JLabel jLabelFrameStaff1;
    private javax.swing.JLabel jLabelFrameStaff2;
    private javax.swing.JLabel jLabelFrameStaff3;
    private javax.swing.JLabel jLabelFrameStaff4;
    private javax.swing.JLabel jLabelFrameStaff5;
    private javax.swing.JLabel jLabelFrameStaff6;
    private javax.swing.JLabel jLabelGenderStaff1;
    private javax.swing.JLabel jLabelGenderStaff2;
    private javax.swing.JLabel jLabelGenderStaff3;
    private javax.swing.JLabel jLabelGenderStaff4;
    private javax.swing.JLabel jLabelGenderStaff5;
    private javax.swing.JLabel jLabelGenderStaff6;
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
    private javax.swing.JLabel jLabelIdSupplier1;
    private javax.swing.JLabel jLabelIdSupplier2;
    private javax.swing.JLabel jLabelIdSupplier3;
    private javax.swing.JLabel jLabelIdSupplier4;
    private javax.swing.JLabel jLabelIdSupplier5;
    private javax.swing.JLabel jLabelIdSupplier6;
    private javax.swing.JLabel jLabelIdSupplier7;
    private javax.swing.JLabel jLabelIdSupplier8;
    private javax.swing.JLabel jLabelImage;
    private javax.swing.JLabel jLabelImage1;
    private javax.swing.JLabel jLabelImage2;
    private javax.swing.JLabel jLabelImage3;
    private javax.swing.JLabel jLabelImage4;
    private javax.swing.JLabel jLabelImage5;
    private javax.swing.JLabel jLabelImage6;
    private javax.swing.JLabel jLabelImage7;
    private javax.swing.JLabel jLabelImage8;
    private javax.swing.JLabel jLabelImportPrice1;
    private javax.swing.JLabel jLabelImportPrice2;
    private javax.swing.JLabel jLabelImportPrice3;
    private javax.swing.JLabel jLabelImportPrice4;
    private javax.swing.JLabel jLabelImportPrice5;
    private javax.swing.JLabel jLabelImportPrice6;
    private javax.swing.JLabel jLabelImportPrice7;
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
    private javax.swing.JLabel jLabelLeft;
    private javax.swing.JLabel jLabelLeft2;
    private javax.swing.JLabel jLabelLeftPageBill;
    private javax.swing.JLabel jLabelLeftSupplier;
    private javax.swing.JLabel jLabelLogoSupplier1;
    private javax.swing.JLabel jLabelLogoSupplier2;
    private javax.swing.JLabel jLabelLogoSupplier3;
    private javax.swing.JLabel jLabelLogoSupplier4;
    private javax.swing.JLabel jLabelLogoSupplier5;
    private javax.swing.JLabel jLabelLogoSupplier6;
    private javax.swing.JLabel jLabelLogoSupplier7;
    private javax.swing.JLabel jLabelLogoSupplier8;
    private javax.swing.JLabel jLabelMSP1;
    private javax.swing.JLabel jLabelMSP2;
    private javax.swing.JLabel jLabelMSP3;
    private javax.swing.JLabel jLabelMSP4;
    private javax.swing.JLabel jLabelMSP5;
    private javax.swing.JLabel jLabelMSP6;
    private javax.swing.JLabel jLabelMSP7;
    private javax.swing.JLabel jLabelMaSP;
    private javax.swing.JLabel jLabelMaSP1;
    private javax.swing.JLabel jLabelMessengerStaff1;
    private javax.swing.JLabel jLabelMessengerStaff2;
    private javax.swing.JLabel jLabelMessengerStaff3;
    private javax.swing.JLabel jLabelMessengerStaff4;
    private javax.swing.JLabel jLabelMessengerStaff5;
    private javax.swing.JLabel jLabelMessengerStaff6;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelName1;
    private javax.swing.JLabel jLabelName2;
    private javax.swing.JLabel jLabelName3;
    private javax.swing.JLabel jLabelName4;
    private javax.swing.JLabel jLabelName5;
    private javax.swing.JLabel jLabelName6;
    private javax.swing.JLabel jLabelName7;
    private javax.swing.JLabel jLabelName8;
    private javax.swing.JLabel jLabelNameCalendar;
    private javax.swing.JLabel jLabelNameStaff1;
    private javax.swing.JLabel jLabelNameStaff2;
    private javax.swing.JLabel jLabelNameStaff3;
    private javax.swing.JLabel jLabelNameStaff4;
    private javax.swing.JLabel jLabelNameStaff5;
    private javax.swing.JLabel jLabelNameStaff6;
    private javax.swing.JLabel jLabelNameStaffBill1;
    private javax.swing.JLabel jLabelNameStaffBill2;
    private javax.swing.JLabel jLabelNameStaffBill3;
    private javax.swing.JLabel jLabelNameStaffBill4;
    private javax.swing.JLabel jLabelNameStaffBill5;
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
    private javax.swing.JLabel jLabelPageProduct;
    private javax.swing.JLabel jLabelPageStaff;
    private javax.swing.JLabel jLabelPageSupplier;
    private javax.swing.JLabel jLabelPhonenumberSupplier1;
    private javax.swing.JLabel jLabelPhonenumberSupplier2;
    private javax.swing.JLabel jLabelPhonenumberSupplier3;
    private javax.swing.JLabel jLabelPhonenumberSupplier4;
    private javax.swing.JLabel jLabelPhonenumberSupplier5;
    private javax.swing.JLabel jLabelPhonenumberSupplier6;
    private javax.swing.JLabel jLabelPhonenumberSupplier7;
    private javax.swing.JLabel jLabelPhonenumberSupplier8;
    private javax.swing.JLabel jLabelPreviousMonth;
    private javax.swing.JLabel jLabelPreviousYear;
    private javax.swing.JLabel jLabelPrice;
    private javax.swing.JLabel jLabelPrice1;
    private javax.swing.JLabel jLabelPrice2;
    private javax.swing.JLabel jLabelPrice3;
    private javax.swing.JLabel jLabelPrice4;
    private javax.swing.JLabel jLabelPrice5;
    private javax.swing.JLabel jLabelPrice6;
    private javax.swing.JLabel jLabelPrice7;
    private javax.swing.JLabel jLabelPrice8;
    private javax.swing.JLabel jLabelPriceBill;
    private javax.swing.JLabel jLabelPriceBill1;
    private javax.swing.JLabel jLabelPriceBill2;
    private javax.swing.JLabel jLabelPriceBill3;
    private javax.swing.JLabel jLabelPriceBill4;
    private javax.swing.JLabel jLabelPriceBill5;
    private javax.swing.JLabel jLabelPriceImport;
    private javax.swing.JLabel jLabelPriceImport1;
    private javax.swing.JLabel jLabelProductBill;
    private javax.swing.JLabel jLabelProductBill1;
    private javax.swing.JLabel jLabelProductBill2;
    private javax.swing.JLabel jLabelProductBill3;
    private javax.swing.JLabel jLabelProductBill4;
    private javax.swing.JLabel jLabelProductBill5;
    private javax.swing.JLabel jLabelQLDH;
    private javax.swing.JLabel jLabelQLNCC;
    private javax.swing.JLabel jLabelQLNV;
    private javax.swing.JLabel jLabelRight;
    private javax.swing.JLabel jLabelRight2;
    private javax.swing.JLabel jLabelRightPageBill;
    private javax.swing.JLabel jLabelRightSupplier;
    private javax.swing.JLabel jLabelSearchBill;
    private javax.swing.JLabel jLabelSearchProduct;
    private javax.swing.JLabel jLabelSearchStaff;
    private javax.swing.JLabel jLabelSetting1;
    private javax.swing.JLabel jLabelSetting2;
    private javax.swing.JLabel jLabelSetting3;
    private javax.swing.JLabel jLabelSetting4;
    private javax.swing.JLabel jLabelSetting5;
    private javax.swing.JLabel jLabelSetting6;
    private javax.swing.JLabel jLabelSetting7;
    private javax.swing.JLabel jLabelSettingBill;
    private javax.swing.JLabel jLabelSettingBill1;
    private javax.swing.JLabel jLabelSettingBill2;
    private javax.swing.JLabel jLabelSettingBill3;
    private javax.swing.JLabel jLabelSettingBill4;
    private javax.swing.JLabel jLabelSettingBill5;
    private javax.swing.JLabel jLabelSettingSupplier1;
    private javax.swing.JLabel jLabelSettingSupplier2;
    private javax.swing.JLabel jLabelSettingSupplier3;
    private javax.swing.JLabel jLabelSettingSupplier4;
    private javax.swing.JLabel jLabelSettingSupplier5;
    private javax.swing.JLabel jLabelSettingSupplier6;
    private javax.swing.JLabel jLabelSettingSupplier7;
    private javax.swing.JLabel jLabelSettingSupplier8;
    private javax.swing.JLabel jLabelSettings;
    private javax.swing.JLabel jLabelSettings1;
    private javax.swing.JLabel jLabelSkipToEnd;
    private javax.swing.JLabel jLabelSkipToEnd2;
    private javax.swing.JLabel jLabelSkipToEndPageBill;
    private javax.swing.JLabel jLabelSkipToEndSupplier;
    private javax.swing.JLabel jLabelSkipToStart;
    private javax.swing.JLabel jLabelSkipToStart2;
    private javax.swing.JLabel jLabelSkipToStartPageBill;
    private javax.swing.JLabel jLabelSkipToStartSupplier;
    private javax.swing.JLabel jLabelStaffBill;
    private javax.swing.JLabel jLabelStatusStaff1;
    private javax.swing.JLabel jLabelStatusStaff2;
    private javax.swing.JLabel jLabelStatusStaff3;
    private javax.swing.JLabel jLabelStatusStaff4;
    private javax.swing.JLabel jLabelStatusStaff5;
    private javax.swing.JLabel jLabelStatusStaff6;
    private javax.swing.JLabel jLabelTK;
    private javax.swing.JLabel jLabelTT;
    private javax.swing.JLabel jLabelTTBill;
    private javax.swing.JLabel jLabelTTKH;
    private javax.swing.JLabel jLabelTitleQLNV;
    private javax.swing.JLabel jLabelTitleStatistical;
    private javax.swing.JLabel jLabelTotalBill;
    private javax.swing.JLabel jLabelTotalPriceBill1;
    private javax.swing.JLabel jLabelTotalPriceBill2;
    private javax.swing.JLabel jLabelTotalPriceBill3;
    private javax.swing.JLabel jLabelTotalPriceBill4;
    private javax.swing.JLabel jLabelTotalPriceBill5;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JLabel jLabelType1;
    private javax.swing.JLabel jLabelType2;
    private javax.swing.JLabel jLabelType3;
    private javax.swing.JLabel jLabelType4;
    private javax.swing.JLabel jLabelType5;
    private javax.swing.JLabel jLabelType6;
    private javax.swing.JLabel jLabelType7;
    private javax.swing.JLabel jLabelType8;
    private javax.swing.JLabel jLabelUnit;
    private javax.swing.JLabel jLabelUnit1;
    private javax.swing.JLabel jLabelUnit2;
    private javax.swing.JLabel jLabelUnit3;
    private javax.swing.JLabel jLabelUnit4;
    private javax.swing.JLabel jLabelUnit5;
    private javax.swing.JLabel jLabelUnit6;
    private javax.swing.JLabel jLabelUnit7;
    private javax.swing.JPanel jPanelBill1;
    private javax.swing.JPanel jPanelBill2;
    private javax.swing.JPanel jPanelBill3;
    private javax.swing.JPanel jPanelBill4;
    private javax.swing.JPanel jPanelBill5;
    private javax.swing.JPanel jPanelBody;
    private javax.swing.JPanel jPanelCalendar;
    private javax.swing.JPanel jPanelControlPageBill;
    private javax.swing.JPanel jPanelControlPageProduct;
    private javax.swing.JPanel jPanelControlPageProduct1;
    private javax.swing.JPanel jPanelControlPageStaff;
    private javax.swing.JPanel jPanelControlQLK;
    private javax.swing.JPanel jPanelCustomerBill1;
    private javax.swing.JPanel jPanelCustomerBill2;
    private javax.swing.JPanel jPanelCustomerBill3;
    private javax.swing.JPanel jPanelCustomerBill4;
    private javax.swing.JPanel jPanelCustomerBill5;
    private javax.swing.JPanel jPanelGood1;
    private javax.swing.JPanel jPanelGood2;
    private javax.swing.JPanel jPanelGood3;
    private javax.swing.JPanel jPanelGood4;
    private javax.swing.JPanel jPanelGood5;
    private javax.swing.JPanel jPanelGood6;
    private javax.swing.JPanel jPanelGood7;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelHeaderBill;
    private javax.swing.JPanel jPanelHeaderSupplier;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelProductBill1;
    private javax.swing.JPanel jPanelProductBill2;
    private javax.swing.JPanel jPanelProductBill3;
    private javax.swing.JPanel jPanelProductBill4;
    private javax.swing.JPanel jPanelProductBill5;
    private javax.swing.JPanel jPanelQLDH;
    private javax.swing.JPanel jPanelQLK;
    private javax.swing.JPanel jPanelQLNCC;
    private javax.swing.JPanel jPanelQLNV;
    private javax.swing.JPanel jPanelSelectPage;
    private javax.swing.JPanel jPanelStaff1;
    private javax.swing.JPanel jPanelStaff2;
    private javax.swing.JPanel jPanelStaff3;
    private javax.swing.JPanel jPanelStaff4;
    private javax.swing.JPanel jPanelStaff5;
    private javax.swing.JPanel jPanelStaff6;
    private javax.swing.JPanel jPanelSupplier1;
    private javax.swing.JPanel jPanelSupplier2;
    private javax.swing.JPanel jPanelSupplier3;
    private javax.swing.JPanel jPanelSupplier4;
    private javax.swing.JPanel jPanelSupplier5;
    private javax.swing.JPanel jPanelSupplier6;
    private javax.swing.JPanel jPanelSupplier7;
    private javax.swing.JPanel jPanelSupplier8;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextFieldPageBill;
    private javax.swing.JTextField jTextFieldPageProduct;
    private javax.swing.JTextField jTextFieldPageStaff;
    private javax.swing.JTextField jTextFieldPageSupplier;
    private javax.swing.JTextField jTextFieldSearchBill;
    private javax.swing.JTextField jTextFieldSearchProduct;
    private javax.swing.JTextField jTextFieldSearchStaff;
    // End of variables declaration//GEN-END:variables
}
