package every_day_topic;

import data_structure.TreeNode;

@SuppressWarnings("unused")
public class topic_0988 {

    String ans = "~";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        sb.append((char) ('a' + root.val));

        if (root.left == null && root.right == null) {
            sb.reverse();
            String currStr = sb.toString();

            if (currStr.compareTo(ans) < 0) {
                ans = currStr;
            }
            return;
        }

        dfs(root.left, new StringBuilder().append(sb));
        dfs(root.right, new StringBuilder().append(sb));

        sb.deleteCharAt(sb.length() - 1);

    }
}
