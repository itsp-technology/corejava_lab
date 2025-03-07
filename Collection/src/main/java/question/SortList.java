package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortList {
    public static void main(String[] args) {
        List<String> std = new ArrayList<>(Arrays.asList("vivek","ram","amit","ashu","sahil","ambika"));
        Collections.sort(std);
        System.out.println("sorted stucent "+std);
    }
}

//sorted stucent [ambika, amit, ashu, ram, sahil, vivek]
