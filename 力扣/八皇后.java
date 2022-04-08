package 力扣;

import java.util.*;

// 输入：4
//         输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//         解释: 4 皇后问题存在如下两个不同的解法。
//         [
//         [".Q..", // 解法 1
//          "...Q",
//          "Q...",
//          "..Q."],
//
//         ["..Q.", // 解法 2
//          "Q...",
//          "...Q",
//          ".Q.."]
//         ]

public class 八皇后 {
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        //定义空棋盘
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }

        boolean[] col = new boolean[n];
        // 该方向的x=row-col是固定的
        boolean[] dg = new boolean[n + n];
        // 该方向的x=row+col是固定的
        boolean[] udg = new boolean[n + n];

        dfs(0, n, grid, col, dg, udg);

        return res;
    }

    /**
     * @param height 皇后摆在第几行
     * @param n
     * @param grid
     * @param col
     * @param dg
     * @param udg
     */
    private void dfs(int height, int n, char[][] grid, boolean[] col, boolean[] dg, boolean[] udg) {
        if (height == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new String(grid[i]));
            }
            res.add(list);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (!col[j] && !dg[n - height + j] && !udg[height + j]) {
                //标记
                grid[height][j] = 'Q';
                col[j] = dg[n - height + j] = udg[height + j] = true;
                //下一行
                dfs(height + 1, n, grid, col, dg, udg);
                //回溯
                grid[height][j] = '.';
                col[j] = dg[n - height + j] = udg[height + j] = false;
            }
        }
    }
}
