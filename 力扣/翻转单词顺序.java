package 力扣;

/**
 * @author peiqi
 * @date 2022/4/2715:34
 */
public class 翻转单词顺序 {
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length-1; i >=0 ; i--) {
            if("".equals(strs[i])){
                continue;
            }
            sb.append(strs[i]+" ");
        }
        return sb.toString().trim();
    }
}
