package leetcode;

@SuppressWarnings("unused")
public class topic_0105 {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode head = buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
        return head;
    }

    public static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
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
            root.left = buildTree(preorder, preStart + 1, preStart + leftLen + 1, inorder, inStart, inIdx);
        } else {
            root.left = null;
        }
        if (rightLen > 0) {
            root.right = buildTree(preorder, preStart + leftLen + 1, preEnd, inorder, inIdx + 1, inEnd);
        } else {
            root.right = null;
        }
        return root;
    }
}
