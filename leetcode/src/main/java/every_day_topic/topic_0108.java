package every_day_topic;

@SuppressWarnings("unused")
public class topic_0108 {

    public static class TreeNode {
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

    private int[] ans;

    public TreeNode sortedArrayToBST(int[] nums) {
        ans = nums;
        return buildTree(0, nums.length - 1);
    }

    private TreeNode buildTree(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(ans[mid]);
        root.left = buildTree(start, mid - 1);
        root.right = buildTree(mid + 1, end);

        return root;
    }

}
