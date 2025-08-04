package cn.liulin.leetcode.unfixedwindows.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * LCP 68. 美观的花束
 *
 * @author liulin
 * @version 1.0
 * @date 2025/8/4 15:50
 */
public class Class_18_BeautifulBouquet68 {
    public int beautifulBouquet(int[] flowers, int cnt) {
        Map<Integer, Integer> flowerCountMap = new HashMap<>();
        int left = 0;
        int ans = 0;
        for (int right = 0; right < flowers.length; right++) {
            flowerCountMap.put(flowers[right], flowerCountMap.getOrDefault(flowers[right], 0) + 1);
            while (flowerCountMap.get(flowers[right]) > cnt) {
                flowerCountMap.put(flowers[left], flowerCountMap.get(flowers[left]) - 1);
                left++;
            }
            ans += right - left + 1;
        }
        return ans % 1000000007;
    }
}
