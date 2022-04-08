package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/3/2311:36
 */
public class 化学公式解析 {
    private static int i = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(countOfAtoms(str));
    }
    public static String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        // 字典序排序
        stack.push(new TreeMap<>());
        char[] chars = formula.toCharArray();
        while (i<chars.length){
            //入栈
            if(chars[i]=='('){
                i++;
                stack.push(new HashMap<>());
            }else if(chars[i]==')'){
                //出栈
                i++;
                //获取原子数量
                int count = getCount(chars);
                // 将出栈的hashmap * 原子数量，累加到外面层
                stack.pop().forEach((name, subCount) -> stack.peek().put(name, count * subCount + stack.peek().getOrDefault(name, 0)));
            }else {
                String name = getName(chars);
                int count = getCount(chars);
                stack.peek().put(name,stack.peek().getOrDefault(name,0)+count);
            }
        }
        StringBuilder sb = new StringBuilder();
        stack.peek().forEach((name, count) -> {
            sb.append(name);
            sb.append(count);
        });

        return sb.toString();
    }

    private static String getName(char[] chars) {
        int sid = i++;
        while (i<chars.length){
            if(chars[i]<'a'){
                break;
            }
            i++;
        }

        return new String(chars,sid,i-sid);
    }

    private static int getCount(char[] chars) {
        int count = 0;
        while (i<chars.length){
            if(chars[i]<'0'||chars[i]>'9'){
                break;
            }
            count = count*10+chars[i]-'0';
            i++;
        }

        return Math.max(1,count);
    }
}
