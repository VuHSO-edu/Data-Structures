import Hw9_22000132_NguyenDuyVu.BaiTap1_2_3.ExpressionTree;
import Hw9_22000132_NguyenDuyVu.BaiTap1_2_3.LinkedBinaryTree.Node;
public class BinaryTreeTest {
    public static void main(String[] args) {
        ExpressionTree<String> tree = new ExpressionTree<>();
        Node<String> root = tree.addRoot("*");
        Node<String> left = tree.addLeft(root, "+");
        Node<String> right = tree.addRight(root, "-");
        tree.addLeft(left, "/");
        tree.addRight(left, "2");
        tree.addLeft(right, "7");
        tree.addRight(right, "4");

        System.out.println("Prefix:");
        tree.preorderPrint(root);
        System.out.println("\nInfix:");
        tree.inorderPrint(root);
        System.out.println("\nPostfix:");
        tree.postorderPrint(root);
    }
}