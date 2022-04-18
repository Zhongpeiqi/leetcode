package 力扣;

/**
 * @author peiqi
 * @date 2022/4/1814:42
 */
public class 找到小镇的法官 {
    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n+1];
        int[] out = new int[n+1];

        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];
            in[b]++;
            out[a]++;
        }
        for (int i = 1; i <= n; i++) {
            if (in[i] == n - 1 && out[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
