// class Solution {
//     public int findGCD(int[] nums) {
//         Arrays.sort(nums);
//         int a = nums[0];
//         int b = nums[nums.length-1];

//         while (b != 0) {
//             int temp = b;
//             b = a % b;
//             a = temp;
//         }
//         return Math.abs(a); // Returns positive GCD even for negative inputs
//     }

// }

class Solution {

    public int findGCD(int[] nums) {

        int min = nums[0];
        int max = nums[0];

        
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < min) {
                min = nums[i];
            }

            if (nums[i] > max) {
                max = nums[i];
            }
        }

        return gcd(min, max);
    }

    public int gcd(int a, int b) {

        while (b != 0) {

            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
