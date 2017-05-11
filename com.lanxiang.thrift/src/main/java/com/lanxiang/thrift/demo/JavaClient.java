package com.lanxiang.thrift.demo;

import com.lanxiang.thrift.demo.shared.SharedStruct;
import com.lanxiang.thrift.demo.tutorial.Calculator;
import com.lanxiang.thrift.demo.tutorial.InvalidOperation;
import com.lanxiang.thrift.demo.tutorial.Operation;
import com.lanxiang.thrift.demo.tutorial.Work;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

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
            System.out.println("15-10=" + diff);
        } catch (InvalidOperation io) {
            System.out.println("Invalid operation: " + io.getWhy());
        }

        SharedStruct log = client.getStruct(1);
        System.out.println("Check log: " + log.value);
    }

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Please enter 'simple' or 'secure'");
            System.exit(0);
        }

        try {
            TTransport transport;
            if (args[0].contains("simple")) {
                transport = new TSocket("127.0.0.1", 9090);
                transport.open();
            } else {
                throw new RuntimeException();
            }
            TProtocol protocol = new TBinaryProtocol(transport);
            Calculator.Client client = new Calculator.Client(protocol);
            perform(client);

            transport.close();
        } catch (TException e) {
            e.printStackTrace();
        }
    }


}
