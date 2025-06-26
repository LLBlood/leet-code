package cn.liulin.leetcode.unfixedwindows.medium;

/**
 * 2024. 考试的最大困扰度
 *
 * @author liulin
 * @version 1.0
 * @date 2025/6/26 9:31
 */
public class Class_7_MaxConsecutiveAnswers2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int ans = 0;
        int leftT = 0;
        int[] ansT = new int[answerKey.length()];
        int costT = 0;
        int leftF = 0;
        int[] ansF = new int[answerKey.length()];
        int costF = 0;
        for (int right = 0; right < answerKey.length(); right++) {
            if ('F' == answerKey.charAt(right)) {
                costT += 1;
                ansT[right]++;
                while (costT > k) {
                    costT -= ansT[leftT];
                    leftT++;
                }
            }
            ans = Math.max(ans, right - leftT + 1);
            if ('T' == answerKey.charAt(right)) {
                costF += 1;
                ansF[right]++;
                while (costF > k) {
                    costF -= ansF[leftF];
                    leftF++;
                }
            }
            ans = Math.max(ans, right - leftF + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        new Class_7_MaxConsecutiveAnswers2024().maxConsecutiveAnswers("TFFT", 1);
    }

    public int maxConsecutiveAnswers2(String answerKey, int k) {
        return Math.max(maxConsecutiveChar(answerKey, k, 'T'), maxConsecutiveChar(answerKey, k, 'F'));
    }

    public int maxConsecutiveChar(String answerKey, int k, char ch) {
        int n = answerKey.length();
        int ans = 0;
        for (int left = 0, right = 0, sum = 0; right < n; right++) {
            sum += answerKey.charAt(right) != ch ? 1 : 0;
            while (sum > k) {
                sum -= answerKey.charAt(left++) != ch ? 1 : 0;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
