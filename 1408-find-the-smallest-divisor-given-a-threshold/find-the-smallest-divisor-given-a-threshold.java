class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = getMax(nums);

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (computeSum(nums, mid) > threshold) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // Helper to get max element from array
    private int getMax(int[] nums) {
        int max = nums[0];
        for (int n : nums) {
            max = Math.max(max, n);
        }
        return max;
    }

    // Helper to compute the sum of ceil(num / divisor)
    private int computeSum(int[] nums, int divisor) {
        int sum = 0;
        for (int n : nums) {
            sum += (n + divisor - 1) / divisor;  // ceil(n / divisor)
        }
        return sum;
    }
}
