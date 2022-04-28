package 力扣;

/**
 * @author peiqi
 * @date 2022/4/289:16
 */
public class x的平方根 {
    public int mySqrt(int x) {
        if(x==1){
            return 1;
        }
        int min = 0;
        int max = x;
        while (max-min>1){
            int mid = (max+min)/2;
            if(x/mid<mid){
                max = mid;
            }else{
                min = mid;
            }
        }
        return min;
    }
}
