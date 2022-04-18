package 力扣;

/**
 * @author peiqi
 * @date 2022/4/1710:08
 */
public class 剑指Offer53 {
    /**
     * 对于有序的数组都要考虑二分法
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }
}
