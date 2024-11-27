package Hw9_22000132_NguyenDuyVu.LuyenTap1;

class BinarySearchTree {
    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    BinarySearchTree() {
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

    void inorder(StringBuilder result) {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    public static String binaryTree(int[] a) {
        BinarySearchTree tree = new BinarySearchTree();
        for (int num : a) {
            tree.insert(num);
        }
        StringBuilder result = new StringBuilder();
        tree.inorder(result);
        return result.toString();
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 4};
        System.out.println(binaryTree(a));
    }

}

