package cn.liulin.leetcode.unfixedwindows.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 *
 * @author liulin
 * @version 1.0
 * @date 2025/6/23 10:28
 */
public class Class_2_LongestSubarray1493 {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int cnt0 = 0;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            cnt0 += 1 - nums[right];
            while (cnt0 > 1) {
                cnt0 -= 1 - nums[left];
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }

    public static void main(String[] args) {
        new Class_2_LongestSubarray1493().longestSubarray(new int[] {0,0,1,1});
    }
}
