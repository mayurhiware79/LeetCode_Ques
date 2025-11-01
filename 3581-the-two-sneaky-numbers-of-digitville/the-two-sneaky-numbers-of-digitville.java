class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        // int result[]= new int[2];
        // int j=0;
        // Arrays.sort(nums);
        // for(int i=1;i<=nums.length-1;i++){
        //     if(nums[i] == nums[i-1]){
        //         result[j++]=nums[i];
        //     }
        // }
        // return result;

        int[] ans = new int[2];
        int[] freq = new int[nums.length];
        int k = 0;
        for(int num : nums) {
            freq[num]++;
            if(freq[num] == 2) {
              ans[k] = num;
              k++;
            }
        }
        return ans;
    }
}