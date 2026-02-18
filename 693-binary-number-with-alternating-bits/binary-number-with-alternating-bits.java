 /**
     * Efficient bitwise check:
     * If bits alternate (1010), n ^ (n >> 1) results in all 1s (1111).
     * We then verify if (allOnes & (allOnes + 1)) == 0.
*/
class Solution {
    public boolean hasAlternatingBits(int n) {
        int allOnes = n ^ (n>>1);
        return (allOnes & (long)(allOnes + 1)) == 0;
    }
}