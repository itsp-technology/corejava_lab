package itsp;

import java.util.ArrayList;
import java.util.List;

public class ProduceCunsome {
    int CAPACITRY = 5;
    List<Integer> list = new ArrayList<>();
    public void produce()throws InterruptedException{
        int value = 0 ;
        while (true){
            synchronized (this){
                if (list.size()==CAPACITRY)
                    wait();

                System.out.println("Produce :: "+value);
                list.add(value++);
                notify();
                Thread.sleep(1000);
            }
        }
    }

    public void cunsome()throws  InterruptedException{
        while (true){
            synchronized (this){
                if (list.isEmpty())
                    wait();

                int val = list.remove(0);
                System.out.println("Consumed :: "+val);
                notify();
                Thread.sleep(1000);
            }
        }
    }

    public static void main(String[] args) {
        ProduceCunsome pc= new ProduceCunsome();
        Thread thProduce = new Thread(()->{
            try{
                pc.produce();
            }catch (InterruptedException ie){}
        });

        Thread thConsume = new Thread(()->{
            try{
                pc.cunsome();
            }catch (InterruptedException ie){}
        });
        thProduce.start();
        thConsume.start();
    }
}
