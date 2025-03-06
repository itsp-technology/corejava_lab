package itsp;

import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
public class BankAccountReentrantLockThread {
    int balance;
   private ReentrantLock reentrantLock = new ReentrantLock();
   // private ReentrantLock reentrantLock = new ReentrantLock(true);
    BankAccountReentrantLockThread(int balance){
    this.balance =balance;
    }
    public void withdraw(String user, int amount) {
        reentrantLock.lock();
      // boolean accordLock = reentrantLock.tryLock();
        //if(accordLock){}else{do somethid pallel}
        try {
            if (balance >= amount) {
                System.out.println(user + " Trying to withdraw amount " + amount);

                Thread.sleep(1000);
                balance -= amount;
                System.out.println(user + " successfully withdrew " + amount);
            }else{
                System.out.println("your amount is "+amount+" \nyour  Balance is"+balance);
           }
            System.out.println("Remaning Balance " + balance);
         }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }


    }

    public static void main(String[] args) {
        BankAccountReentrantLockThread ba = new BankAccountReentrantLockThread(2000);
        Thread th1 = new Thread(new BankUser1(ba,"rani",20));
        Thread th2 = new Thread(new BankUser1(ba,"raja",30));
        Thread th3 = new Thread(new BankUser1(ba,"raja",30));
        th1.start();
       th2.start();
       th3.start();
    }
}
class BankUser1 implements  Runnable{
    private BankAccountReentrantLockThread bankAccountReentrantLockThread;
    private String user;
    private int amount;

    public BankUser1(BankAccountReentrantLockThread bankAccountReentrantLockThread , String user, int amount){
        this.bankAccountReentrantLockThread=bankAccountReentrantLockThread;
        this.user= user;
        this.amount= amount;
    }
    @Override
    public void run() {
        bankAccountReentrantLockThread.withdraw(user,amount);
    }
}
