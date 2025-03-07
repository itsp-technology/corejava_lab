package org.coll;

import java.util.HashMap;
import java.util.Map;

public class MapUseCase {

    public static void main(String[] args) {
        Map<Integer,String> emp = new HashMap<>();
        emp.put(101,"vivek");
        emp.put(102,"Raja");
        System.out.println("employee get by id "+emp.get(102));
    }
}
