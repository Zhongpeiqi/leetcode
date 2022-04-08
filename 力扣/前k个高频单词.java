package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/4/813:04
 */
public class 前k个高频单词 {
    /**
     * 小根堆
     *
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 1) + 1);
        }

        //构建小根堆
        PriorityQueue<String> queue = new PriorityQueue<>((s1, s2) -> {
            if (map.get(s1).equals(map.get(s2))) {
                //按字典顺序比较两个字符串
                return s2.compareTo(s1);
            } else {
                return map.get(s1) - map.get(s2);
            }
        });

        for (String s : map.keySet()) {
            queue.offer(s);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        //依次弹出堆中的 K 个元素，放入结果集合中。
        List<String> res = new ArrayList<>(k);
        while (queue.size() > 0) {
            res.add(queue.poll());
        }
        //最后需要反转元素的顺序。
        Collections.reverse(res);
        return res;
    }

    /**
     * 哈希表排序
     *
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent2(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 1) + 1);
        }

        //存储字符key
        List<String> res = new ArrayList<>(map.keySet());
        res.sort((a, b) -> {
            if (map.get(a).equals(map.get(b))) {
                //按字典顺序比较两个字符串
                return a.compareTo(b);
            } else {
                return map.get(b) - map.get(a);
            }
        });

        return res.subList(0, k);
    }
}
