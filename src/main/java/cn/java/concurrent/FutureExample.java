package cn.java.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 作者: Jiang
 * 时间: 2021/8/24
 * 描述:
 */
public class FutureExample {
    static class CalculationCallable implements Callable<Integer> {
        private final int x;
        private final int y;
        public CalculationCallable(int x,int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public Integer call() throws Exception {
            return x+y;
        }
    }
    /*public static void main(String[] args) throws ExecutionException, InterruptedException {
        CalculationCallable calculationCallable = new CalculationCallable(1,2);
        FutureTask<Integer> futureTask = new FutureTask<>(calculationCallable);
        new Thread(futureTask).start();
        Integer result = futureTask.get();//阻塞获取返回值
        System.out.println("线程返回值:"+result);
    }*/

    /*public static void main(String[] args) {
        CompletableFuture cf1 = CompletableFuture.supplyAsync(()->"hello world").thenAccept(rs-> System.out.println(rs));
    }*/
    /*public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(()->"hello");
        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(()->" world!");
        CompletableFuture<String> task3 = CompletableFuture.supplyAsync(()->" test!");
        task1.thenAcceptBoth(task2.thenAcceptBoth(task3,(r3,r4)->{
            System.out.println(r3+r4);
        }),(r1,r2)->{
            System.out.println(r1+r2);
        }).get();
    }*/

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture cf = CompletableFuture.supplyAsync(()->"hello").thenApply((r)->{
            return r+" world!";
        });
        System.out.println(cf.get());

    }
}
