/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author acer
 */
public class TestCalendar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the year: ");
        int selectedYear = sc.nextInt();
        System.out.println("Enter the month: ");
        int selectedMonth = sc.nextInt() - 1;

        Calendar cal = new GregorianCalendar();
        int cDay = cal.get(Calendar.DATE);
        int cMonth = cal.get(Calendar.MONTH);
        int cYear = cal.get(Calendar.YEAR);

        GregorianCalendar gCal = new GregorianCalendar(selectedYear, selectedMonth, 1);
        int days = gCal.getActualMaximum(Calendar.DATE);
        int startInWeek = gCal.get(Calendar.DAY_OF_WEEK);

        gCal = new GregorianCalendar(selectedYear, selectedMonth, days);
        int totalweeks = gCal.getActualMaximum(Calendar.WEEK_OF_MONTH);

        int count = 1; //Count the days
        String [] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        System.out.println(months[selectedMonth] + " - " + selectedYear);
        System.out.println("SU MO TU WE TH FR SA");
        System.out.println(cMonth);

        for (int i = 1; i <= totalweeks; i++) {
            System.out.println();
            for (int j = 1; j <= 7; j++) {
                if (count < startInWeek || (count - startInWeek + 1) > 31) {
                    System.out.print("__");
                    System.out.print(" ");
                } else {
                    if (cDay == (count - startInWeek + 1) && cMonth == selectedMonth && cYear == selectedYear) {
                        System.out.print("'" + getDay((count - startInWeek + 1)) + "'");
                        System.out.print(" ");
                    } else {
                        System.out.print(getDay((count - startInWeek + 1)));
                        System.out.print(" ");
                    }
                }
                count++;
            }
        }

    }

    private static String getDay(int i) {
        String sDate = Integer.toString(i);
        if (sDate.length() == 1) {
            sDate = "0" + sDate;
        }
        return sDate;
    }
}
