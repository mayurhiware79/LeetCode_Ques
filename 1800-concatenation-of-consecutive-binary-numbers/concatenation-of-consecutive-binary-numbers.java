// This is Bit Manipulation - So Find out the formula
// here formula res = (res << no. of bits in x)+x (x from 1 to n)

class Solution {
    public int concatenatedBinary(int n) {
        int mod = 1000000007;
        long res = 0;
        int bitLength = 0;

        for(int i=1; i<=n; i++){

            if((i & (i-1)) == 0){
                bitLength++;
            }

            res = (res << bitLength) % mod;
            res = (res + i) % mod;

        }
        return (int) res;
    }
}