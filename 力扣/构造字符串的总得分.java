package 力扣;

/**
 * @author peiqi
 * @date 2022/4/321:24
 */
public class 构造字符串的总得分 {
    /**
     * KMP算法
     * @param s
     * @return
     */
    public long sumScores(String s) {
        int len = s.length();
        int [] z = new int[len];
        int ans = len;

        for(int i = 1,l = 0,r = 0;i<len;i++){
            z[i] = Math.max(Math.min(z[i-l],r-i+1),0);
            while (i+z[i]<len&&s.charAt(z[i]) == s.charAt(i + z[i])){
                l = i;
                r = i+z[i];
                z[i]++;
            }
            ans+=z[i];
        }
        return ans;
    }
}
