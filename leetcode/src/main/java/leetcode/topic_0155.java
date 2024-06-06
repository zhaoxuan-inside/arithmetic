package leetcode;

public class topic_0155 {
    class Node<Integer> {
        int val;
        Node<Integer> orderNext;
        Node<Integer> orderPre;
        Node<Integer> stackNext;
        Node<Integer> stackPre;

        public Node(int val) {
            this.val = val;
        }
    }

    class MinStack {

        private final Node<Integer> root;
        private Node<Integer> top;
        private final Node<Integer> orderRoot;

        public MinStack() {
            root = new Node<>(-1);
            top = root;
            orderRoot = root;
        }

        public void push(int val) {
            Node<Integer> curr = new Node<>(val);

            top.stackNext = curr;
            curr.stackPre = top;
            top = curr;

            Node<Integer> idx = orderRoot;
            while (idx.orderNext != null && idx.orderNext.val < val) {
                idx = idx.orderNext;
            }
            curr.orderNext = idx.orderNext;
            idx.orderNext = curr;
            if (curr.orderNext != null) {
                curr.orderNext.orderPre = curr;
            }
            curr.orderPre = idx;
        }

        public void pop() {
            Node<Integer> node = top;
            top = top.stackPre;
            top.stackNext = null;
            node.orderPre.orderNext = node.orderNext;
            if (node.orderNext != null) {
                node.orderNext.orderPre = node.orderPre;
            }
        }

        public int top() {
            return top.val;
        }

        public int getMin() {
            if (orderRoot.orderNext != null) {
                return orderRoot.orderNext.val;
            }
            return 0;
        }
    }
}