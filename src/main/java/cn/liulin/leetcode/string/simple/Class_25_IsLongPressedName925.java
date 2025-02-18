package cn.liulin.leetcode.string.simple;

/**
 * 925. 长按键入
 *
 * @author liulin
 * @date 2025-02-18 17:09:16
 */
public class Class_25_IsLongPressedName925 {
    public boolean isLongPressedName(String name, String typed) {
        if (typed.length() < name.length()) {
            return false;
        }
        int nameIndex = 0;
        int typedIndex = 0;
        int count = 0;
        while (nameIndex < name.length() && typedIndex < typed.length()) {
            char temp = name.charAt(nameIndex);
            while (nameIndex < name.length() && name.charAt(nameIndex) == temp) {
                count++;
                nameIndex++;
            }
            while (typedIndex < typed.length() && typed.charAt(typedIndex) == temp) {
                count--;
                typedIndex++;
            }
            if (count > 0) {
                return false;
            }
            count = 0;
        }
        return nameIndex == name.length() && typedIndex == typed.length();
    }

    public boolean isLongPressedName2(String name, String typed) {
        if (typed.length() < name.length()) {
            return false;
        }
        int nameIndex = 0;
        int typedIndex = 0;
        while (typedIndex < typed.length()) {
            if (nameIndex < name.length() && name.charAt(nameIndex) == typed.charAt(typedIndex)) {
                nameIndex++;
                typedIndex++;
            } else if (typedIndex > 0 && typed.charAt(typedIndex - 1) == typed.charAt(typedIndex)) {
                typedIndex++;
            } else {
                return false;
            }
        }
        return nameIndex == name.length();
    }
}
