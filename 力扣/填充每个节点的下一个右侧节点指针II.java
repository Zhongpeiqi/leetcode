package 力扣;

/**
 * @author peiqi
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/2323:52
 */
public class 填充每个节点的下一个右侧节点指针II {
    public Node1 connect(Node1 root) {
        if(root==null){
            return root;
        }
        Node1 cur = root;
        while (cur!=null){
            Node1 dummy = new Node1(0);
            //下一层节点的前一个结点
            Node1 pre = dummy;
            while (cur!=null){
                if(cur.left!=null){
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if(cur.right!=null){
                    pre.next = cur.right;
                    pre = pre.next;
                }
                //继续访问这一行的下一个节点
                cur = cur.next;
            }
            cur = dummy.next;
        }
        return root;
    }

}
class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;
    public Node1 next;

    public Node1() {}

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
