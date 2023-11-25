package leetcode;

import data_structure.TreeNode;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class topic_1457 {

    private static final Set<Integer> SET = new HashSet<>();
    private Integer ans = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        scanTree(root);
        return ans;
    }

    private void scanTree(TreeNode root) {
        int val = root.val;
        if (SET.contains(val)) {
            SET.remove(val);
        } else {
            SET.add(val);
        }

        if (root.left == null && root.right == null) {
            if (SET.isEmpty() || SET.size() == 1) {
                ans++;
            }

            if (SET.contains(val)) {
                SET.remove(val);
            } else {
                SET.add(val);
            }

            return;
        }

        if (root.left != null) {
            scanTree(root.left);
        }

        if (root.right != null) {
            scanTree(root.right);
        }

        if (SET.contains(val)) {
            SET.remove(val);
        } else {
            SET.add(val);
        }

    }
}
