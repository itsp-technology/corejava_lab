package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReveseList {
    public static void main(String[] args) {
        List<String> std = new ArrayList<>(Arrays.asList("vivek","ram","amit","ashu","sahil","ambika"));
        Collections.reverse(std);
        System.out.println("sorted stucent "+std);
    }
    //orted stucent [ambika, sahil, ashu, amit, ram, vivek]
}
