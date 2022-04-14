package 力扣;

/**
 * @author peiqi
 * @date 2022/4/1415:51
 */
public class 包含min函数的栈 {
    private Node node;

    /**
     * initialize your data structure here.
     */
    public 包含min函数的栈() {
    }

    public void push(int x) {
        if (node == null) {
            node = new Node(x, x);
        } else {
            node = new Node(x, Math.min(x, node.min), node);
        }
    }

    public void pop() {
        node = node.next;
    }

    public int top() {
        return node.val;
    }

    public int min() {
        return node.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
