package cn.liulin.leetcode.fixedwindows.medium;

/**
 * 1456. 定长子串中元音的最大数目
 *
 * @author liulin
 * @date 2025-02-24 11:21:03
 */
public class Class_1_MaxVowels1456 {
    public int maxVowels(String s, int k) {
        int ans = 0;
        int curMax = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                curMax++;
            }
            if (i < k - 1) {
                continue;
            }
            ans = Math.max(ans, curMax);
            char out = charArray[i - k + 1];
            if (out == 'a' || out == 'e' || out == 'i' || out == 'o' || out == 'u') {
                curMax--;
            }
        }
        return ans;
    }
}
