package Hw3_22000132_NguyenDuyVu;

public class Bai6 {
    class MyLinkedList {
        private Node top;
        private Node bot;
        private int size;
        class Node {
            int val;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }

        public MyLinkedList() {
            this.top = null;
            this.bot = null;
            this.size = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            Node cur = top;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            Node newNode = new Node(val);
            if (top == null) {
                top = newNode;
                bot = newNode;
            } else {
                newNode.next = top;
                top = newNode;
            }
            size++;
        }

        public void addAtTail(int val) {
            Node newNode = new Node(val);
            if (bot == null) {
                top = newNode;
                bot = newNode;
            } else {
                bot.next = newNode;
                bot = newNode;
            }
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }
            if (index == 0) {
                addAtHead(val);
            } else if (index == size) {
                addAtTail(val);
            } else {
                Node newNode = new Node(val);
                Node cur = top;
                for (int i = 0; i < index - 1; i++) {
                    cur = cur.next;
                }
                newNode.next = cur.next;
                cur.next = newNode;
                size++;
            }
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            if (index == 0) {
                top = top.next;
                size--;
            } else {
                Node cur = top;
                for (int i = 0; i < index - 1; i++) {
                    cur = cur.next;
                }
                cur.next = cur.next.next;
                if (index == size - 1) {
                    bot = cur;
                }
                size--;
            }
        }
    }
}
