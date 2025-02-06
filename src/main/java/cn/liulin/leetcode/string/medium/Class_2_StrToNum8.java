package cn.liulin.leetcode.string.medium;


import java.util.HashMap;
import java.util.Map;

/**
 * 8. 字符串转换整数 (atoi)
 *
 * @author liulin
 * @date 2025-02-06 14:07:01
 */
public class Class_2_StrToNum8 {
    public int myAtoi(String s) {
        int result = 0;
        int bits = 0;
        for (int i = 0; i < s.length(); i++) {
            if (bits == 0) {
                if (s.charAt(i) == ' ') {
                    continue;
                } else if (s.charAt(i) == '-') {
                    bits = -1;
                } else if (s.charAt(i) == '+') {
                    bits = 1;
                } else if (Character.isDigit(s.charAt(i))) {
                    bits = 1;
                    result = s.charAt(i) - '0';
                } else {
                    return result;
                }
            } else {
                if (!Character.isDigit(s.charAt(i))) {
                    return result;
                }
                int value = s.charAt(i) - '0';
                if (bits > 0) {
                    if ((Integer.MAX_VALUE - value) / 10 < result) {
                        return Integer.MAX_VALUE;
                    }
                    result = result * 10 + value;
                } else {
                    if ((Integer.MIN_VALUE + value) / 10 > result) {
                        return Integer.MIN_VALUE;
                    }
                    result = result * 10 - value;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int i = new Class_2_StrToNum8().myAtoi("42");
        System.out.println(i);
    }

    public int myAtoi2(String s) {
        Automaton automaton = new Automaton();
        for (char c : s.toCharArray()) {
            automaton.get(c);
        }
        return (int) (automaton.getSign() * automaton.getAns());
    }
}

/**
 * 自动机
 * 对应表格如下
 *              ' '     -/+     number      other
 * start        start   signed  int_number  end
 * signed       end     end     int_number  end
 * int_number   end     end     int_number  end
 * end          end     end     end         end
 */
class Automaton {
    private int sign = 1;
    private long ans = 0;
    private String state = "start";

    public int getSign() {
        return sign;
    }

    public long getAns() {
        return ans;
    }

    private Map<String, String[]> table = new HashMap<>();
    {
        table.put("start", new String[] {"start", "signed", "int_number", "end"});
        table.put("signed", new String[] {"end", "end", "int_number", "end"});
        table.put("int_number", new String[] {"end", "end", "int_number", "end"});
        table.put("end", new String[] {"end", "end", "end", "end"});
    }

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        } else if ("int_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long)Integer.MIN_VALUE);
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '-' || c == '+') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}
