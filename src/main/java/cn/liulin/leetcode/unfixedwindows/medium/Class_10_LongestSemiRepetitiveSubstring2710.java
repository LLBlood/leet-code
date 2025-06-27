package cn.liulin.leetcode.unfixedwindows.medium;

/**
 * 2730. 找到最长的半重复子字符串
 *
 * @author liulin
 * @version 1.0
 * @date 2025/6/27 14:05
 */
public class Class_10_LongestSemiRepetitiveSubstring2710 {
    public int longestSemiRepetitiveSubstring(String s) {
        int cost = 0;
        int left = 0;
        int ans = 0;
        for (int right = 0; right < s.length(); right++) {
            if (right != 0 && s.charAt(right) == s.charAt(right - 1)) {
                cost++;
                while (cost > 1) {
                    if (s.charAt(left) == s.charAt(left + 1)) {
                        cost--;
                    }
                    left++;
                }
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
