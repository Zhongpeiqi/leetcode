package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/4/215:05
 */
public class 合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode list : lists) {
            if(list!=null){
                queue.add(list);
            }
        }

        while (!queue.isEmpty()){
            p.next = queue.poll();
            p = p.next;
            if(p.next!=null){
                queue.add(p.next);
            }
        }

        return dummy.next;
    }
}