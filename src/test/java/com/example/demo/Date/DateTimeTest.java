package com.example.demo.Date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class DateTimeTest {
    @Test
    public void DateTest(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        System.out.println("DAY_OF_MONTH:"+calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("There are "+calendar.getActualMaximum(Calendar.DAY_OF_MONTH)+" days in this month");
        System.out.println("DAY_OF_YEAR:"+calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("There are "+calendar.getActualMaximum(Calendar.DAY_OF_YEAR)+" days in this year");
        
        calendar.add(Calendar.YEAR, -3);
        System.out.println(simpleDateFormat.format(calendar.getTime()));
        calendar.add(Calendar.MONTH, 4);
        System.out.println(simpleDateFormat.format(calendar.getTime()));
    }
}
