package every_day_topic;

import java.util.Stack;

@SuppressWarnings("unused")
public class topic_0100 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();

        pStack.push(p);
        qStack.push(q);

        while (!pStack.isEmpty() || !qStack.isEmpty()) {
            TreeNode pPop = pStack.pop();
            TreeNode qPop = qStack.pop();

            if (pPop == null && qPop != null) {
                return false;
            }

            if (pPop != null && qPop == null) {
                return false;
            }

            if (pPop == null) {
                continue;
            }

            if (pPop.val != qPop.val) {
                return false;
            }

            pStack.push(pPop.left);
            pStack.push(pPop.right);
            qStack.push(qPop.left);
            qStack.push(qPop.right);
        }
        return true;
    }

}
