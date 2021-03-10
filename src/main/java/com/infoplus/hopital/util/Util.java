package com.infoplus.hopital.util;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static String convertIntoTimeStamp(Date time){
        Format format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(time);
    }

    public static Date covertStringToDate(String time) throws ParseException {
        Date date  = new SimpleDateFormat("yyyy-MM-dd").parse(time);
        return date;
    }
}
