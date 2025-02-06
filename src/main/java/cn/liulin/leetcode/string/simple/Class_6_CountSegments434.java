package cn.liulin.leetcode.string.simple;

/**
 * 434. 字符串中的单词数
 *
 * @author liulin
 * @date 2025-02-06 13:20:20
 */
public class Class_6_CountSegments434 {
    public int countSegments(String s) {
        int sum = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (count > 0) {
                    sum++;
                    count = 0;
                }
            } else {
                count++;
            }
        }
        if (count > 0) {
            sum++;
        }
        return sum;
    }

    public int countSegments2(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                sum++;
            }
        }
        return sum;
    }
}
