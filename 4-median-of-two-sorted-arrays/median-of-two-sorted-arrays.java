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

// OPTIMIZED CODE USING BINARY SERACH FOR CUT

// 1. Binary search the smaller array.
// 2. Pick a partition in it.
// 3. Calculate the required partition in the other array.
// 4. Check: left1 <= right2 AND left2 <= right1.
// 5. Move binary search left/right until the partition is correct.

// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {

//         // Always binary search on the smaller array
//         if (nums1.length > nums2.length) {
//             return findMedianSortedArrays(nums2, nums1);
//         }

//         int m = nums1.length;
//         int n = nums2.length;

//         int low = 0;
//         int high = m;

//         while (low <= high) {

//             // Partition of nums1
//             int cut1 = (low + high) / 2;

//             // Partition of nums2
//             int cut2 = (m + n + 1) / 2 - cut1;

//             // Elements just left/right of partition
//             int left1  = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
//             int right1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];

//             int left2  = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
//             int right2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

//             // Correct partition
//             if (left1 <= right2 && left2 <= right1) {

//                 // Odd total length
//                 if ((m + n) % 2 == 1) {
//                     return Math.max(left1, left2);
//                 }

//                 // Even total length
//                 return (Math.max(left1, left2)
//                         + Math.min(right1, right2)) / 2.0;
//             }

//             // Too many elements taken from nums1
//             if (left1 > right2) {
//                 high = cut1 - 1;
//             }

//             // Too few elements taken from nums1
//             else {
//                 low = cut1 + 1;
//             }
//         }

//         return 0.0;
//     }
// }