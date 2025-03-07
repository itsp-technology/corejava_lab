## Main Interfaces in Java Collections Framework
| Interface | Description	 | Eample Implementation           |
|-----------|--------------|---------------------------------|
| List      | Ordered collection (allows duplicates)        | `ArrayList, LinkedList, Vector, Stack`        |
| Set       | Unordered collection (does not allow duplicates)      | `HashSet, LinkedHashSet, TreeSet` |
| Queue      | Used to hold elements before processing (FIFO, LIFO)     | `PriorityQueue, Deque, ArrayDeque`        |
| Map       |Stores key-value pairs (unique keys)     | HashMap, LinkedHashMap, TreeMap, Hashtable          |

## 2. Real-Time Use Cases of Java Collections

**2.1. List Interface (ArrayList) - Dynamic Data Storage**

Use Case: E-commerce Shopping Cart

In an online shopping application, a shopping cart holds multiple products. Since users can add or remove products dynamically, we use ArrayList because it provides fast read operations.
```package org.coll;

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
```
---

## 2.2. Set Interface (HashSet) - Removing Duplicates
**Use Case: Maintaining Unique Usernames in a System**

When users register in an application, we need to ensure that usernames are unique. A HashSet is used because it does not allow duplicate values.
```package org.coll;

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
```
output 
```user [vivek, ram]```

---
## 2.3. Queue Interface (PriorityQueue) - Task Scheduling
**Use Case: Job Scheduling System (Print Queue)**

n a printer queue, documents with higher priority should be printed first. We use PriorityQueue to store tasks based on priority.
```package org.coll;

import java.util.PriorityQueue;

public class QueueUseCase {

    public static void main(String[] args) {
        PriorityQueue<String> printJobs = new PriorityQueue<>();
        printJobs.add("Job3 - Low Priority");
        printJobs.add("Job1 - High Priority");
        printJobs.add("Job2 - Medium Priority");

        while(!printJobs.isEmpty()){
            System.out.println("processing "+printJobs.poll());
        }
    }
}
```
output
```
processing Job1 - High Priority
processing Job2 - Medium Priority
processing Job3 - Low Priority
```
---

## 2.4. Map Interface (HashMap) - Fast Data Lookup

**Use Case: Storing Employee ID and Names**

A HashMap helps store and retrieve employee details quickly.
```package org.coll;

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
```
---