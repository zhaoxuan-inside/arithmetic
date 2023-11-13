package leetcode;

import data_structure.TreeNode;

@SuppressWarnings("unused")
public class topic_0897 {

    private static TreeNode index;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode result = new TreeNode();
        index = result;

        mid(root);
        return result.right;
    }

    private void mid(TreeNode root) {
        if (root == null) {
            return;
        }

        mid(root.left);
        index.right = root;
        index = index.right;
        index.left = null;
        mid(root.right);

    }
}
