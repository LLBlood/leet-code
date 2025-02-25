package cn.liulin.leetcode.fixedwindows.medium;

import java.util.*;

/**
 * 2841. 几乎唯一子数组的最大和
 *
 * @author liulin
 * @date 2025-02-25 14:25:30
 */
public class Class_4_MaxSum2841 {
    public long maxSum(List<Integer> nums, int m, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        int n = nums.size();
        for (int i = 0; i < k; i++) {
            sum += nums.get(i);
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
        }
        long maxValue = 0;
        if (map.size() >= m) {
            maxValue = sum;
        }
        for (int i = k; i < n; i++) {
            sum = sum - nums.get(i - k) + nums.get(i);
            if (map.get(nums.get(i - k)) > 1) {
                map.put(nums.get(i - k), map.get(nums.get(i - k)) - 1);
            } else {
                map.remove(nums.get(i - k));
            }
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
            if (map.size() >= m) {
                maxValue = Math.max(sum, maxValue);
            }
        }
        return maxValue;
    }
}
