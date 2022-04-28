package 力扣;


import java.util.*;

/**
 * @author peiqi
 * @date 2022/4/1513:35
 */
public class 复杂链表的复制 {
    /**
     * map实现
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        HashMap<Node, Node> map = new HashMap<>();
        for(Node cur = head; cur!=null; cur = cur.next){
            map.put(cur,new Node(cur.val));
        }
        for(Node cur = head; cur!=null; cur = cur.next){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
        }

        return map.get(head);
    }

    /**
     * 原地修改
     * @param head
     * @return
     */
    public Node copyRandomList1(Node head) {
        if (head == null) {
            return head;
        }
//将拷贝节点放到原节点后面，例如1->2->3这样的链表就变成了这样1->1'->2->2'->3->3'
        for (Node node = head, copy; node != null; node = node.next.next) {
            copy = new Node(node.val);
            copy.next = node.next;
            node.next = copy;
        }
        //把拷贝节点的random指针安排上
        for (Node node = head; node != null; node = node.next.next) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
        }
        //分离拷贝节点和原节点，变成1->2->3和1'->2'->3'两个链表，后者就是答案
        Node newHead = head.next;
        for (Node node = head, temp; node != null && node.next != null;) {
            temp = node.next;
            node.next = temp.next;
            node = temp;
        }

        return newHead;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
