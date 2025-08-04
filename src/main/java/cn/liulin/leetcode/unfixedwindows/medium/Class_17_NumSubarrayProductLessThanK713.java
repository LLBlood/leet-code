package cn.liulin.leetcode.unfixedwindows.medium;

/**
 * 713. 乘积小于 K 的子数组
 *
 * @author liulin
 * @version 1.0
 * @date 2025/8/4 15:26
 */
public class Class_17_NumSubarrayProductLessThanK713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int ans = 0;
        int numK = 1;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            numK *= nums[right];
            while (numK >= k) {
                numK /= nums[left];
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
