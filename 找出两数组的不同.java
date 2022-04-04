package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/3/2710:30
 */
public class 找出两数组的不同 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> lists = new ArrayList<>();
        if(nums1==null||nums2==null){
            return lists;
        }
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        for (Integer integer : set1) {
            if(!set2.contains(integer)){
                arr1.add(integer);
            }
        }

        for (Integer integer : set2) {
            if(!set1.contains(integer)){
                arr2.add(integer);
            }
        }


        lists.add(arr1);
        lists.add(arr2);
        return lists;
    }
}
