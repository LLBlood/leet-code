package cn.liulin.leetcode.unfixedwindows.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 *
 * @author liulin
 * @version 1.0
 * @date 2025/6/20 9:41
 */
public class Class_1_LengthOfLongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxSum = 0;
        while (right < chars.length) {
            char aChar = chars[right];
            if (left == right || !map.containsKey(aChar)) {
                map.put(aChar, 1);
                sum++;
                right++;
                maxSum = Math.max(sum, maxSum);
            } else {
                char aChar1 = chars[left];
                map.put(aChar1, map.get(aChar1) - 1);
                if (map.get(aChar1) == 0) {
                    map.remove(aChar1);
                }
                left++;
                sum--;
            }
        }
        return maxSum;
    }

    public int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int ans = 0;
        int left = 0;
        int[] cnt = new int[128];
        for (int right = 0; right < n; right++) {
            char c = chars[right];
            cnt[c]++;
            while (cnt[c] > 1) {
                cnt[chars[left]]--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring3(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int ans = 0;
        int left = 0;
        boolean[] has = new boolean[128];
        for (int right = 0; right < n; right++) {
            char c = chars[right];
            while (has[c]) {
                has[chars[left]] = false;
                left++;
            }
            has[c] = true;
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
