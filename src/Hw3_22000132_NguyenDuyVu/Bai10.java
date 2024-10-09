package Hw3_22000132_NguyenDuyVu;

public class Bai10 {
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class LinkList{
        public void printReverseList(Node head){
            if (head == null){
                return;
            }

            printReverseList(head.next);
            System.out.print(head.data + " ");
        }

    }

    public static void main(String[] args) {
        Bai10 bai10 = new Bai10();
        Node head = bai10.new Node(1);
        head.next = bai10.new Node(2);
        head.next.next = bai10.new Node(3);
        head.next.next.next = bai10.new Node(4);
        LinkList linkList = bai10.new LinkList();
        linkList.printReverseList(head);
    }
}
