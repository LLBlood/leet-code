package cn.liulin.leetcode.unfixedwindows.medium;

import java.util.Arrays;

/**
 * 209. 长度最小的子数组
 *
 * @author liulin
 * @version 1.0
 * @date 2025/7/3 17:42
 */
public class Class_15_MinSubArrayLen209 {
    public int minSubArrayLen(int target, int[] nums) {
        if (Arrays.stream(nums).sum() < target) {
            return 0;
        }
        int left = 0;
        int ans = nums.length;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                if (ans == 1) {
                    return ans;
                }
                sum -= nums[left];
                left++;
            }
        }
        return ans;
    }
}
