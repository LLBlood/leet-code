package cn.liulin.leetcode.dynamic.simple;

import java.util.*;

/**
 * LCP 07. 传递信息
 *
 * @author liulin
 * @date 2025-02-24 10:03:06
 */
public class Class_7_MessageDeliveryLCP07 {
    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] ints : relation) {
            if (map.containsKey(ints[0])) {
                map.get(ints[0]).add(ints[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(ints[1]);
                map.put(ints[0], list);
            }
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (k > 0 && !queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            while (!queue.isEmpty()) {
                temp.add(queue.poll());
            }
            k--;
            for (Integer i : temp) {
                List<Integer> integers = map.get(i);
                if (integers != null) {
                    for (Integer integer : integers) {
                        if (k == 0 && integer == n - 1) {
                            count++;
                        }
                        queue.add(integer);
                    }
                }
            }
        }
        return count;
    }

    public int numWays2(int n, int[][] relation, int k) {
        int[][] des = new int[k + 1][n];
        des[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] ints : relation) {
                int sec = ints[0];
                int det = ints[1];
                des[i + 1][det] += des[i][sec];
            }
        }
        return des[k][n - 1];
    }
}
