package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/4/2414:57
 */
public class 最长不含重复字符的子字符串 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        HashSet<Character> set = new HashSet<>();
        for (int r = 0,l = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            while (set.contains(c)){
                set.remove(l++);
            }
            set.add(c);
            res = Math.max(res,r-l+1);
        }
        return res;
    }
}
