package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class topic_0133 {

    private static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> map = new HashMap<>();

        dfs(map, node, visited);
        for (Node key : map.keySet()) {
            Node newNode = map.get(key);
            for (Node neighbor : key.neighbors) {
                if (map.get(neighbor) != null) {
                    newNode.neighbors.add(map.get(neighbor));
                }
            }
        }
        return map.get(node);
    }

    private void dfs(Map<Node, Node> map, Node root, Set<Node> visited) {
        if (root == null) {
            return;
        }
        visited.add(root);
        map.put(root, new Node(root.val));
        for (Node neighbor : root.neighbors) {
            if (!visited.contains(neighbor)) {
                dfs(map, neighbor, visited);
            }
        }
    }

    private Map<Node, Node> nodeMap = new HashMap<>();

    public Node better(Node node) {
        if (node == null) {
            return null;
        }

        if (nodeMap.containsKey(node)) {
            return nodeMap.get(node);
        }

        Node root = new Node(node.val);
        nodeMap.put(node, root);
        for (Node neighbor : node.neighbors) {
            root.neighbors.add(better(neighbor));
        }
        return root;
    }

    public static void main(String[] args) {
        topic_0133 test = new topic_0133();
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);

        one.neighbors.add(two);
        two.neighbors.add(one);
        one.neighbors.add(three);
        three.neighbors.add(one);
        two.neighbors.add(four);
        four.neighbors.add(two);
        three.neighbors.add(four);
        four.neighbors.add(three);
        Node node = test.better(one);
        System.out.println(node.val);
    }
}
