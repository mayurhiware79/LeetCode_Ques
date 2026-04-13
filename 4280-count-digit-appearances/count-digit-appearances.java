class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int cnt = 0;
        char d = (char)(digit + '0');

        for (int i = 0; i < nums.length; i++) {
            String curr = String.valueOf(nums[i]);
            
            for (char c : curr.toCharArray()) {
                if (c == d) {
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}