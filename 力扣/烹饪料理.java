package 力扣;

/**
 * @author peiqi
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/2014:05
 */
public class 烹饪料理 {
    int maxAns = 0;
    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        this.maxAns = -1;
        boolean[] exists = new boolean[cookbooks.length];
        dfs(materials, cookbooks, attribute, limit, exists, 0, 0);
        return this.maxAns;

    }

    /**
     *
     * @param materials 材料
     * @param cookbooks cookbooks[i][j] 表示制作第 i 种料理需要第 j 种食材的数量
     * @param attribute attribute[i] = [x,y] 表示第 i 道料理的美味度 x 和饱腹感 y
     * @param limit     最小饱腹感 limit
     * @param exists    状态, exists[i] = true 表示已经做了第 i 道料理
     * @param sumx      总的美味度 x
     * @param sumy      总的饱腹感 y
     */
    private void dfs(int[] materials, int[][] cookbooks, int[][] attribute, int limit, boolean[] exists, int sumx, int sumy) {
        if(sumy>=limit){
            this.maxAns = Math.max(maxAns,sumx);
        }
        int len = cookbooks.length;
        for (int i = 0; i < len; i++) {
            if(exists[i]){
                continue;
            }
            int[] need = cookbooks[i];
            boolean can = true;
            for (int j = 0; j < need.length; j++) {
                if(materials[j]<need[j]){
                    can = false;
                    break;
                }
            }
            if(can){
                exists[i] = true;
                for (int j = 0; j < need.length; j++) {
                    materials[j] -= need[j];
                }
                dfs(materials, cookbooks, attribute, limit, exists, sumx + attribute[i][0], sumy + attribute[i][1]);
                //回溯
                for (int j = 0; j < need.length; j++) {
                    materials[j] += need[j];
                }
                exists[i] = false;
            }
        }
    }
}
