package 力扣;

/**
 * @author peiqi
 * @date 2022/4/1115:13
 */

/**
 * 给你一个整数数组 arr 。
 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 * <p>
 * a 和 b 定义如下：
 * <p>
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 注意：^ 表示 按位异或 操作。
 * <p>
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 */
public class 形成两个异或相等数组的三元组数目 {
    /**
     * 由a==b可知arr[i]^arr[i+1]^……^arr[j]^……arr[k]的结果为0
     * 所以只需找到一些连续的元素，他们的亦或结果为0即可
     */
    public int countTriplets(int[] arr) {
        //所有可能的组合
        int total = 0;
        int length = arr.length;
        //判断数组从i到j的元素异或结果是否是0
        for (int i = 0; i < length - 1; i++) {
            int temp = arr[i];
            for (int j = i + 1; j < length; j++) {
                temp ^= arr[j];
                //如果数组从i到j的异或结果是0，那么他们
                //可能的组合就是j-i
                if (temp == 0) {
                    total += (j - i);
                }
            }
        }
        return total;
    }
}
