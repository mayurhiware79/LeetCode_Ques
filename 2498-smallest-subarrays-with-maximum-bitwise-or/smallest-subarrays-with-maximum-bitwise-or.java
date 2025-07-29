//Approach (Using frequency count and Xor Property)
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] setBitIndex = new int[31]; //setBitIndex[j] = i, it means that jth bit can be set via element at index i in nums

        Arrays.fill(setBitIndex, -1);

        //nums[i] = binary rep
        for (int i = n - 1; i >= 0; i--) {
            int endIndex = i;
            for (int j = 0; j < 31; j++) {
                if ((nums[i] & (1 << j)) == 0) { //if jth bit is not set
                    if (setBitIndex[j] != -1) {
                        endIndex = Math.max(endIndex, setBitIndex[j]);
                    }
                } else {
                    setBitIndex[j] = i;
                }
            }
            result[i] = endIndex - i + 1;
        }

        return result;
    }
}