package org.coll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ListUseCase {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("car");
        list.add("bike");
        list.add("bag");
        list.remove(0);

        System.out.println(Arrays.asList(list));
    }



}
