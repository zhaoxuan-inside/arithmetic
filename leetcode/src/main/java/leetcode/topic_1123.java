package leetcode;

public class topic_1123 {

    public static TreeNode lcaDeepestLeaves(TreeNode root) {

        TreeNode depth = depth(root);
        return find(depth, root);
    }

    private static TreeNode depth(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode depth = new TreeNode(0);
        depth.left = depth(root.left);
        depth.right = depth(root.right);

        depth.val = Math.max(depth.left == null ? 0 : depth.left.val, depth.right == null ? 0 : depth.right.val) + 1;

        return depth;

    }

    private static TreeNode find(TreeNode depth, TreeNode root) {

        if (depth.right != null && depth.left != null) {
            if (depth.right.val == depth.left.val) {
                return root;
            }

            if (depth.left.val > depth.right.val) {
                return find(depth.left, root.left);
            }
            return find(depth.right, root.right);
        }

        if (depth.right != null) {
            return find(depth.right, root.right);
        }

        if (depth.left != null) {
            return find(depth.left, root.left);
        }

        return root;

    }

}
