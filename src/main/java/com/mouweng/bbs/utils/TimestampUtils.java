package com.mouweng.bbs.utils;

import java.sql.Timestamp;
import java.util.Date;

public class TimestampUtils {
    public static Timestamp getTime(){
        return new Timestamp(new Date().getTime());
    }
}
