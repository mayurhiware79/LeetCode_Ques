class Solution {
    public long maxAlternatingSum(int[] nums) {
        Arrays.sort(nums); // We will instead sort boxed integers by abs below
        Integer[] a = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(a, (x, y) ->
            Long.compare(Math.abs((long) x), Math.abs((long) y))
        );

        long ans = 0;
        int n = a.length;

        for (int i = 0; i < n; i++) {
            long x = a[i];
            long square = x * x;

            if (i < n / 2) {
                ans -= square;
            } else {
                ans += square;
            }
        }

        return ans;
    }
}
