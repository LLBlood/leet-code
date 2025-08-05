package cn.liulin.leetcode.unfixedwindows.medium;

/**
 * 930. 和相同的二元子数组
 *
 * @author liulin
 * @version 1.0
 * @date 2025/8/5 16:07
 */
public class Class_21_NumSubarraysWithSum930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ansRatherGoal = 0;
        int ansRatherGoalAnd1 = 0;
        int left = 0;
        int sum = 0;
        int left2 = 0;
        int sum2 = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= goal && left <= right) {
                ansRatherGoal += nums.length - right;
                sum -= nums[left];
                left++;
            }
        }
        for (int right = 0; right < nums.length; right++) {
            sum2 += nums[right];
            while (sum2 >= goal + 1 && left2 <= right) {
                ansRatherGoalAnd1 += nums.length - right;
                sum2 -= nums[left2];
                left2++;
            }
        }
        return ansRatherGoal - ansRatherGoalAnd1;
    }

    public static void main(String[] args) {
        new Class_21_NumSubarraysWithSum930().numSubarraysWithSum(new int[] {0,1,1,1,1}, 3);
    }
}
