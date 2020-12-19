/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.views.staff;

import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import qlbhgg.dao.WorkDayDao;
import qlbhgg.models.Users;
import qlbhgg.models.WorkDay;
import qlbhgg.views.common.DisplayImage;
import qlbhgg.views.admin.staff.EditStaff;

/**
 *
 * @author acer
 */
public class PanelProfileStaff extends javax.swing.JPanel {

    /**
     * Creates new form PanelProfileStaff
     */
    private Users userLogin;
    private ArrayList<WorkDay> ListWorkday = new ArrayList<>();
    private ArrayList<JLabel> ListLabelDaysCalendar = new ArrayList<JLabel>();
    
    Calendar cal = new GregorianCalendar();
    private int selectedMonth = cal.get(Calendar.MONTH);
    private int selectedYear = cal.get(Calendar.YEAR);
    private int dayEarlier = 0;
    private int numberOfWorking;
    
    public PanelProfileStaff(Users u) throws SQLException{
        userLogin = u;
        initComponents();
        addLabelDays();
        renderJDashboardProfile();
        showCalendar();
    }
    
    public void showCalendar() throws SQLException {
        numberOfWorking = WorkDayDao.countWorkDay(userLogin.getId(), selectedMonth + 1, selectedYear);
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
    
    private void renderJDashboardProfile() throws SQLException {

        ListWorkday = WorkDayDao.findByUsername(userLogin);
        selectedMonth = cal.get(Calendar.MONTH);
        selectedYear = cal.get(Calendar.YEAR);
        showCalendar();
        jLabelInformationNameStaff.setText(userLogin.getFullname());
        jLabelAvatarStaff.setIcon(scaleImformationAvatar(userLogin.getImage_user()));
        jLabelInformationId.setText(userLogin.getId());
        jLabelInformationUsername.setText(userLogin.getUsername());
        jLabelInformationGender.setText(userLogin.getGender());
        if (userLogin.getGender().equals("Nam")) {
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDashboardProfile = new javax.swing.JPanel();
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

        jDashboardProfile.setBackground(new java.awt.Color(255, 255, 255));
        jDashboardProfile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelButtonEditStaff.setBackground(new java.awt.Color(255, 255, 255));
        jLabelButtonEditStaff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelButtonEditStaff.setForeground(new java.awt.Color(0, 0, 0));
        jLabelButtonEditStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelButtonEditStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png"))); // NOI18N
        jLabelButtonEditStaff.setText("Sửa thông tin cá nhân");
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
        jDashboardProfile.add(jLabelButtonEditStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 270, 40));

        jLabelBBButtonEditStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBBButtonEditStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jDashboardProfile.add(jLabelBBButtonEditStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 270, 40));
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
        jLabelInformationNameStaff.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabelInformationNameStaff.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationNameStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInformationNameStaff.setText("Phạm Duy Tài");
        jDashboardProfile.add(jLabelInformationNameStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 410, -1));

        jLabelTT.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTT.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabelTT.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTT.setText("Thông tin cá nhân:");
        jLabelTT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jDashboardProfile.add(jLabelTT, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 220, 40));

        jLabelInformationUsername.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationUsername.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationUsername.setText("Tên đăng nhập:");
        jDashboardProfile.add(jLabelInformationUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 440, 30));

        jLabelInformationId.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationId.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationId.setText("Mã nhân viên:");
        jDashboardProfile.add(jLabelInformationId, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 440, 30));

        jLabelInformationGender.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationGender.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationGender.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationGender.setText("Giới tính:");
        jDashboardProfile.add(jLabelInformationGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 440, 30));

        jLabelInformationBirthday.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationBirthday.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationBirthday.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationBirthday.setText("Ngày sinh:");
        jDashboardProfile.add(jLabelInformationBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 470, 440, 30));

        jLabelInformationStartdate.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationStartdate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationStartdate.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationStartdate.setText("Ngày bắt đầu:");
        jDashboardProfile.add(jLabelInformationStartdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 510, 440, 30));

        jLabelInformationAddress.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationAddress.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationAddress.setText("Địa chỉ:");
        jDashboardProfile.add(jLabelInformationAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 550, 440, 30));

        jLabelInformationPhonenumber.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationPhonenumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationPhonenumber.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationPhonenumber.setText("Số điện thoại:");
        jDashboardProfile.add(jLabelInformationPhonenumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 630, 440, 30));

        jLabelInformationEmail.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationEmail.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationEmail.setText("Email:");
        jDashboardProfile.add(jLabelInformationEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 590, 440, 30));

        jLabelInformationBasicsalary.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationBasicsalary.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationBasicsalary.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationBasicsalary.setText("Lương cơ bản:");
        jDashboardProfile.add(jLabelInformationBasicsalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 670, 440, 30));

        jLabelInformationAllowance.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationAllowance.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationAllowance.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationAllowance.setText("Trợ cấp:");
        jDashboardProfile.add(jLabelInformationAllowance, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 710, 440, 30));

        jLabelInformationId1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationId1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationId1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationId1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_identification_documents_25px.png"))); // NOI18N
        jLabelInformationId1.setText("Mã nhân viên:");
        jDashboardProfile.add(jLabelInformationId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 160, 30));

        jLabelInformationUsername1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationUsername1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationUsername1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationUsername1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_name_25px.png"))); // NOI18N
        jLabelInformationUsername1.setText("Tên đăng nhập:");
        jDashboardProfile.add(jLabelInformationUsername1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 160, 30));

        jLabelInformationGender1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationGender1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationGender1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationGender1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_25px.png"))); // NOI18N
        jLabelInformationGender1.setText("Giới tính:");
        jDashboardProfile.add(jLabelInformationGender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 120, 30));

        jLabelInformationBirthday1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationBirthday1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationBirthday1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationBirthday1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_birthday_25px.png"))); // NOI18N
        jLabelInformationBirthday1.setText("Ngày sinh:");
        jDashboardProfile.add(jLabelInformationBirthday1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 130, 30));

        jLabelInformationStartdate1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationStartdate1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationStartdate1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationStartdate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_maintenance_date_25px.png"))); // NOI18N
        jLabelInformationStartdate1.setText("Ngày bắt đầu:");
        jDashboardProfile.add(jLabelInformationStartdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 150, 30));

        jLabelInformationAddress1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationAddress1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationAddress1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationAddress1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_home_address_25px.png"))); // NOI18N
        jLabelInformationAddress1.setText("Địa chỉ:");
        jDashboardProfile.add(jLabelInformationAddress1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 550, 100, 30));

        jLabelInformationEmail1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationEmail1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationEmail1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationEmail1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gmail_25px_1.png"))); // NOI18N
        jLabelInformationEmail1.setText("Email:");
        jDashboardProfile.add(jLabelInformationEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 90, 30));

        jLabelInformationPhonenumber1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationPhonenumber1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationPhonenumber1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationPhonenumber1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_phone_25px.png"))); // NOI18N
        jLabelInformationPhonenumber1.setText("Số điện thoại:");
        jDashboardProfile.add(jLabelInformationPhonenumber1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 630, 150, 30));

        jLabelInformationBasicsalary1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationBasicsalary1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationBasicsalary1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationBasicsalary1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_paycheque_25px.png"))); // NOI18N
        jLabelInformationBasicsalary1.setText("Lương cơ bản:");
        jDashboardProfile.add(jLabelInformationBasicsalary1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 670, 150, 30));

        jLabelInformationAllowance1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationAllowance1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationAllowance1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationAllowance1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_loyalty_card_25px.png"))); // NOI18N
        jLabelInformationAllowance1.setText("Trợ cấp:");
        jDashboardProfile.add(jLabelInformationAllowance1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 710, 100, 30));
        jDashboardProfile.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 415, 440, 10));
        jDashboardProfile.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 455, 440, 10));
        jDashboardProfile.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 375, 440, 10));
        jDashboardProfile.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 495, 440, 10));
        jDashboardProfile.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 535, 440, 10));
        jDashboardProfile.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 575, 440, 10));
        jDashboardProfile.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 735, 440, 10));
        jDashboardProfile.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 615, 440, 10));
        jDashboardProfile.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 655, 440, 10));
        jDashboardProfile.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 695, 440, 10));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1342, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jDashboardProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 1330, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jDashboardProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelButtonEditStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonEditStaffMouseClicked
        EditStaff es = new EditStaff(userLogin, "Sửa thông tin cá nhân");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelButtonEditStaffMouseClicked

    private void jLabelButtonEditStaffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonEditStaffMouseEntered
        // TODO add your handling code here:
        jLabelBBButtonEditStaff.setIcon(scaleButtonEdit("/Image/ButtonEditDark.png"));
    }//GEN-LAST:event_jLabelButtonEditStaffMouseEntered

    private void jLabelButtonEditStaffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonEditStaffMouseExited
        // TODO add your handling code here:
        jLabelBBButtonEditStaff.setIcon(scaleButtonEdit("/Image/ButtonEditLight.png"));
    }//GEN-LAST:event_jLabelButtonEditStaffMouseExited

    private void jLabelFrameAvatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelFrameAvatarMouseClicked
        // TODO add your handling code here:
        popUpImageStaff(userLogin);
    }//GEN-LAST:event_jLabelFrameAvatarMouseClicked

    private void jLabelPreviousYearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPreviousYearMouseClicked
        // TODO add your handling code here:
        selectedYear--;
        try {
            showCalendar();
        } catch (SQLException ex) {
            Logger.getLogger(PanelProfileStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jLabelPreviousYearMouseClicked

    private void jLabelPreviousYearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPreviousYearMouseEntered
        // TODO add your handling code here:
        jLabelPreviousYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_down_40px_1.png")));
    }//GEN-LAST:event_jLabelPreviousYearMouseEntered

    private void jLabelPreviousYearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPreviousYearMouseExited
        // TODO add your handling code here:
        jLabelPreviousYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_down_40px.png")));
    }//GEN-LAST:event_jLabelPreviousYearMouseExited

    private void jLabelNextYearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNextYearMouseClicked
        // TODO add your handling code here:
        selectedYear++;
        
        try {
            showCalendar();
        } catch (SQLException ex) {
            Logger.getLogger(PanelProfileStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jLabelNextYearMouseClicked

    private void jLabelNextYearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNextYearMouseEntered
        // TODO add your handling code here:
        jLabelNextYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_up_40px_1.png")));
    }//GEN-LAST:event_jLabelNextYearMouseEntered

    private void jLabelNextYearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNextYearMouseExited
        // TODO add your handling code here:
        jLabelNextYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_up_40px.png")));
    }//GEN-LAST:event_jLabelNextYearMouseExited

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
            Logger.getLogger(PanelProfileStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jLabelPreviousMonthMouseClicked

    private void jLabelPreviousMonthMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPreviousMonthMouseEntered
        // TODO add your handling code here:
        jLabelPreviousMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_left_40px_1.png")));
    }//GEN-LAST:event_jLabelPreviousMonthMouseEntered

    private void jLabelPreviousMonthMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPreviousMonthMouseExited
        // TODO add your handling code here:
        jLabelPreviousMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_left_40px.png")));
    }//GEN-LAST:event_jLabelPreviousMonthMouseExited

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
            Logger.getLogger(PanelProfileStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jLabelNextMonthMouseClicked

    private void jLabelNextMonthMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNextMonthMouseEntered
        // TODO add your handling code here:
        jLabelNextMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_right_40px_1.png")));
    }//GEN-LAST:event_jLabelNextMonthMouseEntered

    private void jLabelNextMonthMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNextMonthMouseExited
        // TODO add your handling code here:
        jLabelNextMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_right_40px.png")));
    }//GEN-LAST:event_jLabelNextMonthMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jDashboardProfile;
    private javax.swing.JLabel jLabelAvatarStaff;
    private javax.swing.JLabel jLabelBBButtonEditStaff;
    private javax.swing.JLabel jLabelButtonEditStaff;
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
    private javax.swing.JLabel jLabelFrameAvatar;
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
    private javax.swing.JLabel jLabelNameCalendar;
    private javax.swing.JLabel jLabelNextMonth;
    private javax.swing.JLabel jLabelNextYear;
    private javax.swing.JLabel jLabelNumberOfSalary;
    private javax.swing.JLabel jLabelNumberOfStatistical;
    private javax.swing.JLabel jLabelNumberOfWorking;
    private javax.swing.JLabel jLabelPreviousMonth;
    private javax.swing.JLabel jLabelPreviousYear;
    private javax.swing.JLabel jLabelTT;
    private javax.swing.JLabel jLabelTitleStatistical;
    private javax.swing.JPanel jPanelCalendar;
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
    // End of variables declaration//GEN-END:variables
}
