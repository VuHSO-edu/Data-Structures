package Hw5_22000132_NguyenDuyVu.BaiTap1;

public class PriorityQueueTest {

    private static void testIntegerPriorityQueue(PriorityQueueInterface<Integer, Integer> pq) {
        System.out.println("Testing Integer PriorityQueue: " + pq.getClass().getSimpleName());
        pq.insert(5, 5);
        pq.insert(1, 1);
        pq.insert(3, 3);
        pq.insert(4, 4);
        pq.insert(2, 2);

        while (!pq.isEmpty()) {
            System.out.println("Min: " + pq.min().getKey());
            pq.removeMin();
        }
    }

    private static void testCustomObjectPriorityQueue(PriorityQueueInterface<Integer, String> pq) {
        System.out.println("Testing Custom Object PriorityQueue: " + pq.getClass().getSimpleName());
        pq.insert(300, "Item A");
        pq.insert(100, "Item B");
        pq.insert(200, "Item C");
        pq.insert(400, "Item D");
        pq.insert(150, "Item E");

        while (!pq.isEmpty()) {
            Entry<Integer, String> min = pq.min();
            System.out.println("Min: " + min.getKey() + " - " + min.getValue());
            pq.removeMin();
        }
    }

    public static void main(String[] args) {
        testIntegerPriorityQueue(new UnsortedArrayPriorityQueue<>());
        testIntegerPriorityQueue(new UnsortedLinkedPriorityQueue<>());

        testCustomObjectPriorityQueue(new UnsortedArrayPriorityQueue<>());
        testCustomObjectPriorityQueue(new UnsortedLinkedPriorityQueue<>());
    }

}
