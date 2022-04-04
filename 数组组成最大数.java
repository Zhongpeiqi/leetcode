package 力扣;

import java.math.BigInteger;
import java.util.*;

/**
 * @author peiqi
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/168:26
 */
public class 数组组成最大数{
    public static void main(String[] args) {
//        //接受输入的数组
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
//        String substring = str.substring(1, str.length() - 1);
//        String[] arr = substring.split(",");
//        int[] nums = new int[arr.length];
//        //转换为数字数组
//        for (int i = 0; i < arr.length; i++) {
//            nums[i] = Integer.parseInt(arr[i]);
//        }
//        System.out.println(largestNumber(nums));
    }
    public static String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for(int i = 0;i<nums.length;i++){
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder sb = new StringBuilder();
        for(String a:s){
            sb.append(a);
        }
        String res = sb.toString();
        if(res.charAt(0)=='0') {
            res = "0";
        }

        return res;
    }
}

