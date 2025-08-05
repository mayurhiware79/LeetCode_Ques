class Solution {
    public int maxJump(int[] stones) {
        int max =0;

        //jump eveyr 2 stones (simulate skipping)
        for(int i=2;i < stones.length; i++){
            max = Math.max(max, stones[i] - stones[i-2]);
        }

        //include first jump : stone[0] -> stone[1]
        max = Math.max(max, stones[1] -  stones[0]);
        
        return max;
    }
}