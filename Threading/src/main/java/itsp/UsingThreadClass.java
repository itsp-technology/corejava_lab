package itsp;

public class UsingThreadClass extends  Thread{

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println("run method"+i);
        }
    }

    public static void main(String[] args) {
        UsingThreadClass t = new UsingThreadClass();
        Thread th = new Thread(t);
        t.start();
    }
}
