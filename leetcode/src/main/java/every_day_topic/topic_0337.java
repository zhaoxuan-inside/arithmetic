package every_day_topic;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class topic_0337 {

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

    Map<TreeNode, Integer> incluteSelf = new HashMap<>();
    Map<TreeNode, Integer> notSelf = new HashMap<>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(incluteSelf.getOrDefault(root, 0),
                notSelf.getOrDefault(root, 0));
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        incluteSelf.put(node,
                node.val +
                        notSelf.getOrDefault(node.left, 0) +
                        notSelf.getOrDefault(node.right, 0));
        notSelf.put(node,
                Math.max(incluteSelf.getOrDefault(node.left, 0),
                        notSelf.getOrDefault(node.left, 0))
                        +
                        Math.max(incluteSelf.getOrDefault(node.right, 0),
                                notSelf.getOrDefault(node.right, 0)));
    }
}
