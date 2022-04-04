package 力扣;

public class 岛屿最大面积 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int a = dfs(grid, r, c);
                    res = Math.max(res, a);
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid,int i,int j){
        if(check(grid,i,j)){
            return 0;
        }
        //标记遍历过
        grid[i][j] = 2;
        //访问上下左右节点将数量加起来
        return 1
        +dfs(grid,i-1,j)
        +dfs(grid,i+1,j)
        +dfs(grid,i,j-1)
        +dfs(grid,i,j+1);
    }
    public boolean check(int[][] grid,int i,int j){
        return i < 0 || i >= grid.length ||
                j < 0 || j >= grid[0].length || grid[i][j] != 1;
    }
}
