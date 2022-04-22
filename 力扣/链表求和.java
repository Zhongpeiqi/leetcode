package 力扣;

/**
 * @author peiqi
 * @date 2022/4/310:28
 */
public class 链表求和 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        while(l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            pre.next = new ListNode(sum%10);
            pre = pre.next;
            carry = sum/10;

        }
        return head.next;
    }
}
