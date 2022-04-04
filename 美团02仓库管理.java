package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/3/3019:57
 */
public class 美团02仓库管理 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] weight = new int[n];
        int[] number = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            number[i] = in.nextInt();
        }

        int[] preSum = new int[n+1];
        //前缀和
        for (int i = 0; i < n; i++) {
            preSum[i+1] = weight[i]+preSum[i];
        }
        int [] ans = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(n+1);

        TreeMap<Integer,Integer> sumMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int pos = number[i];
            int left  = set.lower(pos);
            int right = set.higher(pos);
            set.add(pos);

            int sum = preSum[right-1]-preSum[left];
            Integer count = sumMap.get(sum);
            if(count!=null){
                if(count==1){
                    sumMap.remove(sum);
                }else{
                    sumMap.put(sum-1, count);
                }
            }
            int leftSum = preSum[pos - 1] - preSum[left];
            int rightSum = preSum[right - 1] - preSum[pos];
            sumMap.put(leftSum, sumMap.getOrDefault(leftSum, 0) + 1);
            sumMap.put(rightSum, sumMap.getOrDefault(rightSum, 0) + 1);
            ans[i] = sumMap.lastKey();
        }

        for (int an : ans) {
            System.out.println(an);
        }
    }

    private static int getMax(int[] weight) {
        int max = 0;
        int n = weight.length;
        int index= 0;
        while (index<n){
            //此处已经没有物品
            while (index<n&&weight[index]==0){
                index++;
            }
            if(index<n&&weight[index]!=0){
                int sum = 0;
                while (index<n&&weight[index]!=0){
                    sum+=weight[index];
                    index++;
                }
                max = Math.max(sum,max);
            }
        }
        return max;
    }
}
