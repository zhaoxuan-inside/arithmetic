package every_day_topic;

@SuppressWarnings("unused")
public class topic_0654 {
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

    private int[] numsArray;

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        numsArray = nums;
        return buildTreeByArray(0, nums.length - 1);
    }

    private TreeNode buildTreeByArray(int start, int end) {
        if (start >= end) {
            return new TreeNode(numsArray[start]);
        }

        int maxIndex = findMaxIndex(start, end);
        TreeNode root = new TreeNode(numsArray[maxIndex]);

        root.left = maxIndex <= start ? null : buildTreeByArray(start, maxIndex - 1);
        root.right = maxIndex >= end ? null : buildTreeByArray(maxIndex + 1, end);

        return root;

    }

    private int findMaxIndex(int start, int end) {
        int max = numsArray[start];
        int maxIndex = start;

        for (int index = start + 1; index <= end; index++) {
            if (numsArray[index] > max) {
                max = numsArray[index];
                maxIndex = index;
            }
        }

        return maxIndex;

    }
}
