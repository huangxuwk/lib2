package src.com.jd.leetcode.textI;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        char[] cs = s.toCharArray();
        int[] dp = new int[length];
        int max = 0;
        for (int i = 1; i < length; i++) {
            if (cs[i] == ')') {
                if (cs[i - 1] == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && cs[i - dp[i - 1] - 1] == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
