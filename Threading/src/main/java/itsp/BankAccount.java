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


