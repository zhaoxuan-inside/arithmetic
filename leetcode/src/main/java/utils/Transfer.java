package utils;


import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Transfer {

    public static TreeNode transfer(Integer[] arrays) {

        TreeNode root = new TreeNode(arrays[0]);
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        int included = 1;
        int start = 1;
        while (included < arrays.length) {
            included *= 2;
            while (start < Math.min(arrays.length, included)) {
                TreeNode parent = queue.poll();
                if (parent == null) {
                    start += 2;
                    queue.add(null);
                    queue.add(null);
                    continue;
                }
                Integer left = arrays[start++];
                if (null != left) {
                    parent.left = new TreeNode(left);
                    queue.add(parent.left);
                }
                Integer right = arrays[start++];
                if (null != right) {
                    parent.right = new TreeNode(right);
                    queue.add(parent.right);
                }
            }

        }


        return root;

    }

    public static List<Integer> transfer(TreeNode root) {

        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        Queue<TreeNode> empty = new LinkedBlockingQueue<>();
        queue.add(root);

        List<Integer> ans = new ArrayList<>();

        Boolean allNull = queue.peek() == null || queue.peek().val == Integer.MAX_VALUE;
        while (!allNull) {
            allNull = true;
            Queue<TreeNode> layerQueue = queue;
            queue = empty;
            while (!layerQueue.isEmpty()) {
                TreeNode poll = layerQueue.poll();
                if (poll.val == Integer.MAX_VALUE) {
                    queue.add(new TreeNode(Integer.MAX_VALUE));
                    queue.add(new TreeNode(Integer.MAX_VALUE));
                    ans.add(null);
                    continue;
                }
                ans.add(poll.val);
                if (poll.left == null) {
                    queue.add(new TreeNode(Integer.MAX_VALUE));
                } else {
                    queue.add(poll.left);
                    allNull = false;
                }
                if (poll.right == null) {
                    queue.add(new TreeNode(Integer.MAX_VALUE));
                } else {
                    queue.add(poll.right);
                    allNull = false;
                }
            }
            empty = layerQueue;
        }

        int nonNullIdx = 0;
        for (int idx = 0; idx < ans.size(); idx++) {
            if (ans.get(idx) != null) {
                nonNullIdx = idx;
            }
        }

        ans = ans.subList(0, nonNullIdx + 1);

        return ans;
    }

}
