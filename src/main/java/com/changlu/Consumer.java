package com.changlu;

import java.util.concurrent.*;

/**
 * Created by changlu on 12/22/17.
 */
public class Consumer {

    private static final Service service = new Service();

    public void consumeAsync(String arg) throws InterruptedException, ExecutionException, TimeoutException {
        Future<String> completableFuture = service.asyncService(arg);
        Future<String> future = service.asyncService(arg);
        System.out.println(completableFuture.get(2, TimeUnit.SECONDS));
        System.out.println(future.get(2, TimeUnit.SECONDS));
    }

    public void asyncConsume(String arg) throws InterruptedException, ExecutionException, TimeoutException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        new Thread(() -> {
            String result = service.longTimeService(arg);
            completableFuture.complete(result);
        }).start();
        System.out.println(service.longTimeService(arg));
        System.out.println(completableFuture.get(2, TimeUnit.SECONDS));
    }

    public void consumeSupplyAsync(String arg) throws InterruptedException, ExecutionException, TimeoutException {
        Future<String> future = service.supplyAsync(arg);
        Future<String> future1 = service.supplyAsync(arg);
        System.out.println(future.get(2,TimeUnit.SECONDS));
        System.out.println(future1.get(2,TimeUnit.SECONDS));
    }

}
