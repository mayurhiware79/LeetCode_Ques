class Solution {
    public int mirrorDistance(int n) {

        int m = n;
        int revN = 0;
        while(m > 0){
            int rem = m % 10;
            revN = revN * 10 + rem;
            m /= 10;
        }
        return Math.abs(n - revN);
    }
}