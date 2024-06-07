package leetcode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class topic_0095 {
    public static List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public static List<TreeNode> generateTrees(int start, int end) {
        if (start > end) {
            return null;
        }

        List<TreeNode> rootes = new ArrayList<>();
        for (int idx = start; idx <= end; idx++) {
            List<TreeNode> rights = generateTrees(idx + 1, end);
            List<TreeNode> lefts = generateTrees(start, idx - 1);
            if (rights == null && lefts == null) {
                rootes.add(new TreeNode(idx));
                continue;
            }

            if (lefts == null) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(idx);
                    root.right = right;
                    rootes.add(root);
                }
                continue;
            }

            if (rights == null) {
                for (TreeNode left : lefts) {
                    TreeNode root = new TreeNode(idx);
                    root.left = left;
                    rootes.add(root);
                }
                continue;
            }

            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(idx);
                    root.left = left;
                    root.right = right;
                    rootes.add(root);
                }
            }
        }

        return rootes;
    }

}
