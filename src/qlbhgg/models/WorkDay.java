/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author acer
 */
public class WorkDay {
    private String id;
    private Date workday;

    public WorkDay() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getWorkday() {
        return workday;
    }

    public void setWorkday(Date workday) {
        this.workday = workday;
    }

    @Override
    public String toString() {
        return "WorkDay{" + "id=" + id + ", workday=" + workday + '}';
    }
    public static WorkDay getFromResultSet(ResultSet rs) throws SQLException{
        WorkDay wd = new WorkDay();
        wd.setId(rs.getString("id_user"));
        wd.setWorkday(rs.getDate("work_day"));
        return wd;
    }
}
