package cn.liulin.leetcode.string.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 884. 两句话中的不常见单词
 *
 * @author liulin
 * @date 2025-02-17 10:10:38
 */
public class Class_23_UncommonFromSentences884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] strArr1 = s1.split(" ");
        String[] strArr2 = s2.split(" ");
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (String s : strArr1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        for (String s : strArr2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : map1.entrySet()) {
            String key = stringIntegerEntry.getKey();
            Integer value = stringIntegerEntry.getValue();
            if (value == 1) {
                if (!map2.containsKey(key)) {
                    list.add(key);
                }
            }
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : map2.entrySet()) {
            String key = stringIntegerEntry.getKey();
            Integer value = stringIntegerEntry.getValue();
            if (value == 1) {
                if (!map1.containsKey(key)) {
                    list.add(key);
                }
            }
        }
        return list.toArray(new String[0]);
    }

    public String[] uncommonFromSentences2(String s1, String s2) {
        String[] strArr1 = s1.split(" ");
        String[] strArr2 = s2.split(" ");
        Map<String, Integer> map1 = new HashMap<>();
        for (String s : strArr1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        for (String s : strArr2) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : map1.entrySet()) {
            String key = stringIntegerEntry.getKey();
            Integer value = stringIntegerEntry.getValue();
            if (value == 1) {
                list.add(key);
            }
        }
        return list.toArray(new String[0]);
    }
}
