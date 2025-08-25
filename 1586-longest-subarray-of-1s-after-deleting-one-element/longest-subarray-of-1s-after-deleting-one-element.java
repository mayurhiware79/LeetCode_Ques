class Solution {
    public int longestSubarray(int[] nums) {
        //Sliding Window approach is best for this type of problems
        //Approach/intuition : 

        int left = 0,right, zeroCount =0;
        int maxLength = 0;
        for( right =0; right < nums.length; right++){
            if(nums[right] == 0) zeroCount++;

            while(zeroCount > 1){
                if(nums[left] == 0 ) zeroCount--;
                left++;
            }

            maxLength = Math.max(maxLength, right-left+1);
        }

        return maxLength-1; //skip one 1


    }
}