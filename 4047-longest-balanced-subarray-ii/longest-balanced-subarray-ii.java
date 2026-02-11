// Approach - 2 (Using Segment Tree with Range Min/Max Query)
// Time Complexity  : O(n log n)
// Space Complexity : O(n)

class Solution {

    // segMin[i] = minimum value in this segment
    // segMax[i] = maximum value in this segment
    // lazy[i]   = pending updates for lazy propagation
    int[] segMin, segMax, lazy;
    int n;

    // Apply any pending lazy update to current node
    void propagate(int i, int l, int r) {

        // If there is some pending update
        if (lazy[i] != 0) {

            // Add lazy value to both min and max
            segMin[i] += lazy[i];
            segMax[i] += lazy[i];

            // If not a leaf node, pass update to children
            if (l != r) {
                lazy[2 * i + 1] += lazy[i];
                lazy[2 * i + 2] += lazy[i];
            }

            // Clear lazy value for this node
            lazy[i] = 0;
        }
    }

    // Add 'val' to range [start, end]
    void updateRange(int start, int end, int i, int l, int r, int val) {

        // First apply any pending updates
        propagate(i, l, r);

        // No overlap
        if (l > end || r < start) return;

        // Complete overlap
        if (l >= start && r <= end) {
            lazy[i] += val;
            propagate(i, l, r);
            return;
        }

        // Partial overlap → go deeper
        int mid = (l + r) / 2;

        updateRange(start, end, 2 * i + 1, l, mid, val);
        updateRange(start, end, 2 * i + 2, mid + 1, r, val);

        // Update current node using children values
        segMin[i] = Math.min(segMin[2 * i + 1], segMin[2 * i + 2]);
        segMax[i] = Math.max(segMax[2 * i + 1], segMax[2 * i + 2]);
    }

    // Find leftmost index where value becomes 0
    int findLeftMostZero(int i, int l, int r) {

        propagate(i, l, r);

        // If entire segment is strictly positive or strictly negative
        // then 0 cannot exist here
        if (segMin[i] > 0 || segMax[i] < 0)
            return -1;

        // If leaf node and contains zero
        if (l == r)
            return l;

        int mid = (l + r) / 2;

        // Try left side first (to get leftmost index)
        int left = findLeftMostZero(2 * i + 1, l, mid);
        if (left != -1)
            return left;

        // Otherwise check right side
        return findLeftMostZero(2 * i + 2, mid + 1, r);
    }

    public int longestBalanced(int[] nums) {

        n = nums.length;

        // Allocate segment tree arrays
        segMin = new int[4 * n];
        segMax = new int[4 * n];
        lazy   = new int[4 * n];

        int maxLength = 0;

        // Store last occurrence of each number
        Map<Integer, Integer> map = new HashMap<>();

        for (int r = 0; r < n; r++) {

            // If even → +1
            // If odd  → -1
            int val = (nums[r] % 2 == 0) ? 1 : -1;

            // Check if number appeared before
            int prev = map.getOrDefault(nums[r], -1);

            // If duplicate found, remove its old contribution
            if (prev != -1) {
                updateRange(0, prev, 0, 0, n - 1, -val);
            }

            // Add new contribution up to current index
            updateRange(0, r, 0, 0, n - 1, val);

            // Check if any prefix becomes 0
            int l = findLeftMostZero(0, 0, n - 1);

            // If found, update answer
            if (l != -1) {
                maxLength = Math.max(maxLength, r - l + 1);
            }

            // Update last occurrence
            map.put(nums[r], r);
        }

        return maxLength;
    }
}
