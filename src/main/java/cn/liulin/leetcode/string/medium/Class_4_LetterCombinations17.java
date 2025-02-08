package cn.liulin.leetcode.string.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 *
 * @author liulin
 * @date 2025-02-08 11:00:48
 */
public class Class_4_LetterCombinations17 {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.isEmpty()) {
            return list;
        }
        list.add("");
        Map<Character, Character[]> map = new HashMap<>();
        map.put('2', new Character[] {'a', 'b', 'c'});
        map.put('3', new Character[] {'d', 'e', 'f'});
        map.put('4', new Character[] {'g', 'h', 'i'});
        map.put('5', new Character[] {'j', 'k', 'l'});
        map.put('6', new Character[] {'m', 'n', 'o'});
        map.put('7', new Character[] {'p', 'q', 'r', 's'});
        map.put('8', new Character[] {'t', 'u', 'v'});
        map.put('9', new Character[] {'w', 'x', 'y', 'z'});
        for (int i = 0; i < digits.length(); i++) {
            List<String> temp = new ArrayList<>();
            for (Character c : map.get(digits.charAt(i))) {
                for (String s : list) {
                    temp.add(s + c);
                }
            }
            list = temp;
        }
        return list;
    }

    public List<String> letterCombinations2(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.isEmpty()) {
            return list;
        }
        Map<Character, Character[]> map = new HashMap<>();
        map.put('2', new Character[] {'a', 'b', 'c'});
        map.put('3', new Character[] {'d', 'e', 'f'});
        map.put('4', new Character[] {'g', 'h', 'i'});
        map.put('5', new Character[] {'j', 'k', 'l'});
        map.put('6', new Character[] {'m', 'n', 'o'});
        map.put('7', new Character[] {'p', 'q', 'r', 's'});
        map.put('8', new Character[] {'t', 'u', 'v'});
        map.put('9', new Character[] {'w', 'x', 'y', 'z'});
        backtrack(list, map, digits, 0, new StringBuffer());
        return list;
    }

    private void backtrack(List<String> list, Map<Character, Character[]> map, String digits, int index, StringBuffer stringBuffer) {
        if (index == digits.length()) {
            list.add(stringBuffer.toString());
        } else {
            char digit = digits.charAt(index);
            Character[] characters = map.get(digit);
            for (int i = 0; i < characters.length; i++) {
                stringBuffer.append(characters[i]);
                backtrack(list, map, digits, index + 1, stringBuffer);
                // 这一手体现了作者对递归的完整理解，帅
                stringBuffer.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        new Class_4_LetterCombinations17().letterCombinations2("24");
    }
}
