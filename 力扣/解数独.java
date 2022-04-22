package 力扣;

/**
 * @author peiqi
 * @date 2022/4/2221:27
 */
public class 解数独 {
    public void solveSudoku(char[][] board) {
        // 三个布尔数组 表明 行, 列, 还有 3*3 的方格的数字是否被使用过
        boolean[][] rowUsed = new boolean[9][10];
        boolean[][] colUsed = new boolean[9][10];
        boolean[][][] boxUsed = new boolean[3][3][10];
        for(int row = 0;row<board.length;row++){
            for(int col = 0;col<board[0].length;col++){
                int num = board[row][col]-'0';
                if(num<=9&&num>=1){
                    //第row行的num被使用
                    rowUsed[row][num] = true;
                    //第col列的num被使用
                    colUsed[col][num] = true;
                    boxUsed[row/3][col/3][num] = true;
                }
            }
        }
        brack(board,rowUsed,colUsed,boxUsed,0,0);
    }

    private boolean brack(char[][] board, boolean[][] rowUsed, boolean[][] colUsed, boolean[][][] boxUsed, int row, int col) {
        if(col==board[0].length){
            col = 0;
            row++;
            if(row==board.length){
                return true;
            }
        }
        if(board[row][col]=='.'){
            for (int num = 1; num <=9 ; num++) {
                boolean canUsed = !(rowUsed[row][num] || colUsed[col][num] || boxUsed[row/3][col/3][num]);
                if(canUsed){
                    rowUsed[row][num] = true;
                    colUsed[col][num] = true;
                    boxUsed[row/3][col/3][num] = true;

                    board[row][col] = (char)('0' + num);
                    if(brack(board, rowUsed, colUsed, boxUsed, row, col + 1)){
                        return true;
                    }
                    board[row][col] = '.';

                    rowUsed[row][num] = false;
                    colUsed[col][num] = false;
                    boxUsed[row/3][col/3][num] = false;
                }
            }
        }else{
            return brack(board,rowUsed,colUsed,boxUsed,row,col+1);
        }
        return false;
    }
}
