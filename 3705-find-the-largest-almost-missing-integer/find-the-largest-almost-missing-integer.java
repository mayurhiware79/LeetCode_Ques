class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        // Case 1
        if (k == 1) {
            HashMap<Integer, Integer> freq = new HashMap<>();

            for (int x : nums) {
                freq.put(x, freq.getOrDefault(x, 0) + 1);
            }

            int ans = -1;

            for (int x : nums) {
                if (freq.get(x) == 1) {
                    ans = Math.max(ans, x);
                }
            }

            return ans;
        }

        // Case 2
        if (k == n) {
            int ans = nums[0];

            for (int x : nums) {
                ans = Math.max(ans, x);
            }

            return ans;
        }

        // Case 3
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        boolean firstUnique = freq.get(nums[0]) == 1;
        boolean lastUnique = freq.get(nums[n - 1]) == 1;

        if (firstUnique && lastUnique) {
            return Math.max(nums[0], nums[n - 1]);
        }

        if (firstUnique) {
            return nums[0];
        }

        if (lastUnique) {
            return nums[n - 1];
        }

        return -1;
    }
}