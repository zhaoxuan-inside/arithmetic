package every_day_topic;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class topic_0113 {

    private final List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        subPathSum(root, targetSum, new ArrayList<>());
        return ans;
    }

    private void subPathSum(TreeNode root, int targetSum, List<Integer> list) {
        if (targetSum <= 0 || root == null) {
            return;
        }

        if (root.right == null && root.left == null) {
            if (root.val == targetSum) {
                list.add(root.val);
                ans.add(list);
            }
            return;
        }

        list.add(root.val);

        subPathSum(root.left, targetSum - root.val, new ArrayList<>(list));
        subPathSum(root.right, targetSum - root.val, new ArrayList<>(list));
    }

}
