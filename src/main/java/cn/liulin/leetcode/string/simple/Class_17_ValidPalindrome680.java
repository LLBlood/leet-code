package cn.liulin.leetcode.string.simple;

import static sun.plugin2.main.server.LiveConnectSupport.getResult;

/**
 * 680. 验证回文串 II
 *
 * @author liulin
 * @date 2025-02-12 14:45:54
 */
public class Class_17_ValidPalindrome680 {
    public boolean validPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        return getResult(0, s.length() - 1, s, 1);
    }

    private boolean getResult(int start, int end, String s, int chance) {
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
                continue;
            }
            if (chance == 0) {
                return false;
            }
            return getResult(start + 1, end, s, 0) || getResult(start, end - 1, s, 0);
        }
        return true;
    }

    public static void main(String[] args) {
        new Class_17_ValidPalindrome680().validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga");
    }
}
