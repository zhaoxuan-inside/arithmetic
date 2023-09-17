package every_day_topic;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class topic_0094 {
    private static class TreeNode {
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

    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        mid(root);
        return result;
    }

    private void mid(TreeNode root) {
        if (root == null) {
            return;
        }
        mid(root.left);
        result.add(root.val);
        mid(root.right);
    }
}
