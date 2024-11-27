import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SimpleBST<Key extends Comparable<Key>> implements SimplebTreeInterface<Key> {

    class Node {
        Key data;
        Node left, right;

        public Node(Key key) {
            this.data = key;
        }
    }

    private Node root = null;
    int n = 0;

    @Override
    public void insert(Key key) {
        Node newNode  = new Node(key);
        if (root == null) {
            root = newNode;

        } else {
            Node current = root;
            Node parent = null;
            while (true) {
                parent = current;
                if (key.compareTo(current.data) < 0) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
        n++;
    }

    @Override
    public Key search(Key key) {
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.data);
            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                return current.data;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public Iterator<Key> iterator() {
        List<Key> keys = new ArrayList<>();
        inOrderTraversal(root, keys);
        return keys.iterator();
    }

    private void inOrderTraversal(Node node, List<Key> keys) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, keys);
        keys.add(node.data);
        inOrderTraversal(node.right, keys);
    }
    public void postTraverse() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    public void preTraverse() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void inTraverse() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }


    public static void main(String[] args) {
        SimpleBST<Integer> bst = new SimpleBST<>();
        int[] data = {5,6,7,1,2,3,8,6,9,0};
        for (int i : data) {
            bst.insert(i);
        }

        System.out.println("All elements in tree:");
        System.out.println("All elements in tree:");
        int[] t = new int[data.length];
        int id = 0;
        for (int d: bst) {
            t[id] = d;
            id++;
        }


        Arrays.sort(t);
        for (int d: t) {
            System.out.print(d + " ");
        }

        System.out.println("");
        System.out.println("Size of tree: " + bst.size());

        System.out.println("Search key = 4> " + bst.search(4));
        System.out.println("Search key = 6> " + bst.search(6));

        System.out.println("Pre-order traversal:");
        bst.preTraverse();
        System.out.println("Post-order traversal:");
        bst.postTraverse();
        System.out.println("In-order traversal:");
        bst.inTraverse();

    }
}
