package Hw3_22000132_NguyenDuyVu;

public class Bai9 {

    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class CountNode {
        public int count(Node head, int key){
            Node current = head;
            int count = 0;
            while (current != null){
                if (current.data == key){
                    count++;
                }
                current = current.next;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Bai9 bai9 = new Bai9();
        Node head = bai9.new Node(1);
        head.next = bai9.new Node(2);
        head.next.next = bai9.new Node(1);
        head.next.next.next = bai9.new Node(2);
        head.next.next.next.next = bai9.new Node(1);
        head.next.next.next.next.next = bai9.new Node(3);
        head.next.next.next.next.next.next = bai9.new Node(1);
        CountNode countNode = bai9.new CountNode();
        System.out.println(countNode.count(head, 1));
    }
}
