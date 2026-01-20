class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            ans[i] = -1; // default

            for (int y = 0; y <= x; y++) {
                if ((y | (y + 1)) == x) {
                    ans[i] = y;  // first (smallest) valid y
                    break;
                }
            }
        }
        return ans;
    }
}
