package cn.liulin.leetcode.unfixedwindows.medium;

import java.util.Set;

/**
 * 1358. 包含所有三种字符的子字符串数目
 *
 * @author liulin
 * @version 1.0
 * @date 2025/8/4 16:02
 */
public class Class_19_NumberOfSubstrings1358 {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        int[] abc = new int[3];
        int left = 0;
        char[] chars = s.toCharArray();
        for (int right = 0; right < chars.length; right++) {
            abc[chars[right] - 'a']++;
            while (abc[0] >= 1 && abc[1] >= 1 && abc[2] >= 1) {
                ans += chars.length - right;
                abc[chars[left] - 'a']--;
                left++;
            }
        }
        return ans;
    }
}
