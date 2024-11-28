public class Node {
    int nodeId;
    int data;
    Node left;
    Node right;

    public Node(int nodeId, int data) {
        this.nodeId = nodeId;
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void insertData(int newData) {
        if (newData < this.data) {
            if (this.left == null) {
                this.left = new Node(nodeId + 1, newData);
            } else {
                this.left.insertData(newData);
            }
        } else {
            if (this.right == null) {
                this.right = new Node(nodeId + 1, newData);
            } else {
                this.right.insertData(newData);
            }
        }
    }

    public String dump() {
        StringBuilder sb = new StringBuilder();
        dumpHelper(this, 0, sb);
        return sb.toString();
    }

    private void dumpHelper(Node node, int depth, StringBuilder sb) {
        if (node == null) return;
        for (int i = 0; i < depth; i++) {
            sb.append("\t");
        }
        sb.append("Node ID: ").append(node.nodeId)
          .append(", Data: ").append(node.data)
          .append("\n");
        dumpHelper(node.left, depth + 1, sb);
        dumpHelper(node.right, depth + 1, sb);
    }
}

