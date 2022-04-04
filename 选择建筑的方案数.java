package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/223:19
 */
public class 选择建筑的方案数 {

//    public long numberOfWays(String s) {
//        char[] chars = s.toCharArray();
//        List<Character> list = new ArrayList<>();
//        return backtrack(0, list, chars);
//    }
//
//    int count = 0;
//
//    private int backtrack(int index, List<Character> list, char[] chars) {
//        if (list.size() == 3) {
//            count++;
//        }
//        for (int i = index; i < chars.length; i++) {
//            if (check(list, chars[i])) {
//                list.add(chars[i]);
//                backtrack(i + 1, list, chars);
//                list.remove(list.size() - 1);
//            }
//        }
//        return count;
//    }
//
//    private boolean check(List<Character> list, char c) {
//        if (list.size() == 0) {
//            return true;
//        }
//        Character pre = list.get(list.size() - 1);
//        if (pre == c) {
//            return false;
//        }
//        return true;
//    }

    public long numberOfWays(String s) {
        long ans = 0,n0 = 0,n1 = 0,n10 = 0,n01 = 0;
        for (char c : s.toCharArray()) {
            if(c=='1'){
                n01 += n0;
                n1++;
                ans+=n10;
            }else{
                n10+=n1;
                n0++;
                ans+=n01;
            }
        }
        return ans;
    }
}
