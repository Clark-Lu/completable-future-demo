package com.changlu;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Created by changlu on 12/22/17.
 */
public class Service {

    public String longTimeService(String arg){
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (arg.equals("exception")){
            int i = 2/0;
            throw new  RuntimeException("运行时exception");
        }
        return "Hello "+ arg;
    }

    public CompletableFuture<String> asyncService(String arg){
        CompletableFuture<String> completableFuture = new CompletableFuture<String>();
        new Thread(()->{
            try {
                String result = longTimeService(arg);
                completableFuture.complete(result);
            }catch (Exception e){
                completableFuture.completeExceptionally(e);
            }
        }).start();
        return completableFuture;
    }

    public Future<String> supplyAsync(String arg){
        return CompletableFuture.supplyAsync(() -> longTimeService(arg));
    }
}
