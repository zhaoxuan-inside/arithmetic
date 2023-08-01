package data_structure;

@SuppressWarnings("unused")
public class BTreeNode {
    public int val;
    public BTreeNode left;
    public BTreeNode right;

    public BTreeNode() {
    }

    public BTreeNode(int val) {
        this.val = val;
    }

    public BTreeNode(int val, BTreeNode left, BTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}