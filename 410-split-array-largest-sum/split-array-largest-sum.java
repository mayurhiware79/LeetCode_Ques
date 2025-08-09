class Solution {
    public int splitArray(int[] nums, int k) {
        // Define search space
        int low = 0, high = 0;
        for (int num : nums) {
            low = Math.max(low, num); // max element
            high += num;              // total sum
        }

        // Binary search for the minimal largest sum
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int parts = countSubarrays(nums, mid);

            if (parts > k) { 
                // Too many parts → need bigger max sum
                low = mid + 1;
            } else { 
                // Can do with mid or smaller
                high = mid - 1;
            }
        }
        return low;
    }

    // Counts how many subarrays we need if max allowed sum is 'maxSum'
    private int countSubarrays(int[] nums, int maxSum) {
        int count = 1; // at least one subarray
        long currentSum = 0;

        for (int num : nums) {
            if (currentSum + num <= maxSum) {
                currentSum += num;
            } else {
                count++;
                currentSum = num;
            }
        }
        return count;
    }
}
