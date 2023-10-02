package every_day_topic;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class topic_0998 {

    private List<Integer> nums;

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        List<Integer> numsList = buildArray(root);
        numsList.add(val);
        nums = numsList;
        return buildTreeByArray(0, nums.size() - 1);
    }

    private List<Integer> buildArray(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        if (root.left != null) {
            ans.addAll(buildArray(root.left));
        }
        ans.add(root.val);
        if (root.right != null) {
            ans.addAll(buildArray(root.right));
        }
        return ans;
    }

    private TreeNode buildTreeByArray(int start, int end) {
        if (start >= end) {
            return new TreeNode(nums.get(start));
        }
        int maxIndex = findMaxIndex(start, end);
        TreeNode root = new TreeNode(nums.get(maxIndex));
        root.left = maxIndex <= start ? null : buildTreeByArray(start, maxIndex - 1);
        root.right = maxIndex >= end ? null : buildTreeByArray(maxIndex + 1, end);
        return root;
    }

    private int findMaxIndex(int start, int end) {
        int max = nums.get(start);
        int maxIndex = start;
        for (int index = start + 1; index <= end; index++) {
            if (nums.get(index) > max) {
                max = nums.get(index);
                maxIndex = index;
            }
        }
        return maxIndex;
    }

    private static class Batter {

        private static final List<TreeNode> LIST = new ArrayList<>();

        private static class LYQ {
            private void mid(TreeNode root) {
                if (root == null) {
                    return;
                }

                mid(root.left);
                LIST.add(root);
                mid(root.right);
            }

            TreeNode createTree(int left, int right) {
                if (left > right) {
                    return null;
                }

                TreeNode subTreeRoot = LIST.get(left);
                int index = left;

                for (int i = left; i <= right; i++) {
                    if (LIST.get(i).val > subTreeRoot.val) {
                        subTreeRoot = LIST.get(i);
                        index = i;
                    }
                }

                subTreeRoot.left = createTree(left, index - 1);
                subTreeRoot.right = createTree(index + 1, right);

                return subTreeRoot;
            }
        }

        public TreeNode insertIntoMaxTree(TreeNode root, int val) {

            LYQ lyq = new LYQ();
            lyq.mid(root);
            LIST.add(new TreeNode(val));

            return lyq.createTree(0, LIST.size() - 1);
        }
    }

}
