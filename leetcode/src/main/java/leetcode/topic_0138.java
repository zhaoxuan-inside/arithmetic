package leetcode;

import java.util.HashMap;
import java.util.Map;

public class topic_0138 {
    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();
        Node ans = new Node(0);
        Node last = ans;
        Node idx = head;
        while (idx != null) {
            Node newNode = new Node(idx.val);
            last.next = newNode;
            nodeMap.put(idx, newNode);
            last = last.next;
            idx = idx.next;
        }
        idx = head;
        Node newIdx = ans.next;
        while (idx != null) {
            newIdx.random = nodeMap.get(idx.random);
            idx = idx.next;
            newIdx = newIdx.next;
        }
        return ans.next;
    }
}

