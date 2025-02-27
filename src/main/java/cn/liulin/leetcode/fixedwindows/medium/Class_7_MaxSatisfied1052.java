package cn.liulin.leetcode.fixedwindows.medium;

/**
 * 1052. 爱生气的书店老板
 *
 * @author liulin
 * @date 2025-02-26 16:26:46
 */
public class Class_7_MaxSatisfied1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        // 一个是minutes范围内的所有默认不生气，剩下来的计算一次，然后不断挪动窗口
        int sum = 0;
        int otherSum = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            if (i < minutes) {
                sum += customers[i];
            } else if (grumpy[i] == 0) {
                otherSum += customers[i];
            }
        }
        int maxSum = sum + otherSum;
        for (int i = minutes; i < n; i++) {
            sum = sum - customers[i - minutes] + customers[i];
            if (grumpy[i - minutes] == 0) {
                otherSum += customers[i - minutes];
            }
            if (grumpy[i] == 0) {
                otherSum -= customers[i];
            }
            maxSum = Math.max(maxSum, sum + otherSum);
        }
        return maxSum;
    }

    public int maxSatisfied2(int[] customers, int[] grumpy, int minutes) {
        // 一个是minutes范围内的所有默认不生气，剩下来的计算一次，然后不断挪动窗口
        int sum = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }
        int incre = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                incre += customers[i];
            }
        }
        int maxIncre = incre;
        for (int i = minutes; i < n; i++) {
            if (grumpy[i - minutes] == 1) {
                incre -= customers[i - minutes];
            }
            if (grumpy[i] == 1) {
                incre += customers[i];
            }
            maxIncre = Math.max(maxIncre, incre);
        }
        return sum + maxIncre;
    }

    public static void main(String[] args) {
        new Class_7_MaxSatisfied1052().maxSatisfied(new int[] {1,0,1,2,1,1,7,5}, new int[] {0,1,0,1,0,1,0,1}, 3);
    }
}
