package com.changlu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * Created by changlu on 12/22/17.
 */
public class AsyncTest {

    Consumer consumer;
    TimeUtil timeUtil;

    @Before
    public void initParam(){
        consumer = new Consumer();
        timeUtil = new TimeUtil();
    }

    @After
    public void release(){
        consumer = null;
        timeUtil = null;
    }

    @Test
    public void testConsumeAsync() throws InterruptedException, ExecutionException, TimeoutException {
        Date date = new Date();
        consumer.consumeAsync("Async");
        System.out.println("异步耗时：" + timeUtil.calculateTime(date));
    }

    @Test
    public void testConsumeException(){
        Date date = new Date();
        try {
            consumer.consumeAsync("exception");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("异步耗时：" + timeUtil.calculateTime(date));
    }

    @Test
    public void testAsyncConsume() throws InterruptedException, ExecutionException, TimeoutException {
        Date date = new Date();
        consumer.asyncConsume("async");
        System.out.println("异步耗时：" + timeUtil.calculateTime(date));
    }

    @Test
    public void testConsumeSupplyAsync() throws InterruptedException, ExecutionException, TimeoutException {
        Date date = new Date();
        consumer.consumeSupplyAsync("Async");
        System.out.println("异步耗时：" + timeUtil.calculateTime(date));
    }

    @Test
    public void testConsumeSupplyAsyncException(){
        Date date = new Date();
        try {
            consumer.consumeSupplyAsync("exception");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("异步耗时：" + timeUtil.calculateTime(date));
    }

}
