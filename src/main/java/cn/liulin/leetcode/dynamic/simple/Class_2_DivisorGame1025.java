package cn.liulin.leetcode.dynamic.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 1025. 除数博弈
 *
 * @author liulin
 * @date 2025-02-19 11:03:31
 */
public class Class_2_DivisorGame1025 {
    public boolean divisorGame(int n) {
        boolean[] booleans = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            List<Integer> result = getIntN(i);
            for (Integer integer : result) {
                if (!booleans[i - integer]) {
                    booleans[i] = true;
                    break;
                }
            }
        }
        return booleans[n];
    }

    private List<Integer> getIntN(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean divisorGame2(int n) {
        boolean[] booleans = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0 && !booleans[i - j]) {
                    booleans[i] = true;
                    break;
                }
            }
        }
        return booleans[n];
    }
}
