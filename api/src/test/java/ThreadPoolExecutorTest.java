import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.*;

@SpringBootTest
public class ThreadPoolExecutorTest {


    @Test
    public void test1() {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 10, 1, TimeUnit.MINUTES, new LinkedBlockingQueue());
        System.out.println("核心池的大小:" + executor.getCorePoolSize());
        System.out.println("最大线程数:" + executor.getMaximumPoolSize());

        executor.setMaximumPoolSize(20);
        executor.setCorePoolSize(2);
        System.out.println("设置后的核心池大小:" + executor.getCorePoolSize());
        System.out.println("设置后的最大线程数:" + executor.getMaximumPoolSize());
    }


    @Test
    public void test2() {


        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5), new ThreadPoolExecutor.CallerRunsPolicy());


        for (int i = 0; i < 50; i++) {

            int finalI1 = i;
            executor.execute(() -> System.out.println("正在执行:" + finalI1));
            System.out.println("线程池中的线程数:" + executor.getPoolSize() + ",线程池中等待执行的任务:" + executor.getQueue().size() + ",已经执行的任务:" + executor.getCompletedTaskCount());


        }
        executor.shutdown();


//        while (true) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }


//        executor.shutdown();
//        while (!executor.isTerminated()) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }


    }

    @Test
    public void test3() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 1, TimeUnit.MINUTES, new SynchronousQueue<>(), new ThreadPoolExecutor.AbortPolicy());
        System.out.println("当前线程池核心数:" + executor.getPoolSize());
        executor.prestartCoreThread();
        //executor.prestartAllCoreThreads();
        System.out.println("初始化后的核心数:" + executor.getPoolSize());

    }


    private int a = 1;

    @Test
    public void test4() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (a == 1) {
                    System.out.println("1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        System.out.println("改变1之前");
        a=2;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("改变1之后");
    }


}
