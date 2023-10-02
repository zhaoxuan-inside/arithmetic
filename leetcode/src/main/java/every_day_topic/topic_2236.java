package every_day_topic;

import data_structure.TreeNode;

@SuppressWarnings("unused")
public class topic_2236 {

    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }

}