package leetcode;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class topic_0111 {

    public int batter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0) {
            return right + 1;
        } else if (right == 0) {
            return left + 1;
        } else {
            return Math.min(left, right) + 1;
        }
    }

    public int minDepth(TreeNode root) {
        List<TreeNode> stack = new ArrayList<>();

        if (root != null) {
            stack.add(root);
        }

        int layout = 1;
        while (!stack.isEmpty()) {
            List<TreeNode> tmp = new ArrayList<>(stack);
            stack.clear();

            for (TreeNode treeNode : tmp) {
                if (treeNode.left == null && treeNode.right == null) {
                    return layout;
                }
                if (treeNode.left != null) {
                    stack.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    stack.add(treeNode.right);
                }
            }

            layout++;

        }

        return 0;
    }

}
