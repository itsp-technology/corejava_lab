package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListToArray {
    public static void main(String[] args) {
        List<String> std = new ArrayList<>(Arrays.asList("vivek","ram","amit","ashu","sahil","ambika"));
        String[] stdArray = std.toArray(new String[0]);
        System.out.println("list "+std);
        System.out.println("Array "+Arrays.toString(stdArray));
        System.out.println("potion print "+stdArray[3]);

    }
//    list [vivek, ram, amit, ashu, sahil, ambika]
//    Array [vivek, ram, amit, ashu, sahil, ambika]
//    potion print ashu
}
