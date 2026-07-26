class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        int option1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int option2 = nums[0] * nums[1] * nums[n - 1];

        return Math.max(option1, option2);
    }
}


// class Solution {
//     public int maximumProduct(int[] nums) {

//         // Below approch is wordking ---> ONLY for POSITIVE nums

//         int n=nums.length;
//         if(n==0) return 0;
//         if(n == 1) {
//             return nums[0];
//         }else if(n == 2){
//             return nums[0]*nums[1];
//         }
//         // Arrays.sort(nums);
//         // Arrays.sort(nums, (a,b) -> (Integer.compare( Math.abs(a),  Math.abs(b))));
//         // Arrays.sort(nums, Comparator.comparingInt(Math::abs));
        
//         // 3667 - Sort Array By Absolute Value

//         // Convert primitive int array to Stream        
//         nums = Arrays.stream(nums)
//             // Box each primitive int to Integer object for stream operations
//             .boxed()
//             // Sort elements by comparing their absolute values
//             .sorted(Comparator.comparingInt(Math::abs))
//             // Convert Integer objects back to primitive int values
//             .mapToInt(Integer::intValue)
//             // Collect the sorted stream into a new int array
//             .toArray();

//         int product = nums[n-3]*nums[n-2]*nums[n-1];
//         return product;
        
//     }
// }