package cn.liulin.leetcode.unfixedwindows.medium;

/**
 * 1004. 最大连续1的个数 III
 *
 * @author liulin
 * @version 1.0
 * @date 2025/6/26 9:49
 */
public class Class_8_LongestOnes1004 {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int ans = 0;
        int cost = 0;
        for (int right = 0; right < nums.length; right++) {
            cost += Math.abs(nums[right] - 1);
            while (cost > k) {
                cost -= Math.abs(nums[left] - 1);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int longestOnes2(int[] nums, int k) {
        int left = 0;
        int ans = 0;
        int cost = 0;
        for (int right = 0; right < nums.length; right++) {
            cost += nums[right] ^ 1;
            while (cost > k) {
                cost -= nums[left] ^ 1;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int longestOnes3(int[] nums, int k) {
        int left = 0;
        int ans = 0;
        int cost = 0;
        for (int right = 0; right < nums.length; right++) {
            cost += 1 - nums[right];
            while (cost > k) {
                cost -= 1 - nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
