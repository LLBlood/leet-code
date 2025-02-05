package cn.liulin.leetcode.string.simple;

/**
 * 28. 找出字符串中第一个匹配项的下标
 *
 * @author liulin
 * @date 2025-01-22 14:49
 **/
public class Class_3_StrStr28 {
    /**
     * 朴素字符串匹配
     * 从文本的第一个字符开始，依次检查每个可能的起始位置，看模式字符串是否在该位置匹配文本字符串。
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        char first = needle.charAt(0);
        int dis = needle.length() - 1;
        char[] chars = haystack.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == first && i + dis < chars.length && haystack.substring(i, i + dis + 1).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * KMP算法
     * KMP算法的核心在于跳跃匹配，它可能会给你带来漏掉字符串匹配的错觉，但是它存在前提，跳跃的是已匹配上字符的最大公共前后缀，
     * 换句话来说，公共的前缀部分，如果不断向右移动，只可能在公共的后缀部分才能重新匹配成功，所以KMP就直接跳跃到该部分
     * 所以难点在于找寻字串的每个字符位置的最大公共前后缀长度
     * π(i) 代表的是 从0-i这个字符串最大的公共前后缀长度，某种意义上，它刚好等于前缀的最大索引可以通过画图得到结果
     */
    public int strStr2(String haystack, String needle) {
        int[] next = getNextStr2(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                if (j == needle.length()) {
                    return i - needle.length() + 1;
                }
            } else {
                while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                    j = next[j - 1];
                }
                if (haystack.charAt(i) == needle.charAt(j)) {
                    j++;
                    if (j == needle.length()) {
                        return i - needle.length() + 1;
                    }
                }
            }
        }
        return -1;
    }

    public int strStr3(String haystack, String needle) {
        int[] next = getNextStr3(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    public int[] getNextStr(String str) {
        int[] next = new int[str.length()];
        next[0] = 0;
        for (int i = 1; i < str.length(); i++) {
            next[i] = getIndexStrLength(str.substring(0, i + 1));
        }
        return next;
    }

    public int[] getNextStr2(String str) {
        int[] next = new int[str.length()];
        next[0] = 0;
        int k = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(k) == str.charAt(i)) {
                k++;
                next[i] = k;
            } else {
                while (k > 0 && str.charAt(k) != str.charAt(i)) {
                    k = next[k - 1];
                }
                if (str.charAt(k) == str.charAt(i)) {
                    k++;
                    next[i] = k;
                } else {
                    next[i] = 0;
                }
            }
        }
        return next;
    }

    public int[] getNextStr3(String str) {
        int[] next = new int[str.length()];
        next[0] = 0;
        int k = 0;
        for (int i = 1; i < str.length(); i++) {
            while (k > 0 && str.charAt(k) != str.charAt(i)) {
                k = next[k - 1];
            }
            if (str.charAt(k) == str.charAt(i)) {
                k++;
                next[i] = k;
            } else {
                next[i] = 0;
            }
        }
        return next;
    }

    private int getIndexStrLength(String str) {
        int maxNextLength = str.length() - 1;
        for (int j = maxNextLength; j >= 0; j--) {
            boolean success = true;
            for (int k = 0, l = str.length() - j; k < j; k++, l++) {
                char prefixChar = str.charAt(k);
                char suffixChar = str.charAt(l);
                if (prefixChar != suffixChar) {
                    success = false;
                    break;
                }
            }
            if (success) {
                return j;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Class_3_StrStr28 class_3_strStr28 = new Class_3_StrStr28();
        int i1 = class_3_strStr28.strStr2("mississippi", "issip");
        System.out.println(i1);
    }
}
