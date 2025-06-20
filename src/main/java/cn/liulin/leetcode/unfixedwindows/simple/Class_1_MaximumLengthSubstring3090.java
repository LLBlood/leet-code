package cn.liulin.leetcode.unfixedwindows.simple;

/**
 * 3090. 每个字符最多出现两次的最长子字符串
 *
 * @author liulin
 * @version 1.0
 * @date 2025/6/20 10:06
 */
public class Class_1_MaximumLengthSubstring3090 {
    public int maximumLengthSubstring(String s) {
        char[] chars = s.toCharArray();
        int[] arr = new int[128];
        int ans = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char aChar = chars[right];
            arr[aChar]++;
            while (arr[aChar] > 2) {
                arr[chars[left]]--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
