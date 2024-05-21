package leetcode;

public class topic_0114 {
    public void flatten(TreeNode root) {
        postorder(root);
    }

    public void postorder(TreeNode root) {
        if (root == null) return;
        if (root.left != null) postorder(root.left);
        if (root.right != null) postorder(root.right);

        if (root.left != null && root.right != null) {
            TreeNode temp = root.left;
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = root.right;
            root.right = root.left;
            root.left = null;
            return;
        }

        if (root.right == null) {
            root.right = root.left;
            root.left = null;
        }
    }
}
