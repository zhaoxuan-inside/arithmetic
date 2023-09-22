package every_day_topic;

@SuppressWarnings("unused")
public class topic_0897 {

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
