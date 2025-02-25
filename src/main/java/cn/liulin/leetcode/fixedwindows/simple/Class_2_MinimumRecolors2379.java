package cn.liulin.leetcode.fixedwindows.simple;

/**
 * 2379. 得到 K 个黑块的最少涂色次数
 *
 * @author liulin
 * @date 2025-02-25 14:11:53
 */
public class Class_2_MinimumRecolors2379 {
    public int minimumRecolors(String blocks, int k) {
        // 找出k长度的最少白色块
        int count = 0;
        int n = blocks.length();
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                count++;
            }
        }
        int minCount = count;
        for (int i = k; i < n; i++) {
            if (blocks.charAt(i - k) == 'W') {
                count--;
            }
            if (blocks.charAt(i) == 'W') {
                count++;
            }
            minCount = Math.min(minCount, count);
        }
        return minCount;
    }
}
