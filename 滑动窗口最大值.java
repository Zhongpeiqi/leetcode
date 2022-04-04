package 力扣;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @author peiqi
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/2315:00
 */
public class 滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            if (i >= k && nums[i - k] == deque.peekFirst()) {
                deque.removeFirst();
            }
            if (i >= k - 1) {
                res[i - k + 1] = deque.peekFirst();
            }
        }
        return res;
    }
}
