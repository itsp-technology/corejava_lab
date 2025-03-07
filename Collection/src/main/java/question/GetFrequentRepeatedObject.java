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
