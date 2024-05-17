package leetcode;

import java.util.ArrayList;
import java.util.List;

public class topic_0107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        List<TreeNode> currLayer = new ArrayList<>();
        currLayer.add(root);
        while (!currLayer.isEmpty()) {
            List<TreeNode> tmp = new ArrayList<>();
            for (TreeNode node : currLayer) {
                if (node.left != null) {
                    tmp.add(node.left);
                }
                if (node.right != null) {
                    tmp.add(node.right);
                }
            }
            List<Integer> integers = new ArrayList<>();
            for (TreeNode treeNode : currLayer) {
                integers.add(treeNode.val);
            }
            ans.add(0, integers);
            currLayer = tmp;
        }
        return ans;
    }

    public List<List<Integer>> batter(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, root, ans);
        return ans;
    }

    public void dfs(int layer, TreeNode root, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }

        List<Integer> curr = null;
        if (ans.size() <= layer) {
            curr = new ArrayList<>();
            ans.add(0, curr);
        } else {
            curr = ans.get(ans.size() - layer);
        }
        curr.add(root.val);
        if (root.left != null) {
            dfs(layer + 1, root.left, ans);
        }
        if (root.right != null) {
            dfs(layer + 1, root.right, ans);
        }
    }
}
