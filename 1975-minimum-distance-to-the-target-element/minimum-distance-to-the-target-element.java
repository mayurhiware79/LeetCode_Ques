class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int minDist = Integer.MAX_VALUE;

        for(int i=nums.length-1; i>= 0;i--){
            if(nums[i] == target){
                minDist = Math.min(minDist, Math.abs(i - start));
            }
        }
        return minDist;
    }
}