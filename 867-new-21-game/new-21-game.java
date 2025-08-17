class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0) return 1.0; 
        if (n >= k + maxPts - 1) return 1.0;

        double[] dp = new double[n + 1];
        dp[0] = 1.0;

        double windowSum = 1.0;
        double result = 0.0;

        for (int i = 1; i <= n; i++) {
            dp[i] = windowSum / maxPts;

            if (i < k) {
                // still drawing → add to sliding window
                windowSum += dp[i];
            } else {
                // stopped drawing → valid final score
                result += dp[i];
            }

            // shrink sliding window when it exceeds maxPts
            if (i - maxPts >= 0) {
                windowSum -= dp[i - maxPts];
            }
        }

        return result;
    }
}
