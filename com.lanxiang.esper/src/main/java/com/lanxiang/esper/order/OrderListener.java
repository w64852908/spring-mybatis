package com.lanxiang.esper.order;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * Created by lanxiang on 2017/9/19.
 */
public class OrderListener implements UpdateListener {

    @Override
    public void update(EventBean[] newEvents, EventBean[] oldEvents) {
//        countCinema(newEvents);
        countDiscountCardId(newEvents);
        for (EventBean eventBean : newEvents) {
            System.out.println("===");
            System.out.println(eventBean.getUnderlying().toString());
        }
    }

    private void countCinema(EventBean[] events) {
        System.out.println("单影院会员卡掉单达到阈值," + events[0].getUnderlying());
    }

    private void countDiscountCardId(EventBean[] events) {
//        System.out.println("单个会员卡掉单达到阈值," + events[0].getUnderlying());
    }
}
