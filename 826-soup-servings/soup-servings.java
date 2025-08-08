class Solution {
    private final int[][] SERVES = {
        {100, 0},
        {75, 25},
        {50, 50},
        {25, 75}
    };

    private double[][] memo;

    public double soupServings(int n) {
        // Optimization trick: for large n, result approaches 1
        if (n >= 5000)
            return 1.0;

        memo = new double[n + 1][n + 1];
        for (double[] row : memo) {
            Arrays.fill(row, -1.0);
        }

        return helper(n, n);
    }

    private double helper(int A, int B) {
        if (A <= 0 && B <= 0)
            return 0.5;
        if (A <= 0)
            return 1.0;
        if (B <= 0)
            return 0.0;

        if (memo[A][B] != -1.0)
            return memo[A][B];

        double prob = 0.0;

        for (int[] serve : SERVES) {
            prob += 0.25 * helper(A - serve[0], B - serve[1]);
        }

        memo[A][B] = prob;
        return prob;
    }
}
