package Hw8_22000132_NguyenDuyVu.Bai5;

public class SubtreeOfAnotherTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return subRoot == null;
        }
        if (isSameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    public static void main(String[] args) {
        SubtreeOfAnotherTree solution = new SubtreeOfAnotherTree();
        TreeNode root = solution.new TreeNode(3);
        root.left = solution.new TreeNode(4);
        root.right = solution.new TreeNode(5);
        root.left.left = solution.new TreeNode(1);
        root.left.right = solution.new TreeNode(2);

        TreeNode subRoot = solution.new TreeNode(4);
        subRoot.left = solution.new TreeNode(1);
        subRoot.right = solution.new TreeNode(2);

        System.out.println(solution.isSubtree(root, subRoot));
    }
}
