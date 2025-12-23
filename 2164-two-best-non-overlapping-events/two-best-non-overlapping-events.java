class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;

        // Sort events by start time
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        // Suffix max array
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = events[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], events[i][2]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            // Option 1: take only this event
            ans = Math.max(ans, events[i][2]);

            // Option 2: take this + another non-overlapping event
            int nextIndex = findNextEvent(events, events[i][1] + 1);
            if (nextIndex < n) {
                ans = Math.max(ans, events[i][2] + suffixMax[nextIndex]);
            }
        }

        return ans;
    }

    // Binary search for first event with startTime >= target
    private int findNextEvent(int[][] events, int target) {
        int left = 0, right = events.length - 1;
        int res = events.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (events[mid][0] >= target) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
