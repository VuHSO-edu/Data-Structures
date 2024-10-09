package Hw3_22000132_NguyenDuyVu;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Bai7 {
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class CountNode {
        public int countNode(Node head) {
            int count = 0;
            Node cur = head;
            while (cur != null) {
                count++;
                cur = cur.next;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Bai7 bai7 = new Bai7();
        Node head = bai7.new Node(1);
        head.next = bai7.new Node(3);
        head.next.next = bai7.new Node(1);
        head.next.next.next = bai7.new Node(2);
        head.next.next.next.next = bai7.new Node(1);
        CountNode countNode = bai7.new CountNode();
        System.out.println(countNode.countNode(head));

    }

}
