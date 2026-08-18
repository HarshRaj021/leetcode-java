class Solution {
    public int countTexts(String pressedKeys) {
        int MOD = 1000000007;
        int n = pressedKeys.length();

        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {

            // One press
            dp[i] = dp[i - 1];

            // Two presses
            if (i >= 2 && pressedKeys.charAt(i - 1) == pressedKeys.charAt(i - 2)) {
                dp[i] += dp[i - 2];
            }

            // Three presses
            if (i >= 3 &&
                pressedKeys.charAt(i - 1) == pressedKeys.charAt(i - 2) &&
                pressedKeys.charAt(i - 2) == pressedKeys.charAt(i - 3)) {
                dp[i] += dp[i - 3];
            }

            // Four presses for 7 and 9
            if (i >= 4 &&
                (pressedKeys.charAt(i - 1) == '7' ||
                 pressedKeys.charAt(i - 1) == '9')) {

                if (pressedKeys.charAt(i - 1) == pressedKeys.charAt(i - 2) &&
                    pressedKeys.charAt(i - 2) == pressedKeys.charAt(i - 3) &&
                    pressedKeys.charAt(i - 3) == pressedKeys.charAt(i - 4)) {

                    dp[i] += dp[i - 4];
                }
            }

            dp[i] %= MOD;
        }

        return (int) dp[n];
    }
}