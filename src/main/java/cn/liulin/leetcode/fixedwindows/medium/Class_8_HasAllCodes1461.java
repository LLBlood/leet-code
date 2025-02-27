package cn.liulin.leetcode.fixedwindows.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 1461. 检查一个字符串是否包含所有长度为 K 的二进制子串
 *
 * @author liulin
 * @date 2025-02-27 14:20:57
 */
public class Class_8_HasAllCodes1461 {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        if (n < k) {
            return false;
        }
        // 计算k长度的二进制子串的可能性
        int sum = (int) Math.pow(2, k);
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(s.charAt(i));
        }
        set.add(sb.toString());
        for (int i = k; i < n; i++) {
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            set.add(sb.toString());
        }
        return set.size() == sum;
    }

    public boolean hasAllCodes2(String s, int k) {
        if (s.length() < (1 << k) + k - 1) {
            return false;
        }

        Set<String> exists = new HashSet<String>();
        for (int i = 0; i + k <= s.length(); ++i) {
            exists.add(s.substring(i, i + k));
        }
        return exists.size() == (1 << k);
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
