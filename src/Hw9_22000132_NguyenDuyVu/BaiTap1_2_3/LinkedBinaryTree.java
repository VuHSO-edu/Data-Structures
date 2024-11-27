package Hw9_22000132_NguyenDuyVu.BaiTap1_2_3;

public class LinkedBinaryTree<E, T> implements BinaryTreeInterface<T> {

    public static class Node<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setElement(E e) {
            element = e;
        }

        public void setParent(Node<E> parentNode) {
            parent = parentNode;
        }

        public void setLeft(Node<E> leftChild) {
            left = leftChild;
        }

        public void setRight(Node<E> rightChild) {
            right = rightChild;
        }
    }

    private Node<E> root = null;
    private int size = 0;

    public LinkedBinaryTree() {
    }

    public Node<E> addRoot(E element) {
        if (root != null) throw new IllegalStateException("Tree already has a root");
        root = new Node<>(element, null, null, null);
        size = 1;
        return root;
    }

    public Node<E> addLeft(Node<E> p, E element) {
        if (p.getLeft() != null) throw new IllegalArgumentException("Node already has a left child");
        Node<E> child = new Node<>(element, p, null, null);
        p.setLeft(child);
        size++;
        return child;
    }

    public Node<E> addRight(Node<E> p, E element) {
        if (p.getRight() != null) throw new IllegalArgumentException("Node already has a right child");
        Node<E> child = new Node<>(element, p, null, null);
        p.setRight(child);
        size++;
        return child;
    }

    public void set(Node<E> p, E element) {
        p.setElement(element);
    }

    @Override
    public T root() {
        return (T) root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int numChildren(T p) {
        Node<E> node = (Node<E>) p;
        int count = 0;
        if (node.getLeft() != null) count++;
        if (node.getRight() != null) count++;
        return count;
    }

    @Override
    public T parent(T p) {
        Node<E> node = (Node<E>) p;
        return (T) node.getParent();
    }

    @Override
    public T left(T p) {
        Node<E> node = (Node<E>) p;
        return (T) node.getLeft();
    }

    @Override
    public T right(T p) {
        Node<E> node = (Node<E>) p;
        return (T) node.getRight();
    }

    @Override
    public T sibling(T p) {
        Node<E> node = (Node<E>) p;
        Node<E> parent = node.getParent();
        if (parent == null) return null;
        if (node == parent.getLeft()) return (T) parent.getRight();
        else return (T) parent.getLeft();
    }
}