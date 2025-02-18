package cn.liulin.leetcode.string.simple;

/**
 * 917. 仅仅反转字母
 *
 * @author liulin
 * @date 2025-02-18 16:59:39
 */
public class Class_24_ReverseOnlyLetters917 {
    public String reverseOnlyLetters(String s) {
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetter(charArray[left])) {
                left++;
            }
            while (left < right && !Character.isLetter(charArray[right])) {
                right--;
            }
            if (left < right) {
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }
        }
        return new String(charArray);
    }
}
