package 力扣;

/**
 * @author peiqi
 * @date 2022/4/2515:29
 */
public class 两个链表的第一个公共节点 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null||headB==null){
            return null;
        }
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1!=node2){
            node1 = node1==null ? headB : node1.next;
            node2 = node2==null ? headA : node2.next;
        }
        return node1;
    }
}
