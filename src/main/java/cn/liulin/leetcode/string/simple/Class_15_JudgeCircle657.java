package cn.liulin.leetcode.string.simple;

/**
 * 657. 机器人能否返回原点
 *
 * @author liulin
 * @date 2025-02-11 13:48:21
 */
public class Class_15_JudgeCircle657 {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'R') {
                x++;
            } else if (c == 'L') {
                x--;
            } else if (c == 'U') {
                y++;
            } else if (c == 'D') {
                y--;
            }
        }
        return x == 0 && y == 0;
    }
}
