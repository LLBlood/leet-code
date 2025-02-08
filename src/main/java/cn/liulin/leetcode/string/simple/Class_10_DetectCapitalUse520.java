package cn.liulin.leetcode.string.simple;

/**
 * 520. 检测大写字母
 *
 * @author liulin
 * @date 2025-02-08 10:21:16
 */
public class Class_10_DetectCapitalUse520 {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }
        // 首字母大写，其他小写
        // 全部大写
        // 全部小写
        boolean firstFlag = false;
        boolean allFlag = false;
        char c = word.charAt(0);
        if (c >= 'A' && c <= 'Z') {
            firstFlag = true;
        }
        char c2 = word.charAt(1);
        if (c2 >= 'A' && c2 <= 'Z') {
            if (!firstFlag) {
                return false;
            }
            allFlag = true;
        }
        for (int i = 2; i < word.length(); i++) {
            if (allFlag && word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                return false;
            }
            if (!allFlag && word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                return false;
            }
        }
        return true;
    }

    public boolean detectCapitalUse2(String word) {
        if (word.length() >= 2 && Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            return false;
        }
        for (int i = 1; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i)) ^ Character.isUpperCase(word.charAt(1))) {
                return false;
            }
        }
        return true;
    }
}
