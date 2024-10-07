package thirdweek;

import java.util.*;

import util.TreeNode;

public class BinaryTreeLevelOrder {

    

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return null;
        }

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> remainingNodes = new ArrayDeque<>();
        TreeNode currentNode;
        List<Integer> aux;

        remainingNodes.add(root);
        while (!remainingNodes.isEmpty()) {
            int levelSize = remainingNodes.size();
            aux = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                currentNode = remainingNodes.poll();
                aux.add(currentNode.val);

                if (currentNode.left != null) {
                    remainingNodes.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    remainingNodes.add(currentNode.right);
                }
            }
            ans.add(aux);
        }

        return ans;
    }
}
