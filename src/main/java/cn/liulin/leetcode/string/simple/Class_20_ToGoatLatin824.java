package cn.liulin.leetcode.string.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * 824. 山羊拉丁文
 *
 * @author liulin
 * @date 2025-02-14 09:58:00
 */
public class Class_20_ToGoatLatin824 {
    public String toGoatLatin(String sentence) {
        Set<Character> characters = new HashSet<>();
        characters.add('a');
        characters.add('e');
        characters.add('i');
        characters.add('o');
        characters.add('u');

        String[] s = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            String s1 = s[i];
            if (characters.contains(Character.toLowerCase(s1.charAt(0)))) {
                sb.append(s1).append("ma");
            } else {
                for (int j = 1; j < s1.length(); j++) {
                    sb.append(s1.charAt(j));
                }
                sb.append(s1.charAt(0)).append("ma");
            }
            for (int j = 0; j < i + 1; j++) {
                sb.append("a");
            }
            if (i != s.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
