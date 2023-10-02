package every_day_topic;

import data_structure.TreeNode;

@SuppressWarnings("unused")
public class topic_0129 {

    private int ans = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int currNum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            currNum = currNum * 10 + root.val;
            ans += currNum;
            return;
        }

        currNum = currNum * 10 + root.val;
        dfs(root.left, currNum);
        dfs(root.right, currNum);
    }

}
