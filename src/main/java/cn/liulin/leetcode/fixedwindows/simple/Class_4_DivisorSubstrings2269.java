package cn.liulin.leetcode.fixedwindows.simple;

/**
 * 2269. 找到一个数字的 K 美丽值
 *
 * @author liulin
 * @version 1.0
 * @date 2025/6/19 14:46
 */
public class Class_4_DivisorSubstrings2269 {
    public int divisorSubstrings(int num, int k) {
        String numStr = String.valueOf(num);
        int sum = 0;
        int currentKSum = 0;
        char[] chars = numStr.toCharArray();
        int kMul = 1;
        for (int i = 0; i < k; i++) {
            if (i != 0) {
                kMul *= 10;
            }
            currentKSum = currentKSum * 10 + (chars[i] - '0');
        }
        if (currentKSum != 0 && num % currentKSum == 0) {
            sum++;
        }
        for (int i = k; i < chars.length; i++) {
            currentKSum = currentKSum - (chars[i - k] - '0') * kMul;
            currentKSum = currentKSum * 10 + (chars[i] - '0');
            if (currentKSum != 0 && num % currentKSum == 0) {
                sum++;
            }
        }
        return sum;
    }
}
