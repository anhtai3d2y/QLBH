/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.InterfaceController;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author acer
 */
public class ListKind {
    private String kind;
    private JPanel jp;
    private JLabel jl;

    public ListKind(String kind, JPanel jpanel, JLabel jlabel) {
        this.kind = kind;
        this.jp = jpanel;
        this.jl = jlabel;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public JPanel getJp() {
        return jp;
    }

    public void setJp(JPanel jp) {
        this.jp = jp;
    }

    public JLabel getJl() {
        return jl;
    }

    public void setJl(JLabel jl) {
        this.jl = jl;
    }
    
}
