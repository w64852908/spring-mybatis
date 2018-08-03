package com.lanxiang.esper.order;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

/**
 * Created by lanxiang on 2017/9/19.
 */
public class OrderEventTest {

    private EPAdministrator epAdministrator;

    private EPRuntime epRuntime;

    private static final String EVENT_TYPE = "OrderEvent";

    private static final Random random = new Random();

    @Before
    public void init() {
        Configuration config = new Configuration();
        config.addEventType(EVENT_TYPE, Order.class.getName());
        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);
        epRuntime = epService.getEPRuntime();
        epAdministrator = epService.getEPAdministrator();
    }

    private void sendOrderData() {
        List<Order> orders = Arrays.asList(new Order(1, 1, 10000, 30, 233)
                , new Order(2, 0, 0, 33, 233)
                , new Order(3, 1, 10001, 28, 233)
                , new Order(4, 0, 10000, 30, 233));
        for (Order order : orders) {
            epRuntime.sendEvent(order);
        }
    }

    private void sendManyOrderData() {
        int total = 10000;
        for (int i = 0; i < total; i++) {
            int roll = random.nextInt(100) + 1;
            int isVip = 0;
            int disCountCard = 0;
            if (roll > 5) {
                isVip = 1;
                disCountCard = roll * 100;
            }
            epRuntime.sendEvent(new Order(i, isVip, disCountCard, 30, 10086));
        }
    }

    @Test
    public void test1() {
        String express = "select id,discountCardId,price,cinemaId from " + EVENT_TYPE + ".win:length_batch(3) having price > 25";

        EPStatement statement = epAdministrator.createEPL(express);
        statement.addListener(new OrderListener());
        sendOrderData();
    }

    @Test
    public void countCinema() {
        String window = "create window cinemaWindow.win:time(10 sec) as " + EVENT_TYPE;
        String express = "select cinemaId,count(*) AS count from " + EVENT_TYPE + " where isVip = 1 group by cinemaId having count(*) > 30";

        epAdministrator.compileEPL(window);
        EPStatement statement = epAdministrator.createEPL(express);
        statement.addListener(new OrderListener());
        sendManyOrderData();
    }

    @Test
    public void countDiscountCardId() {
        String window = "create window cinemaWindow.win:time(10 sec) as " + EVENT_TYPE;

        String express = "select discountCardId from " + EVENT_TYPE;


        epAdministrator.compileEPL(window);
        EPStatement statement = epAdministrator.createEPL(express);
        statement.addListener(new OrderListener());
        sendManyOrderData();
    }

    @Test
    public void testSelectAll() {
        String window = "create window cinemaWindow.win:time(10 minutes) as " + EVENT_TYPE;

        String source = "insert into cinemaWindow select * from " + EVENT_TYPE;

        String express = "select * from " + EVENT_TYPE;


        epAdministrator.compileEPL(window);
        EPStatement statement = epAdministrator.createEPL(express);
        statement.addListener(new OrderListener());
        sendManyOrderData();
    }
}
