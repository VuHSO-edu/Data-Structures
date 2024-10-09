package Hw3_22000132_NguyenDuyVu;

public class Bai8 {
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class findNthFromLastNode{
        public int findNthFromLast(Node head , int n){
            int len = 0;
            int i;
            Node temp = head;
            while (temp != null){
                temp = temp.next;
                len++;
            }

            if (len < n) return -1;

            temp = head;
            for (i = 1; i < len - n + 1; i++){
                temp = temp.next;
            }
            return temp.data;
        }
    }

    public static void main(String[] args) {
        Bai8 bai8 = new Bai8();
        Node head = bai8.new Node(10);
        head.next = bai8.new Node(5);
        head.next.next = bai8.new Node(100);
        head.next.next.next = bai8.new Node(5);

        findNthFromLastNode obj = bai8.new findNthFromLastNode();
        System.out.println(obj.findNthFromLast(head, 5));

    }

}
