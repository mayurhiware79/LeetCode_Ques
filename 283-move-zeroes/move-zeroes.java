class Solution {

    public void moveZeroes(int[] nums) {

        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            // If non-zero found
            if (nums[right] != 0) {

                // Swap
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
            }
        }
    }
}

// class Solution {

//     public void moveZeroes(int[] nums) {

//         int index = 0;

//         // Move non-zero values
//         for (int num : nums) {

//             if (num != 0) {
//                 nums[index++] = num;
//             }
//         }

//         // Fill remaining with zero
//         while (index < nums.length) {
//             nums[index++] = 0;
//         }
//     }
// }


// class Solution {

//     public void moveZeroes(int[] nums) {

//         int[] temp = new int[nums.length];
//         int index = 0;

//         // Store non-zero elements
//         for (int num : nums) {
//             if (num != 0) {
//                 temp[index++] = num;
//             }
//         }

//         // Copy back
//         for (int i = 0; i < nums.length; i++) {
//             nums[i] = temp[i];
//         }
//     }
// }