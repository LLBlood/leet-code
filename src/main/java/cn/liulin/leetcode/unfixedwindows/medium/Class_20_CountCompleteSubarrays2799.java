package cn.liulin.leetcode.unfixedwindows.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2799. 统计完全子数组的数目
 *
 * @author liulin
 * @version 1.0
 * @date 2025/8/4 16:26
 */
public class Class_20_CountCompleteSubarrays2799 {
    public int countCompleteSubarrays(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int left = 0;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.size() == set.size()) {
                ans += nums.length - right;
                Integer integer = map.get(nums[left]);
                if (integer == 1) {
                    map.remove(nums[left]);
                } else {
                    map.put(nums[left], integer - 1);
                }
                left++;
            }
        }
        return ans;
    }
}
