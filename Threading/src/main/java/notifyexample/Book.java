package notifyexample;

public class Book {

    private String bookTitle;
    private String bookName;

    private boolean isCompleted;

    public Book(String title){
     super();
     this.bookTitle=title;
    }
    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookName() {
        return bookName;
    }


}
