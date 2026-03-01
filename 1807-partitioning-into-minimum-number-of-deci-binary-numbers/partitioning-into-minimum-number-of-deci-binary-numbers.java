// this problem need tricky observation
// count maximum digit in a string of deci-binary 0 or 1's
class Solution {
    public int minPartitions(String n) {
        int maxDigit=0;
        for(char c: n.toCharArray()){
            maxDigit = Math.max(maxDigit, c-'0');
        }
        return maxDigit;
    }
}