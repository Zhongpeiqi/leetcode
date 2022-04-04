package 力扣;

/**
 * @author peiqi
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/222:33
 */
public class 转换数字的最少位翻转次数 {
    public static int minBitFlips(int start, int goal) {
//        String s1 = Integer.toBinaryString(start);
//        String s2 = Integer.toBinaryString(goal);
//        int len = Math.max(s1.length(), s2.length());
//        String s3 = buqi(s2, len-s2.length());
//        String s4 = buqi(s1, len-s1.length());
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println("s3:"+s3);
//        System.out.println("s4:"+s4);
//
//        char[] ch1 = s3.toCharArray();
//        char[] ch2 = s4.toCharArray();
//
//        int count = 0;
//        for (int i = 0; i < ch1.length; i++) {
//                if(ch1[i]!=ch2[i]){
//                    count++;
//                }
//        }
//        return count;
        return Integer.bitCount(start ^ goal);
    }
//    public static String buqi(String s1,int n){
//        StringBuilder s1Builder = new StringBuilder(s1);
//        for (int i = 0; i < n; i++) {
//            s1Builder.insert(0, "0");
//        }
//        s1 = s1Builder.toString();
//        return s1;
//    }
    public static void main(String[] args) {
        System.out.println(minBitFlips(3, 4));
    }

}
