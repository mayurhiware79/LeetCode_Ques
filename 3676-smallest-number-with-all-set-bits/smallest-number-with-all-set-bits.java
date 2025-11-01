class Solution {
    public int smallestNumber(int n) {

        int[] allOnes = {1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047};
        for(int x:allOnes){
            if(x >= n) return x;
        }

        return -1;

        // 1 << k = 2^k
        //1(1) 3(11) 5(111) ===> 2^k - 1 pattern observed
        // int x = 1;
        // while( (1 << x) - 1 < n){
        //     x++;
        // }
        // return (1 << x) -1;
        
    }
}