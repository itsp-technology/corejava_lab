package itsp;

public class StopThreadGradefull implements Runnable{
    @Override
    public void run() {
        for(int i= 0 ; i<=100 ; i++){

            if(Thread.currentThread().isInterrupted()){
                System.out.println("Thread Interrupted ... Stopping Tasking ");
                break;
            }

            System.out.println("processing the Thread "+i);
            try{
                Thread.sleep(100);
            }catch (InterruptedException id){break;}
        }
    }

    public static void main(String[] args) {
       Thread th =new Thread(new StopThreadGradefull());
        th.start();
        try{
            Thread.sleep(1000);
        }catch (InterruptedException ie){}
        th.interrupt();
    }
}
