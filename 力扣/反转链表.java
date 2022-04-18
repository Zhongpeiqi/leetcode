package 力扣;

/**
 * @author peiqi
 * @date 2022/4/1513:31
 */
public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        //前一个节点
        ListNode pre = null;
        //当前节点
        ListNode cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
