// approach 1 - stimulated as it is - iteratively

// class Solution {
//     public int triangularSum(int[] nums) {
//         int n=nums.length;

//         for(int len =n; len > 1;len--){
//             for(int i=0; i< len-1;i++){
//                 nums[i]=(nums[i] + nums[i+1]) % 10;
//             }
//         }
//         return nums[0];
//     }
// }

// Pascal-row implementation (O(n²) time, O(n) space)

class Solution {
    public int triangularSum(int[] nums){
        int n = nums.length;
        if(n==1) return nums[0];

        int[] C = new int[n];
        C[0] = 1;
        for(int i=1; i<=n-1 ; i++){
            for(int j=i; j > 0; j--){
                C[j]= (C[j] + C[j-1]) % 10;
            }
        }

        int ans = 0;
        for(int i=0; i<n ; i++){
            ans = (ans + C[i] * nums[i]) % 10;
        }

        return ans;
    }
}