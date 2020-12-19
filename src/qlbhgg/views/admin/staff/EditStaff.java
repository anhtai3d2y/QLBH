/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.views.admin.staff;

import qlbhgg.models.Users;
import java.awt.Image;
import java.io.File;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import qlbhgg.dao.UsersDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlbhgg.views.common.DisplayImage;

/**
 *
 * @author acer
 */
public class EditStaff extends javax.swing.JFrame {

    /**
     * Creates new form EditStaff
     */
    private String ImagePath;
    private String savePath = "";
    private String roleOfForm;
    private int pinCode = 0, XX, YY;
    Users user = null;
    ArrayList<Users> listCheck = new ArrayList<>();

    public EditStaff(Users u, String title) {
        initComponents();
        jLabelButtonClear.setIcon(scaleImage("/Image/SignButtonBlue.png"));
        jLabelButtonAdd.setIcon(scaleImage("/Image/SignButtonBlue.png"));

        jLabelErrorId.setVisible(false);
        jLabelErrorUsername.setVisible(false);
        jLabelErrorPassword.setVisible(false);
        jLabelErrorConfirmPassword.setVisible(false);
        jLabelErrorEmail.setVisible(false);
        jLabelErrorPincode.setVisible(false);
        jLabelErrorPhonenumber.setVisible(false);
        jLabelErrorAll.setVisible(false);

        jRadioButtonMale.setSelected(true);
        jLabelTitle.setText(title);
        user = u;
        roleOfForm = title;
        if (u != null && roleOfForm.equals("Sửa thông tin nhân viên")) {
            jLabelAvatarStaff.setIcon(scaleAvatarStaff(u.getImage_user()));
            jTextFieldNameStaff.setText(u.getFullname());
            jTextFieldIdStaff.setEditable(false);
            jTextFieldIdStaff.setText(u.getId());
            jTextFieldUsername.setText(u.getUsername());
            jPasswordFieldPassword.setText(u.getPassword());
            jPasswordFieldConfirmPassword.setText(u.getPassword());
            jPasswordFieldPassword.setEditable(false);
            jPasswordFieldConfirmPassword.setEditable(false);
            jTextFieldUsername.setEditable(false);
            jTextFieldEmailStaff.setEditable(false);
            jTextFieldPhonenumberStaff.setEditable(false);
            savePath = u.getImage_user();
            if (u.getGender().equals("Nam")) {
                jRadioButtonMale.setSelected(true);
            } else {
                jRadioButtonFemale.setSelected(true);
            }
            jDateChooserBirthday.setDate(u.getBirthday());
            jDateChooserStartdate.setDate(u.getStartdate());
            jTextFieldAddressStaff.setText(u.getAddress());
            jTextFieldEmailStaff.setText(u.getEmail());
            jTextFieldPhonenumberStaff.setText(u.getPhonenumber());
            jTextFieldBasicsalaryStaff.setText(String.format("%1$,.0f", u.getBasicsalary()));
            jTextFieldAllowanceStaff.setText(String.format("%1$,.0f", u.getAllowance()));
        } else if (u != null && roleOfForm.equals("Sửa thông tin cá nhân")) {
            jLabelAvatarStaff.setIcon(scaleAvatarStaff(u.getImage_user()));
            jTextFieldNameStaff.setText(u.getFullname());
            jTextFieldIdStaff.setEditable(false);
            jTextFieldIdStaff.setText(u.getId());
            jTextFieldUsername.setText(u.getUsername());
            jPasswordFieldPassword.setText(u.getPassword());
            jPasswordFieldConfirmPassword.setText(u.getPassword());
            jTextFieldUsername.setEditable(false);
            jTextFieldEmailStaff.setEditable(false);
            savePath = u.getImage_user();
            if (u.getGender().equals("Nam")) {
                jRadioButtonMale.setSelected(true);
            } else {
                jRadioButtonFemale.setSelected(true);
            }
            jDateChooserBirthday.setDate(u.getBirthday());
            jDateChooserStartdate.setDate(u.getStartdate());
            jTextFieldAddressStaff.setText(u.getAddress());
            jTextFieldEmailStaff.setText(u.getEmail());
            jTextFieldPhonenumberStaff.setText(u.getPhonenumber());
            jTextFieldBasicsalaryStaff.setText(String.format("%1$,.0f", u.getBasicsalary()));
            jTextFieldAllowanceStaff.setText(String.format("%1$,.0f", u.getAllowance()));
        } else {
            jLabelAvatarStaff.setIcon(null);
            jTextFieldNameStaff.setText("");
            jTextFieldIdStaff.setText("");
            jTextFieldUsername.setText("");
            jPasswordFieldPassword.setText("");
            jPasswordFieldConfirmPassword.setText("");
            jDateChooserBirthday.setCalendar(null);
            jDateChooserStartdate.setCalendar(null);
            jTextFieldAddressStaff.setText("");
            jTextFieldEmailStaff.setText("");
            jTextFieldPhonenumberStaff.setText("");
            jTextFieldBasicsalaryStaff.setText("");
            jTextFieldAllowanceStaff.setText("");
        }
    }

    private ImageIcon scaleImage(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(150, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }

    private ImageIcon scaleAvatarStaff(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }

    public static boolean checkNameStaff(String name) {
        return !name.equals("");
    }

    public static boolean checkIdStaff(String id) {
        return Pattern.matches("^[U]{1}+[S]{1}+[0-9]{8}+$", id) && !id.equals("");
    }

    public static boolean checkUsernameStaff(String username) {
        return !username.equals("");
    }

    public static boolean checkPasswordStaff(String password) {
        return !password.equals("") && Pattern.matches("^[a-zA-Z0-9]+$", password);
    }

    public static boolean checkConfirmPasswordStaff(String confirmpassword, String password) {
        return !confirmpassword.equals("") && confirmpassword.equals(password);
    }

    public static boolean checkBirthdayStaff(String birthday) {
        return !birthday.equals("");
    }

    public static boolean checkStartdateStaff(String startdate) {
        return !startdate.equals("");
    }

    public static boolean checkAddressStaff(String address) {
        return !address.equals("");
    }

    public static boolean checkEmail(String email) {
        return Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", email) && !email.equals("");
    }

    public static boolean checkPhonenumberStaff(String phonenumber) {
        return !phonenumber.equals("");
    }

    public static boolean checkBasicsalaryStaff(String basicsalary) {
        return !basicsalary.equals("");
    }

    public static boolean checkAllowanceStaff(String allowance) {
        return !allowance.equals("");
    }

    public static boolean checkImageStaff(String imagepath) {
        return !imagepath.equals("");
    }

    public static boolean checkPincode(String pincode) {
        return !pincode.equals("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupGender = new javax.swing.ButtonGroup();
        jPanelBackGround = new javax.swing.JPanel();
        jLabelInformationConfirmPassword = new javax.swing.JLabel();
        jPasswordFieldConfirmPassword = new javax.swing.JPasswordField();
        jSeparator16 = new javax.swing.JSeparator();
        jLabelChooseImage = new javax.swing.JLabel();
        jDateChooserStartdate = new com.toedter.calendar.JDateChooser();
        jDateChooserBirthday = new com.toedter.calendar.JDateChooser();
        jTextFieldAllowanceStaff = new javax.swing.JTextField();
        jTextFieldBasicsalaryStaff = new javax.swing.JTextField();
        jTextFieldPhonenumberStaff = new javax.swing.JTextField();
        jTextFieldEmailStaff = new javax.swing.JTextField();
        jTextFieldAddressStaff = new javax.swing.JTextField();
        jTextFieldUsername = new javax.swing.JTextField();
        jTextFieldIdStaff = new javax.swing.JTextField();
        jTextFieldNameStaff = new javax.swing.JTextField();
        jLabelInformationPassword = new javax.swing.JLabel();
        jLabelInformationNameStaff = new javax.swing.JLabel();
        jLabelInformationEmail1 = new javax.swing.JLabel();
        jLabelInformationUsername1 = new javax.swing.JLabel();
        jLabelInformationBasicsalary1 = new javax.swing.JLabel();
        jLabelInformationPhonenumber1 = new javax.swing.JLabel();
        jLabelInformationGender1 = new javax.swing.JLabel();
        jLabelInformationStartdate1 = new javax.swing.JLabel();
        jLabelInformationAddress1 = new javax.swing.JLabel();
        jLabelInformationId1 = new javax.swing.JLabel();
        jLabelInformationAllowance1 = new javax.swing.JLabel();
        jLabelFrameAvatar = new javax.swing.JLabel();
        jLabelAvatarStaff = new javax.swing.JLabel();
        jLabelInformationBirthday1 = new javax.swing.JLabel();
        jLabelInformationEmail2 = new javax.swing.JLabel();
        jTextFieldPincode = new javax.swing.JTextField();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelClear = new javax.swing.JLabel();
        jLabelButtonClear = new javax.swing.JLabel();
        jLabelAdd = new javax.swing.JLabel();
        jLabelButtonAdd = new javax.swing.JLabel();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButtonFemale = new javax.swing.JRadioButton();
        jRadioButtonMale = new javax.swing.JRadioButton();
        jLabelErrorAll = new javax.swing.JLabel();
        jLabelErrorPincode = new javax.swing.JLabel();
        jLabelErrorId = new javax.swing.JLabel();
        jLabelErrorEmail = new javax.swing.JLabel();
        jLabelErrorConfirmPassword = new javax.swing.JLabel();
        jLabelErrorPassword = new javax.swing.JLabel();
        jLabelErrorUsername = new javax.swing.JLabel();
        jButtonSendPincode = new javax.swing.JButton();
        jLabelErrorPhonenumber = new javax.swing.JLabel();
        jPanelTitle = new javax.swing.JPanel();
        jLabelExit = new javax.swing.JLabel();
        jLabelTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanelBackGround.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBackGround.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(125, 125, 125)));
        jPanelBackGround.setForeground(new java.awt.Color(255, 255, 255));
        jPanelBackGround.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelInformationConfirmPassword.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationConfirmPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationConfirmPassword.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationConfirmPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_password_reset_25px.png"))); // NOI18N
        jLabelInformationConfirmPassword.setText("Xác nhận:");
        jPanelBackGround.add(jLabelInformationConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 120, 30));

        jPasswordFieldConfirmPassword.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordFieldConfirmPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPasswordFieldConfirmPassword.setForeground(new java.awt.Color(0, 0, 0));
        jPasswordFieldConfirmPassword.setBorder(null);
        jPasswordFieldConfirmPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordFieldConfirmPasswordKeyReleased(evt);
            }
        });
        jPanelBackGround.add(jPasswordFieldConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 440, 30));
        jPanelBackGround.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, 440, 10));

        jLabelChooseImage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelChooseImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelChooseImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_camera_25px.png"))); // NOI18N
        jLabelChooseImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelChooseImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelChooseImageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelChooseImageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelChooseImageMouseExited(evt);
            }
        });
        jPanelBackGround.add(jLabelChooseImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 40, 40));

        jDateChooserStartdate.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserStartdate.setForeground(new java.awt.Color(0, 0, 0));
        jDateChooserStartdate.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanelBackGround.add(jDateChooserStartdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 580, 440, 30));

        jDateChooserBirthday.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserBirthday.setForeground(new java.awt.Color(0, 0, 0));
        jDateChooserBirthday.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanelBackGround.add(jDateChooserBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, 440, 30));

        jTextFieldAllowanceStaff.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldAllowanceStaff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldAllowanceStaff.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldAllowanceStaff.setBorder(null);
        jTextFieldAllowanceStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldAllowanceStaff.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldAllowanceStaffKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldAllowanceStaffKeyTyped(evt);
            }
        });
        jPanelBackGround.add(jTextFieldAllowanceStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 850, 390, 30));

        jTextFieldBasicsalaryStaff.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldBasicsalaryStaff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldBasicsalaryStaff.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldBasicsalaryStaff.setBorder(null);
        jTextFieldBasicsalaryStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldBasicsalaryStaff.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBasicsalaryStaffKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBasicsalaryStaffKeyTyped(evt);
            }
        });
        jPanelBackGround.add(jTextFieldBasicsalaryStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 810, 390, 30));

        jTextFieldPhonenumberStaff.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPhonenumberStaff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldPhonenumberStaff.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldPhonenumberStaff.setBorder(null);
        jTextFieldPhonenumberStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldPhonenumberStaff.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPhonenumberStaffKeyTyped(evt);
            }
        });
        jPanelBackGround.add(jTextFieldPhonenumberStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 760, 440, 30));

        jTextFieldEmailStaff.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldEmailStaff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldEmailStaff.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldEmailStaff.setBorder(null);
        jTextFieldEmailStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldEmailStaff.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldEmailStaffKeyReleased(evt);
            }
        });
        jPanelBackGround.add(jTextFieldEmailStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 660, 440, 30));

        jTextFieldAddressStaff.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldAddressStaff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldAddressStaff.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldAddressStaff.setBorder(null);
        jTextFieldAddressStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanelBackGround.add(jTextFieldAddressStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 620, 440, 30));

        jTextFieldUsername.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldUsername.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldUsername.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldUsername.setBorder(null);
        jTextFieldUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanelBackGround.add(jTextFieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 440, 30));

        jTextFieldIdStaff.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldIdStaff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldIdStaff.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldIdStaff.setBorder(null);
        jTextFieldIdStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldIdStaff.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldIdStaffKeyReleased(evt);
            }
        });
        jPanelBackGround.add(jTextFieldIdStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 440, 30));

        jTextFieldNameStaff.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldNameStaff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldNameStaff.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldNameStaff.setBorder(null);
        jTextFieldNameStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanelBackGround.add(jTextFieldNameStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 440, 30));

        jLabelInformationPassword.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationPassword.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_password_window_25px.png"))); // NOI18N
        jLabelInformationPassword.setText("Mật khẩu:");
        jPanelBackGround.add(jLabelInformationPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 120, 30));

        jLabelInformationNameStaff.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationNameStaff.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationNameStaff.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationNameStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_name_25px_1.png"))); // NOI18N
        jLabelInformationNameStaff.setText("Tên nhân viên:");
        jLabelInformationNameStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanelBackGround.add(jLabelInformationNameStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 150, 30));

        jLabelInformationEmail1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationEmail1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationEmail1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationEmail1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gmail_25px_1.png"))); // NOI18N
        jLabelInformationEmail1.setText("Email:");
        jPanelBackGround.add(jLabelInformationEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 660, 90, 30));

        jLabelInformationUsername1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationUsername1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationUsername1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationUsername1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_name_25px.png"))); // NOI18N
        jLabelInformationUsername1.setText("Tên đăng nhập:");
        jPanelBackGround.add(jLabelInformationUsername1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 160, 30));

        jLabelInformationBasicsalary1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationBasicsalary1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationBasicsalary1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationBasicsalary1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_paycheque_25px.png"))); // NOI18N
        jLabelInformationBasicsalary1.setText("Lương cơ bản:");
        jPanelBackGround.add(jLabelInformationBasicsalary1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 810, 150, 30));

        jLabelInformationPhonenumber1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationPhonenumber1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationPhonenumber1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationPhonenumber1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_phone_25px.png"))); // NOI18N
        jLabelInformationPhonenumber1.setText("Số điện thoại:");
        jPanelBackGround.add(jLabelInformationPhonenumber1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 760, 150, 30));

        jLabelInformationGender1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationGender1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationGender1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationGender1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_25px.png"))); // NOI18N
        jLabelInformationGender1.setText("Giới tính:");
        jPanelBackGround.add(jLabelInformationGender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 120, 30));

        jLabelInformationStartdate1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationStartdate1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationStartdate1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationStartdate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_maintenance_date_25px.png"))); // NOI18N
        jLabelInformationStartdate1.setText("Ngày bắt đầu:");
        jPanelBackGround.add(jLabelInformationStartdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 580, 150, 30));

        jLabelInformationAddress1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationAddress1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationAddress1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationAddress1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_home_address_25px.png"))); // NOI18N
        jLabelInformationAddress1.setText("Địa chỉ:");
        jPanelBackGround.add(jLabelInformationAddress1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 620, 100, 30));

        jLabelInformationId1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationId1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationId1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationId1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_identification_documents_25px.png"))); // NOI18N
        jLabelInformationId1.setText("Mã nhân viên:");
        jPanelBackGround.add(jLabelInformationId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 160, 30));

        jLabelInformationAllowance1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationAllowance1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationAllowance1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationAllowance1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_loyalty_card_25px.png"))); // NOI18N
        jLabelInformationAllowance1.setText("Trợ cấp:");
        jPanelBackGround.add(jLabelInformationAllowance1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 850, 100, 30));

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
        jPanelBackGround.add(jLabelFrameAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 200, 200));

        jLabelAvatarStaff.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatarStaff.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatarStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanelBackGround.add(jLabelAvatarStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 200, 200));

        jLabelInformationBirthday1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationBirthday1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationBirthday1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationBirthday1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_birthday_25px.png"))); // NOI18N
        jLabelInformationBirthday1.setText("Ngày sinh:");
        jPanelBackGround.add(jLabelInformationBirthday1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 130, 30));

        jLabelInformationEmail2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationEmail2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationEmail2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationEmail2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_pin_code_25px.png"))); // NOI18N
        jLabelInformationEmail2.setText("Mã xác nhận:");
        jPanelBackGround.add(jLabelInformationEmail2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 710, 150, 30));

        jTextFieldPincode.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPincode.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldPincode.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldPincode.setBorder(null);
        jTextFieldPincode.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldPincode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPincodeKeyReleased(evt);
            }
        });
        jPanelBackGround.add(jTextFieldPincode, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 710, 140, 30));
        jPanelBackGround.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 740, 140, 10));
        jPanelBackGround.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 440, 10));
        jPanelBackGround.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 880, 440, 10));
        jPanelBackGround.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 690, 440, 10));
        jPanelBackGround.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 840, 440, 10));
        jPanelBackGround.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 570, 440, 10));
        jPanelBackGround.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 790, 440, 10));
        jPanelBackGround.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 610, 440, 10));
        jPanelBackGround.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 440, 10));
        jPanelBackGround.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 440, 10));
        jPanelBackGround.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 650, 440, 10));
        jPanelBackGround.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 440, 10));

        jLabelClear.setBackground(new java.awt.Color(255, 255, 255));
        jLabelClear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelClear.setForeground(new java.awt.Color(0, 0, 0));
        jLabelClear.setText("Clear");
        jLabelClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelBackGround.add(jLabelClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 925, -1, -1));

        jLabelButtonClear.setBackground(new java.awt.Color(255, 255, 255));
        jLabelButtonClear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelButtonClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelButtonClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelButtonClearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelButtonClearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelButtonClearMouseExited(evt);
            }
        });
        jPanelBackGround.add(jLabelButtonClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 910, 150, 50));

        jLabelAdd.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAdd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelAdd.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAdd.setText("Xác nhận");
        jLabelAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelBackGround.add(jLabelAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 925, -1, -1));

        jLabelButtonAdd.setBackground(new java.awt.Color(255, 255, 255));
        jLabelButtonAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelButtonAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelButtonAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelButtonAddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelButtonAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelButtonAddMouseExited(evt);
            }
        });
        jPanelBackGround.add(jLabelButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 910, 150, 50));

        jPasswordFieldPassword.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordFieldPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPasswordFieldPassword.setForeground(new java.awt.Color(0, 0, 0));
        jPasswordFieldPassword.setBorder(null);
        jPasswordFieldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordFieldPasswordKeyReleased(evt);
            }
        });
        jPanelBackGround.add(jPasswordFieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 440, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("VNĐ");
        jPanelBackGround.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 850, 50, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("VNĐ");
        jPanelBackGround.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 810, 50, 30));

        jRadioButtonFemale.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupGender.add(jRadioButtonFemale);
        jRadioButtonFemale.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButtonFemale.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButtonFemale.setText("Nữ");
        jRadioButtonFemale.setFocusable(false);
        jPanelBackGround.add(jRadioButtonFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 500, -1, -1));

        jRadioButtonMale.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupGender.add(jRadioButtonMale);
        jRadioButtonMale.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButtonMale.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButtonMale.setText("Nam");
        jRadioButtonMale.setFocusable(false);
        jPanelBackGround.add(jRadioButtonMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, -1, -1));

        jLabelErrorAll.setBackground(new java.awt.Color(255, 255, 255));
        jLabelErrorAll.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelErrorAll.setForeground(new java.awt.Color(255, 51, 51));
        jLabelErrorAll.setText("Bạn chưa nhập đủ thông tin");
        jPanelBackGround.add(jLabelErrorAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 880, 440, 20));

        jLabelErrorPincode.setBackground(new java.awt.Color(255, 255, 255));
        jLabelErrorPincode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelErrorPincode.setForeground(new java.awt.Color(255, 51, 51));
        jLabelErrorPincode.setText("Mã xác nhận không đúng");
        jPanelBackGround.add(jLabelErrorPincode, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 740, 440, 20));

        jLabelErrorId.setBackground(new java.awt.Color(255, 255, 255));
        jLabelErrorId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelErrorId.setForeground(new java.awt.Color(255, 51, 51));
        jLabelErrorId.setText("Mã nhân viên phải bắt đầu bằng US và 8 kí tự số");
        jPanelBackGround.add(jLabelErrorId, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 440, -1));

        jLabelErrorEmail.setBackground(new java.awt.Color(255, 255, 255));
        jLabelErrorEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelErrorEmail.setForeground(new java.awt.Color(255, 51, 51));
        jLabelErrorEmail.setText("Định dạng email không đúng");
        jPanelBackGround.add(jLabelErrorEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 690, 440, 20));

        jLabelErrorConfirmPassword.setBackground(new java.awt.Color(255, 255, 255));
        jLabelErrorConfirmPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelErrorConfirmPassword.setForeground(new java.awt.Color(255, 51, 51));
        jLabelErrorConfirmPassword.setText("Mật khẩu xác nhận không trùng khớp");
        jPanelBackGround.add(jLabelErrorConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, 440, 20));

        jLabelErrorPassword.setBackground(new java.awt.Color(255, 255, 255));
        jLabelErrorPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelErrorPassword.setForeground(new java.awt.Color(255, 51, 51));
        jLabelErrorPassword.setText("Mật khẩu chỉ được bao gồm kí tự chữ hoặc số");
        jPanelBackGround.add(jLabelErrorPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 440, 20));

        jLabelErrorUsername.setBackground(new java.awt.Color(255, 255, 255));
        jLabelErrorUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelErrorUsername.setForeground(new java.awt.Color(255, 51, 51));
        jLabelErrorUsername.setText("Tên đăng nhập đã tồn tại");
        jPanelBackGround.add(jLabelErrorUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 440, 20));

        jButtonSendPincode.setBackground(new java.awt.Color(89, 194, 89));
        jButtonSendPincode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonSendPincode.setForeground(new java.awt.Color(0, 0, 0));
        jButtonSendPincode.setText("Gửi mã");
        jButtonSendPincode.setBorder(null);
        jButtonSendPincode.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSendPincode.setFocusable(false);
        jButtonSendPincode.setOpaque(true);
        jButtonSendPincode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonSendPincodeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonSendPincodeMouseExited(evt);
            }
        });
        jButtonSendPincode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendPincodeActionPerformed(evt);
            }
        });
        jPanelBackGround.add(jButtonSendPincode, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 710, 120, 30));

        jLabelErrorPhonenumber.setBackground(new java.awt.Color(255, 255, 255));
        jLabelErrorPhonenumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelErrorPhonenumber.setForeground(new java.awt.Color(255, 51, 51));
        jLabelErrorPhonenumber.setText("Số điện thoại đã tồn tại");
        jPanelBackGround.add(jLabelErrorPhonenumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 790, 440, 20));

        jPanelTitle.setBackground(new java.awt.Color(0, 0, 0));
        jPanelTitle.setForeground(new java.awt.Color(0, 0, 0));

        jLabelExit.setBackground(new java.awt.Color(0, 0, 0));
        jLabelExit.setForeground(new java.awt.Color(0, 0, 0));
        jLabelExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_close_window_25px_4.png"))); // NOI18N
        jLabelExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelExitMouseExited(evt);
            }
        });

        jLabelTitle.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gear_25px.png"))); // NOI18N
        jLabelTitle.setText("Sửa thông tin nhân viên");
        jLabelTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jLabelTitle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabelTitleMouseDragged(evt);
            }
        });
        jLabelTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelTitleMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTitleLayout = new javax.swing.GroupLayout(jPanelTitle);
        jPanelTitle.setLayout(jPanelTitleLayout);
        jPanelTitleLayout.setHorizontalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTitleLayout.createSequentialGroup()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelExit))
        );
        jPanelTitleLayout.setVerticalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addGroup(jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelExit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelBackGround.add(jPanelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelBackGround, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBackGround, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelFrameAvatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelFrameAvatarMouseClicked
        DisplayImage di = new DisplayImage(user.getFullname(), user.getImage_user());
        di.setVisible(true);
        di.pack();
    }//GEN-LAST:event_jLabelFrameAvatarMouseClicked

    private void jLabelButtonAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonAddMouseClicked

        if (checkNameStaff(jTextFieldNameStaff.getText()) && checkIdStaff(jTextFieldIdStaff.getText()) && checkUsernameStaff(jTextFieldUsername.getText())
                && checkPasswordStaff(String.valueOf(jPasswordFieldPassword.getPassword())) && checkConfirmPasswordStaff(String.valueOf(jPasswordFieldConfirmPassword.getPassword()), String.valueOf(jPasswordFieldPassword.getPassword()))
                && checkBirthdayStaff(String.valueOf(jDateChooserBirthday)) && checkStartdateStaff(String.valueOf(jDateChooserStartdate))
                && checkAddressStaff(jTextFieldAddressStaff.getText()) && checkEmail(jTextFieldEmailStaff.getText()) && checkPhonenumberStaff(jTextFieldPhonenumberStaff.getText())
                && checkBasicsalaryStaff(jTextFieldBasicsalaryStaff.getText()) && checkAllowanceStaff(jTextFieldAllowanceStaff.getText()) && checkImageStaff(savePath) && checkPincode(jTextFieldPincode.getText())) {
            try {
                listCheck = UsersDao.findStaffBy(jTextFieldIdStaff.getText(), jTextFieldUsername.getText(), jTextFieldPhonenumberStaff.getText(), jTextFieldEmailStaff.getText());
            } catch (SQLException ex) {
                Logger.getLogger(EditStaff.class.getName()).log(Level.SEVERE, null, ex);
            }
            boolean checkusername = true, checkid = true, checkemail = true, checkphonenumber = true;
            boolean checkrole = (roleOfForm.equals("Thêm nhân viên") ? true : false);
            for (Users u : listCheck) {
                if (jTextFieldIdStaff.getText().equals(u.getId()) && checkrole) {
                    jLabelErrorId.setText("Mã nhân viên đã tồn tại");
                    jLabelErrorId.setVisible(true);
                    checkid = false;
                }
                if (jTextFieldUsername.getText().equals(u.getUsername()) && checkrole) {
                    jLabelErrorUsername.setText("Tên đăng nhập đã tồn tại");
                    jLabelErrorUsername.setVisible(true);
                    checkusername = false;
                }
                if (jTextFieldEmailStaff.getText().equals(u.getEmail()) && checkrole) {
                    jLabelErrorEmail.setText("Email đã tồn tại");
                    jLabelErrorEmail.setVisible(true);
                    checkemail = false;
                }
                if (jTextFieldPhonenumberStaff.getText().equals(u.getPhonenumber()) && checkrole) {
                    jLabelErrorPhonenumber.setText("Số điện thoại đã tồn tại");
                    jLabelErrorPhonenumber.setVisible(true);
                    checkphonenumber = false;
                }
            }
            if (!jTextFieldPincode.getText().equals(String.valueOf(pinCode))) {
                jLabelErrorPincode.setVisible(true);
            }
            if (checkid && checkusername && checkemail && checkphonenumber && checkrole && jTextFieldPincode.getText().equals(String.valueOf(pinCode))) {
                jLabelErrorId.setVisible(false);
                jLabelErrorUsername.setVisible(false);
                jLabelErrorPassword.setVisible(false);
                jLabelErrorConfirmPassword.setVisible(false);
                jLabelErrorEmail.setVisible(false);
                jLabelErrorPincode.setVisible(false);
                jLabelErrorPhonenumber.setVisible(false);
                Users checkExits = new Users();
                checkExits.setId(jTextFieldIdStaff.getText());
                checkExits.setUsername(jTextFieldUsername.getText());
                checkExits.setFullname(jTextFieldNameStaff.getText());
                checkExits.setPassword(String.valueOf(jPasswordFieldPassword.getPassword()));
                checkExits.setGender(jRadioButtonMale.isSelected() ? "Nam" : "Nữ");

                Date birthday = jDateChooserBirthday.getDate();
                checkExits.setBirthday(birthday);
                Date startdate = jDateChooserStartdate.getDate();
                checkExits.setStartdate(startdate);

                checkExits.setAddress(jTextFieldAddressStaff.getText());
                checkExits.setEmail(jTextFieldEmailStaff.getText());
                checkExits.setPhonenumber(jTextFieldPhonenumberStaff.getText());
                checkExits.setBasicsalary(Float.parseFloat(jTextFieldBasicsalaryStaff.getText().replace(",", "")));
                checkExits.setAllowance(Float.parseFloat(jTextFieldAllowanceStaff.getText().replace(",", "")));
                checkExits.setStatus("Hoạt động");
                checkExits.setImage_user(savePath);
                checkExits.setRole("Nhân viên");
                UsersDao.insertStaff(checkExits);
                jLabelErrorAll.setText(roleOfForm + " thành công");
                jLabelErrorAll.setForeground(new java.awt.Color(27, 201, 68));
                jLabelErrorAll.setVisible(true);
            } else if (!checkrole && jTextFieldPincode.getText().equals(String.valueOf(pinCode))) {
                jLabelErrorId.setVisible(false);
                jLabelErrorUsername.setVisible(false);
                jLabelErrorPassword.setVisible(false);
                jLabelErrorConfirmPassword.setVisible(false);
                jLabelErrorEmail.setVisible(false);
                jLabelErrorPincode.setVisible(false);
                jLabelErrorPhonenumber.setVisible(false);
                Users checkExits = new Users();

                checkExits.setId(jTextFieldIdStaff.getText());
                checkExits.setUsername(jTextFieldUsername.getText());
                checkExits.setFullname(jTextFieldNameStaff.getText());
                checkExits.setPassword(String.valueOf(jPasswordFieldPassword.getPassword()));
                checkExits.setGender(jRadioButtonMale.isSelected() ? "Nam" : "Nữ");

                Date birthday = jDateChooserBirthday.getDate();
                checkExits.setBirthday(birthday);
                Date startdate = jDateChooserStartdate.getDate();
                checkExits.setStartdate(startdate);

                checkExits.setAddress(jTextFieldAddressStaff.getText());
                checkExits.setEmail(jTextFieldEmailStaff.getText());
                checkExits.setPhonenumber(jTextFieldPhonenumberStaff.getText());
                checkExits.setBasicsalary(Float.parseFloat(jTextFieldBasicsalaryStaff.getText().replace(",", "")));
                checkExits.setAllowance(Float.parseFloat(jTextFieldAllowanceStaff.getText().replace(",", "")));
                checkExits.setStatus("Hoạt động");
                checkExits.setImage_user(savePath);
                checkExits.setRole("Nhân viên");
                UsersDao.updateStaff(checkExits);
                jLabelErrorAll.setText(roleOfForm + " thành công");
                jLabelErrorAll.setForeground(new java.awt.Color(27, 201, 68));
                jLabelErrorAll.setVisible(true);
            }
        } else {
            jLabelErrorAll.setText("Bạn chưa nhập đủ thông tin");
            jLabelErrorAll.setForeground(new java.awt.Color(255, 0, 0));
            jLabelErrorAll.setVisible(true);
        }
    }//GEN-LAST:event_jLabelButtonAddMouseClicked

    private void jLabelButtonAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonAddMouseEntered
        jLabelButtonAdd.setIcon(scaleImage("/Image/SignButtonGray.png"));
    }//GEN-LAST:event_jLabelButtonAddMouseEntered

    private void jLabelButtonAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonAddMouseExited
        jLabelButtonAdd.setIcon(scaleImage("/Image/SignButtonBlue.png"));
    }//GEN-LAST:event_jLabelButtonAddMouseExited

    private void jLabelButtonClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonClearMouseClicked
        // TODO add your handling code here:
        if (roleOfForm.equals("Thêm nhân viên")) {
            jLabelAvatarStaff.setIcon(null);
            jTextFieldNameStaff.setText("");
            jTextFieldIdStaff.setText("");
            jTextFieldUsername.setText("");
            jPasswordFieldPassword.setText("");
            jPasswordFieldConfirmPassword.setText("");
            jRadioButtonMale.setSelected(true);
            jDateChooserBirthday.setCalendar(null);
            jDateChooserStartdate.setCalendar(null);
            jTextFieldAddressStaff.setText("");
            jTextFieldEmailStaff.setText("");
            jTextFieldPhonenumberStaff.setText("");
            jTextFieldBasicsalaryStaff.setText("");
            jTextFieldAllowanceStaff.setText("");
            jTextFieldPincode.setText("");
        } else {
            jLabelAvatarStaff.setIcon(null);
            jTextFieldNameStaff.setText("");
            jRadioButtonMale.setSelected(true);
            jDateChooserBirthday.setCalendar(null);
            jDateChooserStartdate.setCalendar(null);
            jTextFieldAddressStaff.setText("");
            jTextFieldBasicsalaryStaff.setText("");
            jTextFieldAllowanceStaff.setText("");
            jTextFieldPincode.setText("");
        }

    }//GEN-LAST:event_jLabelButtonClearMouseClicked

    private void jLabelButtonClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonClearMouseEntered
        // TODO add your handling code here:
        jLabelButtonClear.setIcon(scaleImage("/Image/SignButtonGray.png"));
    }//GEN-LAST:event_jLabelButtonClearMouseEntered

    private void jLabelButtonClearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonClearMouseExited
        // TODO add your handling code here:
        jLabelButtonClear.setIcon(scaleImage("/Image/SignButtonBlue.png"));
    }//GEN-LAST:event_jLabelButtonClearMouseExited

    private void jLabelChooseImageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelChooseImageMouseEntered
        // TODO add your handling code here:
        jLabelChooseImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_camera_25px_1.png")));
    }//GEN-LAST:event_jLabelChooseImageMouseEntered

    private void jLabelChooseImageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelChooseImageMouseExited
        // TODO add your handling code here:
        jLabelChooseImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_camera_25px.png")));
    }//GEN-LAST:event_jLabelChooseImageMouseExited

    private void jLabelChooseImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelChooseImageMouseClicked
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            ImagePath = path;
            boolean checkPath = false;
            String[] strPath = ImagePath.split("\\\\");
            for (String string : strPath) {
                if (string.equals("AvatarStaff") || checkPath) {
                    savePath += "/" + string;
                    checkPath = true;
                }
            }
            jLabelAvatarStaff.setIcon(scaleAvatarStaff(savePath));
            System.out.println(savePath);
        } else {
            System.out.println("No file selected!");
        }
    }//GEN-LAST:event_jLabelChooseImageMouseClicked

    private void jTextFieldPhonenumberStaffKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPhonenumberStaffKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldPhonenumberStaffKeyTyped

    private void jTextFieldBasicsalaryStaffKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBasicsalaryStaffKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldBasicsalaryStaffKeyTyped

    private void jTextFieldAllowanceStaffKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAllowanceStaffKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldAllowanceStaffKeyTyped

    private void jTextFieldEmailStaffKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEmailStaffKeyReleased
        if (!checkEmail(jTextFieldEmailStaff.getText())) {
            jLabelErrorEmail.setText("Định dạng email không đúng");
            jLabelErrorEmail.setVisible(true);
        } else {
            jLabelErrorEmail.setVisible(false);
        }
    }//GEN-LAST:event_jTextFieldEmailStaffKeyReleased

    private void jTextFieldBasicsalaryStaffKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBasicsalaryStaffKeyReleased
        if (Character.isDigit(evt.getKeyChar())) {
            double basicSalary = Double.parseDouble(jTextFieldBasicsalaryStaff.getText().replace(",", ""));
            jTextFieldBasicsalaryStaff.setText(String.format("%1$,.0f", basicSalary));
        }
    }//GEN-LAST:event_jTextFieldBasicsalaryStaffKeyReleased

    private void jTextFieldAllowanceStaffKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAllowanceStaffKeyReleased
        if (Character.isDigit(evt.getKeyChar())) {
            double allowance = Double.parseDouble(jTextFieldAllowanceStaff.getText().replace(",", ""));
            jTextFieldAllowanceStaff.setText(String.format("%1$,.0f", allowance));
        }
    }//GEN-LAST:event_jTextFieldAllowanceStaffKeyReleased

    private void jTextFieldIdStaffKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIdStaffKeyReleased
        if (!checkIdStaff(jTextFieldIdStaff.getText())) {
            jLabelErrorId.setText("Mã nhân viên phải bắt đầu bằng US và 8 kí tự số");
            jLabelErrorId.setVisible(true);
        } else {
            jLabelErrorId.setVisible(false);
        }
    }//GEN-LAST:event_jTextFieldIdStaffKeyReleased

    private void jTextFieldPincodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPincodeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPincodeKeyReleased

    private void jPasswordFieldPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordKeyReleased
        if (!checkPasswordStaff(String.valueOf(jPasswordFieldPassword.getPassword()))) {
            jLabelErrorPassword.setVisible(true);
        } else {
            jLabelErrorPassword.setVisible(false);
        }

    }//GEN-LAST:event_jPasswordFieldPasswordKeyReleased

    private void jPasswordFieldConfirmPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldConfirmPasswordKeyReleased
        if (!checkConfirmPasswordStaff(String.valueOf(jPasswordFieldConfirmPassword.getPassword()), String.valueOf(jPasswordFieldPassword.getPassword()))) {
            jLabelErrorConfirmPassword.setVisible(true);
        } else {
            jLabelErrorConfirmPassword.setVisible(false);
        }
    }//GEN-LAST:event_jPasswordFieldConfirmPasswordKeyReleased

    private void jButtonSendPincodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendPincodeActionPerformed
        try {
            ArrayList<Users> ListcheckEmail = UsersDao.checkEmail(jTextFieldEmailStaff.getText());
            boolean check = true;
            for (Users users : ListcheckEmail) {
                if (users.getEmail().equals(jTextFieldEmailStaff.getText())) {
                    check = false;
                }
            }
            if (!check && roleOfForm.equals("Thêm nhân viên")) {
                jLabelErrorEmail.setText("Email đã tồn tại");
                jLabelErrorEmail.setVisible(true);
            } else {
                pinCode = qlbhgg.mailhandle.MailHandle.SendPincode(jTextFieldEmailStaff.getText(), "Mã xác minh đăng lý tài khoản KMA-Gear");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditStaff.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonSendPincodeActionPerformed

    private void jButtonSendPincodeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSendPincodeMouseEntered
        // TODO add your handling code here:
        jButtonSendPincode.setBackground(new java.awt.Color(133, 198, 133));
    }//GEN-LAST:event_jButtonSendPincodeMouseEntered

    private void jButtonSendPincodeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSendPincodeMouseExited
        jButtonSendPincode.setBackground(new java.awt.Color(89, 194, 89));
    }//GEN-LAST:event_jButtonSendPincodeMouseExited

    private void jLabelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabelExitMouseClicked

    private void jLabelExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseEntered
        // TODO add your handling code here:
        jLabelExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_close_window_25px_3.png")));
    }//GEN-LAST:event_jLabelExitMouseEntered

    private void jLabelExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseExited
        // TODO add your handling code here:
        jLabelExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_close_window_25px_4.png")));
    }//GEN-LAST:event_jLabelExitMouseExited

    private void jLabelTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTitleMousePressed
        XX = evt.getX();
        YY = evt.getY();
    }//GEN-LAST:event_jLabelTitleMousePressed

    private void jLabelTitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTitleMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - XX, y - YY);
    }//GEN-LAST:event_jLabelTitleMouseDragged

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditStaff(null, "Sửa thông tin nhân viên").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupGender;
    private javax.swing.JButton jButtonSendPincode;
    private com.toedter.calendar.JDateChooser jDateChooserBirthday;
    private com.toedter.calendar.JDateChooser jDateChooserStartdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelAdd;
    private javax.swing.JLabel jLabelAvatarStaff;
    private javax.swing.JLabel jLabelButtonAdd;
    private javax.swing.JLabel jLabelButtonClear;
    private javax.swing.JLabel jLabelChooseImage;
    private javax.swing.JLabel jLabelClear;
    private javax.swing.JLabel jLabelErrorAll;
    private javax.swing.JLabel jLabelErrorConfirmPassword;
    private javax.swing.JLabel jLabelErrorEmail;
    private javax.swing.JLabel jLabelErrorId;
    private javax.swing.JLabel jLabelErrorPassword;
    private javax.swing.JLabel jLabelErrorPhonenumber;
    private javax.swing.JLabel jLabelErrorPincode;
    private javax.swing.JLabel jLabelErrorUsername;
    private javax.swing.JLabel jLabelExit;
    private javax.swing.JLabel jLabelFrameAvatar;
    private javax.swing.JLabel jLabelInformationAddress1;
    private javax.swing.JLabel jLabelInformationAllowance1;
    private javax.swing.JLabel jLabelInformationBasicsalary1;
    private javax.swing.JLabel jLabelInformationBirthday1;
    private javax.swing.JLabel jLabelInformationConfirmPassword;
    private javax.swing.JLabel jLabelInformationEmail1;
    private javax.swing.JLabel jLabelInformationEmail2;
    private javax.swing.JLabel jLabelInformationGender1;
    private javax.swing.JLabel jLabelInformationId1;
    private javax.swing.JLabel jLabelInformationNameStaff;
    private javax.swing.JLabel jLabelInformationPassword;
    private javax.swing.JLabel jLabelInformationPhonenumber1;
    private javax.swing.JLabel jLabelInformationStartdate1;
    private javax.swing.JLabel jLabelInformationUsername1;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelBackGround;
    private javax.swing.JPanel jPanelTitle;
    private javax.swing.JPasswordField jPasswordFieldConfirmPassword;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JRadioButton jRadioButtonFemale;
    private javax.swing.JRadioButton jRadioButtonMale;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextFieldAddressStaff;
    private javax.swing.JTextField jTextFieldAllowanceStaff;
    private javax.swing.JTextField jTextFieldBasicsalaryStaff;
    private javax.swing.JTextField jTextFieldEmailStaff;
    private javax.swing.JTextField jTextFieldIdStaff;
    private javax.swing.JTextField jTextFieldNameStaff;
    private javax.swing.JTextField jTextFieldPhonenumberStaff;
    private javax.swing.JTextField jTextFieldPincode;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}
