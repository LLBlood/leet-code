package cn.liulin.leetcode.fixedwindows.medium;

/**
 * 2134. 最少交换次数来组合所有的 1 II
 *
 * @author liulin
 * @date 2025-02-27 15:09:13
 */
public class Class_9_MinSwaps2134 {
    public int minSwaps(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            }
        }
        int sumCount = 0;
        for (int i = 0; i < count; i++) {
            if (nums[i] == 1) {
                sumCount++;
            }
        }
        int maxCount = sumCount;
        int n = nums.length;
        for (int i = count; i < 2 * n; i++) {
            if (nums[(i - count) % n] == 1) {
                sumCount--;
            }
            if (nums[i % n] == 1) {
                sumCount++;
            }
            maxCount = Math.max(maxCount, sumCount);
        }
        return count - maxCount;
    }

    public int minSwaps2(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            }
        }
        int[] newNums = new int[2 * n];
        System.arraycopy(nums, 0, newNums, 0, n);
        System.arraycopy(nums, 0, newNums, n, n);
        nums = newNums;
        int sumCount = 0;
        for (int i = 0; i < count; i++) {
            if (nums[i] == 1) {
                sumCount++;
            }
        }
        int maxCount = sumCount;
        for (int i = count; i < nums.length; i++) {
            if (nums[i - count] == 1) {
                sumCount--;
            }
            if (nums[i] == 1) {
                sumCount++;
            }
            maxCount = Math.max(maxCount, sumCount);
        }
        return count - maxCount;
    }
}
