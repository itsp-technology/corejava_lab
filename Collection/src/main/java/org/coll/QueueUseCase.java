package org.coll;

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
