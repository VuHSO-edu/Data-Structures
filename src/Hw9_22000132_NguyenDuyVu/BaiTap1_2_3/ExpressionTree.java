package Hw9_22000132_NguyenDuyVu.BaiTap1_2_3;

import Hw9_22000132_NguyenDuyVu.BaiTap1_2_3.LinkedBinaryTree.Node;
public class ExpressionTree<E> extends LinkedBinaryTree<E, Node<E>> {

    public void preorderPrint(Node<E> p) {
        if (p == null) return;
        System.out.print(p.getElement() + " ");
        preorderPrint(p.getLeft());
        preorderPrint(p.getRight());
    }

    public void postorderPrint(Node<E> p) {
        if (p == null) return;
        postorderPrint(p.getLeft());
        postorderPrint(p.getRight());
        System.out.print(p.getElement() + " ");
    }

    public void inorderPrint(Node<E> p) {
        if (p == null) return;
        inorderPrint(p.getLeft());
        System.out.print(p.getElement() + " ");
        inorderPrint(p.getRight());
    }

    public int evaluate(Node<String> p) {
        if (p == null) return 0;
        if (p.getLeft() == null && p.getRight() == null) return Integer.parseInt(p.getElement());

        int leftVal = evaluate(p.getLeft());
        int rightVal = evaluate(p.getRight());

        switch (p.getElement()) {
            case "+":
                return leftVal + rightVal;
            case "-":
                return leftVal - rightVal;
            case "*":
                return leftVal * rightVal;
            case "/":
                return leftVal / rightVal;
        }
        return 0;
    }
}