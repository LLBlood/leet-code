package cn.liulin.leetcode.recursion.simple;

/**
 * 326. 3 的幂
 *
 * @author liulin
 * @date 2025-02-24 10:45:39
 */
public class Class_1_IsPowerOfThree326 {
    public boolean isPowerOfThree(int n) {
        return isPowerOfThree(n, 1);
    }

    private boolean isPowerOfThree(int n, int i) {
        if (i == n) {
            return true;
        } else if (i > n) {
            return false;
        } else if (n / i >= 3) {
            return isPowerOfThree(n, i * 3);
        }
        return false;
    }

    public boolean isPowerOfThree2(int n) {
        for (int i = 0; i < n; i++) {
            int pow = (int) Math.pow(3, i);
            if (pow == n) {
                return true;
            } else if (pow > n) {
                return false;
            } else if (n / pow < 3) {
                return false;
            }
        }
        return false;
    }

    public boolean isPowerOfThree3(int n) {
        while (n > 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
