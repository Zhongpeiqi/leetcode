package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/3/3017:27
 */
public class 美团01小美的用户名 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < T; i++) {
            String str = scanner.nextLine();
            if (isOk(str)) {
                System.out.println("Accept");
            } else {
                System.out.println("Wrong");
            }
        }
    }

    public static boolean isOk(String str) {
        if (str.length() < 2) {
            return false;
        }
        char firstChar = str.charAt(0);
        if (!isBig(firstChar) && !isSmall(firstChar)) {
            return false;
        }
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!isBig(c) && !isSmall(c) && !isNum(c)) {
                return false;
            }
            if (isNum(c)) {
                flag = true;
            }
        }
        if (flag == false) {
            return false;
        }
        return true;
    }
    public static boolean isBig(char c) {
        return ('A' <= c) && (c <= 'Z');
    }
    public static boolean isSmall(char c) {
        return ('a' <= c) && (c <= 'z');
    }
    public static boolean isNum(char c) {
        return ('0' <= c) && (c <= '9');
    }
}
