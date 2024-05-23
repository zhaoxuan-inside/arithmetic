package leetcode;

public class topic_0106 {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode head = buildTree(postorder, 0, postorder.length, inorder, 0, inorder.length);
        return head;
    }

    public static TreeNode buildTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd) {
        if (postStart > postEnd || postEnd <= 0) return null;
        TreeNode root = new TreeNode(postorder[postEnd - 1]);
        int inIdx = inStart;
        for (int idx = inStart; idx < inEnd; idx++) {
            if (inorder[idx] == root.val) {
                inIdx = idx;
                break;
            }
        }
        int leftLen = inIdx - inStart;
        int rightLen = inEnd - inIdx - 1;
        if (leftLen > 0) {
            root.left = buildTree(postorder, postStart, postStart + leftLen, inorder, inStart, inIdx);
        } else {
            root.left = null;
        }
        if (rightLen > 0) {
            root.right = buildTree(postorder, postStart + leftLen, postEnd - 1, inorder, inIdx + 1, inEnd);
        } else {
            root.right = null;
        }
        return root;
    }
}
