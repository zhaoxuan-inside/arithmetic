package leetcode;

import data_structure.TreeNode;

@SuppressWarnings("unused")
public class topic_0222 {
    int i = 0;

    public int countNodes(TreeNode root) {
        if (root == null) {
            return i;
        }
        countNodes(root.left);
        i++;
        countNodes(root.right);
        return i;
    }

}