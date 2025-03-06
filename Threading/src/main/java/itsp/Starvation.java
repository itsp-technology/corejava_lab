package itsp;

public class Starvation extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" executing");
    }

    public static void main(String[] args) {
        Starvation st = new Starvation();
        Starvation st1= new Starvation();
        st.setPriority(Thread.MIN_PRIORITY);
        st1.setPriority(Thread.MAX_PRIORITY);
        st.start();
      //  System.out.println("----");
       // Thread.yield();
        st1.start();
    }
}
