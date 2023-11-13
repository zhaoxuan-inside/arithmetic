package leetcode;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class topic_0257 {

    private final List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        path(root, new StringBuilder());
        return ans;
    }

    private void path(TreeNode root, StringBuilder path) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            path.append(root.val);
            ans.add(path.toString());
            return;
        }

        path.append(root.val).append("->");
        if (root.left != null) {
            path(root.left, new StringBuilder().append(path));
        }
        if (root.right != null) {
            path(root.right, new StringBuilder().append(path));
        }
    }
}
