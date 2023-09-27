package every_day_topic;

@SuppressWarnings("unused")
public class topic_0404 {

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

    public int sumOfLeftLeaves(TreeNode root) {
        return isLeaf(root) ? 0 : accumulateLeftLeaf(root);
    }

    private int accumulateLeftLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = 0;

        if (root.left != null) {
            ans += isLeaf(root.left) ? root.left.val : accumulateLeftLeaf(root.left);
        }

        if (root.right != null) {
            ans += isLeaf(root.right) ? 0 : accumulateLeftLeaf(root.right);
        }

        return ans;
    }

    private boolean isLeaf(TreeNode node) {
        return (node.left == null && node.right == null);
    }

}
