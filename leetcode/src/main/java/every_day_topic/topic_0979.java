package every_day_topic;

import data_structure.TreeNode;

@SuppressWarnings("unused")
public class topic_0979 {

    private int ans = 0;

    public int distributeCoins(TreeNode root) {
        lrd(root);
        return ans;
    }

    public int lrd(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left != null) {
            root.val += lrd(root.left);
        }

        if (root.right != null) {
            root.val += lrd(root.right);
        }

        ans += Math.abs(root.val - 1);

        return root.val - 1;

    }

}
