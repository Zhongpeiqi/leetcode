package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/4/1415:41
 */
public class 两个栈实现队列 {
    LinkedList<Integer> A, B;

    public 两个栈实现队列() {
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        A.addLast(value);
    }

    public int deleteHead() {
        if (!B.isEmpty()) {
            return B.removeLast();
        }
        if (A.isEmpty()) {
            return -1;
        }
        while (!A.isEmpty()) {
            B.addLast(A.removeLast());
        }
        return B.removeLast();
    }
}
