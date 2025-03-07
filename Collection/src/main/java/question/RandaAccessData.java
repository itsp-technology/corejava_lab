package question;

import java.util.ArrayList;

public class RandaAccessData {


    public static void main(String[] args) {
        ArrayList<Integer> id = new ArrayList<>();

        id.add(11);
        id.add(22);
        id.add(33);
        id.add(33);
        ArrayList list = new ArrayList<>();
        list.add("vivek");
        list.add(111);
        list.add(1.2);

        System.out.println("type safe :: "+id.get(2));
        System.out.println("with type safe :: "+list.get(0));

    }
}
