package org.coll;

import java.util.HashSet;
import java.util.Set;

public class SetUseCase {
    public static void main(String[] args) {
        Set<String> user = new HashSet();
        user.add("vivek");
        user.add("ram");
        user.add("ram");
        System.out.println("user "+user);
    }
}
