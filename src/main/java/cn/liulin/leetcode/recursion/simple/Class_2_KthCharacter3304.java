package cn.liulin.leetcode.recursion.simple;

/**
 * 3304. 找出第 K 个字符 I
 *
 * @author liulin
 * @date 2025-02-24 10:45:39
 */
public class Class_2_KthCharacter3304 {
    public char kthCharacter(int k) {
        String word = "a";
        return kthCharacter(word, k);
    }

    private char kthCharacter(String word, int k) {
        if (word.length() >= k) {
            return word.charAt(k - 1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(word);
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == 'z') {
                sb.append('a');
            } else {
                sb.append((char) (c + 1));
            }
        }
        return kthCharacter(sb.toString(), k);
    }
}
