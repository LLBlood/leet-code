package cn.liulin.leetcode.unfixedwindows.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 904. 水果成篮
 *
 * @author liulin
 * @version 1.0
 * @date 2025/6/24 17:53
 */
public class Class_4_TotalFruit904 {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            int curCost = map.size();
            while (curCost > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
                curCost = map.size();
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int totalFruit2(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();

        int left = 0, ans = 0;
        for (int right = 0; right < n; ++right) {
            cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
            while (cnt.size() > 2) {
                cnt.put(fruits[left], cnt.get(fruits[left]) - 1);
                if (cnt.get(fruits[left]) == 0) {
                    cnt.remove(fruits[left]);
                }
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
