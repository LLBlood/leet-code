package cn.liulin.leetcode.unfixedwindows.medium;

import java.util.Arrays;

/**
 * 1658. 将 x 减到 0 的最小操作数
 *
 * @author liulin
 * @version 1.0
 * @date 2025/6/26 9:55
 */
public class Class_9_MinOperations1658 {
    public int minOperations(int[] nums, int x) {
        if (Arrays.stream(nums).sum() < x || Arrays.stream(nums).allMatch(x1 -> x1 > x)) {
            return -1;
        }
        int[] nums2 = new int[nums.length * 2];
        int index = 0;
        for (int num : nums) {
            nums2[index++] = num;
        }
        for (int num : nums) {
            nums2[index++] = num;
        }
        int left = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < nums2.length; right++) {
            sum += nums2[right];
            while (sum > x) {
                sum -= nums2[left];
                left++;
            }
            if (sum == x && (left <= nums.length && right >= nums.length - 1)) {
                ans = Math.min(ans, right - left + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int minOperations2(int[] nums, int x) {
        int target = -x;
        for (int num : nums) {
            target += num;
        }
        if (target < 0) {
            return -1;
        }
        int left = 0;
        int ans = -1;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > target) {
                sum -= nums[left];
                left++;
            }
            if (sum == target) {
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans < 0 ? -1 : nums.length - ans;
    }
}
