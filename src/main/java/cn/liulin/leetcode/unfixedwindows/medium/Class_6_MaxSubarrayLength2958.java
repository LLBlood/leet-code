package cn.liulin.leetcode.unfixedwindows.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 2958. 最多 K 个重复元素的最长子数组
 *
 * @author liulin
 * @version 1.0
 * @date 2025/6/26 9:26
 */
public class Class_6_MaxSubarrayLength2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        int left = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.get(nums[right]) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
