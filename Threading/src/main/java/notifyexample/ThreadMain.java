package notifyexample;

public class ThreadMain {

    public static void main(String[] args) {
        Book bk = new Book("Java");
        BookReader br1 = new BookReader(bk);
        BookReader br2 = new BookReader(bk);
        Thread th = new Thread(br1,"vivek");
        Thread th2 = new Thread(br2,"Rani");

        th.start();
        th2.start();

        try{
            Thread.sleep(1100);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }

        BookWrites bw = new BookWrites(bk);
        Thread th3 = new Thread(bw);
        th3.start();

    }
}
