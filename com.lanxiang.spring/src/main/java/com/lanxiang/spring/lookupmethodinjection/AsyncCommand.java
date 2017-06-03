package com.lanxiang.spring.lookupmethodinjection;

/**
 * Created by lanxiang on 2017/4/14.
 */
public class AsyncCommand implements Command {
    @Override
    public Object execute() {
        System.out.println("Async command execute.");
        return "Execute result.";
    }
}
