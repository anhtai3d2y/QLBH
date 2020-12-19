/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClassObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author acer
 */
public class Bill {
    protected String codebill, customercode, iduser, note;
    protected Date creationdate;

    public Bill() {
    }

    public String getCodebill() {
        return codebill;
    }

    public void setCodebill(String codebill) {
        this.codebill = codebill;
    }

    public String getCustomercode() {
        return customercode;
    }

    public void setCustomercode(String customercode) {
        this.customercode = customercode;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    

    @Override
    public String toString() {
        return "Bill{" + "codebill=" + codebill + ", customercode=" + customercode + ", iduser=" + iduser + ", creationdate=" + creationdate + ", note=" + note + '}';
    }
    public static Bill getFromResultSet(ResultSet rs) throws SQLException{
        Bill bill = new Bill();
        bill.setCodebill(rs.getString("code_bill"));
        bill.setCustomercode(rs.getString("customer_code"));
        bill.setIduser(rs.getString("id_user"));
        bill.setCreationdate(rs.getDate("invoice_creation_date"));
        bill.setNote(rs.getNString("note"));
        return bill;
    }
}
