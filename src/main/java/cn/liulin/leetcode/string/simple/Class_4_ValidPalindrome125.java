package cn.liulin.leetcode.string.simple;

/**
 * 125. 验证回文串
 *
 * @author liulin
 * @date 2025-02-05 14:01:10
 */
public class Class_4_ValidPalindrome125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            while (left <= right && !((s.charAt(left) >= 'a' && s.charAt(left) <= 'z') || (s.charAt(left) >= 'A' && s.charAt(left) <= 'Z') || (s.charAt(left) >= '0' && s.charAt(left) <= '9'))) {
                left++;
            }
            if (left > right) {
                return true;
            }
            while (left <= right && !((s.charAt(right) >= 'a' && s.charAt(right) <= 'z') || (s.charAt(right) >= 'A' && s.charAt(right) <= 'Z') || (s.charAt(right) >= '0' && s.charAt(right) <= '9'))) {
                right--;
            }
            if (left > right) {
                return true;
            }
            char leftC = s.charAt(left);
            char rightC = s.charAt(right);
            if (leftC >= 'A' && leftC <= 'Z') {
                leftC = (char) (leftC - 'A' + 'a');
            }
            if (rightC >= 'A' && rightC <= 'Z') {
                rightC = (char) (rightC - 'A' + 'a');
            }
            if (leftC == rightC) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Class_4_ValidPalindrome125().isPalindrome("ab2a");
    }

    public boolean isPalindrome2(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
