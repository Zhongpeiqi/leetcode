package 力扣;

/**
 * @author peiqi
 * @date 2022/4/1914:13
 */
public class 环形链表II {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            //快指针
            fast = fast.next.next;
            //慢指针
            slow = slow.next;
            //相遇结束循环
            if (fast == slow) {
                break;
            }
        }
        //快节点回到原点，慢指针在原地，一步一步走,直到相遇
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
