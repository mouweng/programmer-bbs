package com.mouweng.bbs.utils;

public class PrintUtils {

    static boolean printFlag = true;

    public static void print(String msg){
        if (printFlag){
            System.out.println("PrintMessage:=>"+msg);
        }
    }
}
