package cn.liulin.leetcode.unfixedwindows.medium;

/**
 * 1208. 尽可能使字符串相等
 *
 * @author liulin
 * @version 1.0
 * @date 2025/6/23 11:29
 */
public class Class_3_EqualSubstring1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int ans = 0;
        int left = 0;
        int cost0 = 0;
        for (int right = 0; right < s.length(); right++) {
            cost0 += Math.abs(s.charAt(right) - t.charAt(right));
            while (cost0 > maxCost) {
                cost0 -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
