package firstweek;

import util.TreeNode;



public class LowestCommonAncestor {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while (true) {
            if (root.val == p.val || root.val == q.val) {
                return root;
            }

            if (has(root.left, p.val) && has(root.right, q.val)) {
                return root;
            }

            if (has(root.right, p.val) && has(root.left, q.val)) {
                return root;
            }

            if (has(root.left, p.val) && has(root.left, q.val)) {
                root = root.left;
                continue;
            }

            if (has(root.right, p.val) && has(root.right, q.val)) {
                root = root.right;
            }
        }
    }

    private boolean has(TreeNode node, int value) {

        if (node == null) {
            return false;
        }

        if (node.val == value) {
            return true;
        } else {
            return has(node.left, value) || has(node.right, value);
        }
    }
}
