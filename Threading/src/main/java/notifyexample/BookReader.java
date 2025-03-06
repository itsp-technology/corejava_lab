package notifyexample;

import java.util.concurrent.ExecutionException;

public class BookReader implements Runnable{

    Book book;

    public BookReader(Book book){
        super();
        this.book=book;
    }
    @Override
    public void run(){
        synchronized (book){
            System.out.println(Thread.currentThread().getName()+" is wating for book completesiong of "+book.getBookTitle());
            try {
                book.wait();
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" book has been completed you can  read it ");
        }
    }
}
