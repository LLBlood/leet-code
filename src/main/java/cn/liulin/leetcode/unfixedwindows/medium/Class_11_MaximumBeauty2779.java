package cn.liulin.leetcode.unfixedwindows.medium;

import java.util.Arrays;

/**
 * 2779. 数组的最大美丽值
 *
 * @author liulin
 * @version 1.0
 * @date 2025/6/27 14:56
 */
public class Class_11_MaximumBeauty2779 {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > k * 2) {
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
