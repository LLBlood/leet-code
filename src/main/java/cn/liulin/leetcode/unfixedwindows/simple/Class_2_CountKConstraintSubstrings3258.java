package cn.liulin.leetcode.unfixedwindows.simple;

/**
 * 3258. 统计满足 K 约束的子字符串数量 I
 *
 * @author liulin
 * @version 1.0
 * @date 2025/8/4 15:42
 */
public class Class_2_CountKConstraintSubstrings3258 {
    public int countKConstraintSubstrings(String s, int k) {
        int[] ans = new int[2];
        int left = 0;
        int sum = 0;
        char[] chars = s.toCharArray();
        for (int right = 0; right < chars.length; right++) {
            ans[chars[right] - '0']++;
            while (ans[0] > k && ans[1] > k) {
                ans[chars[left] - '0']--;
                left++;
            }
            sum += right - left + 1;
        }
        return sum;
    }
}
