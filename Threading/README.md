## What is Thread Starvation?

**Scenario:** Low-priority threads waiting for a long time because high-priority threads are continuously executing.
```commandline
class Starvation extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " executing");
    }

    public static void main(String[] args) {
        Starvation t1 = new Starvation();
        Starvation t2 = new Starvation();
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
    }
}

```
**🎯 Solution:**

1. Use Fair Locking with ReentrantLock.
2. Use Thread.yield().

## What is Thread Pool? Why do we need it?

**Scenario:** If you have 1000 tasks to execute, creating 1000 threads will consume memory.
```commandline
package itsp;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for(int i = 0 ; i <= 10 ; i++){
            es.submit(()->{
                System.out.println(Thread.currentThread().getName()+"is Executing");
            });
        }
        es.shutdown();
    }
}
```
**OUT PUT**
```pool-1-thread-1is Executing
pool-1-thread-2is Executing
pool-1-thread-2is Executing
pool-1-thread-4is Executing
pool-1-thread-2is Executing
pool-1-thread-4is Executing
pool-1-thread-1is Executing
pool-1-thread-4is Executing
pool-1-thread-2is Executing
pool-1-thread-3is Executing
pool-1-thread-5is Executing
```
## What is the difference between wait(), notify(), and notifyAll()?

 |method | Description|
 |------|----------------|
  | wait | Pause the thread|
|notify | weakup the one thread|
|notifyAll | weakup all Thread|

**for notify notifyAl and Wait you can use the notifyExample package**

## What is Thread Interruption? How to Stop a Running Thread Gracefully?
**Imagine you are processing 1 lakh records in the background, and the user wants to cancel the process in the middle.**
```commandline
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

```
**Explanation:**
1. Thread.currentThread().isInterrupted() → Checks if the thread is interrupted.
2. interrupt() sends a signal to stop the thread.
3. It will break the loop immediately.
4. If the thread is sleeping, it will throw InterruptedException.

##  What is Thread Livelock? How to Solve It?

```package itsp;

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
        new Thread(() -> {
            try {
                wk1.work(wk1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Thread -2").start();

    }


}
```

**🔑 Output:**
1. The program will never end — Livelock
2. Both threads are continuously giving chance to each other without finishing their task.
---
## How to Use ThreadLocal in Java?
**Scenario:**
Imagine you have multiple threads, and each thread needs its own copy of data like User ID or Session ID.
```class ThreadLocalExample {
    static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 100);

    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
            threadLocal.set(threadLocal.get() + 10);
            System.out.println(Thread.currentThread().getName() + " (After Update): " + threadLocal.get());
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
    }
}
```
---
##   How to Implement Callable + Future for Multi-threading?
**Scenario:))
Imagine fetching user data from the database and doing Email Verification at the same time.

---
## Scenario:
Imagine you are developing a banking system where multiple users are trying to withdraw money from a shared bank account at the same time. You need to ensure that no two users withdraw money simultaneously in a way that could lead to an incorrect balance (i.e., preventing race conditions).

**Question:**
How would you implement a thread-safe bank withdrawal system using Java multi-threading? Write a Java program that ensures thread safety while allowing multiple users to withdraw money concurrently.

**Answer:**
To solve this problem, we use synchronized methods or ReentrantLock to prevent race conditions. Below is the Java implementation using synchronization:
```commandline
package itsp;

public class BankAccount {

    int blance;
    public BankAccount(int blance){
        this.blance=blance;
    }
    public synchronized void withdraw(String user,int amout){
            if(blance >= amout){
                System.out.println(user+" Trying to Withdraw Rs.  "+amout);
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException ie){}
                blance = blance - amout;
                System.out.println("Transetion Success Amount is "+amout);
            }else{
                System.out.println("insuficent Balance");
            }
        System.out.println("Reamining Balance "+blance);
    }

    public static void main(String[] args) {
        BankAccount ba = new BankAccount(3000);
//        BankUser bankUser1 = new BankUser(ba,"vivek",1000);
//        BankUser bankUser2 = new BankUser(ba,"Ram",1000);
//        BankUser bankUser3 = new BankUser(ba,"Raja",1000);
//        Thread th1 = new Thread(bankUser1);
//        Thread th2 = new Thread(bankUser2);
//        Thread th3 = new Thread(bankUser3);
            Thread th1 = new Thread(new BankUser(ba,"vivek",1000));
            Thread th2 = new Thread(new BankUser(ba,"Ram",1000));
            Thread th3 = new Thread(new BankUser(ba,"Raja",300));

        th1.start();
        th2.start();
        th3.start();


    }
}

class BankUser implements  Runnable{

    private BankAccount bankAccount;
    private String user;
    private int amount;

    public BankUser(BankAccount bankAccount,String user, int amount){
        this.bankAccount=bankAccount;
        this.user=user;
        this.amount=amount;
    }
    @Override
    public void run() {
        bankAccount.withdraw(user,amount);
    }
}

```
## Alternative Approach using ReentrantLock:
Instead of using synchronized, we can use ReentrantLock for more flexibility:
```package itsp;

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
```
**Fairness**

Synchronized blocks don’t offer any mechanism of a waiting queue and after the exit of one thread, any thread can take the lock. This could lead to starvation for a thread which is waiting for a very long period of time. To avoid this a Lock should be fair.

Synchronized keyword doesn’t support fairness. Any thread can acquire lock once released and there is no mechanism to provide the preference. On the other hand, we can make a ReentrantLock fair. Fairness property provides lock to longest waiting thread. While creating an instance of ReentrantLock, we can define the fairness property.

---