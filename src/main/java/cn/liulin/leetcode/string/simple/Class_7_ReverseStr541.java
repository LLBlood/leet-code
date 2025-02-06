package cn.liulin.leetcode.string.simple;

/**
 * 541. 反转字符串 II
 *
 * @author liulin
 * @date 2025-02-06 13:33:47
 */
public class Class_7_ReverseStr541 {
    public String reverseStr(String s, int k) {
        int start = 0;
        int end = Math.min(2 * k, s.length());
        StringBuilder sb = new StringBuilder();
        while (start < s.length()) {
            int reverseStart = Math.min(start + k, s.length());
            for (int i = reverseStart - 1; i >= start; i--) {
                sb.append(s.charAt(i));
            }
            for (int i = reverseStart; i < end; i++) {
                sb.append(s.charAt(i));
            }
            start = end;
            end = Math.min(start + 2 * k, s.length());
        }
        return sb.toString();
    }

    public String reverseStr2(String s, int k) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            reverse(charArray, i, Math.min(i + k, s.length()) - 1);
        }
        return new String(charArray);
    }

    private void reverse(char[] charArray, int left, int right) {
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
    }
}
