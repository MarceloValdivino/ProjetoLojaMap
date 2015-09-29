/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.utils;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Marcelo
 */
public class DateUtil {
    
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
    public static Date getDate(String date) throws ParseException {
        Date dt = null;
        if(date!=null&&!date.equals(""))
            dt = format.parse(date);
        return dt;
    }

    public static String getDate(Date date){
        String data = null;
        if(date!=null)
            data = format.format(date);
        return data;
    }
}
