package cn.liulin.leetcode.unfixedwindows.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 1695. 删除子数组的最大得分
 *
 * @author liulin
 * @version 1.0
 * @date 2025/6/24 18:13
 */
public class Class_5_MaximumUniqueSubarray1695 {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            while (map.get(num) > 1) {
                map.put(nums[left], map.get(nums[left]) - 1);
                sum -= nums[left];
                left++;
            }
            sum += num;
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public int maximumUniqueSubarray2(int[] nums) {
        int left = 0;
        int ans = 0;
        int[] arr = new int[10001];
        int sum = 0;
        for (int num : nums) {
            arr[num]++;
            while (arr[num] > 1) {
                arr[nums[left]]--;
                sum -= nums[left];
                left++;
            }
            sum += num;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
