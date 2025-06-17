package cn.liulin.leetcode.fixedwindows.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 3439. 重新安排会议得到最多空余时间 I
 *
 * @author liulin
 * @date 2025-03-03 10:36:19
 */
public class Class_12_MaxFreeTime3439 {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == 0 && startTime[i] > 0) {
                list.add(startTime[i]);
            }
            if (i > 0) {
                list.add(startTime[i] - endTime[i - 1]);
            }
            if (i == n - 1 && endTime[i] < eventTime) {
                list.add(eventTime - endTime[i]);
            }
        }
        if (list.isEmpty()) {
            return 0;
        }
        if (k + 1 >= list.size()) {
            return list.stream().mapToInt(Integer::intValue).sum();
        }
        int sum = 0;
        for (int i = 0; i < k + 1; i++) {
            sum += list.get(i);
        }
        int maxSum = sum;
        for (int i = k + 1; i < list.size(); i++) {
            sum = sum - list.get(i - k - 1) + list.get(i);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public int maxFreeTime2(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        List<Integer> list = new ArrayList<>();
        list.add(startTime[0]);
        for (int i = 0; i < n - 1; i++) {
            list.add(startTime[i + 1] - endTime[i]);
        }
        list.add(eventTime - endTime[n - 1]);
        if (k + 1 >= list.size()) {
            return list.stream().mapToInt(Integer::intValue).sum();
        }
        int sum = 0;
        for (int i = 0; i < k + 1; i++) {
            sum += list.get(i);
        }
        int maxSum = sum;
        for (int i = k + 1; i < list.size(); i++) {
            sum = sum - list.get(i - k - 1) + list.get(i);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        new Class_12_MaxFreeTime3439().maxFreeTime(34, 2, new int[] {0, 17}, new int[] {14, 19});
    }
}
