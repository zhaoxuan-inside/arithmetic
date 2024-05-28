package leetcode;

import java.util.ArrayList;
import java.util.List;

public class topic_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderTraversal(root, ans);
        return ans;
    }

    public void inorderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        ans.add(root.val);
        inorderTraversal(root.left, ans);
        inorderTraversal(root.right, ans);
    }
}
