package ru.geekbrains.lesson4;

import java.util.concurrent.*;

public class ExecutorServiceDemo {

    private static final int n=2;
    public static void main(String[] args) {
        final BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(100);
        ExecutorService executorService;
        executorService = new ThreadPoolExecutor(n, n, 0L, TimeUnit.MILLISECONDS, queue);

        //executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hi from thread pool thread 1.");
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hi from thread pool thread 2.");
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hi from thread pool thread 3.");
            }
        });

        Future<?> runnableFuture = executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hi from thread pool thread 4.");
            }
        });

        Future<String> callableFuture = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "Hello from callable";
            }
        });

        try {
            System.out.println(callableFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // Вместо join, для заданий, запущенных через ExecutorService
        try {
            runnableFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Task 4 completed!");

        // дожидается выполнения всех запущенных заданий и завершает работу ExecutorService
        executorService.shutdown();
        // Шлет всем потокам сообщение interrupted и завершает работу ExecutorService
        // executorService.shutdownNow();
    }
}