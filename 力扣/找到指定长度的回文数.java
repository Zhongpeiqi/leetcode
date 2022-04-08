package 力扣;


/**
 * @author peiqi
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/2710:52
 */
public class 找到指定长度的回文数 {
    public static long[] kthPalindrome(int[] queries, int intLength) {
        int n = queries.length;
        long min = (long)Math.pow(10, (intLength - 2 + 1)/2);
        long[] ans = new long[n];

        for (int i = 0; i < n; i++) {
            int q = queries[i];
            //长度为 intLength 的回文数个数 = 9*Math.pow(10,(intLength-1)/2)
            if((long)q > (long) 9*Math.pow(10,(intLength-1)/2)){
                ans[i] = -1;
                continue;
            }
            //判断第几个数的大小
            long cur = q-1+min;
            String str = String.valueOf(cur);
            //偶数直接将前半段反转拼接
            if(intLength%2==0){
                StringBuilder sb = new StringBuilder(str);
                str +=sb.reverse().toString();
            } else{
                StringBuilder sb = new StringBuilder(str);
                //反过来截取
                str+= sb.reverse().substring(1);
            }
            ans[i] = Long.parseLong(str);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,12};

    }
}
