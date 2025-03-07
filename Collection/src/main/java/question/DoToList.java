package question;

import java.util.LinkedList;

public class DoToList {
    public static void main(String[] args) {
        LinkedList task = new LinkedList();
        task.add("fixing bug");
        task.add("rasing PR");

        task.add("PR merged");
        task.add(1,"meeting schudle");
        System.out.println("task to print "+task);
    }
}
