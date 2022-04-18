package 力扣;

/**
 * @author peiqi
 * @date 2022/4/1622:45
 */
public class 替换空格 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(c==' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public String replaceSpace1(String s) {
        return s.replace(" ","%20");
    }

}
