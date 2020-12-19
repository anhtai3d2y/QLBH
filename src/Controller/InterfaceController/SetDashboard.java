/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.InterfaceController;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import qlbhgg.views.admin.bill.PanelBill;
import qlbhgg.views.admin.customer.PanelCustomer;
import qlbhgg.views.admin.staff.PanelStaff;
import qlbhgg.views.admin.PanelStatistical;
import qlbhgg.views.admin.supplier.PanelSupplier;
import qlbhgg.views.admin.warehouse.PanelWarehouse;
import qlbhgg.views.staff.PanelSale;

/**
 *
 * @author acer
 */
public class SetDashboard {

    private String kindSelected;
    private JPanel jpRoot;
    ArrayList<ListKind> list = null;

    public SetDashboard(JPanel jpRoot) {
        this.jpRoot = jpRoot;
    }

    public String getKindSelected() {
        return kindSelected;
    }

    public void setKindSelected(String kindSelected) {
        this.kindSelected = kindSelected;
    }

    public JPanel getJpRoot() {
        return jpRoot;
    }

    public void setJpRoot(JPanel jpRoot) {
        this.jpRoot = jpRoot;
    }

    public ArrayList<ListKind> getList() {
        return list;
    }

    public void setList(ArrayList<ListKind> list) {
        this.list = list;
    }

    public void setView(JPanel jpItem, JLabel jlItem) throws SQLException {
        kindSelected = "QLDH";
        jpItem.setBackground(new Color(102, 178, 255));
        jlItem.setBackground(new Color(102, 178, 255));

        jpRoot.removeAll();
        jpRoot.setLayout(new BorderLayout());
        jpRoot.add(new PanelBill());
        jpRoot.validate();
        jpRoot.repaint();
    }

    public void setEvent(ArrayList<ListKind> list) {
        this.list = list;
        for (ListKind item : list) {
            item.getJp().addMouseListener(new PanelEvent(item.getKind(), item.getJp(), item.getJl()));
        }
    }

    class PanelEvent implements MouseListener {

        private JPanel node;
        private String kind;

        private JPanel jpItem;
        private JLabel jlItem;

        public PanelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpItem = jpnItem;
            this.jlItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "QLDH": {
                    try {
                        node = new PanelBill();
                    } catch (SQLException ex) {
                        Logger.getLogger(SetDashboard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "QLNV": {
                    try {
                        node = new PanelStaff();
                    } catch (SQLException ex) {
                        Logger.getLogger(SetDashboard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "QLK": {
                    try {
                        node = new PanelWarehouse();
                    } catch (SQLException ex) {
                        Logger.getLogger(SetDashboard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "QLNCC": {
                    try {
                        node = new PanelSupplier();
                    } catch (SQLException ex) {
                        Logger.getLogger(SetDashboard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "TTKH": {
                    try {
                        node = new PanelCustomer();
                    } catch (SQLException ex) {
                        Logger.getLogger(SetDashboard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "QLBH":  {
                    node = new PanelSale();
                }
                break;

                case "TK": {
                    node = new PanelStatistical();
                }
                break;

                default:
                    break;
            }
            jpRoot.removeAll();
            jpRoot.setLayout(new CardLayout());
            jpRoot.add(node);
            jpRoot.validate();
            jpRoot.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpItem.setBackground(new Color(102, 178, 255));
            jlItem.setBackground(new Color(102, 178, 255));
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpItem.setBackground(new Color(102, 102, 102));
                jlItem.setBackground(new Color(102, 102, 102));
            }
            else{
                jpItem.setBackground(new Color(102, 178, 255));
                jlItem.setBackground(new Color(102, 178, 255));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpItem.setBackground(new Color(0, 0, 0));
                jlItem.setBackground(new Color(0, 0, 0));
            } else {
                jpItem.setBackground(new Color(102, 178, 255));
                jlItem.setBackground(new Color(102, 178, 255));
            }
        }
    }

    private void setChangeBackground(String kind) {
        for (ListKind item : list) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJp().setBackground(new Color(102, 178, 255));
                item.getJl().setBackground(new Color(102, 178, 255));
            } else {
                item.getJp().setBackground(new Color(0, 0, 0));
                item.getJl().setBackground(new Color(0, 0, 0));
            }
        }
    }
}
