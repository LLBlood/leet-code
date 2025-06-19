package cn.liulin.leetcode.fixedwindows.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 1461. 检查一个字符串是否包含所有长度为 K 的二进制子串
 *
 * @author liulin
 * @version 1.0
 * @date 2025/6/19 15:18
 */
public class Class_16_HasAllCodes1461 {
    public boolean hasAllCodes(String s, int k) {
        int result = 1 << k;
        if (s.length() - k + 1 < result) {
            return false;
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - k + 1; i++) {
            set.add(s.substring(i, i + k));
        }
        return set.size() == result;
    }

    public boolean hasAllCodes2(String s, int k) {
        int result = 1 << k;
        if (s.length() - k + 1 < result) {
            return false;
        }
        int sum = 0;
        int re = 1 << (k - 1);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            sum = sum * 2 + (s.charAt(i) - '0');
        }
        set.add(sum);
        for (int i = k; i < s.length(); i++) {
            sum = sum - (s.charAt(i - k) - '0') * re;
            sum = sum * 2 + (s.charAt(i) - '0');
            set.add(sum);
        }
        return set.size() == result;
    }

    public boolean hasAllCodes3(String s, int k) {
        if (s.length() < (1 << k) + k - 1) {
            return false;
        }

        int num = Integer.parseInt(s.substring(0, k), 2);
        Set<Integer> exists = new HashSet<Integer>();
        exists.add(num);

        for (int i = 1; i + k <= s.length(); ++i) {
            num = (num - ((s.charAt(i - 1) - '0') << (k - 1))) * 2 + (s.charAt(i + k - 1) - '0');
            exists.add(num);
        }
        return exists.size() == (1 << k);
    }
}
