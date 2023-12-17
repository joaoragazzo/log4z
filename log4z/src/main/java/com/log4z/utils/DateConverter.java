package com.log4z.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
    public static Date stringToDate(String dateString) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
            return formatter.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
