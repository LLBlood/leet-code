package cn.liulin.leetcode.dynamic.simple;

import java.util.Arrays;
import java.util.Collections;

/**
 * 1668. 最大重复子字符串
 *
 * @author liulin
 * @date 2025-02-20 14:25:22
 */
public class Class_3_MaxRepeating1668 {
    public int maxRepeating(String sequence, String word) {
        int k = 0;
        String temp = word;
        while (contains(sequence, temp)) {
            k++;
            temp += word;
        }
        return k;
    }

    private boolean contains(String sequence, String word) {
        // KMP算法，找word的next数组
        int[] next = getNext(word);
        int k = 0;
        for (int i = 0; i < sequence.length(); i++) {
            while (k > 0 && sequence.charAt(i) != word.charAt(k)) {
                k = next[k - 1];
            }
            if (sequence.charAt(i) == word.charAt(k)) {
                k++;
            }
            if (k == word.length()) {
                return true;
            }
        }
        return false;
    }

    private int[] getNext(String word) {
        int[] next = new int[word.length()];
        next[0] = 0;
        int k = 0;
        for (int i = 1; i < word.length(); i++) {
            while (k > 0 && word.charAt(i) != word.charAt(k)) {
                k = next[k - 1];
            }
            if (word.charAt(i) == word.charAt(k)) {
                k++;
            }
            next[i] = k;
        }
        return next;
    }

    public static void main(String[] args) {
        int i = new Class_3_MaxRepeating1668().maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba");
    }

    /**
     * 动态规划+KMP
     * @param sequence
     * @param word
     * @return
     */
    public int maxRepeating2(String sequence, String word) {
        int n = sequence.length();
        int m = word.length();
        if (n < m) {
            return 0;
        }
        int[] f = new int[n];
        int[] next = new int[m];
        int k = 0;
        next[0] = 0;
        for (int i = 1; i < m; i++) {
            while (k > 0 && word.charAt(i) != word.charAt(k)) {
                k = next[k - 1];
            }
            if (word.charAt(i) == word.charAt(k)) {
                k++;
            }
            next[i] = k;
        }
        int z = 0;
        for (int i = 0; i < n; i++) {
            while (z > 0 && sequence.charAt(i) != word.charAt(z)) {
                z = next[z - 1];
            }
            if (sequence.charAt(i) == word.charAt(z)) {
                z++;
                if (z == m) {
                    f[i] = (i == m - 1 ? 0 : f[i - m]) + 1;
                    z = next[z - 1];
                }
            }
        }
        return Arrays.stream(f).max().getAsInt();
    }

}
