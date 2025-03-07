## 1. Scenario: How do you handle dynamic data storage where random access is required?

**Question:**

You are designing a product catalog system where products are frequently accessed based on index positions. Which List implementation would you use, and why?

**Answer:**

ArrayList is the best choice because it allows fast random access (O(1) time complexity) using an index. It is efficient for reading operations but slower for insertions/deletions in the middle.

```commandline
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

```

output 
```commandline
type safe :: 33
with type safe :: vivek
```

---
## 4. Scenario: How do you maintain insertion order?

**Answer:**

Both ArrayList and LinkedList maintain insertion order. However, ArrayList is preferred for read-heavy operations.

```commandline
package question;

import java.util.ArrayList;

public class InstertionOrder {
    public static void main(String[] args) {
        ArrayList<String> order = new ArrayList<>();
        order.add("order 1");
        order.add("order 2");
        order.add("order 3");
        System.out.println("order processing "+order);
    }
}

```
output
```commandline
order processing [order 1, order 2, order 3]

```

---
## 5. Scenario: How do you remove duplicate elements?
**Question:**

You need to filter out duplicate entries from a list of customer names. How will you do it?

**Answer:**

Convert List to Set, as Set does not allow duplicates.

```commandline
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

```
output 
```commandline
Unique User List [vivek, ram, java]
```
---
## Scenario: How do you sort a list?
**Question:**

You are working on a student management system. How will you sort student names in alphabetical order?

**Answer:**

`Use Collections.sort() to sort List elements.`

```commandline
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

```
---
## Scenario: How do you reverse a list?
**Question:**
You need to display the latest transactions in reverse order. How will you achieve this?

**Answer:**
Use Collections.reverse() to reverse the list.

```package question;

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
```
---
## Scenario: How do you convert a list to an array?
**Question:**
You need to pass a List of email addresses to a legacy system that only accepts arrays. How will you handle it?

**Answer:**
Use toArray() to convert a list to an array.

```package question;

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
```
---
##  Scenario: How do you find the most frequently occurring element?
**Question:**
Given a list of products, find the most frequently bought product.

**Answer:**
Use HashMap to count occurrences.

```commandline
package question;

import java.util.*;

public class GetFrequentRepeatedObject {
    public static void main(String[] args) {
        List<String> user = Arrays.asList("vivek","ram","vivek","java","vivek","vivek","ram","vivek");
        Map<String,Integer> frequencyMap = new HashMap<>();
        for(String p : user){
            frequencyMap.put(p, frequencyMap.getOrDefault(p, 0) + 1);
        }

        String mostFrequent = Collections.max(frequencyMap.entrySet(),Map.Entry.comparingByKey()).getKey();
        System.out.println("Most Frequent user " + mostFrequent);

    }
}

```