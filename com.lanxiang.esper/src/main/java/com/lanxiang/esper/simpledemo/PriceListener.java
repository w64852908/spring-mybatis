package com.lanxiang.esper.simpledemo;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * Created by lanxiang on 2017/11/27.
 */
public class PriceListener implements UpdateListener {

    @Override
    public void update(EventBean[] newEvents, EventBean[] oldEvents) {
        EventBean event = newEvents[0];
        System.out.println(event.get("price"));
    }
}
