package 力扣;

/**
 * @author peiqi
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/2423:17
 */
public class 链表中倒数第k个节点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        while (fast!=null){
            fast = fast.next;
            if(k==0){
                head = head.next;
            }else{
                k--;
            }
        }
        return head;
    }
}
