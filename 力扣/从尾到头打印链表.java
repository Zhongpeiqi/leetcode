package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/4/1513:20
 */
public class 从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        ListNode node = head;
        int len = 0;
        while (node!=null){
            len++;
            node = node.next;
        }
        int[] ans = new int[len];
        node = head;
        for (int i = len-1; i >=0; i--) {
            ans[i] = node.val;
            node = node.next;
        }
        return ans;
    }
}
