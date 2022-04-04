package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/3/299:21
 */
public class 颠倒字符串中的单词 {
    public String reverseWords(String s) {
        //去除首位以及中间多余的空格
        StringBuilder sb = removeSpace(s);
        //反转整个字符串
        reverseString(sb,0,sb.length()-1);
        //反转字符串中的单词
        reverseEachWord(sb);
        return sb.toString();
    }

    /**
     * 删除多余的空格
     * @param s
     * @return
     */
    public static StringBuilder removeSpace(String s){
        int start = 0;
        int end = s.length()-1;
        char space = ' ';
        //去除首位空格
        while (s.charAt(start)==space){
            start++;
        }
        while (s.charAt(end)==space){
            end--;
        }

        StringBuilder sb = new StringBuilder();
        //去除中间空格
        while (start<=end){
            char c = s.charAt(start);
            if(c!=space||sb.charAt(sb.length()-1)!=space){
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    /**
     * 反转字符串指定区间[start, end]的字符
     */
    public static void reverseString(StringBuilder sb, int start, int end) {
        while (start<=end){
            char temp = sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,temp);
            start++;
            end--;
        }
    }

    /**
     * 反转每一个单词
     * @param sb
     */
    private static void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int length = sb.length();
        while (start < length) {
            while (end < length && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(removeSpace(s));
    }
}
