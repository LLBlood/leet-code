package cn.liulin.leetcode.string.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * 521. 最长特殊序列 Ⅰ
 *
 * @author liulin
 * @date 2025-02-10 17:38:11
 */
public class Class_12_FindLUSlength521 {
    public int findLUSlength(String a, String b) {
        if (a.length() != b.length()) {
            return Math.max(a.length(), b.length());
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return a.length();
            }
        }
        return -1;
    }
}
