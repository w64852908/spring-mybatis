package com.lanxiang.spring.lookupmethodinjection;

/**
 * Created by lanxiang on 2017/4/14.
 */
public abstract class CommandManager {

    public Object process() {
        Command command = createCommand();
        System.out.println(command);
        return command.execute();
    }

    public abstract Command createCommand();
}
