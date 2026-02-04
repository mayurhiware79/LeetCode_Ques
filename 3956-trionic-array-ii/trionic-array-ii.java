class Solution {
    public long maxSumTrionic(int[] nums) {

        long NEG = (long) -1e17;

        long ans = (long) -1e18;
        long prev = nums[0];
        int n = nums.length;

        // a = increasing
        // b = decreasing
        // c = increasing again (trionic complete)
        long a = NEG, b = NEG, c = NEG;

        for (int i = 1; i < n; i++) {

            long newA = NEG;
            long newB = NEG;
            long newC = NEG;

            long curr = nums[i];

            if (curr > prev) {
                // extend/start increasing
                newA = Math.max(a, prev) + curr;

                // extend/start final increasing
                newC = Math.max(b, c) + curr;
            }
            else if (curr < prev) {
                // extend/start decreasing
                newB = Math.max(b, a) + curr;
            }

            a = newA;
            b = newB;
            c = newC;

            ans = Math.max(ans, c);
            prev = curr;
        }

        return ans;
    }
}
