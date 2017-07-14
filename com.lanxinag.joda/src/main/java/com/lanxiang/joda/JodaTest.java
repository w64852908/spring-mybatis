package com.lanxiang.joda;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lanxiang on 2017/6/14.
 */
public class JodaTest {

    @Test
    public void test1() {
        DateTime yesterday = new DateTime();
        System.out.println(yesterday.toDate());
    }

    @Test
    public void test2() {
        DateTime yesterday = new DateTime().minusDays(2);
        System.out.println(yesterday.toDate().getTime());
    }

    @Test
    public void test3() {
        DateTime date = new DateTime(1498834800000L);
        System.out.println(date.toDate());
    }

    @Test
    public void test5() {
        int year = 2017;
        int month = 6;
        int day = 13;

        Long start = getStartAndEnd(year, month, day, 1).getMillis();
        Long end = getStartAndEnd(year, month, day, 2).getMillis();
        System.out.println(start);
        System.out.println(end);
    }

    private DateTime getStartAndEnd(int year, int month, int day, int type) {
        int hour = 0, minute = 0, second = 0, millsSecond = 0;
        if (type != 1) {
            hour = 23;
            minute = 59;
            second = 59;
            millsSecond = 999;
        }
        return new DateTime(year, month, day, hour, minute, second, millsSecond);
    }

    @Test
    public void test6() {
        int year = 2017;
        int month = 6;
        int day = 13;
        DateTime date = new DateTime(year, month, day, 0, 0, 0, 0);
        System.out.println(date.toDate());
    }

    @Test
    public void test7() {
        DateTime yesterday = new DateTime().minusDays(1);
        final Long startTime = new DateTime(yesterday.getYear(), yesterday.getMonthOfYear(), yesterday.getDayOfMonth(), 0, 0, 0, 0).getMillis();
        System.out.println(startTime);
    }

    @Test
    public void test8() {
        int start = 7414;
        while (start <= 7453) {
            System.out.print(start++ + ",");
        }
    }

    @Test
    public void test9() {
//        2017-06-22
        DateTime dateTime = new DateTime(2017, 6, 22, 0, 0, 0);
        System.out.println(dateTime.getMillis());
    }

    @Test
    public void test10() {
        long l1 = TimeUnit.SECONDS.toMillis(30L);
        System.out.println(l1);
    }

    @Test
    public void test11() {
        DateTime dateTime = new DateTime(2014, 1, 1, 23, 59, 59);
        System.out.println(dateTime.toDate());
    }

    @Test
    public void test12() {
        DateTime dateTime = new DateTime(2014, 1, 1, 23, 59, 59);
        Date date1 = dateTime.toDate();
        dateTime = new DateTime(2014, 1, 1, 23, 59, 59);
        Date date2 = dateTime.toDate();
        Assert.assertTrue(date1.equals(date2));
    }

    @Test
    public void test13() {
        DateTime dateTime1 = new DateTime(2014, 1, 1, 23, 59, 59);
        DateTime dateTime2 = new DateTime(2014, 1, 1, 0, 0, 0);
        System.out.println(dateTime1.getMillis());
        System.out.println(dateTime2.getMillis());
    }
}
