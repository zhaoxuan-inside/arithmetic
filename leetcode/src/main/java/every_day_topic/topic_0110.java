package every_day_topic;

@SuppressWarnings("unused")
public class topic_0110 {

    public class TreeNode {
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

    public boolean isBalanced(TreeNode root) {
        return doRecur(root) != -1;
    }

    private int doRecur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = doRecur(root.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = doRecur(root.right);
        if (rightDepth == -1) {
            return -1;
        }
        if (Math.abs(leftDepth - rightDepth) < 2) {
            return Math.max(leftDepth, rightDepth) + 1;
        }
        return -1;
    }

}
