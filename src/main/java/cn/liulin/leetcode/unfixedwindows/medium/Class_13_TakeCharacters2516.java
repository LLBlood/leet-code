package cn.liulin.leetcode.unfixedwindows.medium;

/**
 * 2516. 每种字符至少取 K 个
 *
 * @author liulin
 * @version 1.0
 * @date 2025/7/1 17:35
 */
public class Class_13_TakeCharacters2516 {
    public int takeCharacters(String s, int k) {
        int[] arr = new int[3];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            arr[aChar - 'a']++;
        }
        for (int i : arr) {
            if (i < k) {
                return -1;
            }
        }
        int left = 0;
        int ans = arr[0] + arr[1] + arr[2];
        for (int right = 0; right < chars.length; right++) {
            arr[chars[right] - 'a']--;
            while (arr[chars[right] - 'a'] < k) {
                arr[chars[left] - 'a']++;
                left++;
            }
            ans = Math.min(ans, s.length() - (right - left + 1));
        }
        return ans;
    }
}
