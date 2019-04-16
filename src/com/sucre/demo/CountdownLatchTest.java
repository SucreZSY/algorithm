package com.sucre.demo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 使用CountdownLatch来实现主线程等待其他线程结束并收集结果的demo
 */
public class CountdownLatchTest {
    public ExecutorService service;
    public Queue<Future<?>> queue;
    public final CountDownLatch countDownLatch;

    public CountdownLatchTest(ExecutorService service, Queue<Future<?>> queue, int threadNum){
        this.service = service;
        this.queue = queue;
        this.countDownLatch = new CountDownLatch(threadNum);
    }
    /**
     * 提交任务，但是不会阻塞其他线程（主线程）
     * @param task 需要执行的任务
     */
    public void runDontBlockTheMainThread(Callable<?> task){
        Future<?> res = service.submit(task);
        queue.offer(res);
    }

    /**
     * 会阻塞当前主线程，等新开的线程结束才会执行主线程或者创建另一个新的线程
     * @param task 任务
     */
    public void runBlockTheMainThreadAndCreateThreadOneByOne(Callable<?> task) {
        Future<?> res = service.submit(task);
        try {
            System.out.println(res.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 主线程会等待，直到所有的新线程完全结束之后才会执行下去
     * @param task 要执行的任务，必须是特殊的，任务代码中结束之后必须执行countdown操作
     */
    public void runBlockTheMainThread(Callable<?> task){
        Future<?> res = service.submit(task);
        queue.offer(res);
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //countdownLatch的使用需要条件，这里用一个例子来表示，获取能产生随机数的十个线程的返回值
        ExecutorService service = Executors.newCachedThreadPool();
        Queue<Future<?>> queue = new LinkedList<>();
        int threadNum = 10;
        final CountdownLatchTest test = new CountdownLatchTest(service, queue, threadNum);
        while (threadNum-- > 0){
            test.runBlockTheMainThread(() -> {
                try {
                    Random random = new Random();
                    System.out.println("这个线程开始执行了");
                    Thread.sleep(5000);
                    System.out.println("这个线程结束了");
                    return random.nextInt();
                }finally {
                    test.countDownLatch.countDown();//精髓之处，必须要countDown，否则主线程永远执行不了了
                }
            });
        }
        test.countDownLatch.await();//阻塞主线程，等待上面线程任务全部结束再继续执行
        service.shutdown();//任务执行完毕，可以将线程池关闭了（shutDownNow也是可以的）
        for (Future<?> future : queue) {
            System.out.println(future.get());//获取执行完之后的任务
        }

    }
}
