class Solution {
    public int numDecodings(String s) {
        if ("0".equals(s) || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length()];
        if (s.charAt(0) != '0') {
            dp[0] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0' && (s.charAt(i - 1) > '2' || s.charAt(i - 1) == '0')) {
                return 0;
            } else if (s.charAt(i) == '0' && (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2')) {
                if (i > 1) {
                    dp[i] = dp[i - 2];
                } else {
                    dp[i] = 1;
                }
            } else if ((s.charAt(i - 1) == '2' && s.charAt(i) > '0' && s.charAt(i) <= '6') || (s.charAt(i - 1) == '1')) {
                if (i > 1) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length() - 1];
    }
}
