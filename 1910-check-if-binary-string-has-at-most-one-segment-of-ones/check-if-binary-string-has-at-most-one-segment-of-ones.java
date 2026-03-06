class Solution {
    public boolean checkOnesSegment(String s) {
        //pattern found : If "01" appears, return false if another '1' exists later.
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '1' && s.charAt(i-1) == '0'){
                return false;
            }
        }
        return true;

    }
}