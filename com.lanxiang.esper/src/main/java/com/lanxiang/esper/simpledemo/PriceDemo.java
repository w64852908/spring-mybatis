package com.lanxiang.esper.simpledemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

/**
 * Created by lanxiang on 2017/11/27.
 */
public class PriceDemo {

    private List<Integer> priceList = new ArrayList<>();

    private static final int ARR_LEN = 10;

    @Before
    public void init() {
        for (int i = 0; i < ARR_LEN; i++) {
            priceList.add((i + 1) * 10);
        }
        Collections.shuffle(priceList);
        System.out.println("Price sort : " + priceList);
    }

    @Test
    public void run() {
        //Creating a configuration
        Configuration config = new Configuration();
        config.addEventTypeAutoName(PriceEvent.class.getName());//添加包路径，这样在查询表达式中就不需要写类的全路径了
        //Creating a statement
        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);
        //查询最近30秒钟到达的最高价格
        String expression = "select price from " + PriceEvent.class.getName() + ".win:time(30 sec) having price >= max(price)";
        EPStatement statement = epService.getEPAdministrator().createEPL(expression);
        //Adding a listener
        statement.addListener(new PriceListener());
        //Sending events
        for (int i = 0; i < ARR_LEN; i++) {
            epService.getEPRuntime().sendEvent(new PriceEvent(priceList.get(i), "Name" + i));
        }
    }
}
