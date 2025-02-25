package cn.liulin.leetcode.fixedwindows.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 2090. 半径为 k 的子数组平均值
 *
 * @author liulin
 * @date 2025-02-25 13:40:43
 */
public class Class_3_GetAverages2090 {
    public int[] getAverages(int[] nums, int k) {
        // 其实就是2K+1长度的定长窗口
        long sum = 0;
        int sumK = 2 * k + 1;
        int n = nums.length;
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        if (sumK > n) {
            return arr;
        }
        for (int i = 0; i < sumK; i++) {
            sum += nums[i];
        }
        int begin = (sumK - 1) / 2;
        arr[begin] = (int) (sum / sumK);
        for (int i = sumK; i < n; i++) {
            sum = sum - nums[i - sumK] + nums[i];
            arr[++begin] = (int) (sum / sumK);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(100000L * 80000 > (long) Integer.MAX_VALUE);
    }
}
