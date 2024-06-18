package leetcode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class topic_0099 {

    private class Peek {
        public TreeNode min;
        public TreeNode max;
    }

    public static void recoverTree(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        recover(root, nodes);

        if (nodes.size() <= 1) {
            return;
        }

        boolean flag = true;
        while (flag) {
            flag = false;
            for (int idx = 0; idx < nodes.size() - 1; idx++) {
                if (nodes.get(idx).val > nodes.get(idx + 1).val) {
                    int tmp = nodes.get(idx).val;
                    nodes.get(idx).val = nodes.get(idx + 1).val;
                    nodes.get(idx + 1).val = tmp;
                    flag = true;
                }
            }
        }
        return;
    }

    public static void recover(TreeNode root, List<TreeNode> nodes) {
        if (root == null) {
            return;
        }
        recover(root.left, nodes);
        nodes.add(root);
        recover(root.right, nodes);

    }

    public void faster(TreeNode root) {
        TreeNode x = null, y = null, pred = null, predecessor;

        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;

                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    if (pred != null && root.val < pred.val) {
                        y = root;
                        x = x == null ? pred : x;
                    }
                    pred = root;
                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                if (pred != null && root.val < pred.val) {
                    y = root;
                    x = x == null ? pred : x;
                }
                pred = root;
                root = root.right;
            }
        }
        swap(x, y);
    }

    public void swap(TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }

}
