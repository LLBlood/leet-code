package cn.liulin.leetcode.fixedwindows.medium;

/**
 * 1423. 可获得的最大点数
 *
 * @author liulin
 * @date 2025-02-25 14:47:10
 */
public class Class_6_MaxScore1423 {
    public int maxScore(int[] cardPoints, int k) {
        // 因为是从行头或者行尾拿，所以角标必定包含行首或者行尾才有求值的可能性
        // 即 开头角标为0，结束角标为cardPoints.length - 1 或者小于开头角标
        int count = 0;
        int n = cardPoints.length;
        int sum = 0;
        int maxSum = 0;
        for (int i = n - k; i < n + k; i++) {
            int index = i;
            if (index >= n) {
                index %= n;
            }
            sum += cardPoints[index];
            count++;
            if (count < k) {
                continue;
            }
            maxSum = Math.max(sum, maxSum);
            sum -= cardPoints[(i - k + 1) % n];
        }
        return maxSum;
    }

    public int maxScore2(int[] cardPoints, int k) {
        // 因为是从行头或者行尾拿，所以角标必定包含行首或者行尾才有求值的可能性
        // 即 开头角标为0，结束角标为cardPoints.length - 1 或者小于开头角标
        int n = cardPoints.length;
        int sum = 0;
        int maxSum = 0;
        for (int i = -k; i <= k; i++) {
            if (i >= 0) {
                maxSum = Math.max(maxSum, sum);
                sum -= cardPoints[(i - k + n) % n];
            }
            sum += cardPoints[(i + n) % n];
        }
        return maxSum;
    }

    public static void main(String[] args) {
        new Class_6_MaxScore1423().maxScore(new int[] {1,2,3,4,5,6,1}, 3);
    }
}
