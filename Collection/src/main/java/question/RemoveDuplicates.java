package question;

import javax.crypto.spec.PSource;
import java.util.*;
public class RemoveDuplicates {
  public static void main(String[] args) {
        List<String> user = new ArrayList<>(Arrays.asList("vivek","ram","vivek","java"));
        Set<String> uniqeUser = new LinkedHashSet<>(user);
        System.out.println("Unique User List "+uniqeUser);
    }
}
