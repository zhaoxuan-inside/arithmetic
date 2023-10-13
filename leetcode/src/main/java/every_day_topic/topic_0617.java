package every_day_topic;

import data_structure.TreeNode;

@SuppressWarnings("unused")
public class topic_0617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        merge(root1, root2);
        return root1;
    }

    private void merge(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return;
        }

        root1.val = root1.val + root2.val;

        if (root2.left != null) {
            if (root1.left == null) {
                root1.left = new TreeNode(0);
            }
            merge(root1.left, root2.left);
        }

        if (root2.right != null) {
            if (root1.right == null) {
                root1.right = new TreeNode(0);
            }
            merge(root1.right, root2.right);
        }
    }
}
