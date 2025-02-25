package cn.liulin.leetcode.fixedwindows.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 2461. 长度为 K 子数组中的最大和
 *
 * @author liulin
 * @date 2025-02-25 14:39:07
 */
public class Class_5_MaximumSubarraySum2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        long maxValue = 0;
        if (map.size() >= k) {
            maxValue = sum;
        }
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            if (map.get(nums[i - k]) > 1) {
                map.put(nums[i - k], map.get(nums[i - k]) - 1);
            } else {
                map.remove(nums[i - k]);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.size() >= k) {
                maxValue = Math.max(sum, maxValue);
            }
        }
        return maxValue;
    }
}
