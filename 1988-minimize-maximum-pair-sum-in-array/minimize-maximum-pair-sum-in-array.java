class Solution {
    public int minPairSum(int[] nums) {
        // sorting the array
        Arrays.sort(nums);

        int maxSum = 0;
        int i = 0;
        int j= nums.length - 1;

        // pairing smallest with largest
        while(i < j){
            int pairSum = nums[i]+nums[j];
            maxSum = Math.max(maxSum, pairSum);
            i++;
            j--;
        }

        return maxSum;
    }
}