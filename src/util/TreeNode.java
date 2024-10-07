package util;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    private static boolean has(TreeNode node, int value) {

        if (node == null) {
            return false;
        }

        if (node.val == value) {
            return true;
        } else {
            return has(node.left, value) || has(node.right, value);
        }
    }

    public static int Height(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        return 1 + Math.max(Height(root.left), Height(root.right));
    }
}
