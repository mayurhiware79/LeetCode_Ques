class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n=nums.length;

        List<Integer> miss = new ArrayList<>();
        
        Arrays.sort(nums);

        int expected=nums[0]; // starting with min
        int max= nums[n-1];
        int idx=0;
        while(expected <= max){
            if(nums[idx]==expected && idx < n){
                //arr madhe no. aahe
                idx++;
            }else {
                miss.add(expected);
            }
            expected++;

        }

        return miss;

    }
}