package 力扣;

/**
 * @author peiqi
 * @date 2022/3/3011:25
 */
public class 乐园站位 {
    public int orchestraLayout(int num, int xPos, int yPos) {
        //一共几圈
        int total = (num+1)/2;
        //第几圈
        int level = Math.min(Math.min(yPos,xPos),Math.min( num - xPos - 1, num - yPos - 1))+1;
        //总面积
        long allArea = (long) num *num;
        long area = (long) Math.pow((num-2*(level-1)),2);
        //求差+1得到当前圈左上角
        long index = (allArea-area)%9+1;
        int right = num-level;
        int left = level-1;

        if(xPos==left){
            //上边界
            index+=yPos-left;
        }else if (yPos==right){
            //右边界
            index+=right-left;
            index+=xPos-left;
        }else if(xPos==right){
            //在 __ 上
            index+= 2L *(right-left);
            index+=right-yPos;
        }else {
            //在 |  上
            index+= 3L *(right-left);
            index+=right-xPos;
        }
        return (int)(index%9==0?9:index%9);
    }
}
