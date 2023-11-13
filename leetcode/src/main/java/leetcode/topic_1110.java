package leetcode;

import data_structure.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class topic_1110 {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        List<TreeNode> result = new ArrayList<>();

        Set<Integer> toDelete = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        if (!toDelete.contains(root.val)) {
            result.add(root);
        }

        while (!queue.isEmpty()) {

            TreeNode curr = queue.poll();

            if (curr.left != null)
                queue.offer(curr.left);

            if (curr.right != null)
                queue.offer(curr.right);

            if (toDelete.contains(curr.val)) {
                if (curr.right != null && !toDelete.contains(curr.right.val))
                    result.add(curr.right);
                if (curr.left != null && !toDelete.contains(curr.left.val))
                    result.add(curr.left);
            }

            if (curr.right != null && toDelete.contains(curr.right.val))
                curr.right = null;
            if (curr.left != null && toDelete.contains(curr.left.val))
                curr.left = null;
        }

        return result;

    }

}
