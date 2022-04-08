package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/4/317:09
 */
public class 完成旅途最少时间 {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long left = 0;
        //最大完成旅途的时间
        long right = (long) time[0] *totalTrips;
        while (left<right){
            long mid = left + (right - left) /2;
            //记录当前完成旅程的车
            long trip = 0;
            for (int i : time) {
                if(mid<i){
                    break;
                }
                //当前时间能完成的趟数
                trip+=mid/i;
            }
            if(trip>=totalTrips){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}
