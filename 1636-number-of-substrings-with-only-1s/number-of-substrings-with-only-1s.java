class Solution {
    public int numSub(String s) {
        //declare mod result count(consec. 1s)
        long mod = 1000000007;
        long result = 0;
        long count =0; 
        //loop and if 1 then count++
        //else apply formulae of possible of substrings add into result
        for(char c : s.toCharArray()){
            if(c == '1') {
                count++;
            }else{
                result += (count * (count + 1))/ 2;
                result %= mod; // given cond for op
                count = 0; //reset
            }
        }
        result += (count * (count + 1))/ 2;
        result %= mod; // given cond for op
        return (int) result;
    }
}