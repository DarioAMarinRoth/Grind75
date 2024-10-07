package tests;

import util.TreeNode;

public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(TreeNode.Height(root.left) + TreeNode.Height(root.right));

    }
}
