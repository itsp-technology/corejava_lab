package itsp;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        for(int i = 0 ; i <= 10 ; i++){
            es.submit(()->{
                System.out.println(Thread.currentThread().getName()+"is Executing");
            });
        }
        es.shutdown();
    }
}
