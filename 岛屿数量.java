package 力扣;

public class 岛屿数量 {
    public int numIslands(char[][] grid) {
        //遍历岛屿
        int islandNum = 0;
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    islandNum++;
                }
            }
        }
        return islandNum;
    }

    /**
     * dfs遍历岛屿
     * @param grid
     * @param i
     * @param j
     */
    public void dfs(char[][] grid,int i,int j){
        if(!isArea(grid,i,j)){
            return;
        }
        //标记遍历过
        grid[i][j] = 2;
        //访问上下左右节点
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
    public boolean isArea(char[][] grid,int i,int j){
        return i < 0 || i >= grid.length ||
                j < 0 || j >= grid[0].length || grid[i][j] != '1';
    }
}
