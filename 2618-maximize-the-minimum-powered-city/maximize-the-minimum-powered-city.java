class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] power = new long[n];
        
        // Step 1: Precompute power of each city (sliding window sum)
        long windowSum = 0;
        for (int i = 0; i < n; i++) {
            windowSum += stations[i];
            if (i - (2 * r + 1) >= 0) {
                windowSum -= stations[i - (2 * r + 1)];
            }
            power[i] = windowSum;
        }

        // Adjust using prefix sum for exact power of each city
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + stations[i];
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - r);
            int right = Math.min(n - 1, i + r);
            power[i] = prefix[right + 1] - prefix[left];
        }

        // Binary search on the answer
        long left = 0, right = (long) 1e18, ans = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (canAchieve(power, n, r, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean canAchieve(long[] power, int n, int r, long k, long target) {
        long[] diff = new long[n + 1];
        long add = 0, totalAdded = 0;
        long[] curr = power.clone();

        for (int i = 0; i < n; i++) {
            add += diff[i];
            curr[i] += add;

            if (curr[i] < target) {
                long need = target - curr[i];
                totalAdded += need;
                if (totalAdded > k) return false;

                add += need;
                int end = i + 2 * r + 1;
                if (end < n) diff[end] -= need;
            }
        }
        return true;
    }
}
