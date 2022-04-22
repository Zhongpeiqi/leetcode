package 力扣;

/**
 * @author peiqi
 * @date 2022/4/1915:01
 */
public class 只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int ero = 0;
        /**
         * 相同的数亦或为0
         * 任何数于0异或为任何数 0 ^ n => n
         */
        for (int num : nums) {
            ero ^=num;
        }
        return ero;
    }
}
