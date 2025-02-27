package cn.liulin.leetcode.fixedwindows.simple;

import java.util.Arrays;

/**
 * 1652. 拆炸弹
 *
 * @author liulin
 * @date 2025-02-26 17:18:47
 */
public class Class_3_Decrypt1652 {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) {
            Arrays.fill(ans, 0);
            return ans;
        }
        int sum = 0;
        if (k > 0) {
            for (int i = 1; i <= k; i++) {
                sum += code[i];
            }
            for (int i = 0; i < n; i++) {
                ans[i] = sum;
                sum = sum - code[(i + 1) % n] + code[(i + 1 + k) % n];
            }
        } else {
            for (int i = k; i < 0; i++) {
                sum += code[i + n];
            }
            for (int i = 0; i < n; i++) {
                ans[i] = sum;
                sum = sum - code[(i + k + n) % n] + code[i];
            }
        }
        return ans;
    }

    public int[] decrypt2(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) {
            Arrays.fill(ans, 0);
            return ans;
        }
        int[] newCode = new int[2 * n];
        System.arraycopy(code, 0, newCode, 0, n);
        System.arraycopy(code, 0, newCode, n, n);
        code = newCode;
        int l = k > 0 ? 1 : n + k;
        int r = k > 0 ? k : n - 1;
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += code[i];
        }
        for (int i = 0; i < n; i++) {
            ans[i] = sum;
            sum -= code[l];
            sum += code[r + 1];
            l++;
            r++;
        }
        return ans;
    }

    public static void main(String[] args) {
        new Class_3_Decrypt1652().decrypt(new int[] {5,7,1,4}, 3);
    }
}
