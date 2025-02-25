package cn.liulin.leetcode.fixedwindows.simple;

import java.math.BigDecimal;

/**
 * 643. 子数组最大平均数 I
 *
 * @author liulin
 * @date 2025-02-25 13:09:30
 */
public class Class_1_FindMaxAverage643 {
    public double findMaxAverage(int[] nums, int k) {
        double maxValue = Double.NEGATIVE_INFINITY;
        double temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            if (i < k - 1) {
                continue;
            }
            maxValue = Math.max(maxValue, temp / k);
            if (i - k + 1 >= 0) {
                temp -= nums[i - k + 1];
            }
        }
        return maxValue;
    }

    public double findMaxAverage2(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum * 1.0 / k;
    }

    public static void main(String[] args) {
        new Class_1_FindMaxAverage643().findMaxAverage(new int[] {-1}, 1);
    }
}
