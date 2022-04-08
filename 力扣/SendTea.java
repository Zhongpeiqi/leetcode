package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/3/2710:02
 */
public class SendTea {
    static int[] teaNum;
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //员工数
        n = scanner.nextInt();
        //工作区数
        m = scanner.nextInt();
        teaNum = new int[m+1];
        //只有一个员工派送
        int max = m;
        for (int i = 1; i <=m ; i++) {
            teaNum[i] = scanner.nextInt();
            max += teaNum[i];
        }
        int min = 0;
        while (min<max){
            int mid = (min+max)/2;
            if(check(mid)){
                max = mid;
            }else{
                min = mid+1;
            }
        }
        System.out.println(min);
    }

    private static boolean check(int time) {
        int[] arr = Arrays.copyOf(teaNum,m+1);
        for (int i = 0,j=m; i < n; i++) {
            //首先减去走路要的时间
            int t = time - j;
            //还能动
            while (t>0){
                //可以解决当前工作区则去服务上一个
                if(t>=arr[j]){
                    t-=arr[j];
                    j--;
                    //服务全部结束
                    if(j==0){
                        return true;
                    }
                }else{
                    arr[j] -= t;
                    t = 0;
                }
            }
        }
        return false;
    }
}
