package notifyexample;

import java.util.concurrent.ExecutionException;

public class BookWrites implements Runnable{

    Book book;
    public BookWrites(Book book){
        super();
        this.book=book;
    }

    @Override
    public void run() {
        synchronized (book){
            System.out.println("Auther is starting book : "+book.getBookTitle());
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            book.setCompleted(true);
            System.out.println("book has been completed");

            //book.notify();
            book.notifyAll();
            System.out.println("notify one Reader");
        }
    }
}
