package cn.liulin.leetcode.fixedwindows.medium;

/**
 * 1343. 大小为 K 且平均值大于等于阈值的子数组数目
 *
 * @author liulin
 * @date 2025-02-25 13:32:21
 */
public class Class_2_NumOfSubarrays1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int maxSum = threshold * k;
        int n = arr.length;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        if (sum >= maxSum) {
            count++;
        }
        for (int i = k; i < n; i++) {
            sum = sum - arr[i - k] + arr[i];
            if (sum >= maxSum) {
                count++;
            }
        }
        return count;
    }
}
