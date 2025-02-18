package cn.liulin.leetcode.string.medium;

/**
 * 97. 交错字符串
 *
 * @author liulin
 * @date 2025-02-18 17:30:29
 */
public class Class_10_IsInterleave97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        int s1Index = 0;
        int s2Index = 0;
        return dff(s1Index, s2Index, s1, s2, s3, 0);
    }

    private boolean dff(int s1Index, int s2Index, String s1, String s2, String s3, int i) {
        if (i == s3.length()) {
            return true;
        }
        boolean result1 = false;
        boolean result2 = false;
        if (s1Index < s1.length() && s1.charAt(s1Index) == s3.charAt(i)) {
            result1 = dff(s1Index + 1, s2Index, s1, s2, s3, i + 1);
        }
        if (s2Index < s2.length() && s2.charAt(s2Index) == s3.charAt(i)) {
            result2 = dff(s1Index, s2Index + 1, s1, s2, s3, i + 1);
        }
        return result1 || result2;
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean[][] f = new boolean[s1.length() + 1][s2.length() + 1];
        f[0][0] = true;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return f[s1.length()][s2.length()];
    }
}
