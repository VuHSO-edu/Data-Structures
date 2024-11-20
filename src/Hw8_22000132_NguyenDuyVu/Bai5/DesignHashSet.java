package Hw8_22000132_NguyenDuyVu.Bai5;

public class DesignHashSet {

        class Node {
            int key;
            Node next;

            public Node(int key) {
                this.key = key;
            }
        }

        private Node[] table;
        private int capacity;

        public DesignHashSet() {
            capacity = 16;
            table = new Node[capacity];
        }

        private int hash(int key) {
            return key % capacity;
        }

        public void add(int key) {
            int index = hash(key);
            Node newNode = new Node(key);
            if (table[index] == null) {
                table[index] = newNode;
            } else {
                Node current = table[index];
                while (current != null) {
                    if (current.key == key) {
                        return;
                    }
                    if (current.next == null) {
                        current.next = newNode;
                        break;
                    }
                    current = current.next;
                }
            }
        }

        public void remove(int key) {
            int index = hash(key);
            Node current = table[index];
            if (current == null) {
                return;
            }
            if (current.key == key) {
                table[index] = current.next;
                return;
            }
            while (current.next != null) {
                if (current.next.key == key) {
                    current.next = current.next.next;
                    return;
                }
                current = current.next;
            }
        }

        public boolean contains(int key) {
            int index = hash(key);
            Node current = table[index];
            while (current != null) {
                if (current.key == key) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }
}
