package cn.liulin.leetcode.unfixedwindows.medium;

import java.util.*;

/**
 * 1234. 替换子串得到平衡字符串
 *
 * @author liulin
 * @version 1.0
 * @date 2025/7/4 15:18
 */
public class Class_17_BalancedString1234 {
    public int balancedString(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int m = s.length() / 4;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        if (map.getOrDefault('Q', 0) == m && map.getOrDefault('W', 0) == m && map.getOrDefault('E', 0) == m && map.getOrDefault('R', 0) == m) {
            return 0;
        }
        int left = 0;
        int minValue = s.length();
        for (int right = 0; right < chars.length; right++) {
            char aChar = chars[right];
            map.put(aChar, map.get(aChar) - 1);
            while (map.getOrDefault('Q', 0) <= m && map.getOrDefault('W', 0) <= m && map.getOrDefault('E', 0) <= m && map.getOrDefault('R', 0) <= m) {
                minValue = Math.min(minValue, right - left + 1);
                map.put(chars[left], map.get(chars[left]) + 1);
                left++;
            }
        }
        return minValue;
    }

    public int balancedString2(String S) {
        char[] s = S.toCharArray();
        int[] cnt = new int['X']; // 也可以用哈希表，不过数组更快一些
        for (char c : s) {
            cnt[c]++;
        }

        int n = s.length;
        int m = n / 4;
        if (cnt['Q'] == m && cnt['W'] == m && cnt['E'] == m && cnt['R'] == m) {
            return 0; // 已经符合要求啦
        }

        int ans = n;
        int left = 0;
        for (int right = 0; right < n; right++) { // 枚举子串右端点
            cnt[s[right]]--;
            while (cnt['Q'] <= m && cnt['W'] <= m && cnt['E'] <= m && cnt['R'] <= m) {
                ans = Math.min(ans, right - left + 1);
                cnt[s[left]]++; // 缩小子串
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        new Class_17_BalancedString1234().balancedString("WWWEQRQEWWQQQWQQQWEWEEWRRRRRWWQE");
        new Class_17_BalancedString1234().balancedString("WQWRQQQW");
    }
}
