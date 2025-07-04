package cn.liulin.leetcode.unfixedwindows.medium;

import java.util.*;

/**
 * @author liulin
 * @version 1.0
 * @date 2025/7/1 18:06
 */
public class Class_14_LongestEqualSubarray2831 {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            if (map.containsKey(nums.get(i))) {
                map.get(nums.get(i)).add(i);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(nums.get(i), temp);
            }
        }
        int ans = 1;
        for (Map.Entry<Integer, List<Integer>> integerListEntry : map.entrySet()) {
            List<Integer> value = integerListEntry.getValue();
            int left = 0;
            int cost = 0;
            for (int right = 1; right < value.size(); right++) {
                cost += value.get(right) - value.get(right - 1) - 1;
                while (cost > k) {
                    cost -= value.get(left + 1) - value.get(left) - 1;
                    left++;
                }
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans;

    }


    public int longestEqualSubarray2(List<Integer> nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            if (map.containsKey(nums.get(i))) {
                map.get(nums.get(i)).add(i);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(nums.get(i), temp);
            }
        }
        int ans = 0;
        for (Map.Entry<Integer, List<Integer>> integerListEntry : map.entrySet()) {
            List<Integer> value = integerListEntry.getValue();
            int left = 0;
            for (int right = 0; right < value.size(); right++) {
                while (value.get(right) - value.get(left) - (right - left) > k) {
                    left++;
                }
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans;

    }

    public int longestEqualSubarray3(List<Integer> nums, int k) {
        int n = nums.size();
        List<Integer>[] posLists = new ArrayList[n + 1];
        Arrays.setAll(posLists, i -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            posLists[x].add(i - posLists[x].size());
        }

        int ans = 0;
        for (List<Integer> pos : posLists) {
            if (pos.size() <= ans) {
                continue; // 无法让 ans 变得更大
            }
            int left = 0;
            for (int right = 0; right < pos.size(); right++) {
                while (pos.get(right) - pos.get(left) > k) { // 要删除的数太多了
                    left++;
                }
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new Class_14_LongestEqualSubarray2831().longestEqualSubarray(Arrays.asList(1,1,2,2,1,1), 2);
    }
}
