class Solution {
    public String largestGoodInteger(String num) {
        
        for(int d =9; d >= 0; d--){
            String pattern = ""+d+d+d;
            if(num.contains(pattern)){
                return pattern;
            }
        }
        return "";
    }
}