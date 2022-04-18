package 力扣;

/**
 * @author peiqi
 * @date 2022/4/1815:15
 */
public class 旋转数组的最小数字 {
    /**
     * 二分查找
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length-1;
        while (left<right){
            int mid = (left+right)/2;
            //还在左半部分有序数组中
            if(numbers[mid]>numbers[right]){
                left = mid+1;
            }else if(numbers[mid]<numbers[right]){
                //右边是右半部分有序数组
                right = mid;
            }else{
                //相等去重
                right--;
            }
        }
        return numbers[left];
    }
}
