package 力扣;

/**
 * @author peiqi
 * @date 2022/4/289:53
 */
public class 机器人的运动范围 {
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        //标记是否访问过
        visited = new boolean[m][n];
        //0,0开始
        return dfs(0, 0, m, n, k);
    }

    private int dfs(int x, int y, int m, int n, int k) {
        if(!check(x,y,m,n,k)){
            return 0;
        }
        visited[x][y] = true;
        //左上角开始
        return 1+dfs(x+1,y,m,n,k)+dfs(x,y+1,m,n,k);
    }

    /**
     * 检查坐标是否满足要求
     */
    private boolean check(int x, int y, int m, int n, int k) {
        if(x>=m||y>=n||visited[x][y]||(sum(x)+sum(y))>k){
            return false;
        }
        return true;
    }

    /**
     * 求数位之和
     * @param n
     * @return
     */
    private int sum(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
