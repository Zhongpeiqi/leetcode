package 力扣;

/**
 * @author peiqi
 * @date 2022/4/1622:50
 */
public class 左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        StringBuilder str = new StringBuilder();
        //先取后面的
        for(int i =n;i<len;i++){
            str.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            str.append(s.charAt(i));
        }
        //取余优化
        StringBuilder res = new StringBuilder();
        for(int i = n; i < n + s.length(); i++) {
            res.append(s.charAt(i % s.length()));
        }

        return str.toString();
    }
    public String reverseLeftWords1(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
