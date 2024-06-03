package leetcode;

import java.util.ArrayList;
import java.util.List;

public class topic_0116 {

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) return null;
        List<Node> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            List<Node> curr = new ArrayList<>();
            for (int idx = 0; idx < list.size(); idx++) {
                Node node = list.get(idx);
                if (idx < list.size() - 1) {
                    node.next = list.get(idx + 1);
                }
                if (node.left != null) {
                    curr.add(node.left);
                }
                if (node.right != null) {
                    curr.add(node.right);
                }
            }
            list.clear();
            list.addAll(curr);
        }
        return root;
    }

}
