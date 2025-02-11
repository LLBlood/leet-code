package cn.liulin.leetcode.string.simple;

/**
 * 551. 学生出勤记录 I
 *
 * @author liulin
 * @date 2025-02-11 13:43:44
 */
public class Class_14_CheckRecord551 {
    public boolean checkRecord(String s) {
        int sumA = 0;
        int countL = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                sumA++;
                countL = 0;
            } else if (c == 'L') {
                countL++;
            } else {
                countL = 0;
            }
            if (sumA >= 2 || countL >= 3) {
                return false;
            }
        }
        return true;
    }
}
