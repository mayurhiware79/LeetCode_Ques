class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int[] arr = new int[m + n];

        // Copy nums1
        for (int i = 0; i < m; i++) {
            arr[i] = nums1[i];
        }

        // Copy nums2
        for (int i = 0; i < n; i++) {
            arr[m + i] = nums2[i];
        }

        // Sort combined array
        Arrays.sort(arr);

        int total = m + n;

        // Odd number of elements
        if (total % 2 == 1) {
            return arr[total / 2];
        }

        // Even number of elements
        return (arr[total / 2 - 1] + arr[total / 2]) / 2.0;
    }
}