package every_day_topic;

import data_structure.BTreeNode;

import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class topic_1110 {

    public List<BTreeNode> delNodes(BTreeNode root, int[] to_delete) {

        List<BTreeNode> result = new ArrayList<>();

        Set<Integer> toDelete = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());

        Queue<BTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        if (!toDelete.contains(root.val)) {
            result.add(root);
        }

        while (!queue.isEmpty()) {

            BTreeNode curr = queue.poll();

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
