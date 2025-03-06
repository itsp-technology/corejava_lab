package itsp;

public class ThreadCount extends Thread {
    int count  =0;

    @Override
    public void run() {
        count = count+1;
        System.out.println("count "+count);
    }

    public static void main(String[] args) throws  InterruptedException{
        ThreadCount tc = new ThreadCount();
        Thread th = new Thread(tc);
        th.start();

        Thread th2 = new Thread(tc);
        th2.start();

        Thread th3 = new Thread(tc);
        th3.start();
        th.join();
        th2.join();
        th3.join();
        System.out.println("count inside main "+tc.getName());


    }
}
