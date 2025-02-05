package cn.liulin.leetcode.string.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 *
 * @author liulin
 * @date 2025-02-05 14:12:36
 */
public class Class_5_FizzBuzz412 {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            if (sb.length() == 0) {
                sb.append(i);
            }
            result.add(sb.toString());
        }
        return result;
    }
}
