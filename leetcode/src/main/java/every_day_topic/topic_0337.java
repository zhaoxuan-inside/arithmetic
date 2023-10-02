package every_day_topic;

import data_structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class topic_0337 {

    Map<TreeNode, Integer> includeSelf = new HashMap<>();
    Map<TreeNode, Integer> notSelf = new HashMap<>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(includeSelf.getOrDefault(root, 0),
                notSelf.getOrDefault(root, 0));
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        includeSelf.put(node,
                node.val +
                        notSelf.getOrDefault(node.left, 0) +
                        notSelf.getOrDefault(node.right, 0));
        notSelf.put(node,
                Math.max(includeSelf.getOrDefault(node.left, 0),
                        notSelf.getOrDefault(node.left, 0))
                        +
                        Math.max(includeSelf.getOrDefault(node.right, 0),
                                notSelf.getOrDefault(node.right, 0)));
    }
}
