class Solution {
    public int reverseBits(int n) {
        int result=0;

        for(int i=0;i<32;i++){
            result = result << 1; // making space to add last bit
            result = result | (n & 1); // this adds last bit of n
            n >>= 1; // reduce space at n
        }
        return result;
    }
}