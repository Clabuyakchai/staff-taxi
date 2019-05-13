package com.clabuyakchai.user.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
    public static Date date = Calendar.getInstance().getTime();

    public static String formatDate(){
        return new SimpleDateFormat("dd.MM.yyyy").format(date);
    }

    public static String formatDate(Date date){
        return new SimpleDateFormat("dd.MM.yyyy").format(date);
    }

    public static String formatTime(){
        return new SimpleDateFormat("HH:mm").format(date);
    }

    public static String formatTime(Date date){
        return new SimpleDateFormat("HH:mm").format(date);
    }
}
