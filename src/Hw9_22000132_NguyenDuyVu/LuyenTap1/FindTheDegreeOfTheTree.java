package Hw9_22000132_NguyenDuyVu.LuyenTap1;

import java.util.Scanner;

public class FindTheDegreeOfTheTree {

    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    FindTheDegreeOfTheTree() {
        root = null;
    }

    void insert(int data) {
        root = insertRec(root, data);
    }

    Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);
        return root;
    }

    int height() {
        return heightRec(root);
    }

    int heightRec(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightRec(root.left);
        int rightHeight = heightRec(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        FindTheDegreeOfTheTree tree = new FindTheDegreeOfTheTree();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            tree.insert(num);
        }
        System.out.println(tree.height());
    }
}
