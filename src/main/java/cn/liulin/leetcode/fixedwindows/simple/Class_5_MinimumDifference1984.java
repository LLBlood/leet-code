package cn.liulin.leetcode.fixedwindows.simple;

import java.util.Arrays;

/**
 * 1984. 学生分数的最小差值
 *
 * @author liulin
 * @version 1.0
 * @date 2025/6/19 15:01
 */
public class Class_5_MinimumDifference1984 {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < n; ++i) {
            ans = Math.min(ans, nums[i + k - 1] - nums[i]);
        }
        return ans;
    }
}
