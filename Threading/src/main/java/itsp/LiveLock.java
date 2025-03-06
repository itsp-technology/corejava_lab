package itsp;

public class LiveLock {

    static class Worker{
        private boolean active = true;
        public synchronized void work(Worker other)throws InterruptedException{
            while(active){
                System.out.println(Thread.currentThread().getName()+" working");
            }
            Thread.sleep(100);
            other.giveChance(this);
        }

        public synchronized void giveChance(Worker other){
            active =false;
            other.active=true;
        }
    }

    public static void main(String[] args) {
        Worker wk = new Worker();
        Worker wk1 = new Worker();

        new Thread(() -> {
            try {
                wk.work(wk);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Thread -1 ").start();

        Thread th =new Thread(() -> {
            try {
                wk1.work(wk1);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Thread -2");
        th.start();


    }


}
