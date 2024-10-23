package Hw5_22000132_NguyenDuyVu.BaiTap2;

import Hw5_22000132_NguyenDuyVu.BaiTap1.*;

import java.util.Random;

public class PriorityQueuePerformanceTest {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000, 1000000};
        Random random = new Random();

        for (int n : sizes) {
            System.out.println("Testing with n = " + n);

            // Test UnsortedArrayPriorityQueue
            testPriorityQueuePerformance(new UnsortedArrayPriorityQueue<>(), n, random);

            // Test UnsortedLinkedPriorityQueue
            testPriorityQueuePerformance(new UnsortedLinkedPriorityQueue<>(), n, random);

            // Test SortedArrayPriorityQueue
            testPriorityQueuePerformance(new SortedArrayPriorityQueue<>(), n, random);

            // Test SortedLinkedPriorityQueue
            testPriorityQueuePerformance(new SortedLinkedPriorityQueue<>(), n, random);

            System.out.println();
        }
    }

    private static void testPriorityQueuePerformance(PriorityQueueInterface<Integer, Integer> pq, int n, Random random) {
        long startTime, endTime;

        // Insert elements
        startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            pq.insert(random.nextInt(n), random.nextInt(n));
        }
        endTime = System.currentTimeMillis();
        long insertTime = endTime - startTime;

        // Remove elements
        startTime = System.currentTimeMillis();
        while (!pq.isEmpty()) {
            pq.removeMin();
        }
        endTime = System.currentTimeMillis();
        long removeMinTime = endTime - startTime;

        System.out.println(pq.getClass().getSimpleName() + " - Insert time: " + insertTime + " ms, RemoveMin time: " + removeMinTime + " ms");
    }
}

