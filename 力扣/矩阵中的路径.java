package 力扣;

/**
 * @author peiqi
 * @date 2022/4/289:22
 */
public class 矩阵中的路径 {
    public boolean exist(char[][] board, String word) {
        if(board==null||board[0]==null||board.length==0||board[0].length==0||word==null||(" ").equals(word)){
            return false;
        }
        //记录是否访问过
        boolean[][] visited = new boolean[board.length][board[0].length];
        char[] chs = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==chs[0]){
                    if(dfs(board,i,j,visited,chs,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, boolean[][] visited, char[] chs, int index) {
        if(index==chs.length){
            return true;
        }
        if(i<0||j<0||i==board.length||j==board[0].length||visited[i][j]||board[i][j]!=chs[index]){
            return false;
        }
        visited[i][j] = true;
        //相邻的格子
        boolean res = dfs(board,i+1,j,visited,chs,index+1)
                ||dfs(board,i-1,j,visited,chs,index+1)
                ||dfs(board,i,j+1,visited,chs,index+1)
                ||dfs(board,i,j-1,visited,chs,index+1);
        visited[i][j] = false;
        return res;
    }
}
