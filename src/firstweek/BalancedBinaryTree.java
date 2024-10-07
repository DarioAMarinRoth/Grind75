package firstweek;

import util.TreeNode;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;


        if (Math.abs(getHeight(left) - getHeight(right)) > 1) {
            return false;
        } else {
            return isBalanced(left) && isBalanced(right);
        }
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}
