package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/4/814:00
 */
public class N皇后II {
    Set<Integer> col = new HashSet<>();
    Set<Integer> dg = new HashSet<>();
    Set<Integer> udg = new HashSet<>();
    int res = 0;

    public int totalNQueens(int n) {
        backtrack(0, n);
        return res;
    }

    private void backtrack(int i, int n) {
        if (i == n) {
            res++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (col.contains(j) || udg.contains(i - j) || dg.contains(i + j)) {
                continue;
            }
            col.add(j);
            udg.add(i - j);
            dg.add(i + j);
            backtrack(i + 1, n);
            col.remove(j);
            udg.remove(i - j);
            dg.remove(i + j);
        }
    }
}
