package com.infoplus.hopital.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static String convertIntoTimeStamp(Date time){
        Format format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(time);
    }
}
