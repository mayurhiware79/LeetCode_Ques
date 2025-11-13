class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        int result =0;
        int i=0;
        int countiSeen =0;

        while(i < n){
            if(s.charAt(i) ==  '0'){
                result += countiSeen;
                while(i<n && s.charAt(i) =='0'){
                    i++;
                }
            }else {
                countiSeen++;
                i++;
            }
        }
        return result;
    }
}