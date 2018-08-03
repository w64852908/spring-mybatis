package com.lanxiang.joda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lanxiang on 2017/6/14.
 */
public class JodaTest {

    @Test
    public void marathonDate() {
        DateTime endDate = new DateTime(2018, 9, 23, 0, 0, 0);
        DateTime today = new DateTime();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        int i = 12;
        DateTime weekStart, weekEnd;
        List<String> output = new ArrayList<>();
        while (i > 0) {
            weekEnd = endDate;
            weekStart = endDate.minusDays(6);
            output.add(String.format("第%s周训练,范围[%s]-[%s]", i, weekStart.toString(formatter), weekEnd.toString(formatter)));
            i--;
            endDate = endDate.minusDays(7);
        }
        Collections.reverse(output);
        for (String str : output) {
            System.out.println(str);
        }
    }

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

    @Test
    public void test14() {
        DateTime dateTime = new DateTime();
        System.out.println(dateTime.minusMillis(dateTime.getMillisOfDay()));
        float a = 14;
        int b = 15;
        float c = a / b;
        System.out.println(c);
        Assert.assertTrue(c > 0.9);
    }

    private static final String DATE_FORMAT = "yyyyMMdd";

    @Test
    public void test15() {
        String today = new DateTime().toString(DATE_FORMAT);
        System.out.println(today);
    }

    @Test
    public void test16() {
        String pattern = "hh:mm:ss";
        String now = new DateTime().toString(pattern);
        System.out.println(now);
    }

    @Test
    public void test17() {
        String pattern = "yyyyMMdd hh:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String now = format.format(new Date());
        System.out.println(now);
    }

    @Test
    public void test18() {
        long start = new DateTime(2017, 6, 1, 0, 0, 0).getMillis();
        long end = new DateTime(2017, 7, 31, 23, 59, 59).getMillis();
        System.out.println(start);
        System.out.println(end);
    }

    @Test
    public void test19() throws ParseException {
        String time = "2018-01-19 11:10:00";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse(time);
        System.out.println(date.getTime());
    }

    @Test
    public void test20() {
        DateTime dateTime = new DateTime();

        DateTime sixMonth = dateTime.plusMonths(6);

        DateTime halfYear = dateTime.plusDays(180);

        System.out.println(sixMonth.toString("yyyy-MM-dd HH:mm:ss"));

        System.out.println(halfYear.toString("yyyy-MM-dd HH:mm:ss"));

    }

    @Test
    public void test21() {
        DateTime dateTime = new DateTime(1527073200000L);
        System.out.println(dateTime.toString("yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    public void test22() {
        DateTime dateTime = new DateTime(1518844516080L);
        System.out.println(dateTime);
        dateTime = new DateTime(1518343200000L);
        System.out.println(dateTime);
    }

    @Test
    public void test23() {
        DateTime start = new DateTime(2017, 10, 11, 0, 0, 0);
        DateTime end = new DateTime(2017, 10, 11, 23, 59, 59);

        System.out.println(start.getMillis());
        System.out.println(end.getMillis());
    }

    @Test
    public void test24() {
        DateTime d1 = new DateTime(1511586700037L);
        DateTime d2 = new DateTime(1511586700185L);
        DateTime d3 = new DateTime(1511586720440L);
        DateTime d4 = new DateTime(1511586723809L);
        DateTime d5 = new DateTime(1511586780391L);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d4);
        System.out.println(d5);
    }

    @Test
    public void test25() {
        Date today = new DateTime().toLocalDate().toDate();
        System.out.println(today);

        Date now = new DateTime().toDate();
        System.out.println(now);

        System.out.println(LocalDate.now());
    }

    @Test
    public void test26() {
        DateTime now = new DateTime().plusHours(6);
        System.out.println(now.getHourOfDay());
        DateTime date = new DateTime(2018, 1, 30, 22, 0, 0);
        System.out.println(date.getHourOfDay());
    }

    @Test
    public void test27() {
        String format = "yyyyMMdd";
        DateTime start = new DateTime(2018, 1, 31, 0, 0, 0);
        DateTime end = new DateTime(2019, 2, 1, 0, 0, 0);
        while (start.isBefore(end.getMillis())) {
            System.out.println("ALTER TABLE `record_log" + start.toString(format) + "` CHANGE `order_id` `order_id` BIGINT(20)  UNSIGNED  NOT NULL  DEFAULT '0'  COMMENT '订单ID';");
            start = start.plusDays(1);
        }
    }

    @Test
    public void test28() {
        String dateStr = "20180212";
        System.out.println(LocalDate.parse(dateStr).toString("yyyyMMdd"));
    }

    @Test
    public void test29() {
        Date date = new Date();
        System.out.println(String.format("lanxiang:%s:%s", new SimpleDateFormat("yyyyMMdd").format(date), 2333));
    }

    @Test
    public void test30() {
        DateTime date = new DateTime(2017, 8, 13, 0, 0, 0);
        System.out.println(date.plusDays(180).toString("yyyyMMdd"));
    }

    @Test
    public void test31() {
        String dateStr = "20180827";
        System.out.println(DateTimeFormat.forPattern("yyyyMMdd").parseDateTime(dateStr).plusDays(1).minusMillis(1).toDate());
    }

    @Test
    public void test32() {
        DateTime start = new DateTime(2018, 3, 1, 0, 0, 0);
        DateTime end = new DateTime(2018, 3, 1, 0, 0, 0);
        System.out.println(start.getMillis() + "-" + end.getMillis());
    }

    @Test
    public void testPlus() {
        DateTime now = new DateTime();
        System.out.println(now);
        now.plusDays(11);
        System.out.println(now);
    }

    @Test
    public void test33() {
        long time = 1529028185017L;
        System.out.println(new DateTime(time).toString("yyyyMMdd hh:MM:ss"));

    }

    @Test
    public void test34() {
        DateTime dateTime = new DateTime(2018, 3, 27, 12, 9, 8);
        DateTime expireDate = dateTime.plusDays(180);
        System.out.println(expireDate.toString("yyyy-MM-dd hh:MM:ss"));
    }

    @Test
    public void test35() {
        DateTime now = new DateTime();
        DateTime tomorrow = now.plusDays(2);
        System.out.println((tomorrow.getMillis() - now.getMillis()) / 1000 / 3600 / 24);
    }

    @Test
    public void test36() {
        String format = "yyyyMMdd hh:MM:ss";

        DateTime now = new DateTime();

        int hour = now.getHourOfDay();
        int minute = now.getMinuteOfHour();
        int seconds = now.getSecondOfMinute();

        now = now.minusHours(hour).minusMinutes(minute).minusSeconds(seconds);

        DateTime start = now.minusDays(7);

        DateTime end = start.plusDays(1);


        System.out.println(start.toString(format));

        System.out.println(end.toString(format));

        DateTime haha = DateTime.now().withTimeAtStartOfDay();
        System.out.println(haha.toString(format));
    }
}
