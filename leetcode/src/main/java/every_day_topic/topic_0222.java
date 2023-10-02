package every_day_topic;

import data_structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

@SuppressWarnings("unused")
public class topic_0222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int ans = 1;

        while (!queue.isEmpty()) {
            Queue<TreeNode> tmp = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    tmp.offer(poll.left);
                    ans++;
                }
                if (poll.right != null) {
                    tmp.offer(poll.right);
                    ans++;
                }
            }
            queue.addAll(tmp);
        }

        return ans;
    }
}
