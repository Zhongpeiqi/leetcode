package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/4/110:44
 */
public class 力扣1443 {
    int ans = 0;
    int[] reverseEdges;
    boolean[] visited;

    public void buildReverseEdges(List<List<Integer>> nodeMap, int val) {
        for (int pairVal : nodeMap.get(val)) {
            if (pairVal != 0 && reverseEdges[pairVal] == -1) {
                reverseEdges[pairVal] = val;
                buildReverseEdges(nodeMap, pairVal);
            }
        }
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> nodeMap = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            nodeMap.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            nodeMap.get(edge[0]).add(edge[1]);
            nodeMap.get(edge[1]).add(edge[0]);
        }

        reverseEdges = new int[n];
        Arrays.fill(reverseEdges, -1);
        buildReverseEdges(nodeMap, 0);

        visited = new boolean[n];
        visited[0] = true;

        for (int i = 0; i < n; i++) {
            if (hasApple.get(i)) {
                dfsEdge(i);
            }
        }
        return ans * 2;
    }

    public void dfsEdge(int to) {
        if (!visited[to]) {
            visited[to] = true;
            ans++;
            dfsEdge(reverseEdges[to]);
        }
    }
}
