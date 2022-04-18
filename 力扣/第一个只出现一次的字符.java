package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/4/1814:57
 */
public class 第一个只出现一次的字符 {
    public char firstUniqChar(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }

        return ' ';
    }

    public char firstUniqChar1(String s) {
        Map<Character, Boolean> dic = new HashMap<>();

        char[] array = s.toCharArray();

        for (char c : array) {
            dic.put(c, !dic.containsKey(c));
        }

        for (char c : array) {
            if (dic.get(c)) {
                return c;
            }
        }

        return ' ';
    }
}
