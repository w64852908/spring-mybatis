package com.lanxiang.thrift.demo;

import
import com.lanxiang.thrift.demo.tutorial.Calculator;
import com.lanxiang.thrift.demo.tutorial.InvalidOperation;
import com.lanxiang.thrift.demo.tutorial.Operation;
import com.lanxiang.thrift.demo.tutorial.Work;
import org.apache.thrift.TException;

/**
 * Created by lanxiang on 2017/5/11.
 */
public class JavaClient {

    private static void perform(Calculator.Client client) throws TException {
        client.ping();
        System.out.println("ping()");

        int sum = client.add(1, 1);
        System.out.println("1+1=" + sum);

        Work work = new Work();

        work.op = Operation.DIVIDE;
        work.num1 = 1;
        work.num2 = 0;

        try {
            int quotient = client.calculate(1, work);
            System.out.println("Whoa we can divide by 0");
        } catch (InvalidOperation io) {
            System.out.println("Invalid operation: " + io.getWhy());
        }

        work.op = Operation.SUBTRACT;
        work.num1 = 15;
        work.num2 = 10;
        try {
            int diff = client.calculate(1, work);
        }
    }

    public static void main(String[] args) {

    }
}
