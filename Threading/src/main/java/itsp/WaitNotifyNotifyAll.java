package itsp;

public class WaitNotifyNotifyAll extends Thread{


    public static void main(String[] args) throws Exception {
       final Object obj = new Object();

       Thread th = new Thread(()->{
          synchronized (obj){
              try{
                  System.out.println("Thread 1 Waiting ...."+Thread.currentThread().getName());
                 // obj.wait();

                  obj.notify();
                  System.out.println("Resume the Thread  "+Thread.currentThread().getName());
              }catch(Exception ie){
                  ie.printStackTrace();
              }
          }
       });

       Thread th2 = new Thread(()->{
           synchronized (obj){
               try{
                   System.out.println("Thread 2 is wating ... "+Thread.currentThread().getName());
                   obj.wait();
                   System.out.println("Resume 2 the Thread "+Thread.currentThread().getName());
               }catch (InterruptedException ie){
                   ie.printStackTrace();
               }
           }
       });
       try{
           Thread.sleep(1000);
       }catch (Exception e){}
       th.start();

       th2.start();

    }
}
