package cn.liulin.leetcode.dynamic.simple;

/**
 * 面试题 17.16. 按摩师
 *
 * @author liulin
 * @date 2025-02-21 10:54:00
 */
public class Class_6_massage17_16 {
    public int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] f = new int[nums.length];
        f[0] = nums[0];
        f[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            f[i] = Math.max(f[i - 2] + nums[i], f[i - 1]);
        }
        return f[nums.length - 1];
    }

    public int massage2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int dp0 = 0;
        int dp1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tdp0 = Math.max(dp0, dp1);
            int tdp1 = dp0 + nums[i];

            dp0 = tdp0;
            dp1 = tdp1;
        }
        return Math.max(dp0, dp1);
    }
}
