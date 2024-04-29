package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("unused")
public class topic_0103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean direct = true;
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> subAns = new ArrayList<>();
            Queue<TreeNode> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                if (direct) {
                    subAns.add(node.val);
                } else {
                    subAns.add(0, node.val);
                }
                if (node.left != null) temp.add(node.left);
                if (node.right != null) temp.add(node.right);
            }
            ans.add(subAns);
            queue.addAll(temp);
            direct = !direct;
        }
        return ans;
    }
}
