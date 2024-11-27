import Hw9_22000132_NguyenDuyVu.BaiTap1_2_3.ExpressionTree;
import Hw9_22000132_NguyenDuyVu.BaiTap1_2_3.LinkedBinaryTree;

import java.util.Stack;

public class ExpressionTreeBuilder {
    public static ExpressionTree<String> buildTree(String[] tokens) {
        Stack<LinkedBinaryTree.Node<String>> stack = new Stack<>();
        ExpressionTree<String> tree = new ExpressionTree<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                LinkedBinaryTree.Node<String> right = stack.pop();
                LinkedBinaryTree.Node<String> left = stack.pop();
                LinkedBinaryTree.Node<String> node = new LinkedBinaryTree.Node<>(token, null, left, right);
                left.setParent(node);
                right.setParent(node);
                stack.push(node);
            } else {
                stack.push(new LinkedBinaryTree.Node<>(token, null, null, null));
            }
        }

        tree.addRoot(stack.pop().getElement());
        return tree;
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
}